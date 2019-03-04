package com.p026b.p027a.p041c;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IoUtils */
public final class C0523c {
    public static void m3149a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void m3148a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
        }
    }
}
