package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.PlacementType;
import java.util.Map;

/* compiled from: MraidCommand */
class aw extends ak {
    private static /* synthetic */ int[] f2414c;

    static /* synthetic */ int[] m4524b() {
        int[] iArr = f2414c;
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
            f2414c = iArr;
        }
        return iArr;
    }

    public aw(Map<String, String> map, MraidView mraidView) {
        super(map, mraidView);
    }

    void mo4139a() {
        String b = m4506b("uri");
        if (b == null || b.equals("")) {
            this.b.m4401a(ap.PLAY_VIDEO, "Video can't be played with null or empty URL");
        } else {
            this.b.m4407c().m4565b(b);
        }
    }

    protected boolean mo4140a(PlacementType placementType) {
        switch (m4524b()[placementType.ordinal()]) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return super.mo4140a(placementType);
        }
    }
}
