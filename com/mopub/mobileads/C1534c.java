package com.mopub.mobileads;

import java.lang.ref.WeakReference;
import org.apache.http.HttpResponse;

/* compiled from: AdLoadTask */
abstract class C1534c {
    WeakReference<AdViewController> f2488a;

    abstract void mo4142a();

    abstract void mo4143b();

    C1534c(AdViewController adViewController) {
        this.f2488a = new WeakReference(adViewController);
    }

    static C1534c m4625a(HttpResponse httpResponse, AdViewController adViewController) {
        return new C1537f(httpResponse, adViewController).m4647a();
    }
}
