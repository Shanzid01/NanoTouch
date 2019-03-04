package com.mopub.mobileads;

import android.net.Uri;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public class HtmlInterstitial extends bx {
    private String f2311d;
    private boolean f2312e;
    private String f2313f;
    private String f2314g;

    protected void mo4107a(Map<String, String> map) {
        this.f2311d = Uri.decode((String) map.get("Html-Response-Body"));
        this.f2312e = Boolean.valueOf((String) map.get("Scrollable")).booleanValue();
        this.f2313f = (String) map.get("Redirect-Url");
        this.f2314g = (String) map.get("Clickthrough-Url");
    }

    protected void mo4106a(CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubActivity.m4329a(this.a, customEventInterstitialListener, this.f2311d);
    }
}
