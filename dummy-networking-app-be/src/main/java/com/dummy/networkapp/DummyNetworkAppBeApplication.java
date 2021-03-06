package com.dummy.networkapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.dummy.networkapp")
@EnableJpaRepositories("com.dummy.networkapp")
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.security.servlet.ApplicationContextRequestMatcher.class
})
public class DummyNetworkAppBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyNetworkAppBeApplication.class, args);
	}

}
