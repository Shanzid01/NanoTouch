package com.p019a.p020a.p021a;

import java.util.Locale;
import java.util.Map;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AnswersEventValidator */
class C0347e {
    final int f1109a;
    final int f1110b;
    boolean f1111c;

    public C0347e(int i, int i2, boolean z) {
        this.f1109a = i;
        this.f1110b = i2;
        this.f1111c = z;
    }

    public String m2451a(String str) {
        if (str.length() <= this.f1110b) {
            return str;
        }
        m2450a(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(this.f1110b)})));
        return str.substring(0, this.f1110b);
    }

    public boolean m2452a(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        m2450a(new NullPointerException(str + " must not be null"));
        return true;
    }

    public boolean m2453a(Map<String, Object> map, String str) {
        if (map.size() < this.f1109a || map.containsKey(str)) {
            return false;
        }
        m2450a(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(this.f1109a)})));
        return true;
    }

    private void m2450a(RuntimeException runtimeException) {
        if (this.f1111c) {
            throw runtimeException;
        }
        C0326f.m2298h().mo519e("Answers", "Invalid user input detected", runtimeException);
    }
}
