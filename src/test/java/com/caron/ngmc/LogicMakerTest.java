package com.caron.ngmc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicMakerTest {

    private LogicMaker logicMaker = new LogicMaker();

    @Test
    public void shouldSendChosenSugarFreeCoffeeBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.COFFEE, 0);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C::", m);
    }

    @Test
    public void shouldSendChosenSugarFreeTeaBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.TEA, 0);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("T::", m);
    }

    @Test
    public void shouldSendChosenSugarFreeChocolateBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.CHOCOLATE, 0);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("H::", m);
    }

    @Test
    public void shouldSendChosenBeverageWithSugarAndAddStickToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C:1:0", m);
    }


}