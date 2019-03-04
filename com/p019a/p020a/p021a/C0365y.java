package com.p019a.p020a.p021a;

import java.util.Random;
import p006b.p007a.p008a.p009a.p010a.p013c.p014a.C0227a;

/* compiled from: RandomBackoff */
class C0365y implements C0227a {
    final C0227a f1144a;
    final Random f1145b;
    final double f1146c;

    public C0365y(C0227a c0227a, double d) {
        this(c0227a, d, new Random());
    }

    public C0365y(C0227a c0227a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c0227a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.f1144a = c0227a;
            this.f1146c = d;
            this.f1145b = random;
        }
    }

    public long mo469a(int i) {
        return (long) (m2503a() * ((double) this.f1144a.mo469a(i)));
    }

    double m2503a() {
        double d = 1.0d - this.f1146c;
        return d + (((this.f1146c + 1.0d) - d) * this.f1145b.nextDouble());
    }
}
