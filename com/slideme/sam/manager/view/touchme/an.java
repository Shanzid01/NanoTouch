package com.slideme.sam.manager.view.touchme;

import java.util.Comparator;

/* compiled from: SlidingTabSelector */
class an implements Comparator<ap> {
    final /* synthetic */ SlidingTabSelector f3790a;

    an(SlidingTabSelector slidingTabSelector) {
        this.f3790a = slidingTabSelector;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6073a((ap) obj, (ap) obj2);
    }

    public int m6073a(ap apVar, ap apVar2) {
        return apVar.f3793b < apVar2.f3793b ? -1 : 1;
    }
}
