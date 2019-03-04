package p000a;

import a.k$a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Task */
public class C0010k<TResult> {
    public static final ExecutorService f16a = C0006g.m4a();
    public static final Executor f17b = C0000a.m2b();
    private static final Executor f18c = C0006g.m5b();
    private final Object f19d = new Object();
    private boolean f20e;
    private boolean f21f;
    private TResult f22g;
    private Exception f23h;
    private List<C0009j<TResult, Void>> f24i = new ArrayList();

    private C0010k() {
    }

    public static <TResult> s m11a() {
        C0010k c0010k = new C0010k();
        c0010k.getClass();
        return new C0018s(c0010k);
    }

    public boolean m29b() {
        boolean z;
        synchronized (this.f19d) {
            z = this.f20e;
        }
        return z;
    }

    public boolean m31c() {
        boolean z;
        synchronized (this.f19d) {
            z = this.f21f;
        }
        return z;
    }

    public boolean m32d() {
        boolean z;
        synchronized (this.f19d) {
            z = this.f23h != null;
        }
        return z;
    }

    public TResult m33e() {
        TResult tResult;
        synchronized (this.f19d) {
            tResult = this.f22g;
        }
        return tResult;
    }

    public Exception m34f() {
        Exception exception;
        synchronized (this.f19d) {
            exception = this.f23h;
        }
        return exception;
    }

    public static <TResult> C0010k<TResult> m10a(TResult tResult) {
        C0018s a = C0010k.m11a();
        a.m44b((Object) tResult);
        return a.m40a();
    }

    public static <TResult> C0010k<TResult> m9a(Exception exception) {
        C0018s a = C0010k.m11a();
        a.m43b(exception);
        return a.m40a();
    }

    public static <TResult> C0010k<TResult> m23g() {
        C0018s a = C0010k.m11a();
        a.m46c();
        return a.m40a();
    }

    public <TContinuationResult> C0010k<TContinuationResult> m26a(C0009j<TResult, TContinuationResult> c0009j, Executor executor) {
        C0018s a = C0010k.m11a();
        synchronized (this.f19d) {
            boolean b = m29b();
            if (!b) {
                this.f24i.add(new C0014o(this, a, c0009j, executor));
            }
        }
        if (b) {
            C0010k.m21c(a, c0009j, this, executor);
        }
        return a.m40a();
    }

    public <TContinuationResult> C0010k<TContinuationResult> m25a(C0009j<TResult, TContinuationResult> c0009j) {
        return m26a((C0009j) c0009j, f18c);
    }

    public <TContinuationResult> C0010k<TContinuationResult> m28b(C0009j<TResult, C0010k<TContinuationResult>> c0009j, Executor executor) {
        C0018s a = C0010k.m11a();
        synchronized (this.f19d) {
            boolean b = m29b();
            if (!b) {
                this.f24i.add(new C0015p(this, a, c0009j, executor));
            }
        }
        if (b) {
            C0010k.m22d(a, c0009j, this, executor);
        }
        return a.m40a();
    }

    public <TContinuationResult> C0010k<TContinuationResult> m30c(C0009j<TResult, TContinuationResult> c0009j, Executor executor) {
        return m28b(new C0016q(this, c0009j), executor);
    }

    public <TContinuationResult> C0010k<TContinuationResult> m27b(C0009j<TResult, TContinuationResult> c0009j) {
        return m30c(c0009j, f18c);
    }

    private static <TContinuationResult, TResult> void m21c(s sVar, C0009j<TResult, TContinuationResult> c0009j, C0010k<TResult> c0010k, Executor executor) {
        executor.execute(new C0017r(c0009j, c0010k, sVar));
    }

    private static <TContinuationResult, TResult> void m22d(s sVar, C0009j<TResult, C0010k<TContinuationResult>> c0009j, C0010k<TResult> c0010k, Executor executor) {
        executor.execute(new C0012m(c0009j, c0010k, sVar));
    }

    private void m24h() {
        synchronized (this.f19d) {
            for (C0009j then : this.f24i) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f24i = null;
        }
    }
}
