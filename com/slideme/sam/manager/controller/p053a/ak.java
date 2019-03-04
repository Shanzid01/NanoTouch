package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: TermsAndConditionsDialog */
class ak extends WebViewClient {
    final /* synthetic */ aj f2686a;
    private final /* synthetic */ AlertDialog f2687b;

    ak(aj ajVar, AlertDialog alertDialog) {
        this.f2686a = ajVar;
        this.f2687b = alertDialog;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            this.f2687b.getButton(-1).setEnabled(false);
        } catch (NullPointerException e) {
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        try {
            this.f2687b.getButton(-1).setEnabled(true);
        } catch (NullPointerException e) {
        }
    }
}
