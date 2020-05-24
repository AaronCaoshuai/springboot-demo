package com.aaron;

import com.aaron.generator.Generator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGeneratorApplication.class, args);
        Generator.generator();
    }



}
