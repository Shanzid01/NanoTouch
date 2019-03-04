package com.p019a.p020a.p021a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AnswersAttributes */
class C0346c {
    final C0347e f1107a;
    final Map<String, Object> f1108b = new HashMap();

    public C0346c(C0347e c0347e) {
        this.f1107a = c0347e;
    }

    void m2449a(String str, String str2) {
        if (!this.f1107a.m2452a((Object) str, "key") && !this.f1107a.m2452a((Object) str2, "value")) {
            m2448a(this.f1107a.m2451a(str), this.f1107a.m2451a(str2));
        }
    }

    void m2447a(String str, Number number) {
        if (!this.f1107a.m2452a((Object) str, "key") && !this.f1107a.m2452a((Object) number, "value")) {
            m2448a(this.f1107a.m2451a(str), (Object) number);
        }
    }

    void m2448a(String str, Object obj) {
        if (!this.f1107a.m2453a(this.f1108b, str)) {
            this.f1108b.put(str, obj);
        }
    }

    public String toString() {
        return new JSONObject(this.f1108b).toString();
    }
}
