package com.br.joel.Project.Ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ProjectWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWsApplication.class, args);
	}

}
