package com.TssCommerce.TssOrder.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentInfo {
    private Long id;
    private String companyName;
    private String address;
    private int postalCode;
    private int phoneNumber;
}
