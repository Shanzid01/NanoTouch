package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.drive.DriveFile;
import java.net.URI;

/* compiled from: MraidView */
class bv extends WebViewClient {
    final /* synthetic */ MraidView f2470a;

    private bv(MraidView mraidView) {
        this.f2470a = mraidView;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Log.d("MraidView", "Error: " + str);
        super.onReceivedError(webView, i, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String scheme = Uri.parse(str).getScheme();
        if ("mopub".equals(scheme)) {
            return true;
        }
        if ("mraid".equals(scheme)) {
            this.f2470a.m4391a(URI.create(str));
            return true;
        } else if (!this.f2470a.wasClicked()) {
            return false;
        } else {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            try {
                this.f2470a.getContext().startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.f2470a.f2357e) {
            this.f2470a.f2355c.m4567c();
            this.f2470a.m4402a(bl.m4586a(this.f2470a.f2359g));
            this.f2470a.m4411f();
            if (this.f2470a.m4409d() != null) {
                this.f2470a.m4409d().onReady(this.f2470a);
            }
            this.f2470a.f2362j = this.f2470a.getVisibility() == 0;
            this.f2470a.m4402a(bw.m4602a(this.f2470a.f2362j));
            this.f2470a.f2357e = true;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        Log.d("MraidView", "Loaded resource: " + str);
    }
}
