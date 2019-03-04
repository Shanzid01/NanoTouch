package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.slideme.sam.manager.C1608b;

public class ForegroundRelativeLayout extends RelativeLayout {
    protected Drawable f3694a;
    private boolean f3695b = false;

    public ForegroundRelativeLayout(Context context) {
        super(context);
        m5970a(null);
    }

    public ForegroundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5970a(attributeSet);
    }

    public ForegroundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5970a(attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3695b) {
            this.f3694a.setBounds(new Rect(0, 0, getWidth(), getHeight()));
            this.f3695b = true;
        }
        this.f3694a.draw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3694a != null && this.f3694a.isStateful()) {
            this.f3694a.setState(getDrawableState());
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f3694a) {
            return true;
        }
        return super.verifyDrawable(drawable);
    }

    private void m5970a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ForegroundRelativeLayout);
            m5971a(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
    }

    public void m5971a(Drawable drawable) {
        this.f3694a = drawable;
        this.f3694a.setCallback(this);
        this.f3694a.setVisible(true, false);
        this.f3695b = false;
    }

    public void setForeground(int i) {
        m5971a(getResources().getDrawable(i));
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.f3695b = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3694a = null;
    }
}
