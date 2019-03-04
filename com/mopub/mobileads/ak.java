package com.mopub.mobileads;

import com.facebook.internal.ServerProtocol;
import com.mopub.mobileads.MraidView.PlacementType;
import java.util.Map;

/* compiled from: MraidCommand */
abstract class ak {
    protected Map<String, String> f2409a;
    protected MraidView f2410b;

    abstract void mo4139a();

    ak(Map<String, String> map, MraidView mraidView) {
        this.f2409a = map;
        this.f2410b = mraidView;
    }

    protected int m4503a(String str) {
        String str2 = (String) this.f2409a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2, 10);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    protected String m4506b(String str) {
        return (String) this.f2409a.get(str);
    }

    protected boolean m4507c(String str) {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(this.f2409a.get(str));
    }

    protected boolean mo4140a(PlacementType placementType) {
        return false;
    }
}
