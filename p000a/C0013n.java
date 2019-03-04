package p000a;

/* compiled from: Task */
class C0013n implements C0009j<TContinuationResult, Void> {
    final /* synthetic */ C0012m f28a;

    C0013n(C0012m c0012m) {
        this.f28a = c0012m;
    }

    public /* synthetic */ Object then(C0010k c0010k) {
        return m36a(c0010k);
    }

    public Void m36a(C0010k<TContinuationResult> c0010k) {
        if (c0010k.m31c()) {
            this.f28a.f27c.m46c();
        } else if (c0010k.m32d()) {
            this.f28a.f27c.m43b(c0010k.m34f());
        } else {
            this.f28a.f27c.m44b(c0010k.m33e());
        }
        return null;
    }
}
