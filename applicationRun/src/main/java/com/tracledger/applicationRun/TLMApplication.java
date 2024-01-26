package com.tracledger.applicationRun;

//import com.tracledger.config.AppContext;
import com.tracledger.dsp.entity.CustomerEntity;
import com.tracledger.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan("com.tracledger.*")
public class TLMApplication {


    @Autowired
    private ApplicationContext ctx;

//    private ApplicationContext AppContext = this.ctx;
    public static void main(String[] args) {

        SpringApplication.run(TLMApplication.class, args);
//        System.out.println("Welcome to TLM :) !!!");
//
//        CustomerService service = context.getBean(CustomerService.class);
//        CustomerEntity cust = new CustomerEntity();
//        cust.setFirst_name("Sandeep");
//        cust.setLast_name("Matla");
//        cust.setMobile(7660957876L);
//        service.addCustomer(cust);
//
//        System.out.println("Customers :: " + service.getAllCustomerDetails());
//        System.out.println("Done!");
    }

}
