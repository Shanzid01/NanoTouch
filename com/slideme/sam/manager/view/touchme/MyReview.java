package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.data.Review;

public class MyReview extends FrameLayout {
    private RatingBar f3714a;
    private TextView f3715b;
    private FragmentActivity f3716c;
    private ApplicationHolder f3717d = null;
    private Review f3718e = null;

    public MyReview(Context context) {
        super(context);
        m5985a();
    }

    public MyReview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5985a();
    }

    public void m5985a() {
        setBackgroundResource(R.drawable.bg_clickable_borderless);
        addView(inflate(getContext(), R.layout.widget_my_review, null));
        this.f3714a = (RatingBar) findViewById(R.id.ratingBar);
        this.f3715b = (TextView) findViewById(R.id.textView);
        setOnClickListener(new C1989w(this));
    }

    public void m5987a(ApplicationHolder applicationHolder) {
        this.f3717d = applicationHolder;
        m5991e();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m5988b() {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.f3717d;
        r2 = r4.getContext();
        r0 = r0.getInstallState(r2);
        r2 = com.slideme.sam.manager.model.p054b.C1828b.NOT_INSTALLED;
        if (r0 == r2) goto L_0x0044;
    L_0x000f:
        r0 = com.slideme.sam.manager.SAM.f2622o;
        r0 = r0.m4850b();
        if (r0 == 0) goto L_0x0044;
    L_0x0017:
        r0 = 1;
    L_0x0018:
        if (r0 == 0) goto L_0x0046;
    L_0x001a:
        r2 = r4.getContext();	 Catch:{ NullPointerException -> 0x0049 }
        r2 = r2.getApplicationContext();	 Catch:{ NullPointerException -> 0x0049 }
        r2 = com.slideme.sam.manager.auth.AuthData.m4808d(r2);	 Catch:{ NullPointerException -> 0x0049 }
        if (r2 != 0) goto L_0x0046;
    L_0x0028:
        r2 = r4.f3717d;	 Catch:{ NullPointerException -> 0x0049 }
        r2 = r2.app;	 Catch:{ NullPointerException -> 0x0049 }
        r2 = r2.vendor;	 Catch:{ NullPointerException -> 0x0049 }
        r3 = r4.getContext();	 Catch:{ NullPointerException -> 0x0049 }
        r3 = r3.getApplicationContext();	 Catch:{ NullPointerException -> 0x0049 }
        r3 = com.slideme.sam.manager.auth.AuthData.m4811g(r3);	 Catch:{ NullPointerException -> 0x0049 }
        r2 = r2.equals(r3);	 Catch:{ NullPointerException -> 0x0049 }
        if (r2 != 0) goto L_0x0046;
    L_0x0040:
        r4.setVisibility(r1);	 Catch:{ NullPointerException -> 0x0049 }
    L_0x0043:
        return r0;
    L_0x0044:
        r0 = r1;
        goto L_0x0018;
    L_0x0046:
        r1 = 8;
        goto L_0x0040;
    L_0x0049:
        r1 = move-exception;
        com.slideme.sam.manager.util.C1922m.m5791a(r1);
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.slideme.sam.manager.view.touchme.MyReview.b():boolean");
    }

    public void m5989c() {
        Object obj = (this.f3718e == null || this.f3718e.text == null || this.f3718e.text.length() == 0) ? null : 1;
        this.f3714a.setRating(obj != null ? this.f3718e.rating : 0.0f);
        this.f3715b.setText(obj != null ? R.string.edit_review : R.string.review_app);
    }

    public void m5990d() {
        m5988b();
        m5989c();
    }

    public void m5991e() {
        if (m5988b()) {
            SAM.f2614g.m5610a(this.f3717d.app, new C1990x(this));
        }
    }

    public void m5986a(FragmentActivity fragmentActivity) {
        this.f3716c = fragmentActivity;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putParcelable("STATE_APPHOHLDER", this.f3717d);
        bundle.putParcelable("STATE_REVIEW", this.f3718e);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3717d = (ApplicationHolder) bundle.getParcelable("STATE_APPHOHLDER");
            this.f3718e = (Review) bundle.getParcelable("STATE_REVIEW");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
