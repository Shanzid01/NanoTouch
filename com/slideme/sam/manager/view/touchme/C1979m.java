package com.slideme.sam.manager.view.touchme;

import android.os.Handler;
import android.os.Message;

/* compiled from: FeaturedLayout */
class C1979m extends Handler {
    final /* synthetic */ FeaturedLayout f3834a;

    C1979m(FeaturedLayout featuredLayout) {
        this.f3834a = featuredLayout;
    }

    public void handleMessage(Message message) {
        if (message.what == -1000 && this.f3834a.f3688c.computeScrollOffset()) {
            this.f3834a.scrollTo(this.f3834a.f3688c.getCurrX(), this.f3834a.f3688c.getCurrY());
            sendMessageDelayed(obtainMessage(-1000), 18);
        }
    }
}
