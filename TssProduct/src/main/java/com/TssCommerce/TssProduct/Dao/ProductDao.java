package com.TssCommerce.TssProduct.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDao {
    Long id;
    String productName;
    int quantity;
    Double unitPrice;
}
