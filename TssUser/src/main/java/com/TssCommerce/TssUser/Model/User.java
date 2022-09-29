package com.TssCommerce.TssUser.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private int postalCode;
    private int phoneNumber;
    private String email;
    private String shipmentInfo;
    private String profileImage;

    public User(String firstName, String lastName, String password, String address, int postalCode, int phoneNumber, String email, String shipmentInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shipmentInfo = shipmentInfo;
    }
}
