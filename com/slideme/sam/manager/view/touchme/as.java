package com.slideme.sam.manager.view.touchme;

/* compiled from: SlidingTabSelector */
class as implements Runnable {
    final /* synthetic */ ar f3805a;

    as(ar arVar) {
        this.f3805a = arVar;
    }

    public void run() {
        if (this.f3805a.f3802h.m6100e()) {
            this.f3805a.m6086c();
            this.f3805a.f3795a.invalidate();
            this.f3805a.f3803i.postDelayed(this.f3805a.f3804j, 16);
            return;
        }
        this.f3805a.m6078a(this.f3805a.f3802h.f3806a);
        this.f3805a.f3795a.invalidate();
    }
}
