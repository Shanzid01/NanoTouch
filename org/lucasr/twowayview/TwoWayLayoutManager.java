package org.lucasr.twowayview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.C0174z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.ak;
import android.support.v7.widget.at;
import android.support.v7.widget.ax;
import android.support.v7.widget.bb;
import android.support.v7.widget.bd;
import android.support.v7.widget.bg;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.List;

public abstract class TwoWayLayoutManager extends at {
    private static final String LOGTAG = "TwoWayLayoutManager";
    private boolean mIsVertical;
    private int mLayoutEnd;
    private int mLayoutStart;
    private SavedState mPendingSavedState;
    private int mPendingScrollOffset;
    private int mPendingScrollPosition;
    private RecyclerView mRecyclerView;

    public enum Direction {
        START,
        END
    }

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C19971();
        protected static final SavedState EMPTY_STATE = new SavedState();
        private int anchorItemPosition;
        private Bundle itemSelectionState;
        private final Parcelable superState;

        class C19971 implements Creator<SavedState> {
            C19971() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        private SavedState() {
            this.superState = null;
        }

        protected SavedState(Parcelable parcelable) {
            if (parcelable == null) {
                throw new IllegalArgumentException("superState must not be null");
            }
            if (parcelable == EMPTY_STATE) {
                parcelable = null;
            }
            this.superState = parcelable;
        }

        protected SavedState(Parcel parcel) {
            this.superState = EMPTY_STATE;
            this.anchorItemPosition = parcel.readInt();
            this.itemSelectionState = (Bundle) parcel.readParcelable(getClass().getClassLoader());
        }

        public Parcelable getSuperState() {
            return this.superState;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.anchorItemPosition);
            parcel.writeParcelable(this.itemSelectionState, i);
        }
    }

    protected abstract boolean canAddMoreViews(Direction direction, int i);

    protected abstract void layoutChild(View view, Direction direction);

    protected abstract void measureChild(View view, Direction direction);

    public TwoWayLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoWayLayoutManager(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        this.mIsVertical = true;
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollOffset = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1995R.styleable.twowayview_TwoWayLayoutManager, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        while (i2 < indexCount) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == C1995R.styleable.twowayview_TwoWayLayoutManager_android_orientation) {
                index = obtainStyledAttributes.getInt(index, -1);
                if (index >= 0) {
                    setOrientation(Orientation.values()[index]);
                }
            }
            i2++;
        }
        obtainStyledAttributes.recycle();
    }

    public TwoWayLayoutManager(Orientation orientation) {
        boolean z = true;
        this.mIsVertical = true;
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollOffset = 0;
        if (orientation != Orientation.VERTICAL) {
            z = false;
        }
        this.mIsVertical = z;
    }

    private int getTotalSpace() {
        if (this.mIsVertical) {
            return (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    protected int getStartWithPadding() {
        return this.mIsVertical ? getPaddingTop() : getPaddingLeft();
    }

    protected int getEndWithPadding() {
        if (this.mIsVertical) {
            return getHeight() - getPaddingBottom();
        }
        return getWidth() - getPaddingRight();
    }

    protected int getChildStart(View view) {
        return this.mIsVertical ? getDecoratedTop(view) : getDecoratedLeft(view);
    }

    protected int getChildEnd(View view) {
        return this.mIsVertical ? getDecoratedBottom(view) : getDecoratedRight(view);
    }

    protected ak getAdapter() {
        return this.mRecyclerView != null ? this.mRecyclerView.getAdapter() : null;
    }

    private void offsetChildren(int i) {
        if (this.mIsVertical) {
            offsetChildrenVertical(i);
        } else {
            offsetChildrenHorizontal(i);
        }
        this.mLayoutStart += i;
        this.mLayoutEnd += i;
    }

    private void recycleChildrenOutOfBounds(Direction direction, ax axVar) {
        if (direction == Direction.END) {
            recycleChildrenFromStart(direction, axVar);
        } else {
            recycleChildrenFromEnd(direction, axVar);
        }
    }

    private void recycleChildrenFromStart(Direction direction, ax axVar) {
        int childCount = getChildCount();
        int startWithPadding = getStartWithPadding();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (getChildEnd(childAt) >= startWithPadding) {
                break;
            }
            int i3 = i2 + 1;
            detachChild(childAt, direction);
            i++;
            i2 = i3;
        }
        while (true) {
            i2--;
            if (i2 >= 0) {
                View childAt2 = getChildAt(0);
                removeAndRecycleView(childAt2, axVar);
                updateLayoutEdgesFromRemovedChild(childAt2, direction);
            } else {
                return;
            }
        }
    }

    private void recycleChildrenFromEnd(Direction direction, ax axVar) {
        int endWithPadding = getEndWithPadding();
        int i = 0;
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (getChildStart(childAt) <= endWithPadding) {
                break;
            }
            i = i2 + 1;
            detachChild(childAt, direction);
            i2 = i;
            i = childCount;
        }
        while (true) {
            i2--;
            if (i2 >= 0) {
                View childAt2 = getChildAt(i);
                removeAndRecycleViewAt(i, axVar);
                updateLayoutEdgesFromRemovedChild(childAt2, direction);
            } else {
                return;
            }
        }
    }

    private int scrollBy(int i, ax axVar, bd bdVar) {
        int i2 = 1;
        int childCount = getChildCount();
        if (childCount == 0 || i == 0) {
            return 0;
        }
        int max;
        int startWithPadding = getStartWithPadding();
        int endWithPadding = getEndWithPadding();
        int firstVisiblePosition = getFirstVisiblePosition();
        int totalSpace = getTotalSpace();
        if (i < 0) {
            max = Math.max(-(totalSpace - 1), i);
        } else {
            max = Math.min(totalSpace - 1, i);
        }
        if (firstVisiblePosition != 0 || this.mLayoutStart < startWithPadding || max > 0) {
            totalSpace = 0;
        } else {
            totalSpace = 1;
        }
        if (childCount + firstVisiblePosition != bdVar.m1654f() || this.mLayoutEnd > endWithPadding || max < 0) {
            i2 = 0;
        }
        if (i2 != 0 || r0 != 0) {
            return 0;
        }
        offsetChildren(-max);
        Direction direction = max > 0 ? Direction.END : Direction.START;
        recycleChildrenOutOfBounds(direction, axVar);
        i2 = Math.abs(max);
        if (canAddMoreViews(Direction.START, startWithPadding - i2) || canAddMoreViews(Direction.END, i2 + endWithPadding)) {
            fillGap(direction, axVar, bdVar);
        }
        return max;
    }

    private void fillGap(Direction direction, ax axVar, bd bdVar) {
        int childCount = getChildCount();
        int extraLayoutSpace = getExtraLayoutSpace(bdVar);
        int firstVisiblePosition = getFirstVisiblePosition();
        if (direction == Direction.END) {
            fillAfter(firstVisiblePosition + childCount, axVar, bdVar, extraLayoutSpace);
            correctTooHigh(childCount, axVar, bdVar);
            return;
        }
        fillBefore(firstVisiblePosition - 1, axVar, extraLayoutSpace);
        correctTooLow(childCount, axVar, bdVar);
    }

    private void fillBefore(int i, ax axVar) {
        fillBefore(i, axVar, 0);
    }

    private void fillBefore(int i, ax axVar, int i2) {
        int startWithPadding = getStartWithPadding() - i2;
        while (canAddMoreViews(Direction.START, startWithPadding) && i >= 0) {
            makeAndAddView(i, Direction.START, axVar);
            i--;
        }
    }

    private void fillAfter(int i, ax axVar, bd bdVar) {
        fillAfter(i, axVar, bdVar, 0);
    }

    private void fillAfter(int i, ax axVar, bd bdVar, int i2) {
        int endWithPadding = getEndWithPadding() + i2;
        int f = bdVar.m1654f();
        while (canAddMoreViews(Direction.END, endWithPadding) && i < f) {
            makeAndAddView(i, Direction.END, axVar);
            i++;
        }
    }

    private void fillSpecific(int i, ax axVar, bd bdVar) {
        int i2 = 0;
        if (bdVar.m1654f() != 0) {
            makeAndAddView(i, Direction.END, axVar);
            int extraLayoutSpace = getExtraLayoutSpace(bdVar);
            if (bdVar.m1651c() >= i) {
                int i3 = extraLayoutSpace;
                extraLayoutSpace = 0;
                i2 = i3;
            }
            fillBefore(i - 1, axVar, extraLayoutSpace);
            adjustViewsStartOrEnd();
            fillAfter(i + 1, axVar, bdVar, i2);
            correctTooHigh(getChildCount(), axVar, bdVar);
        }
    }

    private void correctTooHigh(int i, ax axVar, bd bdVar) {
        if (getLastVisiblePosition() == bdVar.m1654f() - 1 && i != 0) {
            int startWithPadding = getStartWithPadding();
            int endWithPadding = getEndWithPadding();
            int firstVisiblePosition = getFirstVisiblePosition();
            endWithPadding -= this.mLayoutEnd;
            if (endWithPadding <= 0) {
                return;
            }
            if (firstVisiblePosition > 0 || this.mLayoutStart < startWithPadding) {
                if (firstVisiblePosition == 0) {
                    endWithPadding = Math.min(endWithPadding, startWithPadding - this.mLayoutStart);
                }
                offsetChildren(endWithPadding);
                if (firstVisiblePosition > 0) {
                    fillBefore(firstVisiblePosition - 1, axVar);
                    adjustViewsStartOrEnd();
                }
            }
        }
    }

    private void correctTooLow(int i, ax axVar, bd bdVar) {
        if (getFirstVisiblePosition() == 0 && i != 0) {
            int startWithPadding = getStartWithPadding();
            int endWithPadding = getEndWithPadding();
            int f = bdVar.m1654f();
            int lastVisiblePosition = getLastVisiblePosition();
            startWithPadding = this.mLayoutStart - startWithPadding;
            if (startWithPadding <= 0) {
                return;
            }
            if (lastVisiblePosition < f - 1 || this.mLayoutEnd > endWithPadding) {
                if (lastVisiblePosition == f - 1) {
                    startWithPadding = Math.min(startWithPadding, this.mLayoutEnd - endWithPadding);
                }
                offsetChildren(-startWithPadding);
                if (lastVisiblePosition < f - 1) {
                    fillAfter(lastVisiblePosition + 1, axVar, bdVar);
                    adjustViewsStartOrEnd();
                }
            } else if (lastVisiblePosition == f - 1) {
                adjustViewsStartOrEnd();
            }
        }
    }

    private void adjustViewsStartOrEnd() {
        if (getChildCount() != 0) {
            int startWithPadding = this.mLayoutStart - getStartWithPadding();
            if (startWithPadding < 0) {
                startWithPadding = 0;
            }
            if (startWithPadding != 0) {
                offsetChildren(-startWithPadding);
            }
        }
    }

    private static View findNextScrapView(List<bg> list, Direction direction, int i) {
        bg bgVar;
        int size = list.size();
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = 0;
        bg bgVar2 = null;
        while (i3 < size) {
            bg bgVar3;
            int i4;
            bgVar = (bg) list.get(i3);
            int d = bgVar.m1678d() - i;
            if (d >= 0 || direction != Direction.END) {
                if (d <= 0 || direction != Direction.START) {
                    int abs = Math.abs(d);
                    if (abs < i2) {
                        if (d == 0) {
                            break;
                        }
                        bgVar3 = bgVar;
                        i4 = abs;
                        i3++;
                        bgVar2 = bgVar3;
                        i2 = i4;
                    }
                } else {
                    i4 = i2;
                    bgVar3 = bgVar2;
                    i3++;
                    bgVar2 = bgVar3;
                    i2 = i4;
                }
            }
            i4 = i2;
            bgVar3 = bgVar2;
            i3++;
            bgVar2 = bgVar3;
            i2 = i4;
        }
        bgVar = bgVar2;
        if (bgVar != null) {
            return bgVar.f636a;
        }
        return null;
    }

    private void fillFromScrapList(List<bg> list, Direction direction) {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (direction == Direction.END) {
            firstVisiblePosition += getChildCount();
        } else {
            firstVisiblePosition--;
        }
        while (true) {
            View findNextScrapView = findNextScrapView(list, direction, firstVisiblePosition);
            if (findNextScrapView != null) {
                setupChild(findNextScrapView, direction);
                firstVisiblePosition += direction == Direction.END ? 1 : -1;
            } else {
                return;
            }
        }
    }

    private void setupChild(View view, Direction direction) {
        ItemSelectionSupport from = ItemSelectionSupport.from(this.mRecyclerView);
        if (from != null) {
            from.setViewChecked(view, from.isItemChecked(getPosition(view)));
        }
        measureChild(view, direction);
        layoutChild(view, direction);
    }

    private View makeAndAddView(int i, Direction direction, ax axVar) {
        View c = axVar.m1611c(i);
        boolean isItemRemoved = ((LayoutParams) c.getLayoutParams()).isItemRemoved();
        if (!isItemRemoved) {
            addView(c, direction == Direction.END ? -1 : 0);
        }
        setupChild(c, direction);
        if (!isItemRemoved) {
            updateLayoutEdgesFromNewChild(c);
        }
        return c;
    }

    private void handleUpdate() {
        int firstVisiblePosition = getFirstVisiblePosition();
        View findViewByPosition = findViewByPosition(firstVisiblePosition);
        if (findViewByPosition != null) {
            setPendingScrollPositionWithOffset(firstVisiblePosition, getChildStart(findViewByPosition));
        } else {
            setPendingScrollPositionWithOffset(-1, 0);
        }
    }

    private void updateLayoutEdgesFromNewChild(View view) {
        int childStart = getChildStart(view);
        if (childStart < this.mLayoutStart) {
            this.mLayoutStart = childStart;
        }
        childStart = getChildEnd(view);
        if (childStart > this.mLayoutEnd) {
            this.mLayoutEnd = childStart;
        }
    }

    private void updateLayoutEdgesFromRemovedChild(View view, Direction direction) {
        int childCount = getChildCount();
        if (childCount == 0) {
            resetLayoutEdges();
            return;
        }
        int childStart = getChildStart(view);
        int childEnd = getChildEnd(view);
        if (childStart <= this.mLayoutStart || childEnd >= this.mLayoutEnd) {
            if (direction == Direction.END) {
                this.mLayoutStart = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                childStart = 0;
            } else {
                this.mLayoutEnd = Integer.MIN_VALUE;
                int i = childStart;
                childStart = childCount - 1;
                childEnd = i;
            }
            while (childStart >= 0 && childStart <= childCount - 1) {
                View childAt = getChildAt(childStart);
                int childStart2;
                if (direction == Direction.END) {
                    childStart2 = getChildStart(childAt);
                    if (childStart2 < this.mLayoutStart) {
                        this.mLayoutStart = childStart2;
                    }
                    if (childStart2 < childEnd) {
                        childStart++;
                    } else {
                        return;
                    }
                }
                childStart2 = getChildEnd(childAt);
                if (childStart2 > this.mLayoutEnd) {
                    this.mLayoutEnd = childStart2;
                }
                if (childStart2 > childEnd) {
                    childStart--;
                } else {
                    return;
                }
            }
        }
    }

    private void resetLayoutEdges() {
        this.mLayoutStart = getStartWithPadding();
        this.mLayoutEnd = this.mLayoutStart;
    }

    protected int getExtraLayoutSpace(bd bdVar) {
        if (bdVar.m1652d()) {
            return getTotalSpace();
        }
        return 0;
    }

    private Bundle getPendingItemSelectionState() {
        if (this.mPendingSavedState != null) {
            return this.mPendingSavedState.itemSelectionState;
        }
        return null;
    }

    protected void setPendingScrollPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollOffset = i2;
    }

    protected int getPendingScrollPosition() {
        if (this.mPendingSavedState != null) {
            return this.mPendingSavedState.anchorItemPosition;
        }
        return this.mPendingScrollPosition;
    }

    protected int getPendingScrollOffset() {
        if (this.mPendingSavedState != null) {
            return 0;
        }
        return this.mPendingScrollOffset;
    }

    protected int getAnchorItemPosition(bd bdVar) {
        int f = bdVar.m1654f();
        int pendingScrollPosition = getPendingScrollPosition();
        if (pendingScrollPosition != -1 && (pendingScrollPosition < 0 || pendingScrollPosition >= f)) {
            pendingScrollPosition = -1;
        }
        if (pendingScrollPosition != -1) {
            return pendingScrollPosition;
        }
        if (getChildCount() > 0) {
            return findFirstValidChildPosition(f);
        }
        return 0;
    }

    private int findFirstValidChildPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    public int getDecoratedMeasuredWidth(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.rightMargin + (super.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin);
    }

    public int getDecoratedMeasuredHeight(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + (super.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin);
    }

    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) - ((MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) - ((MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public int getDecoratedRight(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.rightMargin + super.getDecoratedRight(view);
    }

    public int getDecoratedBottom(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + super.getDecoratedBottom(view);
    }

    public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        super.layoutDecorated(view, i + marginLayoutParams.leftMargin, i2 + marginLayoutParams.topMargin, i3 - marginLayoutParams.rightMargin, i4 - marginLayoutParams.bottomMargin);
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, ax axVar) {
        super.onDetachedFromWindow(recyclerView, axVar);
        this.mRecyclerView = null;
    }

    public void onAdapterChanged(ak akVar, ak akVar2) {
        super.onAdapterChanged(akVar, akVar2);
        ItemSelectionSupport from = ItemSelectionSupport.from(this.mRecyclerView);
        if (akVar != null && from != null) {
            from.clearChoices();
        }
    }

    public void onLayoutChildren(ax axVar, bd bdVar) {
        ItemSelectionSupport from = ItemSelectionSupport.from(this.mRecyclerView);
        if (from != null) {
            Bundle pendingItemSelectionState = getPendingItemSelectionState();
            if (pendingItemSelectionState != null) {
                from.onRestoreInstanceState(pendingItemSelectionState);
            }
            if (bdVar.m1653e()) {
                from.onAdapterDataChanged();
            }
        }
        int anchorItemPosition = getAnchorItemPosition(bdVar);
        detachAndScrapAttachedViews(axVar);
        fillSpecific(anchorItemPosition, axVar, bdVar);
        onLayoutScrapList(axVar, bdVar);
        setPendingScrollPositionWithOffset(-1, 0);
        this.mPendingSavedState = null;
    }

    protected void onLayoutScrapList(ax axVar, bd bdVar) {
        if (getChildCount() != 0 && !bdVar.m1648a() && supportsPredictiveItemAnimations()) {
            List b = axVar.m1606b();
            fillFromScrapList(b, Direction.START);
            fillFromScrapList(b, Direction.END);
        }
    }

    protected void detachChild(View view, Direction direction) {
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        handleUpdate();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        handleUpdate();
    }

    public LayoutParams generateDefaultLayoutParams() {
        if (this.mIsVertical) {
            return new LayoutParams(-1, -2);
        }
        return new LayoutParams(-2, -1);
    }

    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    public int scrollHorizontallyBy(int i, ax axVar, bd bdVar) {
        if (this.mIsVertical) {
            return 0;
        }
        return scrollBy(i, axVar, bdVar);
    }

    public int scrollVerticallyBy(int i, ax axVar, bd bdVar) {
        if (this.mIsVertical) {
            return scrollBy(i, axVar, bdVar);
        }
        return 0;
    }

    public boolean canScrollHorizontally() {
        return !this.mIsVertical;
    }

    public boolean canScrollVertically() {
        return this.mIsVertical;
    }

    public void scrollToPosition(int i) {
        scrollToPositionWithOffset(i, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        setPendingScrollPositionWithOffset(i, i2);
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, bd bdVar, int i) {
        bb c19961 = new C0174z(recyclerView.getContext()) {
            public PointF computeScrollVectorForPosition(int i) {
                if (getChildCount() == 0) {
                    return null;
                }
                int i2 = i < TwoWayLayoutManager.this.getFirstVisiblePosition() ? -1 : 1;
                if (TwoWayLayoutManager.this.mIsVertical) {
                    return new PointF(0.0f, (float) i2);
                }
                return new PointF((float) i2, 0.0f);
            }

            protected int getVerticalSnapPreference() {
                return -1;
            }

            protected int getHorizontalSnapPreference() {
                return -1;
            }
        };
        c19961.setTargetPosition(i);
        startSmoothScroll(c19961);
    }

    public int computeHorizontalScrollOffset(bd bdVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return getFirstVisiblePosition();
    }

    public int computeVerticalScrollOffset(bd bdVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return getFirstVisiblePosition();
    }

    public int computeHorizontalScrollExtent(bd bdVar) {
        return getChildCount();
    }

    public int computeVerticalScrollExtent(bd bdVar) {
        return getChildCount();
    }

    public int computeHorizontalScrollRange(bd bdVar) {
        return bdVar.m1654f();
    }

    public int computeVerticalScrollRange(bd bdVar) {
        return bdVar.m1654f();
    }

    public void onMeasure(ax axVar, bd bdVar, int i, int i2) {
        super.onMeasure(axVar, bdVar, i, i2);
    }

    public Parcelable onSaveInstanceState() {
        Object savedState = new SavedState(SavedState.EMPTY_STATE);
        int pendingScrollPosition = getPendingScrollPosition();
        if (pendingScrollPosition == -1) {
            pendingScrollPosition = getFirstVisiblePosition();
        }
        savedState.anchorItemPosition = pendingScrollPosition;
        ItemSelectionSupport from = ItemSelectionSupport.from(this.mRecyclerView);
        if (from != null) {
            savedState.itemSelectionState = from.onSaveInstanceState();
        } else {
            savedState.itemSelectionState = Bundle.EMPTY;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.mPendingSavedState = (SavedState) parcelable;
        requestLayout();
    }

    public Orientation getOrientation() {
        return this.mIsVertical ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    public void setOrientation(Orientation orientation) {
        boolean z = orientation == Orientation.VERTICAL;
        if (this.mIsVertical != z) {
            this.mIsVertical = z;
            requestLayout();
        }
    }

    public int getFirstVisiblePosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getLastVisiblePosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }
}
