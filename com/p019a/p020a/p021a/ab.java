package com.p019a.p020a.p021a;

import java.util.Set;

/* compiled from: SamplingEventFilter */
class ab implements C0344t {
    static final Set<al> f1062b = new ac();
    final int f1063a;

    public ab(int i) {
        this.f1063a = i;
    }

    public boolean mo534a(ai aiVar) {
        boolean z;
        if (f1062b.contains(aiVar.f1069c) && aiVar.f1067a.f1089g == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(aiVar.f1067a.f1085c.hashCode() % this.f1063a) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
