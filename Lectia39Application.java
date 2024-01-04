package com.example.lectia39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lectia39Application  {
    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(Lectia39Application.class, args);
    }


}
