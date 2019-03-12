package com.caron.ngmc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicMakerTest {

    private LogicMaker logicMaker = new LogicMaker();

    @Test
    public void shouldSendChosenSugarFreeCoffeeBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.COFFEE, 0, 0.6, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C::", m);
    }

    @Test
    public void shouldSendChosenSugarFreeTeaBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.TEA, 0, 0.4, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("T::", m);
    }

    @Test
    public void shouldSendChosenSugarFreeChocolateBeverageToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.CHOCOLATE, 0, 0.5, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("H::", m);
    }

    @Test
    public void shouldSendChosenBeverageWithSugarAndAddStickToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1, 0.6, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C:1:0", m);
    }

    @Test
    public void shouldClaimFortyCentsForCoffeeIfClientDidNotPay() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1, 0d, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("M:Gimme 0.6€, bitch !", m);
    }

    @Test
    public void shouldClaimRemainingAmountForCoffeeIfClientDidNotPayEnough() {
        // Given
        Order order = new Order(Beverage.COFFEE, 1, 0.3, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("M:Gimme 0.3€, bitch !", m);
    }

    @Test
    public void shouldSendChosenSugarFreeCoffeeBeverageToDrinkMakerEvenIfClientMakeMoreThanAsked() {
        // Given
        Order order = new Order(Beverage.COFFEE, 0, 0.9, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("C::", m);
    }

    @Test
    public void shouldApplyExtraHotBeverageToDrinkMakerIfAsked() {
        // Given
        Order order = new Order(Beverage.COFFEE, 0, 0.9, true);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("Ch::", m);
    }

    @Test
    public void shouldSendSugarFreeOrangeJuiceToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.ORANGE_JUICE, 0, 0.9, false);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("O::", m);
    }

    @Test
    public void shouldNotBeAbleToAskHotOrangeJuiceToDrinkMaker() {
        // Given
        Order order = new Order(Beverage.ORANGE_JUICE, 0, 0.9, true);

        //When
        String m = logicMaker.computeOrder(order);

        // Then
        assertEquals("O::", m);
    }

    @Test
    public void shouldGenerateReport() {
        // Given
        logicMaker.computeOrder(new Order(Beverage.ORANGE_JUICE, 0, 0.9, true));
        logicMaker.computeOrder(new Order(Beverage.ORANGE_JUICE, 0, 0.9, true));
        logicMaker.computeOrder(new Order(Beverage.COFFEE, 0, 0.9, true));
        logicMaker.computeOrder(new Order(Beverage.TEA, 0, 0.9, true));

        // When
        String report = logicMaker.computeReport();

        // Then
        assertEquals("C:1,T:1,H:0,O:2 => 2,2€", report);
    }

}