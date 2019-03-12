package com.caron.ngmc;

public class Order {

    private Beverage beverage;
    private int nbSugars;

    public Order(Beverage beverage, int nbSugars) {
        this.beverage = beverage;
        this.nbSugars = nbSugars;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getNbSugars() {
        return nbSugars;
    }

}
