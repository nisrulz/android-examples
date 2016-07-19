package sample.github.nisrulz.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CustomView extends View {

  Paint paint = new Paint();

  public CustomView(Context context) {
    super(context);

    paint.setColor(Color.BLACK);
    paint.setTextSize(30);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    setBackgroundColor(Color.BLUE);
    canvas.drawText("Custom Text", 100, 100, paint);

  }


}
