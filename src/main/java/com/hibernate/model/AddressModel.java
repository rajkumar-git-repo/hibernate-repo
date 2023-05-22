package com.hibernate.model;

import com.hibernate.entity.Address;

public class AddressModel {

    public static Address getAddress(){

        return Address.builder()
                .city("Noida")
                .country("India")
                .build();
    }
}
