package android.support.v7.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

/* compiled from: RecyclerView */
public abstract class bb {
    private at mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final bc mRecyclingAction = new bc(0, 0);
    private boolean mRunning;
    private int mTargetPosition = -1;
    private View mTargetView;

    protected abstract void onSeekTargetStep(int i, int i2, bd bdVar, bc bcVar);

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void onTargetFound(View view, bd bdVar, bc bcVar);

    void start(RecyclerView recyclerView, at atVar) {
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = atVar;
        if (this.mTargetPosition == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        this.mRecyclerView.mState.f621e = this.mTargetPosition;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.m1660a();
    }

    public void setTargetPosition(int i) {
        this.mTargetPosition = i;
    }

    public at getLayoutManager() {
        return this.mLayoutManager;
    }

    protected final void stop() {
        if (this.mRunning) {
            onStop();
            this.mRecyclerView.mState.f621e = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mRunning = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    private void onAnimation(int i, int i2) {
        if (!this.mRunning || this.mTargetPosition == -1) {
            stop();
        }
        this.mPendingInitialRun = false;
        if (this.mTargetView != null) {
            if (getChildPosition(this.mTargetView) == this.mTargetPosition) {
                onTargetFound(this.mTargetView, this.mRecyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.m1631a(this.mRecyclerView);
                stop();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if (this.mRunning) {
            onSeekTargetStep(i, i2, this.mRecyclerView.mState, this.mRecyclingAction);
            this.mRecyclingAction.m1631a(this.mRecyclerView);
        }
    }

    public int getChildPosition(View view) {
        return this.mRecyclerView.getChildPosition(view);
    }

    public int getChildCount() {
        return this.mRecyclerView.mLayout.getChildCount();
    }

    public View findViewByPosition(int i) {
        return this.mRecyclerView.mLayout.findViewByPosition(i);
    }

    public void instantScrollToPosition(int i) {
        this.mRecyclerView.scrollToPosition(i);
    }

    protected void onChildAttachedToWindow(View view) {
        if (getChildPosition(view) == getTargetPosition()) {
            this.mTargetView = view;
        }
    }

    protected void normalize(PointF pointF) {
        double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
        pointF.x = (float) (((double) pointF.x) / sqrt);
        pointF.y = (float) (((double) pointF.y) / sqrt);
    }
}
