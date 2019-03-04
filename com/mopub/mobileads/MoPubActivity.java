package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.p051a.C1529i;

public class MoPubActivity extends C1519m {
    private HtmlInterstitialWebView f2321a;

    static void m4329a(Context context, CustomEventInterstitialListener customEventInterstitialListener, String str) {
        HtmlInterstitialWebView a = C1529i.m4489a(context, customEventInterstitialListener, false, null, null, null);
        a.m4274c(false);
        a.m4321a(new C1573y(customEventInterstitialListener));
        a.setWebViewClient(new C1574z(customEventInterstitialListener));
        a.m4277a(str);
    }

    public View mo4109a() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("Scrollable", false);
        String stringExtra = intent.getStringExtra("Redirect-Url");
        String stringExtra2 = intent.getStringExtra("Clickthrough-Url");
        String stringExtra3 = intent.getStringExtra("Html-Response-Body");
        this.f2321a = C1529i.m4489a(getApplicationContext(), new aa(this), booleanExtra, stringExtra, stringExtra2, m4327e());
        this.f2321a.m4277a(stringExtra3);
        return this.f2321a;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1552s.m4654a(this, m4324b(), "com.mopub.action.interstitial.show");
    }

    protected void onDestroy() {
        this.f2321a.loadUrl(C1545o.WEB_VIEW_DID_CLOSE.getUrl());
        this.f2321a.destroy();
        C1552s.m4654a(this, m4324b(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }
}
