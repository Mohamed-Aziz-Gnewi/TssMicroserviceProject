package com.TssCommerce.TssOrder.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippedInfo implements Serializable {


    String name;
    String companyName;
    String Address;
    int postalCode;
    int phoneNumber;

}
