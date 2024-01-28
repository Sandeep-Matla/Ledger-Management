package com.tracledger.applicationRun;

//import com.tracledger.config.AppContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.tracledger.dsp"})
@EnableJpaRepositories(basePackages = {"com.tracledger.dsp"})
@SpringBootApplication(scanBasePackages = {"com.tracledger.*", "com.tracledger.web.controller"})
@ComponentScan(basePackages = {"com.tracledger"})
public class TLMApplication {


    @Autowired
    private ApplicationContext ctx;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TLMApplication.class, args);
        System.out.println("Welcome to TLM :) !!!");

    }

}
