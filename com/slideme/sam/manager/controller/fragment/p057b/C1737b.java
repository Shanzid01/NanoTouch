package com.slideme.sam.manager.controller.fragment.p057b;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.net.C1867a;
import com.slideme.sam.manager.util.C1920k;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: AdProxyWebViewFragment */
class C1737b extends WebViewClient {
    final /* synthetic */ C1736a f3083a;
    private boolean f3084b = false;
    private final /* synthetic */ SafeViewFlipper f3085c;

    C1737b(C1736a c1736a, SafeViewFlipper safeViewFlipper) {
        this.f3083a = c1736a;
        this.f3085c = safeViewFlipper;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C1922m.m5797b("AdProxy", "--Redirecting to: " + str);
        if (str.startsWith(C1867a.f3350a + "error")) {
            C1920k.m5781a(this.f3083a.getActivity(), (int) R.string.error_occured, 0).show();
            if (this.f3083a.getActivity() != null) {
                this.f3083a.getActivity().finish();
                this.f3083a.getActivity().overridePendingTransition(0, 0);
            }
        }
        if (!str.startsWith("market://") && !str.startsWith("sam://") && !str.startsWith("http://play.google.com") && !str.startsWith("https://play.google.com") && !str.startsWith("http://market.android.com") && !str.startsWith("https://market.android.com")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        try {
            this.f3084b = true;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (this.f3083a.f3076c) {
                intent.addFlags(65536);
                String packageName = this.f3083a.getActivity() != null ? this.f3083a.getActivity().getPackageName() : "com.slideme.sam.manager";
                intent.putExtra("com.slideme.sam.manager.EXTRA_DESTINATION_URL", this.f3083a.f3074a);
                intent.putExtra("com.slideme.sam.manager.EXTRA_ADSLOT_ID", this.f3083a.f3077d);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", this.f3083a.f3078e);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", this.f3083a.f3080g);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", this.f3083a.f3082i);
                intent.setPackage(packageName);
                if (this.f3083a.isAdded()) {
                    C1698a.m5054a(this.f3083a.getActivity(), intent);
                }
            } else {
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
                if (this.f3083a.isAdded()) {
                    this.f3083a.startActivity(intent);
                }
            }
        } catch (ActivityNotFoundException e) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (this.f3083a.isAdded()) {
                    this.f3083a.startActivity(intent2);
                }
            } catch (ActivityNotFoundException e2) {
            }
        }
        if (this.f3083a.getActivity() == null) {
            return true;
        }
        this.f3083a.getActivity().finish();
        this.f3083a.getActivity().overridePendingTransition(0, 0);
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        C1922m.m5797b("AdProxy", "Finished redirect flow: " + str);
        if (this.f3083a.getActivity() != null) {
            if (this.f3084b) {
                this.f3083a.m5275a(this.f3084b);
            } else {
                new Handler().postDelayed(new C1738c(this), 5000);
            }
        } else if (!this.f3083a.f3076c) {
            this.f3085c.setDisplayedChild(1);
        }
        super.onPageFinished(webView, str);
    }
}
