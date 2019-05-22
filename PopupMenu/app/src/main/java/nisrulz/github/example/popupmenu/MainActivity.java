package nisrulz.github.example.popupmenu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private Button button1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button1 = (Button) findViewById(R.id.button1);
    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //Creating the instance of PopupMenu
        PopupMenu popup = new PopupMenu(MainActivity.this, button1);
        //Inflating the Popup using xml file
        popup.getMenuInflater()
            .inflate(R.menu.popup_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
          public boolean onMenuItemClick(MenuItem item) {
            Toast.makeText(
                MainActivity.this,
                "You Clicked : " + item.getTitle(),
                Toast.LENGTH_SHORT
            ).show();
            return true;
          }
        });

        popup.show(); //showing popup menu
      }
    }); //closing the setOnClickListener method
  }
}
