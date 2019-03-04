package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.mopub.common.p050b.C1481d;

/* compiled from: CountdownDrawable */
public class C1550c extends C1548a implements TextDrawable {
    private final Paint f2528a = new Paint();
    private String f2529b = "";
    private final float f2530c;
    private Rect f2531d;

    public C1550c(Context context) {
        this.f2530c = C1481d.m4056a(18.0f, context);
        this.f2528a.setTextSize(this.f2530c);
        this.f2528a.setAntiAlias(true);
        this.f2528a.setColor(-1);
        this.f2528a.setStyle(Style.FILL);
        this.f2528a.setTextAlign(Align.LEFT);
        this.f2531d = new Rect();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        String valueOf = String.valueOf(this.f2529b);
        this.f2528a.getTextBounds(valueOf, 0, valueOf.length(), this.f2531d);
        canvas.drawText(valueOf, (float) (m4650b() - (this.f2531d.width() / 2)), (float) (m4651c() + (this.f2531d.height() / 2)), this.f2528a);
    }

    public void updateText(String str) {
        if (!this.f2529b.equals(str)) {
            this.f2529b = str;
            invalidateSelf();
        }
    }
}
