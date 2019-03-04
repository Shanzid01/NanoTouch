package android.support.v7.widget;

/* compiled from: RecyclerView */
class az extends am {
    final /* synthetic */ RecyclerView f610a;

    private az(RecyclerView recyclerView) {
        this.f610a = recyclerView;
    }

    public void mo447a() {
        this.f610a.assertNotInLayoutOrScroll(null);
        if (this.f610a.mAdapter.m1536b()) {
            this.f610a.mState.f625i = true;
            this.f610a.mDataSetHasChangedAfterLayout = true;
        } else {
            this.f610a.mState.f625i = true;
            this.f610a.mDataSetHasChangedAfterLayout = true;
        }
        if (!this.f610a.mAdapterHelper.m1445d()) {
            this.f610a.requestLayout();
        }
    }
}
