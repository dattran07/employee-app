package com.amdocs.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Name implements Serializable {

    private static final long serialVersionUID = 1L;

    private String first;
    private String middle;
    private String last;

}
