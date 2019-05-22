package github.nisrulz.mobilevisionapi2readbarcodes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.SurfaceView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SurfaceView cameraView;
    TextView barcodeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cameraView = (SurfaceView) findViewById(R.id.camera_view);
        barcodeInfo = (TextView) findViewById(R.id.code_info);

        MobileVisionHelper.init(this, cameraView, new CodeListener() {
            @Override
            public void onDetected(final String data) {
                barcodeInfo.post(new Runnable() {
                    @Override
                    public void run() {
                        barcodeInfo.setText(data);
                    }
                });
            }
        });

    }

}

