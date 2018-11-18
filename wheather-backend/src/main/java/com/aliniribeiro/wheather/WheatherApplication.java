package com.aliniribeiro.wheather;

import com.aliniribeiro.wheather.api.controller.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WheatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WheatherApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CityService cityService) {
		return args -> {
			cityService.loadCities();
		};
	}

}
