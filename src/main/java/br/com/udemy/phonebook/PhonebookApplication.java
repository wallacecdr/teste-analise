package br.com.udemy.phonebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PhonebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(PhonebookApplication.class);

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			logger.info("Connected to Kafka successfully!");
		};
	}
}
