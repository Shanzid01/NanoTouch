package com.slideme.sam.manager.controller.activities;

/* compiled from: SamUpdateActivity */
class C1655c implements Runnable {
    final /* synthetic */ SamUpdateActivity f2784a;
    private final /* synthetic */ int f2785b;

    C1655c(SamUpdateActivity samUpdateActivity, int i) {
        this.f2784a = samUpdateActivity;
        this.f2785b = i;
    }

    public void run() {
        this.f2784a.f2734a.setProgress(this.f2785b);
        this.f2784a.f2735b.setText(this.f2785b + " %");
    }
}
