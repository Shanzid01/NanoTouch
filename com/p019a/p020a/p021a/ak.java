package com.p019a.p020a.p021a;

import java.util.Collections;
import java.util.Map;

/* compiled from: SessionEvent */
class ak {
    final al f1076a;
    final long f1077b = System.currentTimeMillis();
    Map<String, String> f1078c = Collections.emptyMap();
    String f1079d = null;
    Map<String, Object> f1080e = Collections.emptyMap();
    String f1081f = null;
    Map<String, Object> f1082g = Collections.emptyMap();

    public ak(al alVar) {
        this.f1076a = alVar;
    }

    public ak m2405a(Map<String, String> map) {
        this.f1078c = map;
        return this;
    }

    public ak m2404a(String str) {
        this.f1079d = str;
        return this;
    }

    public ak m2407b(Map<String, Object> map) {
        this.f1080e = map;
        return this;
    }

    public ak m2406b(String str) {
        this.f1081f = str;
        return this;
    }

    public ak m2408c(Map<String, Object> map) {
        this.f1082g = map;
        return this;
    }

    public ai m2403a(am amVar) {
        return new ai(amVar, this.f1077b, this.f1076a, this.f1078c, this.f1079d, this.f1080e, this.f1081f, this.f1082g);
    }
}
