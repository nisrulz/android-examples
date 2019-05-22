package nisrulz.github.sample.usingandroidarchcomponents;

import androidx.lifecycle.ViewModel;

public class ClickCounterViewModel extends ViewModel {
  private int count;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}