package org.lucasr.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.ax;
import android.support.v7.widget.bd;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import org.lucasr.twowayview.TwoWayLayoutManager.Direction;
import org.lucasr.twowayview.TwoWayLayoutManager.Orientation;
import org.lucasr.twowayview.widget.BaseLayoutManager.ItemEntry;
import org.lucasr.twowayview.widget.Lanes.LaneInfo;

public class StaggeredGridLayoutManager extends GridLayoutManager {
    private static final int DEFAULT_NUM_COLS = 2;
    private static final int DEFAULT_NUM_ROWS = 2;
    private static final String LOGTAG = "StaggeredGridLayoutManager";

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        private static final int DEFAULT_SPAN = 1;
        public int span;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.span = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2000R.styleable.twowayview_StaggeredGridViewChild);
            this.span = Math.max(1, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_StaggeredGridViewChild_twowayview_span, -1));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            init(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            init(marginLayoutParams);
        }

        private void init(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                this.span = ((LayoutParams) layoutParams).span;
            } else {
                this.span = 1;
            }
        }
    }

    public class StaggeredItemEntry extends ItemEntry {
        public static final Creator<StaggeredItemEntry> CREATOR = new C20021();
        private int height;
        private final int span;
        private int width;

        class C20021 implements Creator<StaggeredItemEntry> {
            C20021() {
            }

            public StaggeredItemEntry createFromParcel(Parcel parcel) {
                return new StaggeredItemEntry(parcel);
            }

            public StaggeredItemEntry[] newArray(int i) {
                return new StaggeredItemEntry[i];
            }
        }

        public StaggeredItemEntry(int i, int i2, int i3) {
            super(i, i2);
            this.span = i3;
        }

        public StaggeredItemEntry(Parcel parcel) {
            super(parcel);
            this.span = parcel.readInt();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.span);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }
    }

    public StaggeredGridLayoutManager(Context context) {
        this(context, null);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2, 2);
    }

    public StaggeredGridLayoutManager(Orientation orientation, int i, int i2) {
        super(orientation, i, i2);
    }

    int getLaneSpanForChild(View view) {
        return ((LayoutParams) view.getLayoutParams()).span;
    }

    int getLaneSpanForPosition(int i) {
        StaggeredItemEntry staggeredItemEntry = (StaggeredItemEntry) getItemEntryForPosition(i);
        if (staggeredItemEntry != null) {
            return staggeredItemEntry.span;
        }
        throw new IllegalStateException("Could not find span for position " + i);
    }

    void getLaneForPosition(LaneInfo laneInfo, int i, Direction direction) {
        StaggeredItemEntry staggeredItemEntry = (StaggeredItemEntry) getItemEntryForPosition(i);
        if (staggeredItemEntry != null) {
            laneInfo.set(staggeredItemEntry.startLane, staggeredItemEntry.anchorLane);
        } else {
            laneInfo.setUndefined();
        }
    }

    void getLaneForChild(LaneInfo laneInfo, View view, Direction direction) {
        super.getLaneForChild(laneInfo, view, direction);
        if (laneInfo.isUndefined()) {
            getLanes().findLane(laneInfo, getLaneSpanForChild(view), direction);
        }
    }

    void moveLayoutToPosition(int i, int i2, ax axVar, bd bdVar) {
        boolean isVertical = isVertical();
        Lanes lanes = getLanes();
        lanes.reset(0);
        for (int i3 = 0; i3 <= i; i3++) {
            ItemEntry itemEntry;
            ItemEntry itemEntry2 = (StaggeredItemEntry) getItemEntryForPosition(i3);
            if (itemEntry2 != null) {
                this.mTempLaneInfo.set(itemEntry2.startLane, itemEntry2.anchorLane);
                if (this.mTempLaneInfo.isUndefined()) {
                    lanes.findLane(this.mTempLaneInfo, getLaneSpanForPosition(i3), Direction.END);
                    itemEntry2.setLane(this.mTempLaneInfo);
                }
                lanes.getChildFrame(this.mTempRect, itemEntry2.width, itemEntry2.height, this.mTempLaneInfo, Direction.END);
                itemEntry = itemEntry2;
            } else {
                View c = axVar.m1611c(i3);
                measureChild(c, Direction.END);
                itemEntry2 = (StaggeredItemEntry) getItemEntryForPosition(i3);
                this.mTempLaneInfo.set(itemEntry2.startLane, itemEntry2.anchorLane);
                lanes.getChildFrame(this.mTempRect, getDecoratedMeasuredWidth(c), getDecoratedMeasuredHeight(c), this.mTempLaneInfo, Direction.END);
                cacheItemFrame(itemEntry2, this.mTempRect);
                itemEntry = itemEntry2;
            }
            if (i3 != i) {
                pushChildFrame(itemEntry, this.mTempRect, itemEntry.startLane, itemEntry.span, Direction.END);
            }
        }
        lanes.getLane(this.mTempLaneInfo.startLane, this.mTempRect);
        lanes.reset(Direction.END);
        lanes.offset(i2 - (isVertical ? this.mTempRect.bottom : this.mTempRect.right));
    }

    ItemEntry cacheChildLaneAndSpan(View view, Direction direction) {
        int position = getPosition(view);
        this.mTempLaneInfo.setUndefined();
        StaggeredItemEntry staggeredItemEntry = (StaggeredItemEntry) getItemEntryForPosition(position);
        if (staggeredItemEntry != null) {
            this.mTempLaneInfo.set(staggeredItemEntry.startLane, staggeredItemEntry.anchorLane);
        }
        if (this.mTempLaneInfo.isUndefined()) {
            getLaneForChild(this.mTempLaneInfo, view, direction);
        }
        if (staggeredItemEntry == null) {
            ItemEntry staggeredItemEntry2 = new StaggeredItemEntry(this.mTempLaneInfo.startLane, this.mTempLaneInfo.anchorLane, getLaneSpanForChild(view));
            setItemEntryForPosition(position, staggeredItemEntry2);
            return staggeredItemEntry2;
        }
        staggeredItemEntry.setLane(this.mTempLaneInfo);
        return staggeredItemEntry;
    }

    void cacheItemFrame(StaggeredItemEntry staggeredItemEntry, Rect rect) {
        staggeredItemEntry.width = rect.right - rect.left;
        staggeredItemEntry.height = rect.bottom - rect.top;
    }

    ItemEntry cacheChildFrame(View view, Rect rect) {
        StaggeredItemEntry staggeredItemEntry = (StaggeredItemEntry) getItemEntryForPosition(getPosition(view));
        if (staggeredItemEntry == null) {
            throw new IllegalStateException("Tried to cache frame on undefined item");
        }
        cacheItemFrame(staggeredItemEntry, rect);
        return staggeredItemEntry;
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        int i = 1;
        boolean checkLayoutParams = super.checkLayoutParams(layoutParams);
        if (!(layoutParams instanceof LayoutParams)) {
            return checkLayoutParams;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (layoutParams2.span < 1 || layoutParams2.span > getLaneCount()) {
            i = 0;
        }
        return i & checkLayoutParams;
    }

    public LayoutParams generateDefaultLayoutParams() {
        if (isVertical()) {
            return new LayoutParams(-1, -2);
        }
        return new LayoutParams(-2, -1);
    }

    public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = new LayoutParams((MarginLayoutParams) layoutParams);
        if (isVertical()) {
            layoutParams2.width = -1;
            layoutParams2.height = layoutParams.height;
        } else {
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = -1;
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2.span = Math.max(1, Math.min(((LayoutParams) layoutParams).span, getLaneCount()));
        }
        return layoutParams2;
    }

    public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }
}
