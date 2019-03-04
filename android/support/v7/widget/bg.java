package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.Log;
import android.view.View;

/* compiled from: RecyclerView */
public abstract class bg {
    public final View f636a;
    int f637b = -1;
    int f638c = -1;
    long f639d = -1;
    int f640e = -1;
    int f641f = -1;
    bg f642g = null;
    bg f643h = null;
    private int f644i;
    private int f645j = 0;
    private ax f646k = null;

    public bg(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f636a = view;
    }

    void m1672a(int i, int i2, boolean z) {
        m1670a(8);
        m1673a(i2, z);
        this.f637b = i;
    }

    void m1673a(int i, boolean z) {
        if (this.f638c == -1) {
            this.f638c = this.f637b;
        }
        if (this.f641f == -1) {
            this.f641f = this.f637b;
        }
        if (z) {
            this.f641f += i;
        }
        this.f637b += i;
        if (this.f636a.getLayoutParams() != null) {
            ((LayoutParams) this.f636a.getLayoutParams()).mInsetsDirty = true;
        }
    }

    void m1669a() {
        this.f638c = -1;
        this.f641f = -1;
    }

    void m1676b() {
        if (this.f638c == -1) {
            this.f638c = this.f637b;
        }
    }

    boolean m1677c() {
        return (this.f644i & 128) != 0;
    }

    public final int m1678d() {
        return this.f641f == -1 ? this.f637b : this.f641f;
    }

    public final long m1679e() {
        return this.f639d;
    }

    public final int m1680f() {
        return this.f640e;
    }

    boolean m1681g() {
        return this.f646k != null;
    }

    void m1682h() {
        this.f646k.m1614c(this);
    }

    boolean m1683i() {
        return (this.f644i & 32) != 0;
    }

    void m1684j() {
        this.f644i &= -33;
    }

    void m1685k() {
        this.f644i &= -257;
    }

    void m1686l() {
        this.f644i &= -129;
    }

    void m1674a(ax axVar) {
        this.f646k = axVar;
    }

    boolean m1687m() {
        return (this.f644i & 4) != 0;
    }

    boolean m1688n() {
        return (this.f644i & 2) != 0;
    }

    boolean m1689o() {
        return (this.f644i & 64) != 0;
    }

    boolean m1690p() {
        return (this.f644i & 1) != 0;
    }

    boolean m1691q() {
        return (this.f644i & 8) != 0;
    }

    boolean m1692r() {
        return (this.f644i & 256) != 0;
    }

    void m1671a(int i, int i2) {
        this.f644i = (this.f644i & (i2 ^ -1)) | (i & i2);
    }

    void m1670a(int i) {
        this.f644i |= i;
    }

    void m1693s() {
        this.f644i = 0;
        this.f637b = -1;
        this.f638c = -1;
        this.f639d = -1;
        this.f641f = -1;
        this.f645j = 0;
        this.f642g = null;
        this.f643h = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f637b + " id=" + this.f639d + ", oldPos=" + this.f638c + ", pLpos:" + this.f641f);
        if (m1681g()) {
            stringBuilder.append(" scrap");
        }
        if (m1687m()) {
            stringBuilder.append(" invalid");
        }
        if (!m1690p()) {
            stringBuilder.append(" unbound");
        }
        if (m1688n()) {
            stringBuilder.append(" update");
        }
        if (m1691q()) {
            stringBuilder.append(" removed");
        }
        if (m1677c()) {
            stringBuilder.append(" ignored");
        }
        if (m1689o()) {
            stringBuilder.append(" changed");
        }
        if (m1692r()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!m1694t()) {
            stringBuilder.append(" not recyclable(" + this.f645j + ")");
        }
        if (this.f636a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m1675a(boolean z) {
        this.f645j = z ? this.f645j - 1 : this.f645j + 1;
        if (this.f645j < 0) {
            this.f645j = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.f645j == 1) {
            this.f644i |= 16;
        } else if (z && this.f645j == 0) {
            this.f644i &= -17;
        }
    }

    public final boolean m1694t() {
        return (this.f644i & 16) == 0 && !ay.m580c(this.f636a);
    }
}
