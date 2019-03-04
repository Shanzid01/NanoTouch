package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StaticSizeImageView extends ImageView {
    private boolean f3696a;
    private boolean f3697b = true;

    public StaticSizeImageView(Context context) {
        super(context);
    }

    public StaticSizeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StaticSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageDrawable(Drawable drawable) {
        m5972a();
        super.setImageDrawable(drawable);
        this.f3696a = false;
    }

    public void setImageBitmap(Bitmap bitmap) {
        m5972a();
        super.setImageBitmap(bitmap);
        this.f3696a = false;
    }

    public void requestLayout() {
        if (!this.f3696a) {
            super.requestLayout();
        }
    }

    private void m5972a() {
        if (this.f3697b) {
            this.f3696a = true;
        }
    }
}
