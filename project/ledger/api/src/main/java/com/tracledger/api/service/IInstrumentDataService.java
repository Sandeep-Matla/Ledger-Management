package com.tracledger.api.service;

import com.tracledger.dsp.entity.InstrumentEntity;

public interface IInstrumentDataService {
    void addInstrumentData(InstrumentEntity instrument);

    void updateInstrumentCharge(String instName, String chargeType, float newPrice);

    void updateInstrumentChargeByCode(String instCode, String chargeType, float newPrice);
}
