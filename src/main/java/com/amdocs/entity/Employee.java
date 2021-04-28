package com.amdocs.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name= "employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @AttributeOverride( name = "first", column = @Column(name = "first_name"))
    @AttributeOverride( name = "middle", column = @Column(name = "middle_name"))
    @AttributeOverride( name = "last", column = @Column(name = "last_name"))
    private Name name;

    @Embedded
    @AttributeOverride( name = "street", column = @Column(name = "street_address"))
    @AttributeOverride( name = "city", column = @Column(name = "city"))
    @AttributeOverride( name = "state", column = @Column(name = "state"))
    @AttributeOverride( name = "zip", column = @Column(name = "zip"))
    private Address address;

    @ElementCollection
    @CollectionTable(
            name = "employees_phone",
            joinColumns = @JoinColumn(name="employees_id")
    )
    @AttributeOverride( name = "number", column = @Column(name = "phone_number"))
    @AttributeOverride( name = "type", column = @Column(name = "phone_type"))
    private List<Phone> phone;

    private String email;

}
