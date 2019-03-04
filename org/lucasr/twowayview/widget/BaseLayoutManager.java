package org.lucasr.twowayview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.ax;
import android.support.v7.widget.bd;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import org.lucasr.twowayview.TwoWayLayoutManager;
import org.lucasr.twowayview.TwoWayLayoutManager.Direction;
import org.lucasr.twowayview.TwoWayLayoutManager.Orientation;
import org.lucasr.twowayview.TwoWayLayoutManager.SavedState;
import org.lucasr.twowayview.widget.Lanes.LaneInfo;

public abstract class BaseLayoutManager extends TwoWayLayoutManager {
    private static /* synthetic */ int[] f3856x502c6ba1 = null;
    private static final String LOGTAG = "BaseLayoutManager";
    protected final Rect mChildFrame;
    private ItemEntries mItemEntries;
    private ItemEntries mItemEntriesToRestore;
    private Lanes mLanes;
    private Lanes mLanesToRestore;
    protected final LaneInfo mTempLaneInfo;
    protected final Rect mTempRect;

    public class ItemEntry implements Parcelable {
        public static final Creator<ItemEntry> CREATOR = new C19981();
        public int anchorLane;
        private int[] spanMargins;
        public int startLane;

        class C19981 implements Creator<ItemEntry> {
            C19981() {
            }

            public ItemEntry createFromParcel(Parcel parcel) {
                return new ItemEntry(parcel);
            }

            public ItemEntry[] newArray(int i) {
                return new ItemEntry[i];
            }
        }

        public ItemEntry(int i, int i2) {
            this.startLane = i;
            this.anchorLane = i2;
        }

        public ItemEntry(Parcel parcel) {
            this.startLane = parcel.readInt();
            this.anchorLane = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.spanMargins = new int[readInt];
                for (int i = 0; i < readInt; i++) {
                    this.spanMargins[i] = parcel.readInt();
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            parcel.writeInt(this.startLane);
            parcel.writeInt(this.anchorLane);
            int length = this.spanMargins != null ? this.spanMargins.length : 0;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeInt(this.spanMargins[i2]);
                i2++;
            }
        }

        void setLane(LaneInfo laneInfo) {
            this.startLane = laneInfo.startLane;
            this.anchorLane = laneInfo.anchorLane;
        }

        void invalidateLane() {
            this.startLane = -1;
            this.anchorLane = -1;
            this.spanMargins = null;
        }

        private boolean hasSpanMargins() {
            return this.spanMargins != null;
        }

        private int getSpanMargin(int i) {
            if (this.spanMargins == null) {
                return 0;
            }
            return this.spanMargins[i];
        }

        private void setSpanMargin(int i, int i2, int i3) {
            if (this.spanMargins == null) {
                this.spanMargins = new int[i3];
            }
            this.spanMargins[i] = i2;
        }
    }

    public class LanedSavedState extends SavedState {
        public static final Creator<LanedSavedState> CREATOR = new C19991();
        private ItemEntries itemEntries;
        private int laneSize;
        private Rect[] lanes;
        private Orientation orientation;

        class C19991 implements Creator<LanedSavedState> {
            C19991() {
            }

            public LanedSavedState createFromParcel(Parcel parcel) {
                return new LanedSavedState(parcel);
            }

            public LanedSavedState[] newArray(int i) {
                return new LanedSavedState[i];
            }
        }

        protected LanedSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private LanedSavedState(Parcel parcel) {
            int i;
            super(parcel);
            this.orientation = Orientation.values()[parcel.readInt()];
            this.laneSize = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.lanes = new Rect[readInt];
                for (i = 0; i < readInt; i++) {
                    Rect rect = new Rect();
                    rect.readFromParcel(parcel);
                    this.lanes[i] = rect;
                }
            }
            readInt = parcel.readInt();
            if (readInt > 0) {
                this.itemEntries = new ItemEntries();
                for (i = 0; i < readInt; i++) {
                    this.itemEntries.restoreItemEntry(i, (ItemEntry) parcel.readParcelable(getClass().getClassLoader()));
                }
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.orientation.ordinal());
            parcel.writeInt(this.laneSize);
            int length = this.lanes != null ? this.lanes.length : 0;
            parcel.writeInt(length);
            for (int i3 = 0; i3 < length; i3++) {
                this.lanes[i3].writeToParcel(parcel, 1);
            }
            if (this.itemEntries != null) {
                length = this.itemEntries.size();
            } else {
                length = 0;
            }
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeParcelable(this.itemEntries.getItemEntry(i2), i);
                i2++;
            }
        }
    }

    enum UpdateOp {
        ADD,
        REMOVE,
        UPDATE,
        MOVE
    }

    abstract int getLaneCount();

    abstract void getLaneForPosition(LaneInfo laneInfo, int i, Direction direction);

    abstract void moveLayoutToPosition(int i, int i2, ax axVar, bd bdVar);

    static /* synthetic */ int[] m6118x502c6ba1() {
        int[] iArr = f3856x502c6ba1;
        if (iArr == null) {
            iArr = new int[UpdateOp.values().length];
            try {
                iArr[UpdateOp.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UpdateOp.MOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UpdateOp.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UpdateOp.UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f3856x502c6ba1 = iArr;
        }
        return iArr;
    }

    public BaseLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildFrame = new Rect();
        this.mTempRect = new Rect();
        this.mTempLaneInfo = new LaneInfo();
    }

    public BaseLayoutManager(Orientation orientation) {
        super(orientation);
        this.mChildFrame = new Rect();
        this.mTempRect = new Rect();
        this.mTempLaneInfo = new LaneInfo();
    }

    protected void pushChildFrame(ItemEntry itemEntry, Rect rect, int i, int i2, Direction direction) {
        Object obj;
        if (direction != Direction.END || itemEntry == null || itemEntry.hasSpanMargins()) {
            obj = null;
        } else {
            obj = 1;
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4;
            if (itemEntry == null || direction == Direction.END) {
                i4 = 0;
            } else {
                i4 = itemEntry.getSpanMargin(i3 - i);
            }
            i4 = this.mLanes.pushChildFrame(rect, i3, i4, direction);
            if (i2 > 1 && r0 != null) {
                itemEntry.setSpanMargin(i3 - i, i4, i2);
            }
        }
    }

    private void popChildFrame(ItemEntry itemEntry, Rect rect, int i, int i2, Direction direction) {
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4;
            if (itemEntry == null || direction == Direction.END) {
                i4 = 0;
            } else {
                i4 = itemEntry.getSpanMargin(i3 - i);
            }
            this.mLanes.popChildFrame(rect, i3, i4, direction);
        }
    }

    void getDecoratedChildFrame(View view, Rect rect) {
        rect.left = getDecoratedLeft(view);
        rect.top = getDecoratedTop(view);
        rect.right = getDecoratedRight(view);
        rect.bottom = getDecoratedBottom(view);
    }

    boolean isVertical() {
        return getOrientation() == Orientation.VERTICAL;
    }

    Lanes getLanes() {
        return this.mLanes;
    }

    void setItemEntryForPosition(int i, ItemEntry itemEntry) {
        if (this.mItemEntries != null) {
            this.mItemEntries.putItemEntry(i, itemEntry);
        }
    }

    ItemEntry getItemEntryForPosition(int i) {
        return this.mItemEntries != null ? this.mItemEntries.getItemEntry(i) : null;
    }

    void clearItemEntries() {
        if (this.mItemEntries != null) {
            this.mItemEntries.clear();
        }
    }

    void invalidateItemLanesAfter(int i) {
        if (this.mItemEntries != null) {
            this.mItemEntries.invalidateItemLanesAfter(i);
        }
    }

    void offsetForAddition(int i, int i2) {
        if (this.mItemEntries != null) {
            this.mItemEntries.offsetForAddition(i, i2);
        }
    }

    void offsetForRemoval(int i, int i2) {
        if (this.mItemEntries != null) {
            this.mItemEntries.offsetForRemoval(i, i2);
        }
    }

    private void requestMoveLayout() {
        if (getPendingScrollPosition() == -1) {
            int firstVisiblePosition = getFirstVisiblePosition();
            View findViewByPosition = findViewByPosition(firstVisiblePosition);
            setPendingScrollPositionWithOffset(firstVisiblePosition, findViewByPosition != null ? getChildStart(findViewByPosition) : 0);
        }
    }

    private boolean canUseLanes(Lanes lanes) {
        if (lanes == null) {
            return false;
        }
        int laneCount = getLaneCount();
        int calculateLaneSize = Lanes.calculateLaneSize(this, laneCount);
        if (lanes.getOrientation() == getOrientation() && lanes.getCount() == laneCount && lanes.getLaneSize() == calculateLaneSize) {
            return true;
        }
        return false;
    }

    private boolean ensureLayoutState() {
        int laneCount = getLaneCount();
        if (laneCount == 0 || getWidth() == 0 || getHeight() == 0 || canUseLanes(this.mLanes)) {
            return false;
        }
        Lanes lanes = this.mLanes;
        this.mLanes = new Lanes(this, laneCount);
        requestMoveLayout();
        if (this.mItemEntries == null) {
            this.mItemEntries = new ItemEntries();
        }
        if (lanes != null && lanes.getOrientation() == this.mLanes.getOrientation() && lanes.getLaneSize() == this.mLanes.getLaneSize()) {
            invalidateItemLanesAfter(0);
        } else {
            this.mItemEntries.clear();
        }
        return true;
    }

    private void handleUpdate(int i, int i2, UpdateOp updateOp) {
        invalidateItemLanesAfter(i);
        switch (m6118x502c6ba1()[updateOp.ordinal()]) {
            case 1:
                offsetForAddition(i, i2);
                break;
            case 2:
                offsetForRemoval(i, i2);
                break;
            case 4:
                offsetForRemoval(i, 1);
                offsetForAddition(i2, 1);
                break;
        }
        if (i + i2 > getFirstVisiblePosition() && i <= getLastVisiblePosition()) {
            requestLayout();
        }
    }

    public void offsetChildrenHorizontal(int i) {
        if (!isVertical()) {
            this.mLanes.offset(i);
        }
        super.offsetChildrenHorizontal(i);
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        if (isVertical()) {
            this.mLanes.offset(i);
        }
    }

    public void onLayoutChildren(ax axVar, bd bdVar) {
        Object obj = this.mLanesToRestore != null ? 1 : null;
        if (obj != null) {
            this.mLanes = this.mLanesToRestore;
            this.mItemEntries = this.mItemEntriesToRestore;
            this.mLanesToRestore = null;
            this.mItemEntriesToRestore = null;
        }
        boolean ensureLayoutState = ensureLayoutState();
        if (this.mLanes != null) {
            int f = bdVar.m1654f();
            if (this.mItemEntries != null) {
                this.mItemEntries.setAdapterSize(f);
            }
            f = getAnchorItemPosition(bdVar);
            if (f > 0 && ensureLayoutState && obj == null) {
                moveLayoutToPosition(f, getPendingScrollOffset(), axVar, bdVar);
            }
            this.mLanes.reset(Direction.START);
            super.onLayoutChildren(axVar, bdVar);
        }
    }

    protected void onLayoutScrapList(ax axVar, bd bdVar) {
        this.mLanes.save();
        super.onLayoutScrapList(axVar, bdVar);
        this.mLanes.restore();
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, UpdateOp.ADD);
        super.onItemsAdded(recyclerView, i, i2);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, UpdateOp.REMOVE);
        super.onItemsRemoved(recyclerView, i, i2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, UpdateOp.UPDATE);
        super.onItemsUpdated(recyclerView, i, i2);
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, UpdateOp.MOVE);
        super.onItemsMoved(recyclerView, i, i2, i3);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        clearItemEntries();
        super.onItemsChanged(recyclerView);
    }

    public Parcelable onSaveInstanceState() {
        int i = 0;
        Parcelable lanedSavedState = new LanedSavedState(super.onSaveInstanceState());
        int count = this.mLanes != null ? this.mLanes.getCount() : 0;
        lanedSavedState.lanes = new Rect[count];
        for (int i2 = 0; i2 < count; i2++) {
            Rect rect = new Rect();
            this.mLanes.getLane(i2, rect);
            lanedSavedState.lanes[i2] = rect;
        }
        lanedSavedState.orientation = getOrientation();
        if (this.mLanes != null) {
            i = this.mLanes.getLaneSize();
        }
        lanedSavedState.laneSize = i;
        lanedSavedState.itemEntries = this.mItemEntries;
        return lanedSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        LanedSavedState lanedSavedState = (LanedSavedState) parcelable;
        if (lanedSavedState.lanes != null && lanedSavedState.laneSize > 0) {
            this.mLanesToRestore = new Lanes(this, lanedSavedState.orientation, lanedSavedState.lanes, lanedSavedState.laneSize);
            this.mItemEntriesToRestore = lanedSavedState.itemEntries;
        }
        super.onRestoreInstanceState(lanedSavedState.getSuperState());
    }

    protected boolean canAddMoreViews(Direction direction, int i) {
        if (direction == Direction.START) {
            if (this.mLanes.getInnerStart() > i) {
                return true;
            }
            return false;
        } else if (this.mLanes.getInnerEnd() >= i) {
            return false;
        } else {
            return true;
        }
    }

    private int getWidthUsed(View view) {
        if (!isVertical()) {
            return 0;
        }
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (getLanes().getLaneSize() * getLaneSpanForChild(view));
    }

    private int getHeightUsed(View view) {
        if (isVertical()) {
            return 0;
        }
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (getLanes().getLaneSize() * getLaneSpanForChild(view));
    }

    void measureChildWithMargins(View view) {
        measureChildWithMargins(view, getWidthUsed(view), getHeightUsed(view));
    }

    protected void measureChild(View view, Direction direction) {
        cacheChildLaneAndSpan(view, direction);
        measureChildWithMargins(view);
    }

    protected void layoutChild(View view, Direction direction) {
        getLaneForChild(this.mTempLaneInfo, view, direction);
        this.mLanes.getChildFrame(this.mChildFrame, getDecoratedMeasuredWidth(view), getDecoratedMeasuredHeight(view), this.mTempLaneInfo, direction);
        ItemEntry cacheChildFrame = cacheChildFrame(view, this.mChildFrame);
        layoutDecorated(view, this.mChildFrame.left, this.mChildFrame.top, this.mChildFrame.right, this.mChildFrame.bottom);
        if (!((LayoutParams) view.getLayoutParams()).isItemRemoved()) {
            pushChildFrame(cacheChildFrame, this.mChildFrame, this.mTempLaneInfo.startLane, getLaneSpanForChild(view), direction);
        }
    }

    protected void detachChild(View view, Direction direction) {
        int position = getPosition(view);
        getLaneForPosition(this.mTempLaneInfo, position, direction);
        getDecoratedChildFrame(view, this.mChildFrame);
        popChildFrame(getItemEntryForPosition(position), this.mChildFrame, this.mTempLaneInfo.startLane, getLaneSpanForChild(view), direction);
    }

    void getLaneForChild(LaneInfo laneInfo, View view, Direction direction) {
        getLaneForPosition(laneInfo, getPosition(view), direction);
    }

    int getLaneSpanForChild(View view) {
        return 1;
    }

    int getLaneSpanForPosition(int i) {
        return 1;
    }

    ItemEntry cacheChildLaneAndSpan(View view, Direction direction) {
        return null;
    }

    ItemEntry cacheChildFrame(View view, Rect rect) {
        return null;
    }

    public boolean checkLayoutParams(LayoutParams layoutParams) {
        if (isVertical()) {
            if (layoutParams.width == -1) {
                return true;
            }
            return false;
        } else if (layoutParams.height != -1) {
            return false;
        } else {
            return true;
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        if (isVertical()) {
            return new LayoutParams(-1, -2);
        }
        return new LayoutParams(-2, -1);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = new LayoutParams((MarginLayoutParams) layoutParams);
        if (isVertical()) {
            layoutParams2.width = -1;
            layoutParams2.height = layoutParams.height;
        } else {
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = -1;
        }
        return layoutParams2;
    }

    public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }
}
