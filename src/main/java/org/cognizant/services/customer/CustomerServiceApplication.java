package org.cognizant.services.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableEurekaClient
//@EnableKafka
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomerServiceApplication.class, args);
	}

}

