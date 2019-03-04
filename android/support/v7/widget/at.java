package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ay;
import android.support.v4.view.p005a.C0094a;
import android.support.v4.view.p005a.C0098e;
import android.support.v4.view.p005a.C0106m;
import android.support.v4.view.p005a.C0107n;
import android.support.v4.view.p005a.ag;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

/* compiled from: RecyclerView */
public abstract class at {
    C0176d mChildHelper;
    RecyclerView mRecyclerView;
    private boolean mRequestedSimpleAnimations = false;
    bb mSmoothScroller;

    public abstract LayoutParams generateDefaultLayoutParams();

    void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            return;
        }
        this.mRecyclerView = recyclerView;
        this.mChildHelper = recyclerView.mChildHelper;
    }

    public void requestLayout() {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.requestLayout();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.assertInLayoutOrScroll(str);
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
    }

    @Deprecated
    public void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, ax axVar) {
        onDetachedFromWindow(recyclerView);
    }

    public boolean getClipToPadding() {
        return this.mRecyclerView != null && this.mRecyclerView.mClipToPadding;
    }

    public void onLayoutChildren(ax axVar, bd bdVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int scrollHorizontallyBy(int i, ax axVar, bd bdVar) {
        return 0;
    }

    public int scrollVerticallyBy(int i, ax axVar, bd bdVar) {
        return 0;
    }

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return false;
    }

    public void scrollToPosition(int i) {
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, bd bdVar, int i) {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void startSmoothScroll(bb bbVar) {
        if (!(this.mSmoothScroller == null || bbVar == this.mSmoothScroller || !this.mSmoothScroller.isRunning())) {
            this.mSmoothScroller.stop();
        }
        this.mSmoothScroller = bbVar;
        this.mSmoothScroller.start(this.mRecyclerView, this);
    }

    public boolean isSmoothScrolling() {
        return this.mSmoothScroller != null && this.mSmoothScroller.isRunning();
    }

    public int getLayoutDirection() {
        return ay.m588h(this.mRecyclerView);
    }

    public void endAnimation(View view) {
        if (this.mRecyclerView.mItemAnimator != null) {
            this.mRecyclerView.mItemAnimator.mo460c(RecyclerView.getChildViewHolderInt(view));
        }
    }

    public void addDisappearingView(View view) {
        addDisappearingView(view, -1);
    }

    public void addDisappearingView(View view, int i) {
        addViewInt(view, i, true);
    }

    public void addView(View view) {
        addView(view, -1);
    }

    public void addView(View view, int i) {
        addViewInt(view, i, false);
    }

    private void addViewInt(View view, int i, boolean z) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (z || childViewHolderInt.m1691q()) {
            this.mRecyclerView.addToDisappearingList(view);
        } else {
            this.mRecyclerView.removeFromDisappearingList(view);
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (childViewHolderInt.m1683i() || childViewHolderInt.m1681g()) {
            if (childViewHolderInt.m1681g()) {
                childViewHolderInt.m1682h();
            } else {
                childViewHolderInt.m1684j();
            }
            this.mChildHelper.m1735a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.mRecyclerView) {
            int b = this.mChildHelper.m1739b(view);
            if (i == -1) {
                i = this.mChildHelper.m1738b();
            }
            if (b == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view));
            } else if (b != i) {
                this.mRecyclerView.mLayout.moveView(b, i);
            }
        } else {
            this.mChildHelper.m1736a(view, i, false);
            layoutParams.mInsetsDirty = true;
            if (this.mSmoothScroller != null && this.mSmoothScroller.isRunning()) {
                this.mSmoothScroller.onChildAttachedToWindow(view);
            }
        }
        if (layoutParams.mPendingInvalidate) {
            childViewHolderInt.f636a.invalidate();
            layoutParams.mPendingInvalidate = false;
        }
    }

    public void removeView(View view) {
        this.mChildHelper.m1734a(view);
    }

    public void removeViewAt(int i) {
        if (getChildAt(i) != null) {
            this.mChildHelper.m1733a(i);
        }
    }

    public void removeAllViews() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount);
            this.mChildHelper.m1733a(childCount);
        }
    }

    public int getPosition(View view) {
        return ((LayoutParams) view.getLayoutParams()).getViewPosition();
    }

    public int getItemViewType(View view) {
        return RecyclerView.getChildViewHolderInt(view).m1680f();
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            bg childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null && childViewHolderInt.m1678d() == i && !childViewHolderInt.m1677c() && (this.mRecyclerView.mState.m1648a() || !childViewHolderInt.m1691q())) {
                return childAt;
            }
        }
        return null;
    }

    public void detachView(View view) {
        int b = this.mChildHelper.m1739b(view);
        if (b >= 0) {
            detachViewInternal(b, view);
        }
    }

    public void detachViewAt(int i) {
        detachViewInternal(i, getChildAt(i));
    }

    private void detachViewInternal(int i, View view) {
        this.mChildHelper.m1744d(i);
    }

    public void attachView(View view, int i, LayoutParams layoutParams) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.m1691q()) {
            this.mRecyclerView.addToDisappearingList(view);
        } else {
            this.mRecyclerView.removeFromDisappearingList(view);
        }
        this.mChildHelper.m1735a(view, i, layoutParams, childViewHolderInt.m1691q());
    }

    public void attachView(View view, int i) {
        attachView(view, i, (LayoutParams) view.getLayoutParams());
    }

    public void attachView(View view) {
        attachView(view, -1);
    }

    public void removeDetachedView(View view) {
        this.mRecyclerView.removeDetachedView(view, false);
    }

    public void moveView(int i, int i2) {
        View childAt = getChildAt(i);
        if (childAt == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }
        detachViewAt(i);
        attachView(childAt, i2);
    }

    public void detachAndScrapView(View view, ax axVar) {
        scrapOrRecycleView(axVar, this.mChildHelper.m1739b(view), view);
    }

    public void detachAndScrapViewAt(int i, ax axVar) {
        scrapOrRecycleView(axVar, i, getChildAt(i));
    }

    public void removeAndRecycleView(View view, ax axVar) {
        removeView(view);
        axVar.m1603a(view);
    }

    public void removeAndRecycleViewAt(int i, ax axVar) {
        View childAt = getChildAt(i);
        removeViewAt(i);
        axVar.m1603a(childAt);
    }

    public int getChildCount() {
        return this.mChildHelper != null ? this.mChildHelper.m1738b() : 0;
    }

    public View getChildAt(int i) {
        return this.mChildHelper != null ? this.mChildHelper.m1740b(i) : null;
    }

    public int getWidth() {
        return this.mRecyclerView != null ? this.mRecyclerView.getWidth() : 0;
    }

    public int getHeight() {
        return this.mRecyclerView != null ? this.mRecyclerView.getHeight() : 0;
    }

    public int getPaddingLeft() {
        return this.mRecyclerView != null ? this.mRecyclerView.getPaddingLeft() : 0;
    }

    public int getPaddingTop() {
        return this.mRecyclerView != null ? this.mRecyclerView.getPaddingTop() : 0;
    }

    public int getPaddingRight() {
        return this.mRecyclerView != null ? this.mRecyclerView.getPaddingRight() : 0;
    }

    public int getPaddingBottom() {
        return this.mRecyclerView != null ? this.mRecyclerView.getPaddingBottom() : 0;
    }

    public int getPaddingStart() {
        return this.mRecyclerView != null ? ay.m591k(this.mRecyclerView) : 0;
    }

    public int getPaddingEnd() {
        return this.mRecyclerView != null ? ay.m592l(this.mRecyclerView) : 0;
    }

    public boolean isFocused() {
        return this.mRecyclerView != null && this.mRecyclerView.isFocused();
    }

    public boolean hasFocus() {
        return this.mRecyclerView != null && this.mRecyclerView.hasFocus();
    }

    public View getFocusedChild() {
        if (this.mRecyclerView == null) {
            return null;
        }
        View focusedChild = this.mRecyclerView.getFocusedChild();
        if (focusedChild == null || this.mChildHelper.m1743c(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public int getItemCount() {
        ak adapter = this.mRecyclerView != null ? this.mRecyclerView.getAdapter() : null;
        return adapter != null ? adapter.mo4327a() : 0;
    }

    public void offsetChildrenHorizontal(int i) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.offsetChildrenHorizontal(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.offsetChildrenVertical(i);
        }
    }

    public void ignoreView(View view) {
        if (view.getParent() != this.mRecyclerView || this.mRecyclerView.indexOfChild(view) == -1) {
            throw new IllegalArgumentException("View should be fully attached to be ignored");
        }
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.m1670a(128);
        this.mRecyclerView.mState.m1649b(childViewHolderInt);
    }

    public void stopIgnoringView(View view) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.m1686l();
        childViewHolderInt.m1693s();
        childViewHolderInt.m1670a(4);
    }

    public void detachAndScrapAttachedViews(ax axVar) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            scrapOrRecycleView(axVar, childCount, getChildAt(childCount));
        }
    }

    private void scrapOrRecycleView(ax axVar, int i, View view) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (!childViewHolderInt.m1677c()) {
            if (!childViewHolderInt.m1687m() || childViewHolderInt.m1691q() || childViewHolderInt.m1689o() || this.mRecyclerView.mAdapter.m1536b()) {
                detachViewAt(i);
                axVar.m1615c(view);
                return;
            }
            removeViewAt(i);
            axVar.m1609b(childViewHolderInt);
        }
    }

    void removeAndRecycleScrapInt(ax axVar) {
        int d = axVar.m1616d();
        for (int i = 0; i < d; i++) {
            View e = axVar.m1619e(i);
            bg childViewHolderInt = RecyclerView.getChildViewHolderInt(e);
            if (!childViewHolderInt.m1677c()) {
                if (childViewHolderInt.m1692r()) {
                    this.mRecyclerView.removeDetachedView(e, false);
                }
                axVar.m1610b(e);
            }
        }
        axVar.m1620e();
        if (d > 0) {
            this.mRecyclerView.invalidate();
        }
    }

    public void measureChild(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        view.measure(getChildMeasureSpec(getWidth(), ((itemDecorInsetsForChild.left + itemDecorInsetsForChild.right) + i) + (getPaddingLeft() + getPaddingRight()), layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), ((itemDecorInsetsForChild.bottom + itemDecorInsetsForChild.top) + i2) + (getPaddingTop() + getPaddingBottom()), layoutParams.height, canScrollVertically()));
    }

    public void measureChildWithMargins(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        view.measure(getChildMeasureSpec(getWidth(), ((itemDecorInsetsForChild.left + itemDecorInsetsForChild.right) + i) + (((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), ((itemDecorInsetsForChild.bottom + itemDecorInsetsForChild.top) + i2) + (((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, canScrollVertically()));
    }

    public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
        int i4 = 1073741824;
        int max = Math.max(0, i - i2);
        if (z) {
            if (i3 < 0) {
                i4 = 0;
                i3 = 0;
            }
        } else if (i3 < 0) {
            if (i3 == -1) {
                i3 = max;
            } else if (i3 == -2) {
                i4 = Integer.MIN_VALUE;
                i3 = max;
            } else {
                i4 = 0;
                i3 = 0;
            }
        }
        return MeasureSpec.makeMeasureSpec(i3, i4);
    }

    public int getDecoratedMeasuredWidth(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public int getDecoratedMeasuredHeight(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public int getDecoratedLeft(View view) {
        return view.getLeft() - getLeftDecorationWidth(view);
    }

    public int getDecoratedTop(View view) {
        return view.getTop() - getTopDecorationHeight(view);
    }

    public int getDecoratedRight(View view) {
        return view.getRight() + getRightDecorationWidth(view);
    }

    public int getDecoratedBottom(View view) {
        return view.getBottom() + getBottomDecorationHeight(view);
    }

    public void calculateItemDecorationsForChild(View view, Rect rect) {
        if (this.mRecyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.mRecyclerView.getItemDecorInsetsForChild(view));
        }
    }

    public int getTopDecorationHeight(View view) {
        return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
    }

    public int getBottomDecorationHeight(View view) {
        return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
    }

    public int getLeftDecorationWidth(View view) {
        return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
    }

    public int getRightDecorationWidth(View view) {
        return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
    }

    public View onFocusSearchFailed(View view, int i, ax axVar, bd bdVar) {
        return null;
    }

    public View onInterceptFocusSearch(View view, int i) {
        return null;
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int left = view.getLeft() + rect.left;
        int top = view.getTop() + rect.top;
        int width2 = rect.width() + left;
        int height2 = rect.height() + top;
        left = Math.min(0, left - paddingLeft);
        paddingTop = Math.min(0, top - paddingTop);
        paddingLeft = Math.max(0, width2 - width);
        width = Math.max(0, height2 - height);
        if (ay.m588h(recyclerView) == 1) {
            if (paddingLeft == 0) {
                paddingLeft = left;
            }
            left = paddingLeft;
        } else if (left == 0) {
            left = paddingLeft;
        }
        if (paddingTop != 0) {
            paddingLeft = paddingTop;
        } else {
            paddingLeft = width;
        }
        if (left == 0 && paddingLeft == 0) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(left, paddingLeft);
        } else {
            recyclerView.smoothScrollBy(left, paddingLeft);
        }
        return true;
    }

    @Deprecated
    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        return isSmoothScrolling() || recyclerView.mRunningLayoutOrScroll;
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, bd bdVar, View view, View view2) {
        return onRequestChildFocus(recyclerView, view, view2);
    }

    public void onAdapterChanged(ak akVar, ak akVar2) {
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        return false;
    }

    public void onItemsChanged(RecyclerView recyclerView) {
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
    }

    public int computeHorizontalScrollExtent(bd bdVar) {
        return 0;
    }

    public int computeHorizontalScrollOffset(bd bdVar) {
        return 0;
    }

    public int computeHorizontalScrollRange(bd bdVar) {
        return 0;
    }

    public int computeVerticalScrollExtent(bd bdVar) {
        return 0;
    }

    public int computeVerticalScrollOffset(bd bdVar) {
        return 0;
    }

    public int computeVerticalScrollRange(bd bdVar) {
        return 0;
    }

    public void onMeasure(ax axVar, bd bdVar, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size = getMinimumWidth();
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size2 = getMinimumHeight();
                break;
        }
        setMeasuredDimension(size, size2);
    }

    public void setMeasuredDimension(int i, int i2) {
        this.mRecyclerView.setMeasuredDimension(i, i2);
    }

    public int getMinimumWidth() {
        return ay.m595o(this.mRecyclerView);
    }

    public int getMinimumHeight() {
        return ay.m596p(this.mRecyclerView);
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    void stopSmoothScroller() {
        if (this.mSmoothScroller != null) {
            this.mSmoothScroller.stop();
        }
    }

    private void onSmoothScrollerStopped(bb bbVar) {
        if (this.mSmoothScroller == bbVar) {
            this.mSmoothScroller = null;
        }
    }

    public void onScrollStateChanged(int i) {
    }

    public void removeAndRecycleAllViews(ax axVar) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).m1677c()) {
                removeAndRecycleViewAt(childCount, axVar);
            }
        }
    }

    void onInitializeAccessibilityNodeInfo(C0098e c0098e) {
        onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, c0098e);
    }

    public void onInitializeAccessibilityNodeInfo(ax axVar, bd bdVar, C0098e c0098e) {
        c0098e.m249b(RecyclerView.class.getName());
        if (ay.m577b(this.mRecyclerView, -1) || ay.m574a(this.mRecyclerView, -1)) {
            c0098e.m240a(8192);
            c0098e.m269i(true);
        }
        if (ay.m577b(this.mRecyclerView, 1) || ay.m574a(this.mRecyclerView, 1)) {
            c0098e.m240a(4096);
            c0098e.m269i(true);
        }
        c0098e.m250b(C0106m.m423a(getRowCountForAccessibility(axVar, bdVar), getColumnCountForAccessibility(axVar, bdVar), isLayoutHierarchical(axVar, bdVar), getSelectionModeForAccessibility(axVar, bdVar)));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(ax axVar, bd bdVar, AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        ag a = C0094a.m200a(accessibilityEvent);
        if (this.mRecyclerView != null && a != null) {
            if (!(ay.m577b(this.mRecyclerView, 1) || ay.m577b(this.mRecyclerView, -1) || ay.m574a(this.mRecyclerView, -1) || ay.m574a(this.mRecyclerView, 1))) {
                z = false;
            }
            a.m212a(z);
            if (this.mRecyclerView.mAdapter != null) {
                a.m211a(this.mRecyclerView.mAdapter.mo4327a());
            }
        }
    }

    void onInitializeAccessibilityNodeInfoForItem(View view, C0098e c0098e) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null && !childViewHolderInt.m1691q()) {
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, c0098e);
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(ax axVar, bd bdVar, View view, C0098e c0098e) {
        int position;
        int position2 = canScrollVertically() ? getPosition(view) : 0;
        if (canScrollHorizontally()) {
            position = getPosition(view);
        } else {
            position = 0;
        }
        c0098e.m256c(C0107n.m424a(position2, 1, position, 1, false, false));
    }

    public void requestSimpleAnimationsInNextLayout() {
        this.mRequestedSimpleAnimations = true;
    }

    public int getSelectionModeForAccessibility(ax axVar, bd bdVar) {
        return 0;
    }

    public int getRowCountForAccessibility(ax axVar, bd bdVar) {
        if (this.mRecyclerView == null || this.mRecyclerView.mAdapter == null || !canScrollVertically()) {
            return 1;
        }
        return this.mRecyclerView.mAdapter.mo4327a();
    }

    public int getColumnCountForAccessibility(ax axVar, bd bdVar) {
        if (this.mRecyclerView == null || this.mRecyclerView.mAdapter == null || !canScrollHorizontally()) {
            return 1;
        }
        return this.mRecyclerView.mAdapter.mo4327a();
    }

    public boolean isLayoutHierarchical(ax axVar, bd bdVar) {
        return false;
    }

    boolean performAccessibilityAction(int i, Bundle bundle) {
        return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performAccessibilityAction(android.support.v7.widget.ax r7, android.support.v7.widget.bd r8, int r9, android.os.Bundle r10) {
        /*
        r6 = this;
        r4 = -1;
        r2 = 1;
        r1 = 0;
        r0 = r6.mRecyclerView;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r9) {
            case 4096: goto L_0x004a;
            case 8192: goto L_0x0018;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r1;
        r3 = r1;
    L_0x000d:
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        if (r0 == 0) goto L_0x0007;
    L_0x0011:
        r1 = r6.mRecyclerView;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r0 = r6.mRecyclerView;
        r0 = android.support.v4.view.ay.m577b(r0, r4);
        if (r0 == 0) goto L_0x007f;
    L_0x0020:
        r0 = r6.getHeight();
        r3 = r6.getPaddingTop();
        r0 = r0 - r3;
        r3 = r6.getPaddingBottom();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x002f:
        r3 = r6.mRecyclerView;
        r3 = android.support.v4.view.ay.m574a(r3, r4);
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r3 = r6.getWidth();
        r4 = r6.getPaddingLeft();
        r3 = r3 - r4;
        r4 = r6.getPaddingRight();
        r3 = r3 - r4;
        r3 = -r3;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x004a:
        r0 = r6.mRecyclerView;
        r0 = android.support.v4.view.ay.m577b(r0, r2);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = r6.getHeight();
        r3 = r6.getPaddingTop();
        r0 = r0 - r3;
        r3 = r6.getPaddingBottom();
        r0 = r0 - r3;
    L_0x0060:
        r3 = r6.mRecyclerView;
        r3 = android.support.v4.view.ay.m574a(r3, r2);
        if (r3 == 0) goto L_0x007a;
    L_0x0068:
        r3 = r6.getWidth();
        r4 = r6.getPaddingLeft();
        r3 = r3 - r4;
        r4 = r6.getPaddingRight();
        r3 = r3 - r4;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x007a:
        r3 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = r1;
        goto L_0x0060;
    L_0x007f:
        r0 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.at.performAccessibilityAction(android.support.v7.widget.ax, android.support.v7.widget.bd, int, android.os.Bundle):boolean");
    }

    boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
        return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
    }

    public boolean performAccessibilityActionForItem(ax axVar, bd bdVar, View view, int i, Bundle bundle) {
        return false;
    }
}
