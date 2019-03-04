package com.slideme.sam.manager;

import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.dynamic.child.AdProxyChild;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONArray;

/* compiled from: SAM */
class C1780g implements Runnable {
    final /* synthetic */ SAM f3170a;
    private final /* synthetic */ StringBuilder f3171b;
    private final /* synthetic */ JSONArray f3172c;
    private final /* synthetic */ ArrayList f3173d;
    private final /* synthetic */ String f3174e;
    private final /* synthetic */ C1700p f3175f;

    C1780g(SAM sam, StringBuilder stringBuilder, JSONArray jSONArray, ArrayList arrayList, String str, C1700p c1700p) {
        this.f3170a = sam;
        this.f3171b = stringBuilder;
        this.f3172c = jSONArray;
        this.f3173d = arrayList;
        this.f3174e = str;
        this.f3175f = c1700p;
    }

    public void run() {
        C1891a c1891a = new C1891a(this.f3171b.toString(), true, true, SAM.m4761a().getString(R.string.live_channel), this.f3172c.length());
        c1891a.m5698b();
        if (c1891a.m5697a() == null || c1891a.m5697a().isEmpty()) {
            C1922m.m5797b("AdProxy", "Failed to populate offers hashtable");
            if (this.f3175f != null) {
                this.f3175f.mo4255a(new Hashtable(), false);
                return;
            }
            return;
        }
        C1922m.m5797b("AdProxy", "Populating offers hashtable");
        for (int i = 0; i < this.f3173d.size(); i++) {
            Application a = C1827a.m5492a(c1891a.m5697a(), ((AdProxyItem) this.f3173d.get(i)).packageName);
            if (a != null) {
                AdProxyChild adProxyChild = new AdProxyChild();
                adProxyChild.clickUrl = ((AdProxyItem) this.f3173d.get(i)).clickUrl;
                adProxyChild.promoUrl = a.promoIcon;
                adProxyChild.samAvailable = ((AdProxyItem) this.f3173d.get(i)).samAvailable;
                adProxyChild.uid = a.bundleId;
                adProxyChild.packageName = ((AdProxyItem) this.f3173d.get(i)).packageName;
                adProxyChild.versionCode = a.versionCode;
                adProxyChild.adslotId = this.f3174e;
                adProxyChild.payout = ((AdProxyItem) this.f3173d.get(i)).payout;
                adProxyChild.network = ((AdProxyItem) this.f3173d.get(i)).network;
                adProxyChild.offerId = ((AdProxyItem) this.f3173d.get(i)).offerId;
                adProxyChild.platform = ((AdProxyItem) this.f3173d.get(i)).platform;
                this.f3170a.f2632w.put(((AdProxyItem) this.f3173d.get(i)).packageName, adProxyChild);
            }
        }
        if (this.f3175f != null) {
            this.f3175f.mo4255a(this.f3170a.f2632w, false);
        }
    }
}
