package org.lucasr.twowayview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.C0135n;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.au;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

abstract class ClickItemTouchListener implements au {
    private static final String LOGTAG = "ClickItemTouchListener";
    private final C0135n mGestureDetector;

    class ItemClickGestureDetector extends C0135n {
        private final ItemClickGestureListener mGestureListener;

        public ItemClickGestureDetector(Context context, ItemClickGestureListener itemClickGestureListener) {
            super(context, itemClickGestureListener);
            this.mGestureListener = itemClickGestureListener;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if ((motionEvent.getAction() & 255) == 1) {
                this.mGestureListener.dispatchSingleTapUpIfNeeded(motionEvent);
            }
            return onTouchEvent;
        }
    }

    class ItemClickGestureListener extends SimpleOnGestureListener {
        private final RecyclerView mHostView;
        private View mTargetChild;

        public ItemClickGestureListener(RecyclerView recyclerView) {
            this.mHostView = recyclerView;
        }

        public void dispatchSingleTapUpIfNeeded(MotionEvent motionEvent) {
            if (this.mTargetChild != null) {
                onSingleTapUp(motionEvent);
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.mTargetChild = this.mHostView.findChildViewUnder((float) ((int) motionEvent.getX()), (float) ((int) motionEvent.getY()));
            return this.mTargetChild != null;
        }

        public void onShowPress(MotionEvent motionEvent) {
            if (this.mTargetChild != null) {
                this.mTargetChild.setPressed(true);
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.mTargetChild == null) {
                return false;
            }
            this.mTargetChild.setPressed(false);
            int childPosition = this.mHostView.getChildPosition(this.mTargetChild);
            boolean performItemClick = ClickItemTouchListener.this.performItemClick(this.mHostView, this.mTargetChild, childPosition, this.mHostView.getAdapter().m1530b(childPosition));
            this.mTargetChild = null;
            return performItemClick;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.mTargetChild == null) {
                return false;
            }
            this.mTargetChild.setPressed(false);
            this.mTargetChild = null;
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.mTargetChild != null) {
                int childPosition = this.mHostView.getChildPosition(this.mTargetChild);
                if (ClickItemTouchListener.this.performItemLongClick(this.mHostView, this.mTargetChild, childPosition, this.mHostView.getAdapter().m1530b(childPosition))) {
                    this.mTargetChild.setPressed(false);
                    this.mTargetChild = null;
                }
            }
        }
    }

    abstract boolean performItemClick(RecyclerView recyclerView, View view, int i, long j);

    abstract boolean performItemLongClick(RecyclerView recyclerView, View view, int i, long j);

    ClickItemTouchListener(RecyclerView recyclerView) {
        this.mGestureDetector = new ItemClickGestureDetector(recyclerView.getContext(), new ItemClickGestureListener(recyclerView));
    }

    @SuppressLint({"NewApi"})
    private boolean isAttachedToWindow(RecyclerView recyclerView) {
        if (VERSION.SDK_INT >= 19) {
            return recyclerView.isAttachedToWindow();
        }
        return recyclerView.getHandler() != null;
    }

    private boolean hasAdapter(RecyclerView recyclerView) {
        return recyclerView.getAdapter() != null;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (isAttachedToWindow(recyclerView) && hasAdapter(recyclerView)) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
