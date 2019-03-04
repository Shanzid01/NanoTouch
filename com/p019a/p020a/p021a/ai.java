package com.p019a.p020a.p021a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* compiled from: SessionEvent */
final class ai {
    public final am f1067a;
    public final long f1068b;
    public final al f1069c;
    public final Map<String, String> f1070d;
    public final String f1071e;
    public final Map<String, Object> f1072f;
    public final String f1073g;
    public final Map<String, Object> f1074h;
    private String f1075i;

    public static ak m2398a(al alVar, Activity activity) {
        return new ak(alVar).m2405a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static ak m2397a() {
        return new ak(al.INSTALL);
    }

    public static ak m2401a(String str) {
        return new ak(al.ERROR).m2405a(Collections.singletonMap("sessionId", str));
    }

    public static ak m2402b(String str) {
        return new ak(al.CRASH).m2405a(Collections.singletonMap("sessionId", str));
    }

    public static ak m2399a(C0359q c0359q) {
        return new ak(al.CUSTOM).m2404a(c0359q.m2485a()).m2407b(c0359q.m2365b());
    }

    public static ak m2400a(C0342w<?> c0342w) {
        return new ak(al.PREDEFINED).m2406b(c0342w.mo533a()).m2408c(c0342w.m2367c()).m2407b(c0342w.m2365b());
    }

    private ai(am amVar, long j, al alVar, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f1067a = amVar;
        this.f1068b = j;
        this.f1069c = alVar;
        this.f1070d = map;
        this.f1071e = str;
        this.f1072f = map2;
        this.f1073g = str2;
        this.f1074h = map3;
    }

    public String toString() {
        if (this.f1075i == null) {
            this.f1075i = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.f1068b + ", type=" + this.f1069c + ", details=" + this.f1070d.toString() + ", customType=" + this.f1071e + ", customAttributes=" + this.f1072f.toString() + ", predefinedType=" + this.f1073g + ", predefinedAttributes=" + this.f1074h.toString() + ", metadata=[" + this.f1067a + "]]";
        }
        return this.f1075i;
    }
}
