package android.support.v7.widget;

import android.support.v4.view.ay;
import android.support.v4.view.cr;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class C0178g extends an {
    private ArrayList<bg> f670a = new ArrayList();
    private ArrayList<bg> f671b = new ArrayList();
    private ArrayList<C0189q> f672c = new ArrayList();
    private ArrayList<C0188p> f673d = new ArrayList();
    private ArrayList<ArrayList<bg>> f674e = new ArrayList();
    private ArrayList<ArrayList<C0189q>> f675f = new ArrayList();
    private ArrayList<ArrayList<C0188p>> f676g = new ArrayList();
    private ArrayList<bg> f677h = new ArrayList();
    private ArrayList<bg> f678i = new ArrayList();
    private ArrayList<bg> f679j = new ArrayList();
    private ArrayList<bg> f680k = new ArrayList();

    public void mo453a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.f670a.isEmpty() ? 1 : 0;
        if (this.f672c.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f673d.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f671b.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable c0179h;
            Iterator it = this.f670a.iterator();
            while (it.hasNext()) {
                m1772p((bg) it.next());
            }
            this.f670a.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f672c);
                this.f675f.add(arrayList);
                this.f672c.clear();
                c0179h = new C0179h(this, arrayList);
                if (i4 != 0) {
                    ay.m572a(((C0189q) arrayList.get(0)).f711a.f636a, c0179h, m1558f());
                } else {
                    c0179h.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f673d);
                this.f676g.add(arrayList);
                this.f673d.clear();
                c0179h = new C0180i(this, arrayList);
                if (i4 != 0) {
                    ay.m572a(((C0188p) arrayList.get(0)).f705a.f636a, c0179h, m1558f());
                } else {
                    c0179h.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f671b);
                this.f674e.add(arrayList2);
                this.f671b.clear();
                Runnable c0181j = new C0181j(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    c0181j.run();
                    return;
                }
                long d;
                long g;
                long f = i4 != 0 ? m1558f() : 0;
                if (i != 0) {
                    d = m1553d();
                } else {
                    d = 0;
                }
                if (i2 != 0) {
                    g = m1560g();
                } else {
                    g = 0;
                }
                ay.m572a(((bg) arrayList2.get(0)).f636a, c0181j, f + Math.max(d, g));
            }
        }
    }

    public boolean mo454a(bg bgVar) {
        mo460c(bgVar);
        this.f670a.add(bgVar);
        return true;
    }

    private void m1772p(bg bgVar) {
        cr q = ay.m597q(bgVar.f636a);
        q.m814a(m1558f()).m813a(0.0f).m815a(new C0183k(this, bgVar, q)).m818b();
        this.f679j.add(bgVar);
    }

    public boolean mo458b(bg bgVar) {
        mo460c(bgVar);
        ay.m578c(bgVar.f636a, 0.0f);
        this.f671b.add(bgVar);
        return true;
    }

    private void m1773q(bg bgVar) {
        View view = bgVar.f636a;
        this.f677h.add(bgVar);
        cr q = ay.m597q(view);
        q.m813a((float) TextTrackStyle.DEFAULT_FONT_SCALE).m814a(m1556e()).m815a(new C0184l(this, bgVar, q)).m818b();
    }

    public boolean mo455a(bg bgVar, int i, int i2, int i3, int i4) {
        View view = bgVar.f636a;
        int m = (int) (((float) i) + ay.m593m(bgVar.f636a));
        int n = (int) (((float) i2) + ay.m594n(bgVar.f636a));
        mo460c(bgVar);
        int i5 = i3 - m;
        int i6 = i4 - n;
        if (i5 == 0 && i6 == 0) {
            m1557e(bgVar);
            return false;
        }
        if (i5 != 0) {
            ay.m566a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ay.m575b(view, (float) (-i6));
        }
        this.f672c.add(new C0189q(bgVar, m, n, i3, i4));
        return true;
    }

    private void m1763b(bg bgVar, int i, int i2, int i3, int i4) {
        View view = bgVar.f636a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            ay.m597q(view).m817b(0.0f);
        }
        if (i6 != 0) {
            ay.m597q(view).m819c(0.0f);
        }
        this.f678i.add(bgVar);
        cr q = ay.m597q(view);
        q.m814a(m1553d()).m815a(new C0185m(this, bgVar, i5, i6, q)).m818b();
    }

    public boolean mo456a(bg bgVar, bg bgVar2, int i, int i2, int i3, int i4) {
        float m = ay.m593m(bgVar.f636a);
        float n = ay.m594n(bgVar.f636a);
        float f = ay.m585f(bgVar.f636a);
        mo460c(bgVar);
        int i5 = (int) (((float) (i3 - i)) - m);
        int i6 = (int) (((float) (i4 - i2)) - n);
        ay.m566a(bgVar.f636a, m);
        ay.m575b(bgVar.f636a, n);
        ay.m578c(bgVar.f636a, f);
        if (!(bgVar2 == null || bgVar2.f636a == null)) {
            mo460c(bgVar2);
            ay.m566a(bgVar2.f636a, (float) (-i5));
            ay.m575b(bgVar2.f636a, (float) (-i6));
            ay.m578c(bgVar2.f636a, 0.0f);
        }
        this.f673d.add(new C0188p(bgVar, bgVar2, i, i2, i3, i4));
        return true;
    }

    private void m1759a(C0188p c0188p) {
        View view = null;
        bg bgVar = c0188p.f705a;
        View view2 = bgVar == null ? null : bgVar.f636a;
        bg bgVar2 = c0188p.f706b;
        if (bgVar2 != null) {
            view = bgVar2.f636a;
        }
        if (view2 != null) {
            this.f680k.add(c0188p.f705a);
            cr a = ay.m597q(view2).m814a(m1560g());
            a.m817b((float) (c0188p.f709e - c0188p.f707c));
            a.m819c((float) (c0188p.f710f - c0188p.f708d));
            a.m813a(0.0f).m815a(new C0186n(this, c0188p, a)).m818b();
        }
        if (view != null) {
            this.f680k.add(c0188p.f706b);
            a = ay.m597q(view);
            a.m817b(0.0f).m819c(0.0f).m814a(m1560g()).m813a((float) TextTrackStyle.DEFAULT_FONT_SCALE).m815a(new C0187o(this, c0188p, a, view)).m818b();
        }
    }

    private void m1760a(List<C0188p> list, bg bgVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0188p c0188p = (C0188p) list.get(size);
            if (m1761a(c0188p, bgVar) && c0188p.f705a == null && c0188p.f706b == null) {
                list.remove(c0188p);
            }
        }
    }

    private void m1764b(C0188p c0188p) {
        if (c0188p.f705a != null) {
            m1761a(c0188p, c0188p.f705a);
        }
        if (c0188p.f706b != null) {
            m1761a(c0188p, c0188p.f706b);
        }
    }

    private boolean m1761a(C0188p c0188p, bg bgVar) {
        boolean z = false;
        if (c0188p.f706b == bgVar) {
            c0188p.f706b = null;
        } else if (c0188p.f705a != bgVar) {
            return false;
        } else {
            c0188p.f705a = null;
            z = true;
        }
        ay.m578c(bgVar.f636a, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
        ay.m566a(bgVar.f636a, 0.0f);
        ay.m575b(bgVar.f636a, 0.0f);
        m1543a(bgVar, z);
        return true;
    }

    public void mo460c(bg bgVar) {
        int size;
        View view = bgVar.f636a;
        ay.m597q(view).m816a();
        for (size = this.f672c.size() - 1; size >= 0; size--) {
            if (((C0189q) this.f672c.get(size)).f711a == bgVar) {
                ay.m575b(view, 0.0f);
                ay.m566a(view, 0.0f);
                m1557e(bgVar);
                this.f672c.remove(size);
            }
        }
        m1760a(this.f673d, bgVar);
        if (this.f670a.remove(bgVar)) {
            ay.m578c(view, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
            m1554d(bgVar);
        }
        if (this.f671b.remove(bgVar)) {
            ay.m578c(view, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
            m1559f(bgVar);
        }
        for (size = this.f676g.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f676g.get(size);
            m1760a(list, bgVar);
            if (list.isEmpty()) {
                this.f676g.remove(size);
            }
        }
        for (int size2 = this.f675f.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f675f.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0189q) arrayList.get(size3)).f711a == bgVar) {
                    ay.m575b(view, 0.0f);
                    ay.m566a(view, 0.0f);
                    m1557e(bgVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f675f.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f674e.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f674e.get(size);
            if (arrayList.remove(bgVar)) {
                ay.m578c(view, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
                m1559f(bgVar);
                if (arrayList.isEmpty()) {
                    this.f674e.remove(size);
                }
            }
        }
        if (this.f679j.remove(bgVar)) {
        }
        if (this.f677h.remove(bgVar)) {
        }
        if (this.f680k.remove(bgVar)) {
        }
        if (this.f678i.remove(bgVar)) {
            m1771j();
        } else {
            m1771j();
        }
    }

    public boolean mo457b() {
        return (this.f671b.isEmpty() && this.f673d.isEmpty() && this.f672c.isEmpty() && this.f670a.isEmpty() && this.f678i.isEmpty() && this.f679j.isEmpty() && this.f677h.isEmpty() && this.f680k.isEmpty() && this.f675f.isEmpty() && this.f674e.isEmpty() && this.f676g.isEmpty()) ? false : true;
    }

    private void m1771j() {
        if (!mo457b()) {
            m1564i();
        }
    }

    public void mo459c() {
        int size;
        for (size = this.f672c.size() - 1; size >= 0; size--) {
            C0189q c0189q = (C0189q) this.f672c.get(size);
            View view = c0189q.f711a.f636a;
            ay.m575b(view, 0.0f);
            ay.m566a(view, 0.0f);
            m1557e(c0189q.f711a);
            this.f672c.remove(size);
        }
        for (size = this.f670a.size() - 1; size >= 0; size--) {
            m1554d((bg) this.f670a.get(size));
            this.f670a.remove(size);
        }
        for (size = this.f671b.size() - 1; size >= 0; size--) {
            bg bgVar = (bg) this.f671b.get(size);
            ay.m578c(bgVar.f636a, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
            m1559f(bgVar);
            this.f671b.remove(size);
        }
        for (size = this.f673d.size() - 1; size >= 0; size--) {
            m1764b((C0188p) this.f673d.get(size));
        }
        this.f673d.clear();
        if (mo457b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f675f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f675f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0189q c0189q2 = (C0189q) arrayList.get(size3);
                    View view2 = c0189q2.f711a.f636a;
                    ay.m575b(view2, 0.0f);
                    ay.m566a(view2, 0.0f);
                    m1557e(c0189q2.f711a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f675f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f674e.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f674e.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    bg bgVar2 = (bg) arrayList.get(size3);
                    ay.m578c(bgVar2.f636a, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
                    m1559f(bgVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f674e.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f676g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f676g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m1764b((C0188p) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f676g.remove(arrayList);
                    }
                }
            }
            m1775a(this.f679j);
            m1775a(this.f678i);
            m1775a(this.f677h);
            m1775a(this.f680k);
            m1564i();
        }
    }

    void m1775a(List<bg> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ay.m597q(((bg) list.get(size)).f636a).m816a();
        }
    }
}
