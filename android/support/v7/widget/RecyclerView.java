package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p004b.C0059a;
import android.support.v4.view.ae;
import android.support.v4.view.at;
import android.support.v4.view.ay;
import android.support.v4.view.bq;
import android.support.v4.widget.C0167w;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator = new ah();
    private bh mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private au mActiveOnItemTouchListener;
    private ak mAdapter;
    C0171a mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private C0167w mBottomGlow;
    C0176d mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    final List<View> mDisappearingViewsInLayoutPass;
    private boolean mEatRequestLayout;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    an mItemAnimator;
    private ap mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList<ar> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    private at mLayout;
    private boolean mLayoutRequestEaten;
    private C0167w mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final az mObserver;
    private final ArrayList<au> mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final ax mRecycler;
    private ay mRecyclerListener;
    private C0167w mRightGlow;
    private boolean mRunningLayoutOrScroll;
    private av mScrollListener;
    private int mScrollPointerId;
    private int mScrollState;
    final bd mState;
    private final Rect mTempRect;
    private C0167w mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final bf mViewFlinger;

    public class LayoutParams extends MarginLayoutParams {
        final Rect mDecorInsets = new Rect();
        boolean mInsetsDirty = true;
        boolean mPendingInvalidate = false;
        bg mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.m1688n();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.m1687m();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.m1691q();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.m1689o();
        }

        public int getViewPosition() {
            return this.mViewHolder.m1678d();
        }
    }

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ba();
        Parcelable f528a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f528a = parcel.readParcelable(at.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f528a, 0);
        }

        private void m1353a(SavedState savedState) {
            this.f528a = savedState.f528a;
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) {
            z = true;
        } else {
            z = false;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet, i);
        this.mObserver = new az();
        this.mRecycler = new ax(this);
        this.mDisappearingViewsInLayoutPass = new ArrayList();
        this.mUpdateChildViewsRunnable = new af(this);
        this.mTempRect = new Rect();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mDataSetHasChangedAfterLayout = false;
        this.mRunningLayoutOrScroll = false;
        this.mItemAnimator = new C0178g();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mViewFlinger = new bf(this);
        this.mState = new bd();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new aq();
        this.mPostedAnimatorRunner = false;
        this.mItemAnimatorRunner = new ag(this);
        this.mPostUpdatesOnAnimation = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        if (ay.m565a(this) == 2) {
            z = true;
        }
        setWillNotDraw(z);
        this.mItemAnimator.m1542a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ay.m583e(this) == 0) {
            ay.m579c((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new bh(this));
    }

    public bh getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(bh bhVar) {
        this.mAccessibilityDelegate = bhVar;
        ay.m570a((View) this, this.mAccessibilityDelegate);
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C0176d(new ai(this));
    }

    void initAdapterManager() {
        this.mAdapterHelper = new C0171a(new aj(this));
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = bq.m774a(viewConfiguration);
                return;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(ak akVar, boolean z) {
        setAdapterInternal(akVar, true, z);
        this.mDataSetHasChangedAfterLayout = true;
        requestLayout();
    }

    public void setAdapter(ak akVar) {
        setAdapterInternal(akVar, false, true);
        requestLayout();
    }

    private void setAdapterInternal(ak akVar, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.m1533b(this.mObserver);
            this.mAdapter.m1532b(this);
        }
        if (!z || z2) {
            if (this.mItemAnimator != null) {
                this.mItemAnimator.mo459c();
            }
            if (this.mLayout != null) {
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            }
        }
        this.mAdapterHelper.m1439a();
        ak akVar2 = this.mAdapter;
        this.mAdapter = akVar;
        if (akVar != null) {
            akVar.m1527a(this.mObserver);
            akVar.m1526a(this);
        }
        if (this.mLayout != null) {
            this.mLayout.onAdapterChanged(akVar2, this.mAdapter);
        }
        this.mRecycler.m1600a(akVar2, this.mAdapter, z);
        this.mState.f625i = true;
        markKnownViewsInvalid();
    }

    public ak getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(ay ayVar) {
        this.mRecyclerListener = ayVar;
    }

    public void setLayoutManager(at atVar) {
        if (atVar != this.mLayout) {
            if (this.mLayout != null) {
                if (this.mIsAttached) {
                    this.mLayout.onDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
            }
            this.mRecycler.m1597a();
            this.mChildHelper.m1732a();
            this.mLayout = atVar;
            if (atVar != null) {
                if (atVar.mRecyclerView != null) {
                    throw new IllegalArgumentException("LayoutManager " + atVar + " is already attached to a RecyclerView: " + atVar.mRecyclerView);
                }
                this.mLayout.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.onAttachedToWindow(this);
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            savedState.m1353a(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            savedState.f528a = this.mLayout.onSaveInstanceState();
        } else {
            savedState.f528a = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        if (this.mLayout != null && this.mPendingSavedState.f528a != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f528a);
        }
    }

    private void addAnimatingView(bg bgVar) {
        View view = bgVar.f636a;
        boolean z = view.getParent() == this;
        this.mRecycler.m1614c(getChildViewHolder(view));
        if (bgVar.m1692r()) {
            this.mChildHelper.m1735a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.mChildHelper.m1745d(view);
        } else {
            this.mChildHelper.m1737a(view, true);
        }
    }

    private boolean removeAnimatingView(View view) {
        eatRequestLayout();
        boolean e = this.mChildHelper.m1746e(view);
        if (e) {
            bg childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m1614c(childViewHolderInt);
            this.mRecycler.m1609b(childViewHolderInt);
        }
        resumeRequestLayout(false);
        return e;
    }

    public at getLayoutManager() {
        return this.mLayout;
    }

    public aw getRecycledViewPool() {
        return this.mRecycler.m1621f();
    }

    public void setRecycledViewPool(aw awVar) {
        this.mRecycler.m1601a(awVar);
    }

    public void setViewCacheExtension(be beVar) {
        this.mRecycler.m1602a(beVar);
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.m1598a(i);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    private void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            if (this.mScrollListener != null) {
                this.mScrollListener.m1581a(this, i);
            }
            this.mLayout.onScrollStateChanged(i);
        }
    }

    public void addItemDecoration(ar arVar, int i) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(arVar);
        } else {
            this.mItemDecorations.add(i, arVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(ar arVar) {
        addItemDecoration(arVar, -1);
    }

    public void removeItemDecoration(ar arVar) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(arVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(ay.m565a(this) == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setOnScrollListener(av avVar) {
        this.mScrollListener = avVar;
    }

    public void scrollToPosition(int i) {
        stopScroll();
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int i) {
        this.mLayout.smoothScrollToPosition(this, this.mState, i);
    }

    public void scrollTo(int i, int i2) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i = 0;
            }
            if (!canScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(i, i2);
        }
    }

    private void consumePendingUpdateOperations() {
        this.mUpdateChildViewsRunnable.run();
    }

    void scrollByInternal(int i, int i2) {
        int scrollHorizontallyBy;
        int i3;
        int scrollVerticallyBy;
        int i4;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            eatRequestLayout();
            this.mRunningLayoutOrScroll = true;
            if (i != 0) {
                scrollHorizontallyBy = this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState);
                i3 = i - scrollHorizontallyBy;
            } else {
                scrollHorizontallyBy = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                scrollVerticallyBy = this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState);
                i4 = i2 - scrollVerticallyBy;
            } else {
                scrollVerticallyBy = 0;
                i4 = 0;
            }
            if (supportsChangeAnimations()) {
                int b = this.mChildHelper.m1738b();
                for (int i5 = 0; i5 < b; i5++) {
                    View b2 = this.mChildHelper.m1740b(i5);
                    bg childViewHolder = getChildViewHolder(b2);
                    if (!(childViewHolder == null || childViewHolder.f643h == null)) {
                        childViewHolder = childViewHolder.f643h;
                        View view = childViewHolder != null ? childViewHolder.f636a : null;
                        if (view != null) {
                            int left = b2.getLeft();
                            int top = b2.getTop();
                            if (left != view.getLeft() || top != view.getTop()) {
                                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                            }
                        }
                    }
                }
            }
            this.mRunningLayoutOrScroll = false;
            resumeRequestLayout(false);
            int i6 = scrollHorizontallyBy;
            scrollHorizontallyBy = i4;
            i4 = i6;
        } else {
            scrollVerticallyBy = 0;
            i4 = 0;
            scrollHorizontallyBy = 0;
            i3 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (ay.m565a(this) != 2) {
            considerReleasingGlowsOnScroll(i, i2);
            pullGlows(i3, scrollHorizontallyBy);
        }
        if (!(i4 == 0 && scrollVerticallyBy == 0)) {
            onScrollChanged(0, 0, 0, 0);
            if (this.mScrollListener != null) {
                this.mScrollListener.m1582a(this, i4, scrollVerticallyBy);
            }
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
    }

    protected int computeHorizontalScrollOffset() {
        return this.mLayout.canScrollHorizontally() ? this.mLayout.computeHorizontalScrollOffset(this.mState) : 0;
    }

    protected int computeHorizontalScrollExtent() {
        return this.mLayout.canScrollHorizontally() ? this.mLayout.computeHorizontalScrollExtent(this.mState) : 0;
    }

    protected int computeHorizontalScrollRange() {
        return this.mLayout.canScrollHorizontally() ? this.mLayout.computeHorizontalScrollRange(this.mState) : 0;
    }

    protected int computeVerticalScrollOffset() {
        return this.mLayout.canScrollVertically() ? this.mLayout.computeVerticalScrollOffset(this.mState) : 0;
    }

    protected int computeVerticalScrollExtent() {
        return this.mLayout.canScrollVertically() ? this.mLayout.computeVerticalScrollExtent(this.mState) : 0;
    }

    protected int computeVerticalScrollRange() {
        return this.mLayout.canScrollVertically() ? this.mLayout.computeVerticalScrollRange(this.mState) : 0;
    }

    void eatRequestLayout() {
        if (!this.mEatRequestLayout) {
            this.mEatRequestLayout = true;
            this.mLayoutRequestEaten = false;
        }
    }

    void resumeRequestLayout(boolean z) {
        if (this.mEatRequestLayout) {
            if (z && this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            this.mEatRequestLayout = false;
            this.mLayoutRequestEaten = false;
        }
    }

    public void smoothScrollBy(int i, int i2) {
        if (i != 0 || i2 != 0) {
            this.mViewFlinger.m1666b(i, i2);
        }
    }

    public boolean fling(int i, int i2) {
        if (Math.abs(i) < this.mMinFlingVelocity) {
            i = 0;
        }
        if (Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        int max = Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity));
        int max2 = Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity));
        if (max == 0 && max2 == 0) {
            return false;
        }
        this.mViewFlinger.m1661a(max, max2);
        return true;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m1665b();
        this.mLayout.stopSmoothScroller();
    }

    private void pullGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.m1264a(((float) (-i)) / ((float) getWidth()));
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.m1264a(((float) i) / ((float) getWidth()));
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.m1264a(((float) (-i2)) / ((float) getHeight()));
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.m1264a(((float) i2) / ((float) getHeight()));
        }
        if (i != 0 || i2 != 0) {
            ay.m581d(this);
        }
    }

    private void releaseGlows() {
        int i = 0;
        if (this.mLeftGlow != null) {
            i = this.mLeftGlow.m1268c();
        }
        if (this.mTopGlow != null) {
            i |= this.mTopGlow.m1268c();
        }
        if (this.mRightGlow != null) {
            i |= this.mRightGlow.m1268c();
        }
        if (this.mBottomGlow != null) {
            i |= this.mBottomGlow.m1268c();
        }
        if (i != 0) {
            ay.m581d(this);
        }
    }

    private void considerReleasingGlowsOnScroll(int i, int i2) {
        int i3 = 0;
        if (!(this.mLeftGlow == null || this.mLeftGlow.m1263a() || i <= 0)) {
            i3 = this.mLeftGlow.m1268c();
        }
        if (!(this.mRightGlow == null || this.mRightGlow.m1263a() || i >= 0)) {
            i3 |= this.mRightGlow.m1268c();
        }
        if (!(this.mTopGlow == null || this.mTopGlow.m1263a() || i2 <= 0)) {
            i3 |= this.mTopGlow.m1268c();
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.m1263a() || i2 >= 0)) {
            i3 |= this.mBottomGlow.m1268c();
        }
        if (i3 != 0) {
            ay.m581d(this);
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.m1265a(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.m1265a(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.m1265a(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.m1265a(i2);
        }
        if (i != 0 || i2 != 0) {
            ay.m581d(this);
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = new C0167w(getContext());
            if (this.mClipToPadding) {
                this.mLeftGlow.m1262a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.m1262a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = new C0167w(getContext());
            if (this.mClipToPadding) {
                this.mRightGlow.m1262a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.m1262a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = new C0167w(getContext());
            if (this.mClipToPadding) {
                this.mTopGlow.m1262a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.m1262a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = new C0167w(getContext());
            if (this.mClipToPadding) {
                this.mBottomGlow.m1262a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.m1262a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public View focusSearch(View view, int i) {
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        onInterceptFocusSearch = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (onInterceptFocusSearch == null && this.mAdapter != null) {
            eatRequestLayout();
            onInterceptFocusSearch = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
            resumeRequestLayout(false);
        }
        return onInterceptFocusSearch == null ? super.focusSearch(view, i) : onInterceptFocusSearch;
    }

    public void requestChildFocus(View view, View view2) {
        boolean z = false;
        if (!(this.mLayout.onRequestChildFocus(this, this.mState, view, view2) || view2 == null)) {
            this.mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            Rect rect = this.mTempRect;
            if (!this.mFirstLayoutComplete) {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (!this.mLayout.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        this.mFirstLayoutComplete = false;
        if (this.mLayout != null) {
            this.mLayout.onAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo459c();
        }
        this.mFirstLayoutComplete = false;
        stopScroll();
        this.mIsAttached = false;
        if (this.mLayout != null) {
            this.mLayout.onDetachedFromWindow(this, this.mRecycler);
        }
        removeCallbacks(this.mItemAnimatorRunner);
    }

    void assertInLayoutOrScroll(String str) {
        if (!this.mRunningLayoutOrScroll) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (!this.mRunningLayoutOrScroll) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public void addOnItemTouchListener(au auVar) {
        this.mOnItemTouchListeners.add(auVar);
    }

    public void removeOnItemTouchListener(au auVar) {
        this.mOnItemTouchListeners.remove(auVar);
        if (this.mActiveOnItemTouchListener == auVar) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            au auVar = (au) this.mOnItemTouchListeners.get(i);
            if (!auVar.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mActiveOnItemTouchListener = auVar;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i = 0; i < size; i++) {
                au auVar = (au) this.mOnItemTouchListeners.get(i);
                if (auVar.onInterceptTouchEvent(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = auVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        }
        boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int a = ae.m516a(motionEvent);
        int b = ae.m518b(motionEvent);
        int x;
        switch (a) {
            case 0:
                this.mScrollPointerId = ae.m519b(motionEvent, 0);
                x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                x = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = x;
                this.mInitialTouchY = x;
                if (this.mScrollState == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    break;
                }
                break;
            case 1:
                this.mVelocityTracker.clear();
                break;
            case 2:
                a = ae.m517a(motionEvent, this.mScrollPointerId);
                if (a >= 0) {
                    b = (int) (ae.m520c(motionEvent, a) + 0.5f);
                    a = (int) (ae.m522d(motionEvent, a) + 0.5f);
                    if (this.mScrollState != 1) {
                        b -= this.mInitialTouchX;
                        a -= this.mInitialTouchY;
                        if (!canScrollHorizontally || Math.abs(b) <= this.mTouchSlop) {
                            canScrollHorizontally = false;
                        } else {
                            this.mLastTouchX = ((b < 0 ? -1 : 1) * this.mTouchSlop) + this.mInitialTouchX;
                            canScrollHorizontally = true;
                        }
                        if (canScrollVertically && Math.abs(a) > this.mTouchSlop) {
                            x = this.mInitialTouchY;
                            int i2 = this.mTouchSlop;
                            if (a >= 0) {
                                i = 1;
                            }
                            this.mLastTouchY = x + (i * i2);
                            canScrollHorizontally = true;
                        }
                        if (canScrollHorizontally) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            setScrollState(1);
                            break;
                        }
                    }
                }
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
                break;
            case 3:
                cancelTouch();
                break;
            case 5:
                this.mScrollPointerId = ae.m519b(motionEvent, b);
                x = (int) (ae.m520c(motionEvent, b) + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                x = (int) (ae.m522d(motionEvent, b) + 0.5f);
                this.mLastTouchY = x;
                this.mInitialTouchY = x;
                break;
            case 6:
                onPointerUp(motionEvent);
                break;
        }
        if (this.mScrollState != 1) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        }
        boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int a = ae.m516a(motionEvent);
        int b = ae.m518b(motionEvent);
        switch (a) {
            case 0:
                this.mScrollPointerId = ae.m519b(motionEvent, 0);
                a = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = a;
                this.mInitialTouchX = a;
                a = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = a;
                this.mInitialTouchY = a;
                return true;
            case 1:
                this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
                float f = canScrollHorizontally ? -at.m555a(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                float f2;
                if (canScrollVertically) {
                    f2 = -at.m556b(this.mVelocityTracker, this.mScrollPointerId);
                } else {
                    f2 = 0.0f;
                }
                if ((f == 0.0f && r0 == 0.0f) || !fling((int) f, (int) r0)) {
                    setScrollState(0);
                }
                this.mVelocityTracker.clear();
                releaseGlows();
                return true;
            case 2:
                a = ae.m517a(motionEvent, this.mScrollPointerId);
                if (a < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int c = (int) (ae.m520c(motionEvent, a) + 0.5f);
                b = (int) (ae.m522d(motionEvent, a) + 0.5f);
                if (this.mScrollState != 1) {
                    boolean z;
                    a = c - this.mInitialTouchX;
                    int i2 = b - this.mInitialTouchY;
                    if (!canScrollHorizontally || Math.abs(a) <= this.mTouchSlop) {
                        z = false;
                    } else {
                        this.mLastTouchX = ((a < 0 ? -1 : 1) * this.mTouchSlop) + this.mInitialTouchX;
                        z = true;
                    }
                    if (canScrollVertically && Math.abs(i2) > this.mTouchSlop) {
                        a = this.mInitialTouchY;
                        int i3 = this.mTouchSlop;
                        if (i2 >= 0) {
                            i = 1;
                        }
                        this.mLastTouchY = a + (i * i3);
                        z = true;
                    }
                    if (z) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                }
                if (this.mScrollState == 1) {
                    scrollByInternal(canScrollHorizontally ? -(c - this.mLastTouchX) : 0, canScrollVertically ? -(b - this.mLastTouchY) : 0);
                }
                this.mLastTouchX = c;
                this.mLastTouchY = b;
                return true;
            case 3:
                cancelTouch();
                return true;
            case 5:
                this.mScrollPointerId = ae.m519b(motionEvent, b);
                a = (int) (ae.m520c(motionEvent, b) + 0.5f);
                this.mLastTouchX = a;
                this.mInitialTouchX = a;
                a = (int) (ae.m522d(motionEvent, b) + 0.5f);
                this.mLastTouchY = a;
                this.mInitialTouchY = a;
                return true;
            case 6:
                onPointerUp(motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void cancelTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        releaseGlows();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int b = ae.m518b(motionEvent);
        if (ae.m519b(motionEvent, b) == this.mScrollPointerId) {
            b = b == 0 ? 1 : 0;
            this.mScrollPointerId = ae.m519b(motionEvent, b);
            int c = (int) (ae.m520c(motionEvent, b) + 0.5f);
            this.mLastTouchX = c;
            this.mInitialTouchX = c;
            b = (int) (ae.m522d(motionEvent, b) + 0.5f);
            this.mLastTouchY = b;
            this.mInitialTouchY = b;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mAdapterUpdateDuringMeasure) {
            eatRequestLayout();
            processAdapterUpdatesAndSetAnimationFlags();
            if (this.mState.f628l) {
                this.mState.f626j = true;
            } else {
                this.mAdapterHelper.m1446e();
                this.mState.f626j = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            resumeRequestLayout(false);
        }
        if (this.mAdapter != null) {
            this.mState.f620d = this.mAdapter.mo4327a();
        } else {
            this.mState.f620d = 0;
        }
        this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        this.mState.f626j = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(an anVar) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo459c();
            this.mItemAnimator.m1542a(null);
        }
        this.mItemAnimator = anVar;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m1542a(this.mItemAnimatorListener);
        }
    }

    public an getItemAnimator() {
        return this.mItemAnimator;
    }

    private boolean supportsChangeAnimations() {
        return this.mItemAnimator != null && this.mItemAnimator.m1563h();
    }

    private void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ay.m571a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        boolean z2 = true;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m1439a();
            markKnownViewsInvalid();
            this.mLayout.onItemsChanged(this);
        }
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            this.mAdapterHelper.m1446e();
        } else {
            this.mAdapterHelper.m1443b();
        }
        boolean z3;
        if ((this.mItemsAddedOrRemoved && !this.mItemsChanged) || this.mItemsAddedOrRemoved || (this.mItemsChanged && supportsChangeAnimations())) {
            z3 = true;
        } else {
            z3 = false;
        }
        bd bdVar = this.mState;
        if (!this.mFirstLayoutComplete || this.mItemAnimator == null || (!(this.mDataSetHasChangedAfterLayout || r0 || this.mLayout.mRequestedSimpleAnimations) || (this.mDataSetHasChangedAfterLayout && !this.mAdapter.m1536b()))) {
            z = false;
        } else {
            z = true;
        }
        bdVar.f627k = z;
        bd bdVar2 = this.mState;
        if (!(this.mState.f627k && r0 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())) {
            z2 = false;
        }
        bdVar2.f628l = z2;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        int b;
        int i;
        bg childViewHolderInt;
        int b2;
        int i2;
        boolean c;
        int i3;
        C0059a c0059a;
        this.mDisappearingViewsInLayoutPass.clear();
        eatRequestLayout();
        this.mRunningLayoutOrScroll = true;
        processAdapterUpdatesAndSetAnimationFlags();
        bd bdVar = this.mState;
        C0059a c0059a2 = (this.mState.f627k && this.mItemsChanged && supportsChangeAnimations()) ? new C0059a() : null;
        bdVar.f619c = c0059a2;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.f626j = this.mState.f628l;
        this.mState.f620d = this.mAdapter.mo4327a();
        if (this.mState.f627k) {
            this.mState.f617a.clear();
            this.mState.f618b.clear();
            b = this.mChildHelper.m1738b();
            for (i = 0; i < b; i++) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1740b(i));
                if (!childViewHolderInt.m1677c() && (!childViewHolderInt.m1687m() || this.mAdapter.m1536b())) {
                    View view = childViewHolderInt.f636a;
                    this.mState.f617a.put(childViewHolderInt, new as(childViewHolderInt, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
            }
        }
        bg childViewHolderInt2;
        if (this.mState.f628l) {
            saveOldPositions();
            if (this.mState.f619c != null) {
                b2 = this.mChildHelper.m1738b();
                for (i2 = 0; i2 < b2; i2++) {
                    childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m1740b(i2));
                    if (!(!childViewHolderInt2.m1689o() || childViewHolderInt2.m1691q() || childViewHolderInt2.m1677c())) {
                        this.mState.f619c.put(Long.valueOf(getChangedHolderKey(childViewHolderInt2)), childViewHolderInt2);
                        this.mState.f617a.remove(childViewHolderInt2);
                    }
                }
            }
            c = this.mState.f625i;
            this.mState.f625i = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.f625i = c;
            C0059a c0059a3 = new C0059a();
            for (b2 = 0; b2 < this.mChildHelper.m1738b(); b2++) {
                View b3 = this.mChildHelper.m1740b(b2);
                if (!getChildViewHolderInt(b3).m1677c()) {
                    for (i3 = 0; i3 < this.mState.f617a.size(); i3++) {
                        if (((bg) this.mState.f617a.m59b(i3)).f636a == b3) {
                            c = true;
                            break;
                        }
                    }
                    c = false;
                    if (!c) {
                        c0059a3.put(b3, new Rect(b3.getLeft(), b3.getTop(), b3.getRight(), b3.getBottom()));
                    }
                }
            }
            clearOldPositions();
            this.mAdapterHelper.m1444c();
            c0059a = c0059a3;
        } else {
            clearOldPositions();
            this.mAdapterHelper.m1446e();
            if (this.mState.f619c != null) {
                b2 = this.mChildHelper.m1738b();
                for (i2 = 0; i2 < b2; i2++) {
                    childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m1740b(i2));
                    if (!(!childViewHolderInt2.m1689o() || childViewHolderInt2.m1691q() || childViewHolderInt2.m1677c())) {
                        this.mState.f619c.put(Long.valueOf(getChangedHolderKey(childViewHolderInt2)), childViewHolderInt2);
                        this.mState.f617a.remove(childViewHolderInt2);
                    }
                }
            }
            c0059a = null;
        }
        this.mState.f620d = this.mAdapter.mo4327a();
        this.mState.f624h = 0;
        this.mState.f626j = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.f625i = false;
        this.mPendingSavedState = null;
        bdVar = this.mState;
        c = this.mState.f627k && this.mItemAnimator != null;
        bdVar.f627k = c;
        if (this.mState.f627k) {
            C0059a c0059a4;
            bg bgVar;
            if (this.mState.f619c != null) {
                c0059a4 = new C0059a();
            } else {
                c0059a4 = null;
            }
            int b4 = this.mChildHelper.m1738b();
            for (b = 0; b < b4; b++) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1740b(b));
                if (!childViewHolderInt.m1677c()) {
                    view = childViewHolderInt.f636a;
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    if (c0059a4 == null || this.mState.f619c.get(Long.valueOf(changedHolderKey)) == null) {
                        this.mState.f618b.put(childViewHolderInt, new as(childViewHolderInt, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    } else {
                        c0059a4.put(Long.valueOf(changedHolderKey), childViewHolderInt);
                    }
                }
            }
            processDisappearingList(c0059a);
            for (b2 = this.mState.f617a.size() - 1; b2 >= 0; b2--) {
                if (!this.mState.f618b.containsKey((bg) this.mState.f617a.m59b(b2))) {
                    as asVar = (as) this.mState.f617a.m60c(b2);
                    this.mState.f617a.m61d(b2);
                    View view2 = asVar.f594a.f636a;
                    this.mRecycler.m1614c(asVar.f594a);
                    animateDisappearance(asVar);
                }
            }
            i2 = this.mState.f618b.size();
            if (i2 > 0) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    bgVar = (bg) this.mState.f618b.m59b(i4);
                    as asVar2 = (as) this.mState.f618b.m60c(i4);
                    if (this.mState.f617a.isEmpty() || !this.mState.f617a.containsKey(bgVar)) {
                        Rect rect;
                        this.mState.f618b.m61d(i4);
                        if (c0059a != null) {
                            rect = (Rect) c0059a.get(bgVar.f636a);
                        } else {
                            rect = null;
                        }
                        animateAppearance(bgVar, rect, asVar2.f595b, asVar2.f596c);
                    }
                }
            }
            b = this.mState.f618b.size();
            for (i = 0; i < b; i++) {
                childViewHolderInt = (bg) this.mState.f618b.m59b(i);
                as asVar3 = (as) this.mState.f618b.m60c(i);
                as asVar4 = (as) this.mState.f617a.get(childViewHolderInt);
                if (!(asVar4 == null || asVar3 == null || (asVar4.f595b == asVar3.f595b && asVar4.f596c == asVar3.f596c))) {
                    childViewHolderInt.m1675a(false);
                    if (this.mItemAnimator.mo455a(childViewHolderInt, asVar4.f595b, asVar4.f596c, asVar3.f595b, asVar3.f596c)) {
                        postAnimationRunner();
                    }
                }
            }
            if (this.mState.f619c != null) {
                i2 = this.mState.f619c.size();
            } else {
                i2 = 0;
            }
            for (i3 = i2 - 1; i3 >= 0; i3--) {
                long longValue = ((Long) this.mState.f619c.m59b(i3)).longValue();
                bgVar = (bg) this.mState.f619c.get(Long.valueOf(longValue));
                View view3 = bgVar.f636a;
                if (!(bgVar.m1677c() || this.mRecycler.f605d == null || !this.mRecycler.f605d.contains(bgVar))) {
                    animateChange(bgVar, (bg) c0059a4.get(Long.valueOf(longValue)));
                }
            }
        }
        resumeRequestLayout(false);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mState.f623g = this.mState.f620d;
        this.mDataSetHasChangedAfterLayout = false;
        this.mState.f627k = false;
        this.mState.f628l = false;
        this.mRunningLayoutOrScroll = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f605d != null) {
            this.mRecycler.f605d.clear();
        }
        this.mState.f619c = null;
    }

    protected void removeDetachedView(View view, boolean z) {
        bg childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.m1692r()) {
                childViewHolderInt.m1685k();
            } else if (!childViewHolderInt.m1677c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt);
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(bg bgVar) {
        return this.mAdapter.m1536b() ? bgVar.m1679e() : (long) bgVar.f637b;
    }

    private void processDisappearingList(C0059a<View, Rect> c0059a) {
        int size = this.mDisappearingViewsInLayoutPass.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.mDisappearingViewsInLayoutPass.get(i);
            bg childViewHolderInt = getChildViewHolderInt(view);
            as asVar = (as) this.mState.f617a.remove(childViewHolderInt);
            if (!this.mState.m1648a()) {
                this.mState.f618b.remove(childViewHolderInt);
            }
            if (c0059a.remove(view) != null) {
                this.mLayout.removeAndRecycleView(view, this.mRecycler);
            } else if (asVar != null) {
                animateDisappearance(asVar);
            } else {
                animateDisappearance(new as(childViewHolderInt, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }
        this.mDisappearingViewsInLayoutPass.clear();
    }

    private void animateAppearance(bg bgVar, Rect rect, int i, int i2) {
        View view = bgVar.f636a;
        if (rect == null || (rect.left == i && rect.top == i2)) {
            bgVar.m1675a(false);
            if (this.mItemAnimator.mo458b(bgVar)) {
                postAnimationRunner();
                return;
            }
            return;
        }
        bgVar.m1675a(false);
        if (this.mItemAnimator.mo455a(bgVar, rect.left, rect.top, i, i2)) {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(as asVar) {
        View view = asVar.f594a.f636a;
        addAnimatingView(asVar.f594a);
        int i = asVar.f595b;
        int i2 = asVar.f596c;
        int left = view.getLeft();
        int top = view.getTop();
        if (i == left && i2 == top) {
            asVar.f594a.m1675a(false);
            if (this.mItemAnimator.mo454a(asVar.f594a)) {
                postAnimationRunner();
                return;
            }
            return;
        }
        asVar.f594a.m1675a(false);
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        if (this.mItemAnimator.mo455a(asVar.f594a, i, i2, left, top)) {
            postAnimationRunner();
        }
    }

    private void animateChange(bg bgVar, bg bgVar2) {
        int i;
        int i2;
        bgVar.m1675a(false);
        addAnimatingView(bgVar);
        bgVar.f642g = bgVar2;
        this.mRecycler.m1614c(bgVar);
        int left = bgVar.f636a.getLeft();
        int top = bgVar.f636a.getTop();
        if (bgVar2 == null || bgVar2.m1677c()) {
            i = top;
            i2 = left;
        } else {
            i2 = bgVar2.f636a.getLeft();
            i = bgVar2.f636a.getTop();
            bgVar2.m1675a(false);
            bgVar2.f643h = bgVar;
        }
        if (this.mItemAnimator.mo456a(bgVar, bgVar2, left, top, i2, i)) {
            postAnimationRunner();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        eatRequestLayout();
        dispatchLayout();
        resumeRequestLayout(false);
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mEatRequestLayout) {
            this.mLayoutRequestEaten = true;
        } else {
            super.requestLayout();
        }
    }

    void markItemDecorInsetsDirty() {
        int c = this.mChildHelper.m1741c();
        for (int i = 0; i < c; i++) {
            ((LayoutParams) this.mChildHelper.m1742c(i).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.m1625i();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        for (i = 0; i < size; i++) {
            ((ar) this.mItemDecorations.get(i)).onDrawOver(canvas, this, this.mState);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.m1263a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.mLeftGlow == null || !this.mLeftGlow.m1266a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.mTopGlow == null || this.mTopGlow.m1263a())) {
            size = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.mTopGlow == null || !this.mTopGlow.m1266a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.mRightGlow == null || this.mRightGlow.m1263a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.mRightGlow == null || !this.mRightGlow.m1266a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.m1263a())) {
            i = canvas.save();
            canvas.rotate(BitmapDescriptorFactory.HUE_CYAN);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow != null && this.mBottomGlow.m1266a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.mo457b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ay.m581d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            ((ar) this.mItemDecorations.get(i)).onDraw(canvas, this, this.mState);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void saveOldPositions() {
        int c = this.mChildHelper.m1741c();
        for (int i = 0; i < c; i++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i));
            if (!childViewHolderInt.m1677c()) {
                childViewHolderInt.m1676b();
            }
        }
    }

    void clearOldPositions() {
        int c = this.mChildHelper.m1741c();
        for (int i = 0; i < c; i++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i));
            if (!childViewHolderInt.m1677c()) {
                childViewHolderInt.m1669a();
            }
        }
        this.mRecycler.m1624h();
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int c = this.mChildHelper.m1741c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i6));
            if (childViewHolderInt != null && childViewHolderInt.f637b >= r3 && childViewHolderInt.f637b <= r2) {
                if (childViewHolderInt.f637b == i) {
                    childViewHolderInt.m1673a(i2 - i, false);
                } else {
                    childViewHolderInt.m1673a(i3, false);
                }
                this.mState.f625i = true;
            }
        }
        this.mRecycler.m1599a(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int c = this.mChildHelper.m1741c();
        for (int i3 = 0; i3 < c; i3++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i3));
            if (!(childViewHolderInt == null || childViewHolderInt.m1677c() || childViewHolderInt.f637b < i)) {
                childViewHolderInt.m1673a(i2, false);
                this.mState.f625i = true;
            }
        }
        this.mRecycler.m1607b(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.mChildHelper.m1741c();
        for (int i4 = 0; i4 < c; i4++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i4));
            if (!(childViewHolderInt == null || childViewHolderInt.m1677c())) {
                if (childViewHolderInt.f637b >= i3) {
                    childViewHolderInt.m1673a(-i2, z);
                    this.mState.f625i = true;
                } else if (childViewHolderInt.f637b >= i) {
                    childViewHolderInt.m1672a(i - 1, -i2, z);
                    this.mState.f625i = true;
                }
            }
        }
        this.mRecycler.m1608b(i, i2, z);
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2) {
        int c = this.mChildHelper.m1741c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.mChildHelper.m1742c(i4);
            bg childViewHolderInt = getChildViewHolderInt(c2);
            if (childViewHolderInt != null && !childViewHolderInt.m1677c() && childViewHolderInt.f637b >= i && childViewHolderInt.f637b < i3) {
                childViewHolderInt.m1670a(2);
                if (supportsChangeAnimations()) {
                    childViewHolderInt.m1670a(64);
                }
                ((LayoutParams) c2.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.m1613c(i, i2);
    }

    void rebindUpdatedViewHolders() {
        int b = this.mChildHelper.m1738b();
        for (int i = 0; i < b; i++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1740b(i));
            if (!(childViewHolderInt == null || childViewHolderInt.m1677c())) {
                if (childViewHolderInt.m1691q() || childViewHolderInt.m1687m()) {
                    requestLayout();
                } else if (childViewHolderInt.m1688n()) {
                    if (childViewHolderInt.m1680f() != this.mAdapter.m1524a(childViewHolderInt.f637b)) {
                        childViewHolderInt.m1670a(4);
                        requestLayout();
                    } else if (childViewHolderInt.m1689o() && supportsChangeAnimations()) {
                        requestLayout();
                    } else {
                        this.mAdapter.m1535b(childViewHolderInt, childViewHolderInt.f637b);
                    }
                }
            }
        }
    }

    void markKnownViewsInvalid() {
        int c = this.mChildHelper.m1741c();
        for (int i = 0; i < c; i++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i));
            if (!(childViewHolderInt == null || childViewHolderInt.m1677c())) {
                childViewHolderInt.m1670a(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m1623g();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public bg getChildViewHolder(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static bg getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public int getChildPosition(View view) {
        bg childViewHolderInt = getChildViewHolderInt(view);
        return childViewHolderInt != null ? childViewHolderInt.m1678d() : -1;
    }

    public long getChildItemId(View view) {
        if (this.mAdapter == null || !this.mAdapter.m1536b()) {
            return -1;
        }
        bg childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.m1679e();
        }
        return -1;
    }

    public bg findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    bg findViewHolderForPosition(int i, boolean z) {
        int c = this.mChildHelper.m1741c();
        for (int i2 = 0; i2 < c; i2++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.m1691q())) {
                if (z) {
                    if (childViewHolderInt.f637b == i) {
                        return childViewHolderInt;
                    }
                } else if (childViewHolderInt.m1678d() == i) {
                    return childViewHolderInt;
                }
            }
        }
        return null;
    }

    public bg findViewHolderForItemId(long j) {
        int c = this.mChildHelper.m1741c();
        for (int i = 0; i < c; i++) {
            bg childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m1742c(i));
            if (childViewHolderInt != null && childViewHolderInt.m1679e() == j) {
                return childViewHolderInt;
            }
        }
        return null;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.mChildHelper.m1738b() - 1; b >= 0; b--) {
            View b2 = this.mChildHelper.m1740b(b);
            float m = ay.m593m(b2);
            float n = ay.m594n(b2);
            if (f >= ((float) b2.getLeft()) + m && f <= m + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + n && f2 <= ((float) b2.getBottom()) + n) {
                return b2;
            }
        }
        return null;
    }

    public void offsetChildrenVertical(int i) {
        int b = this.mChildHelper.m1738b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.m1740b(i2).offsetTopAndBottom(i);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.mChildHelper.m1738b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.m1740b(i2).offsetLeftAndRight(i);
        }
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            ((ar) this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    private void dispatchChildDetached(View view) {
        if (this.mAdapter != null) {
            this.mAdapter.m1538c(getChildViewHolderInt(view));
        }
        onChildDetachedFromWindow(view);
    }

    private void dispatchChildAttached(View view) {
        if (this.mAdapter != null) {
            this.mAdapter.m1534b(getChildViewHolderInt(view));
        }
        onChildAttachedToWindow(view);
    }

    private void removeFromDisappearingList(View view) {
        this.mDisappearingViewsInLayoutPass.remove(view);
    }

    private void addToDisappearingList(View view) {
        if (!this.mDisappearingViewsInLayoutPass.contains(view)) {
            this.mDisappearingViewsInLayoutPass.add(view);
        }
    }
}
