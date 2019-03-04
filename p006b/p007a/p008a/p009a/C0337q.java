package p006b.p007a.p008a.p009a;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p013c.C0245n;
import p006b.p007a.p008a.p009a.p010a.p013c.C0248y;

/* compiled from: Kit */
public abstract class C0337q<Result> implements Comparable<C0337q> {
    C0326f f1037e;
    C0336p<Result> f1038f = new C0336p(this);
    Context f1039g;
    C0328l<Result> f1040h;
    C0226z f1041i;

    public abstract String mo529a();

    public abstract String mo531b();

    protected abstract Result mo532f();

    public /* synthetic */ int compareTo(Object obj) {
        return m2339a((C0337q) obj);
    }

    void m2341a(Context context, C0326f c0326f, C0328l<Result> c0328l, C0226z c0226z) {
        this.f1037e = c0326f;
        this.f1039g = new C0331j(context, mo531b(), m2336D());
        this.f1040h = c0328l;
        this.f1041i = c0226z;
    }

    final void m2347z() {
        this.f1038f.m2015a(this.f1037e.m2310f(), (Void) null);
    }

    protected boolean a_() {
        return true;
    }

    protected void m2342a(Result result) {
    }

    protected void m2344b(Result result) {
    }

    protected C0226z m2333A() {
        return this.f1041i;
    }

    public Context m2334B() {
        return this.f1039g;
    }

    public C0326f m2335C() {
        return this.f1037e;
    }

    public String m2336D() {
        return ".Fabric" + File.separator + mo531b();
    }

    public int m2339a(C0337q c0337q) {
        if (m2345b(c0337q)) {
            return 1;
        }
        if (c0337q.m2345b(this)) {
            return -1;
        }
        if (m2337E() && !c0337q.m2337E()) {
            return 1;
        }
        if (m2337E() || !c0337q.m2337E()) {
            return 0;
        }
        return -1;
    }

    boolean m2345b(C0337q c0337q) {
        C0245n c0245n = (C0245n) getClass().getAnnotation(C0245n.class);
        if (c0245n != null) {
            for (Object equals : c0245n.m2008a()) {
                if (equals.equals(c0337q.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean m2337E() {
        return ((C0245n) getClass().getAnnotation(C0245n.class)) != null;
    }

    protected Collection<C0248y> m2338F() {
        return this.f1038f.mo473c();
    }
}
