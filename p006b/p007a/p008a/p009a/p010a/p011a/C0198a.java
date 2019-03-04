package p006b.p007a.p008a.p009a.p010a.p011a;

import android.content.Context;

/* compiled from: AbstractValueCache */
public abstract class C0198a<T> implements C0197c<T> {
    private final C0197c<T> f742a;

    protected abstract T mo462a(Context context);

    protected abstract void mo463a(Context context, T t);

    public C0198a(C0197c<T> c0197c) {
        this.f742a = c0197c;
    }

    public final synchronized T mo461a(Context context, C0200d<T> c0200d) {
        T a;
        a = mo462a(context);
        if (a == null) {
            a = this.f742a != null ? this.f742a.mo461a(context, c0200d) : c0200d.mo464c(context);
            m1817b(context, a);
        }
        return a;
    }

    private void m1817b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        mo463a(context, (Object) t);
    }
}
