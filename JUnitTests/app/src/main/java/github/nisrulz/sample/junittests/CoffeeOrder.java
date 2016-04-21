package github.nisrulz.sample.junittests;

public class CoffeeOrder {
    private float mCoffeePrice;
    private int mCoffeeCount;
    private float mTotalPrice;

    public CoffeeOrder(float coffeePrice) {
        mCoffeeCount = 0;
        mTotalPrice = 0;
        this.mCoffeePrice = coffeePrice;
    }

    public void setCoffeeCount(int count) {
        if (count >= 0) {
            this.mCoffeeCount = count;
        }
        calculateTotalPrice();
    }

    public int getCoffeeCount() {
        return mCoffeeCount;
    }

    public void incrementCoffeeCount() {
        mCoffeeCount++;
        calculateTotalPrice();
    }

    public float getTotalPrice() {
        return mTotalPrice;
    }

    public void decrementCoffeeCount() {
        if (mCoffeeCount > 0) {
            mCoffeeCount--;
            calculateTotalPrice();
        }
    }

    private void calculateTotalPrice() {
        mTotalPrice = mCoffeePrice * mCoffeeCount;
    }
}
