package p006b.p007a.p008a.p009a.p010a.p012b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AdvertisingInfoServiceStrategy */
final class C0211h implements ServiceConnection {
    private boolean f782a;
    private final LinkedBlockingQueue<IBinder> f783b;

    private C0211h() {
        this.f782a = false;
        this.f783b = new LinkedBlockingQueue(1);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f783b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f783b.clear();
    }

    public IBinder m1885a() {
        if (this.f782a) {
            C0326f.m2298h().mo518e("Fabric", "getBinder already called");
        }
        this.f782a = true;
        try {
            return (IBinder) this.f783b.poll(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return null;
        }
    }
}
