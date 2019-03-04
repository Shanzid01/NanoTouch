package p000a;

import java.util.concurrent.Executor;

/* compiled from: Task */
class C0015p implements C0009j<TResult, Void> {
    final /* synthetic */ C0018s f33a;
    final /* synthetic */ C0009j f34b;
    final /* synthetic */ Executor f35c;
    final /* synthetic */ C0010k f36d;

    C0015p(C0010k c0010k, C0018s c0018s, C0009j c0009j, Executor executor) {
        this.f36d = c0010k;
        this.f33a = c0018s;
        this.f34b = c0009j;
        this.f35c = executor;
    }

    public /* synthetic */ Object then(C0010k c0010k) {
        return m38a(c0010k);
    }

    public Void m38a(C0010k<TResult> c0010k) {
        C0010k.m22d(this.f33a, this.f34b, c0010k, this.f35c);
        return null;
    }
}
