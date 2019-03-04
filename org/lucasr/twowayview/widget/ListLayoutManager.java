package org.lucasr.twowayview.widget;

import android.content.Context;
import android.support.v7.widget.ax;
import android.support.v7.widget.bd;
import android.util.AttributeSet;
import org.lucasr.twowayview.TwoWayLayoutManager.Direction;
import org.lucasr.twowayview.TwoWayLayoutManager.Orientation;
import org.lucasr.twowayview.widget.Lanes.LaneInfo;

public class ListLayoutManager extends BaseLayoutManager {
    private static final String LOGTAG = "ListLayoutManager";

    public ListLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ListLayoutManager(Context context, Orientation orientation) {
        super(orientation);
    }

    int getLaneCount() {
        return 1;
    }

    void getLaneForPosition(LaneInfo laneInfo, int i, Direction direction) {
        laneInfo.set(0, 0);
    }

    void moveLayoutToPosition(int i, int i2, ax axVar, bd bdVar) {
        getLanes().reset(i2);
    }
}
