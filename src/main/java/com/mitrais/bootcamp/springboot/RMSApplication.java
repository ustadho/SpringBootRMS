package com.mitrais.bootcamp.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class RMSApplication {

	Logger logger = LoggerFactory.getLogger(RMSApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RMSApplication.class, args);
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}
	@GetMapping("/403")
	public String error403(){
		return "/error/403";
	}
}

