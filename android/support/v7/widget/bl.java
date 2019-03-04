package android.support.v7.widget;

/* compiled from: StaggeredGridLayoutManager */
class bl {
    int f651a;
    int f652b;
    boolean f653c;
    boolean f654d;
    final /* synthetic */ StaggeredGridLayoutManager f655e;

    void m1704a() {
        this.f651a = -1;
        this.f652b = Integer.MIN_VALUE;
        this.f653c = false;
        this.f654d = false;
    }

    void m1706b() {
        this.f652b = this.f653c ? this.f655e.f546a.mo421d() : this.f655e.f546a.mo419c();
    }

    void m1705a(int i) {
        if (this.f653c) {
            this.f652b = this.f655e.f546a.mo421d() - i;
        } else {
            this.f652b = this.f655e.f546a.mo419c() + i;
        }
    }
}
