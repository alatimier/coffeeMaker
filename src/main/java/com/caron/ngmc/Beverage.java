package com.caron.ngmc;

public enum Beverage {

    COFFEE("C", 0.6, true),
    TEA("T", 0.4, true),
    CHOCOLATE("H", 0.5, true),
    ORANGE_JUICE("O", 0.6, false);

    public String code;
    public double price;
    public boolean canBeHotter;

    Beverage(String code, double price, boolean canBeHotter) {
        this.code = code;
        this.price = price;
        this.canBeHotter = canBeHotter;
    }

}
