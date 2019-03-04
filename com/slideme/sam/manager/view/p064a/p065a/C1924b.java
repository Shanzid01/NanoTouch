package com.slideme.sam.manager.view.p064a.p065a;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.gms.cast.TextTrackStyle;
import com.nineoldandroids.view.ViewHelper;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application.ImageSize;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.data.cache.helper.TestModeCache;
import com.slideme.sam.manager.model.p054b.C1828b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/* compiled from: ApplicationHolderViewFactory */
public class C1924b extends C1923a<ApplicationHolder> {
    private static /* synthetic */ int[] f3502i;
    int f3503a = -1;
    Activity f3504b;
    Drawable f3505c;
    Drawable f3506d;
    int f3507e = 1;
    boolean f3508f;
    boolean f3509g = false;
    ArrayList<String> f3510h;

    static /* synthetic */ int[] m5807e() {
        int[] iArr = f3502i;
        if (iArr == null) {
            iArr = new int[C1828b.values().length];
            try {
                iArr[C1828b.NEEDS_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1828b.NOT_INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1828b.UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            f3502i = iArr;
        }
        return iArr;
    }

    public C1924b(Activity activity) {
        this.f3504b = activity;
        this.f3508f = this.f3504b.getResources().getBoolean(R.bool.showIncompatibilityIndicators);
        TypedArray obtainStyledAttributes = this.f3504b.getTheme().obtainStyledAttributes(new int[]{R.attr.backgroundListItemEven, R.attr.backgroundListItemOdd});
        this.f3505c = obtainStyledAttributes.getDrawable(0).mutate();
        if (this.f3505c instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f3505c).setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        }
        this.f3506d = obtainStyledAttributes.getDrawable(1).mutate();
        if (this.f3506d instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f3506d).setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        }
        obtainStyledAttributes.recycle();
    }

    protected int mo4326b() {
        return R.layout.listitem_app;
    }

    public View mo4323a(int i, ApplicationHolder applicationHolder, View view, ViewGroup viewGroup) {
        return mo4324a(i, applicationHolder, view, viewGroup, null);
    }

    public View mo4324a(int i, ApplicationHolder applicationHolder, View view, ViewGroup viewGroup, C0476d c0476d) {
        C1925c c1925c;
        if (view == null || view.getTag() == null) {
            view = ((LayoutInflater) this.f3504b.getSystemService("layout_inflater")).inflate(mo4326b(), viewGroup, false);
            C1925c c1925c2 = new C1925c(this);
            c1925c2.f3513c = (TextView) view.findViewById(R.id.category);
            c1925c2.f3511a = (ImageView) view.findViewById(R.id.icon);
            c1925c2.f3512b = (TextView) view.findViewById(R.id.app_name);
            c1925c2.f3515e = (TextView) view.findViewById(R.id.price);
            c1925c2.f3514d = (RatingBar) view.findViewById(R.id.rating);
            c1925c2.f3516f = (TextView) view.findViewById(R.id.price_old);
            c1925c2.f3516f.setPaintFlags(c1925c2.f3516f.getPaintFlags() | 16);
            view.setTag(c1925c2);
            c1925c = c1925c2;
        } else {
            c1925c = (C1925c) view.getTag();
        }
        view.setBackgroundDrawable(i % (this.f3507e * 2) < this.f3507e ? this.f3505c : this.f3506d);
        applicationHolder.setIcon(c1925c.f3511a, ImageSize.values()[this.f3504b.getResources().getInteger(R.integer.ordinal_icon_app_list)], c0476d);
        c1925c.f3512b.setText(applicationHolder.app.getName());
        c1925c.f3513c.setText(applicationHolder.app.getCategory());
        if (TextUtils.isEmpty(applicationHolder.app.getCategory())) {
            c1925c.f3513c.setText(applicationHolder.app.getOrganization());
        }
        c1925c.f3514d.setRating(applicationHolder.getStarRating());
        c1925c.f3516f.setText(SAM.f2616i.m5487a(applicationHolder.app.priceOld));
        switch (C1924b.m5807e()[applicationHolder.getInstallState(this.f3504b).ordinal()]) {
            case 1:
                c1925c.f3515e.setText(R.string.installed);
                break;
            case 2:
                if (!applicationHolder.isAdProxyOffer()) {
                    if (applicationHolder.app.price != 0.0d) {
                        c1925c.f3515e.setText(SAM.f2616i.m5487a(applicationHolder.app.price));
                        break;
                    }
                    c1925c.f3515e.setText(R.string.free);
                    break;
                }
                c1925c.f3515e.setText(new StringBuilder(String.valueOf(this.f3504b.getResources().getString(R.string.earn))).append("\n").append(SAM.f2616i.m5487a(new BigDecimal(applicationHolder.app.payout * ((double) (SAM.f2619l.m5428b() / 100.0f))).setScale(2, RoundingMode.HALF_UP).doubleValue())).toString());
                c1925c.f3515e.setGravity(17);
                break;
            case 3:
                c1925c.f3515e.setText(R.string.update);
                break;
        }
        if (!applicationHolder.isOffer() || applicationHolder.isAdProxyOffer()) {
            c1925c.f3516f.setVisibility(8);
            c1925c.f3515e.setPadding(c1925c.f3515e.getPaddingLeft(), c1925c.f3515e.getPaddingBottom(), c1925c.f3515e.getPaddingRight(), c1925c.f3515e.getPaddingBottom());
        } else {
            c1925c.f3516f.setVisibility(0);
            c1925c.f3515e.setPadding(c1925c.f3515e.getPaddingLeft(), 0, c1925c.f3515e.getPaddingRight(), c1925c.f3515e.getPaddingBottom());
        }
        if (this.f3509g) {
            if (this.f3510h.contains(applicationHolder.app.bundleId)) {
                c1925c.f3515e.setText(R.string.tested);
            } else {
                c1925c.f3515e.setText(R.string.untested);
            }
        }
        float f;
        if (i > this.f3503a) {
            f = (applicationHolder.app.isCompatible || !this.f3508f) ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.2f;
            C1923a.m5802a(view, f);
            this.f3503a = i;
        } else {
            f = (applicationHolder.app.isCompatible || !this.f3508f) ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.2f;
            ViewHelper.setAlpha(view, f);
        }
        return view;
    }

    public View mo4320a() {
        return ((LayoutInflater) this.f3504b.getSystemService("layout_inflater")).inflate(R.layout.listitem_loading_indicator, null);
    }

    public void m5816c() {
        if (this.f3509g) {
            TestModeCache testModeCache = new TestModeCache(this.f3504b);
            m5806a(testModeCache.getAll());
            testModeCache.close();
        }
    }

    private void m5806a(String[] strArr) {
        this.f3510h = new ArrayList(strArr.length);
        for (Object add : strArr) {
            this.f3510h.add(add);
        }
    }

    public void mo4325a(int i) {
        this.f3507e = i;
    }

    public int m5817d() {
        return this.f3503a;
    }

    public void m5815b(int i) {
        this.f3503a = i;
    }
}
