package android.support.v7.widget;

/* compiled from: RecyclerView */
class aj implements C0173b {
    final /* synthetic */ RecyclerView f583a;

    aj(RecyclerView recyclerView) {
        this.f583a = recyclerView;
    }

    public bg mo435a(int i) {
        return this.f583a.findViewHolderForPosition(i, true);
    }

    public void mo436a(int i, int i2) {
        this.f583a.offsetPositionRecordsForRemove(i, i2, true);
        this.f583a.mItemsAddedOrRemoved = true;
        bd.m1634a(this.f583a.mState, i2);
    }

    public void mo438b(int i, int i2) {
        this.f583a.offsetPositionRecordsForRemove(i, i2, false);
        this.f583a.mItemsAddedOrRemoved = true;
    }

    public void mo440c(int i, int i2) {
        this.f583a.viewRangeUpdate(i, i2);
        this.f583a.mItemsChanged = true;
    }

    public void mo437a(C0175c c0175c) {
        m1520c(c0175c);
    }

    void m1520c(C0175c c0175c) {
        switch (c0175c.f662a) {
            case 0:
                this.f583a.mLayout.onItemsAdded(this.f583a, c0175c.f663b, c0175c.f664c);
                return;
            case 1:
                this.f583a.mLayout.onItemsRemoved(this.f583a, c0175c.f663b, c0175c.f664c);
                return;
            case 2:
                this.f583a.mLayout.onItemsUpdated(this.f583a, c0175c.f663b, c0175c.f664c);
                return;
            case 3:
                this.f583a.mLayout.onItemsMoved(this.f583a, c0175c.f663b, c0175c.f664c, 1);
                return;
            default:
                return;
        }
    }

    public void mo439b(C0175c c0175c) {
        m1520c(c0175c);
    }

    public void mo441d(int i, int i2) {
        this.f583a.offsetPositionRecordsForInsert(i, i2);
        this.f583a.mItemsAddedOrRemoved = true;
    }

    public void mo442e(int i, int i2) {
        this.f583a.offsetPositionRecordsForMove(i, i2);
        this.f583a.mItemsAddedOrRemoved = true;
    }
}
