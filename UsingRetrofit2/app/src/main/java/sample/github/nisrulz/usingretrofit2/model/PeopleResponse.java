package sample.github.nisrulz.usingretrofit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class PeopleResponse {

  @SerializedName("count") @Expose private int count;
  @SerializedName("next") @Expose private String next;
  @SerializedName("previous") @Expose private Object previous;
  @SerializedName("results") @Expose private List<People> peoples = new ArrayList<People>();

  /**
   * @return The count
   */
  public int getCount() {
    return count;
  }

  /**
   * @param count The count
   */
  public void setCount(int count) {
    this.count = count;
  }

  /**
   * @return The next
   */
  public String getNext() {
    return next;
  }

  /**
   * @param next The next
   */
  public void setNext(String next) {
    this.next = next;
  }

  /**
   * @return The previous
   */
  public Object getPrevious() {
    return previous;
  }

  /**
   * @param previous The previous
   */
  public void setPrevious(Object previous) {
    this.previous = previous;
  }

  /**
   * @return The peoples
   */
  public List<People> getPeoples() {
    return peoples;
  }

  /**
   * @param peoples The results
   */
  public void setPeoples(List<People> peoples) {
    this.peoples = peoples;
  }
}