package android.support.v7.widget;

import android.support.v4.p004b.C0073o;
import android.support.v4.p004b.C0074p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper */
class C0171a implements ab {
    final ArrayList<C0175c> f570a;
    final ArrayList<C0175c> f571b;
    final C0173b f572c;
    Runnable f573d;
    final boolean f574e;
    final aa f575f;
    private C0073o<C0175c> f576g;

    C0171a(C0173b c0173b) {
        this(c0173b, false);
    }

    C0171a(C0173b c0173b, boolean z) {
        this.f576g = new C0074p(30);
        this.f570a = new ArrayList();
        this.f571b = new ArrayList();
        this.f572c = c0173b;
        this.f574e = z;
        this.f575f = new aa(this);
    }

    void m1439a() {
        m1442a(this.f570a);
        m1442a(this.f571b);
    }

    void m1443b() {
        this.f575f.m1450a(this.f570a);
        int size = this.f570a.size();
        for (int i = 0; i < size; i++) {
            C0175c c0175c = (C0175c) this.f570a.get(i);
            switch (c0175c.f662a) {
                case 0:
                    m1434f(c0175c);
                    break;
                case 1:
                    m1431c(c0175c);
                    break;
                case 2:
                    m1432d(c0175c);
                    break;
                case 3:
                    m1429b(c0175c);
                    break;
            }
            if (this.f573d != null) {
                this.f573d.run();
            }
        }
        this.f570a.clear();
    }

    void m1444c() {
        int size = this.f571b.size();
        for (int i = 0; i < size; i++) {
            this.f572c.mo439b((C0175c) this.f571b.get(i));
        }
        m1442a(this.f571b);
    }

    private void m1429b(C0175c c0175c) {
        m1435g(c0175c);
    }

    private void m1431c(C0175c c0175c) {
        int i = c0175c.f663b;
        int i2 = c0175c.f663b + c0175c.f664c;
        int i3 = -1;
        int i4 = c0175c.f663b;
        int i5 = 0;
        while (i4 < i2) {
            int i6;
            if (this.f572c.mo435a(i4) != null || m1430b(i4)) {
                if (i3 == 0) {
                    m1433e(mo414a(1, i, i5));
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                i3 = 1;
            } else {
                if (i3 == 1) {
                    m1435g(mo414a(1, i, i5));
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                i3 = 0;
            }
            if (i6 != 0) {
                i6 = i4 - i5;
                i4 = i2 - i5;
                i2 = 1;
            } else {
                int i7 = i4;
                i4 = i2;
                i2 = i5 + 1;
                i6 = i7;
            }
            i5 = i2;
            i2 = i4;
            i4 = i6 + 1;
        }
        if (i5 != c0175c.f664c) {
            mo415a(c0175c);
            c0175c = mo414a(1, i, i5);
        }
        if (i3 == 0) {
            m1433e(c0175c);
        } else {
            m1435g(c0175c);
        }
    }

    private void m1432d(C0175c c0175c) {
        int i = c0175c.f663b;
        int i2 = c0175c.f663b + c0175c.f664c;
        int i3 = c0175c.f663b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f572c.mo435a(i3) != null || m1430b(i3)) {
                if (obj == null) {
                    m1433e(mo414a(2, i, i4));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m1435g(mo414a(2, i, i4));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0175c.f664c) {
            mo415a(c0175c);
            c0175c = mo414a(2, i, i4);
        }
        if (obj == null) {
            m1433e(c0175c);
        } else {
            m1435g(c0175c);
        }
    }

    private void m1433e(C0175c c0175c) {
        if (c0175c.f662a == 0 || c0175c.f662a == 3) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = m1428b(c0175c.f663b, c0175c.f662a);
        int i2 = c0175c.f663b;
        switch (c0175c.f662a) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0175c);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < c0175c.f664c; i2++) {
            Object obj;
            int b2 = m1428b(c0175c.f663b + (i * i2), c0175c.f662a);
            int i5;
            switch (c0175c.f662a) {
                case 1:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 2:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C0175c a = mo414a(c0175c.f662a, i4, i3);
                m1441a(a, b);
                mo415a(a);
                if (c0175c.f662a == 2) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        mo415a(c0175c);
        if (i3 > 0) {
            C0175c a2 = mo414a(c0175c.f662a, i4, i3);
            m1441a(a2, b);
            mo415a(a2);
        }
    }

    void m1441a(C0175c c0175c, int i) {
        this.f572c.mo437a(c0175c);
        switch (c0175c.f662a) {
            case 1:
                this.f572c.mo436a(i, c0175c.f664c);
                return;
            case 2:
                this.f572c.mo440c(i, c0175c.f664c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m1428b(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f571b.size() - 1; size >= 0; size--) {
            C0175c c0175c = (C0175c) this.f571b.get(size);
            if (c0175c.f662a == 3) {
                int i5;
                int i6;
                if (c0175c.f663b < c0175c.f664c) {
                    i5 = c0175c.f663b;
                    i3 = c0175c.f664c;
                } else {
                    i5 = c0175c.f664c;
                    i3 = c0175c.f663b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0175c.f663b) {
                        if (i2 == 0) {
                            c0175c.f663b++;
                            c0175c.f664c++;
                            i6 = i4;
                        } else if (i2 == 1) {
                            c0175c.f663b--;
                            c0175c.f664c--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0175c.f663b) {
                    if (i2 == 0) {
                        c0175c.f664c++;
                    } else if (i2 == 1) {
                        c0175c.f664c--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 0) {
                        c0175c.f663b++;
                    } else if (i2 == 1) {
                        c0175c.f663b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0175c.f663b <= i4) {
                if (c0175c.f662a == 0) {
                    i4 -= c0175c.f664c;
                } else if (c0175c.f662a == 1) {
                    i4 += c0175c.f664c;
                }
            } else if (i2 == 0) {
                c0175c.f663b++;
            } else if (i2 == 1) {
                c0175c.f663b--;
            }
        }
        for (i3 = this.f571b.size() - 1; i3 >= 0; i3--) {
            c0175c = (C0175c) this.f571b.get(i3);
            if (c0175c.f662a == 3) {
                if (c0175c.f664c == c0175c.f663b || c0175c.f664c < 0) {
                    this.f571b.remove(i3);
                    mo415a(c0175c);
                }
            } else if (c0175c.f664c <= 0) {
                this.f571b.remove(i3);
                mo415a(c0175c);
            }
        }
        return i4;
    }

    private boolean m1430b(int i) {
        int size = this.f571b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0175c c0175c = (C0175c) this.f571b.get(i2);
            if (c0175c.f662a == 3) {
                if (m1437a(c0175c.f664c, i2 + 1) == i) {
                    return true;
                }
            } else if (c0175c.f662a == 0) {
                int i3 = c0175c.f663b + c0175c.f664c;
                for (int i4 = c0175c.f663b; i4 < i3; i4++) {
                    if (m1437a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m1434f(C0175c c0175c) {
        m1435g(c0175c);
    }

    private void m1435g(C0175c c0175c) {
        this.f571b.add(c0175c);
        switch (c0175c.f662a) {
            case 0:
                this.f572c.mo441d(c0175c.f663b, c0175c.f664c);
                return;
            case 1:
                this.f572c.mo438b(c0175c.f663b, c0175c.f664c);
                return;
            case 2:
                this.f572c.mo440c(c0175c.f663b, c0175c.f664c);
                return;
            case 3:
                this.f572c.mo442e(c0175c.f663b, c0175c.f664c);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0175c);
        }
    }

    boolean m1445d() {
        return this.f570a.size() > 0;
    }

    int m1436a(int i) {
        return m1437a(i, 0);
    }

    int m1437a(int i, int i2) {
        int size = this.f571b.size();
        int i3 = i;
        while (i2 < size) {
            C0175c c0175c = (C0175c) this.f571b.get(i2);
            if (c0175c.f662a == 3) {
                if (c0175c.f663b == i3) {
                    i3 = c0175c.f664c;
                } else {
                    if (c0175c.f663b < i3) {
                        i3--;
                    }
                    if (c0175c.f664c <= i3) {
                        i3++;
                    }
                }
            } else if (c0175c.f663b > i3) {
                continue;
            } else if (c0175c.f662a == 1) {
                if (i3 < c0175c.f663b + c0175c.f664c) {
                    return -1;
                }
                i3 -= c0175c.f664c;
            } else if (c0175c.f662a == 0) {
                i3 += c0175c.f664c;
            }
            i2++;
        }
        return i3;
    }

    void m1446e() {
        m1444c();
        int size = this.f570a.size();
        for (int i = 0; i < size; i++) {
            C0175c c0175c = (C0175c) this.f570a.get(i);
            switch (c0175c.f662a) {
                case 0:
                    this.f572c.mo439b(c0175c);
                    this.f572c.mo441d(c0175c.f663b, c0175c.f664c);
                    break;
                case 1:
                    this.f572c.mo439b(c0175c);
                    this.f572c.mo436a(c0175c.f663b, c0175c.f664c);
                    break;
                case 2:
                    this.f572c.mo439b(c0175c);
                    this.f572c.mo440c(c0175c.f663b, c0175c.f664c);
                    break;
                case 3:
                    this.f572c.mo439b(c0175c);
                    this.f572c.mo442e(c0175c.f663b, c0175c.f664c);
                    break;
            }
            if (this.f573d != null) {
                this.f573d.run();
            }
        }
        m1442a(this.f570a);
    }

    public C0175c mo414a(int i, int i2, int i3) {
        C0175c c0175c = (C0175c) this.f576g.mo165a();
        if (c0175c == null) {
            return new C0175c(i, i2, i3);
        }
        c0175c.f662a = i;
        c0175c.f663b = i2;
        c0175c.f664c = i3;
        return c0175c;
    }

    public void mo415a(C0175c c0175c) {
        if (!this.f574e) {
            this.f576g.mo166a(c0175c);
        }
    }

    void m1442a(List<C0175c> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo415a((C0175c) list.get(i));
        }
        list.clear();
    }
}
