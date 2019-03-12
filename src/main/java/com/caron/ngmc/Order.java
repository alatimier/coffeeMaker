package com.caron.ngmc;

public class Order {

    private Beverage beverage;
    private int nbSugars;
    private double amount;

    public Order(Beverage beverage, int nbSugars, double amount) {
        this.beverage = beverage;
        this.nbSugars = nbSugars;
        this.amount = amount;
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

}
