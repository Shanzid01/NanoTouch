package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import com.slideme.sam.manager.R;

@Deprecated
public class FeaturedLayout extends LinearLayout {
    final Handler f3686a = new C1979m(this);
    private GestureDetector f3687b;
    private Scroller f3688c;
    private int f3689d = 1;
    private boolean f3690e = true;
    private SimpleOnGestureListener f3691f = new C1981o();
    private Runnable f3692g = new C1980n(this);
    private boolean f3693h = false;

    public FeaturedLayout(Context context) {
        super(context);
        m5965b();
    }

    public FeaturedLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5965b();
    }

    public FeaturedLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5965b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3693h) {
            canvas.drawColor(getResources().getColor(R.color.bg_listitem_pressed));
        }
    }

    private void m5965b() {
        int i = 0;
        setWillNotDraw(false);
        while (i < 8) {
            View imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.rating_big_filled);
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(true);
            imageView.setLayoutParams(new LayoutParams(-2, -2));
            addView(imageView);
            i++;
        }
        this.f3687b = new GestureDetector(getContext(), this.f3691f, null);
        this.f3688c = new Scroller(getContext(), null);
        this.f3686a.postDelayed(this.f3692g, 5000);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3690e) {
            m5969a(1);
            this.f3690e = false;
        }
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i3, ((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    public void m5968a() {
        this.f3689d++;
        if (this.f3689d >= getChildCount()) {
            this.f3689d = 0;
        }
        m5969a(this.f3689d);
    }

    public void m5969a(int i) {
        if (i >= 0 && i < getChildCount()) {
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += getChildAt(i3).getWidth();
            }
            this.f3688c.startScroll(getScrollX(), getScrollY(), (((getChildAt(i).getWidth() / 2) + i2) - (getWidth() / 2)) - getScrollX(), 0, 150);
            this.f3686a.sendMessageDelayed(this.f3686a.obtainMessage(-1000), 18);
        }
    }

    private void m5966c() {
        int i = 0;
        int scrollX = getScrollX() + (getWidth() / 2);
        int childCount = getChildCount();
        int i2 = -1;
        int i3 = 0;
        while (i3 < scrollX && i2 < childCount - 1) {
            i2++;
            i3 += getChildAt(i2).getWidth();
        }
        if (i2 != -1) {
            i = i2;
        }
        this.f3689d = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f3687b.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            m5969a(this.f3689d);
            this.f3686a.postDelayed(this.f3692g, 5000);
        } else {
            this.f3686a.removeCallbacks(this.f3692g);
        }
        if (motionEvent.getAction() != 0) {
            this.f3693h = false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
