package com.tracledger.web.controller;

import com.tracledger.api.service.IInstrumentDataService;
import com.tracledger.dsp.entity.InstrumentEntity;
import com.tracledger.web.Utils.APIResponse;
import com.tracledger.web.Utils.APIResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.Map;

import static com.tracledger.web.Utils.APIConstants.ADD_INSTRUMENT;
import static com.tracledger.web.Utils.APIConstants.UPDATE_INSTRUMENT_PRICE;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tlm")
public class InstrumentMDController {

    private static final Logger logger = LoggerFactory.getLogger(InstrumentMDController.class);
    @Autowired
    private IInstrumentDataService instrumentDataService;
    @Autowired
    private APIResponseService responseService;


    @PostMapping(ADD_INSTRUMENT)
    public APIResponse addInstrument(@RequestBody InstrumentEntity instrumentInfo){
        try {
            logger.info("recieved req :: " + instrumentInfo);
            instrumentDataService.addInstrumentData(instrumentInfo);
            return responseService.buildAPIResponse(HttpStatus.OK, "Instrument Data Added");
        }catch (InvalidParameterException e){
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());

        }catch (Throwable e){
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }
    @PostMapping(UPDATE_INSTRUMENT_PRICE)
    public APIResponse updateInstrumentCharge(@RequestBody Map<String,Object> request){

        String instrumentName = (String) request.get("inst_name");
        String instrumentCode = (String) request.get("inst_code");
        String chargeType = (String) request.get("charge_type");
        Double newPrice = (Double) request.get("new_price");

        logger.info("updateInstrumentCharge ::: recieved request : " + request);
        if(chargeType.isBlank() || newPrice == null || (instrumentName == null && instrumentCode == null)){
            logger.debug("Invalid data to update instrument :: instrument_name={}, price_type={} , new_price={}", instrumentName, chargeType, newPrice );
            return responseService.buildAPIResponse(HttpStatus.BAD_REQUEST, "price_type or new_price can't be null/empty");
        }

        try {
            if(instrumentName != null) {
                instrumentDataService.updateInstrumentCharge(instrumentName, chargeType, newPrice.floatValue());
                return responseService.buildAPIResponse(HttpStatus.OK, chargeType + " price updated for instrument " + instrumentName);
            }
            else {
                instrumentDataService.updateInstrumentChargeByCode(instrumentCode, chargeType, newPrice.floatValue());
                return responseService.buildAPIResponse(HttpStatus.OK, chargeType + " price updated for instrument " + instrumentCode);
            }

        }catch (Throwable e){
            e.printStackTrace();
            return responseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro :: Price can't be updated " + e.getLocalizedMessage());
        }
    }

}
