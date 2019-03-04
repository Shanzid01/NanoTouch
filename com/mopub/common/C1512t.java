package com.mopub.common;

import com.mopub.common.p050b.C1486i;

/* compiled from: HttpClient */
class C1512t implements C1507o {
    C1512t() {
    }

    public void mo4076a(String str, C1505m c1505m) {
        if (c1505m == null || c1505m.m4132b() != 200) {
            C1486i.m4076a("Failed to hit tracking endpoint: " + str);
        } else if (C1514v.m4155b(c1505m) != null) {
            C1486i.m4076a("Successfully hit tracking endpoint: " + str);
        } else {
            C1486i.m4076a("Failed to hit tracking endpoint: " + str);
        }
    }
}
