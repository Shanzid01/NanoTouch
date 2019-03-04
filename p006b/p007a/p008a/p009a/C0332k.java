package p006b.p007a.p008a.p009a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: FabricKitsFinder */
class C0332k implements Callable<Map<String, C0339s>> {
    final String f1035a;

    public /* synthetic */ Object call() {
        return m2322a();
    }

    C0332k(String str) {
        this.f1035a = str;
    }

    public Map<String, C0339s> m2322a() {
        Map<String, C0339s> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile b = m2323b();
        Enumeration entries = b.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            int i2 = i + 1;
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                C0339s a = m2321a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.m2349a(), a);
                    C0326f.m2298h().mo514b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.m2349a(), a.m2350b()}));
                }
            }
            i = i2;
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException e) {
            }
        }
        C0326f.m2298h().mo514b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    private C0339s m2321a(ZipEntry zipEntry, ZipFile zipFile) {
        Closeable inputStream;
        Throwable e;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                C0339s c0339s = new C0339s(property, property2, property3);
                C0214m.m1912a(inputStream);
                return c0339s;
            } catch (IOException e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    C0214m.m1912a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    C0214m.m1912a(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            C0326f.m2298h().mo519e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            C0214m.m1912a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            C0214m.m1912a(inputStream);
            throw e;
        }
    }

    protected ZipFile m2323b() {
        return new ZipFile(this.f1035a);
    }
}
