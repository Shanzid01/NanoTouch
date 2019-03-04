package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.tags.ResourcesTag;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import java.util.Iterator;

/* compiled from: AdProxyApplicationsListFragment */
class C1712b extends C1600v {
    final /* synthetic */ C1709a f2944a;

    C1712b(C1709a c1709a) {
        this.f2944a = c1709a;
    }

    public void mo4234b() {
        if (this.f2944a.g.m5693i().size() == 0) {
            this.f2944a.mo4260a(false);
        }
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        if (this.f2944a.f2918i != null && this.f2944a.g != null) {
            this.f2944a.m5102a(this.f2944a.g.m5693i());
            boolean c = SAM.f2615h.m5512c();
            Iterator it = this.f2944a.g.m5693i().iterator();
            while (it.hasNext()) {
                Application application = (Application) it.next();
                AdProxyItem adProxyItem = (AdProxyItem) this.f2944a.f2920k.get(application.packageName);
                if (adProxyItem != null) {
                    application.payout = adProxyItem.payout;
                    if (c && adProxyItem.rating > 0.0d) {
                        application.rating = adProxyItem.rating * 20.0d;
                    }
                }
            }
            if (this.f2944a.f2918i.size() > this.f2944a.g.m5693i().size() && SAM.f2615h.m5512c() && this.f2944a.f2920k != null) {
                Iterator it2 = this.f2944a.f2918i.iterator();
                while (it2.hasNext()) {
                    AdProxyItem adProxyItem2 = (AdProxyItem) it2.next();
                    if (!this.f2944a.f2919j.containsKey(adProxyItem2.packageName)) {
                        Application application2 = new Application();
                        application2.packageName = adProxyItem2.packageName;
                        application2.name = adProxyItem2.name;
                        ResourcesTag resourcesTag = new ResourcesTag();
                        resourcesTag.icon = adProxyItem2.image;
                        application2.resources = resourcesTag;
                        application2.organization = "";
                        application2.vendor = "";
                        application2.payout = adProxyItem2.payout;
                        application2.rating = adProxyItem2.rating * 20.0d;
                        this.f2944a.g.m5693i().add(application2);
                    }
                }
            }
            this.f2944a.d.notifyDataSetChanged();
        }
    }

    public void mo4231a() {
        this.f2944a.mo4260a(true);
    }
}
