package com.wircodeteam.ecommercedemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@Data
public class Employee extends User {
    public static enum Role{
        ADMIN;
    }
    @Enumerated
    private Role role;

}
