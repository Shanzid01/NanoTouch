package p006b.p007a.p008a.p009a.p010a.p015d;

import android.content.Context;
import com.google.android.gms.location.places.Place;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.ad;

/* compiled from: QueueFileEventStorage */
public class C0270n implements C0267h {
    private final Context f872a;
    private final File f873b;
    private final String f874c;
    private final File f875d;
    private ad f876e = new ad(this.f875d);
    private File f877f;

    public C0270n(Context context, File file, String str, String str2) {
        this.f872a = context;
        this.f873b = file;
        this.f874c = str2;
        this.f875d = new File(this.f873b, str);
        m2093e();
    }

    private void m2093e() {
        this.f877f = new File(this.f873b, this.f874c);
        if (!this.f877f.exists()) {
            this.f877f.mkdirs();
        }
    }

    public void mo487a(byte[] bArr) {
        this.f876e.m1852a(bArr);
    }

    public int mo483a() {
        return this.f876e.m1850a();
    }

    public void mo485a(String str) {
        this.f876e.close();
        m2092a(this.f875d, new File(this.f877f, str));
        this.f876e = new ad(this.f875d);
    }

    private void m2092a(File file, File file2) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = mo492a(file2);
                C0214m.m1915a((InputStream) fileInputStream, (OutputStream) closeable, new byte[Place.TYPE_SUBLOCALITY_LEVEL_2]);
                C0214m.m1913a(fileInputStream, "Failed to close file input stream");
                C0214m.m1913a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                C0214m.m1913a(fileInputStream, "Failed to close file input stream");
                C0214m.m1913a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C0214m.m1913a(fileInputStream, "Failed to close file input stream");
            C0214m.m1913a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream mo492a(File file) {
        return new FileOutputStream(file);
    }

    public List<File> mo484a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f877f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void mo486a(List<File> list) {
        for (File file : list) {
            C0214m.m1910a(this.f872a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> mo490c() {
        return Arrays.asList(this.f877f.listFiles());
    }

    public void mo491d() {
        try {
            this.f876e.close();
        } catch (IOException e) {
        }
        this.f875d.delete();
    }

    public boolean mo489b() {
        return this.f876e.m1855b();
    }

    public boolean mo488a(int i, int i2) {
        return this.f876e.m1854a(i, i2);
    }
}
