package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1879l;
import com.slideme.sam.manager.net.wrappers.Catalog;

/* compiled from: MyFreeAppsApplicationListFragment */
public class aa extends C1708i {
    protected void mo4257a(Catalog catalog) {
        m5093b(false);
        catalog.m5686f(0);
        catalog.m5684e(true);
        catalog.m5690g(1);
        if (catalog.m5669b() == 0) {
            SAM.f2614g.m5614a(C1879l.FREE, new ab(this, catalog));
        }
    }

    boolean mo4258a() {
        return this.g.m5681e() > 0;
    }
}
