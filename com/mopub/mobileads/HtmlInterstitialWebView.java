package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import com.mopub.common.p050b.C1493p;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public class HtmlInterstitialWebView extends BaseHtmlWebView {
    private Handler f2315b = new Handler();

    interface MoPubUriJavascriptFireFinishLoadListener {
        void onInterstitialLoaded();
    }

    public HtmlInterstitialWebView(Context context, AdConfiguration adConfiguration) {
        super(context, adConfiguration);
    }

    public void m4320a(CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2) {
        super.m4278a(z);
        setWebViewClient(new C1572x(new C1571w(customEventInterstitialListener), this, str2, str));
        m4321a(new C1554u(this, customEventInterstitialListener));
    }

    void m4321a(MoPubUriJavascriptFireFinishLoadListener moPubUriJavascriptFireFinishLoadListener) {
        addJavascriptInterface(new C1570v(this, moPubUriJavascriptFireFinishLoadListener), "mopubUriInterface");
    }

    @TargetApi(11)
    public void destroy() {
        if (C1493p.currentApiLevel().isAtLeast(C1493p.HONEYCOMB)) {
            removeJavascriptInterface("mopubUriInterface");
        }
        super.destroy();
    }
}
