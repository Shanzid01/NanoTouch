package com.slideme.sam.manager.controller.fragment.p057b;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.slideme.sam.manager.controller.p055b.C1707i;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: WebViewFragment */
class C1747l extends WebViewClient {
    final /* synthetic */ C1746k f3101a;
    private final /* synthetic */ SafeViewFlipper f3102b;

    C1747l(C1746k c1746k, SafeViewFlipper safeViewFlipper) {
        this.f3101a = c1746k;
        this.f3102b = safeViewFlipper;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C1922m.m5797b("SAMWebView", str);
        if (!str.startsWith("http") && !str.startsWith("https")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (!C1707i.m5085a(str, this.f3101a.getActivity())) {
            this.f3101a.f3100b.stopLoading();
            this.f3101a.getActivity().setResult(2);
            this.f3101a.getActivity().finish();
        }
        return false;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.f3102b != null) {
            this.f3102b.setDisplayedChild(1);
        }
        super.onPageFinished(webView, str);
    }
}
