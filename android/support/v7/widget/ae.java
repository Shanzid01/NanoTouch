package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: OrientationHelper */
final class ae extends ac {
    ae(at atVar) {
        super(atVar);
    }

    public int mo421d() {
        return this.a.getHeight() - this.a.getPaddingBottom();
    }

    public int mo423e() {
        return this.a.getHeight();
    }

    public void mo417a(int i) {
        this.a.offsetChildrenVertical(i);
    }

    public int mo419c() {
        return this.a.getPaddingTop();
    }

    public int mo420c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin);
    }

    public int mo422d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin);
    }

    public int mo418b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + this.a.getDecoratedBottom(view);
    }

    public int mo416a(View view) {
        return this.a.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public int mo424f() {
        return (this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom();
    }

    public int mo425g() {
        return this.a.getPaddingBottom();
    }
}
