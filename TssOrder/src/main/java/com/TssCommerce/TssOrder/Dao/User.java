package com.TssCommerce.TssOrder.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private int postalCode;
    private int phoneNumber;
    private String email;
}
