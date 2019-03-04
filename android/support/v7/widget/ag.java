package android.support.v7.widget;

/* compiled from: RecyclerView */
class ag implements Runnable {
    final /* synthetic */ RecyclerView f581a;

    ag(RecyclerView recyclerView) {
        this.f581a = recyclerView;
    }

    public void run() {
        if (this.f581a.mItemAnimator != null) {
            this.f581a.mItemAnimator.mo453a();
        }
        this.f581a.mPostedAnimatorRunner = false;
    }
}
