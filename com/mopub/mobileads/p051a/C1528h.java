package com.mopub.mobileads.p051a;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;

/* compiled from: HtmlBannerWebViewFactory */
public class C1528h {
    protected static C1528h f2396a = new C1528h();

    public static HtmlBannerWebView m4487a(Context context, CustomEventBannerListener customEventBannerListener, boolean z, String str, String str2, AdConfiguration adConfiguration) {
        return f2396a.m4488b(context, customEventBannerListener, z, str, str2, adConfiguration);
    }

    public HtmlBannerWebView m4488b(Context context, CustomEventBannerListener customEventBannerListener, boolean z, String str, String str2, AdConfiguration adConfiguration) {
        HtmlBannerWebView htmlBannerWebView = new HtmlBannerWebView(context, adConfiguration);
        htmlBannerWebView.m4312a(customEventBannerListener, z, str, str2);
        return htmlBannerWebView;
    }
}
