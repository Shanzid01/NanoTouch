package com.slideme.sam.manager.controller.activities.market.product;

/* compiled from: TermsActivity */
class C1692q implements Runnable {
    final /* synthetic */ C1691p f2870a;

    C1692q(C1691p c1691p) {
        this.f2870a = c1691p;
    }

    public void run() {
        if (this.f2870a.f2869a.f2837b.app.token == null) {
            this.f2870a.f2869a.m4990a(C1693r.UNPURCHASED);
        } else {
            this.f2870a.f2869a.m4990a(C1693r.PURCHASED);
        }
        this.f2870a.f2869a.m4995c(false);
    }
}
