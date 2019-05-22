package github.nisrulz.sample.junittests;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String COFFEE_COUNT = "coffee_count";
    public final static float DEFAULT_COFFEE_PRICE = 5.0f;
    private TextView mCoffeePrice;
    private TextView mTotalPrice;
    private TextView mCoffeeCount;
    private CoffeeOrder mOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoffeePrice = (TextView) findViewById(R.id.coffee_price);
        mTotalPrice = (TextView) findViewById(R.id.total_price);
        mCoffeeCount = (TextView) findViewById(R.id.coffee_count);
        mCoffeePrice.setText(String.format(getString(R.string.coffee_price), DEFAULT_COFFEE_PRICE));
        mTotalPrice.setText(String.format(getString(R.string.total_price), 0.0f));
        findViewById(R.id.coffee_increment).setOnClickListener(this);
        findViewById(R.id.coffee_decrement).setOnClickListener(this);
        mOrder = new CoffeeOrder(DEFAULT_COFFEE_PRICE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coffee_increment:
                mOrder.incrementCoffeeCount();
                updateCoffeeCount();
                updateTotalPrice();
                break;
            case R.id.coffee_decrement:
                mOrder.decrementCoffeeCount();
                updateCoffeeCount();
                updateTotalPrice();
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COFFEE_COUNT, mOrder.getCoffeeCount());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            mOrder.setCoffeeCount(savedInstanceState.getInt(COFFEE_COUNT));
            updateCoffeeCount();
            updateTotalPrice();
        }
    }

    private void updateCoffeeCount() {
        mCoffeeCount.setText(String.valueOf(mOrder.getCoffeeCount()));
    }

    private void updateTotalPrice() {
        mTotalPrice.setText(String.format(getString(R.string.total_price), mOrder.getTotalPrice()));
    }
}