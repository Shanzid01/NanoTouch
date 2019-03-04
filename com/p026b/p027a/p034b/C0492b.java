package com.p026b.p027a.p034b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultConfigurationFactory */
class C0492b implements ThreadFactory {
    private static final AtomicInteger f1448a = new AtomicInteger(1);
    private final ThreadGroup f1449b;
    private final AtomicInteger f1450c = new AtomicInteger(1);
    private final String f1451d;
    private final int f1452e;

    C0492b(int i) {
        this.f1452e = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.f1449b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f1451d = "pool-" + f1448a.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f1449b, runnable, this.f1451d + this.f1450c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.f1452e);
        return thread;
    }
}
