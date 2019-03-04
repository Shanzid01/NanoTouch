package com.mopub.mobileads.p051a;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlInterstitialWebView;

/* compiled from: HtmlInterstitialWebViewFactory */
public class C1529i {
    protected static C1529i f2397a = new C1529i();

    public static HtmlInterstitialWebView m4489a(Context context, CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2, AdConfiguration adConfiguration) {
        return f2397a.m4490b(context, customEventInterstitialListener, z, str, str2, adConfiguration);
    }

    public HtmlInterstitialWebView m4490b(Context context, CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2, AdConfiguration adConfiguration) {
        HtmlInterstitialWebView htmlInterstitialWebView = new HtmlInterstitialWebView(context, adConfiguration);
        htmlInterstitialWebView.m4320a(customEventInterstitialListener, z, str, str2);
        return htmlInterstitialWebView;
    }
}
