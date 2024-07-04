package com.tracledger.service;

//import com.tracledger.config.AppContext;
import com.tracledger.api.service.ICustomerService;
import com.tracledger.dsp.Exceptions.DSPExceptionHandler;
import com.tracledger.dsp.entity.CustomerEntity;
import com.tracledger.dsp.repository.CustomerRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public void addCustomer(CustomerEntity customer) throws Throwable {
        try {

            customerRepo.save(customer);
        }catch ( DataIntegrityViolationException | ConstraintViolationException  e){
            logger.debug("ERROR :: Unable to add customer. Customer Already exists");
            throw new RuntimeException("ERROR :: Unable to add customer. Customer Already exists" , e);
        }
    }
    @Override
    public Iterable<CustomerEntity> getAllCustomerDetails(){
        return customerRepo.findAll();
    }


}
