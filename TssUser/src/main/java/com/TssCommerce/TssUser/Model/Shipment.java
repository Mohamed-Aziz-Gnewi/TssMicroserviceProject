package com.TssCommerce.TssUser.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String address;
    private int postalCode;
    private int phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Shipment_User_Id",nullable= false)
    private User shipmentUser;

    public Shipment(String companyName, String address, int postalCode, int phoneNumber) {
        this.companyName = companyName;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    public Shipment(String companyName, String address, int postalCode, int phoneNumber, User shipmentUser) {
        this.companyName = companyName;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.shipmentUser = shipmentUser;
    }
}
