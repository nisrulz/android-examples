package github.nisrulz.sample.usingsugarorm;

import com.orm.SugarRecord;

public class Book extends SugarRecord {
  String title;
  String edition;

  public Book() {
  }

  public Book(String title, String edition) {
    this.title = title;
    this.edition = edition;
  }
}