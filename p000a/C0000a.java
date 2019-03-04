package p000a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AndroidExecutors */
final class C0000a {
    static final int f0a = (f3e + 1);
    static final int f1b = ((f3e * 2) + 1);
    private static final C0000a f2c = new C0000a();
    private static final int f3e = Runtime.getRuntime().availableProcessors();
    private final Executor f4d = new C0002c();

    private C0000a() {
    }

    public static ExecutorService m0a() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(f0a, f1b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        C0000a.m1a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    public static void m1a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor m2b() {
        return f2c.f4d;
    }
}
