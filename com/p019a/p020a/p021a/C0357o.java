package com.p019a.p020a.p021a;

import java.io.File;
import java.util.List;
import p006b.p007a.p008a.p009a.p010a.p013c.p014a.C0229b;
import p006b.p007a.p008a.p009a.p010a.p013c.p014a.C0230c;
import p006b.p007a.p008a.p009a.p010a.p013c.p014a.C0231e;
import p006b.p007a.p008a.p009a.p010a.p015d.C0269l;

/* compiled from: AnswersRetryFilesSender */
class C0357o implements C0269l {
    private final af f1132a;
    private final aa f1133b;

    public static C0357o m2479a(af afVar) {
        return new C0357o(afVar, new aa(new C0231e(new C0365y(new C0230c(1000, 8), 0.1d), new C0229b(5))));
    }

    C0357o(af afVar, aa aaVar) {
        this.f1132a = afVar;
        this.f1133b = aaVar;
    }

    public boolean mo538a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f1133b.m2376a(nanoTime)) {
            return false;
        }
        if (this.f1132a.mo538a(list)) {
            this.f1133b.m2375a();
            return true;
        }
        this.f1133b.m2377b(nanoTime);
        return false;
    }
}
