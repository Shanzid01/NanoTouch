package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

/* compiled from: CircleImageView */
class C0150b extends OvalShape {
    final /* synthetic */ C0147a f448a;
    private RadialGradient f449b;
    private int f450c;
    private Paint f451d = new Paint();
    private int f452e;

    public C0150b(C0147a c0147a, int i, int i2) {
        this.f448a = c0147a;
        this.f450c = i;
        this.f452e = i2;
        this.f449b = new RadialGradient((float) (this.f452e / 2), (float) (this.f452e / 2), (float) this.f450c, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.f451d.setShader(this.f449b);
    }

    public void draw(Canvas canvas, Paint paint) {
        int width = this.f448a.getWidth();
        int height = this.f448a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f452e / 2) + this.f450c), this.f451d);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f452e / 2), paint);
    }
}
