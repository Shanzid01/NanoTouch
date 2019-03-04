package android.support.v4.p004b;

/* compiled from: Pair */
public class C0071m<F, S> {
    public final F f78a;
    public final S f79b;

    public boolean equals(Object obj) {
        if (!(obj instanceof C0071m)) {
            return false;
        }
        C0071m c0071m = (C0071m) obj;
        if (C0071m.m101a(c0071m.f78a, this.f78a) && C0071m.m101a(c0071m.f79b, this.f79b)) {
            return true;
        }
        return false;
    }

    private static boolean m101a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f78a == null ? 0 : this.f78a.hashCode();
        if (this.f79b != null) {
            i = this.f79b.hashCode();
        }
        return hashCode ^ i;
    }
}
