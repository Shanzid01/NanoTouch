package android.support.v7.widget;

/* compiled from: RecyclerView */
class af implements Runnable {
    final /* synthetic */ RecyclerView f580a;

    af(RecyclerView recyclerView) {
        this.f580a = recyclerView;
    }

    public void run() {
        if (!this.f580a.mFirstLayoutComplete) {
            return;
        }
        if (this.f580a.mDataSetHasChangedAfterLayout) {
            this.f580a.dispatchLayout();
        } else if (this.f580a.mAdapterHelper.m1445d()) {
            this.f580a.eatRequestLayout();
            this.f580a.mAdapterHelper.m1443b();
            if (!this.f580a.mLayoutRequestEaten) {
                this.f580a.rebindUpdatedViewHolders();
            }
            this.f580a.resumeRequestLayout(true);
        }
    }
}
