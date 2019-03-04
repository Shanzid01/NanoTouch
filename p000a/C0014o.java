package p000a;

import java.util.concurrent.Executor;

/* compiled from: Task */
class C0014o implements C0009j<TResult, Void> {
    final /* synthetic */ C0018s f29a;
    final /* synthetic */ C0009j f30b;
    final /* synthetic */ Executor f31c;
    final /* synthetic */ C0010k f32d;

    C0014o(C0010k c0010k, C0018s c0018s, C0009j c0009j, Executor executor) {
        this.f32d = c0010k;
        this.f29a = c0018s;
        this.f30b = c0009j;
        this.f31c = executor;
    }

    public /* synthetic */ Object then(C0010k c0010k) {
        return m37a(c0010k);
    }

    public Void m37a(C0010k<TResult> c0010k) {
        C0010k.m21c(this.f29a, this.f30b, c0010k, this.f31c);
        return null;
    }
}
