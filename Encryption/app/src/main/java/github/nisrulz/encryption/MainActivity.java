package github.nisrulz.encryption;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Encryption-Decryption";
    AesCbcWithIntegrity.SecretKeys key;
    private static boolean PASSWORD_BASED_KEY = true;
    private static String EXAMPLE_PASSWORD = "general_password";

    private String TEXT = "Real programmers count from 0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView txt_original = (TextView) findViewById(R.id.txt_original);
        txt_original.setText("Original : \n" + TEXT);

        final TextView txt_encrypted = (TextView) findViewById(R.id.txt_encrypted);
        txt_encrypted.setText("Encrypted : \n" + TEXT);

        final TextView txt_decrypted = (TextView) findViewById(R.id.txt_decrypted);
        txt_decrypted.setText("Decrypted : \n" + TEXT);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (PASSWORD_BASED_KEY) {//example for password based keys
                        String salt = AesCbcWithIntegrity.saltString(AesCbcWithIntegrity.generateSalt());
                        //If you generated the key from a password, you can store the salt and not the key.
                        Log.i(TAG, "Salt: " + salt);
                        key = AesCbcWithIntegrity.generateKeyFromPassword(EXAMPLE_PASSWORD, salt);
                    } else {
                        key = AesCbcWithIntegrity.generateKey();
                        //Note: If you are generating a random key, you'll probably be storing it somewhere
                    }

                    // The encryption / storage & display:

                    String keyStr = AesCbcWithIntegrity.keyString(key);
                    key = null; //Pretend to throw that away so we can demonstrate converting it from str

                    Log.i(TAG, "Before encryption: " + TEXT);

                    // Read from storage & decrypt
                    key = AesCbcWithIntegrity.keys(keyStr); // alternately, regenerate the key from password/salt.
                    AesCbcWithIntegrity.CipherTextIvMac civ = AesCbcWithIntegrity.encrypt(TEXT, key);

                    Log.i(TAG, "Encrypted: " + civ.toString());
                    txt_encrypted.setText("Encrypted : \n" + civ.toString());

                    String decryptedText = AesCbcWithIntegrity.decryptString(civ, key);
                    Log.i(TAG, "Decrypted: " + decryptedText);
                    txt_decrypted.setText("Decrypted : \n" + decryptedText);

                    //Note: "String.equals" is not a constant-time check, which can sometimes be problematic.
                    Log.i(TAG, "Do they equal: " + TEXT.equals(decryptedText));


                    Snackbar.make(view, "Original matches the Decrypted ? " + TEXT.equals
                            (decryptedText), Snackbar.LENGTH_INDEFINITE)
                            .show();

                } catch (GeneralSecurityException e) {
                    Log.e(TAG, "GeneralSecurityException", e);
                } catch (UnsupportedEncodingException e) {
                    Log.e(TAG, "UnsupportedEncodingException", e);
                }
            }
        });
    }

}
