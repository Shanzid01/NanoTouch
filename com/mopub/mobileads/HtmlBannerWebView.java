package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;

public class HtmlBannerWebView extends BaseHtmlWebView {
    public HtmlBannerWebView(Context context, AdConfiguration adConfiguration) {
        super(context, adConfiguration);
    }

    public void m4312a(CustomEventBannerListener customEventBannerListener, boolean z, String str, String str2) {
        super.m4278a(z);
        setWebViewClient(new C1572x(new C1553t(customEventBannerListener), this, str2, str));
    }
}
