package com.slideme.sam.manager.controller.fragment;

import android.os.Message;
import java.util.TimerTask;

/* compiled from: ApplicationDetailsFragment */
class C1758i extends TimerTask {
    final /* synthetic */ C1735a f3132a;

    C1758i(C1735a c1735a) {
        this.f3132a = c1735a;
    }

    public void run() {
        if (this.f3132a.f2997i != null && this.f3132a.f2996h != null) {
            try {
                Message obtain = Message.obtain(null, 2000);
                obtain.arg1 = Integer.valueOf(this.f3132a.f2989a.app.nodeId).intValue();
                obtain.replyTo = this.f3132a.f2997i;
                this.f3132a.f2996h.send(obtain);
            } catch (Exception e) {
            }
        }
    }
}
