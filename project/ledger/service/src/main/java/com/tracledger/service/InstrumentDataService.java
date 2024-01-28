package com.tracledger.service;

import com.tracledger.api.service.IInstrumentDataService;
import com.tracledger.dsp.entity.InstrumentEntity;
import com.tracledger.dsp.repository.InstrumentDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.security.InvalidParameterException;

@Component
public class InstrumentDataService implements IInstrumentDataService {

    private static final Logger logger = LoggerFactory.getLogger(InstrumentDataService.class);
    private static final String CHARGE_PER_ACRE = "CPA";
    private static final String CHARGE_PER_HOUR = "CPH";


    @Autowired
    private InstrumentDataRepository instrumentDsp;

    @Override
    public void addInstrumentData(InstrumentEntity instrument){
        try {
            validateInstrumentInfo(instrument);
            instrumentDsp.save(instrument);
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            logger.debug("Error :: Unable to add Instrument.");
            throw new RuntimeException("Error :: Unable to add Instrument. constraint violation",e);
        }

    }
    @Override
    public void updateInstrumentCharge(String instName, String chargeType, float newPrice){
        try{
            if(chargeType.equalsIgnoreCase(CHARGE_PER_ACRE)){
                instrumentDsp.updateInstrumentCPA(instName , newPrice);
            } else if (chargeType.equalsIgnoreCase(CHARGE_PER_HOUR)) {
                instrumentDsp.updateInstrumentCPH(instName, newPrice);
            }
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            logger.debug("Error :: Unable to update Instrument charge.");
            throw new RuntimeException("Error :: Unable to update Instrument charge. constraint violation", e );
        }
    }

    @Override
    public void updateInstrumentChargeByCode(String instCode, String chargeType, float newPrice){
        try{
            if(chargeType.equalsIgnoreCase(CHARGE_PER_ACRE)){
                instrumentDsp.updateInstrumentCPAByCode(instCode , newPrice);
            } else if (chargeType.equalsIgnoreCase(CHARGE_PER_HOUR)) {
                instrumentDsp.updateInstrumentCPHByCode(instCode, newPrice);
            }
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            logger.debug("Error :: Unable to update Instrument charge.");
            throw new RuntimeException("Error :: Unable to update Instrument charge. constraint violation", e );
        }
    }

    private void validateInstrumentInfo(InstrumentEntity instrument){
        if(instrument.getInstrument_name() == null){
            throw new InvalidParameterException("Invalid instrument data to insert!!");
        }
        if(instrument.getCharge_per_acre() == null && instrument.getCharge_per_hour() == null){
            throw new InvalidParameterException("Both price information of the instrument are null..");
        }
    }
}
