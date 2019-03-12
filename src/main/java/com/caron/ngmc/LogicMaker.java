package com.caron.ngmc;

import java.util.HashMap;
import java.util.Map;

class LogicMaker {

    private Map<Beverage, Integer> database = new HashMap<>();

    String computeOrder(Order order) {
        String beverageCode = order.getBeverage().code;
        String extraHot = order.isExtraHot() && order.getBeverage().canBeHotter ? "h" : "";
        String sugar = order.getNbSugars() == 0 ? "" : String.valueOf(order.getNbSugars());
        String stick = order.getNbSugars() > 0 ? String.valueOf(0) : "";

        if (order.getAmount() < order.getBeverage().price) {
            return String.format("M:Gimme %s€, bitch !", order.getBeverage().price - order.getAmount());
        }

        database.merge(order.getBeverage(), 1, Integer::sum);
        return String.format("%s%s:%s:%s", beverageCode, extraHot, sugar, stick);
    }

    String computeReport() {
        double total = database.entrySet().stream().mapToDouble(e -> e.getKey().price * e.getValue()).sum();
        return String.format(
                "%s:%s,%s:%s,%s:%s,%s:%s => %s€",
                Beverage.COFFEE.code, database.getOrDefault(Beverage.COFFEE, 0),
                Beverage.TEA.code, database.getOrDefault(Beverage.TEA, 0),
                Beverage.CHOCOLATE.code, database.getOrDefault(Beverage.CHOCOLATE, 0),
                Beverage.ORANGE_JUICE.code, database.getOrDefault(Beverage.ORANGE_JUICE, 0),
                Math.round(total * 10) / 10.0
        );
    }

}
