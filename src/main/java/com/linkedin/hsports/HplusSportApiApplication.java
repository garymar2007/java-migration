package com.linkedin.hsports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class HplusSportApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HplusSportApiApplication.class, args);
	}

}
