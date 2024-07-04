package com.tracledger.web.controller;

import com.tracledger.api.service.ILedgerService;
import com.tracledger.dsp.entity.WorkEntryEntity;
import com.tracledger.dsp.repository.LedgerDataRepository;
import com.tracledger.web.Utils.APIResponse;
import com.tracledger.web.Utils.APIResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Objects;

import static com.tracledger.web.Utils.APIConstants.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tlm")
public class LedgerController {

    private static final Logger logger = LoggerFactory.getLogger(LedgerController.class);
    @Autowired
    private APIResponseService responseService;

    @Autowired
    private ILedgerService ledgerService;

    @PostMapping(ADD_WORK_ENTRY)
    public APIResponse addWorkEntryToLedger(@RequestBody WorkEntryEntity workEntry){
        logger.debug("addWorkEntryToLedger ::: received request Object :: {} ", workEntry);
        try {
            ledgerService.addWorkEntry(workEntry);
            return responseService.buildAPIResponse(HttpStatus.OK, "record Added to ledger!");
        }catch (InvalidParameterException e){
            logger.error(e.getMessage());
            return responseService.buildAPIResponse(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }catch (Throwable e){
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @Autowired
    private LedgerDataRepository ledgerRepo;
    @GetMapping(CUSTOMER_TRANSACTIONS)
    public APIResponse getCustomerTransactionLedger(@PathVariable String customerName){
        logger.debug("getCustomerTransactionLedger :: customerName : {}",customerName);

        System.out.println(ledgerRepo.getAllEntriesOfCustomer(customerName));

        return responseService.buildAPIResponse(HttpStatus.OK, "Done!");
    }

}
