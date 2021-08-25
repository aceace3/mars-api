package com.mars.mars_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MarsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsApiApplication.class, args);
    }

}
