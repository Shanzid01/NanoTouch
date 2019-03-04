package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.slideme.sam.manager.R;

@Deprecated
public class IconView extends StaticSizeImageView {
    Rect f3698a = new Rect();
    Rect f3699b = new Rect();
    Paint f3700c = new Paint();
    BitmapDrawable f3701d;
    private boolean f3702e = false;

    public IconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3700c.setColor(-16596320);
        this.f3701d = (BitmapDrawable) getResources().getDrawable(R.drawable.fg_icon);
    }

    public void draw(Canvas canvas) {
        if (!this.f3702e) {
            int width = (int) (((double) getWidth()) * 0.07d);
            this.f3698a.set(width, width, getWidth() - width, getHeight() - width);
            this.f3701d.setBounds(0, 0, getWidth(), getHeight());
            this.f3702e = true;
        }
        canvas.drawRect(this.f3698a, this.f3700c);
        getDrawable().setBounds(this.f3698a);
        getDrawable().draw(canvas);
        this.f3701d.draw(canvas);
    }
}
