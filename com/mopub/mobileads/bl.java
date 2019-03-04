package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.PlacementType;

/* compiled from: MraidProperty */
class bl extends bm {
    private final PlacementType f2455a;

    bl(PlacementType placementType) {
        this.f2455a = placementType;
    }

    public static bl m4586a(PlacementType placementType) {
        return new bl(placementType);
    }

    public String mo4141a() {
        return "placementType: '" + this.f2455a.toString().toLowerCase() + "'";
    }
}
