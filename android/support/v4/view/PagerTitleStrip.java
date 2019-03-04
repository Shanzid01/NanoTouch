package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements ci {
    private static final int[] f109n = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] f110o = new int[]{16843660};
    private static final ao f111q;
    ViewPager f112a;
    TextView f113b;
    TextView f114c;
    TextView f115d;
    int f116e;
    private int f117f;
    private float f118g;
    private int f119h;
    private int f120i;
    private boolean f121j;
    private boolean f122k;
    private final an f123l;
    private WeakReference<aj> f124m;
    private int f125p;

    static {
        if (VERSION.SDK_INT >= 14) {
            f111q = new aq();
        } else {
            f111q = new ap();
        }
    }

    private static void m152a(TextView textView) {
        f111q.mo244a(textView);
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        this.f117f = -1;
        this.f118g = GroundOverlayOptions.NO_DIMENSION;
        this.f123l = new an();
        View textView = new TextView(context);
        this.f113b = textView;
        addView(textView);
        textView = new TextView(context);
        this.f114c = textView;
        addView(textView);
        textView = new TextView(context);
        this.f115d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f109n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f113b.setTextAppearance(context, resourceId);
            this.f114c.setTextAppearance(context, resourceId);
            this.f115d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.f113b.setTextColor(dimensionPixelSize);
            this.f114c.setTextColor(dimensionPixelSize);
            this.f115d.setTextColor(dimensionPixelSize);
        }
        this.f120i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f116e = this.f114c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f113b.setEllipsize(TruncateAt.END);
        this.f114c.setEllipsize(TruncateAt.END);
        this.f115d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, f110o);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            m152a(this.f113b);
            m152a(this.f114c);
            m152a(this.f115d);
        } else {
            this.f113b.setSingleLine();
            this.f114c.setSingleLine();
            this.f115d.setSingleLine();
        }
        this.f119h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f119h = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.f119h;
    }

    public void setNonPrimaryAlpha(float f) {
        this.f125p = ((int) (255.0f * f)) & 255;
        int i = (this.f125p << 24) | (this.f116e & 16777215);
        this.f113b.setTextColor(i);
        this.f115d.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f116e = i;
        this.f114c.setTextColor(i);
        int i2 = (this.f125p << 24) | (this.f116e & 16777215);
        this.f113b.setTextColor(i2);
        this.f115d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f113b.setTextSize(i, f);
        this.f114c.setTextSize(i, f);
        this.f115d.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.f120i = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            aj b = viewPager.m191b();
            viewPager.m194b(this.f123l);
            viewPager.m187a(this.f123l);
            this.f112a = viewPager;
            m155a(this.f124m != null ? (aj) this.f124m.get() : null, b);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f112a != null) {
            m155a(this.f112a.m191b(), null);
            this.f112a.m194b(null);
            this.f112a.m187a(null);
            this.f112a = null;
        }
    }

    void m154a(int i, aj ajVar) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = ajVar != null ? ajVar.getCount() : 0;
        this.f121j = true;
        if (i < 1 || ajVar == null) {
            charSequence = null;
        } else {
            charSequence = ajVar.getPageTitle(i - 1);
        }
        this.f113b.setText(charSequence);
        TextView textView = this.f114c;
        if (ajVar == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = ajVar.getPageTitle(i);
        }
        textView.setText(charSequence);
        if (i + 1 < count && ajVar != null) {
            charSequence2 = ajVar.getPageTitle(i + 1);
        }
        this.f115d.setText(charSequence2);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        count = MeasureSpec.makeMeasureSpec((int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f), Integer.MIN_VALUE);
        height = MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
        this.f113b.measure(count, height);
        this.f114c.measure(count, height);
        this.f115d.measure(count, height);
        this.f117f = i;
        if (!this.f122k) {
            mo169a(i, this.f118g, false);
        }
        this.f121j = false;
    }

    public void requestLayout() {
        if (!this.f121j) {
            super.requestLayout();
        }
    }

    void m155a(aj ajVar, aj ajVar2) {
        if (ajVar != null) {
            ajVar.unregisterDataSetObserver(this.f123l);
            this.f124m = null;
        }
        if (ajVar2 != null) {
            ajVar2.registerDataSetObserver(this.f123l);
            this.f124m = new WeakReference(ajVar2);
        }
        if (this.f112a != null) {
            this.f117f = -1;
            this.f118g = GroundOverlayOptions.NO_DIMENSION;
            m154a(this.f112a.getCurrentItem(), ajVar2);
            requestLayout();
        }
    }

    void mo169a(int i, float f, boolean z) {
        if (i != this.f117f) {
            m154a(i, this.f112a.m191b());
        } else if (!z && f == this.f118g) {
            return;
        }
        this.f122k = true;
        int measuredWidth = this.f113b.getMeasuredWidth();
        int measuredWidth2 = this.f114c.getMeasuredWidth();
        int measuredWidth3 = this.f115d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > TextTrackStyle.DEFAULT_FONT_SCALE) {
            f2 -= TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        i4 = ((width - i3) - ((int) (f2 * ((float) i4)))) - (measuredWidth2 / 2);
        i3 = i4 + measuredWidth2;
        i2 = this.f113b.getBaseline();
        measuredWidth2 = this.f114c.getBaseline();
        int baseline = this.f115d.getBaseline();
        int max = Math.max(Math.max(i2, measuredWidth2), baseline);
        i2 = max - i2;
        measuredWidth2 = max - measuredWidth2;
        baseline = max - baseline;
        int measuredHeight = this.f115d.getMeasuredHeight() + baseline;
        max = Math.max(Math.max(this.f113b.getMeasuredHeight() + i2, this.f114c.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.f120i & 112) {
            case 16:
                paddingTop = (((height - paddingTop) - paddingBottom) - max) / 2;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                paddingTop = (height - paddingBottom) - max;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            default:
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
        }
        this.f114c.layout(i4, measuredWidth2, i3, this.f114c.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i4 - this.f119h) - measuredWidth);
        this.f113b.layout(measuredWidth2, height, measuredWidth + measuredWidth2, this.f113b.getMeasuredHeight() + height);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.f119h + i3);
        this.f115d.layout(measuredWidth2, i2, measuredWidth2 + measuredWidth3, this.f115d.getMeasuredHeight() + i2);
        this.f118g = f;
        this.f122k = false;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        mode = getMinHeight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (((float) size) * 0.8f), Integer.MIN_VALUE);
        i3 = MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        this.f113b.measure(makeMeasureSpec, i3);
        this.f114c.measure(makeMeasureSpec, i3);
        this.f115d.measure(makeMeasureSpec, i3);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(mode, this.f114c.getMeasuredHeight() + paddingTop));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.f112a != null) {
            if (this.f118g >= 0.0f) {
                f = this.f118g;
            }
            mo169a(this.f117f, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
