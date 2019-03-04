package org.lucasr.twowayview.widget;

import android.graphics.Rect;
import org.lucasr.twowayview.TwoWayLayoutManager.Direction;
import org.lucasr.twowayview.TwoWayLayoutManager.Orientation;

class Lanes {
    public static final int NO_LANE = -1;
    private Integer mInnerEnd;
    private Integer mInnerStart;
    private final boolean mIsVertical;
    private final int mLaneSize;
    private final Rect[] mLanes;
    private final BaseLayoutManager mLayout;
    private final Rect[] mSavedLanes;
    private final LaneInfo mTempLaneInfo = new LaneInfo();
    private final Rect mTempRect = new Rect();

    public class LaneInfo {
        public int anchorLane;
        public int startLane;

        public boolean isUndefined() {
            return this.startLane == -1 || this.anchorLane == -1;
        }

        public void set(int i, int i2) {
            this.startLane = i;
            this.anchorLane = i2;
        }

        public void setUndefined() {
            this.startLane = -1;
            this.anchorLane = -1;
        }
    }

    public Lanes(BaseLayoutManager baseLayoutManager, Orientation orientation, Rect[] rectArr, int i) {
        int i2 = 0;
        this.mLayout = baseLayoutManager;
        this.mIsVertical = orientation == Orientation.VERTICAL;
        this.mLanes = rectArr;
        this.mLaneSize = i;
        this.mSavedLanes = new Rect[this.mLanes.length];
        while (i2 < this.mLanes.length) {
            this.mSavedLanes[i2] = new Rect();
            i2++;
        }
    }

    public Lanes(BaseLayoutManager baseLayoutManager, int i) {
        int i2;
        this.mLayout = baseLayoutManager;
        this.mIsVertical = baseLayoutManager.isVertical();
        this.mLanes = new Rect[i];
        this.mSavedLanes = new Rect[i];
        for (i2 = 0; i2 < i; i2++) {
            this.mLanes[i2] = new Rect();
            this.mSavedLanes[i2] = new Rect();
        }
        this.mLaneSize = calculateLaneSize(baseLayoutManager, i);
        int paddingLeft = baseLayoutManager.getPaddingLeft();
        int paddingTop = baseLayoutManager.getPaddingTop();
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * this.mLaneSize;
            if (this.mIsVertical) {
                i2 = i4;
            } else {
                i2 = 0;
            }
            int i5 = paddingLeft + i2;
            if (this.mIsVertical) {
                i4 = 0;
            }
            int i6 = paddingTop + i4;
            if (this.mIsVertical) {
                i2 = this.mLaneSize + i5;
            } else {
                i2 = i5;
            }
            this.mLanes[i3].set(i5, i6, i2, this.mIsVertical ? i6 : this.mLaneSize + i6);
        }
    }

    public static int calculateLaneSize(BaseLayoutManager baseLayoutManager, int i) {
        if (baseLayoutManager.isVertical()) {
            int paddingLeft = baseLayoutManager.getPaddingLeft();
            return ((baseLayoutManager.getWidth() - paddingLeft) - baseLayoutManager.getPaddingRight()) / i;
        }
        paddingLeft = baseLayoutManager.getPaddingTop();
        return ((baseLayoutManager.getHeight() - paddingLeft) - baseLayoutManager.getPaddingBottom()) / i;
    }

    private void invalidateEdges() {
        this.mInnerStart = null;
        this.mInnerEnd = null;
    }

    public Orientation getOrientation() {
        return this.mIsVertical ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    public void save() {
        for (int i = 0; i < this.mLanes.length; i++) {
            this.mSavedLanes[i].set(this.mLanes[i]);
        }
    }

    public void restore() {
        for (int i = 0; i < this.mLanes.length; i++) {
            this.mLanes[i].set(this.mSavedLanes[i]);
        }
    }

    public int getLaneSize() {
        return this.mLaneSize;
    }

    public int getCount() {
        return this.mLanes.length;
    }

    private void offsetLane(int i, int i2) {
        int i3;
        Rect rect = this.mLanes[i];
        if (this.mIsVertical) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (!this.mIsVertical) {
            i2 = 0;
        }
        rect.offset(i3, i2);
    }

    public void offset(int i) {
        for (int i2 = 0; i2 < this.mLanes.length; i2++) {
            offset(i2, i);
        }
        invalidateEdges();
    }

    public void offset(int i, int i2) {
        offsetLane(i, i2);
        invalidateEdges();
    }

    public void getLane(int i, Rect rect) {
        rect.set(this.mLanes[i]);
    }

    public int pushChildFrame(Rect rect, int i, int i2, Direction direction) {
        int i3;
        Rect rect2 = this.mLanes[i];
        if (this.mIsVertical) {
            if (direction == Direction.END) {
                i3 = rect.top - rect2.bottom;
                rect2.bottom = rect.bottom + i2;
            } else {
                i3 = rect.bottom - rect2.top;
                rect2.top = rect.top - i2;
            }
        } else if (direction == Direction.END) {
            i3 = rect.left - rect2.right;
            rect2.right = rect.right + i2;
        } else {
            i3 = rect.right - rect2.left;
            rect2.left = rect.left - i2;
        }
        invalidateEdges();
        return i3;
    }

    public void popChildFrame(Rect rect, int i, int i2, Direction direction) {
        Rect rect2 = this.mLanes[i];
        if (this.mIsVertical) {
            if (direction == Direction.END) {
                rect2.top = rect.bottom - i2;
            } else {
                rect2.bottom = rect.top + i2;
            }
        } else if (direction == Direction.END) {
            rect2.left = rect.right - i2;
        } else {
            rect2.right = rect.left + i2;
        }
        invalidateEdges();
    }

    public void getChildFrame(Rect rect, int i, int i2, LaneInfo laneInfo, Direction direction) {
        Rect rect2 = this.mLanes[laneInfo.startLane];
        Rect rect3 = this.mLanes[direction == Direction.END ? laneInfo.anchorLane : laneInfo.startLane];
        if (this.mIsVertical) {
            rect.left = rect2.left;
            rect.top = direction == Direction.END ? rect3.bottom : rect3.top - i2;
        } else {
            rect.top = rect2.top;
            rect.left = direction == Direction.END ? rect3.right : rect3.left - i;
        }
        rect.right = rect.left + i;
        rect.bottom = rect.top + i2;
    }

    private boolean intersects(int i, int i2, Rect rect) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (Rect.intersects(this.mLanes[i3], rect)) {
                return true;
            }
        }
        return false;
    }

    private int findLaneThatFitsSpan(int i, int i2, Direction direction) {
        int max = Math.max(0, (i - i2) + 1);
        int min = Math.min(max + i2, (this.mLanes.length - i2) + 1);
        while (max < min) {
            int i3;
            this.mTempLaneInfo.set(max, i);
            Rect rect = this.mTempRect;
            if (this.mIsVertical) {
                i3 = i2 * this.mLaneSize;
            } else {
                i3 = 1;
            }
            getChildFrame(rect, i3, this.mIsVertical ? 1 : i2 * this.mLaneSize, this.mTempLaneInfo, direction);
            if (!intersects(max, i2, this.mTempRect)) {
                return max;
            }
            max++;
        }
        return -1;
    }

    public void findLane(LaneInfo laneInfo, int i, Direction direction) {
        laneInfo.setUndefined();
        int i2 = direction == Direction.END ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : Integer.MIN_VALUE;
        for (int i3 = 0; i3 < this.mLanes.length; i3++) {
            int i4 = this.mIsVertical ? direction == Direction.END ? this.mLanes[i3].bottom : this.mLanes[i3].top : direction == Direction.END ? this.mLanes[i3].right : this.mLanes[i3].left;
            if ((direction == Direction.END && i4 < r1) || (direction == Direction.START && i4 > r1)) {
                int findLaneThatFitsSpan = findLaneThatFitsSpan(i3, i, direction);
                if (findLaneThatFitsSpan != -1) {
                    laneInfo.set(findLaneThatFitsSpan, i3);
                    i2 = i4;
                }
            }
        }
    }

    public void reset(Direction direction) {
        for (Rect rect : this.mLanes) {
            if (this.mIsVertical) {
                if (direction == Direction.START) {
                    rect.bottom = rect.top;
                } else {
                    rect.top = rect.bottom;
                }
            } else if (direction == Direction.START) {
                rect.right = rect.left;
            } else {
                rect.left = rect.right;
            }
        }
        invalidateEdges();
    }

    public void reset(int i) {
        for (Rect rect : this.mLanes) {
            int i2;
            if (this.mIsVertical) {
                i2 = rect.left;
            } else {
                i2 = i;
            }
            rect.offsetTo(i2, this.mIsVertical ? i : rect.top);
            if (this.mIsVertical) {
                rect.bottom = rect.top;
            } else {
                rect.right = rect.left;
            }
        }
        invalidateEdges();
    }

    public int getInnerStart() {
        if (this.mInnerStart != null) {
            return this.mInnerStart.intValue();
        }
        this.mInnerStart = Integer.valueOf(Integer.MIN_VALUE);
        for (Rect rect : this.mLanes) {
            this.mInnerStart = Integer.valueOf(Math.max(this.mInnerStart.intValue(), this.mIsVertical ? rect.top : rect.left));
        }
        return this.mInnerStart.intValue();
    }

    public int getInnerEnd() {
        if (this.mInnerEnd != null) {
            return this.mInnerEnd.intValue();
        }
        this.mInnerEnd = Integer.valueOf(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        for (Rect rect : this.mLanes) {
            this.mInnerEnd = Integer.valueOf(Math.min(this.mInnerEnd.intValue(), this.mIsVertical ? rect.bottom : rect.right));
        }
        return this.mInnerEnd.intValue();
    }
}
