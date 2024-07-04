package com.tracledger.service;

import com.tracledger.api.service.ILedgerService;
import com.tracledger.dsp.entity.WorkEntryEntity;
import com.tracledger.dsp.repository.LedgerDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.security.InvalidParameterException;

@Service
public class LedgerService implements ILedgerService {

    private static final Logger logger = LoggerFactory.getLogger(LedgerService.class);
    @Autowired
    private LedgerDataRepository ledgerRepository;

    @Override
    public void addWorkEntry(WorkEntryEntity entry){

        try {
            validateEntry(entry);
            entry.setInsert_ts(System.currentTimeMillis());
            ledgerRepository.save(entry);
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            logger.debug("Unable to insert record. Data integrity/constraint violation..");
            throw e;
        }
    }

    public void getLedgerEntriesOfCustomer(int customer){

    }






    private void validateEntry(WorkEntryEntity entry){

        if(entry.getInstrument_code() == null || entry.getInstrument_code().isBlank()){
            throw new InvalidParameterException("Unable insert record!. Invalid instrument code found!!");
        }if(entry.getUser_id() == null){
            throw new InvalidParameterException("Unable insert record!. Invalid User !!");
        }if (entry.getCustomer_id() == null){
            throw new InvalidParameterException("Unable insert record!. Invalid Customer !!");
        }if(entry.getIs_paid() == null){
            throw new InvalidParameterException("Unable insert record!. Payment Information required!!");
        }if(entry.getNet_charge() == null){
            throw new InvalidParameterException("Unable insert record!. Net charge info is required!!");
        }if(entry.getDate() == null){
            throw new InvalidParameterException("Unable insert record!. Date is not mentioned!!");
        }
    }
}
