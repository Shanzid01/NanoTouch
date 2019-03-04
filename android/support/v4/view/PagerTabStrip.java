package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.gms.cast.TextTrackStyle;

public class PagerTabStrip extends PagerTitleStrip {
    private int f126f;
    private int f127g;
    private int f128h;
    private int f129i;
    private int f130j;
    private int f131k;
    private final Paint f132l;
    private final Rect f133m;
    private int f134n;
    private boolean f135o;
    private boolean f136p;
    private int f137q;
    private boolean f138r;
    private float f139s;
    private float f140t;
    private int f141u;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f132l = new Paint();
        this.f133m = new Rect();
        this.f134n = 255;
        this.f135o = false;
        this.f136p = false;
        this.f126f = this.e;
        this.f132l.setColor(this.f126f);
        float f = context.getResources().getDisplayMetrics().density;
        this.f127g = (int) ((3.0f * f) + 0.5f);
        this.f128h = (int) ((6.0f * f) + 0.5f);
        this.f129i = (int) (64.0f * f);
        this.f131k = (int) ((16.0f * f) + 0.5f);
        this.f137q = (int) ((TextTrackStyle.DEFAULT_FONT_SCALE * f) + 0.5f);
        this.f130j = (int) ((f * 32.0f) + 0.5f);
        this.f141u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new ak(this));
        this.d.setFocusable(true);
        this.d.setOnClickListener(new al(this));
        if (getBackground() == null) {
            this.f135o = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.f126f = i;
        this.f132l.setColor(this.f126f);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public int getTabIndicatorColor() {
        return this.f126f;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f128h) {
            i4 = this.f128h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.f129i) {
            i = this.f129i;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f136p) {
            this.f135o = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f136p) {
            this.f135o = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.f136p) {
            this.f135o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f135o = z;
        this.f136p = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.f135o;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f130j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f138r) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.f139s = x;
                this.f140t = y;
                this.f138r = false;
                break;
            case 1:
                if (x >= ((float) (this.c.getLeft() - this.f131k))) {
                    if (x > ((float) (this.c.getRight() + this.f131k))) {
                        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                        break;
                    }
                }
                this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.f139s) > ((float) this.f141u) || Math.abs(y - this.f140t) > ((float) this.f141u)) {
                    this.f138r = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.f131k;
        int right = this.c.getRight() + this.f131k;
        int i = height - this.f127g;
        this.f132l.setColor((this.f134n << 24) | (this.f126f & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f132l);
        if (this.f135o) {
            this.f132l.setColor(-16777216 | (this.f126f & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f137q), (float) (getWidth() - getPaddingRight()), (float) height, this.f132l);
        }
    }

    void mo169a(int i, float f, boolean z) {
        Rect rect = this.f133m;
        int height = getHeight();
        int i2 = height - this.f127g;
        rect.set(this.c.getLeft() - this.f131k, i2, this.c.getRight() + this.f131k, height);
        super.mo169a(i, f, z);
        this.f134n = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.c.getLeft() - this.f131k, i2, this.c.getRight() + this.f131k, height);
        invalidate(rect);
    }
}
