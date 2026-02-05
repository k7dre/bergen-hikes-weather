package weather.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import weather.dto.MountainWeatherResponse;
import weather.dto.NowcastResponse;
import weather.model.Mountain;

@Service
public class WeatherService {

	private final WebClient webClient;

	private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

	public WeatherService(WebClient webClient) {
		this.webClient = webClient;
	}

	@Cacheable("mountainWeather")
	public List<MountainWeatherResponse> getWeatherForAllMountains() {

		List<MountainWeatherResponse> results = new ArrayList<>();

		for (Mountain mountain : Mountain.values()) {
			try {
				
				results.add(callApi(mountain));
				
			} catch (Exception e) { 
				results.add(failedCall(mountain, e));				
			}

		}
		
		
		return results; 
	}
	
	private MountainWeatherResponse callApi(Mountain mountain){
		NowcastResponse response = webClient.get()
				.uri(uriBuilder -> uriBuilder
						.scheme("https")
						.host("api.met.no")
						.path("/weatherapi/nowcast/2.0/complete")
						.queryParam("lat", mountain.getLatitude())
						.queryParam("lon", mountain.getLongitude())
						.build()
						)
				.retrieve()
				.bodyToMono(NowcastResponse.class)
				.block();

		var details = response.getProperties()
				.getTimeseries()
				.get(0)
				.getData()
				.getInstant()
				.getDetails();
		
		log.info("Fetching weather from MET");

		return new MountainWeatherResponse(
				mountain.getDisplayName(),
				details.getAirTemperature(),
				details.getWindSpeed(),
				details.getPrecipitationRate(),
				true
				);
	}
	
	private MountainWeatherResponse failedCall(Mountain mountain, Exception e) {
		log.warn("Failed to fetch data for " + mountain.getDisplayName() + ":" + e.getMessage());
		return new MountainWeatherResponse(
				mountain.getDisplayName(), null, null, null, false);
		
	}
}

