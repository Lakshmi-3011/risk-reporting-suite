package com.internship.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.internship.tool.entity")
public class RiskReportingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiskReportingApplication.class, args);
    }
}