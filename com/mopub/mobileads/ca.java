package com.mopub.mobileads;

import android.content.Context;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.gms.cast.TextTrackStyle;
import com.mopub.common.p050b.C1481d;
import com.mopub.common.p050b.C1492o;
import com.mopub.mobileads.resource.C1549b;
import com.mopub.mobileads.resource.C1550c;
import com.mopub.mobileads.resource.C1551d;

/* compiled from: VastVideoToolbar */
class ca extends LinearLayout {
    private final by f2489a = m4628b();
    private final by f2490b = m4629c();
    private final by f2491c = m4630d();
    private final by f2492d = m4631e();

    public ca(Context context) {
        super(context);
        setId((int) C1492o.m4089a());
        setOnTouchListener(new cb(this));
        setLayoutParams(new LayoutParams(-1, C1481d.m4058b(44.0f, getContext())));
        setBackgroundColor(-16777216);
        getBackground().setAlpha(180);
        addView(this.f2489a);
        addView(this.f2490b);
        addView(this.f2491c);
        addView(this.f2492d);
    }

    String m4632a(long j) {
        return String.valueOf(Math.round(Math.ceil((double) (((float) j) / 1000.0f))));
    }

    void m4634a(int i) {
        if (i >= 200) {
            this.f2489a.m4604a("Ends in " + m4632a((long) i) + " seconds");
        } else if (i >= 0) {
            this.f2489a.m4604a("Thanks for watching");
        }
    }

    void m4636b(int i) {
        if (i >= 0 && this.f2491c.getVisibility() == 4) {
            this.f2492d.setVisibility(8);
            this.f2491c.setVisibility(0);
        }
        this.f2491c.m4605b(m4632a((long) i));
    }

    void m4633a() {
        this.f2491c.setVisibility(8);
        this.f2490b.setVisibility(0);
        this.f2492d.setVisibility(0);
    }

    void m4635a(OnTouchListener onTouchListener) {
        this.f2492d.setOnTouchListener(onTouchListener);
    }

    void m4637b(OnTouchListener onTouchListener) {
        this.f2490b.setOnTouchListener(onTouchListener);
    }

    private by m4628b() {
        return new bz(getContext()).m4618a(2.0f).m4619a(19).m4617a().m4623b(9).m4622b();
    }

    private by m4629c() {
        return new bz(getContext()).m4618a((float) TextTrackStyle.DEFAULT_FONT_SCALE).m4619a(21).m4621a("Learn More").m4620a(new C1551d()).m4624c(4).m4622b();
    }

    private by m4630d() {
        return new bz(getContext()).m4618a((float) TextTrackStyle.DEFAULT_FONT_SCALE).m4619a(21).m4621a("Skip in").m4620a(new C1550c(getContext())).m4624c(4).m4622b();
    }

    private by m4631e() {
        return new bz(getContext()).m4618a((float) TextTrackStyle.DEFAULT_FONT_SCALE).m4619a(21).m4621a("Close").m4620a(new C1549b()).m4624c(8).m4622b();
    }
}
