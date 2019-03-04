package com.slideme.sam.manager.controller.fragment.p056a;

import com.google.android.gms.actions.SearchIntents;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.ad;
import com.slideme.sam.manager.net.wrappers.Catalog;

/* compiled from: SearchApplicationListFragment */
public class af extends C1710s {
    protected void mo4257a(Catalog catalog) {
        catalog.m5671b(getArguments().getString(SearchIntents.EXTRA_QUERY));
        C0345b.m2427c().m2432a(new ad().m2380a(getArguments().getString(SearchIntents.EXTRA_QUERY)));
        super.mo4257a(catalog);
    }
}
