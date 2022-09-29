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

}
