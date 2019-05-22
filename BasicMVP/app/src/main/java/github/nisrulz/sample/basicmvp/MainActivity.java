package github.nisrulz.sample.basicmvp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity implements the MvpView interface
 */
public class MainActivity extends AppCompatActivity implements MvpView {

  /**
   * The Main presenter.
   */
  MvpPresenter mvpPresenter;

  /**
   * The Txt userinfo.
   */
  TextView txt_userinfo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Instantiate the main presenter
    mvpPresenter = new MvpPresenter(this);

    // Get references from mvpView
    final EditText edtx_name = (EditText) findViewById(R.id.edtx_name);
    final EditText edtx_email = (EditText) findViewById(R.id.edtx_email);
    txt_userinfo = (TextView) findViewById(R.id.txt_userinfo);
    Button btn_submit = (Button) findViewById(R.id.btn_submit);

    btn_submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        mvpPresenter.updateFullName(edtx_name.getText().toString());

        mvpPresenter.updateEmail(edtx_email.getText().toString());
      }
    });
  }

  @Override
  public void updateUserInfoTextView(String info) {
    txt_userinfo.setText(info);
  }
}
