package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: EulaDialog */
class C1616g extends WebViewClient {
    final /* synthetic */ C1615f f2699a;
    private final /* synthetic */ AlertDialog f2700b;

    C1616g(C1615f c1615f, AlertDialog alertDialog) {
        this.f2699a = c1615f;
        this.f2700b = alertDialog;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f2700b.getButton(-1).setEnabled(false);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f2700b.getButton(-1).setEnabled(true);
    }
}
