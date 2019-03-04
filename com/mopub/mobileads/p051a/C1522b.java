package com.mopub.mobileads.p051a;

import com.mopub.mobileads.AdFetcher;
import com.mopub.mobileads.AdViewController;

/* compiled from: AdFetcherFactory */
public class C1522b {
    protected static C1522b f2390a = new C1522b();

    public static AdFetcher m4475a(AdViewController adViewController, String str) {
        return f2390a.m4476b(adViewController, str);
    }

    protected AdFetcher m4476b(AdViewController adViewController, String str) {
        return new AdFetcher(adViewController, str);
    }
}
