package com.example.currencyexchangeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurrencyexchangeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyexchangeapiApplication.class, args);
	}

}
