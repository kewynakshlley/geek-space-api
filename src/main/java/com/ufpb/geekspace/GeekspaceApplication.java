package com.ufpb.geekspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaAuditing
public class GeekspaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeekspaceApplication.class, args);
	}

}
