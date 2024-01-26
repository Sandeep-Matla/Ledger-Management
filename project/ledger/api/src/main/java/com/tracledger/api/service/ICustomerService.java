package com.tracledger.api.service;

import com.tracledger.dsp.entity.CustomerEntity;

public interface ICustomerService {
    void addCustomer(CustomerEntity customer);
    Iterable<CustomerEntity> getAllCustomerDetails();
}
