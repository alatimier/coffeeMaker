package com.caron.ngmc;

public enum Beverage {

    COFFEE("C", 0.6),
    TEA("T", 0.4),
    CHOCOLATE("H", 0.5);

    public String code;
    public double price;

    Beverage(String code, double price) {
        this.code = code;
        this.price = price;
    }

}
