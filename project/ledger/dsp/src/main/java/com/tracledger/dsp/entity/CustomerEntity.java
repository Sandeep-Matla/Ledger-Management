package com.tracledger.dsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "customer_info")
public class CustomerEntity {

    @Id
    Integer customer_id;
    String first_name;
    String last_name;
    Long mobile;

}
