package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: RecyclerView */
class ai implements C0172f {
    final /* synthetic */ RecyclerView f582a;

    ai(RecyclerView recyclerView) {
        this.f582a = recyclerView;
    }

    public int mo426a() {
        return this.f582a.getChildCount();
    }

    public void mo429a(View view, int i) {
        this.f582a.addView(view, i);
        this.f582a.dispatchChildAttached(view);
    }

    public int mo427a(View view) {
        return this.f582a.indexOfChild(view);
    }

    public void mo428a(int i) {
        View childAt = this.f582a.getChildAt(i);
        if (childAt != null) {
            this.f582a.dispatchChildDetached(childAt);
        }
        this.f582a.removeViewAt(i);
    }

    public View mo432b(int i) {
        return this.f582a.getChildAt(i);
    }

    public void mo433b() {
        int a = mo426a();
        for (int i = 0; i < a; i++) {
            this.f582a.dispatchChildDetached(mo432b(i));
        }
        this.f582a.removeAllViews();
    }

    public bg mo431b(View view) {
        return RecyclerView.getChildViewHolderInt(view);
    }

    public void mo430a(View view, int i, LayoutParams layoutParams) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.m1692r() || childViewHolderInt.m1677c()) {
                childViewHolderInt.m1685k();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt);
            }
        }
        this.f582a.attachViewToParent(view, i, layoutParams);
    }

    public void mo434c(int i) {
        View b = mo432b(i);
        if (b != null) {
            bg childViewHolderInt = RecyclerView.getChildViewHolderInt(b);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.m1692r() || childViewHolderInt.m1677c()) {
                    childViewHolderInt.m1670a(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt);
                }
            }
        }
        this.f582a.detachViewFromParent(i);
    }
}
