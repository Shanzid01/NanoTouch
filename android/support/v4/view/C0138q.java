package android.support.v4.view;

import android.os.Handler;
import android.os.Message;

/* compiled from: GestureDetectorCompat */
class C0138q extends Handler {
    final /* synthetic */ C0137p f285a;

    C0138q(C0137p c0137p) {
        this.f285a = c0137p;
    }

    C0138q(C0137p c0137p, Handler handler) {
        this.f285a = c0137p;
        super(handler.getLooper());
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f285a.f269i.onShowPress(this.f285a.f276p);
                return;
            case 2:
                this.f285a.m906d();
                return;
            case 3:
                if (this.f285a.f270j == null) {
                    return;
                }
                if (this.f285a.f271k) {
                    this.f285a.f272l = true;
                    return;
                } else {
                    this.f285a.f270j.onSingleTapConfirmed(this.f285a.f276p);
                    return;
                }
            default:
                throw new RuntimeException("Unknown message " + message);
        }
    }
}
