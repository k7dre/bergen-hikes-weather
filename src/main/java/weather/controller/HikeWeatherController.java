package weather.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import weather.dto.MountainWeatherResponse;
import weather.service.WeatherService;

@CrossOrigin(origins = "*")

@RestController
public class HikeWeatherController {
	
	WeatherService service;
	
	public HikeWeatherController(WeatherService service) {
		this.service = service;
		System.out.println(">>> HikeWeatherController constructed");
	}

	@GetMapping("/hikes/weather") 
	public List<MountainWeatherResponse>  weather() {
		return service.getWeatherForAllMountains();
	}
}
