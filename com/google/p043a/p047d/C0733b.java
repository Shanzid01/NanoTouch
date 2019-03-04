package com.google.p043a.p047d;

import com.google.p043a.p045b.C0724u;
import com.google.p043a.p045b.p046a.C0684h;

/* compiled from: JsonReader */
final class C0733b extends C0724u {
    C0733b() {
    }

    public void mo1159a(C0683a c0683a) {
        if (c0683a instanceof C0684h) {
            ((C0684h) c0683a).mo1139o();
            return;
        }
        int a = c0683a.f1716i;
        if (a == 0) {
            a = c0683a.mo1139o();
        }
        if (a == 13) {
            c0683a.f1716i = 9;
        } else if (a == 12) {
            c0683a.f1716i = 8;
        } else if (a == 14) {
            c0683a.f1716i = 10;
        } else {
            throw new IllegalStateException("Expected a name but was " + c0683a.mo1130f() + " " + " at line " + c0683a.m3447v() + " column " + c0683a.m3448w() + " path " + c0683a.m3468q());
        }
    }
}
