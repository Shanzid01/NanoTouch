package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: RecyclerView */
public abstract class ar {
    public void onDraw(Canvas canvas, RecyclerView recyclerView, bd bdVar) {
        onDraw(canvas, recyclerView);
    }

    @Deprecated
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, bd bdVar) {
        onDrawOver(canvas, recyclerView);
    }

    @Deprecated
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
    }

    @Deprecated
    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, bd bdVar) {
        getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewPosition(), recyclerView);
    }
}
