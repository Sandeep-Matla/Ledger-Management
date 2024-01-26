package com.tracledger.service;

//import com.tracledger.config.AppContext;
import com.tracledger.api.service.ICustomerService;
import com.tracledger.dsp.entity.CustomerEntity;
import com.tracledger.dsp.repository.CustomerRepository;
import com.tracledger.dsp.repository.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private TestService testService ;
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public void addCustomer(CustomerEntity customer){
        testService.test();
        customerRepo.save(customer);
    }
    @Override
    public Iterable<CustomerEntity> getAllCustomerDetails(){
        return customerRepo.findAll();
//        return null;
    }


}
