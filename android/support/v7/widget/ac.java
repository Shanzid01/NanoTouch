package android.support.v7.widget;

import android.view.View;

/* compiled from: OrientationHelper */
public abstract class ac {
    protected final at f578a;
    private int f579b;

    public abstract int mo416a(View view);

    public abstract void mo417a(int i);

    public abstract int mo418b(View view);

    public abstract int mo419c();

    public abstract int mo420c(View view);

    public abstract int mo421d();

    public abstract int mo422d(View view);

    public abstract int mo423e();

    public abstract int mo424f();

    public abstract int mo425g();

    private ac(at atVar) {
        this.f579b = Integer.MIN_VALUE;
        this.f578a = atVar;
    }

    public void m1457a() {
        this.f579b = mo424f();
    }

    public int m1459b() {
        return Integer.MIN_VALUE == this.f579b ? 0 : mo424f() - this.f579b;
    }

    public static ac m1454a(at atVar, int i) {
        switch (i) {
            case 0:
                return m1453a(atVar);
            case 1:
                return m1455b(atVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static ac m1453a(at atVar) {
        return new ad(atVar);
    }

    public static ac m1455b(at atVar) {
        return new ae(atVar);
    }
}
