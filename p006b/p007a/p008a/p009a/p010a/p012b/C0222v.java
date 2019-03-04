package p006b.p007a.p008a.p009a.p010a.p012b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
public final class C0222v {
    public static ExecutorService m1941a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C0222v.m1945c(str));
        C0222v.m1942a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService m1944b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(C0222v.m1945c(str));
        C0222v.m1942a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory m1945c(String str) {
        return new C0223w(str, new AtomicLong(1));
    }

    private static final void m1942a(String str, ExecutorService executorService) {
        C0222v.m1943a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void m1943a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new C0225y(str, executorService, j, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }
}
