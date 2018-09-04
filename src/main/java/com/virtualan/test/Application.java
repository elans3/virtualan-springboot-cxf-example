package com.virtualan.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtualan.test.config.AppConfig;

/**
 * Spring boot and Apache CXF with virtualan
 * 
 * @author Elan Thangamani
 *
 */

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
