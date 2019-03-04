package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.util.BitSet;

/* compiled from: TypeAdapters */
final class al extends com.google.p043a.al<BitSet> {
    al() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3346a(c0683a);
    }

    public BitSet m3346a(C0683a c0683a) {
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        BitSet bitSet = new BitSet();
        c0683a.mo1124a();
        C0734c f = c0683a.mo1130f();
        int i = 0;
        while (f != C0734c.END_ARRAY) {
            boolean z;
            switch (ba.f1697a[f.ordinal()]) {
                case 1:
                    if (c0683a.mo1137m() == 0) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 2:
                    z = c0683a.mo1133i();
                    break;
                case 3:
                    String h = c0683a.mo1132h();
                    try {
                        if (Integer.parseInt(h) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    } catch (NumberFormatException e) {
                        throw new ae("Error: Expecting: bitset number value (1, 0), Found: " + h);
                    }
                default:
                    throw new ae("Invalid bitset value type: " + f);
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            f = c0683a.mo1130f();
        }
        c0683a.mo1125b();
        return bitSet;
    }

    public void m3348a(C0686d c0686d, BitSet bitSet) {
        if (bitSet == null) {
            c0686d.mo1152f();
            return;
        }
        c0686d.mo1146b();
        for (int i = 0; i < bitSet.length(); i++) {
            int i2;
            if (bitSet.get(i)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c0686d.mo1141a((long) i2);
        }
        c0686d.mo1148c();
    }
}
