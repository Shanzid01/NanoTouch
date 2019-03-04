package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.slideme.sam.manager.R;

public class SplashView extends View {
    private int f3755a = -25;
    private BitmapDrawable f3756b = null;
    private BitmapDrawable f3757c = null;
    private Rect f3758d = new Rect();
    private Rect f3759e = new Rect();

    public SplashView(Context context) {
        super(context);
        m6043a();
    }

    protected void onDraw(Canvas canvas) {
        this.f3756b.draw(canvas);
        this.f3757c.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.f3756b.setBounds(0, 0, measuredWidth, measuredHeight);
        int width = this.f3757c.getBitmap().getWidth();
        int height = this.f3757c.getBitmap().getHeight();
        measuredWidth = ((measuredWidth - width) / 2) + (width / 2);
        measuredHeight = (((measuredHeight - height) / 2) + (height / 2)) + this.f3755a;
        this.f3758d.set(measuredWidth - (width / 2), measuredHeight - (height / 2), measuredWidth + (width / 2), measuredHeight + (height / 2));
        this.f3757c.setBounds(this.f3758d);
    }

    private void m6043a() {
        this.f3757c = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.ic_logo));
        this.f3756b = (BitmapDrawable) getResources().getDrawable(R.drawable.bg_splash_pattern);
        this.f3756b.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        setLayoutParams(new LayoutParams(-2, -2));
        this.f3755a = (int) TypedValue.applyDimension(1, (float) this.f3755a, getContext().getResources().getDisplayMetrics());
    }
}
