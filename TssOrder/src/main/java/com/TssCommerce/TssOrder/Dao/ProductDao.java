package com.TssCommerce.TssOrder.Dao;

import com.TssCommerce.TssOrder.Model.ProductOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String productName;
    int quantity;
    Double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Order_id",nullable = false)
    @JsonIgnore
    ProductOrder productOrder;

    public ProductDao(String productName, int quantity, Double unitPrice, ProductOrder productOrder) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productOrder = productOrder;
    }
}
