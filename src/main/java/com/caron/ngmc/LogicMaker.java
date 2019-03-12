package com.caron.ngmc;

public class LogicMaker {


    public String computeOrder(Order order) {
        String beverageCode = order.getBeverage().code;
        String sugar = order.getNbSugars() == 0 ? "" : String.valueOf(order.getNbSugars());
        String stick = order.getNbSugars() > 0 ? String.valueOf(0) : "";

        return String.format("%s:%s:%s", beverageCode, sugar, stick);
    }

}
