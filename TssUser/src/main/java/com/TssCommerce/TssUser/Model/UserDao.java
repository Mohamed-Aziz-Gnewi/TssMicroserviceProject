package com.TssCommerce.TssUser.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDao {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private int postalCode;
    private int phoneNumber;
    private String email;
    private String shipmentInfo;

    public UserDao(Long id, String firstName, String lastName, String address, int postalCode, int phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
