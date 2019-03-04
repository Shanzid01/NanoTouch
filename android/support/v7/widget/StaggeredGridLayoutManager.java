package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ay;
import android.support.v4.view.p005a.C0094a;
import android.support.v4.view.p005a.C0098e;
import android.support.v4.view.p005a.C0107n;
import android.support.v4.view.p005a.ag;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends at {
    ac f546a;
    ac f547b;
    boolean f548c;
    int f549d;
    int f550e;
    LazySpanLookup f551f;
    private int f552g;
    private bo[] f553h;
    private int f554i;
    private int f555j;
    private C0191t f556k;
    private boolean f557l;
    private BitSet f558m;
    private int f559n;
    private boolean f560o;
    private boolean f561p;
    private SavedState f562q;
    private int f563r;
    private int f564s;
    private int f565t;
    private final bl f566u;
    private boolean f567v;
    private boolean f568w;
    private final Runnable f569x;

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        bo f529a;
        boolean f530b;

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

        public final int m1355a() {
            if (this.f529a == null) {
                return -1;
            }
            return this.f529a.f659d;
        }
    }

    class LazySpanLookup {
        int[] f534a;
        List<FullSpanItem> f535b;

        class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new bm();
            int f531a;
            int f532b;
            int[] f533c;

            public FullSpanItem(Parcel parcel) {
                this.f531a = parcel.readInt();
                this.f532b = parcel.readInt();
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f533c = new int[readInt];
                    parcel.readIntArray(this.f533c);
                }
            }

            int m1356a(int i) {
                return this.f533c == null ? 0 : this.f533c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f531a);
                parcel.writeInt(this.f532b);
                if (this.f533c == null || this.f533c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f533c.length);
                parcel.writeIntArray(this.f533c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f531a + ", mGapDir=" + this.f532b + ", mGapPerSpan=" + Arrays.toString(this.f533c) + '}';
            }
        }

        int m1360a(int i) {
            if (this.f535b != null) {
                for (int size = this.f535b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f535b.get(size)).f531a >= i) {
                        this.f535b.remove(size);
                    }
                }
            }
            return m1366b(i);
        }

        int m1366b(int i) {
            if (this.f534a == null || i >= this.f534a.length) {
                return -1;
            }
            int g = m1359g(i);
            if (g == -1) {
                Arrays.fill(this.f534a, i, this.f534a.length, -1);
                return this.f534a.length;
            }
            Arrays.fill(this.f534a, i, g + 1, -1);
            return g + 1;
        }

        int m1368c(int i) {
            if (this.f534a == null || i >= this.f534a.length) {
                return -1;
            }
            return this.f534a[i];
        }

        void m1364a(int i, bo boVar) {
            m1370e(i);
            this.f534a[i] = boVar.f659d;
        }

        int m1369d(int i) {
            int length = this.f534a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m1370e(int i) {
            if (this.f534a == null) {
                this.f534a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f534a, -1);
            } else if (i >= this.f534a.length) {
                Object obj = this.f534a;
                this.f534a = new int[m1369d(i)];
                System.arraycopy(obj, 0, this.f534a, 0, obj.length);
                Arrays.fill(this.f534a, obj.length, this.f534a.length, -1);
            }
        }

        void m1362a() {
            if (this.f534a != null) {
                Arrays.fill(this.f534a, -1);
            }
            this.f535b = null;
        }

        void m1363a(int i, int i2) {
            if (this.f534a != null && i < this.f534a.length) {
                m1370e(i + i2);
                System.arraycopy(this.f534a, i + i2, this.f534a, i, (this.f534a.length - i) - i2);
                Arrays.fill(this.f534a, this.f534a.length - i2, this.f534a.length, -1);
                m1357c(i, i2);
            }
        }

        private void m1357c(int i, int i2) {
            if (this.f535b != null) {
                int i3 = i + i2;
                for (int size = this.f535b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f535b.get(size);
                    if (fullSpanItem.f531a >= i) {
                        if (fullSpanItem.f531a < i3) {
                            this.f535b.remove(size);
                        } else {
                            fullSpanItem.f531a -= i2;
                        }
                    }
                }
            }
        }

        void m1367b(int i, int i2) {
            if (this.f534a != null && i < this.f534a.length) {
                m1370e(i + i2);
                System.arraycopy(this.f534a, i, this.f534a, i + i2, (this.f534a.length - i) - i2);
                Arrays.fill(this.f534a, i, i + i2, -1);
                m1358d(i, i2);
            }
        }

        private void m1358d(int i, int i2) {
            if (this.f535b != null) {
                for (int size = this.f535b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f535b.get(size);
                    if (fullSpanItem.f531a >= i) {
                        fullSpanItem.f531a += i2;
                    }
                }
            }
        }

        private int m1359g(int i) {
            if (this.f535b == null) {
                return -1;
            }
            FullSpanItem f = m1371f(i);
            if (f != null) {
                this.f535b.remove(f);
            }
            int size = this.f535b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.f535b.get(i2)).f531a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.f535b.get(i2);
            this.f535b.remove(i2);
            return f.f531a;
        }

        public void m1365a(FullSpanItem fullSpanItem) {
            if (this.f535b == null) {
                this.f535b = new ArrayList();
            }
            int size = this.f535b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f535b.get(i);
                if (fullSpanItem2.f531a == fullSpanItem.f531a) {
                    this.f535b.remove(i);
                }
                if (fullSpanItem2.f531a >= fullSpanItem.f531a) {
                    this.f535b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f535b.add(fullSpanItem);
        }

        public FullSpanItem m1371f(int i) {
            if (this.f535b == null) {
                return null;
            }
            for (int size = this.f535b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f535b.get(size);
                if (fullSpanItem.f531a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem m1361a(int i, int i2, int i3) {
            if (this.f535b == null) {
                return null;
            }
            for (int i4 = 0; i4 < this.f535b.size(); i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f535b.get(i4);
                if (fullSpanItem.f531a >= i2) {
                    return null;
                }
                if (fullSpanItem.f531a >= i && (i3 == 0 || fullSpanItem.f532b == i3)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new bn();
        int f536a;
        int f537b;
        int f538c;
        int[] f539d;
        int f540e;
        int[] f541f;
        List<FullSpanItem> f542g;
        boolean f543h;
        boolean f544i;
        boolean f545j;

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f536a = parcel.readInt();
            this.f537b = parcel.readInt();
            this.f538c = parcel.readInt();
            if (this.f538c > 0) {
                this.f539d = new int[this.f538c];
                parcel.readIntArray(this.f539d);
            }
            this.f540e = parcel.readInt();
            if (this.f540e > 0) {
                this.f541f = new int[this.f540e];
                parcel.readIntArray(this.f541f);
            }
            this.f543h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f544i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f545j = z2;
            this.f542g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f538c = savedState.f538c;
            this.f536a = savedState.f536a;
            this.f537b = savedState.f537b;
            this.f539d = savedState.f539d;
            this.f540e = savedState.f540e;
            this.f541f = savedState.f541f;
            this.f543h = savedState.f543h;
            this.f544i = savedState.f544i;
            this.f545j = savedState.f545j;
            this.f542g = savedState.f542g;
        }

        void m1372a() {
            this.f539d = null;
            this.f538c = 0;
            this.f540e = 0;
            this.f541f = null;
            this.f542g = null;
        }

        void m1373b() {
            this.f539d = null;
            this.f538c = 0;
            this.f536a = -1;
            this.f537b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.f536a);
            parcel.writeInt(this.f537b);
            parcel.writeInt(this.f538c);
            if (this.f538c > 0) {
                parcel.writeIntArray(this.f539d);
            }
            parcel.writeInt(this.f540e);
            if (this.f540e > 0) {
                parcel.writeIntArray(this.f541f);
            }
            if (this.f543h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f544i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.f545j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.f542g);
        }
    }

    private void m1406e() {
        if (getChildCount() != 0 && this.f559n != 0) {
            int h;
            int i;
            if (this.f548c) {
                h = m1411h();
                i = m1413i();
            } else {
                h = m1413i();
                i = m1411h();
            }
            if (h == 0 && m1417a() != null) {
                this.f551f.m1362a();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
            } else if (this.f567v) {
                int i2 = this.f548c ? -1 : 1;
                FullSpanItem a = this.f551f.m1361a(h, i + 1, i2);
                if (a == null) {
                    this.f567v = false;
                    this.f551f.m1360a(i + 1);
                    return;
                }
                FullSpanItem a2 = this.f551f.m1361a(h, a.f531a, i2 * -1);
                if (a2 == null) {
                    this.f551f.m1360a(a.f531a);
                } else {
                    this.f551f.m1360a(a2.f531a + 1);
                }
                requestSimpleAnimationsInNextLayout();
                requestLayout();
            }
        }
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m1406e();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, ax axVar) {
        for (int i = 0; i < this.f552g; i++) {
            this.f553h[i].m1724e();
        }
    }

    View m1417a() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.f552g);
        bitSet.set(0, this.f552g, true);
        boolean z = (this.f554i == 1 && m1421b()) ? true : true;
        if (this.f548c) {
            childCount--;
            i = -1;
        } else {
            i = childCount;
            childCount = 0;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.f529a.f659d)) {
                if (m1393a(layoutParams.f529a)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.f529a.f659d);
            }
            if (!(layoutParams.f530b || i3 + i2 == i)) {
                boolean z2;
                View childAt2 = getChildAt(i3 + i2);
                int b;
                if (this.f548c) {
                    childCount = this.f546a.mo418b(childAt);
                    b = this.f546a.mo418b(childAt2);
                    if (childCount < b) {
                        return childAt;
                    }
                    if (childCount == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.f546a.mo416a(childAt);
                    b = this.f546a.mo416a(childAt2);
                    if (childCount > b) {
                        return childAt;
                    }
                    if (childCount == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if (layoutParams.f529a.f659d - ((LayoutParams) childAt2.getLayoutParams()).f529a.f659d < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (z >= false)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private boolean m1393a(bo boVar) {
        if (this.f548c) {
            if (boVar.m1722d() < this.f546a.mo421d()) {
                return true;
            }
        } else if (boVar.m1716b() > this.f546a.mo419c()) {
            return true;
        }
        return false;
    }

    public void m1419a(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (!(this.f562q == null || this.f562q.f543h == z)) {
            this.f562q.f543h = z;
        }
        this.f557l = z;
        requestLayout();
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f562q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void m1408f() {
        if (this.f546a == null) {
            this.f546a = ac.m1454a(this, this.f554i);
            this.f547b = ac.m1454a(this, 1 - this.f554i);
            this.f556k = new C0191t();
        }
    }

    private void m1409g() {
        boolean z = true;
        if (this.f554i == 1 || !m1421b()) {
            this.f548c = this.f557l;
            return;
        }
        if (this.f557l) {
            z = false;
        }
        this.f548c = z;
    }

    boolean m1421b() {
        return getLayoutDirection() == 1;
    }

    public void onLayoutChildren(ax axVar, bd bdVar) {
        m1408f();
        bl blVar = this.f566u;
        blVar.m1704a();
        if (this.f562q != null) {
            m1386a(blVar);
        } else {
            m1409g();
            blVar.f653c = this.f548c;
        }
        m1418a(bdVar, blVar);
        if (this.f562q == null && !(blVar.f653c == this.f560o && m1421b() == this.f561p)) {
            this.f551f.m1362a();
            blVar.f654d = true;
        }
        if (getChildCount() > 0 && (this.f562q == null || this.f562q.f538c < 1)) {
            int i;
            if (blVar.f654d) {
                for (i = 0; i < this.f552g; i++) {
                    this.f553h[i].m1724e();
                    if (blVar.f652b != Integer.MIN_VALUE) {
                        this.f553h[i].m1721c(blVar.f652b);
                    }
                }
            } else {
                for (i = 0; i < this.f552g; i++) {
                    this.f553h[i].m1715a(this.f548c, blVar.f652b);
                }
            }
        }
        detachAndScrapAttachedViews(axVar);
        this.f567v = false;
        m1424c();
        C0191t c0191t;
        if (blVar.f653c) {
            m1382a(blVar.f651a, bdVar);
            m1377a(axVar, this.f556k, bdVar);
            m1397b(blVar.f651a, bdVar);
            c0191t = this.f556k;
            c0191t.f719b += this.f556k.f720c;
            m1377a(axVar, this.f556k, bdVar);
        } else {
            m1397b(blVar.f651a, bdVar);
            m1377a(axVar, this.f556k, bdVar);
            m1382a(blVar.f651a, bdVar);
            c0191t = this.f556k;
            c0191t.f719b += this.f556k.f720c;
            m1377a(axVar, this.f556k, bdVar);
        }
        if (getChildCount() > 0) {
            if (this.f548c) {
                m1384a(axVar, bdVar, true);
                m1399b(axVar, bdVar, false);
            } else {
                m1399b(axVar, bdVar, true);
                m1384a(axVar, bdVar, false);
            }
        }
        if (!bdVar.m1648a()) {
            if (getChildCount() > 0 && this.f549d != -1 && this.f567v) {
                ay.m571a(getChildAt(0), this.f569x);
            }
            this.f549d = -1;
            this.f550e = Integer.MIN_VALUE;
        }
        this.f560o = blVar.f653c;
        this.f561p = m1421b();
        this.f562q = null;
    }

    private void m1386a(bl blVar) {
        if (this.f562q.f538c > 0) {
            if (this.f562q.f538c == this.f552g) {
                for (int i = 0; i < this.f552g; i++) {
                    this.f553h[i].m1724e();
                    int i2 = this.f562q.f539d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f562q.f544i) {
                            i2 += this.f546a.mo421d();
                        } else {
                            i2 += this.f546a.mo419c();
                        }
                    }
                    this.f553h[i].m1721c(i2);
                }
            } else {
                this.f562q.m1372a();
                this.f562q.f536a = this.f562q.f537b;
            }
        }
        this.f561p = this.f562q.f545j;
        m1419a(this.f562q.f543h);
        m1409g();
        if (this.f562q.f536a != -1) {
            this.f549d = this.f562q.f536a;
            blVar.f653c = this.f562q.f544i;
        } else {
            blVar.f653c = this.f548c;
        }
        if (this.f562q.f540e > 1) {
            this.f551f.f534a = this.f562q.f541f;
            this.f551f.f535b = this.f562q.f542g;
        }
    }

    void m1418a(bd bdVar, bl blVar) {
        if (!m1422b(bdVar, blVar) && !m1403c(bdVar, blVar)) {
            blVar.m1706b();
            blVar.f651a = 0;
        }
    }

    private boolean m1403c(bd bdVar, bl blVar) {
        blVar.f651a = this.f560o ? m1415j(bdVar.m1654f()) : m1414i(bdVar.m1654f());
        blVar.f652b = Integer.MIN_VALUE;
        return true;
    }

    boolean m1422b(bd bdVar, bl blVar) {
        boolean z = false;
        if (bdVar.m1648a() || this.f549d == -1) {
            return false;
        }
        if (this.f549d < 0 || this.f549d >= bdVar.m1654f()) {
            this.f549d = -1;
            this.f550e = Integer.MIN_VALUE;
            return false;
        } else if (this.f562q == null || this.f562q.f536a == -1 || this.f562q.f538c < 1) {
            View findViewByPosition = findViewByPosition(this.f549d);
            if (findViewByPosition != null) {
                blVar.f651a = this.f548c ? m1411h() : m1413i();
                if (this.f550e != Integer.MIN_VALUE) {
                    if (blVar.f653c) {
                        blVar.f652b = (this.f546a.mo421d() - this.f550e) - this.f546a.mo418b(findViewByPosition);
                        return true;
                    }
                    blVar.f652b = (this.f546a.mo419c() + this.f550e) - this.f546a.mo416a(findViewByPosition);
                    return true;
                } else if (this.f546a.mo420c(findViewByPosition) > this.f546a.mo424f()) {
                    blVar.f652b = blVar.f653c ? this.f546a.mo421d() : this.f546a.mo419c();
                    return true;
                } else {
                    int a = this.f546a.mo416a(findViewByPosition) - this.f546a.mo419c();
                    if (a < 0) {
                        blVar.f652b = -a;
                        return true;
                    }
                    a = this.f546a.mo421d() - this.f546a.mo418b(findViewByPosition);
                    if (a < 0) {
                        blVar.f652b = a;
                        return true;
                    }
                    blVar.f652b = Integer.MIN_VALUE;
                    return true;
                }
            }
            blVar.f651a = this.f549d;
            if (this.f550e == Integer.MIN_VALUE) {
                if (m1412h(blVar.f651a) == 1) {
                    z = true;
                }
                blVar.f653c = z;
                blVar.m1706b();
            } else {
                blVar.m1705a(this.f550e);
            }
            blVar.f654d = true;
            return true;
        } else {
            blVar.f652b = Integer.MIN_VALUE;
            blVar.f651a = this.f549d;
            return true;
        }
    }

    void m1424c() {
        this.f555j = this.f547b.mo424f() / this.f552g;
        this.f563r = MeasureSpec.makeMeasureSpec(this.f547b.mo424f(), 1073741824);
        if (this.f554i == 1) {
            this.f564s = MeasureSpec.makeMeasureSpec(this.f555j, 1073741824);
            this.f565t = MeasureSpec.makeMeasureSpec(0, 0);
            return;
        }
        this.f565t = MeasureSpec.makeMeasureSpec(this.f555j, 1073741824);
        this.f564s = MeasureSpec.makeMeasureSpec(0, 0);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f562q == null;
    }

    public int computeHorizontalScrollOffset(bd bdVar) {
        return m1378a(bdVar);
    }

    private int m1378a(bd bdVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        m1408f();
        ac acVar = this.f546a;
        View b = m1420b(!this.f568w);
        if (this.f568w) {
            z = false;
        }
        return bj.m1702a(bdVar, acVar, b, m1423c(z), this, this.f568w, this.f548c);
    }

    public int computeVerticalScrollOffset(bd bdVar) {
        return m1378a(bdVar);
    }

    public int computeHorizontalScrollExtent(bd bdVar) {
        return m1394b(bdVar);
    }

    private int m1394b(bd bdVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        m1408f();
        ac acVar = this.f546a;
        View b = m1420b(!this.f568w);
        if (this.f568w) {
            z = false;
        }
        return bj.m1701a(bdVar, acVar, b, m1423c(z), this, this.f568w);
    }

    public int computeVerticalScrollExtent(bd bdVar) {
        return m1394b(bdVar);
    }

    public int computeHorizontalScrollRange(bd bdVar) {
        return m1402c(bdVar);
    }

    private int m1402c(bd bdVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        m1408f();
        ac acVar = this.f546a;
        View b = m1420b(!this.f568w);
        if (this.f568w) {
            z = false;
        }
        return bj.m1703b(bdVar, acVar, b, m1423c(z), this, this.f568w);
    }

    public int computeVerticalScrollRange(bd bdVar) {
        return m1402c(bdVar);
    }

    private void m1391a(View view, LayoutParams layoutParams) {
        if (!layoutParams.f530b) {
            m1389a(view, this.f564s, this.f565t);
        } else if (this.f554i == 1) {
            m1389a(view, this.f563r, this.f565t);
        } else {
            m1389a(view, this.f564s, this.f563r);
        }
    }

    private void m1389a(View view, int i, int i2) {
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(m1374a(i, layoutParams.leftMargin + itemDecorInsetsForChild.left, layoutParams.rightMargin + itemDecorInsetsForChild.right), m1374a(i2, layoutParams.topMargin + itemDecorInsetsForChild.top, layoutParams.bottomMargin + itemDecorInsetsForChild.bottom));
    }

    private int m1374a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f562q = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f562q != null) {
            return new SavedState(this.f562q);
        }
        SavedState savedState = new SavedState();
        savedState.f543h = this.f557l;
        savedState.f544i = this.f560o;
        savedState.f545j = this.f561p;
        if (this.f551f == null || this.f551f.f534a == null) {
            savedState.f540e = 0;
        } else {
            savedState.f541f = this.f551f.f534a;
            savedState.f540e = savedState.f541f.length;
            savedState.f542g = this.f551f.f535b;
        }
        if (getChildCount() > 0) {
            m1408f();
            savedState.f536a = this.f560o ? m1411h() : m1413i();
            savedState.f537b = m1425d();
            savedState.f538c = this.f552g;
            savedState.f539d = new int[this.f552g];
            for (int i = 0; i < this.f552g; i++) {
                int b;
                if (this.f560o) {
                    b = this.f553h[i].m1717b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f546a.mo421d();
                    }
                } else {
                    b = this.f553h[i].m1712a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f546a.mo419c();
                    }
                }
                savedState.f539d[i] = b;
            }
        } else {
            savedState.f536a = -1;
            savedState.f537b = -1;
            savedState.f538c = 0;
        }
        return savedState;
    }

    public void onInitializeAccessibilityNodeInfoForItem(ax axVar, bd bdVar, View view, C0098e c0098e) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.f554i == 0) {
                c0098e.m256c(C0107n.m424a(layoutParams2.m1355a(), layoutParams2.f530b ? this.f552g : 1, -1, -1, layoutParams2.f530b, false));
                return;
            } else {
                c0098e.m256c(C0107n.m424a(-1, -1, layoutParams2.m1355a(), layoutParams2.f530b ? this.f552g : 1, layoutParams2.f530b, false));
                return;
            }
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, c0098e);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            ag a = C0094a.m200a(accessibilityEvent);
            View b = m1420b(false);
            View c = m1423c(false);
            if (b != null && c != null) {
                int position = getPosition(b);
                int position2 = getPosition(c);
                if (position < position2) {
                    a.m213b(position);
                    a.m214c(position2);
                    return;
                }
                a.m213b(position2);
                a.m214c(position);
            }
        }
    }

    int m1425d() {
        View c = this.f548c ? m1423c(true) : m1420b(true);
        return c == null ? -1 : getPosition(c);
    }

    public int getRowCountForAccessibility(ax axVar, bd bdVar) {
        if (this.f554i == 0) {
            return this.f552g;
        }
        return super.getRowCountForAccessibility(axVar, bdVar);
    }

    public int getColumnCountForAccessibility(ax axVar, bd bdVar) {
        if (this.f554i == 1) {
            return this.f552g;
        }
        return super.getColumnCountForAccessibility(axVar, bdVar);
    }

    View m1420b(boolean z) {
        m1408f();
        int c = this.f546a.mo419c();
        int d = this.f546a.mo421d();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z || this.f546a.mo416a(childAt) >= c) && this.f546a.mo418b(childAt) <= d) {
                return childAt;
            }
        }
        return null;
    }

    View m1423c(boolean z) {
        m1408f();
        int c = this.f546a.mo419c();
        int d = this.f546a.mo421d();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f546a.mo416a(childAt) >= c && (!z || this.f546a.mo418b(childAt) <= d)) {
                return childAt;
            }
        }
        return null;
    }

    private void m1384a(ax axVar, bd bdVar, boolean z) {
        int d = this.f546a.mo421d() - m1405e(this.f546a.mo421d());
        if (d > 0) {
            d -= -m1416a(-d, axVar, bdVar);
            if (z && d > 0) {
                this.f546a.mo417a(d);
            }
        }
    }

    private void m1399b(ax axVar, bd bdVar, boolean z) {
        int d = m1404d(this.f546a.mo419c()) - this.f546a.mo419c();
        if (d > 0) {
            d -= m1416a(d, axVar, bdVar);
            if (z && d > 0) {
                this.f546a.mo417a(-d);
            }
        }
    }

    private void m1382a(int i, bd bdVar) {
        int i2 = 1;
        this.f556k.f718a = 0;
        this.f556k.f719b = i;
        if (isSmoothScrolling()) {
            if (this.f548c == (bdVar.m1651c() < i)) {
                this.f556k.f722e = 0;
            } else {
                this.f556k.f722e = this.f546a.mo424f();
            }
        } else {
            this.f556k.f722e = 0;
        }
        this.f556k.f721d = -1;
        C0191t c0191t = this.f556k;
        if (!this.f548c) {
            i2 = -1;
        }
        c0191t.f720c = i2;
    }

    private void m1397b(int i, bd bdVar) {
        int i2 = 1;
        this.f556k.f718a = 0;
        this.f556k.f719b = i;
        if (isSmoothScrolling()) {
            if (this.f548c == (bdVar.m1651c() > i)) {
                this.f556k.f722e = 0;
            } else {
                this.f556k.f722e = this.f546a.mo424f();
            }
        } else {
            this.f556k.f722e = 0;
        }
        this.f556k.f721d = 1;
        C0191t c0191t = this.f556k;
        if (this.f548c) {
            i2 = -1;
        }
        c0191t.f720c = i2;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f552g; i2++) {
            this.f553h[i2].m1723d(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f552g; i2++) {
            this.f553h[i2].m1723d(i);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m1396b(i, i2, 1);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m1396b(i, i2, 0);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f551f.m1362a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m1396b(i, i2, 3);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        m1396b(i, i2, 2);
    }

    private void m1396b(int i, int i2, int i3) {
        int h = this.f548c ? m1411h() : m1413i();
        this.f551f.m1366b(i);
        switch (i3) {
            case 0:
                this.f551f.m1367b(i, i2);
                break;
            case 1:
                this.f551f.m1363a(i, i2);
                break;
            case 3:
                this.f551f.m1363a(i, 1);
                this.f551f.m1367b(i2, 1);
                break;
        }
        if (i + i2 > h) {
            if (i <= (this.f548c ? m1413i() : m1411h())) {
                requestLayout();
            }
        }
    }

    private int m1377a(ax axVar, C0191t c0191t, bd bdVar) {
        int d;
        int i;
        int g;
        this.f558m.set(0, this.f552g, true);
        if (c0191t.f721d == 1) {
            d = this.f546a.mo421d() + this.f556k.f718a;
            i = d;
            g = (this.f556k.f722e + d) + this.f546a.mo425g();
        } else {
            d = this.f546a.mo419c() - this.f556k.f718a;
            i = d;
            g = (d - this.f556k.f722e) - this.f546a.mo419c();
        }
        m1381a(c0191t.f721d, g);
        int d2 = this.f548c ? this.f546a.mo421d() : this.f546a.mo419c();
        while (c0191t.m1805a(bdVar) && !this.f558m.isEmpty()) {
            bo boVar;
            int c;
            View a = c0191t.m1804a(axVar);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            if (c0191t.f721d == 1) {
                addView(a);
            } else {
                addView(a, 0);
            }
            m1391a(a, layoutParams);
            int viewPosition = layoutParams.getViewPosition();
            int c2 = this.f551f.m1368c(viewPosition);
            Object obj = c2 == -1 ? 1 : null;
            if (obj != null) {
                bo a2 = layoutParams.f530b ? this.f553h[0] : m1380a(c0191t);
                this.f551f.m1364a(viewPosition, a2);
                boVar = a2;
            } else {
                boVar = this.f553h[c2];
            }
            if (c0191t.f721d == 1) {
                if (layoutParams.f530b) {
                    d = m1405e(d2);
                } else {
                    d = boVar.m1717b(d2);
                }
                c = d + this.f546a.mo420c(a);
                if (obj == null || !layoutParams.f530b) {
                    c2 = d;
                } else {
                    FullSpanItem a3 = m1379a(d);
                    a3.f532b = -1;
                    a3.f531a = viewPosition;
                    this.f551f.m1365a(a3);
                    c2 = d;
                }
            } else {
                if (layoutParams.f530b) {
                    d = m1404d(d2);
                } else {
                    d = boVar.m1712a(d2);
                }
                c2 = d - this.f546a.mo420c(a);
                if (obj != null && layoutParams.f530b) {
                    FullSpanItem b = m1395b(d);
                    b.f532b = 1;
                    b.f531a = viewPosition;
                    this.f551f.m1365a(b);
                }
                c = d;
            }
            if (layoutParams.f530b && c0191t.f720c == -1 && obj != null) {
                this.f567v = true;
            }
            layoutParams.f529a = boVar;
            m1392a(a, layoutParams, c0191t);
            int c3 = layoutParams.f530b ? this.f547b.mo419c() : this.f547b.mo419c() + (boVar.f659d * this.f555j);
            viewPosition = c3 + this.f547b.mo420c(a);
            if (this.f554i == 1) {
                m1390a(a, c3, c2, viewPosition, c);
            } else {
                m1390a(a, c2, c3, c, viewPosition);
            }
            if (layoutParams.f530b) {
                m1381a(this.f556k.f721d, g);
            } else {
                m1387a(boVar, this.f556k.f721d, g);
            }
            m1385a(axVar, this.f556k, boVar, i);
        }
        if (this.f556k.f721d == -1) {
            return Math.max(0, (i - m1404d(this.f546a.mo419c())) + this.f556k.f718a);
        }
        return Math.max(0, (m1405e(this.f546a.mo421d()) - i) + this.f556k.f718a);
    }

    private FullSpanItem m1379a(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f533c = new int[this.f552g];
        for (int i2 = 0; i2 < this.f552g; i2++) {
            fullSpanItem.f533c[i2] = i - this.f553h[i2].m1717b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m1395b(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f533c = new int[this.f552g];
        for (int i2 = 0; i2 < this.f552g; i2++) {
            fullSpanItem.f533c[i2] = this.f553h[i2].m1712a(i) - i;
        }
        return fullSpanItem;
    }

    private void m1392a(View view, LayoutParams layoutParams, C0191t c0191t) {
        if (c0191t.f721d == 1) {
            if (layoutParams.f530b) {
                m1388a(view);
            } else {
                layoutParams.f529a.m1718b(view);
            }
        } else if (layoutParams.f530b) {
            m1400b(view);
        } else {
            layoutParams.f529a.m1714a(view);
        }
    }

    private void m1385a(ax axVar, C0191t c0191t, bo boVar, int i) {
        if (c0191t.f721d == -1) {
            m1398b(axVar, Math.max(i, m1401c(boVar.m1716b())) + (this.f546a.mo423e() - this.f546a.mo419c()));
        } else {
            m1383a(axVar, Math.min(i, m1407f(boVar.m1722d())) - (this.f546a.mo423e() - this.f546a.mo419c()));
        }
    }

    private void m1388a(View view) {
        for (int i = this.f552g - 1; i >= 0; i--) {
            this.f553h[i].m1718b(view);
        }
    }

    private void m1400b(View view) {
        for (int i = this.f552g - 1; i >= 0; i--) {
            this.f553h[i].m1714a(view);
        }
    }

    private void m1390a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutDecorated(view, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void m1381a(int i, int i2) {
        for (int i3 = 0; i3 < this.f552g; i3++) {
            if (!this.f553h[i3].f661f.isEmpty()) {
                m1387a(this.f553h[i3], i, i2);
            }
        }
    }

    private void m1387a(bo boVar, int i, int i2) {
        int i3 = boVar.m1728i();
        if (i == -1) {
            if (i3 + boVar.m1716b() < i2) {
                this.f558m.set(boVar.f659d, false);
            }
        } else if (boVar.m1722d() - i3 > i2) {
            this.f558m.set(boVar.f659d, false);
        }
    }

    private int m1401c(int i) {
        int a = this.f553h[0].m1712a(i);
        for (int i2 = 1; i2 < this.f552g; i2++) {
            int a2 = this.f553h[i2].m1712a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m1404d(int i) {
        int a = this.f553h[0].m1712a(i);
        for (int i2 = 1; i2 < this.f552g; i2++) {
            int a2 = this.f553h[i2].m1712a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int m1405e(int i) {
        int b = this.f553h[0].m1717b(i);
        for (int i2 = 1; i2 < this.f552g; i2++) {
            int b2 = this.f553h[i2].m1717b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private int m1407f(int i) {
        int b = this.f553h[0].m1717b(i);
        for (int i2 = 1; i2 < this.f552g; i2++) {
            int b2 = this.f553h[i2].m1717b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void m1383a(ax axVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f546a.mo418b(childAt) < i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f530b) {
                    for (int i2 = 0; i2 < this.f552g; i2++) {
                        this.f553h[i2].m1727h();
                    }
                } else {
                    layoutParams.f529a.m1727h();
                }
                removeAndRecycleView(childAt, axVar);
            } else {
                return;
            }
        }
    }

    private void m1398b(ax axVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f546a.mo416a(childAt) > i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f530b) {
                    for (int i2 = 0; i2 < this.f552g; i2++) {
                        this.f553h[i2].m1726g();
                    }
                } else {
                    layoutParams.f529a.m1726g();
                }
                removeAndRecycleView(childAt, axVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean m1410g(int i) {
        if (this.f554i == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f548c) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f548c) != m1421b()) {
            return false;
        }
        return true;
    }

    private bo m1380a(C0191t c0191t) {
        int i;
        int i2;
        bo boVar = null;
        int i3 = -1;
        if (m1410g(c0191t.f721d)) {
            i = this.f552g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f552g;
            i3 = 1;
        }
        int c;
        int i4;
        bo boVar2;
        int b;
        bo boVar3;
        if (c0191t.f721d == 1) {
            c = this.f546a.mo419c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                boVar2 = this.f553h[i4];
                b = boVar2.m1717b(c);
                if (b < i) {
                    boVar3 = boVar2;
                } else {
                    b = i;
                    boVar3 = boVar;
                }
                i4 += i3;
                boVar = boVar3;
                i = b;
            }
        } else {
            c = this.f546a.mo421d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                boVar2 = this.f553h[i4];
                b = boVar2.m1712a(c);
                if (b > i) {
                    boVar3 = boVar2;
                } else {
                    b = i;
                    boVar3 = boVar;
                }
                i4 += i3;
                boVar = boVar3;
                i = b;
            }
        }
        return boVar;
    }

    public boolean canScrollVertically() {
        return this.f554i == 1;
    }

    public boolean canScrollHorizontally() {
        return this.f554i == 0;
    }

    public int scrollHorizontallyBy(int i, ax axVar, bd bdVar) {
        return m1416a(i, axVar, bdVar);
    }

    public int scrollVerticallyBy(int i, ax axVar, bd bdVar) {
        return m1416a(i, axVar, bdVar);
    }

    private int m1412h(int i) {
        int i2 = -1;
        if (getChildCount() != 0) {
            if ((i < m1413i()) == this.f548c) {
                i2 = 1;
            }
            return i2;
        } else if (this.f548c) {
            return 1;
        } else {
            return -1;
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, bd bdVar, int i) {
        bb bkVar = new bk(this, recyclerView.getContext());
        bkVar.setTargetPosition(i);
        startSmoothScroll(bkVar);
    }

    public void scrollToPosition(int i) {
        if (!(this.f562q == null || this.f562q.f536a == i)) {
            this.f562q.m1373b();
        }
        this.f549d = i;
        this.f550e = Integer.MIN_VALUE;
        requestLayout();
    }

    int m1416a(int i, ax axVar, bd bdVar) {
        int i2 = 1;
        int i3 = -1;
        m1408f();
        C0191t c0191t;
        if (i > 0) {
            this.f556k.f721d = 1;
            c0191t = this.f556k;
            if (!this.f548c) {
                i3 = 1;
            }
            c0191t.f720c = i3;
            i3 = m1411h();
        } else {
            this.f556k.f721d = -1;
            c0191t = this.f556k;
            if (!this.f548c) {
                i2 = -1;
            }
            c0191t.f720c = i2;
            i3 = m1413i();
        }
        this.f556k.f719b = i3 + this.f556k.f720c;
        i2 = Math.abs(i);
        this.f556k.f718a = i2;
        this.f556k.f722e = isSmoothScrolling() ? this.f546a.mo424f() : 0;
        i3 = m1377a(axVar, this.f556k, bdVar);
        if (i2 >= i3) {
            i = i < 0 ? -i3 : i3;
        }
        this.f546a.mo417a(-i);
        this.f560o = this.f548c;
        return i;
    }

    private int m1411h() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : getPosition(getChildAt(childCount - 1));
    }

    private int m1413i() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int m1414i(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int m1415j(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
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
}
