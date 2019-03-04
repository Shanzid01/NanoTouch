package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

/* compiled from: RecyclerView */
public class bc {
    private int f611a;
    private int f612b;
    private int f613c;
    private Interpolator f614d;
    private boolean f615e;
    private int f616f;

    public bc(int i, int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    public bc(int i, int i2, int i3, Interpolator interpolator) {
        this.f615e = false;
        this.f616f = 0;
        this.f611a = i;
        this.f612b = i2;
        this.f613c = i3;
        this.f614d = interpolator;
    }

    private void m1631a(RecyclerView recyclerView) {
        if (this.f615e) {
            m1630a();
            if (this.f614d != null) {
                recyclerView.mViewFlinger.m1664a(this.f611a, this.f612b, this.f613c, this.f614d);
            } else if (this.f613c == Integer.MIN_VALUE) {
                recyclerView.mViewFlinger.m1666b(this.f611a, this.f612b);
            } else {
                recyclerView.mViewFlinger.m1662a(this.f611a, this.f612b, this.f613c);
            }
            this.f616f++;
            if (this.f616f > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f615e = false;
            return;
        }
        this.f616f = 0;
    }

    private void m1630a() {
        if (this.f614d != null && this.f613c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.f613c < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }

    public void m1633a(int i, int i2, int i3, Interpolator interpolator) {
        this.f611a = i;
        this.f612b = i2;
        this.f613c = i3;
        this.f614d = interpolator;
        this.f615e = true;
    }
}
