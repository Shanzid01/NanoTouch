package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import java.util.ArrayList;
import java.util.Collections;

public class SlidingTabSelector extends LinearLayout {
    private ar f3750a;
    private int f3751b = -1;
    private au f3752c = new au();
    private ViewPager f3753d;
    private aq f3754e = new am(this);

    public SlidingTabSelector(Context context) {
        super(context);
        m6038b();
    }

    public SlidingTabSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6038b();
    }

    private void m6034a(int i, boolean z, boolean z2) {
        if (i < getChildCount() && i >= 0) {
            this.f3751b = i;
            if (z) {
                m6039b(getChildAt(i));
            } else {
                this.f3750a.m6078a((float) (getChildAt(i).getLeft() + (getChildAt(i).getWidth() / 2)));
                invalidate();
            }
            if (this.f3753d != null && z2) {
                this.f3753d.setCurrentItem(this.f3751b, true);
            }
            this.f3754e.mo4333a(this.f3751b);
            m6032a();
        }
    }

    public void setSelectedChild(int i, boolean z) {
        m6034a(i, z, true);
    }

    private void m6032a() {
        for (int i = 0; i < getChildCount(); i++) {
            int i2;
            TextView textView = (TextView) getChildAt(i);
            if (i == this.f3751b) {
                i2 = -1;
            } else {
                i2 = getResources().getColor(17170432);
            }
            textView.setTextColor(i2);
        }
    }

    private void m6039b(View view) {
        m6033a(this.f3750a.m6082b(), (float) (view.getLeft() + (view.getWidth() / 2)));
    }

    private void m6038b() {
        this.f3750a = new ar(this);
        this.f3750a.m6093a(-1);
        setWillNotDraw(false);
        setClickable(true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RectF a = this.f3750a.m6091a();
        switch (motionEvent.getAction()) {
            case 0:
                if (motionEvent.getX() < a.right && motionEvent.getX() > a.left) {
                    this.f3752c.m6104b();
                    break;
                }
            case 1:
                if (!this.f3752c.m6102a()) {
                    setSelectedChild(m6040a(m6036b(motionEvent.getX())), true);
                    break;
                }
                this.f3752c.m6101a(motionEvent.getX());
                int a2 = m6040a(m6041a(this.f3752c.m6103b(0.8f)));
                setSelectedChild(a2, true);
                this.f3754e.mo4333a(a2);
                this.f3752c.m6105c();
                break;
            case 2:
                if (motionEvent.getX() < a.right && motionEvent.getX() > a.left) {
                    this.f3752c.m6101a(motionEvent.getX());
                    this.f3750a.m6078a(motionEvent.getX());
                    invalidate();
                    break;
                }
        }
        return true;
    }

    public int m6040a(View view) {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i).equals(view)) {
                return i;
            }
        }
        return -1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3751b < 0) {
            setSelectedChild(0, false);
        }
        this.f3750a.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.f3750a.f3801g) {
            this.f3750a.f3801g = true;
            this.f3750a.m6094a(BitmapFactory.decodeResource(getResources(), R.drawable.bg_slider_btn));
        }
    }

    private void m6033a(float f, float f2) {
        this.f3750a.m6092a(f, f2);
    }

    public View m6041a(float f) {
        if (Math.abs(f) < 0.2f) {
            return m6036b(this.f3750a.m6082b());
        }
        return m6037b(this.f3750a.m6082b(), f);
    }

    private View m6037b(float f, float f2) {
        View b;
        View b2 = m6036b(f);
        if (((float) (b2.getLeft() + (b2.getWidth() / 2))) < f) {
            b = m6036b(((float) b2.getWidth()) + f);
        } else {
            View view = b2;
            b2 = m6036b(f - ((float) b2.getWidth()));
            b = view;
        }
        if (f2 < 0.0f) {
            return b2;
        }
        return b;
    }

    private View m6036b(float f) {
        Object arrayList = new ArrayList(getChildCount());
        for (int i = 0; i < getChildCount(); i++) {
            ap apVar = new ap();
            apVar.f3793b = Math.abs(((float) (getChildAt(i).getLeft() + (getChildAt(i).getWidth() / 2))) - f);
            apVar.f3792a = i;
            arrayList.add(apVar);
        }
        Collections.sort(arrayList, new an(this));
        return getChildAt(((ap) arrayList.get(0)).f3792a);
    }

    public void m6042a(ViewPager viewPager) {
        this.f3753d = viewPager;
        viewPager.m188a(new ao(this));
    }
}
