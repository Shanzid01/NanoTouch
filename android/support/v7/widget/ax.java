package android.support.v7.widget;

import android.support.v4.view.ay;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: RecyclerView */
public final class ax {
    final ArrayList<bg> f602a = new ArrayList();
    final ArrayList<bg> f603b = new ArrayList();
    final /* synthetic */ RecyclerView f604c;
    private ArrayList<bg> f605d = null;
    private final List<bg> f606e = Collections.unmodifiableList(this.f602a);
    private int f607f = 2;
    private aw f608g;
    private be f609h;

    public ax(RecyclerView recyclerView) {
        this.f604c = recyclerView;
    }

    public void m1597a() {
        this.f602a.clear();
        m1612c();
    }

    public void m1598a(int i) {
        this.f607f = i;
        for (int size = this.f603b.size() - 1; size >= 0 && this.f603b.size() > i; size--) {
            m1618d(size);
        }
        while (this.f603b.size() > i) {
            this.f603b.remove(this.f603b.size() - 1);
        }
    }

    public List<bg> m1606b() {
        return this.f606e;
    }

    boolean m1604a(bg bgVar) {
        if (bgVar.m1691q()) {
            return true;
        }
        if (bgVar.f637b < 0 || bgVar.f637b >= this.f604c.mAdapter.mo4327a()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + bgVar);
        } else if (!this.f604c.mState.m1648a() && this.f604c.mAdapter.m1524a(bgVar.f637b) != bgVar.m1680f()) {
            return false;
        } else {
            if (!this.f604c.mAdapter.m1536b() || bgVar.m1679e() == this.f604c.mAdapter.m1530b(bgVar.f637b)) {
                return true;
            }
            return false;
        }
    }

    public int m1605b(int i) {
        if (i >= 0 && i < this.f604c.mState.m1654f()) {
            return !this.f604c.mState.m1648a() ? i : this.f604c.mAdapterHelper.m1436a(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f604c.mState.m1654f());
        }
    }

    public View m1611c(int i) {
        return m1596a(i, false);
    }

    View m1596a(int i, boolean z) {
        boolean z2 = true;
        if (i < 0 || i >= this.f604c.mState.m1654f()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f604c.mState.m1654f());
        }
        boolean z3;
        bg bgVar;
        boolean z4;
        int a;
        bg bgVar2;
        boolean z5;
        LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        if (this.f604c.mState.m1648a()) {
            bg f = m1622f(i);
            bg bgVar3 = f;
            z3 = f != null;
            bgVar = bgVar3;
        } else {
            bgVar = null;
            z3 = false;
        }
        if (bgVar == null) {
            bgVar = m1594a(i, -1, z);
            if (bgVar != null) {
                if (m1604a(bgVar)) {
                    z4 = true;
                } else {
                    if (!z) {
                        bgVar.m1670a(4);
                        if (bgVar.m1681g()) {
                            this.f604c.removeDetachedView(bgVar.f636a, false);
                            bgVar.m1682h();
                        } else if (bgVar.m1683i()) {
                            bgVar.m1684j();
                        }
                        m1609b(bgVar);
                    }
                    bgVar = null;
                    z4 = z3;
                }
                if (bgVar == null) {
                    a = this.f604c.mAdapterHelper.m1436a(i);
                    if (a >= 0 || a >= this.f604c.mAdapter.mo4327a()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.f604c.mState.m1654f());
                    }
                    int a2 = this.f604c.mAdapter.m1524a(a);
                    if (this.f604c.mAdapter.m1536b()) {
                        bgVar = m1595a(this.f604c.mAdapter.m1530b(a), a2, z);
                        if (bgVar != null) {
                            bgVar.f637b = a;
                            z4 = true;
                        }
                    }
                    if (bgVar == null && this.f609h != null) {
                        View a3 = this.f609h.m1655a(this, i, a2);
                        if (a3 != null) {
                            bgVar = this.f604c.getChildViewHolder(a3);
                            if (bgVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (bgVar.m1677c()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (bgVar == null) {
                        bgVar = m1621f().m1584a(this.f604c.mAdapter.m1524a(a));
                        if (bgVar != null) {
                            bgVar.m1693s();
                            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                m1593e(bgVar);
                            }
                        }
                    }
                    if (bgVar == null) {
                        bgVar = this.f604c.mAdapter.m1531b(this.f604c, this.f604c.mAdapter.m1524a(a));
                        z3 = z4;
                        bgVar2 = bgVar;
                        if (!this.f604c.mState.m1648a() && bgVar2.m1690p()) {
                            bgVar2.f641f = i;
                            z5 = false;
                        } else if (bgVar2.m1690p() || bgVar2.m1688n() || bgVar2.m1687m()) {
                            this.f604c.mAdapter.m1535b(bgVar2, this.f604c.mAdapterHelper.m1436a(i));
                            m1592d(bgVar2.f636a);
                            if (this.f604c.mState.m1648a()) {
                                bgVar2.f641f = i;
                            }
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        layoutParams = bgVar2.f636a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams2 = (RecyclerView.LayoutParams) this.f604c.generateDefaultLayoutParams();
                            bgVar2.f636a.setLayoutParams(layoutParams2);
                        } else if (this.f604c.checkLayoutParams(layoutParams)) {
                            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                        } else {
                            layoutParams2 = (RecyclerView.LayoutParams) this.f604c.generateLayoutParams(layoutParams);
                            bgVar2.f636a.setLayoutParams(layoutParams2);
                        }
                        layoutParams2.mViewHolder = bgVar2;
                        if (!(z3 && r5)) {
                            z2 = false;
                        }
                        layoutParams2.mPendingInvalidate = z2;
                        return bgVar2.f636a;
                    }
                }
                z3 = z4;
                bgVar2 = bgVar;
                if (!this.f604c.mState.m1648a()) {
                }
                if (bgVar2.m1690p()) {
                }
                this.f604c.mAdapter.m1535b(bgVar2, this.f604c.mAdapterHelper.m1436a(i));
                m1592d(bgVar2.f636a);
                if (this.f604c.mState.m1648a()) {
                    bgVar2.f641f = i;
                }
                z5 = true;
                layoutParams = bgVar2.f636a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RecyclerView.LayoutParams) this.f604c.generateDefaultLayoutParams();
                    bgVar2.f636a.setLayoutParams(layoutParams2);
                } else if (this.f604c.checkLayoutParams(layoutParams)) {
                    layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                } else {
                    layoutParams2 = (RecyclerView.LayoutParams) this.f604c.generateLayoutParams(layoutParams);
                    bgVar2.f636a.setLayoutParams(layoutParams2);
                }
                layoutParams2.mViewHolder = bgVar2;
                z2 = false;
                layoutParams2.mPendingInvalidate = z2;
                return bgVar2.f636a;
            }
        }
        z4 = z3;
        if (bgVar == null) {
            a = this.f604c.mAdapterHelper.m1436a(i);
            if (a >= 0) {
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.f604c.mState.m1654f());
        }
        z3 = z4;
        bgVar2 = bgVar;
        if (!this.f604c.mState.m1648a()) {
        }
        if (bgVar2.m1690p()) {
        }
        this.f604c.mAdapter.m1535b(bgVar2, this.f604c.mAdapterHelper.m1436a(i));
        m1592d(bgVar2.f636a);
        if (this.f604c.mState.m1648a()) {
            bgVar2.f641f = i;
        }
        z5 = true;
        layoutParams = bgVar2.f636a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams2 = (RecyclerView.LayoutParams) this.f604c.generateDefaultLayoutParams();
            bgVar2.f636a.setLayoutParams(layoutParams2);
        } else if (this.f604c.checkLayoutParams(layoutParams)) {
            layoutParams2 = (RecyclerView.LayoutParams) this.f604c.generateLayoutParams(layoutParams);
            bgVar2.f636a.setLayoutParams(layoutParams2);
        } else {
            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        }
        layoutParams2.mViewHolder = bgVar2;
        z2 = false;
        layoutParams2.mPendingInvalidate = z2;
        return bgVar2.f636a;
    }

    private void m1592d(View view) {
        if (this.f604c.mAccessibilityManager != null && this.f604c.mAccessibilityManager.isEnabled()) {
            if (ay.m583e(view) == 0) {
                ay.m579c(view, 1);
            }
            if (!ay.m576b(view)) {
                ay.m570a(view, this.f604c.mAccessibilityDelegate.m1697b());
            }
        }
    }

    private void m1593e(bg bgVar) {
        if (bgVar.f636a instanceof ViewGroup) {
            m1591a((ViewGroup) bgVar.f636a, false);
        }
    }

    private void m1591a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m1591a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    public void m1603a(View view) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.m1692r()) {
            this.f604c.removeDetachedView(view, false);
        }
        if (childViewHolderInt.m1681g()) {
            childViewHolderInt.m1682h();
        } else if (childViewHolderInt.m1683i()) {
            childViewHolderInt.m1684j();
        }
        m1609b(childViewHolderInt);
    }

    void m1612c() {
        for (int size = this.f603b.size() - 1; size >= 0; size--) {
            m1618d(size);
        }
        this.f603b.clear();
    }

    boolean m1618d(int i) {
        bg bgVar = (bg) this.f603b.get(i);
        if (!bgVar.m1694t()) {
            return false;
        }
        m1621f().m1588a(bgVar);
        m1617d(bgVar);
        this.f603b.remove(i);
        return true;
    }

    void m1609b(bg bgVar) {
        boolean z = true;
        boolean z2 = false;
        if (bgVar.m1681g() || bgVar.f636a.getParent() != null) {
            StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(bgVar.m1681g()).append(" isAttached:");
            if (bgVar.f636a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (bgVar.m1692r()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + bgVar);
        } else if (bgVar.m1677c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            if (bgVar.m1694t()) {
                if (!bgVar.m1687m() && ((this.f604c.mState.f626j || !bgVar.m1691q()) && !bgVar.m1689o())) {
                    if (this.f603b.size() == this.f607f && !this.f603b.isEmpty()) {
                        int i = 0;
                        while (i < this.f603b.size() && !m1618d(i)) {
                            i++;
                        }
                    }
                    if (this.f603b.size() < this.f607f) {
                        this.f603b.add(bgVar);
                        z2 = true;
                    }
                }
                if (!z2) {
                    m1621f().m1588a(bgVar);
                    m1617d(bgVar);
                }
            }
            this.f604c.mState.m1647a(bgVar);
        }
    }

    void m1610b(View view) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.f646k = null;
        childViewHolderInt.m1684j();
        m1609b(childViewHolderInt);
    }

    void m1615c(View view) {
        bg childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.m1674a(this);
        if (childViewHolderInt.m1689o() && this.f604c.supportsChangeAnimations()) {
            if (this.f605d == null) {
                this.f605d = new ArrayList();
            }
            this.f605d.add(childViewHolderInt);
        } else if (!childViewHolderInt.m1687m() || childViewHolderInt.m1691q() || this.f604c.mAdapter.m1536b()) {
            this.f602a.add(childViewHolderInt);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    void m1614c(bg bgVar) {
        if (bgVar.m1689o() && this.f604c.supportsChangeAnimations() && this.f605d != null) {
            this.f605d.remove(bgVar);
        } else {
            this.f602a.remove(bgVar);
        }
        bgVar.f646k = null;
        bgVar.m1684j();
    }

    int m1616d() {
        return this.f602a.size();
    }

    View m1619e(int i) {
        return ((bg) this.f602a.get(i)).f636a;
    }

    void m1620e() {
        this.f602a.clear();
    }

    bg m1622f(int i) {
        int i2 = 0;
        if (this.f605d != null) {
            int size = this.f605d.size();
            if (size != 0) {
                bg bgVar;
                int i3 = 0;
                while (i3 < size) {
                    bgVar = (bg) this.f605d.get(i3);
                    if (bgVar.m1683i() || bgVar.m1678d() != i) {
                        i3++;
                    } else {
                        bgVar.m1670a(32);
                        return bgVar;
                    }
                }
                if (this.f604c.mAdapter.m1536b()) {
                    int a = this.f604c.mAdapterHelper.m1436a(i);
                    if (a > 0 && a < this.f604c.mAdapter.mo4327a()) {
                        long b = this.f604c.mAdapter.m1530b(a);
                        while (i2 < size) {
                            bgVar = (bg) this.f605d.get(i2);
                            if (bgVar.m1683i() || bgVar.m1679e() != b) {
                                i2++;
                            } else {
                                bgVar.m1670a(32);
                                return bgVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    bg m1594a(int i, int i2, boolean z) {
        View a;
        int i3 = 0;
        int size = this.f602a.size();
        int i4 = 0;
        while (i4 < size) {
            bg bgVar = (bg) this.f602a.get(i4);
            if (bgVar.m1683i() || bgVar.m1678d() != i || bgVar.m1687m() || (!this.f604c.mState.f626j && bgVar.m1691q())) {
                i4++;
            } else if (i2 == -1 || bgVar.m1680f() == i2) {
                bgVar.m1670a(32);
                return bgVar;
            } else {
                Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + bgVar.m1680f() + " but expected " + i2 + ")");
                if (!z) {
                    a = this.f604c.mChildHelper.m1731a(i, i2);
                    if (a != null) {
                        this.f604c.mItemAnimator.mo460c(this.f604c.getChildViewHolder(a));
                    }
                }
                i4 = this.f603b.size();
                while (i3 < i4) {
                    bgVar = (bg) this.f603b.get(i3);
                    if (bgVar.m1687m() || bgVar.m1678d() != i) {
                        i3++;
                    } else if (z) {
                        return bgVar;
                    } else {
                        this.f603b.remove(i3);
                        return bgVar;
                    }
                }
                return null;
            }
        }
        if (z) {
            a = this.f604c.mChildHelper.m1731a(i, i2);
            if (a != null) {
                this.f604c.mItemAnimator.mo460c(this.f604c.getChildViewHolder(a));
            }
        }
        i4 = this.f603b.size();
        while (i3 < i4) {
            bgVar = (bg) this.f603b.get(i3);
            if (bgVar.m1687m()) {
            }
            i3++;
        }
        return null;
    }

    bg m1595a(long j, int i, boolean z) {
        int size;
        for (size = this.f602a.size() - 1; size >= 0; size--) {
            bg bgVar = (bg) this.f602a.get(size);
            if (bgVar.m1679e() == j && !bgVar.m1683i()) {
                if (i == bgVar.m1680f()) {
                    bgVar.m1670a(32);
                    if (!bgVar.m1691q() || this.f604c.mState.m1648a()) {
                        return bgVar;
                    }
                    bgVar.m1671a(2, 14);
                    return bgVar;
                } else if (!z) {
                    this.f602a.remove(size);
                    this.f604c.removeDetachedView(bgVar.f636a, false);
                    m1610b(bgVar.f636a);
                }
            }
        }
        for (size = this.f603b.size() - 1; size >= 0; size--) {
            bgVar = (bg) this.f603b.get(size);
            if (bgVar.m1679e() == j) {
                if (i == bgVar.m1680f()) {
                    if (z) {
                        return bgVar;
                    }
                    this.f603b.remove(size);
                    return bgVar;
                } else if (!z) {
                    m1618d(size);
                }
            }
        }
        return null;
    }

    void m1617d(bg bgVar) {
        if (this.f604c.mRecyclerListener != null) {
            this.f604c.mRecyclerListener.m1626a(bgVar);
        }
        if (this.f604c.mAdapter != null) {
            this.f604c.mAdapter.m1528a(bgVar);
        }
        if (this.f604c.mState != null) {
            this.f604c.mState.m1647a(bgVar);
        }
    }

    void m1600a(ak akVar, ak akVar2, boolean z) {
        m1597a();
        m1621f().m1587a(akVar, akVar2, z);
    }

    void m1599a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.f603b.size();
        for (int i6 = 0; i6 < size; i6++) {
            bg bgVar = (bg) this.f603b.get(i6);
            if (bgVar != null && bgVar.f637b >= r3 && bgVar.f637b <= r2) {
                if (bgVar.f637b == i) {
                    bgVar.m1673a(i2 - i, false);
                } else {
                    bgVar.m1673a(i3, false);
                }
            }
        }
    }

    void m1607b(int i, int i2) {
        int size = this.f603b.size();
        for (int i3 = 0; i3 < size; i3++) {
            bg bgVar = (bg) this.f603b.get(i3);
            if (bgVar != null && bgVar.m1678d() >= i) {
                bgVar.m1673a(i2, true);
            }
        }
    }

    void m1608b(int i, int i2, boolean z) {
        int i3 = i + i2;
        int size = this.f603b.size() - 1;
        while (size >= 0) {
            bg bgVar = (bg) this.f603b.get(size);
            if (bgVar != null) {
                if (bgVar.m1678d() >= i3) {
                    bgVar.m1673a(-i2, z);
                } else if (bgVar.m1678d() >= i && !m1618d(size)) {
                    bgVar.m1670a(4);
                }
            }
            size--;
        }
    }

    void m1602a(be beVar) {
        this.f609h = beVar;
    }

    void m1601a(aw awVar) {
        if (this.f608g != null) {
            this.f608g.m1589b();
        }
        this.f608g = awVar;
        if (awVar != null) {
            this.f608g.m1586a(this.f604c.getAdapter());
        }
    }

    aw m1621f() {
        if (this.f608g == null) {
            this.f608g = new aw();
        }
        return this.f608g;
    }

    void m1613c(int i, int i2) {
        int i3 = i + i2;
        int size = this.f603b.size();
        for (int i4 = 0; i4 < size; i4++) {
            bg bgVar = (bg) this.f603b.get(i4);
            if (bgVar != null) {
                int d = bgVar.m1678d();
                if (d >= i && d < i3) {
                    bgVar.m1670a(2);
                }
            }
        }
    }

    void m1623g() {
        int size;
        if (this.f604c.mAdapter == null || !this.f604c.mAdapter.m1536b()) {
            for (size = this.f603b.size() - 1; size >= 0; size--) {
                if (!m1618d(size)) {
                    ((bg) this.f603b.get(size)).m1670a(6);
                }
            }
            return;
        }
        int size2 = this.f603b.size();
        for (size = 0; size < size2; size++) {
            bg bgVar = (bg) this.f603b.get(size);
            if (bgVar != null) {
                bgVar.m1670a(6);
            }
        }
    }

    void m1624h() {
        int i;
        int i2 = 0;
        int size = this.f603b.size();
        for (i = 0; i < size; i++) {
            ((bg) this.f603b.get(i)).m1669a();
        }
        size = this.f602a.size();
        for (i = 0; i < size; i++) {
            ((bg) this.f602a.get(i)).m1669a();
        }
        if (this.f605d != null) {
            i = this.f605d.size();
            while (i2 < i) {
                ((bg) this.f605d.get(i2)).m1669a();
                i2++;
            }
        }
    }

    void m1625i() {
        int size = this.f603b.size();
        for (int i = 0; i < size; i++) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((bg) this.f603b.get(i)).f636a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }
}
