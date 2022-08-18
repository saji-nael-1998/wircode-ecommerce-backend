package com.wircodeteam.ecommercedemo.model;


import com.wircodeteam.ecommercedemo.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class User extends BaseEntity<String> {
    public static enum Type {
        EMPLOYEE, CUSTOMER;
    }

    public static enum AccountStatus {
        ACTIVE, INACTIVE, CLOSED, BANNED
    }

    private String password;
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

}
