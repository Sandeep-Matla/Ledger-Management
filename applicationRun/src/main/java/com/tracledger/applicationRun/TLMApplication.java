package com.tracledger.applicationRun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TLMApplication {

    public static void main(String[] args) {
        SpringApplication.run(TLMApplication.class, args);

        System.out.println("Welcome to TLM :) !!!");
    }

}
