package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class C0251t<V> extends FutureTask<V> implements C0243l<C0248y>, C0247u, C0248y {
    final Object f848b;

    public /* synthetic */ void mo474c(Object obj) {
        m2026a((C0248y) obj);
    }

    public C0251t(Callable<V> callable) {
        super(callable);
        this.f848b = m2025a((Object) callable);
    }

    public C0251t(Runnable runnable, V v) {
        super(runnable, v);
        this.f848b = m2025a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C0247u) mo477a()).compareTo(obj);
    }

    public void m2026a(C0248y c0248y) {
        ((C0243l) ((C0247u) mo477a())).mo474c(c0248y);
    }

    public Collection<C0248y> mo473c() {
        return ((C0243l) ((C0247u) mo477a())).mo473c();
    }

    public boolean mo475d() {
        return ((C0243l) ((C0247u) mo477a())).mo475d();
    }

    public C0246o mo471b() {
        return ((C0247u) mo477a()).mo471b();
    }

    public void mo472b(boolean z) {
        ((C0248y) ((C0247u) mo477a())).mo472b(z);
    }

    public boolean mo476f() {
        return ((C0248y) ((C0247u) mo477a())).mo476f();
    }

    public void mo470a(Throwable th) {
        ((C0248y) ((C0247u) mo477a())).mo470a(th);
    }

    public <T extends C0243l<C0248y> & C0247u & C0248y> T mo477a() {
        return (C0243l) this.f848b;
    }

    protected <T extends C0243l<C0248y> & C0247u & C0248y> T m2025a(Object obj) {
        if (C0253v.m2035a(obj)) {
            return (C0243l) obj;
        }
        return new C0253v();
    }
}
