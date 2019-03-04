package p006b.p007a.p008a.p009a.p010a.p016e;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: HttpRequest */
public abstract class C0280g<V> extends C0279k<V> {
    private final Closeable f897a;
    private final boolean f898b;

    protected C0280g(Closeable closeable, boolean z) {
        this.f897a = closeable;
        this.f898b = z;
    }

    protected void mo495c() {
        if (this.f897a instanceof Flushable) {
            ((Flushable) this.f897a).flush();
        }
        if (this.f898b) {
            try {
                this.f897a.close();
                return;
            } catch (IOException e) {
                return;
            }
        }
        this.f897a.close();
    }
}
