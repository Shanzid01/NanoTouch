package com.mopub.mobileads.p051a;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

/* compiled from: CustomEventBannerFactory */
public class C1525e {
    private static C1525e f2393a = new C1525e();

    public static CustomEventBanner m4481a(String str) {
        return f2393a.m4482b(str);
    }

    protected CustomEventBanner m4482b(String str) {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventBanner.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (CustomEventBanner) declaredConstructor.newInstance(new Object[0]);
    }
}
