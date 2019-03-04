package com.slideme.sam.manager.net;

import android.content.Context;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.C1871c;

/* compiled from: NetworkUtils */
class C1872e implements C1871c {
    final /* synthetic */ C1867a f3392a;
    private final /* synthetic */ String f3393b;
    private final /* synthetic */ Context f3394c;
    private final /* synthetic */ int f3395d;
    private final /* synthetic */ String f3396e;
    private final /* synthetic */ String f3397f;
    private final /* synthetic */ boolean f3398g;
    private final /* synthetic */ AsyncHttpResponseHandler f3399h;

    C1872e(C1867a c1867a, String str, Context context, int i, String str2, String str3, boolean z, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.f3392a = c1867a;
        this.f3393b = str;
        this.f3394c = context;
        this.f3395d = i;
        this.f3396e = str2;
        this.f3397f = str3;
        this.f3398g = z;
        this.f3399h = asyncHttpResponseHandler;
    }

    public void mo4310a(String str, boolean z) {
        ("everypage".equals(this.f3393b) ? this.f3392a.f3376T : this.f3392a.f3378V).get(C1867a.f3350a, C1888s.m5651a(this.f3394c, this.f3395d, this.f3393b, this.f3396e, this.f3397f, this.f3392a.f3381Z.m4780d(), this.f3398g, str, z), this.f3399h);
    }
}
