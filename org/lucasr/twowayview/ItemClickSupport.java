package org.lucasr.twowayview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemClickSupport {
    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;
    private final RecyclerView mRecyclerView;
    private final TouchListener mTouchListener;

    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int i, long j);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(RecyclerView recyclerView, View view, int i, long j);
    }

    class TouchListener extends ClickItemTouchListener {
        TouchListener(RecyclerView recyclerView) {
            super(recyclerView);
        }

        boolean performItemClick(RecyclerView recyclerView, View view, int i, long j) {
            if (ItemClickSupport.this.mItemClickListener == null) {
                return false;
            }
            view.playSoundEffect(0);
            ItemClickSupport.this.mItemClickListener.onItemClick(recyclerView, view, i, j);
            return true;
        }

        boolean performItemLongClick(RecyclerView recyclerView, View view, int i, long j) {
            if (ItemClickSupport.this.mItemLongClickListener == null) {
                return false;
            }
            view.performHapticFeedback(0);
            return ItemClickSupport.this.mItemLongClickListener.onItemLongClick(recyclerView, view, i, j);
        }
    }

    private ItemClickSupport(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        this.mTouchListener = new TouchListener(recyclerView);
        recyclerView.addOnItemTouchListener(this.mTouchListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!this.mRecyclerView.isLongClickable()) {
            this.mRecyclerView.setLongClickable(true);
        }
        this.mItemLongClickListener = onItemLongClickListener;
    }

    public static ItemClickSupport addTo(RecyclerView recyclerView) {
        ItemClickSupport from = from(recyclerView);
        if (from != null) {
            return from;
        }
        from = new ItemClickSupport(recyclerView);
        recyclerView.setTag(C1995R.id.twowayview_item_click_support, from);
        return from;
    }

    public static void removeFrom(RecyclerView recyclerView) {
        ItemClickSupport from = from(recyclerView);
        if (from != null) {
            recyclerView.removeOnItemTouchListener(from.mTouchListener);
            recyclerView.setTag(C1995R.id.twowayview_item_click_support, null);
        }
    }

    public static ItemClickSupport from(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return null;
        }
        return (ItemClickSupport) recyclerView.getTag(C1995R.id.twowayview_item_click_support);
    }
}
