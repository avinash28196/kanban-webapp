package com.kanbanBoard.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@ComponentScan(basePackages = "com.kanbanBoard.demo")
@EnableAutoConfiguration
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:auth0.properties.example")
})

public class KanbanWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanbanWebappApplication.class, args);
	}

}
