package br.brazona.brz_sbc_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BrzSbcServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrzSbcServicesApplication.class, args);
	}

}
