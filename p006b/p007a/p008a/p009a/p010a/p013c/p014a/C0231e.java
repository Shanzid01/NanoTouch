package p006b.p007a.p008a.p009a.p010a.p013c.p014a;

/* compiled from: RetryState */
public class C0231e {
    private final int f815a;
    private final C0227a f816b;
    private final C0228d f817c;

    public C0231e(C0227a c0227a, C0228d c0228d) {
        this(0, c0227a, c0228d);
    }

    public C0231e(int i, C0227a c0227a, C0228d c0228d) {
        this.f815a = i;
        this.f816b = c0227a;
        this.f817c = c0228d;
    }

    public long m1976a() {
        return this.f816b.mo469a(this.f815a);
    }

    public C0231e m1977b() {
        return new C0231e(this.f815a + 1, this.f816b, this.f817c);
    }

    public C0231e m1978c() {
        return new C0231e(this.f816b, this.f817c);
    }
}
