package com.caron.ngmc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicMakerTest {

    private LogicMaker logicMaker = new LogicMaker();

    @Test
    public void shouldSendChosenSugarFreeCoffeeBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.COFFEE, 0, 0.6);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C::", m);
    }

    @Test
    public void shouldSendChosenSugarFreeTeaBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.TEA, 0, 0.4);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("T::", m);
    }

    @Test
    public void shouldSendChosenSugarFreeChocolateBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.CHOCOLATE, 0, 0.5);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("H::", m);
    }

    @Test
    public void shouldSendChosenBeverageWithSugarAndAddStickToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1, 0.6);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C:1:0", m);
    }

    @Test
    public void shouldClaimFortyCentsForCoffeeIfClientDidNotPay() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1, 0d);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("M:Gimme 0.6€, bitch !", m);
    }

    @Test
    public void shouldClaimRemainingAmountForCoffeeIfClientDidNotPayEnough() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1, 0.3);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("M:Gimme 0.3€, bitch !", m);
    }

    @Test
    public void shouldSendChosenSugarFreeCoffeeBeverageToDrinkMakerEvenIfClientMakeMoreThanAsked() {
        // Given
        Order order = new Order(Beverage.COFFEE, 0, 0.9);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C::", m);
    }

}