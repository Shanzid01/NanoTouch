package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.TextTrackStyle;
import com.slideme.sam.manager.R;

public class BeveledRelativeLayout extends RelativeLayout {
    Paint f3652a = new Paint();
    int f3653b = 0;
    int f3654c = 0;
    float f3655d = TextTrackStyle.DEFAULT_FONT_SCALE;
    private boolean f3656e = true;

    public BeveledRelativeLayout(Context context) {
        super(context);
        m5912a();
    }

    public BeveledRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5912a();
    }

    public BeveledRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5912a();
    }

    private void m5912a() {
        setWillNotDraw(false);
        this.f3655d = TypedValue.applyDimension(1, TextTrackStyle.DEFAULT_FONT_SCALE, getResources().getDisplayMetrics());
        this.f3652a.setStyle(Style.FILL);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.bevelDark, R.attr.bevelLight});
        this.f3653b = obtainStyledAttributes.getColor(0, 0);
        this.f3654c = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void setShowBevels(boolean z) {
        this.f3656e = z;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3656e) {
            int width = getWidth();
            int height = getHeight();
            this.f3652a.setColor(this.f3653b);
            canvas.drawRect((float) null, ((float) height) - this.f3655d, (float) width, (float) height, this.f3652a);
            canvas.drawRect(((float) width) - this.f3655d, (float) null, (float) width, (float) height, this.f3652a);
            this.f3652a.setColor(this.f3654c);
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) null, (float) null, (float) width, this.f3655d + ((float) null), this.f3652a);
            canvas2 = canvas;
            canvas2.drawRect((float) null, (float) null, this.f3655d + ((float) null), (float) height, this.f3652a);
        }
    }
}
