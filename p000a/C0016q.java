package p000a;

/* compiled from: Task */
class C0016q implements C0009j<TResult, C0010k<TContinuationResult>> {
    final /* synthetic */ C0009j f37a;
    final /* synthetic */ C0010k f38b;

    C0016q(C0010k c0010k, C0009j c0009j) {
        this.f38b = c0010k;
        this.f37a = c0009j;
    }

    public /* synthetic */ Object then(C0010k c0010k) {
        return m39a(c0010k);
    }

    public C0010k<TContinuationResult> m39a(C0010k<TResult> c0010k) {
        if (c0010k.m32d()) {
            return C0010k.m9a(c0010k.m34f());
        }
        if (c0010k.m31c()) {
            return C0010k.m23g();
        }
        return c0010k.m25a(this.f37a);
    }
}
