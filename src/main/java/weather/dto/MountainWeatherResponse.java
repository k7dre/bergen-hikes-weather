package weather.dto;

public class MountainWeatherResponse {
	
	private final String mountain;
	private final Double temperature;
	private final Double windSpeed;
	private final Double precipitation;
	private final boolean success; 
	
	public MountainWeatherResponse(
			String mountain,
			Double temperature,
			Double windSpeed,
			Double precipitation, Boolean success) {
		this.mountain = mountain;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.precipitation = precipitation;
		this.success = success;
	}

	public String getMountain() {
		return mountain;
	}

	public Double getTemperature() {
		return temperature;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public Double getPrecipitation() {
		return precipitation;
	}
	
	public boolean getSuccess() {
		return success;
	}

}
