package com.tracledger.dsp.repository;

import com.tracledger.dsp.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;

@Repository
public interface InstrumentDataRepository extends CrudRepository<InstrumentEntity, String> {

    @Transactional
    @Modifying
    @Query("update InstrumentEntity ins set ins.charge_per_hour = ?2 where ins.instrument_name = ?1")
    public void updateInstrumentCPH(String instrumentName , float newPrice);

    @Transactional
    @Modifying
    @Query("update InstrumentEntity ins set ins.charge_per_acre = ?2 where ins.instrument_name = ?1")
    public void updateInstrumentCPA(String instrumentName,float newPrice);

    @Transactional
    @Modifying
    @Query("update InstrumentEntity ins set ins.charge_per_hour = ?2 where ins.instrument_code = ?1")
    public void updateInstrumentCPHByCode(String instrumentCode , float newPrice);

    @Transactional
    @Modifying
    @Query("update InstrumentEntity ins set ins.charge_per_acre = ?2 where ins.instrument_code = ?1")
    public void updateInstrumentCPAByCode(String instrumentCode,float newPrice);

}
