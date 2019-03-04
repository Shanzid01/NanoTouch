package org.lucasr.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.ax;
import android.support.v7.widget.bd;
import android.util.AttributeSet;
import android.view.View;
import org.lucasr.twowayview.TwoWayLayoutManager.Direction;
import org.lucasr.twowayview.TwoWayLayoutManager.Orientation;
import org.lucasr.twowayview.widget.Lanes.LaneInfo;

public class GridLayoutManager extends BaseLayoutManager {
    private static final int DEFAULT_NUM_COLS = 2;
    private static final int DEFAULT_NUM_ROWS = 2;
    private static final String LOGTAG = "GridLayoutManager";
    private int mNumColumns;
    private int mNumRows;

    public GridLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 2, 2);
    }

    protected GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2000R.styleable.twowayview_GridLayoutManager, i, 0);
        this.mNumColumns = Math.max(1, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_GridLayoutManager_twowayview_numColumns, i2));
        this.mNumRows = Math.max(1, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_GridLayoutManager_twowayview_numRows, i3));
        obtainStyledAttributes.recycle();
    }

    public GridLayoutManager(Orientation orientation, int i, int i2) {
        super(orientation);
        this.mNumColumns = i;
        this.mNumRows = i2;
        if (this.mNumColumns < 1) {
            throw new IllegalArgumentException("GridLayoutManager must have at least 1 column");
        } else if (this.mNumRows < 1) {
            throw new IllegalArgumentException("GridLayoutManager must have at least 1 row");
        }
    }

    int getLaneCount() {
        return isVertical() ? this.mNumColumns : this.mNumRows;
    }

    void getLaneForPosition(LaneInfo laneInfo, int i, Direction direction) {
        int laneCount = i % getLaneCount();
        laneInfo.set(laneCount, laneCount);
    }

    void moveLayoutToPosition(int i, int i2, ax axVar, bd bdVar) {
        Lanes lanes = getLanes();
        lanes.reset(i2);
        getLaneForPosition(this.mTempLaneInfo, i, Direction.END);
        int i3 = this.mTempLaneInfo.startLane;
        if (i3 != 0) {
            View c = axVar.m1611c(i);
            measureChild(c, Direction.END);
            int decoratedMeasuredHeight = isVertical() ? getDecoratedMeasuredHeight(c) : getDecoratedMeasuredWidth(c);
            for (i3--; i3 >= 0; i3--) {
                lanes.offset(i3, decoratedMeasuredHeight);
            }
        }
    }

    public int getNumColumns() {
        return this.mNumColumns;
    }

    public void setNumColumns(int i) {
        if (this.mNumColumns != i) {
            this.mNumColumns = i;
            if (isVertical()) {
                requestLayout();
            }
        }
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public void setNumRows(int i) {
        if (this.mNumRows != i) {
            this.mNumRows = i;
            if (!isVertical()) {
                requestLayout();
            }
        }
    }
}
