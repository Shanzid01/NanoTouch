package com.slideme.sam.manager.controller.fragment;

import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;

/* compiled from: ApplicationDetailsFragment */
class C1766p implements Runnable {
    final /* synthetic */ C1735a f3145a;

    C1766p(C1735a c1735a) {
        this.f3145a = c1735a;
    }

    public void run() {
        if (this.f3145a.getActivity() != null) {
            ((FlipperFragmentActivity) this.f3145a.getActivity()).m4792a(3);
        }
    }
}
