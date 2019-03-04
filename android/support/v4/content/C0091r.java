package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: LocalBroadcastManager */
class C0091r extends Handler {
    final /* synthetic */ C0090q f103a;

    C0091r(C0090q c0090q, Looper looper) {
        this.f103a = c0090q;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f103a.m146a();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
