package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.MyAppsResponse;
import com.slideme.sam.manager.net.wrappers.Catalog;
import java.util.ArrayList;

/* compiled from: MyFreeAppsApplicationListFragment */
class ab extends C1600v {
    final /* synthetic */ aa f2922a;
    private final /* synthetic */ Catalog f2923b;

    ab(aa aaVar, Catalog catalog) {
        this.f2922a = aaVar;
        this.f2923b = catalog;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        ArrayList arrayList = ((MyAppsResponse) baseNetworkResponse).myApps;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.f2923b.m5673c();
        this.f2923b.m5667a(strArr);
        this.f2923b.m5685f();
    }
}
