package p006b.p007a.p008a.p009a.p010a.p012b;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable */
public abstract class C0205l implements Runnable {
    protected abstract void mo467a();

    public final void run() {
        Process.setThreadPriority(10);
        mo467a();
    }
}
