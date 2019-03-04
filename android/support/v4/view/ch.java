package android.support.v4.view;

/* compiled from: ViewPager */
class ch implements Runnable {
    final /* synthetic */ ViewPager f234a;

    ch(ViewPager viewPager) {
        this.f234a = viewPager;
    }

    public void run() {
        this.f234a.setScrollState(0);
        this.f234a.m197d();
    }
}
