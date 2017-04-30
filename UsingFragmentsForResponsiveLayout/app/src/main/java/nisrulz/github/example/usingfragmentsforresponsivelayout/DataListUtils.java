package nisrulz.github.example.usingfragmentsforresponsivelayout;

import java.util.ArrayList;

public class DataListUtils {

  private static final ArrayList<String> datalist = new ArrayList<String>() {{
    add("Apples");
    add("Oranges");
    add("Peaches");
  }};

  public static ArrayList<String> getDatalist() {
    return datalist;
  }
}
