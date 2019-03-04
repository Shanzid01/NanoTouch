package com.mopub.mobileads.p051a;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;

/* compiled from: CustomEventInterstitialFactory */
public class C1527g {
    private static C1527g f2395a = new C1527g();

    public static CustomEventInterstitial m4485a(String str) {
        return f2395a.m4486b(str);
    }

    protected CustomEventInterstitial m4486b(String str) {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (CustomEventInterstitial) declaredConstructor.newInstance(new Object[0]);
    }
}
