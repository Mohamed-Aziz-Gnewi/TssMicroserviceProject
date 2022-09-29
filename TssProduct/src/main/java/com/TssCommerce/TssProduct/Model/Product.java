package com.TssCommerce.TssProduct.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id;
    String productName;
    String productDescription;
    Double unitPrice;
    int quantity;
    //Constructors

    public Product(String productName, String productDescription, Double price, int quantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitPrice = price;
        this.quantity = quantity;
    }
}
