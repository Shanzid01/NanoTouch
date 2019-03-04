package com.mopub.common.p050b;

import android.os.AsyncTask;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: AsyncTasks */
public class C1478a {
    public static <P> void m4050a(AsyncTask<P, ?, ?> asyncTask, P... pArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("Unable to execute null AsyncTask.");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("AsyncTask must be executed on the main thread");
        } else if (C1493p.currentApiLevel().isAtLeast(C1493p.ICE_CREAM_SANDWICH)) {
            try {
                new C1488k(asyncTask, "executeOnExecutor").m4083a(Executor.class, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(AsyncTask.class)).m4083a(Object[].class, pArr).m4084a();
            } catch (Exception e) {
                asyncTask.execute(pArr);
            }
        } else {
            asyncTask.execute(pArr);
        }
    }
}
