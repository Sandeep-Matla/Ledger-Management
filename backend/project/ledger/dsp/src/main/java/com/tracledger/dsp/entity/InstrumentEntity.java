package com.tracledger.dsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "instrument_charges_md")
public class InstrumentEntity {

    String instrument_code;
    @Id
    String instrument_name;
    Float charge_per_hour;
    Float charge_per_acre;

}
