package com.ittalent.csn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan(basePackages = {"com.ittalent.csn"})

public class CsnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsnApplication.class, args);
	}

}
