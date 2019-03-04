package com.slideme.sam.manager.controller.fragment.p057b;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: AdProxyWebViewFragment */
class C1740e extends AsyncHttpResponseHandler {
    final /* synthetic */ C1736a f3088a;
    private final /* synthetic */ boolean f3089b;

    C1740e(C1736a c1736a, boolean z) {
        this.f3088a = c1736a;
        this.f3089b = z;
    }

    public void onFailure(Throwable th, String str) {
        C1922m.m5797b("AdProxy", "Failed to report offer health: " + this.f3088a.f3078e + "@" + this.f3088a.f3079f + " - " + String.valueOf(this.f3089b));
        C1922m.m5790a(new Exception(str, th));
    }

    public void onSuccess(String str) {
        C1922m.m5797b("AdProxy", "Reported offer health: " + this.f3088a.f3078e + "@" + this.f3088a.f3079f + " - " + String.valueOf(this.f3089b));
    }
}
