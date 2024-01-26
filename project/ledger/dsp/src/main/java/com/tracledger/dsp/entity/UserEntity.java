package com.tracledger.dsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    Integer user_id;
    String user_name;
    String email;
    String password;

}
