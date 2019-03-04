package com.mopub.mobileads.util.vast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Node;

/* compiled from: VastXmlManager */
class C1567e {
    final /* synthetic */ C1566d f2587a;
    private final Node f2588b;

    C1567e(C1566d c1566d, Node node) {
        this.f2587a = c1566d;
        if (node == null) {
            throw new IllegalArgumentException("Companion node cannot be null");
        }
        this.f2588b = node;
    }

    Integer m4722a() {
        return C1569g.m4738b(this.f2588b, "width");
    }

    Integer m4723b() {
        return C1569g.m4738b(this.f2588b, "height");
    }

    String m4724c() {
        return C1569g.m4740c(C1569g.m4735a(this.f2588b, "StaticResource"), "creativeType");
    }

    String m4725d() {
        return C1569g.m4732a(C1569g.m4735a(this.f2588b, "StaticResource"));
    }

    String m4726e() {
        return C1569g.m4732a(C1569g.m4735a(this.f2588b, "CompanionClickThrough"));
    }

    List<String> m4727f() {
        List<String> arrayList = new ArrayList();
        Node a = C1569g.m4735a(this.f2588b, "TrackingEvents");
        if (a == null) {
            return arrayList;
        }
        for (Node a2 : C1569g.m4739b(a2, "Tracking", "event", Arrays.asList(new String[]{"creativeView"}))) {
            if (a2.getFirstChild() != null) {
                arrayList.add(a2.getFirstChild().getNodeValue().trim());
            }
        }
        return arrayList;
    }
}
