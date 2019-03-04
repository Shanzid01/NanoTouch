package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.concurrent.Executor;

/* compiled from: PriorityAsyncTask */
class C0250q<Result> implements Executor {
    private final Executor f846a;
    private final C0249p f847b;

    public C0250q(Executor executor, C0249p c0249p) {
        this.f846a = executor;
        this.f847b = c0249p;
    }

    public void execute(Runnable runnable) {
        this.f846a.execute(new C0252r(this, runnable, null));
    }
}
