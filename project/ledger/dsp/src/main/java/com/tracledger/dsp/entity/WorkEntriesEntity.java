package com.tracledger.dsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "work_entries")
public class WorkEntriesEntity {

    @Id
    Integer entry_id;
    Integer user_id ;
    Integer customer_id;
    Integer instrument_id ;
    Float work_hours;
    Float work_acres;
    Float net_charge ;
    Float amount_paid ;
    Boolean is_paid ;
    Long insert_ts ;
    Long update_ts ;

}
