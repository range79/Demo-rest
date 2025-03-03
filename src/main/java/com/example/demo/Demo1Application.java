package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
This application made by range79 with spring boot
 */

@SpringBootApplication
@OpenAPIDefinition(info = @Info( title = "Demo-rest", description = "demo applicaton for testing spring",
        version = "2.0.0" ,contact = @Contact(name = "github",url = "https://github.com/range79",email = "darkrange6@gmail.com" )))


public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
