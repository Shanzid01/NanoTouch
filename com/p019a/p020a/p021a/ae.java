package com.p019a.p020a.p021a;

import android.content.Context;
import java.util.UUID;
import p006b.p007a.p008a.p009a.p010a.p012b.C0202s;
import p006b.p007a.p008a.p009a.p010a.p015d.C0264d;
import p006b.p007a.p008a.p009a.p010a.p015d.C0267h;
import p006b.p007a.p008a.p009a.p010a.p018g.C0295b;

/* compiled from: SessionAnalyticsFilesManager */
class ae extends C0264d<ai> {
    private C0295b f1064g;

    ae(Context context, an anVar, C0202s c0202s, C0267h c0267h) {
        super(context, anVar, c0202s, c0267h, 100);
    }

    protected String mo535a() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.c.mo466a() + ".tap";
    }

    protected int mo536b() {
        return this.f1064g == null ? super.mo536b() : this.f1064g.f921e;
    }

    protected int mo537c() {
        return this.f1064g == null ? super.mo537c() : this.f1064g.f919c;
    }

    void m2383a(C0295b c0295b) {
        this.f1064g = c0295b;
    }
}
