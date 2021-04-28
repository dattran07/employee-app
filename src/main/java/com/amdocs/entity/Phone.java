package com.amdocs.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int HOME = 0;
    public static final int WORK = 0;
    public static final int MOBILE = 0;

    private String number;
    private Type type;

    public enum Type {
        HOME, WORK, MOBILE
    }

}
