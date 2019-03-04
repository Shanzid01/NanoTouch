package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
public class C0255w extends ThreadPoolExecutor {
    private static final int f853a = Runtime.getRuntime().availableProcessors();
    private static final int f854b = (f853a + 1);
    private static final int f855c = ((f853a * 2) + 1);

    public /* synthetic */ BlockingQueue getQueue() {
        return m2046b();
    }

    <T extends Runnable & C0243l & C0248y & C0247u> C0255w(int i, int i2, long j, TimeUnit timeUnit, C0244m<T> c0244m, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, c0244m, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & C0243l & C0248y & C0247u> C0255w m2045a(int i, int i2) {
        return new C0255w(i, i2, 1, TimeUnit.SECONDS, new C0244m(), new C0256x(10));
    }

    public static C0255w m2044a() {
        return C0255w.m2045a(f854b, f855c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0251t(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0251t(callable);
    }

    public void execute(Runnable runnable) {
        if (C0253v.m2035a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        C0248y c0248y = (C0248y) runnable;
        c0248y.mo472b(true);
        c0248y.mo470a(th);
        m2046b().m2007d();
        super.afterExecute(runnable, th);
    }

    public C0244m m2046b() {
        return (C0244m) super.getQueue();
    }
}
