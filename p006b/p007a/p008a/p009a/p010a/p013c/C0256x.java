package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.concurrent.ThreadFactory;

/* compiled from: PriorityThreadPoolExecutor */
public final class C0256x implements ThreadFactory {
    private final int f856a;

    public C0256x(int i) {
        this.f856a = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.f856a);
        thread.setName("Queue");
        return thread;
    }
}
