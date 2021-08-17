package com.paymentEureka.EurekaForPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaForPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaForPaymentApplication.class, args);
	}

}
