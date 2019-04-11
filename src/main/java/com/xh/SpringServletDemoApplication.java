package com.xh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.xh.servlet.servlet")
public class SpringServletDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServletDemoApplication.class, args);
    }

}
