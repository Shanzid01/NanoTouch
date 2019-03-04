package android.support.v7.widget;

import java.util.List;

/* compiled from: OpReorderer */
class aa {
    final ab f577a;

    public aa(ab abVar) {
        this.f577a = abVar;
    }

    void m1450a(List<C0175c> list) {
        while (true) {
            int b = m1448b(list);
            if (b != -1) {
                m1447a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    private void m1447a(List<C0175c> list, int i, int i2) {
        C0175c c0175c = (C0175c) list.get(i);
        C0175c c0175c2 = (C0175c) list.get(i2);
        switch (c0175c2.f662a) {
            case 0:
                m1449c(list, i, c0175c, i2, c0175c2);
                return;
            case 1:
                m1451a(list, i, c0175c, i2, c0175c2);
                return;
            case 2:
                m1452b(list, i, c0175c, i2, c0175c2);
                return;
            default:
                return;
        }
    }

    void m1451a(List<C0175c> list, int i, C0175c c0175c, int i2, C0175c c0175c2) {
        int i3;
        C0175c c0175c3;
        int i4 = 0;
        if (c0175c.f663b < c0175c.f664c) {
            i3 = (c0175c2.f663b == c0175c.f663b && c0175c2.f664c == c0175c.f664c - c0175c.f663b) ? 1 : 0;
        } else if (c0175c2.f663b == c0175c.f664c + 1 && c0175c2.f664c == c0175c.f663b - c0175c.f664c) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0175c.f664c < c0175c2.f663b) {
            c0175c2.f663b--;
        } else if (c0175c.f664c < c0175c2.f663b + c0175c2.f664c) {
            c0175c2.f664c--;
            c0175c.f662a = 1;
            c0175c.f664c = 1;
            if (c0175c2.f664c == 0) {
                list.remove(i2);
                this.f577a.mo415a(c0175c2);
                return;
            }
            return;
        }
        if (c0175c.f663b <= c0175c2.f663b) {
            c0175c2.f663b++;
            c0175c3 = null;
        } else if (c0175c.f663b < c0175c2.f663b + c0175c2.f664c) {
            c0175c3 = this.f577a.mo414a(1, c0175c.f663b + 1, (c0175c2.f663b + c0175c2.f664c) - c0175c.f663b);
            c0175c2.f664c = c0175c.f663b - c0175c2.f663b;
        } else {
            c0175c3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0175c2);
            list.remove(i2);
            this.f577a.mo415a(c0175c);
            return;
        }
        if (i4 != 0) {
            if (c0175c3 != null) {
                if (c0175c.f663b > c0175c3.f663b) {
                    c0175c.f663b -= c0175c3.f664c;
                }
                if (c0175c.f664c > c0175c3.f663b) {
                    c0175c.f664c -= c0175c3.f664c;
                }
            }
            if (c0175c.f663b > c0175c2.f663b) {
                c0175c.f663b -= c0175c2.f664c;
            }
            if (c0175c.f664c > c0175c2.f663b) {
                c0175c.f664c -= c0175c2.f664c;
            }
        } else {
            if (c0175c3 != null) {
                if (c0175c.f663b >= c0175c3.f663b) {
                    c0175c.f663b -= c0175c3.f664c;
                }
                if (c0175c.f664c >= c0175c3.f663b) {
                    c0175c.f664c -= c0175c3.f664c;
                }
            }
            if (c0175c.f663b >= c0175c2.f663b) {
                c0175c.f663b -= c0175c2.f664c;
            }
            if (c0175c.f664c >= c0175c2.f663b) {
                c0175c.f664c -= c0175c2.f664c;
            }
        }
        list.set(i, c0175c2);
        if (c0175c.f663b != c0175c.f664c) {
            list.set(i2, c0175c);
        } else {
            list.remove(i2);
        }
        if (c0175c3 != null) {
            list.add(i, c0175c3);
        }
    }

    private void m1449c(List<C0175c> list, int i, C0175c c0175c, int i2, C0175c c0175c2) {
        int i3 = 0;
        if (c0175c.f664c < c0175c2.f663b) {
            i3 = -1;
        }
        if (c0175c.f663b < c0175c2.f663b) {
            i3++;
        }
        if (c0175c2.f663b <= c0175c.f663b) {
            c0175c.f663b += c0175c2.f664c;
        }
        if (c0175c2.f663b <= c0175c.f664c) {
            c0175c.f664c += c0175c2.f664c;
        }
        c0175c2.f663b = i3 + c0175c2.f663b;
        list.set(i, c0175c2);
        list.set(i2, c0175c);
    }

    void m1452b(List<C0175c> list, int i, C0175c c0175c, int i2, C0175c c0175c2) {
        Object obj;
        Object obj2 = null;
        if (c0175c.f664c < c0175c2.f663b) {
            c0175c2.f663b--;
            obj = null;
        } else if (c0175c.f664c < c0175c2.f663b + c0175c2.f664c) {
            c0175c2.f664c--;
            obj = this.f577a.mo414a(2, c0175c.f663b, 1);
        } else {
            obj = null;
        }
        if (c0175c.f663b <= c0175c2.f663b) {
            c0175c2.f663b++;
        } else if (c0175c.f663b < c0175c2.f663b + c0175c2.f664c) {
            int i3 = (c0175c2.f663b + c0175c2.f664c) - c0175c.f663b;
            obj2 = this.f577a.mo414a(2, c0175c.f663b + 1, i3);
            c0175c2.f664c -= i3;
        }
        list.set(i2, c0175c);
        if (c0175c2.f664c > 0) {
            list.set(i, c0175c2);
        } else {
            list.remove(i);
            this.f577a.mo415a(c0175c2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    private int m1448b(List<C0175c> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0175c) list.get(size)).f662a != 3) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }
}
