package android.support.v7.widget;

/* compiled from: DefaultItemAnimator */
class C0188p {
    public bg f705a;
    public bg f706b;
    public int f707c;
    public int f708d;
    public int f709e;
    public int f710f;

    private C0188p(bg bgVar, bg bgVar2) {
        this.f705a = bgVar;
        this.f706b = bgVar2;
    }

    private C0188p(bg bgVar, bg bgVar2, int i, int i2, int i3, int i4) {
        this(bgVar, bgVar2);
        this.f707c = i;
        this.f708d = i2;
        this.f709e = i3;
        this.f710f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f705a + ", newHolder=" + this.f706b + ", fromX=" + this.f707c + ", fromY=" + this.f708d + ", toX=" + this.f709e + ", toY=" + this.f710f + '}';
    }
}
