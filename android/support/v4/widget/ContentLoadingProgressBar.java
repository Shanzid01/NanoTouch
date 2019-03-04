package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private long f289a;
    private boolean f290b;
    private boolean f291c;
    private boolean f292d;
    private final Runnable f293e;
    private final Runnable f294f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f289a = -1;
        this.f290b = false;
        this.f291c = false;
        this.f292d = false;
        this.f293e = new C0151c(this);
        this.f294f = new C0152d(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m925a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m925a();
    }

    private void m925a() {
        removeCallbacks(this.f293e);
        removeCallbacks(this.f294f);
    }
}
