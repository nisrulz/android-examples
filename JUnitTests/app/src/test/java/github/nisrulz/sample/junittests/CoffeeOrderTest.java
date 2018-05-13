package github.nisrulz.sample.junittests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CoffeeOrderTest {

    private final static float PRICE_TEST = 5.0f;
    private CoffeeOrder coffeeOrder;

    @Before
    public void setUp() throws Exception {
        coffeeOrder = new CoffeeOrder(PRICE_TEST);

    }


    @Test
    public void newTest(){
        // Do nothing
        assertEquals(1,8);
    }

    @Test
    public void orderIsNotNull() {
        assertNotNull(coffeeOrder);
    }

    @Test
    public void orderDecrement() {
        coffeeOrder.decrementCoffeeCount();
        assertEquals(0, coffeeOrder.getCoffeeCount());

        coffeeOrder.setCoffeeCount(25);
        coffeeOrder.decrementCoffeeCount();
        assertEquals(24, coffeeOrder.getCoffeeCount());
    }


    @Test
    public void orderIncrement() {
        coffeeOrder.incrementCoffeeCount();
        assertEquals(1, coffeeOrder.getCoffeeCount());

        coffeeOrder.setCoffeeCount(25);
        coffeeOrder.incrementCoffeeCount();
        assertEquals(26, coffeeOrder.getCoffeeCount());
    }

    @Test
    public void orderTotalPrice() {
        assertEquals(0.0, coffeeOrder.getTotalPrice(),0.0f);

        coffeeOrder.setCoffeeCount(25);
        assertEquals(PRICE_TEST * 25, coffeeOrder.getTotalPrice(),0.0f);
    }

    @Test
    public void orderSetCoffeeCount() {
        coffeeOrder.setCoffeeCount(-1);
        assertEquals(0, coffeeOrder.getCoffeeCount());
        coffeeOrder.setCoffeeCount(25);
        assertEquals(25, coffeeOrder.getCoffeeCount());
    }

}