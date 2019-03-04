package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.p050b.C1483f;
import com.mopub.mobileads.util.C1560f;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;

/* compiled from: HtmlWebViewClient */
class C1572x extends WebViewClient {
    private final Context f2594a;
    private HtmlWebViewListener f2595b;
    private BaseHtmlWebView f2596c;
    private final String f2597d;
    private final String f2598e;

    C1572x(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView baseHtmlWebView, String str, String str2) {
        this.f2595b = htmlWebViewListener;
        this.f2596c = baseHtmlWebView;
        this.f2597d = str;
        this.f2598e = str2;
        this.f2594a = baseHtmlWebView.getContext();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!(m4743b(str) || m4745d(str) || m4747f(str))) {
            Log.d("MoPub", "Ad clicked. Click URL: " + str);
            if (!(!m4748g(str) && C1483f.m4064a(this.f2594a, str) && m4749h(str))) {
                m4750i(str);
            }
        }
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f2598e != null && str.startsWith(this.f2598e)) {
            webView.stopLoading();
            m4750i(str);
        }
    }

    private boolean m4742a(String str) {
        return str.startsWith("mopub://");
    }

    private boolean m4743b(String str) {
        if (!m4742a(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if ("finishLoad".equals(host)) {
            this.f2595b.onLoaded(this.f2596c);
        } else if ("close".equals(host)) {
            this.f2595b.onCollapsed();
        } else if ("failLoad".equals(host)) {
            this.f2595b.onFailed(MoPubErrorCode.UNSPECIFIED);
        } else if ("custom".equals(host)) {
            m4741a(parse);
        }
        return true;
    }

    private boolean m4744c(String str) {
        return str.startsWith("tel:") || str.startsWith("voicemail:") || str.startsWith("sms:") || str.startsWith("mailto:") || str.startsWith("geo:") || str.startsWith("google.streetview:");
    }

    private boolean m4745d(String str) {
        if (!m4744c(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        m4751a(this.f2594a, intent, "Could not handle intent with URI: " + str + ". Is this intent supported on your phone?");
        return true;
    }

    private boolean m4746e(String str) {
        return str.startsWith("mopubnativebrowser://");
    }

    private boolean m4747f(String str) {
        if (!m4746e(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        try {
            String queryParameter = parse.getQueryParameter("url");
            if (!"navigate".equals(parse.getHost()) || queryParameter == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            m4751a(this.f2594a, intent, "Could not handle intent with URI: " + str + ". Is this intent supported on your phone?");
            return true;
        } catch (UnsupportedOperationException e) {
            Log.w("MoPub", "Could not handle url: " + str);
            return false;
        }
    }

    private boolean m4748g(String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }

    private boolean m4749h(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        return m4751a(this.f2594a, intent, "Unable to open intent.");
    }

    private void m4750i(String str) {
        if (str == null || str.equals("")) {
            str = "about:blank";
        }
        Log.d("MoPub", "Final URI to show in browser: " + str);
        Intent intent = new Intent(this.f2594a, MoPubBrowser.class);
        intent.putExtra(LayoutTagTable.URL, str);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        String str2 = "Could not handle intent action. . Perhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.";
        intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        m4751a(this.f2594a, intent, null);
    }

    private void m4741a(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter("fnc");
            String queryParameter2 = uri.getQueryParameter("data");
            Intent intent = new Intent(queryParameter);
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.putExtra("com.mopub.intent.extra.AD_CLICK_DATA", queryParameter2);
            m4751a(this.f2594a, intent, "Could not handle custom intent: " + queryParameter + ". Is your intent spelled correctly?");
        } catch (UnsupportedOperationException e) {
            Log.w("MoPub", "Could not handle custom intent with uri: " + uri);
        }
    }

    boolean m4751a(Context context, Intent intent, String str) {
        if (!this.f2596c.wasClicked()) {
            return false;
        }
        boolean a = C1560f.m4670a(context, intent, str);
        if (!a) {
            return a;
        }
        this.f2595b.onClicked();
        this.f2596c.onResetUserClick();
        return a;
    }
}
