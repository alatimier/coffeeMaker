package com.caron.ngmc;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class LogicMaker {

    private Map<Beverage, Integer> database = new HashMap<>();
    private DecimalFormat df = new DecimalFormat("#.#");


    public String computeOrder(Order order) {
        String beverageCode = order.getBeverage().code;
        String extraHot = order.isExtraHot() && order.getBeverage().canBeHotter ? "h" : "";
        String sugar = order.getNbSugars() == 0 ? "" : String.valueOf(order.getNbSugars());
        String stick = order.getNbSugars() > 0 ? String.valueOf(0) : "";

        if (order.getAmount() < order.getBeverage().price) {
            return String.format("M:Gimme %s€, bitch !", order.getBeverage().price - order.getAmount());
        }


        int currentSell = database.get(order.getBeverage()) == null ? 0 : database.get(order.getBeverage());
        database.put(order.getBeverage(), currentSell + 1);

        return String.format("%s%s:%s:%s", beverageCode, extraHot, sugar, stick);
    }

    public String computeReport() {
        double total = database.entrySet().stream().mapToDouble(e -> e.getKey().price * e.getValue()).sum();
        return String.format(
                "%s:%s,%s:%s,%s:%s,%s:%s => %s€",
                Beverage.COFFEE.code, getNumberOfSells(Beverage.COFFEE),
                Beverage.TEA.code, getNumberOfSells(Beverage.TEA),
                Beverage.CHOCOLATE.code, getNumberOfSells(Beverage.CHOCOLATE),
                Beverage.ORANGE_JUICE.code, getNumberOfSells(Beverage.ORANGE_JUICE),
                df.format(total)
        );
    }

    private int getNumberOfSells(Beverage b) {
        return database.get(b) == null ? 0 : database.get(b);
    }

}
