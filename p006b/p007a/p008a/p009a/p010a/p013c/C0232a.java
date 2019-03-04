package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AsyncTask */
public abstract class C0232a<Params, Progress, Result> {
    private static final int f818a = Runtime.getRuntime().availableProcessors();
    public static final Executor f819b = new ThreadPoolExecutor(f821d, f822e, 1, TimeUnit.SECONDS, f824g, f823f);
    public static final Executor f820c = new C0240h();
    private static final int f821d = (f818a + 1);
    private static final int f822e = ((f818a * 2) + 1);
    private static final ThreadFactory f823f = new C0233b();
    private static final BlockingQueue<Runnable> f824g = new LinkedBlockingQueue(128);
    private static final C0239g f825h = new C0239g();
    private static volatile Executor f826i = f820c;
    private final C0234k<Params, Result> f827j = new C0235c(this);
    private final FutureTask<Result> f828k = new C0236d(this, this.f827j);
    private volatile C0242j f829l = C0242j.PENDING;
    private final AtomicBoolean f830m = new AtomicBoolean();
    private final AtomicBoolean f831n = new AtomicBoolean();

    protected abstract Result mo525a(Params... paramsArr);

    private void mo474c(Result result) {
        if (!this.f831n.get()) {
            m1984d(result);
        }
    }

    private Result m1984d(Result result) {
        f825h.obtainMessage(1, new C0238f(this, result)).sendToTarget();
        return result;
    }

    public final C0242j c_() {
        return this.f829l;
    }

    protected void mo526a() {
    }

    protected void mo527a(Result result) {
    }

    protected void m1992b(Progress... progressArr) {
    }

    protected void mo528b(Result result) {
        d_();
    }

    protected void d_() {
    }

    public final boolean m1993e() {
        return this.f830m.get();
    }

    public final boolean m1990a(boolean z) {
        this.f830m.set(true);
        return this.f828k.cancel(z);
    }

    public final C0232a<Params, Progress, Result> m1986a(Executor executor, Params... paramsArr) {
        if (this.f829l != C0242j.PENDING) {
            switch (C0237e.f836a[this.f829l.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f829l = C0242j.RUNNING;
        mo526a();
        this.f827j.f833b = paramsArr;
        executor.execute(this.f828k);
        return this;
    }

    private void m1985e(Result result) {
        if (m1993e()) {
            mo528b((Object) result);
        } else {
            mo527a((Object) result);
        }
        this.f829l = C0242j.FINISHED;
    }
}
