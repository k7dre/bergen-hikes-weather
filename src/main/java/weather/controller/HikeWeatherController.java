package weather.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import weather.dto.MountainWeatherResponse;
import weather.service.WeatherService;

@CrossOrigin(
		origins = "https://bergen-hikes-weather-1.onrender.com"
)

@RestController
public class HikeWeatherController {
	
	WeatherService service;
	
	public HikeWeatherController(WeatherService service) {
		this.service = service;
	}

	@GetMapping("/hikes/weather") 
	public List<MountainWeatherResponse>  weather() {
		return service.getWeatherForAllMountains();
	}
}
