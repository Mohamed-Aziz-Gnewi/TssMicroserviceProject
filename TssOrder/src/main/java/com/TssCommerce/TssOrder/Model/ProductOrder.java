package com.TssCommerce.TssOrder.Model;


import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Enum.Discount;
import com.TssCommerce.TssOrder.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date dateCreated;
    Status status = Status.PENDING;
    Long userId;

    @OneToMany(mappedBy = "productOrder", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<ProductDao> productDaoList;


    Double totalPrice;
    Discount discount = Discount.REGULAR_DISCOUNT;

    public ProductOrder(Date dateCreated, Status status, Long userId,Double totalPrice, Discount discount) {
        this.dateCreated = dateCreated;
        this.status = status;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }
}
