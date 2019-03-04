package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.LinkedList;
import java.util.concurrent.Executor;

/* compiled from: AsyncTask */
class C0240h implements Executor {
    final LinkedList<Runnable> f839a;
    Runnable f840b;

    private C0240h() {
        this.f839a = new LinkedList();
    }

    public synchronized void execute(Runnable runnable) {
        this.f839a.offer(new C0241i(this, runnable));
        if (this.f840b == null) {
            m1994a();
        }
    }

    protected synchronized void m1994a() {
        Runnable runnable = (Runnable) this.f839a.poll();
        this.f840b = runnable;
        if (runnable != null) {
            C0232a.f819b.execute(this.f840b);
        }
    }
}
