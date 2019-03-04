package android.support.v7.widget;

import com.google.android.gms.analytics.ecommerce.ProductAction;

/* compiled from: AdapterHelper */
class C0175c {
    int f662a;
    int f663b;
    int f664c;

    C0175c(int i, int i2, int i3) {
        this.f662a = i;
        this.f663b = i2;
        this.f664c = i3;
    }

    String m1729a() {
        switch (this.f662a) {
            case 0:
                return ProductAction.ACTION_ADD;
            case 1:
                return "rm";
            case 2:
                return "up";
            case 3:
                return "mv";
            default:
                return "??";
        }
    }

    public String toString() {
        return "[" + m1729a() + ",s:" + this.f663b + "c:" + this.f664c + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0175c c0175c = (C0175c) obj;
        if (this.f662a != c0175c.f662a) {
            return false;
        }
        if (this.f662a == 3 && Math.abs(this.f664c - this.f663b) == 1 && this.f664c == c0175c.f663b && this.f663b == c0175c.f664c) {
            return true;
        }
        if (this.f664c != c0175c.f664c) {
            return false;
        }
        if (this.f663b != c0175c.f663b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f662a * 31) + this.f663b) * 31) + this.f664c;
    }
}
