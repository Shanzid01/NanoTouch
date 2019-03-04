package com.mopub.common;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DiskLruCache */
class C1501i extends FilterOutputStream {
    final /* synthetic */ C1500h f2176a;

    private C1501i(C1500h c1500h, OutputStream outputStream) {
        this.f2176a = c1500h;
        super(outputStream);
    }

    public void write(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            this.f2176a.f2174d = true;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.f2176a.f2174d = true;
        }
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            this.f2176a.f2174d = true;
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.f2176a.f2174d = true;
        }
    }
}
