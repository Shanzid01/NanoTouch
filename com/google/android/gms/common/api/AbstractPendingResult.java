package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPendingResult<R extends Result> implements PendingResult<R> {
    protected final CallbackHandler<R> mHandler;
    private final Object zzLK = new Object();
    private final ArrayList<BatchCallback> zzLL = new ArrayList();
    private ResultCallback<R> zzLM;
    private volatile R zzLN;
    private volatile boolean zzLO;
    private boolean zzLP;
    private boolean zzLQ;
    private ICancelToken zzLR;
    private final CountDownLatch zzmx = new CountDownLatch(1);

    public class CallbackHandler<R extends Result> extends Handler {
        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        protected void deliverResultCallback(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                AbstractPendingResult.zzb(r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    deliverResultCallback((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((AbstractPendingResult) message.obj).zzhS();
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }

        public void removeTimeoutMessages() {
            removeMessages(2);
        }

        public void sendResultCallback(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult<R> abstractPendingResult, long j) {
            sendMessageDelayed(obtainMessage(2, abstractPendingResult), j);
        }
    }

    protected AbstractPendingResult(Looper looper) {
        this.mHandler = new CallbackHandler(looper);
    }

    protected AbstractPendingResult(CallbackHandler<R> callbackHandler) {
        this.mHandler = callbackHandler;
    }

    private void zza(R r) {
        this.zzLN = r;
        this.zzLR = null;
        this.zzmx.countDown();
        Status status = this.zzLN.getStatus();
        if (this.zzLM != null) {
            this.mHandler.removeTimeoutMessages();
            if (!this.zzLP) {
                this.mHandler.sendResultCallback(this.zzLM, zzhQ());
            }
        }
        Iterator it = this.zzLL.iterator();
        while (it.hasNext()) {
            ((BatchCallback) it.next()).zzl(status);
        }
        this.zzLL.clear();
    }

    static void zzb(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("AbstractPendingResult", "Unable to release " + result, e);
            }
        }
    }

    private R zzhQ() {
        R r;
        boolean z = true;
        synchronized (this.zzLK) {
            if (this.zzLO) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzLN;
            this.zzLN = null;
            this.zzLM = null;
            this.zzLO = true;
        }
        onResultConsumed();
        return r;
    }

    private void zzhR() {
        synchronized (this.zzLK) {
            if (!isReady()) {
                setResult(createFailedResult(Status.zzNp));
                this.zzLQ = true;
            }
        }
    }

    public final void addBatchCallback(BatchCallback batchCallback) {
        zzx.zza(!this.zzLO, (Object) "Result has already been consumed.");
        synchronized (this.zzLK) {
            if (isReady()) {
                batchCallback.zzl(this.zzLN.getStatus());
            } else {
                this.zzLL.add(batchCallback);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        if (this.zzLO) {
            z = false;
        }
        zzx.zza(z, (Object) "Result has already been consumed");
        try {
            this.zzmx.await();
        } catch (InterruptedException e) {
            zzhR();
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return zzhQ();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzx.zza(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        if (this.zzLO) {
            z = false;
        }
        zzx.zza(z, (Object) "Result has already been consumed.");
        try {
            if (!this.zzmx.await(j, timeUnit)) {
                zzhS();
            }
        } catch (InterruptedException e) {
            zzhR();
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return zzhQ();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r2 = this;
        r1 = r2.zzLK;
        monitor-enter(r1);
        r0 = r2.zzLP;	 Catch:{ all -> 0x002c }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.zzLO;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.zzLR;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.zzLR;	 Catch:{ RemoteException -> 0x002f }
        r0.cancel();	 Catch:{ RemoteException -> 0x002f }
    L_0x0016:
        r0 = r2.zzLN;	 Catch:{ all -> 0x002c }
        zzb(r0);	 Catch:{ all -> 0x002c }
        r0 = 0;
        r2.zzLM = r0;	 Catch:{ all -> 0x002c }
        r0 = 1;
        r2.zzLP = r0;	 Catch:{ all -> 0x002c }
        r0 = com.google.android.gms.common.api.Status.zzNs;	 Catch:{ all -> 0x002c }
        r0 = r2.createFailedResult(r0);	 Catch:{ all -> 0x002c }
        r2.zza(r0);	 Catch:{ all -> 0x002c }
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        goto L_0x000c;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.AbstractPendingResult.cancel():void");
    }

    protected abstract R createFailedResult(Status status);

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzLK) {
            z = this.zzLP;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzmx.getCount() == 0;
    }

    protected void onResultConsumed() {
    }

    protected final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zzLK) {
            this.zzLR = iCancelToken;
        }
    }

    public final void setResult(R r) {
        boolean z = true;
        synchronized (this.zzLK) {
            if (this.zzLQ || this.zzLP) {
                zzb(r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzLO) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zza(r);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
        /*
        r3 = this;
        r0 = r3.zzLO;
        if (r0 != 0) goto L_0x0015;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        r1 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.zza(r0, r1);
        r1 = r3.zzLK;
        monitor-enter(r1);
        r0 = r3.isCanceled();	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0017;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = 0;
        goto L_0x0005;
    L_0x0017:
        r0 = r3.isReady();	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x002b;
    L_0x001d:
        r0 = r3.mHandler;	 Catch:{ all -> 0x0028 }
        r2 = r3.zzhQ();	 Catch:{ all -> 0x0028 }
        r0.sendResultCallback(r4, r2);	 Catch:{ all -> 0x0028 }
    L_0x0026:
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        goto L_0x0014;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r3.zzLM = r4;	 Catch:{ all -> 0x0028 }
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.AbstractPendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
        r4 = this;
        r1 = 1;
        r2 = 0;
        r0 = r4.zzLO;
        if (r0 != 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.zza(r0, r3);
        r0 = r4.mHandler;
        if (r0 == 0) goto L_0x0022;
    L_0x0010:
        r0 = "CallbackHandler has not been set before calling setResultCallback.";
        com.google.android.gms.common.internal.zzx.zza(r1, r0);
        r1 = r4.zzLK;
        monitor-enter(r1);
        r0 = r4.isCanceled();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r1 = r2;
        goto L_0x0010;
    L_0x0024:
        r0 = r4.isReady();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0038;
    L_0x002a:
        r0 = r4.mHandler;	 Catch:{ all -> 0x0035 }
        r2 = r4.zzhQ();	 Catch:{ all -> 0x0035 }
        r0.sendResultCallback(r5, r2);	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        goto L_0x001f;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r4.zzLM = r5;	 Catch:{ all -> 0x0035 }
        r0 = r4.mHandler;	 Catch:{ all -> 0x0035 }
        r2 = r8.toMillis(r6);	 Catch:{ all -> 0x0035 }
        r0.sendTimeoutResultCallback(r4, r2);	 Catch:{ all -> 0x0035 }
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.AbstractPendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    void zzhS() {
        synchronized (this.zzLK) {
            if (!isReady()) {
                setResult(createFailedResult(Status.zzNr));
                this.zzLQ = true;
            }
        }
    }
}
