package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgi
public class zzhq<T> implements Future<T> {
    private final Object zznh = new Object();
    private boolean zzsg = false;
    private T zzzt = null;
    private boolean zzzu = false;

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.zznh) {
            if (this.zzzu) {
                return false;
            }
            this.zzsg = true;
            this.zzzu = true;
            this.zznh.notifyAll();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.zznh) {
            if (!this.zzzu) {
                try {
                    this.zznh.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzsg) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzzt;
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.zznh) {
            if (!this.zzzu) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.zznh.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzzu) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzsg) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzzt;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzsg;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzzu;
        }
        return z;
    }

    public void zzb(T t) {
        synchronized (this.zznh) {
            if (this.zzzu) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzzu = true;
            this.zzzt = t;
            this.zznh.notifyAll();
        }
    }
}
