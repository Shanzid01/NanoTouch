package android.support.v7.widget;

import android.support.v4.p004b.C0059a;
import android.util.SparseArray;

/* compiled from: RecyclerView */
public class bd {
    C0059a<bg, as> f617a = new C0059a();
    C0059a<bg, as> f618b = new C0059a();
    C0059a<Long, bg> f619c = new C0059a();
    int f620d = 0;
    private int f621e = -1;
    private SparseArray<Object> f622f;
    private int f623g = 0;
    private int f624h = 0;
    private boolean f625i = false;
    private boolean f626j = false;
    private boolean f627k = false;
    private boolean f628l = false;

    static /* synthetic */ int m1634a(bd bdVar, int i) {
        int i2 = bdVar.f624h + i;
        bdVar.f624h = i2;
        return i2;
    }

    public boolean m1648a() {
        return this.f626j;
    }

    public boolean m1650b() {
        return this.f628l;
    }

    public int m1651c() {
        return this.f621e;
    }

    public boolean m1652d() {
        return this.f621e != -1;
    }

    public boolean m1653e() {
        return this.f625i;
    }

    public int m1654f() {
        return this.f626j ? this.f623g - this.f624h : this.f620d;
    }

    public void m1647a(bg bgVar) {
        this.f617a.remove(bgVar);
        this.f618b.remove(bgVar);
        if (this.f619c != null) {
            m1635a(this.f619c, bgVar);
        }
    }

    public void m1649b(bg bgVar) {
        m1647a(bgVar);
    }

    private void m1635a(C0059a<Long, bg> c0059a, bg bgVar) {
        for (int size = c0059a.size() - 1; size >= 0; size--) {
            if (bgVar == c0059a.m60c(size)) {
                c0059a.m61d(size);
                return;
            }
        }
    }

    public String toString() {
        return "State{mTargetPosition=" + this.f621e + ", mPreLayoutHolderMap=" + this.f617a + ", mPostLayoutHolderMap=" + this.f618b + ", mData=" + this.f622f + ", mItemCount=" + this.f620d + ", mPreviousLayoutItemCount=" + this.f623g + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f624h + ", mStructureChanged=" + this.f625i + ", mInPreLayout=" + this.f626j + ", mRunSimpleAnimations=" + this.f627k + ", mRunPredictiveAnimations=" + this.f628l + '}';
    }
}
