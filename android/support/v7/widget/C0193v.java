package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: LinearLayoutManager */
class C0193v {
    int f724a;
    int f725b;
    boolean f726c;
    final /* synthetic */ LinearLayoutManager f727d;

    void m1806a() {
        this.f724a = -1;
        this.f725b = Integer.MIN_VALUE;
        this.f726c = false;
    }

    void m1809b() {
        this.f725b = this.f726c ? this.f727d.f511j.mo421d() : this.f727d.f511j.mo419c();
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.f724a + ", mCoordinate=" + this.f725b + ", mLayoutFromEnd=" + this.f726c + '}';
    }

    public boolean m1808a(View view, bd bdVar) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.isItemRemoved() || layoutParams.getViewPosition() < 0 || layoutParams.getViewPosition() >= bdVar.m1654f()) {
            return false;
        }
        m1807a(view);
        return true;
    }

    public void m1807a(View view) {
        if (this.f726c) {
            this.f725b = this.f727d.f511j.mo418b(view) + this.f727d.f511j.m1459b();
        } else {
            this.f725b = this.f727d.f511j.mo416a(view);
        }
        this.f724a = this.f727d.getPosition(view);
    }
}
