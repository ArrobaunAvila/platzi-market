package com.platzi.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.platzi.market.*"})
@ComponentScan ({"com.server", "com.server.config"})
@EntityScan(basePackages = {"com.platzi.market.*"})
@EnableJpaRepositories(basePackages = {"com.platzi.market.*"})
public class PlatziMarketApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(PlatziMarketApplication.class, args);
	}
    
	
}
