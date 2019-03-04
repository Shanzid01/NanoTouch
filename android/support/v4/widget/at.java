package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.view.View;

/* compiled from: SlidingPaneLayout */
class at extends bm {
    final /* synthetic */ SlidingPaneLayout f445a;

    private at(SlidingPaneLayout slidingPaneLayout) {
        this.f445a = slidingPaneLayout;
    }

    public boolean mo356a(View view, int i) {
        if (this.f445a.f348l) {
            return false;
        }
        return ((LayoutParams) view.getLayoutParams()).f333b;
    }

    public void mo353a(int i) {
        if (this.f445a.f353q.m1199a() != 0) {
            return;
        }
        if (this.f445a.f345i == 0.0f) {
            this.f445a.m996d(this.f445a.f344h);
            this.f445a.m994c(this.f445a.f344h);
            this.f445a.f354r = false;
            return;
        }
        this.f445a.m991b(this.f445a.f344h);
        this.f445a.f354r = true;
    }

    public void mo359b(View view, int i) {
        this.f445a.m986a();
    }

    public void mo355a(View view, int i, int i2, int i3, int i4) {
        this.f445a.m969a(i);
        this.f445a.invalidate();
    }

    public void mo354a(View view, float f, float f2) {
        int paddingRight;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f445a.m982f()) {
            paddingRight = layoutParams.rightMargin + this.f445a.getPaddingRight();
            if (f < 0.0f || (f == 0.0f && this.f445a.f345i > 0.5f)) {
                paddingRight += this.f445a.f347k;
            }
            paddingRight = (this.f445a.getWidth() - paddingRight) - this.f445a.f344h.getWidth();
        } else {
            paddingRight = layoutParams.leftMargin + this.f445a.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.f445a.f345i > 0.5f)) {
                paddingRight += this.f445a.f347k;
            }
        }
        this.f445a.f353q.m1203a(paddingRight, view.getTop());
        this.f445a.invalidate();
    }

    public int mo351a(View view) {
        return this.f445a.f347k;
    }

    public int mo352a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.f445a.f344h.getLayoutParams();
        if (this.f445a.m982f()) {
            int width = this.f445a.getWidth() - ((layoutParams.rightMargin + this.f445a.getPaddingRight()) + this.f445a.f344h.getWidth());
            return Math.max(Math.min(i, width), width - this.f445a.f347k);
        }
        width = layoutParams.leftMargin + this.f445a.getPaddingLeft();
        return Math.min(Math.max(i, width), this.f445a.f347k + width);
    }

    public int mo357b(View view, int i, int i2) {
        return view.getTop();
    }

    public void mo358b(int i, int i2) {
        this.f445a.f353q.m1202a(this.f445a.f344h, i2);
    }
}
