package weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Details {
	
	@JsonProperty("air_temperature")
	private Double airTemperature;
	
	@JsonProperty("wind_speed")
	private Double windSpeed;
	
	@JsonProperty("precipitation_rate")
	private Double precipitationRate;
	
	public Double getAirTemperature() {
		return airTemperature;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public Double getPrecipitationRate() {
		return precipitationRate;
	}

}
