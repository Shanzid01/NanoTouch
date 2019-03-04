package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzgi
public final class zzhn {
    private static final ThreadFactory zzzk = new C12324();
    private static final ExecutorService zzzl = Executors.newFixedThreadPool(10, zzzk);
    private static final ExecutorService zzzm = Executors.newFixedThreadPool(5, zzzk);

    final class C12291 implements Callable<Void> {
        final /* synthetic */ Runnable zzzn;

        C12291(Runnable runnable) {
            this.zzzn = runnable;
        }

        public /* synthetic */ Object call() {
            return zzer();
        }

        public Void zzer() {
            this.zzzn.run();
            return null;
        }
    }

    final class C12302 implements Callable<Void> {
        final /* synthetic */ Runnable zzzn;

        C12302(Runnable runnable) {
            this.zzzn = runnable;
        }

        public /* synthetic */ Object call() {
            return zzer();
        }

        public Void zzer() {
            this.zzzn.run();
            return null;
        }
    }

    final class C12313 implements Callable<T> {
        final /* synthetic */ Callable zzzo;

        C12313(Callable callable) {
            this.zzzo = callable;
        }

        public T call() {
            try {
                Process.setThreadPriority(10);
                return this.zzzo.call();
            } catch (Throwable e) {
                zzab.zzaP().zze(e);
                throw e;
            }
        }
    }

    final class C12324 implements ThreadFactory {
        private final AtomicInteger zzzp = new AtomicInteger(1);

        C12324() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.zzzp.getAndIncrement());
        }
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        return zza(zzzl, (Callable) callable);
    }

    public static Future<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza(zzzm, new C12291(runnable)) : zza(zzzl, new C12302(runnable));
    }

    public static <T> Future<T> zza(ExecutorService executorService, Callable<T> callable) {
        try {
            return executorService.submit(new C12313(callable));
        } catch (Throwable e) {
            zzhx.zzd("Thread execution is rejected.", e);
            return new zzhr(null);
        }
    }

    public static Future<Void> zzb(Runnable runnable) {
        return zza(0, runnable);
    }
}
