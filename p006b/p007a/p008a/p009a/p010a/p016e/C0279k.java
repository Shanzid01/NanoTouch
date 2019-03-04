package p006b.p007a.p008a.p009a.p010a.p016e;

import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: HttpRequest */
public abstract class C0279k<V> implements Callable<V> {
    protected abstract V mo496b();

    protected abstract void mo495c();

    protected C0279k() {
    }

    public V call() {
        Throwable th;
        Object obj = 1;
        try {
            V b = mo496b();
            try {
                mo495c();
                return b;
            } catch (IOException e) {
                throw new C0284j(e);
            }
        } catch (C0284j e2) {
            throw e2;
        } catch (IOException e3) {
            throw new C0284j(e3);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            mo495c();
        } catch (IOException e4) {
            if (obj == null) {
                throw new C0284j(e4);
            }
        }
        throw th;
    }
}
