package com.TssCommerce.TssNamingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TssNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TssNamingServerApplication.class, args);
	}

}
