package com.tracledger.dsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "instrument_charges_md")
public class InstrumentInfoEntity {

    @Id
    Integer instrument_id;
    String instrument_name;
    Float charge_per_hour;
    Float charge_per_acre;

}
