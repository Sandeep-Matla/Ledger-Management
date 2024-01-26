package com.tracledger.dsp.repository;

import com.tracledger.dsp.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class TestService{
    public void test(){

        System.out.println("Test !!!!!");
    }

    public CustomerEntity getCustomerEntityByFirst_name(String first_name) {
        return null;
    }
}
