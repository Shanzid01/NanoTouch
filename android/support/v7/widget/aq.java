package android.support.v7.widget;

/* compiled from: RecyclerView */
class aq implements ap {
    final /* synthetic */ RecyclerView f593a;

    private aq(RecyclerView recyclerView) {
        this.f593a = recyclerView;
    }

    public void mo443a(bg bgVar) {
        bgVar.m1675a(true);
        if (!this.f593a.removeAnimatingView(bgVar.f636a) && bgVar.m1692r()) {
            this.f593a.removeDetachedView(bgVar.f636a, false);
        }
    }

    public void mo444b(bg bgVar) {
        bgVar.m1675a(true);
        if (bgVar.m1694t()) {
            this.f593a.removeAnimatingView(bgVar.f636a);
        }
    }

    public void mo445c(bg bgVar) {
        bgVar.m1675a(true);
        if (bgVar.m1694t()) {
            this.f593a.removeAnimatingView(bgVar.f636a);
        }
    }

    public void mo446d(bg bgVar) {
        bgVar.m1675a(true);
        if (bgVar.f642g != null && bgVar.f643h == null) {
            bgVar.f642g = null;
            bgVar.m1671a(-65, bgVar.f644i);
        }
        bgVar.f643h = null;
        if (bgVar.m1694t()) {
            this.f593a.removeAnimatingView(bgVar.f636a);
        }
    }
}
