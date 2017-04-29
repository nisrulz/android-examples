package nisrulz.github.example.usingfragmentsforresponsivelayout;

import java.util.ArrayList;

public class DataListUtils {

  static ArrayList<String> datalist;

  public DataListUtils() {
    datalist = new ArrayList<>();
    datalist.add("Apples");
    datalist.add("Oranges");
    datalist.add("Peaches");
  }

  public static ArrayList<String> getDatalist() {
    return datalist;
  }
}
