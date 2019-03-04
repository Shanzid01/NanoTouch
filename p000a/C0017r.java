package p000a;

/* compiled from: Task */
final class C0017r implements Runnable {
    final /* synthetic */ C0009j f39a;
    final /* synthetic */ C0010k f40b;
    final /* synthetic */ C0018s f41c;

    C0017r(C0009j c0009j, C0010k c0010k, C0018s c0018s) {
        this.f39a = c0009j;
        this.f40b = c0010k;
        this.f41c = c0018s;
    }

    public void run() {
        try {
            this.f41c.m44b(this.f39a.then(this.f40b));
        } catch (Exception e) {
            this.f41c.m43b(e);
        }
    }
}
