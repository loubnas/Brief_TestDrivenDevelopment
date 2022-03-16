package com.example.brief_tdd;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BriefTDDApplication {

    public static void main(String[] args) {
        SpringApplication.run(BriefTDDApplication.class, args);
    }

    @Bean
    public org.modelmapper.ModelMapper modelMapper() {
        return new ModelMapper();
    }
    }



