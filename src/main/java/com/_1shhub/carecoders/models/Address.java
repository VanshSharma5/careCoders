package com._1shhub.carecoders.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String houseNo;
    public Address(String houseNo, String street, String city, String state, String pinCode, String region) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.region = region;
    }
    private String street;
    private String city;
    private String state;
    private String pinCode;
    private String region;
}
