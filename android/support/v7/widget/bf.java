package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.widget.aj;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* compiled from: RecyclerView */
class bf implements Runnable {
    final /* synthetic */ RecyclerView f629a;
    private int f630b;
    private int f631c;
    private aj f632d;
    private Interpolator f633e = RecyclerView.sQuinticInterpolator;
    private boolean f634f = false;
    private boolean f635g = false;

    public bf(RecyclerView recyclerView) {
        this.f629a = recyclerView;
        this.f632d = aj.m1086a(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
    }

    public void run() {
        m1658c();
        this.f629a.consumePendingUpdateOperations();
        aj ajVar = this.f632d;
        bb bbVar = this.f629a.mLayout.mSmoothScroller;
        if (ajVar.m1095g()) {
            int b;
            int i;
            int top;
            int f;
            int b2 = ajVar.m1090b();
            int c = ajVar.m1091c();
            int i2 = b2 - this.f630b;
            int i3 = c - this.f631c;
            int i4 = 0;
            int i5 = 0;
            this.f630b = b2;
            this.f631c = c;
            int i6 = 0;
            int i7 = 0;
            if (this.f629a.mAdapter != null) {
                this.f629a.eatRequestLayout();
                this.f629a.mRunningLayoutOrScroll = true;
                if (i2 != 0) {
                    i4 = this.f629a.mLayout.scrollHorizontallyBy(i2, this.f629a.mRecycler, this.f629a.mState);
                    i6 = i2 - i4;
                }
                if (i3 != 0) {
                    i5 = this.f629a.mLayout.scrollVerticallyBy(i3, this.f629a.mRecycler, this.f629a.mState);
                    i7 = i3 - i5;
                }
                if (this.f629a.supportsChangeAnimations()) {
                    b = this.f629a.mChildHelper.m1738b();
                    for (i = 0; i < b; i++) {
                        View b3 = this.f629a.mChildHelper.m1740b(i);
                        bg childViewHolder = this.f629a.getChildViewHolder(b3);
                        if (!(childViewHolder == null || childViewHolder.f643h == null)) {
                            View view = childViewHolder.f643h != null ? childViewHolder.f643h.f636a : null;
                            if (view != null) {
                                int left = b3.getLeft();
                                top = b3.getTop();
                                if (left != view.getLeft() || top != view.getTop()) {
                                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                                }
                            }
                        }
                    }
                }
                if (!(bbVar == null || bbVar.isPendingInitialRun() || !bbVar.isRunning())) {
                    f = this.f629a.mState.m1654f();
                    if (f == 0) {
                        bbVar.stop();
                    } else if (bbVar.getTargetPosition() >= f) {
                        bbVar.setTargetPosition(f - 1);
                        bbVar.onAnimation(i2 - i6, i3 - i7);
                    } else {
                        bbVar.onAnimation(i2 - i6, i3 - i7);
                    }
                }
                this.f629a.mRunningLayoutOrScroll = false;
                this.f629a.resumeRequestLayout(false);
            }
            f = i7;
            i = i6;
            b = i5;
            top = i4;
            Object obj = (i2 == top && i3 == b) ? 1 : null;
            if (!this.f629a.mItemDecorations.isEmpty()) {
                this.f629a.invalidate();
            }
            if (ay.m565a(this.f629a) != 2) {
                this.f629a.considerReleasingGlowsOnScroll(i2, i3);
            }
            if (!(i == 0 && f == 0)) {
                i6 = (int) ajVar.m1094f();
                if (i != b2) {
                    i5 = i < 0 ? -i6 : i > 0 ? i6 : 0;
                    i4 = i5;
                } else {
                    i4 = 0;
                }
                if (f == c) {
                    i6 = 0;
                } else if (f < 0) {
                    i6 = -i6;
                } else if (f <= 0) {
                    i6 = 0;
                }
                if (ay.m565a(this.f629a) != 2) {
                    this.f629a.absorbGlows(i4, i6);
                }
                if ((i4 != 0 || i == b2 || ajVar.m1092d() == 0) && (i6 != 0 || f == c || ajVar.m1093e() == 0)) {
                    ajVar.m1096h();
                }
            }
            if (!(top == 0 && b == 0)) {
                this.f629a.onScrollChanged(0, 0, 0, 0);
                if (this.f629a.mScrollListener != null) {
                    this.f629a.mScrollListener.m1582a(this.f629a, top, b);
                }
            }
            if (!this.f629a.awakenScrollBars()) {
                this.f629a.invalidate();
            }
            if (ajVar.m1089a() || obj == null) {
                this.f629a.setScrollState(0);
            } else {
                m1660a();
            }
        }
        if (bbVar != null && bbVar.isPendingInitialRun()) {
            bbVar.onAnimation(0, 0);
        }
        m1659d();
    }

    private void m1658c() {
        this.f635g = false;
        this.f634f = true;
    }

    private void m1659d() {
        this.f634f = false;
        if (this.f635g) {
            m1660a();
        }
    }

    void m1660a() {
        if (this.f634f) {
            this.f635g = true;
        } else {
            ay.m571a(this.f629a, (Runnable) this);
        }
    }

    public void m1661a(int i, int i2) {
        this.f629a.setScrollState(2);
        this.f631c = 0;
        this.f630b = 0;
        this.f632d.m1088a(0, 0, i, i2, Integer.MIN_VALUE, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        m1660a();
    }

    public void m1666b(int i, int i2) {
        m1663a(i, i2, 0, 0);
    }

    public void m1663a(int i, int i2, int i3, int i4) {
        m1662a(i, i2, m1657b(i, i2, i3, i4));
    }

    private float m1656a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int m1657b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.f629a.getWidth() : this.f629a.getHeight();
        int i5 = width / 2;
        float a = (m1656a(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, (((float) sqrt2) * TextTrackStyle.DEFAULT_FONT_SCALE) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            if (obj != null) {
                round = abs;
            } else {
                round = abs2;
            }
            round = (int) (((((float) round) / ((float) width)) + TextTrackStyle.DEFAULT_FONT_SCALE) * BitmapDescriptorFactory.HUE_MAGENTA);
        }
        return Math.min(round, 2000);
    }

    public void m1662a(int i, int i2, int i3) {
        m1664a(i, i2, i3, RecyclerView.sQuinticInterpolator);
    }

    public void m1664a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.f633e != interpolator) {
            this.f633e = interpolator;
            this.f632d = aj.m1086a(this.f629a.getContext(), interpolator);
        }
        this.f629a.setScrollState(2);
        this.f631c = 0;
        this.f630b = 0;
        this.f632d.m1087a(0, 0, i, i2, i3);
        m1660a();
    }

    public void m1665b() {
        this.f629a.removeCallbacks(this);
        this.f632d.m1096h();
    }
}
