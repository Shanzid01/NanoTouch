package p000a;

/* compiled from: Task */
public class C0018s {
    final /* synthetic */ C0010k f42a;

    private C0018s(C0010k c0010k) {
        this.f42a = c0010k;
    }

    public C0010k<TResult> m40a() {
        return this.f42a;
    }

    public boolean m45b() {
        boolean z = true;
        synchronized (this.f42a.f19d) {
            if (this.f42a.f20e) {
                z = false;
            } else {
                this.f42a.f20e = true;
                this.f42a.f21f = true;
                this.f42a.f19d.notifyAll();
                this.f42a.m24h();
            }
        }
        return z;
    }

    public boolean m42a(TResult tResult) {
        boolean z = true;
        synchronized (this.f42a.f19d) {
            if (this.f42a.f20e) {
                z = false;
            } else {
                this.f42a.f20e = true;
                this.f42a.f22g = tResult;
                this.f42a.f19d.notifyAll();
                this.f42a.m24h();
            }
        }
        return z;
    }

    public boolean m41a(Exception exception) {
        boolean z = true;
        synchronized (this.f42a.f19d) {
            if (this.f42a.f20e) {
                z = false;
            } else {
                this.f42a.f20e = true;
                this.f42a.f23h = exception;
                this.f42a.f19d.notifyAll();
                this.f42a.m24h();
            }
        }
        return z;
    }

    public void m46c() {
        if (!m45b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void m44b(TResult tResult) {
        if (!m42a((Object) tResult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void m43b(Exception exception) {
        if (!m41a(exception)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
