package org.lucasr.twowayview.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import org.lucasr.twowayview.TwoWayLayoutManager.Direction;
import org.lucasr.twowayview.widget.Lanes.LaneInfo;

class ItemSpacingOffsets {
    private boolean mAddSpacingAtEnd;
    private final int mHorizontalSpacing;
    private final LaneInfo mTempLaneInfo = new LaneInfo();
    private final int mVerticalSpacing;

    public ItemSpacingOffsets(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Spacings should be equal or greater than 0");
        }
        this.mVerticalSpacing = i;
        this.mHorizontalSpacing = i2;
    }

    private boolean isSecondLane(BaseLayoutManager baseLayoutManager, int i, int i2) {
        if (i2 == 0 || i == 0) {
            return false;
        }
        int i3 = -1;
        int i4 = i - 1;
        while (i4 >= 0) {
            baseLayoutManager.getLaneForPosition(this.mTempLaneInfo, i4, Direction.END);
            i3 = this.mTempLaneInfo.startLane;
            if (i3 != i2) {
                break;
            }
            i4--;
        }
        i4 = baseLayoutManager.getLaneSpanForPosition(i4);
        if (i3 != 0) {
            return false;
        }
        if (i2 == i3 + i4) {
            return true;
        }
        return false;
    }

    private static boolean isFirstChildInLane(BaseLayoutManager baseLayoutManager, int i) {
        int count = baseLayoutManager.getLanes().getCount();
        if (i >= count) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += baseLayoutManager.getLaneSpanForPosition(i3);
            if (i2 >= count) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLastChildInLane(BaseLayoutManager baseLayoutManager, int i, int i2) {
        if (i < i2 - baseLayoutManager.getLanes().getCount() || (baseLayoutManager instanceof SpannableGridLayoutManager) || (baseLayoutManager instanceof StaggeredGridLayoutManager)) {
            return false;
        }
        return true;
    }

    public void setAddSpacingAtEnd(boolean z) {
        this.mAddSpacingAtEnd = z;
    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        int i2;
        BaseLayoutManager baseLayoutManager = (BaseLayoutManager) recyclerView.getLayoutManager();
        baseLayoutManager.getLaneForPosition(this.mTempLaneInfo, i, Direction.END);
        int i3 = this.mTempLaneInfo.startLane;
        int laneSpanForPosition = baseLayoutManager.getLaneSpanForPosition(i);
        int count = baseLayoutManager.getLanes().getCount();
        int a = recyclerView.getAdapter().mo4327a();
        boolean isVertical = baseLayoutManager.isVertical();
        Object obj = i3 == 0 ? 1 : null;
        boolean isSecondLane = isSecondLane(baseLayoutManager, i, i3);
        Object obj2 = i3 + laneSpanForPosition == count ? 1 : null;
        Object obj3 = i3 + laneSpanForPosition == count + -1 ? 1 : null;
        laneSpanForPosition = isVertical ? this.mHorizontalSpacing : this.mVerticalSpacing;
        if (obj != null) {
            i3 = 0;
        } else if (obj2 != null && !isSecondLane) {
            i3 = (int) (((double) laneSpanForPosition) * 0.75d);
        } else if (isSecondLane && obj2 == null) {
            i3 = (int) (((double) laneSpanForPosition) * 0.25d);
        } else {
            i3 = (int) (((double) laneSpanForPosition) * 0.5d);
        }
        if (obj2 != null) {
            i2 = 0;
        } else if (obj != null && obj3 == null) {
            i2 = (int) (((double) laneSpanForPosition) * 0.75d);
        } else if (obj3 == null || obj != null) {
            i2 = (int) (((double) laneSpanForPosition) * 0.5d);
        } else {
            i2 = (int) (((double) laneSpanForPosition) * 0.25d);
        }
        boolean isFirstChildInLane = isFirstChildInLane(baseLayoutManager, i);
        Object obj4 = (this.mAddSpacingAtEnd || !isLastChildInLane(baseLayoutManager, i, a)) ? null : 1;
        if (isVertical) {
            rect.left = i3;
            rect.top = isFirstChildInLane ? 0 : this.mVerticalSpacing / 2;
            rect.right = i2;
            rect.bottom = obj4 != null ? 0 : this.mVerticalSpacing / 2;
            return;
        }
        rect.left = isFirstChildInLane ? 0 : this.mHorizontalSpacing / 2;
        rect.top = i3;
        rect.right = obj4 != null ? 0 : this.mHorizontalSpacing / 2;
        rect.bottom = i2;
    }
}
