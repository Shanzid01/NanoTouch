package p006b.p007a.p008a.p009a.p010a.p012b;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
public class ak {
    private final String f769a;
    private final String f770b;
    private final boolean f771c;
    private long f772d;
    private long f773e;

    public ak(String str, String str2) {
        this.f769a = str;
        this.f770b = str2;
        this.f771c = !Log.isLoggable(str2, 2);
    }

    public synchronized void m1864a() {
        if (!this.f771c) {
            this.f772d = SystemClock.elapsedRealtime();
            this.f773e = 0;
        }
    }

    public synchronized void m1865b() {
        if (!this.f771c) {
            if (this.f773e == 0) {
                this.f773e = SystemClock.elapsedRealtime() - this.f772d;
                m1863c();
            }
        }
    }

    private void m1863c() {
        Log.v(this.f770b, this.f769a + ": " + this.f773e + "ms");
    }
}
