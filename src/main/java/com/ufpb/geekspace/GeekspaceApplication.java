package com.ufpb.geekspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ufpb.geekspace.config.AppContext;


@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaAuditing
public class GeekspaceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GeekspaceApplication.class, args);
		AppContext.loadApplicationContext(ctx);
		
	}

}
