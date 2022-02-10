package github.nisrulz.example.fingerprintapi

import android.Manifest
import android.hardware.fingerprint.FingerprintManager
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.widget.TextView
import android.app.Activity
import android.content.Context
import android.os.CancellationSignal
import android.view.View
import androidx.core.content.ContextCompat

class FingerprintHandler     // Constructor
    (private val context: Context) : FingerprintManager.AuthenticationCallback() {
    fun startAuth(manager: FingerprintManager, cryptoObject: FingerprintManager.CryptoObject?) {
        val cancellationSignal = CancellationSignal()
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT)
            != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null)
    }

    override fun onAuthenticationError(errMsgId: Int, errString: CharSequence) {
        update("Fingerprint Authentication error\n$errString", false)
    }

    override fun onAuthenticationHelp(helpMsgId: Int, helpString: CharSequence) {
        update("Fingerprint Authentication help\n$helpString", false)
    }

    override fun onAuthenticationFailed() {
        update("Fingerprint Authentication failed.", false)
    }

    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult) {
        update("Fingerprint Authentication succeeded.", true)
    }

    fun update(e: String?, success: Boolean) {
        val textView = (context as Activity).findViewById<View>(R.id.errorText) as TextView
        textView.text = e
        if (success) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
        }
    }
}