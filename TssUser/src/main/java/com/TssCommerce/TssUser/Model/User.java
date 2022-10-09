package com.TssCommerce.TssUser.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private int postalCode;
    private int phoneNumber;
    private String email;
    private String profileImage;
    @OneToMany(mappedBy = "shipmentUser", fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private List<Shipment> shipmentList;

    @OneToMany(mappedBy = "productUser", fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public User(String firstName, String lastName, String password, String address, int postalCode, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(Long id, String firstName, String lastName, String password, String address, int postalCode, int phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
