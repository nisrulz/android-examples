package github.nisrulz.sample.junittests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CoffeeOrderTest {

    private final static float PRICE_TEST = 5.0f;
    private CoffeeOrder mCoffeeOrder;

    @Before
    public void setUp() throws Exception {
        mCoffeeOrder = new CoffeeOrder(PRICE_TEST);

    }

    @Test
    public void orderIsNotNull() {
        assertNotNull(mCoffeeOrder);
    }

    @Test
    public void orderDecrement() {
        mCoffeeOrder.decrementCoffeeCount();
        assertEquals(0, mCoffeeOrder.getCoffeeCount());

        mCoffeeOrder.setCoffeeCount(25);
        mCoffeeOrder.decrementCoffeeCount();
        assertEquals(24, mCoffeeOrder.getCoffeeCount());
    }


    @Test
    public void orderIncrement() {
        mCoffeeOrder.incrementCoffeeCount();
        assertEquals(1, mCoffeeOrder.getCoffeeCount());

        mCoffeeOrder.setCoffeeCount(25);
        mCoffeeOrder.incrementCoffeeCount();
        assertEquals(26, mCoffeeOrder.getCoffeeCount());
    }

    @Test
    public void orderTotalPrice() {
        assertEquals(0.0, mCoffeeOrder.getTotalPrice(),0.0f);

        mCoffeeOrder.setCoffeeCount(25);
        assertEquals(PRICE_TEST * 25, mCoffeeOrder.getTotalPrice(),0.0f);
    }

    @Test
    public void orderSetCoffeeCount() {
        mCoffeeOrder.setCoffeeCount(-1);
        assertEquals(0, mCoffeeOrder.getCoffeeCount());
        mCoffeeOrder.setCoffeeCount(25);
        assertEquals(25, mCoffeeOrder.getCoffeeCount());
    }

}