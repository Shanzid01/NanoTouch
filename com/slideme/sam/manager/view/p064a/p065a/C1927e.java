package com.slideme.sam.manager.view.p064a.p065a;

import android.app.Activity;
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
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.view.touchme.YoutubePreviewButton;

/* compiled from: VideoListApplicationViewFactory */
public class C1927e extends C1924b {
    private static /* synthetic */ int[] f3519i;

    static /* synthetic */ int[] m5823f() {
        int[] iArr = f3519i;
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
            f3519i = iArr;
        }
        return iArr;
    }

    public C1927e(Activity activity) {
        super(activity);
    }

    protected int mo4326b() {
        return R.layout.listitem_video;
    }

    public View mo4323a(int i, ApplicationHolder applicationHolder, View view, ViewGroup viewGroup) {
        return mo4324a(i, applicationHolder, view, viewGroup, null);
    }

    public View mo4324a(int i, ApplicationHolder applicationHolder, View view, ViewGroup viewGroup, C0476d c0476d) {
        C1929g c1929g;
        float f = 0.2f;
        if (view == null || view.getTag() == null) {
            view = ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(mo4326b(), viewGroup, false);
            C1929g c1929g2 = new C1929g(this);
            c1929g2.f3524c = (TextView) view.findViewById(R.id.category);
            c1929g2.f3522a = (ImageView) view.findViewById(R.id.icon);
            c1929g2.f3523b = (TextView) view.findViewById(R.id.app_name);
            c1929g2.f3526e = (TextView) view.findViewById(R.id.price);
            c1929g2.f3525d = (RatingBar) view.findViewById(R.id.rating);
            c1929g2.f3527f = (YoutubePreviewButton) view.findViewById(R.id.video);
            view.setTag(c1929g2);
            c1929g = c1929g2;
        } else {
            c1929g = (C1929g) view.getTag();
        }
        view.setBackgroundDrawable(i % (this.e * 2) < this.e ? this.c : this.d);
        applicationHolder.setIcon(c1929g.f3522a, ImageSize.values()[this.b.getResources().getInteger(R.integer.ordinal_icon_app_list)], c0476d);
        applicationHolder.setYoutubeButton(c1929g.f3527f, c0476d);
        c1929g.f3527f.setOnClickListener(new C1928f(this, applicationHolder));
        c1929g.f3523b.setText(applicationHolder.app.getName());
        c1929g.f3524c.setText(applicationHolder.app.getCategory());
        if (TextUtils.isEmpty(applicationHolder.app.getCategory())) {
            c1929g.f3524c.setText(applicationHolder.app.getOrganization());
        }
        c1929g.f3525d.setRating(applicationHolder.getStarRating());
        switch (C1927e.m5823f()[applicationHolder.getInstallState(this.b).ordinal()]) {
            case 1:
                c1929g.f3526e.setText(R.string.installed);
                break;
            case 2:
                if (applicationHolder.app.price != 0.0d) {
                    c1929g.f3526e.setText(SAM.f2616i.m5487a(applicationHolder.app.price));
                    break;
                }
                c1929g.f3526e.setText(R.string.free);
                break;
            case 3:
                c1929g.f3526e.setText(R.string.update);
                break;
        }
        if (this.g) {
            if (this.h.contains(applicationHolder.app.bundleId)) {
                c1929g.f3526e.setText(R.string.tested);
            } else {
                c1929g.f3526e.setText(R.string.untested);
            }
        }
        if (i > this.a) {
            float f2 = (applicationHolder.app.isCompatible || !this.f) ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.2f;
            C1923a.m5802a(view, f2);
            this.a = i;
        } else {
            if (applicationHolder.app.isCompatible || !this.f) {
                f = TextTrackStyle.DEFAULT_FONT_SCALE;
            }
            ViewHelper.setAlpha(view, f);
        }
        return view;
    }

    public View mo4320a() {
        return ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.listitem_loading_indicator, null);
    }

    public void mo4325a(int i) {
        this.e = i;
    }
}
