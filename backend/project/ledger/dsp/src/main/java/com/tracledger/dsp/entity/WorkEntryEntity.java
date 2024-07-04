package com.tracledger.dsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "work_entries")
@SecondaryTable(name = "customer_info", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customer_id"))

public class WorkEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer entry_id;
    Integer user_id ;
    Integer customer_id;
    Date date;
    String instrument_code ;
    Float work_hours;
    Float work_acres;
    Float net_charge ;
    Float amount_paid ;
    Boolean is_paid ;
    Long insert_ts ;
    Long update_ts ;

}
