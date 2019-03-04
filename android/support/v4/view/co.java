package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: ViewPager */
class co extends DataSetObserver {
    final /* synthetic */ ViewPager f241a;

    private co(ViewPager viewPager) {
        this.f241a = viewPager;
    }

    public void onChanged() {
        this.f241a.m195c();
    }

    public void onInvalidated() {
        this.f241a.m195c();
    }
}
