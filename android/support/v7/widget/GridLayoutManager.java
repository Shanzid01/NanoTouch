package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p005a.C0098e;
import android.support.v4.view.p005a.C0107n;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    static final int f517a = MeasureSpec.makeMeasureSpec(0, 0);
    int f518b;
    int f519c;
    View[] f520d;
    final SparseIntArray f521e;
    final SparseIntArray f522f;
    C0190s f523g;
    final Rect f524h;

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        private int f502a = -1;
        private int f503b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m1297a() {
            return this.f502a;
        }

        public int m1298b() {
            return this.f503b;
        }
    }

    public int getRowCountForAccessibility(ax axVar, bd bdVar) {
        if (this.i == 0) {
            return this.f518b;
        }
        if (bdVar.m1654f() < 1) {
            return 0;
        }
        return m1339a(axVar, bdVar, bdVar.m1654f() - 1);
    }

    public int getColumnCountForAccessibility(ax axVar, bd bdVar) {
        if (this.i == 1) {
            return this.f518b;
        }
        if (bdVar.m1654f() < 1) {
            return 0;
        }
        return m1339a(axVar, bdVar, bdVar.m1654f() - 1);
    }

    public void onInitializeAccessibilityNodeInfoForItem(ax axVar, bd bdVar, View view, C0098e c0098e) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = m1339a(axVar, bdVar, layoutParams2.getViewPosition());
            if (this.i == 0) {
                int a2 = layoutParams2.m1297a();
                int b = layoutParams2.m1298b();
                boolean z = this.f518b > 1 && layoutParams2.m1298b() == this.f518b;
                c0098e.m256c(C0107n.m424a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = layoutParams2.m1297a();
            int b2 = layoutParams2.m1298b();
            boolean z2 = this.f518b > 1 && layoutParams2.m1298b() == this.f518b;
            c0098e.m256c(C0107n.m424a(a, 1, a3, b2, z2, false));
            return;
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, c0098e);
    }

    public void onLayoutChildren(ax axVar, bd bdVar) {
        if (bdVar.m1648a()) {
            m1347g();
        }
        super.onLayoutChildren(axVar, bdVar);
        m1346f();
    }

    private void m1346f() {
        this.f521e.clear();
        this.f522f.clear();
    }

    private void m1347g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewPosition = layoutParams.getViewPosition();
            this.f521e.put(viewPosition, layoutParams.m1298b());
            this.f522f.put(viewPosition, layoutParams.m1297a());
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f523g.m1800a();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f523g.m1800a();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f523g.m1800a();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        this.f523g.m1800a();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f523g.m1800a();
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void m1348h() {
        int width;
        if (m1326a() == 1) {
            width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            width = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        this.f519c = width / this.f518b;
    }

    void mo399a(bd bdVar, C0193v c0193v) {
        super.mo399a(bdVar, c0193v);
        m1348h();
        if (bdVar.m1654f() > 0 && !bdVar.m1648a()) {
            m1341a(c0193v);
        }
        if (this.f520d == null || this.f520d.length != this.f518b) {
            this.f520d = new View[this.f518b];
        }
    }

    private void m1341a(C0193v c0193v) {
        int a = this.f523g.m1799a(c0193v.f724a, this.f518b);
        while (a > 0 && c0193v.f724a > 0) {
            c0193v.f724a--;
            a = this.f523g.m1799a(c0193v.f724a, this.f518b);
        }
    }

    private int m1339a(ax axVar, bd bdVar, int i) {
        if (!bdVar.m1648a()) {
            return this.f523g.m1803c(i, this.f518b);
        }
        int b = axVar.m1605b(i);
        if (b != -1) {
            return this.f523g.m1803c(b, this.f518b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int m1344b(ax axVar, bd bdVar, int i) {
        if (!bdVar.m1648a()) {
            return this.f523g.m1799a(i, this.f518b);
        }
        int i2 = this.f522f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = axVar.m1605b(i);
        if (i2 != -1) {
            return this.f523g.m1799a(i2, this.f518b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int m1345c(ax axVar, bd bdVar, int i) {
        if (!bdVar.m1648a()) {
            return this.f523g.m1798a(i);
        }
        int i2 = this.f521e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = axVar.m1605b(i);
        if (i2 != -1) {
            return this.f523g.m1798a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    void mo398a(ax axVar, bd bdVar, C0195x c0195x, C0194w c0194w) {
        boolean z = c0195x.f736e == 1;
        int i = 0;
        int i2 = 0;
        int i3 = this.f518b;
        if (!z) {
            i3 = m1344b(axVar, bdVar, c0195x.f735d) + m1345c(axVar, bdVar, c0195x.f735d);
        }
        while (i < this.f518b && c0195x.m1813a(bdVar) && i3 > 0) {
            int i4 = c0195x.f735d;
            int c = m1345c(axVar, bdVar, i4);
            if (c <= this.f518b) {
                i3 -= c;
                if (i3 >= 0) {
                    View a = c0195x.m1812a(axVar);
                    if (a == null) {
                        break;
                    }
                    i2 += c;
                    this.f520d[i] = a;
                    i++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.f518b + " spans.");
        }
        if (i == 0) {
            c0194w.f729b = true;
            return;
        }
        int makeMeasureSpec;
        m1340a(axVar, bdVar, i, i2, z);
        c = 0;
        i4 = 0;
        while (c < i) {
            View view = this.f520d[c];
            if (c0195x.f741j == null) {
                if (z) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(m1345c(axVar, bdVar, getPosition(view)) * this.f519c, 1073741824);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.i == 1) {
                m1342a(view, makeMeasureSpec, m1343b(layoutParams.height));
            } else {
                m1342a(view, m1343b(layoutParams.width), makeMeasureSpec);
            }
            i3 = this.j.mo420c(view);
            if (i3 <= i4) {
                i3 = i4;
            }
            c++;
            i4 = i3;
        }
        c = m1343b(i4);
        for (i3 = 0; i3 < i; i3++) {
            view = this.f520d[i3];
            if (this.j.mo420c(view) != i4) {
                int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(m1345c(axVar, bdVar, getPosition(view)) * this.f519c, 1073741824);
                if (this.i == 1) {
                    m1342a(view, makeMeasureSpec2, c);
                } else {
                    m1342a(view, c, makeMeasureSpec2);
                }
            }
        }
        c0194w.f728a = i4;
        i3 = 0;
        if (this.i == 1) {
            if (c0195x.f737f == -1) {
                i3 = c0195x.f733b;
                i4 = i3 - i4;
                c = 0;
                i2 = 0;
            } else {
                c = c0195x.f733b;
                i3 = c + i4;
                i4 = c;
                c = 0;
                i2 = 0;
            }
        } else if (c0195x.f737f == -1) {
            i2 = c0195x.f733b;
            c = i2;
            i2 -= i4;
            i4 = 0;
        } else {
            i2 = c0195x.f733b;
            c = i4 + i2;
            i4 = 0;
        }
        int i5 = 0;
        makeMeasureSpec = i2;
        i2 = c;
        c = i4;
        i4 = i3;
        while (i5 < i) {
            int d;
            int i6;
            View view2 = this.f520d[i5];
            layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.i == 1) {
                makeMeasureSpec = (this.f519c * layoutParams.f502a) + getPaddingLeft();
                d = this.j.mo422d(view2) + makeMeasureSpec;
                i6 = makeMeasureSpec;
            } else {
                c = (this.f519c * layoutParams.f502a) + getPaddingTop();
                i4 = this.j.mo422d(view2) + c;
                d = i2;
                i6 = makeMeasureSpec;
            }
            layoutDecorated(view2, i6 + layoutParams.leftMargin, c + layoutParams.topMargin, d - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                c0194w.f730c = true;
            }
            c0194w.f731d |= view2.isFocusable();
            i5++;
            i2 = d;
            makeMeasureSpec = i6;
        }
        Arrays.fill(this.f520d, null);
    }

    private int m1343b(int i) {
        if (i < 0) {
            return f517a;
        }
        return MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private void m1342a(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.f524h);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(m1338a(i, layoutParams.leftMargin + this.f524h.left, layoutParams.rightMargin + this.f524h.right), m1338a(i2, layoutParams.topMargin + this.f524h.top, layoutParams.bottomMargin + this.f524h.bottom));
    }

    private int m1338a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    private void m1340a(ax axVar, bd bdVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m1334b()) {
            i5 = i2 - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f520d[i5];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f503b = m1345c(axVar, bdVar, getPosition(view));
            if (i6 != -1 || layoutParams.f503b <= 1) {
                layoutParams.f502a = i7;
            } else {
                layoutParams.f502a = i7 - (layoutParams.f503b - 1);
            }
            i7 += layoutParams.f503b * i6;
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.n == null;
    }
}
