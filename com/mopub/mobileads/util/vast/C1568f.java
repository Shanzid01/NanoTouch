package com.mopub.mobileads.util.vast;

import org.w3c.dom.Node;

/* compiled from: VastXmlManager */
class C1568f {
    final /* synthetic */ C1566d f2589a;
    private final Node f2590b;

    C1568f(C1566d c1566d, Node node) {
        this.f2589a = c1566d;
        if (node == null) {
            throw new IllegalArgumentException("Media node cannot be null");
        }
        this.f2590b = node;
    }

    Integer m4728a() {
        return C1569g.m4738b(this.f2590b, "width");
    }

    Integer m4729b() {
        return C1569g.m4738b(this.f2590b, "height");
    }

    String m4730c() {
        return C1569g.m4740c(this.f2590b, "type");
    }

    String m4731d() {
        return C1569g.m4732a(this.f2590b);
    }
}
