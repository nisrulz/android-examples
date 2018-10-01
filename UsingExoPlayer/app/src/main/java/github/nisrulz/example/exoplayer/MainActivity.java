package github.nisrulz.example.exoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

// Contributed by Sergio Morales (@Fireblend)

public class MainActivity extends AppCompatActivity implements Player.EventListener {

    private Button button;
    private TextureView surface;

    private SimpleExoPlayer mExoPlayer;
    private ExtractorMediaSource mMediaSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        surface = findViewById(R.id.surface);

        setup();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mExoPlayer.getPlayWhenReady()) {
                    mExoPlayer.setPlayWhenReady(false);
                    button.setText("Resume");
                } else {
                    mExoPlayer.setPlayWhenReady(true);
                    button.setText("Pause");
                }
            }
        });
    }

    private void setup() {
        String url = "http://techslides.com/demos/sample-videos/small.mp4";

        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        TrackSelection.Factory trackSelectionFactory = new AdaptiveTrackSelection.Factory();
        TrackSelector trackSelector = new DefaultTrackSelector(trackSelectionFactory);

        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "mediaPlayerExample"), defaultBandwidthMeter);

        mMediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).setExtractorsFactory(extractorsFactory).createMediaSource(Uri.parse(url));

        mExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        mExoPlayer.setVideoTextureView(surface);

        mExoPlayer.addListener(this);

        mExoPlayer.prepare(mMediaSource);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        if (playbackState == Player.STATE_READY) {
            button.setEnabled(true);
            button.setText("Play");
        } else if (playbackState == Player.STATE_ENDED) {
            mExoPlayer.setPlayWhenReady(false);
            button.setText("Setting Up...");
            button.setEnabled(false);

            mExoPlayer.prepare(mMediaSource);
        }
    }
}
