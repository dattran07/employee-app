package com.amdocs.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String state;
    private String zip;

}
