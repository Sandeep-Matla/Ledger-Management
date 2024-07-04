package com.tracledger.web.controller;

import com.tracledger.api.service.ICustomerService;
import com.tracledger.api.service.IInstrumentDataService;
import com.tracledger.dsp.entity.CustomerEntity;
import com.tracledger.web.Utils.APIResponse;
import com.tracledger.web.Utils.APIResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tracledger.web.Utils.APIConstants.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tlm")
public class CustomerDataController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDataController.class);

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private APIResponseService responseService;
    @GetMapping(TEST_GET_API)
    public APIResponse testGetApi() {
        logger.info("GET request received for testGetApi");

        return responseService.buildAPIResponse(HttpStatus.OK, "testGetApi is working successfully!");
    }

    @PostMapping(ADD_CUSTOMER)
    public APIResponse addCustomer(@RequestBody CustomerEntity customer) {
        //validate cust data
        try {
            customerService.addCustomer(customer);
            return responseService.buildAPIResponse(HttpStatus.OK, "Customer details Added");
        } catch (Throwable e) {
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping(GET_ALL_CUSTOMERS_DEATAILS)
    public APIResponse getAllCustomers(){
        try{
            Iterable<CustomerEntity> customers = customerService.getAllCustomerDetails();

            return responseService.buildAPIResponse(HttpStatus.OK,
                    customers);
        }catch (Throwable e){
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping(GET_ALL_CUSTOMERS_NAMES)
    public APIResponse getAllCustomerFullNames(){
        try{
            Iterable<CustomerEntity> customers = customerService.getAllCustomerDetails();
            List<String> fullNames = CustomerEntity.getFullNamesOfCustomers(customers);
            return responseService.buildAPIResponse(HttpStatus.OK,
                    fullNames);
        }catch (Throwable e){
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }
}
