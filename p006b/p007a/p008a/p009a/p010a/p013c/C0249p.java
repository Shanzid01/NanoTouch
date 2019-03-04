package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.Collection;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
public abstract class C0249p<Params, Progress, Result> extends C0232a<Params, Progress, Result> implements C0243l<C0248y>, C0247u, C0248y {
    private final C0253v f845a = new C0253v();

    public /* synthetic */ void mo474c(Object obj) {
        m2013a((C0248y) obj);
    }

    public final void m2015a(ExecutorService executorService, Params... paramsArr) {
        super.m1986a(new C0250q(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return C0246o.compareTo(this, obj);
    }

    public void m2013a(C0248y c0248y) {
        if (c_() != C0242j.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((C0243l) ((C0247u) m2022g())).mo474c(c0248y);
    }

    public Collection<C0248y> mo473c() {
        return ((C0243l) ((C0247u) m2022g())).mo473c();
    }

    public boolean mo475d() {
        return ((C0243l) ((C0247u) m2022g())).mo475d();
    }

    public C0246o mo471b() {
        return ((C0247u) m2022g()).mo471b();
    }

    public void mo472b(boolean z) {
        ((C0248y) ((C0247u) m2022g())).mo472b(z);
    }

    public boolean mo476f() {
        return ((C0248y) ((C0247u) m2022g())).mo476f();
    }

    public void mo470a(Throwable th) {
        ((C0248y) ((C0247u) m2022g())).mo470a(th);
    }

    public <T extends C0243l<C0248y> & C0247u & C0248y> T m2022g() {
        return this.f845a;
    }
}
