package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import com.mopub.common.p050b.C1493p;
import com.mopub.mobileads.MraidView.ExpansionStyle;
import com.mopub.mobileads.MraidView.NativeCloseButtonStyle;
import com.mopub.mobileads.MraidView.PlacementType;
import com.mopub.mobileads.p051a.C1531k;
import com.mopub.mobileads.util.C1561g;

public class MraidActivity extends C1519m {
    private MraidView f2347a;

    public View mo4109a() {
        this.f2347a = C1531k.m4494a(this, m4327e(), ExpansionStyle.DISABLED, NativeCloseButtonStyle.AD_CONTROLLED, PlacementType.INTERSTITIAL);
        this.f2347a.m4399a(new ai(this));
        this.f2347a.m4400a(new aj(this));
        this.f2347a.m4403a(getIntent().getStringExtra("Html-Response-Body"));
        return this.f2347a;
    }

    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1552s.m4654a(this, m4324b(), "com.mopub.action.interstitial.show");
        if (C1493p.currentApiLevel().isAtLeast(C1493p.ICE_CREAM_SANDWICH)) {
            getWindow().setFlags(16777216, 16777216);
        }
    }

    protected void onPause() {
        super.onPause();
        C1561g.m4671a(this.f2347a);
    }

    protected void onResume() {
        super.onResume();
        C1561g.m4672b(this.f2347a);
    }

    protected void onDestroy() {
        this.f2347a.destroy();
        C1552s.m4654a(this, m4324b(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }
}
