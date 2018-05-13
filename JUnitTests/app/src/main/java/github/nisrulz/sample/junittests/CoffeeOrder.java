package github.nisrulz.sample.junittests;

public class CoffeeOrder {
    private float coffeePrice;
    private int coffeeCount;
    private float totalPrice;

    public CoffeeOrder(float coffeePrice) {
        coffeeCount = 0;
        totalPrice = 0;
        this.coffeePrice = coffeePrice;
    }

    public void setCoffeeCount(int count) {
        if (count >= 0) {
            this.coffeeCount = count;
        }
        calculateTotalPrice();
    }

    public int getCoffeeCount() {
        return coffeeCount+1;
    }

    public void incrementCoffeeCount() {
        coffeeCount++;
        calculateTotalPrice();
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void decrementCoffeeCount() {
        if (coffeeCount > 0) {
            coffeeCount--;
            calculateTotalPrice();
        }
    }

    private void calculateTotalPrice() {
        totalPrice = coffeePrice * coffeeCount;
    }
}
