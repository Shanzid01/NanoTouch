package com.mopub.common;

import com.mopub.common.p050b.C1490m;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* compiled from: DownloadResponse */
public class C1505m {
    private byte[] f2190a = new byte[0];
    private final int f2191b;
    private final long f2192c;
    private final Header[] f2193d;

    public C1505m(HttpResponse httpResponse) {
        Throwable th;
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        Closeable bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(httpResponse.getEntity().getContent());
            try {
                C1490m.m4086a(bufferedInputStream, byteArrayOutputStream);
                this.f2190a = byteArrayOutputStream.toByteArray();
                C1490m.m4085a(bufferedInputStream);
                C1490m.m4085a(byteArrayOutputStream);
                this.f2191b = httpResponse.getStatusLine().getStatusCode();
                this.f2192c = (long) this.f2190a.length;
                this.f2193d = httpResponse.getAllHeaders();
            } catch (Throwable th2) {
                th = th2;
                C1490m.m4085a(bufferedInputStream);
                C1490m.m4085a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            C1490m.m4085a(bufferedInputStream);
            C1490m.m4085a(byteArrayOutputStream);
            throw th;
        }
    }

    public byte[] m4131a() {
        return this.f2190a;
    }

    public int m4132b() {
        return this.f2191b;
    }
}
