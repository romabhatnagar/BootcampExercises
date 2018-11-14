package com.ttn.springboot.reapdemo.entity;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private User user;
    private String uniqueIdentifier;


}
