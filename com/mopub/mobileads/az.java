package com.mopub.mobileads;

import android.util.Log;
import com.mopub.mobileads.MraidView.PlacementType;
import java.util.Map;

/* compiled from: MraidCommand */
class az extends ak {
    public az(Map<String, String> map, MraidView mraidView) {
        super(map, mraidView);
    }

    void mo4139a() {
        String b = m4506b("uri");
        if (b == null || b.equals("")) {
            this.b.m4401a(ap.STORE_PICTURE, "Image can't be stored with null or empty URL");
            Log.d("MoPub", "Invalid URI for Mraid Store Picture.");
            return;
        }
        this.b.m4407c().m4560a(b);
    }

    protected boolean mo4140a(PlacementType placementType) {
        return true;
    }
}
