package com.github.amlcurran.showcaseview;

import android.app.Activity;
import com.github.amlcurran.showcaseview.p042a.C0639a;

/* compiled from: ShowcaseView */
public class C0666y {
    final ShowcaseView f1661a;
    private final Activity f1662b;

    public C0666y(Activity activity, boolean z) {
        this.f1662b = activity;
        this.f1661a = new ShowcaseView(activity, z);
        this.f1661a.m3180a(C0639a.f1622a);
    }

    public ShowcaseView m3246a() {
        ShowcaseView.m3167b(this.f1661a, this.f1662b);
        return this.f1661a;
    }

    public C0666y m3247a(int i) {
        return m3250a(this.f1662b.getString(i));
    }

    public C0666y m3250a(CharSequence charSequence) {
        this.f1661a.m3182a(charSequence);
        return this;
    }

    public C0666y m3251b(CharSequence charSequence) {
        this.f1661a.m3184b(charSequence);
        return this;
    }

    public C0666y m3249a(C0639a c0639a) {
        this.f1661a.m3180a(c0639a);
        return this;
    }

    public C0666y m3248a(long j) {
        this.f1661a.setSingleShot(j);
        return this;
    }
}
