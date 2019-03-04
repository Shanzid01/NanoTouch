package com.mopub.common;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.mopub.common.p050b.C1482e;
import com.mopub.common.p050b.C1483f;

/* compiled from: MoPubBrowser */
class C1517y extends WebViewClient {
    final /* synthetic */ MoPubBrowser f2202a;

    C1517y(MoPubBrowser moPubBrowser) {
        this.f2202a = moPubBrowser;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Toast.makeText(this.f2202a, "MoPubBrowser error: " + str, 0).show();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!C1483f.m4067b(str) || !C1483f.m4063a(this.f2202a, intent)) {
            return false;
        }
        this.f2202a.startActivity(intent);
        this.f2202a.finish();
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f2202a.f2129c.setImageDrawable(C1482e.UNRIGHT_ARROW.decodeImage(this.f2202a));
    }

    public void onPageFinished(WebView webView, String str) {
        Drawable decodeImage;
        super.onPageFinished(webView, str);
        if (webView.canGoBack()) {
            decodeImage = C1482e.LEFT_ARROW.decodeImage(this.f2202a);
        } else {
            decodeImage = C1482e.UNLEFT_ARROW.decodeImage(this.f2202a);
        }
        this.f2202a.f2128b.setImageDrawable(decodeImage);
        if (webView.canGoForward()) {
            decodeImage = C1482e.RIGHT_ARROW.decodeImage(this.f2202a);
        } else {
            decodeImage = C1482e.UNRIGHT_ARROW.decodeImage(this.f2202a);
        }
        this.f2202a.f2129c.setImageDrawable(decodeImage);
    }
}
