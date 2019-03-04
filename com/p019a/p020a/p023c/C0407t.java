package com.p019a.p020a.p023c;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class C0407t {
    private final ExecutorService f1370a;

    public C0407t(ExecutorService executorService) {
        this.f1370a = executorService;
    }

    <T> T m2817a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f1370a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f1370a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> m2818a(Runnable runnable) {
        try {
            return this.f1370a.submit(new C0408u(this, runnable));
        } catch (RejectedExecutionException e) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> m2819b(Callable<T> callable) {
        try {
            return this.f1370a.submit(new C0409v(this, callable));
        } catch (RejectedExecutionException e) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
