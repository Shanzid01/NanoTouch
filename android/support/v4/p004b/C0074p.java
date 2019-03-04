package android.support.v4.p004b;

/* compiled from: Pools */
public class C0074p<T> implements C0073o<T> {
    private final Object[] f80a;
    private int f81b;

    public C0074p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f80a = new Object[i];
    }

    public T mo165a() {
        if (this.f81b <= 0) {
            return null;
        }
        int i = this.f81b - 1;
        T t = this.f80a[i];
        this.f80a[i] = null;
        this.f81b--;
        return t;
    }

    public boolean mo166a(T t) {
        if (m104b(t)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.f81b >= this.f80a.length) {
            return false;
        } else {
            this.f80a[this.f81b] = t;
            this.f81b++;
            return true;
        }
    }

    private boolean m104b(T t) {
        for (int i = 0; i < this.f81b; i++) {
            if (this.f80a[i] == t) {
                return true;
            }
        }
        return false;
    }
}
