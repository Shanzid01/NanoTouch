package com.slideme.sam.manager.controller.fragment;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.view.C1950a;

/* compiled from: ApplicationDetailsFragment */
class C1757h implements Runnable {
    final /* synthetic */ C1735a f3127a;
    private final /* synthetic */ int f3128b;
    private final /* synthetic */ int f3129c;
    private final /* synthetic */ int f3130d;
    private final /* synthetic */ int f3131e;

    C1757h(C1735a c1735a, int i, int i2, int i3, int i4) {
        this.f3127a = c1735a;
        this.f3128b = i;
        this.f3129c = i2;
        this.f3130d = i3;
        this.f3131e = i4;
    }

    public void run() {
        if (!this.f3127a.isAdded()) {
            return;
        }
        if (this.f3128b > 0) {
            this.f3127a.f3012x.setMax(this.f3129c);
            if (this.f3127a.f3012x.isIndeterminate()) {
                this.f3127a.f3012x.setIndeterminate(false);
            }
            this.f3127a.f3012x.setProgress(this.f3128b);
            Object string = this.f3127a.getString(R.string.downloading);
            if (this.f3130d > 1) {
                string = new StringBuilder(String.valueOf(string)).append(" (").append(String.valueOf(this.f3131e)).append("/").append(String.valueOf(this.f3130d)).append(") ").toString();
            }
            this.f3127a.f3014z.setText(new StringBuilder(String.valueOf(string)).append(": ").append(C1950a.m5858a((long) this.f3128b)).append("/").append(C1950a.m5858a((long) this.f3127a.f3012x.getMax())).toString());
        } else if (!this.f3127a.f3012x.isIndeterminate()) {
            this.f3127a.f3012x.setIndeterminate(true);
            this.f3127a.f3014z.setText(R.string.download_waiting);
        }
    }
}
