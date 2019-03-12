package com.caron.ngmc;

public enum Beverage {

    COFFEE("C"),
    TEA("T"),
    CHOCOLATE("H");

    public String code;

    Beverage(String code) {
        this.code = code;
    }

}
