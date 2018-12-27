package com.razorpay.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@SpringBootApplication
@EnableBatchProcessing
@EnableAsync
public class BatchApplication {
	public static void main(String[] args) {

		log.debug("========starting app =========");
		SpringApplication.run(BatchApplication.class, args);
	}
}

