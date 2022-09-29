package com.TssCommerce.TssOrder.Enum;

public enum Discount {
    REGULAR_DISCOUNT(0.07),
    INTERMEDIATE_DISCOUNT(0.1),
    SPECIAL_DISCOUNT(0.2);

    public final double discountValue;
    Discount(double v) {
        this.discountValue=v;
    }
    public double getDiscountValue(){return this.discountValue;}
}
