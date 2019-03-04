package com.mopub.mobileads;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.location.places.Place;
import com.mopub.common.p050b.C1481d;
import com.mopub.common.p050b.C1482e;

/* compiled from: BaseInterstitialActivity */
abstract class C1519m extends Activity {
    private ImageView f2316a;
    private RelativeLayout f2317b;
    private int f2318c;
    private int f2319d;
    private long f2320e;

    public abstract View mo4109a();

    C1519m() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(Place.TYPE_SUBLOCALITY_LEVEL_2);
        this.f2318c = C1481d.m4060d(50.0f, this);
        this.f2319d = C1481d.m4060d(8.0f, this);
        this.f2317b = new RelativeLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f2317b.addView(mo4109a(), layoutParams);
        setContentView(this.f2317b);
        AdConfiguration e = m4327e();
        if (e != null) {
            this.f2320e = e.m4191d();
        }
        m4322f();
    }

    protected void onDestroy() {
        this.f2317b.removeAllViews();
        super.onDestroy();
    }

    long m4324b() {
        return this.f2320e;
    }

    protected void m4325c() {
        this.f2316a.setVisibility(0);
    }

    protected void m4326d() {
        this.f2316a.setVisibility(4);
    }

    protected AdConfiguration m4327e() {
        try {
            return (AdConfiguration) getIntent().getSerializableExtra("Ad-Configuration");
        } catch (ClassCastException e) {
            return null;
        }
    }

    private void m4322f() {
        this.f2316a = new ImageButton(this);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, C1482e.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this));
        stateListDrawable.addState(new int[]{16842919}, C1482e.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this));
        this.f2316a.setImageDrawable(stateListDrawable);
        this.f2316a.setBackgroundDrawable(null);
        this.f2316a.setOnClickListener(new C1544n(this));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f2318c, this.f2318c);
        layoutParams.addRule(11);
        layoutParams.setMargins(this.f2319d, 0, this.f2319d, 0);
        this.f2317b.addView(this.f2316a, layoutParams);
    }
}
