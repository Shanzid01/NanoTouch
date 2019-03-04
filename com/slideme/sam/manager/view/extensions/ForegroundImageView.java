package com.slideme.sam.manager.view.extensions;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.slideme.sam.manager.R;

public class ForegroundImageView extends ImageView {
    protected Drawable f3600a;
    private boolean f3601b = false;

    public ForegroundImageView(Context context) {
        super(context);
        m5864a();
    }

    public ForegroundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5864a();
    }

    public ForegroundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5864a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3601b) {
            this.f3600a.setBounds(new Rect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom()));
            this.f3601b = true;
        }
        this.f3600a.draw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3600a != null && this.f3600a.isStateful()) {
            this.f3600a.setState(getDrawableState());
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f3600a) {
            return true;
        }
        return super.verifyDrawable(drawable);
    }

    private void m5864a() {
        m5865a(getResources().getDrawable(R.drawable.fg_touchable_image));
    }

    public void m5865a(Drawable drawable) {
        this.f3600a = drawable;
        this.f3600a.setCallback(this);
        this.f3600a.setVisible(true, false);
        this.f3601b = false;
    }

    public void setForeground(int i) {
        m5865a(getResources().getDrawable(i));
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.f3601b = false;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f3601b = false;
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f3601b = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3600a = null;
    }
}
