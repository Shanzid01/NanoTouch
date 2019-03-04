package com.mopub.mobileads.util.vast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VastCompanionAd */
public class C1563a implements Serializable {
    private static final long serialVersionUID = 0;
    private final Integer f2568a;
    private final Integer f2569b;
    private final String f2570c;
    private final String f2571d;
    private final ArrayList<String> f2572e;

    public C1563a(Integer num, Integer num2, String str, String str2, ArrayList<String> arrayList) {
        this.f2568a = num;
        this.f2569b = num2;
        this.f2570c = str;
        this.f2571d = str2;
        this.f2572e = arrayList;
    }

    public String m4684a() {
        return this.f2570c;
    }

    public String m4685b() {
        return this.f2571d;
    }

    public List<String> m4686c() {
        return this.f2572e;
    }
}
