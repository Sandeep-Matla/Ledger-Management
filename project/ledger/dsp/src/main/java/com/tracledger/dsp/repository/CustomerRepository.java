package com.tracledger.dsp.repository;

import com.tracledger.dsp.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    @Query(value = "select s from CustomerEntity s where s.first_name = ?1")
    CustomerEntity getCustomerEntityByFirst_name(String first_name);
}
