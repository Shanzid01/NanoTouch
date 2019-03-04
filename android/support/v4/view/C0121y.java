package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: KeyEventCompat */
class C0121y implements ab {
    C0121y() {
    }

    private static int m503a(int i, int i2, int i3, int i4, int i5) {
        Object obj = 1;
        Object obj2 = (i2 & i3) != 0 ? 1 : null;
        int i6 = i4 | i5;
        if ((i2 & i6) == 0) {
            obj = null;
        }
        if (obj2 != null) {
            if (obj == null) {
                return i & (i6 ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        } else if (obj != null) {
            return i & (i3 ^ -1);
        } else {
            return i;
        }
    }

    public int mo234a(int i) {
        int i2;
        if ((i & 192) != 0) {
            i2 = i | 1;
        } else {
            i2 = i;
        }
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    public boolean mo232a(int i, int i2) {
        if (C0121y.m503a(C0121y.m503a(mo234a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
            return true;
        }
        return false;
    }

    public boolean mo233b(int i) {
        return (mo234a(i) & 247) == 0;
    }

    public void mo231a(KeyEvent keyEvent) {
    }
}
