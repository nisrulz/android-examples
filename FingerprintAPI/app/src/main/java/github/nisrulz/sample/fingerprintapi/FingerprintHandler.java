package github.nisrulz.sample.fingerprintapi;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.widget.TextView;

public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

  private Context context;

  // Constructor
  public FingerprintHandler(Context mContext) {
    context = mContext;
  }

  public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
    CancellationSignal cancellationSignal = new CancellationSignal();
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT)
        != PackageManager.PERMISSION_GRANTED) {
      return;
    }
    manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
  }

  @Override
  public void onAuthenticationError(int errMsgId, CharSequence errString) {
    this.update("Fingerprint Authentication error\n" + errString, false);
  }

  @Override
  public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
    this.update("Fingerprint Authentication help\n" + helpString, false);
  }

  @Override
  public void onAuthenticationFailed() {
    this.update("Fingerprint Authentication failed.", false);
  }

  @Override
  public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
    this.update("Fingerprint Authentication succeeded.", true);
  }

  public void update(String e, Boolean success) {
    TextView textView = (TextView) ((Activity) context).findViewById(R.id.errorText);
    textView.setText(e);
    if (success) {
      textView.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
    }
  }
}