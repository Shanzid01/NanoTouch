package p006b.p007a.p008a.p009a.p010a.p013c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
public class C0253v implements C0243l<C0248y>, C0247u, C0248y {
    private final List<C0248y> f850a = new ArrayList();
    private final AtomicBoolean f851b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> f852c = new AtomicReference(null);

    public /* synthetic */ void mo474c(Object obj) {
        m2036a((C0248y) obj);
    }

    public synchronized Collection<C0248y> mo473c() {
        return Collections.unmodifiableCollection(this.f850a);
    }

    public synchronized void m2036a(C0248y c0248y) {
        this.f850a.add(c0248y);
    }

    public boolean mo475d() {
        for (C0248y f : mo473c()) {
            if (!f.mo476f()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void mo472b(boolean z) {
        this.f851b.set(z);
    }

    public boolean mo476f() {
        return this.f851b.get();
    }

    public C0246o mo471b() {
        return C0246o.NORMAL;
    }

    public void mo470a(Throwable th) {
        this.f852c.set(th);
    }

    public int compareTo(Object obj) {
        return C0246o.compareTo(this, obj);
    }

    public static boolean m2035a(Object obj) {
        try {
            C0243l c0243l = (C0243l) obj;
            C0248y c0248y = (C0248y) obj;
            C0247u c0247u = (C0247u) obj;
            if (c0243l == null || c0248y == null || c0247u == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
