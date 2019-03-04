package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class zznx<T extends Result> implements PendingResult<T> {
    private final T zzZX;

    zznx(T t) {
        this.zzZX = t;
    }

    public void addBatchCallback(BatchCallback batchCallback) {
        batchCallback.zzl(this.zzZX.getStatus());
    }

    public T await() {
        return this.zzZX;
    }

    public T await(long j, TimeUnit timeUnit) {
        return this.zzZX;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> resultCallback) {
        resultCallback.onResult(this.zzZX);
    }

    public void setResultCallback(ResultCallback<T> resultCallback, long j, TimeUnit timeUnit) {
        resultCallback.onResult(this.zzZX);
    }
}
