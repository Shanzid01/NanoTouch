package p000a;

/* compiled from: Task */
final class C0012m implements Runnable {
    final /* synthetic */ C0009j f25a;
    final /* synthetic */ C0010k f26b;
    final /* synthetic */ C0018s f27c;

    C0012m(C0009j c0009j, C0010k c0010k, C0018s c0018s) {
        this.f25a = c0009j;
        this.f26b = c0010k;
        this.f27c = c0018s;
    }

    public void run() {
        try {
            C0010k c0010k = (C0010k) this.f25a.then(this.f26b);
            if (c0010k == null) {
                this.f27c.m44b(null);
            } else {
                c0010k.m25a(new C0013n(this));
            }
        } catch (Exception e) {
            this.f27c.m43b(e);
        }
    }
}
