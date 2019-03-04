package com.slideme.sam.manager.controller.activities.market.product;

/* compiled from: TermsActivity */
class C1680f implements Runnable {
    final /* synthetic */ TermsActivity f2855a;
    private final /* synthetic */ boolean f2856b;

    C1680f(TermsActivity termsActivity, boolean z) {
        this.f2855a = termsActivity;
        this.f2856b = z;
    }

    public void run() {
        if (!(this.f2855a.f2838c == null || this.f2855a.f2840e)) {
            if (this.f2856b) {
                this.f2855a.f2838c.show(this.f2855a.getSupportFragmentManager(), "progress");
            } else {
                this.f2855a.f2838c.dismiss();
            }
        }
        this.f2855a.setSupportProgressBarIndeterminateVisibility(this.f2856b);
    }
}
