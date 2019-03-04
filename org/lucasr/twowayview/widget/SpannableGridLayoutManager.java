package org.lucasr.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
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

public class SpannableGridLayoutManager extends GridLayoutManager {
    private static final int DEFAULT_NUM_COLS = 3;
    private static final int DEFAULT_NUM_ROWS = 3;
    private static final String LOGTAG = "SpannableGridLayoutManager";
    private boolean mMeasuring;

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        private static final int DEFAULT_SPAN = 1;
        public int colSpan;
        public int rowSpan;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.rowSpan = 1;
            this.colSpan = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2000R.styleable.twowayview_SpannableGridViewChild);
            this.colSpan = Math.max(1, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_SpannableGridViewChild_twowayview_colSpan, -1));
            this.rowSpan = Math.max(1, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_SpannableGridViewChild_twowayview_rowSpan, -1));
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
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.rowSpan = layoutParams2.rowSpan;
                this.colSpan = layoutParams2.colSpan;
                return;
            }
            this.rowSpan = 1;
            this.colSpan = 1;
        }
    }

    public class SpannableItemEntry extends ItemEntry {
        public static final Creator<SpannableItemEntry> CREATOR = new C20011();
        private final int colSpan;
        private final int rowSpan;

        class C20011 implements Creator<SpannableItemEntry> {
            C20011() {
            }

            public SpannableItemEntry createFromParcel(Parcel parcel) {
                return new SpannableItemEntry(parcel);
            }

            public SpannableItemEntry[] newArray(int i) {
                return new SpannableItemEntry[i];
            }
        }

        public SpannableItemEntry(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.colSpan = i3;
            this.rowSpan = i4;
        }

        public SpannableItemEntry(Parcel parcel) {
            super(parcel);
            this.colSpan = parcel.readInt();
            this.rowSpan = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.colSpan);
            parcel.writeInt(this.rowSpan);
        }
    }

    public SpannableGridLayoutManager(Context context) {
        this(context, null);
    }

    public SpannableGridLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpannableGridLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 3, 3);
    }

    public SpannableGridLayoutManager(Orientation orientation, int i, int i2) {
        super(orientation, i, i2);
    }

    private int getChildWidth(int i) {
        return getLanes().getLaneSize() * i;
    }

    private int getChildHeight(int i) {
        return getLanes().getLaneSize() * i;
    }

    private static int getLaneSpan(LayoutParams layoutParams, boolean z) {
        return z ? layoutParams.colSpan : layoutParams.rowSpan;
    }

    private static int getLaneSpan(SpannableItemEntry spannableItemEntry, boolean z) {
        return z ? spannableItemEntry.colSpan : spannableItemEntry.rowSpan;
    }

    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally() && !this.mMeasuring;
    }

    public boolean canScrollVertically() {
        return super.canScrollVertically() && !this.mMeasuring;
    }

    int getLaneSpanForChild(View view) {
        return getLaneSpan((LayoutParams) view.getLayoutParams(), isVertical());
    }

    int getLaneSpanForPosition(int i) {
        SpannableItemEntry spannableItemEntry = (SpannableItemEntry) getItemEntryForPosition(i);
        if (spannableItemEntry != null) {
            return getLaneSpan(spannableItemEntry, isVertical());
        }
        throw new IllegalStateException("Could not find span for position " + i);
    }

    void getLaneForPosition(LaneInfo laneInfo, int i, Direction direction) {
        SpannableItemEntry spannableItemEntry = (SpannableItemEntry) getItemEntryForPosition(i);
        if (spannableItemEntry != null) {
            laneInfo.set(spannableItemEntry.startLane, spannableItemEntry.anchorLane);
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

    private int getWidthUsed(View view) {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - getChildWidth(((LayoutParams) view.getLayoutParams()).colSpan);
    }

    private int getHeightUsed(View view) {
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) - getChildHeight(((LayoutParams) view.getLayoutParams()).rowSpan);
    }

    void measureChildWithMargins(View view) {
        this.mMeasuring = true;
        measureChildWithMargins(view, getWidthUsed(view), getHeightUsed(view));
        this.mMeasuring = false;
    }

    protected void moveLayoutToPosition(int i, int i2, ax axVar, bd bdVar) {
        boolean isVertical = isVertical();
        Lanes lanes = getLanes();
        lanes.reset(0);
        for (int i3 = 0; i3 <= i; i3++) {
            ItemEntry itemEntry;
            ItemEntry itemEntry2 = (SpannableItemEntry) getItemEntryForPosition(i3);
            if (itemEntry2 == null) {
                itemEntry = (SpannableItemEntry) cacheChildLaneAndSpan(axVar.m1611c(i3), Direction.END);
            } else {
                itemEntry = itemEntry2;
            }
            this.mTempLaneInfo.set(itemEntry.startLane, itemEntry.anchorLane);
            if (this.mTempLaneInfo.isUndefined()) {
                lanes.findLane(this.mTempLaneInfo, getLaneSpanForPosition(i3), Direction.END);
                itemEntry.setLane(this.mTempLaneInfo);
            }
            lanes.getChildFrame(this.mTempRect, getChildWidth(itemEntry.colSpan), getChildHeight(itemEntry.rowSpan), this.mTempLaneInfo, Direction.END);
            if (i3 != i) {
                pushChildFrame(itemEntry, this.mTempRect, itemEntry.startLane, getLaneSpan((SpannableItemEntry) itemEntry, isVertical), Direction.END);
            }
        }
        lanes.getLane(this.mTempLaneInfo.startLane, this.mTempRect);
        lanes.reset(Direction.END);
        lanes.offset(i2 - (isVertical ? this.mTempRect.bottom : this.mTempRect.right));
    }

    ItemEntry cacheChildLaneAndSpan(View view, Direction direction) {
        int position = getPosition(view);
        this.mTempLaneInfo.setUndefined();
        SpannableItemEntry spannableItemEntry = (SpannableItemEntry) getItemEntryForPosition(position);
        if (spannableItemEntry != null) {
            this.mTempLaneInfo.set(spannableItemEntry.startLane, spannableItemEntry.anchorLane);
        }
        if (this.mTempLaneInfo.isUndefined()) {
            getLaneForChild(this.mTempLaneInfo, view, direction);
        }
        if (spannableItemEntry == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            ItemEntry spannableItemEntry2 = new SpannableItemEntry(this.mTempLaneInfo.startLane, this.mTempLaneInfo.anchorLane, layoutParams.colSpan, layoutParams.rowSpan);
            setItemEntryForPosition(position, spannableItemEntry2);
            return spannableItemEntry2;
        }
        spannableItemEntry.setLane(this.mTempLaneInfo);
        return spannableItemEntry;
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        if (layoutParams.width != -1 || layoutParams.height != -1) {
            return false;
        }
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (isVertical()) {
            if (layoutParams2.rowSpan < 1 || layoutParams2.colSpan < 1 || layoutParams2.colSpan > getLaneCount()) {
                return false;
            }
            return true;
        } else if (layoutParams2.colSpan < 1 || layoutParams2.rowSpan < 1 || layoutParams2.rowSpan > getLaneCount()) {
            return false;
        } else {
            return true;
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = new LayoutParams((MarginLayoutParams) layoutParams);
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams3 = (LayoutParams) layoutParams;
            if (isVertical()) {
                layoutParams2.colSpan = Math.max(1, Math.min(layoutParams3.colSpan, getLaneCount()));
                layoutParams2.rowSpan = Math.max(1, layoutParams3.rowSpan);
            } else {
                layoutParams2.colSpan = Math.max(1, layoutParams3.colSpan);
                layoutParams2.rowSpan = Math.max(1, Math.min(layoutParams3.rowSpan, getLaneCount()));
            }
        }
        return layoutParams2;
    }

    public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }
}
