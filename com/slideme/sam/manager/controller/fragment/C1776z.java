package com.slideme.sam.manager.controller.fragment;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: ApplicationDetailsFragment */
class C1776z extends Handler {
    private final WeakReference<C1735a> f3164a;

    public C1776z(C1735a c1735a) {
        this.f3164a = new WeakReference(c1735a);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                int[] intArray = message.getData().getIntArray("KEY_PROGRESS");
                ((C1735a) this.f3164a.get()).m5166a(intArray[0], intArray[1], intArray[2], intArray[3]);
                return;
            case 2001:
                ((C1735a) this.f3164a.get()).f2995g = message.getData().getBoolean("KEY_IS_DOWNLOADING");
                ((C1735a) this.f3164a.get()).m5197k();
                ((C1735a) this.f3164a.get()).f3000l.setEnabled(!((C1735a) this.f3164a.get()).m5208p());
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
