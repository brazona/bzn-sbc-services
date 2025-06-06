package br.brazona.bzn_sbc_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BznSbcServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BznSbcServicesApplication.class, args);
	}

}
