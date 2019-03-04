package com.mopub.mobileads.util;

import android.webkit.WebView;

/* compiled from: WebViews */
public class C1561g {
    public static void m4671a(WebView webView) {
        try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
        }
    }

    public static void m4672b(WebView webView) {
        try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
        }
    }

    public static void m4673c(WebView webView) {
        webView.setWebChromeClient(new C1562h());
    }
}
