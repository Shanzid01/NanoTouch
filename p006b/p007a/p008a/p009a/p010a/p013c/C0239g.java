package p006b.p007a.p008a.p009a.p010a.p013c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: AsyncTask */
class C0239g extends Handler {
    public C0239g() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        C0238f c0238f = (C0238f) message.obj;
        switch (message.what) {
            case 1:
                c0238f.f837a.m1985e(c0238f.f838b[0]);
                return;
            case 2:
                c0238f.f837a.m1992b(c0238f.f838b);
                return;
            default:
                return;
        }
    }
}
