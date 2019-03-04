package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
final class C0233b implements ThreadFactory {
    private final AtomicInteger f832a = new AtomicInteger(1);

    C0233b() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f832a.getAndIncrement());
    }
}
