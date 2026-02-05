package weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	public WebClient webClient() {
		return WebClient.builder()
				.defaultHeader("Accept", "application/json")
				.defaultHeader("User-Agent", "BergenHikesWeather/1.0 (186489@stud.hvl.no)")
				.build();
	}
}
