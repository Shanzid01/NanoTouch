package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@zzgi
public class zzhr<T> implements Future<T> {
    private final T zzzt;

    public zzhr(T t) {
        this.zzzt = t;
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.zzzt;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.zzzt;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
