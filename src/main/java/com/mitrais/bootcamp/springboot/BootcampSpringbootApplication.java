package com.mitrais.bootcamp.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootcampSpringbootApplication {

	Logger logger = LoggerFactory.getLogger(BootcampSpringbootApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BootcampSpringbootApplication.class, args);
	}

	@RequestMapping("hello")
	public String hello() {
		logger.debug("Mencetak Hello");
		return "Hello";
	}
}

