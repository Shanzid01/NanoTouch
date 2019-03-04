package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.PlacementType;
import java.util.Map;

/* compiled from: MraidCommand */
class av extends ak {
    av(Map<String, String> map, MraidView mraidView) {
        super(map, mraidView);
    }

    void mo4139a() {
        String b = m4506b("url");
        if (b == null) {
            this.b.m4401a(ap.OPEN, "Url can not be null.");
        } else {
            this.b.m4405b().m4499a(b);
        }
    }

    protected boolean mo4140a(PlacementType placementType) {
        return true;
    }
}
