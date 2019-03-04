package android.support.v4.p004b;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class C0064e extends Writer {
    private final String f64a;
    private StringBuilder f65b = new StringBuilder(128);

    public C0064e(String str) {
        this.f64a = str;
    }

    public void close() {
        m98a();
    }

    public void flush() {
        m98a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m98a();
            } else {
                this.f65b.append(c);
            }
        }
    }

    private void m98a() {
        if (this.f65b.length() > 0) {
            Log.d(this.f64a, this.f65b.toString());
            this.f65b.delete(0, this.f65b.length());
        }
    }
}
