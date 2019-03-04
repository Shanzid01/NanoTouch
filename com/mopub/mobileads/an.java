package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.PlacementType;
import java.util.Map;

/* compiled from: MraidCommand */
class an extends ak {
    private static /* synthetic */ int[] f2411c;

    static /* synthetic */ int[] m4511b() {
        int[] iArr = f2411c;
        if (iArr == null) {
            iArr = new int[PlacementType.values().length];
            try {
                iArr[PlacementType.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PlacementType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f2411c = iArr;
        }
        return iArr;
    }

    an(Map<String, String> map, MraidView mraidView) {
        super(map, mraidView);
    }

    void mo4139a() {
        int a = m4503a("w");
        int a2 = m4503a("h");
        String b = m4506b("url");
        boolean c = m4507c("shouldUseCustomClose");
        boolean c2 = m4507c("lockOrientation");
        if (a <= 0) {
            a = this.b.m4407c().f2417b;
        }
        if (a2 <= 0) {
            a2 = this.b.m4407c().f2418c;
        }
        this.b.m4407c().m4561a(b, a, a2, c, c2);
    }

    protected boolean mo4140a(PlacementType placementType) {
        switch (m4511b()[placementType.ordinal()]) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return super.mo4140a(placementType);
        }
    }
}
