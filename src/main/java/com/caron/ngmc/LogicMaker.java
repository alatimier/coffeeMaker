package com.caron.ngmc;

public class LogicMaker {


    public String computeOrder(Order order) {
        String beverageCode = order.getBeverage().code;
        String extraHot = order.isExtraHot() && order.getBeverage().canBeHotter ? "h" : "";
        String sugar = order.getNbSugars() == 0 ? "" : String.valueOf(order.getNbSugars());
        String stick = order.getNbSugars() > 0 ? String.valueOf(0) : "";

        if (order.getAmount() < order.getBeverage().price) {
            return String.format("M:Gimme %s€, bitch !", order.getBeverage().price - order.getAmount());
        }

        return String.format("%s%s:%s:%s", beverageCode, extraHot, sugar, stick);
    }

}
