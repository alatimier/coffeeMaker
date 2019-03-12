package com.caron.ngmc;

public class Order {

    private Beverage beverage;
    private int nbSugars;
    private double amount;
    private boolean extraHot;

    public Order(Beverage beverage, int nbSugars, double amount, boolean extraHot) {
        this.beverage = beverage;
        this.nbSugars = nbSugars;
        this.amount = amount;
        this.extraHot = extraHot;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getNbSugars() {
        return nbSugars;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isExtraHot() {
        return extraHot;
    }
}
