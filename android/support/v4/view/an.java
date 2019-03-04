package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: PagerTitleStrip */
class an extends DataSetObserver implements cl, cm {
    final /* synthetic */ PagerTitleStrip f221a;
    private int f222b;

    private an(PagerTitleStrip pagerTitleStrip) {
        this.f221a = pagerTitleStrip;
    }

    public void mo241a(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.f221a.mo169a(i, f, false);
    }

    public void mo240a(int i) {
        float f = 0.0f;
        if (this.f222b == 0) {
            this.f221a.m154a(this.f221a.f112a.getCurrentItem(), this.f221a.f112a.m191b());
            if (this.f221a.f118g >= 0.0f) {
                f = this.f221a.f118g;
            }
            this.f221a.mo169a(this.f221a.f112a.getCurrentItem(), f, true);
        }
    }

    public void mo243b(int i) {
        this.f222b = i;
    }

    public void mo242a(aj ajVar, aj ajVar2) {
        this.f221a.m155a(ajVar, ajVar2);
    }

    public void onChanged() {
        float f = 0.0f;
        this.f221a.m154a(this.f221a.f112a.getCurrentItem(), this.f221a.f112a.m191b());
        if (this.f221a.f118g >= 0.0f) {
            f = this.f221a.f118g;
        }
        this.f221a.mo169a(this.f221a.f112a.getCurrentItem(), f, true);
    }
}
