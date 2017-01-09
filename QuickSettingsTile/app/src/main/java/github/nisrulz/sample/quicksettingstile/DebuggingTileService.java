package github.nisrulz.sample.quicksettingstile;

import android.content.Intent;
import android.provider.Settings;
import android.service.quicksettings.TileService;

public class DebuggingTileService extends TileService {
  @Override
  public void onDestroy() {
    super.onDestroy();
  }

  @Override
  public void onTileAdded() {
    super.onTileAdded();
  }

  @Override
  public void onTileRemoved() {
    super.onTileRemoved();
  }

  @Override
  public void onStartListening() {
    super.onStartListening();
  }

  @Override
  public void onStopListening() {
    super.onStopListening();
  }

  @Override
  public void onClick() {
    super.onClick();
    //Open the Developer Options Settings Page
    startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS), null);
  }
}
