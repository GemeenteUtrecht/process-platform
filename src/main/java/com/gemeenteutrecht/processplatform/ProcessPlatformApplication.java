package com.gemeenteutrecht.processplatform;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class ProcessPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessPlatformApplication.class, args);
    }

}
