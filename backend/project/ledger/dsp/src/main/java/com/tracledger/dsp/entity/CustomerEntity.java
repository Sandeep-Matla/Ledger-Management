package com.tracledger.dsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "customer_info")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customer_id;
    String first_name;
    String last_name;
    Long mobile;

    public static List<String> getFullNamesOfCustomers(Iterable<CustomerEntity> customerEntities){
        List<String> fullNames = new ArrayList<>();
        for (CustomerEntity cust : customerEntities){
            fullNames.add(cust.first_name + " " + cust.last_name);
        }
        return fullNames;
    }

}
