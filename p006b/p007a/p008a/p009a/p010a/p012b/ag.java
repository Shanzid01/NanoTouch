package p006b.p007a.p008a.p009a.p010a.p012b;

import java.io.InputStream;

/* compiled from: QueueFile */
final class ag extends InputStream {
    final /* synthetic */ ad f766a;
    private int f767b;
    private int f768c;

    private ag(ad adVar, af afVar) {
        this.f766a = adVar;
        this.f767b = adVar.m1841b(afVar.f764b + 4);
        this.f768c = afVar.f765c;
    }

    public int read(byte[] bArr, int i, int i2) {
        ad.m1843b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (this.f768c <= 0) {
            return -1;
        } else {
            if (i2 > this.f768c) {
                i2 = this.f768c;
            }
            this.f766a.m1844b(this.f767b, bArr, i, i2);
            this.f767b = this.f766a.m1841b(this.f767b + i2);
            this.f768c -= i2;
            return i2;
        }
    }

    public int read() {
        if (this.f768c == 0) {
            return -1;
        }
        this.f766a.f755c.seek((long) this.f767b);
        int read = this.f766a.f755c.read();
        this.f767b = this.f766a.m1841b(this.f767b + 1);
        this.f768c--;
        return read;
    }
}
