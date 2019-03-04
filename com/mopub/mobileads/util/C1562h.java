package com.mopub.mobileads.util;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: WebViews */
class C1562h extends WebChromeClient {
    C1562h() {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Log.d("MoPub - WebViewsUtil", str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Log.d("MoPub - WebViewsUtil", str2);
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Log.d("MoPub - WebViewsUtil", str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        Log.d("MoPub - WebViewsUtil", str2);
        return true;
    }
}
