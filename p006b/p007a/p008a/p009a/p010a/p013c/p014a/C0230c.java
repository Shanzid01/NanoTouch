package p006b.p007a.p008a.p009a.p010a.p013c.p014a;

/* compiled from: ExponentialBackoff */
public class C0230c implements C0227a {
    private final long f813a;
    private final int f814b;

    public C0230c(long j, int i) {
        this.f813a = j;
        this.f814b = i;
    }

    public long mo469a(int i) {
        return (long) (((double) this.f813a) * Math.pow((double) this.f814b, (double) i));
    }
}
