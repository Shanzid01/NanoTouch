package com.mopub.mobileads.p051a;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

/* compiled from: AdViewControllerFactory */
public class C1523c {
    protected static C1523c f2391a = new C1523c();

    public static AdViewController m4477a(Context context, MoPubView moPubView) {
        return f2391a.m4478b(context, moPubView);
    }

    protected AdViewController m4478b(Context context, MoPubView moPubView) {
        return new AdViewController(context, moPubView);
    }
}
