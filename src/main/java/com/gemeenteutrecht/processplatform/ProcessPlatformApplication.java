package com.gemeenteutrecht.processplatform;

import com.gemeenteutrecht.processplatform.config.NlxEndpointProperties;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableProcessApplication
@EnableConfigurationProperties(value = {NlxEndpointProperties.class})
public class ProcessPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessPlatformApplication.class, args);
    }

}
