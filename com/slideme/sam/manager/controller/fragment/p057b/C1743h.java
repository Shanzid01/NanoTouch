package com.slideme.sam.manager.controller.fragment.p057b;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.controller.p055b.C1707i;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: WebBuyFragment */
class C1743h extends WebViewClient {
    final /* synthetic */ C1742g f3095a;
    private final /* synthetic */ SafeViewFlipper f3096b;

    C1743h(C1742g c1742g, SafeViewFlipper safeViewFlipper) {
        this.f3095a = c1742g;
        this.f3096b = safeViewFlipper;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            String host = new URI(str).getHost();
            if (!(str.startsWith(this.f3095a.f3092a) || this.f3095a.f3094c.equals(host))) {
                this.f3095a.f3094c = host;
                C0345b.m2427c().m2437a((C0359q) ((C0359q) new C0359q("Purchase option selected").m2364a("type", this.f3095a.f3094c)).m2364a("id", this.f3095a.getArguments().getString("com.slideme.sam.manager.EXTRA_APP_NID")));
            }
        } catch (URISyntaxException e) {
        }
        C1922m.m5797b("WebBuyFragment", str);
        if (str.startsWith("http") || str.startsWith("https")) {
            if (!C1707i.m5085a(str, this.f3095a.getActivity())) {
                this.f3095a.f3093b.stopLoading();
                this.f3095a.getActivity().setResult(2);
                this.f3095a.getActivity().finish();
            } else if (str.contains("sam=cancel")) {
                C1922m.m5797b("WebBuyFragment", "Operation cancelled.");
                this.f3095a.f3093b.stopLoading();
                this.f3095a.getActivity().setResult(0);
                this.f3095a.getActivity().finish();
            } else if (str.contains("/download")) {
                C1922m.m5797b("WebBuyFragment", "Directed to download");
                this.f3095a.f3093b.stopLoading();
                int indexOf = str.indexOf("token=");
                if (indexOf > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("com.slideme.sam.manager.RESULT_WEBBUY_TOKEN", str.substring(indexOf + 6));
                    this.f3095a.getActivity().setResult(-1, intent);
                    this.f3095a.getActivity().finish();
                } else {
                    C1922m.m5797b("WebBuyFragment", "Returned from WebBUY without token");
                }
            }
            return false;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent2.addCategory("android.intent.category.BROWSABLE");
        intent2.putExtra("com.android.browser.application_id", this.f3095a.getActivity().getPackageName());
        try {
            this.f3095a.getActivity().startActivity(intent2);
            return true;
        } catch (ActivityNotFoundException e2) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.f3096b != null) {
            this.f3096b.setDisplayedChild(1);
        }
        super.onPageFinished(webView, str);
    }
}
