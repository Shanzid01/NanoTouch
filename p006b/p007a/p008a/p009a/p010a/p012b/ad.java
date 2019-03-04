package p006b.p007a.p008a.p009a.p010a.p012b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
public class ad implements Closeable {
    private static final Logger f753b = Logger.getLogger(ad.class.getName());
    int f754a;
    private final RandomAccessFile f755c;
    private int f756d;
    private af f757e;
    private af f758f;
    private final byte[] f759g = new byte[16];

    public ad(File file) {
        if (!file.exists()) {
            ad.m1839a(file);
        }
        this.f755c = ad.m1842b(file);
        m1848e();
    }

    private static void m1845b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m1840a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            ad.m1845b(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m1832a(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void m1848e() {
        this.f755c.seek(0);
        this.f755c.readFully(this.f759g);
        this.f754a = ad.m1832a(this.f759g, 0);
        if (((long) this.f754a) > this.f755c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f754a + ", Actual length: " + this.f755c.length());
        }
        this.f756d = ad.m1832a(this.f759g, 4);
        int a = ad.m1832a(this.f759g, 8);
        int a2 = ad.m1832a(this.f759g, 12);
        this.f757e = m1833a(a);
        this.f758f = m1833a(a2);
    }

    private void m1836a(int i, int i2, int i3, int i4) {
        ad.m1840a(this.f759g, i, i2, i3, i4);
        this.f755c.seek(0);
        this.f755c.write(this.f759g);
    }

    private af m1833a(int i) {
        if (i == 0) {
            return af.f763a;
        }
        this.f755c.seek((long) i);
        return new af(i, this.f755c.readInt());
    }

    private static void m1839a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = ad.m1842b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            ad.m1840a(bArr, 4096, 0, 0, 0);
            b.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    private static RandomAccessFile m1842b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private int m1841b(int i) {
        return i < this.f754a ? i : (i + 16) - this.f754a;
    }

    private void m1837a(int i, byte[] bArr, int i2, int i3) {
        int b = m1841b(i);
        if (b + i3 <= this.f754a) {
            this.f755c.seek((long) b);
            this.f755c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f754a - b;
        this.f755c.seek((long) b);
        this.f755c.write(bArr, i2, i4);
        this.f755c.seek(16);
        this.f755c.write(bArr, i2 + i4, i3 - i4);
    }

    private void m1844b(int i, byte[] bArr, int i2, int i3) {
        int b = m1841b(i);
        if (b + i3 <= this.f754a) {
            this.f755c.seek((long) b);
            this.f755c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f754a - b;
        this.f755c.seek((long) b);
        this.f755c.readFully(bArr, i2, i4);
        this.f755c.seek(16);
        this.f755c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void m1852a(byte[] bArr) {
        m1853a(bArr, 0, bArr.length);
    }

    public synchronized void m1853a(byte[] bArr, int i, int i2) {
        ad.m1843b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m1846c(i2);
        boolean b = m1855b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m1841b((this.f758f.f764b + 4) + this.f758f.f765c);
        }
        af afVar = new af(i3, i2);
        ad.m1845b(this.f759g, 0, i2);
        m1837a(afVar.f764b, this.f759g, 0, 4);
        m1837a(afVar.f764b + 4, bArr, i, i2);
        m1836a(this.f754a, this.f756d + 1, b ? afVar.f764b : this.f757e.f764b, afVar.f764b);
        this.f758f = afVar;
        this.f756d++;
        if (b) {
            this.f757e = this.f758f;
        }
    }

    public int m1850a() {
        if (this.f756d == 0) {
            return 16;
        }
        if (this.f758f.f764b >= this.f757e.f764b) {
            return (((this.f758f.f764b - this.f757e.f764b) + 4) + this.f758f.f765c) + 16;
        }
        return (((this.f758f.f764b + 4) + this.f758f.f765c) + this.f754a) - this.f757e.f764b;
    }

    private int m1849f() {
        return this.f754a - m1850a();
    }

    public synchronized boolean m1855b() {
        return this.f756d == 0;
    }

    private void m1846c(int i) {
        int i2 = i + 4;
        int f = m1849f();
        if (f < i2) {
            int i3 = this.f754a;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            m1847d(i3);
            i2 = m1841b((this.f758f.f764b + 4) + this.f758f.f765c);
            if (i2 < this.f757e.f764b) {
                FileChannel channel = this.f755c.getChannel();
                channel.position((long) this.f754a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f758f.f764b < this.f757e.f764b) {
                f = (this.f754a + this.f758f.f764b) - 16;
                m1836a(i3, this.f756d, this.f757e.f764b, f);
                this.f758f = new af(f, this.f758f.f765c);
            } else {
                m1836a(i3, this.f756d, this.f757e.f764b, this.f758f.f764b);
            }
            this.f754a = i3;
        }
    }

    private void m1847d(int i) {
        this.f755c.setLength((long) i);
        this.f755c.getChannel().force(true);
    }

    public synchronized void m1851a(ah ahVar) {
        int i = this.f757e.f764b;
        for (int i2 = 0; i2 < this.f756d; i2++) {
            af a = m1833a(i);
            ahVar.mo465a(new ag(this, a, null), a.f765c);
            i = m1841b(a.f765c + (a.f764b + 4));
        }
    }

    private static <T> T m1843b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void m1856c() {
        if (m1855b()) {
            throw new NoSuchElementException();
        } else if (this.f756d == 1) {
            m1857d();
        } else {
            int b = m1841b((this.f757e.f764b + 4) + this.f757e.f765c);
            m1844b(b, this.f759g, 0, 4);
            int a = ad.m1832a(this.f759g, 0);
            m1836a(this.f754a, this.f756d - 1, b, this.f758f.f764b);
            this.f756d--;
            this.f757e = new af(b, a);
        }
    }

    public synchronized void m1857d() {
        m1836a(4096, 0, 0, 0);
        this.f756d = 0;
        this.f757e = af.f763a;
        this.f758f = af.f763a;
        if (this.f754a > 4096) {
            m1847d(4096);
        }
        this.f754a = 4096;
    }

    public synchronized void close() {
        this.f755c.close();
    }

    public boolean m1854a(int i, int i2) {
        return (m1850a() + 4) + i <= i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.f754a);
        stringBuilder.append(", size=").append(this.f756d);
        stringBuilder.append(", first=").append(this.f757e);
        stringBuilder.append(", last=").append(this.f758f);
        stringBuilder.append(", element lengths=[");
        try {
            m1851a(new ae(this, stringBuilder));
        } catch (Throwable e) {
            f753b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
