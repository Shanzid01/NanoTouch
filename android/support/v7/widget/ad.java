package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: OrientationHelper */
final class ad extends ac {
    ad(at atVar) {
        super(atVar);
    }

    public int mo421d() {
        return this.a.getWidth() - this.a.getPaddingRight();
    }

    public int mo423e() {
        return this.a.getWidth();
    }

    public void mo417a(int i) {
        this.a.offsetChildrenHorizontal(i);
    }

    public int mo419c() {
        return this.a.getPaddingLeft();
    }

    public int mo420c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin);
    }

    public int mo422d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin);
    }

    public int mo418b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + this.a.getDecoratedRight(view);
    }

    public int mo416a(View view) {
        return this.a.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int mo424f() {
        return (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
    }

    public int mo425g() {
        return this.a.getPaddingRight();
    }
}
