package com.google.p043a;

import com.google.p043a.p045b.C0726w;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: JsonObject */
public final class C0756z extends C0675w {
    private final C0726w<String, C0675w> f1933a = new C0726w();

    public void m3711a(String str, C0675w c0675w) {
        if (c0675w == null) {
            c0675w = C0755y.f1932a;
        }
        this.f1933a.put(str, c0675w);
    }

    public Set<Entry<String, C0675w>> m3712o() {
        return this.f1933a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0756z) && ((C0756z) obj).f1933a.equals(this.f1933a));
    }

    public int hashCode() {
        return this.f1933a.hashCode();
    }
}
