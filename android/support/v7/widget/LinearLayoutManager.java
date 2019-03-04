package android.support.v7.widget;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p005a.C0094a;
import android.support.v4.view.p005a.ag;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends at {
    private C0195x f504a;
    private boolean f505b;
    private boolean f506c;
    private boolean f507d;
    private boolean f508e;
    private boolean f509f;
    int f510i;
    ac f511j;
    boolean f512k;
    int f513l;
    int f514m;
    SavedState f515n;
    final C0193v f516o;

    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C0196y();
        int f525a;
        int f526b;
        boolean f527c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f525a = parcel.readInt();
            this.f526b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f527c = z;
        }

        public SavedState(SavedState savedState) {
            this.f525a = savedState.f525a;
            this.f526b = savedState.f526b;
            this.f527c = savedState.f527c;
        }

        boolean m1351a() {
            return this.f525a >= 0;
        }

        void m1352b() {
            this.f525a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f525a);
            parcel.writeInt(this.f526b);
            parcel.writeInt(this.f527c ? 1 : 0);
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, ax axVar) {
        super.onDetachedFromWindow(recyclerView, axVar);
        if (this.f509f) {
            removeAndRecycleAllViews(axVar);
            axVar.m1597a();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            ag a = C0094a.m200a(accessibilityEvent);
            a.m213b(m1336d());
            a.m214c(m1337e());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f515n != null) {
            return new SavedState(this.f515n);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            m1335c();
            boolean z = this.f505b ^ this.f512k;
            savedState.f527c = z;
            View h;
            if (z) {
                h = m1325h();
                savedState.f526b = this.f511j.mo421d() - this.f511j.mo418b(h);
                savedState.f525a = getPosition(h);
                return savedState;
            }
            h = m1324g();
            savedState.f525a = getPosition(h);
            savedState.f526b = this.f511j.mo416a(h) - this.f511j.mo419c();
            return savedState;
        }
        savedState.m1352b();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f515n = (SavedState) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.f510i == 0;
    }

    public boolean canScrollVertically() {
        return this.f510i == 1;
    }

    public int m1326a() {
        return this.f510i;
    }

    private void m1323f() {
        boolean z = true;
        if (this.f510i == 1 || !m1334b()) {
            this.f512k = this.f506c;
            return;
        }
        if (this.f506c) {
            z = false;
        }
        this.f512k = z;
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position < 0 || position >= childCount) {
            return null;
        }
        return getChildAt(position);
    }

    protected int m1329a(bd bdVar) {
        if (bdVar.m1652d()) {
            return this.f511j.mo424f();
        }
        return 0;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, bd bdVar, int i) {
        bb c0192u = new C0192u(this, recyclerView.getContext());
        c0192u.setTargetPosition(i);
        startSmoothScroll(c0192u);
    }

    public PointF m1330a(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.f512k) {
            i2 = -1;
        }
        if (this.f510i == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void onLayoutChildren(ax axVar, bd bdVar) {
        int i;
        if (this.f515n != null && this.f515n.m1351a()) {
            this.f513l = this.f515n.f525a;
        }
        m1335c();
        this.f504a.f732a = false;
        m1323f();
        this.f516o.m1806a();
        this.f516o.f726c = this.f512k ^ this.f507d;
        m1313b(bdVar, this.f516o);
        int a = m1329a(bdVar);
        if ((bdVar.m1651c() < this.f516o.f724a) == this.f512k) {
            i = a;
            a = 0;
        } else {
            i = 0;
        }
        a += this.f511j.mo419c();
        i += this.f511j.mo425g();
        if (!(!bdVar.m1648a() || this.f513l == -1 || this.f514m == Integer.MIN_VALUE)) {
            View findViewByPosition = findViewByPosition(this.f513l);
            if (findViewByPosition != null) {
                int d;
                if (this.f512k) {
                    d = (this.f511j.mo421d() - this.f511j.mo418b(findViewByPosition)) - this.f514m;
                } else {
                    d = this.f514m - (this.f511j.mo416a(findViewByPosition) - this.f511j.mo419c());
                }
                if (d > 0) {
                    a += d;
                } else {
                    i -= d;
                }
            }
        }
        mo399a(bdVar, this.f516o);
        detachAndScrapAttachedViews(axVar);
        this.f504a.f740i = bdVar.m1648a();
        if (this.f516o.f726c) {
            m1314b(this.f516o);
            this.f504a.f739h = a;
            m1328a(axVar, this.f504a, bdVar, false);
            a = this.f504a.f733b;
            if (this.f504a.f734c > 0) {
                i += this.f504a.f734c;
            }
            m1307a(this.f516o);
            this.f504a.f739h = i;
            C0195x c0195x = this.f504a;
            c0195x.f735d += this.f504a.f736e;
            m1328a(axVar, this.f504a, bdVar, false);
            i = this.f504a.f733b;
        } else {
            m1307a(this.f516o);
            this.f504a.f739h = i;
            m1328a(axVar, this.f504a, bdVar, false);
            i = this.f504a.f733b;
            if (this.f504a.f734c > 0) {
                a += this.f504a.f734c;
            }
            m1314b(this.f516o);
            this.f504a.f739h = a;
            C0195x c0195x2 = this.f504a;
            c0195x2.f735d += this.f504a.f736e;
            m1328a(axVar, this.f504a, bdVar, false);
            a = this.f504a.f733b;
        }
        if (getChildCount() > 0) {
            int a2;
            if ((this.f512k ^ this.f507d) != 0) {
                a2 = m1299a(i, axVar, bdVar, true);
                a += a2;
                i += a2;
                a2 = m1309b(a, axVar, bdVar, false);
                a += a2;
                i += a2;
            } else {
                a2 = m1309b(a, axVar, bdVar, true);
                a += a2;
                i += a2;
                a2 = m1299a(i, axVar, bdVar, false);
                a += a2;
                i += a2;
            }
        }
        m1305a(axVar, bdVar, a, i);
        if (!bdVar.m1648a()) {
            this.f513l = -1;
            this.f514m = Integer.MIN_VALUE;
            this.f511j.m1457a();
        }
        this.f505b = this.f507d;
        this.f515n = null;
    }

    void mo399a(bd bdVar, C0193v c0193v) {
    }

    private void m1305a(ax axVar, bd bdVar, int i, int i2) {
        if (bdVar.m1650b() && getChildCount() != 0 && !bdVar.m1648a() && supportsPredictiveItemAnimations()) {
            C0195x c0195x;
            int i3 = 0;
            int i4 = 0;
            List b = axVar.m1606b();
            int size = b.size();
            int position = getPosition(getChildAt(0));
            int i5 = 0;
            while (i5 < size) {
                int c;
                int i6;
                bg bgVar = (bg) b.get(i5);
                if (((bgVar.m1678d() < position) != this.f512k ? -1 : 1) == -1) {
                    c = this.f511j.mo420c(bgVar.f636a) + i3;
                    i6 = i4;
                } else {
                    i6 = this.f511j.mo420c(bgVar.f636a) + i4;
                    c = i3;
                }
                i5++;
                i3 = c;
                i4 = i6;
            }
            this.f504a.f741j = b;
            if (i3 > 0) {
                m1311b(getPosition(m1324g()), i);
                this.f504a.f739h = i3;
                this.f504a.f734c = 0;
                c0195x = this.f504a;
                c0195x.f735d = (this.f512k ? 1 : -1) + c0195x.f735d;
                m1328a(axVar, this.f504a, bdVar, false);
            }
            if (i4 > 0) {
                m1301a(getPosition(m1325h()), i2);
                this.f504a.f739h = i4;
                this.f504a.f734c = 0;
                c0195x = this.f504a;
                c0195x.f735d = (this.f512k ? -1 : 1) + c0195x.f735d;
                m1328a(axVar, this.f504a, bdVar, false);
            }
            this.f504a.f741j = null;
        }
    }

    private void m1313b(bd bdVar, C0193v c0193v) {
        if (!m1320d(bdVar, c0193v) && !m1317c(bdVar, c0193v)) {
            c0193v.m1809b();
            c0193v.f724a = this.f507d ? bdVar.m1654f() - 1 : 0;
        }
    }

    private boolean m1317c(bd bdVar, C0193v c0193v) {
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && c0193v.m1808a(focusedChild, bdVar)) {
            return true;
        }
        if (this.f505b != this.f507d) {
            return false;
        }
        focusedChild = c0193v.f726c ? m1321e(bdVar) : m1322f(bdVar);
        if (focusedChild == null) {
            return false;
        }
        c0193v.m1807a(focusedChild);
        if (!bdVar.m1648a() && supportsPredictiveItemAnimations()) {
            if (this.f511j.mo416a(focusedChild) >= this.f511j.mo421d() || this.f511j.mo418b(focusedChild) < this.f511j.mo419c()) {
                z = true;
            }
            if (z) {
                c0193v.f725b = c0193v.f726c ? this.f511j.mo421d() : this.f511j.mo419c();
            }
        }
        return true;
    }

    private boolean m1320d(bd bdVar, C0193v c0193v) {
        boolean z = false;
        if (bdVar.m1648a() || this.f513l == -1) {
            return false;
        }
        if (this.f513l < 0 || this.f513l >= bdVar.m1654f()) {
            this.f513l = -1;
            this.f514m = Integer.MIN_VALUE;
            return false;
        }
        c0193v.f724a = this.f513l;
        if (this.f515n != null && this.f515n.m1351a()) {
            c0193v.f726c = this.f515n.f527c;
            if (c0193v.f726c) {
                c0193v.f725b = this.f511j.mo421d() - this.f515n.f526b;
                return true;
            }
            c0193v.f725b = this.f511j.mo419c() + this.f515n.f526b;
            return true;
        } else if (this.f514m == Integer.MIN_VALUE) {
            View findViewByPosition = findViewByPosition(this.f513l);
            if (findViewByPosition == null) {
                if (getChildCount() > 0) {
                    boolean z2;
                    if (this.f513l < getPosition(getChildAt(0))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 == this.f512k) {
                        z = true;
                    }
                    c0193v.f726c = z;
                }
                c0193v.m1809b();
                return true;
            } else if (this.f511j.mo420c(findViewByPosition) > this.f511j.mo424f()) {
                c0193v.m1809b();
                return true;
            } else if (this.f511j.mo416a(findViewByPosition) - this.f511j.mo419c() < 0) {
                c0193v.f725b = this.f511j.mo419c();
                c0193v.f726c = false;
                return true;
            } else if (this.f511j.mo421d() - this.f511j.mo418b(findViewByPosition) < 0) {
                c0193v.f725b = this.f511j.mo421d();
                c0193v.f726c = true;
                return true;
            } else {
                c0193v.f725b = c0193v.f726c ? this.f511j.mo418b(findViewByPosition) + this.f511j.m1459b() : this.f511j.mo416a(findViewByPosition);
                return true;
            }
        } else {
            c0193v.f726c = this.f512k;
            if (this.f512k) {
                c0193v.f725b = this.f511j.mo421d() - this.f514m;
                return true;
            }
            c0193v.f725b = this.f511j.mo419c() + this.f514m;
            return true;
        }
    }

    private int m1299a(int i, ax axVar, bd bdVar, boolean z) {
        int d = this.f511j.mo421d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m1327a(-d, axVar, bdVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f511j.mo421d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f511j.mo417a(i2);
        return d + i2;
    }

    private int m1309b(int i, ax axVar, bd bdVar, boolean z) {
        int c = i - this.f511j.mo419c();
        if (c <= 0) {
            return 0;
        }
        c = -m1327a(c, axVar, bdVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f511j.mo419c();
        if (i2 <= 0) {
            return c;
        }
        this.f511j.mo417a(-i2);
        return c - i2;
    }

    private void m1307a(C0193v c0193v) {
        m1301a(c0193v.f724a, c0193v.f725b);
    }

    private void m1301a(int i, int i2) {
        this.f504a.f734c = this.f511j.mo421d() - i2;
        this.f504a.f736e = this.f512k ? -1 : 1;
        this.f504a.f735d = i;
        this.f504a.f737f = 1;
        this.f504a.f733b = i2;
        this.f504a.f738g = Integer.MIN_VALUE;
    }

    private void m1314b(C0193v c0193v) {
        m1311b(c0193v.f724a, c0193v.f725b);
    }

    private void m1311b(int i, int i2) {
        this.f504a.f734c = i2 - this.f511j.mo419c();
        this.f504a.f735d = i;
        this.f504a.f736e = this.f512k ? 1 : -1;
        this.f504a.f737f = -1;
        this.f504a.f733b = i2;
        this.f504a.f738g = Integer.MIN_VALUE;
    }

    protected boolean m1334b() {
        return getLayoutDirection() == 1;
    }

    void m1335c() {
        if (this.f504a == null) {
            this.f504a = new C0195x();
        }
        if (this.f511j == null) {
            this.f511j = ac.m1454a(this, this.f510i);
        }
    }

    public void scrollToPosition(int i) {
        this.f513l = i;
        this.f514m = Integer.MIN_VALUE;
        if (this.f515n != null) {
            this.f515n.m1352b();
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i, ax axVar, bd bdVar) {
        if (this.f510i == 1) {
            return 0;
        }
        return m1327a(i, axVar, bdVar);
    }

    public int scrollVerticallyBy(int i, ax axVar, bd bdVar) {
        if (this.f510i == 0) {
            return 0;
        }
        return m1327a(i, axVar, bdVar);
    }

    public int computeHorizontalScrollOffset(bd bdVar) {
        return m1310b(bdVar);
    }

    public int computeVerticalScrollOffset(bd bdVar) {
        return m1310b(bdVar);
    }

    public int computeHorizontalScrollExtent(bd bdVar) {
        return m1315c(bdVar);
    }

    public int computeVerticalScrollExtent(bd bdVar) {
        return m1315c(bdVar);
    }

    public int computeHorizontalScrollRange(bd bdVar) {
        return m1318d(bdVar);
    }

    public int computeVerticalScrollRange(bd bdVar) {
        return m1318d(bdVar);
    }

    private int m1310b(bd bdVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        m1335c();
        return bj.m1702a(bdVar, this.f511j, m1324g(), m1325h(), this, this.f508e, this.f512k);
    }

    private int m1315c(bd bdVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        m1335c();
        return bj.m1701a(bdVar, this.f511j, m1324g(), m1325h(), this, this.f508e);
    }

    private int m1318d(bd bdVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        m1335c();
        return bj.m1703b(bdVar, this.f511j, m1324g(), m1325h(), this, this.f508e);
    }

    private void m1302a(int i, int i2, boolean z, bd bdVar) {
        int i3 = -1;
        int i4 = 1;
        this.f504a.f739h = m1329a(bdVar);
        this.f504a.f737f = i;
        View h;
        C0195x c0195x;
        if (i == 1) {
            C0195x c0195x2 = this.f504a;
            c0195x2.f739h += this.f511j.mo425g();
            h = m1325h();
            c0195x = this.f504a;
            if (!this.f512k) {
                i3 = 1;
            }
            c0195x.f736e = i3;
            this.f504a.f735d = getPosition(h) + this.f504a.f736e;
            this.f504a.f733b = this.f511j.mo418b(h);
            i3 = this.f511j.mo418b(h) - this.f511j.mo421d();
        } else {
            h = m1324g();
            c0195x = this.f504a;
            c0195x.f739h += this.f511j.mo419c();
            c0195x = this.f504a;
            if (!this.f512k) {
                i4 = -1;
            }
            c0195x.f736e = i4;
            this.f504a.f735d = getPosition(h) + this.f504a.f736e;
            this.f504a.f733b = this.f511j.mo416a(h);
            i3 = (-this.f511j.mo416a(h)) + this.f511j.mo419c();
        }
        this.f504a.f734c = i2;
        if (z) {
            C0195x c0195x3 = this.f504a;
            c0195x3.f734c -= i3;
        }
        this.f504a.f738g = i3;
    }

    int m1327a(int i, ax axVar, bd bdVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.f504a.f732a = true;
        m1335c();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m1302a(i2, abs, true, bdVar);
        int a = this.f504a.f738g + m1328a(axVar, this.f504a, bdVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f511j.mo417a(-i);
        return i;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f515n == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void m1304a(ax axVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, axVar);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, axVar);
                i--;
            }
        }
    }

    private void m1303a(ax axVar, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            int i2;
            if (this.f512k) {
                for (i2 = childCount - 1; i2 >= 0; i2--) {
                    if (this.f511j.mo418b(getChildAt(i2)) > i) {
                        m1304a(axVar, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < childCount; i2++) {
                if (this.f511j.mo418b(getChildAt(i2)) > i) {
                    m1304a(axVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void m1312b(ax axVar, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int e = this.f511j.mo423e() - i;
            int i2;
            if (this.f512k) {
                for (i2 = 0; i2 < childCount; i2++) {
                    if (this.f511j.mo416a(getChildAt(i2)) < e) {
                        m1304a(axVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = childCount - 1; i2 >= 0; i2--) {
                if (this.f511j.mo416a(getChildAt(i2)) < e) {
                    m1304a(axVar, childCount - 1, i2);
                    return;
                }
            }
        }
    }

    private void m1306a(ax axVar, C0195x c0195x) {
        if (!c0195x.f732a) {
            return;
        }
        if (c0195x.f737f == -1) {
            m1312b(axVar, c0195x.f738g);
        } else {
            m1303a(axVar, c0195x.f738g);
        }
    }

    int m1328a(ax axVar, C0195x c0195x, bd bdVar, boolean z) {
        int i = c0195x.f734c;
        if (c0195x.f738g != Integer.MIN_VALUE) {
            if (c0195x.f734c < 0) {
                c0195x.f738g += c0195x.f734c;
            }
            m1306a(axVar, c0195x);
        }
        int i2 = c0195x.f734c + c0195x.f739h;
        C0194w c0194w = new C0194w();
        while (i2 > 0 && c0195x.m1813a(bdVar)) {
            c0194w.m1810a();
            mo398a(axVar, bdVar, c0195x, c0194w);
            if (!c0194w.f729b) {
                c0195x.f733b += c0194w.f728a * c0195x.f737f;
                if (!(c0194w.f730c && this.f504a.f741j == null && bdVar.m1648a())) {
                    c0195x.f734c -= c0194w.f728a;
                    i2 -= c0194w.f728a;
                }
                if (c0195x.f738g != Integer.MIN_VALUE) {
                    c0195x.f738g += c0194w.f728a;
                    if (c0195x.f734c < 0) {
                        c0195x.f738g += c0195x.f734c;
                    }
                    m1306a(axVar, c0195x);
                }
                if (z && c0194w.f731d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0195x.f734c;
    }

    void mo398a(ax axVar, bd bdVar, C0195x c0195x, C0194w c0194w) {
        View a = c0195x.m1812a(axVar);
        if (a == null) {
            c0194w.f729b = true;
            return;
        }
        int width;
        int d;
        int i;
        int i2;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (c0195x.f741j == null) {
            if (this.f512k == (c0195x.f737f == -1)) {
                addView(a);
            } else {
                addView(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.f512k;
            if (c0195x.f737f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                addDisappearingView(a);
            } else {
                addDisappearingView(a, 0);
            }
        }
        measureChildWithMargins(a, 0, 0);
        c0194w.f728a = this.f511j.mo420c(a);
        if (this.f510i == 1) {
            if (m1334b()) {
                width = getWidth() - getPaddingRight();
                d = width - this.f511j.mo422d(a);
            } else {
                d = getPaddingLeft();
                width = this.f511j.mo422d(a) + d;
            }
            if (c0195x.f737f == -1) {
                i = c0195x.f733b - c0194w.f728a;
                i2 = width;
                width = c0195x.f733b;
            } else {
                i = c0195x.f733b;
                i2 = width;
                width = c0195x.f733b + c0194w.f728a;
            }
        } else {
            i = getPaddingTop();
            width = this.f511j.mo422d(a) + i;
            if (c0195x.f737f == -1) {
                d = c0195x.f733b - c0194w.f728a;
                i2 = c0195x.f733b;
            } else {
                d = c0195x.f733b;
                i2 = c0195x.f733b + c0194w.f728a;
            }
        }
        layoutDecorated(a, d + layoutParams.leftMargin, i + layoutParams.topMargin, i2 - layoutParams.rightMargin, width - layoutParams.bottomMargin);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            c0194w.f730c = true;
        }
        c0194w.f731d = a.isFocusable();
    }

    private int m1308b(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.f510i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.f510i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.f510i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f510i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View m1324g() {
        return getChildAt(this.f512k ? getChildCount() - 1 : 0);
    }

    private View m1325h() {
        return getChildAt(this.f512k ? 0 : getChildCount() - 1);
    }

    private View m1321e(bd bdVar) {
        return this.f512k ? m1316c(bdVar.m1654f()) : m1319d(bdVar.m1654f());
    }

    private View m1322f(bd bdVar) {
        return this.f512k ? m1319d(bdVar.m1654f()) : m1316c(bdVar.m1654f());
    }

    private View m1316c(int i) {
        return m1300a(0, getChildCount(), i);
    }

    private View m1319d(int i) {
        return m1300a(getChildCount() - 1, -1, i);
    }

    private View m1300a(int i, int i2, int i3) {
        View view = null;
        m1335c();
        int c = this.f511j.mo419c();
        int d = this.f511j.mo421d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.f511j.mo416a(childAt) < d && this.f511j.mo418b(childAt) >= c) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public int m1336d() {
        View a = m1331a(0, getChildCount(), false);
        return a == null ? -1 : getPosition(a);
    }

    public int m1337e() {
        View a = m1331a(getChildCount() - 1, -1, false);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    View m1331a(int i, int i2, boolean z) {
        m1335c();
        int c = this.f511j.mo419c();
        int d = this.f511j.mo421d();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            int a = this.f511j.mo416a(childAt);
            int b = this.f511j.mo418b(childAt);
            if (a < d && b > c) {
                if (!z) {
                    return childAt;
                }
                if (a >= c && b <= d) {
                    return childAt;
                }
            }
            i += i3;
        }
        return null;
    }

    public View onFocusSearchFailed(View view, int i, ax axVar, bd bdVar) {
        m1323f();
        if (getChildCount() == 0) {
            return null;
        }
        int b = m1308b(i);
        if (b == Integer.MIN_VALUE) {
            return null;
        }
        View f;
        m1335c();
        if (b == -1) {
            f = m1322f(bdVar);
        } else {
            f = m1321e(bdVar);
        }
        if (f == null) {
            return null;
        }
        View g;
        m1335c();
        m1302a(b, (int) (0.33f * ((float) this.f511j.mo424f())), false, bdVar);
        this.f504a.f738g = Integer.MIN_VALUE;
        this.f504a.f732a = false;
        m1328a(axVar, this.f504a, bdVar, true);
        if (b == -1) {
            g = m1324g();
        } else {
            g = m1325h();
        }
        if (g == f || !g.isFocusable()) {
            return null;
        }
        return g;
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f515n == null && this.f505b == this.f507d;
    }
}
