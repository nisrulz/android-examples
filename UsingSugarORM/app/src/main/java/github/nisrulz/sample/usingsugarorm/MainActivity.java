package github.nisrulz.sample.usingsugarorm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

  Book book;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Save
    book = new Book("Title here", "2nd edition");
    book.save();
    logdata("Saved : " + book.title + "," + book.edition);

    // Load
    book = Book.findById(Book.class, 1);
    logdata("Load : " + book.title + "," + book.edition);

    //Update
    book = Book.findById(Book.class, 1);
    book.title = "updated title here"; // modify the values
    book.edition = "3rd edition";
    book.save(); // updates the previous entry with new values.

    logdata("Updated : " + book.title + "," + book.edition);

    //Delete
    book = Book.findById(Book.class, 1);
    book.delete();
    logdata("Deleted! Value now : " + book);
  }

  private void logdata(String s) {
    Log.d("UsingSugar ORM", s + "\n");
  }
}