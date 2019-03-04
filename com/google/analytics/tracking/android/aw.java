package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

/* compiled from: MetaModel */
class aw {
    private Map<String, ay> f2014a = new HashMap();

    aw() {
    }

    ay m3824a(String str) {
        if (str.startsWith("&")) {
            return new ay(str.substring(1), null, null);
        }
        if (str.contains("*")) {
            str = str.substring(0, str.indexOf("*"));
        }
        return (ay) this.f2014a.get(str);
    }

    public void m3825a(String str, String str2, String str3, ax axVar) {
        this.f2014a.put(str, new ay(str2, str3, axVar));
    }
}
