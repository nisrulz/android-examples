package github.nisrulz.sample.gesturedetection;

import android.os.Bundle;
import androidx.core.view.GestureDetectorCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

  //gesture detector
  private GestureDetectorCompat gDetect;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gDetect = new GestureDetectorCompat(this, new GestureListener());
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    gDetect.onTouchEvent(event);
    return super.onTouchEvent(event);
  }

  public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    private float flingMin = 100;
    private float velocityMin = 100;

    //user will move forward through messages on fling up or left
    boolean forward = false;
    //user will move backward through messages on fling down or right
    boolean backward = false;

    @Override public boolean onDoubleTap(MotionEvent e) {
      System.out.println("On Double Tap");
      return super.onDoubleTap(e);
    }

    @Override public boolean onDown(MotionEvent e) {
      System.out.println("On Down");
      return super.onDown(e);
    }

    @Override public void onLongPress(MotionEvent e) {
      System.out.println("On Long Press");
      super.onLongPress(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

      //calculate the change in X position within the fling gesture
      float horizontalDiff = e2.getX() - e1.getX();
      //calculate the change in Y position within the fling gesture
      float verticalDiff = e2.getY() - e1.getY();

      float absHDiff = Math.abs(horizontalDiff);
      float absVDiff = Math.abs(verticalDiff);
      float absVelocityX = Math.abs(velocityX);
      float absVelocityY = Math.abs(velocityY);

      if (absHDiff > absVDiff && absHDiff > flingMin && absVelocityX > velocityMin) {
        //move forward or backward
        if (horizontalDiff > 0) {
          backward = true;
        } else if (absVDiff > flingMin && absVelocityY > velocityMin) {
          if (verticalDiff > 0) {
            backward = true;
          } else {
            forward = true;
          }
        }
      }

      //user is cycling forward through messages
      if (forward) {
        System.out.println("user is cycling forward through messages");
      }
      //user is cycling backwards through messages
      else if (backward) {
        System.out.println("user is cycling backwards through messages");
      }

      return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
      System.out.println("Scrolling");
      return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override public boolean onSingleTapConfirmed(MotionEvent e) {
      System.out.println("On Single Tap");
      return super.onSingleTapConfirmed(e);
    }

    @Override public boolean onSingleTapUp(MotionEvent e) {
      System.out.println("On Single Tap Up");
      return super.onSingleTapUp(e);
    }
  }
}
