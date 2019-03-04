package p006b.p007a.p008a.p009a.p010a.p012b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
final class C0223w implements ThreadFactory {
    final /* synthetic */ String f791a;
    final /* synthetic */ AtomicLong f792b;

    C0223w(String str, AtomicLong atomicLong) {
        this.f791a = str;
        this.f792b = atomicLong;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(new C0224x(this, runnable));
        newThread.setName(this.f791a + this.f792b.getAndIncrement());
        return newThread;
    }
}
