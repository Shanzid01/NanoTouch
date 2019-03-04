package com.google.p043a.p045b;

import java.io.Writer;

/* compiled from: Streams */
final class ai extends Writer {
    private final Appendable f1833a;
    private final aj f1834b;

    private ai(Appendable appendable) {
        this.f1834b = new aj();
        this.f1833a = appendable;
    }

    public void write(char[] cArr, int i, int i2) {
        this.f1834b.f1835a = cArr;
        this.f1833a.append(this.f1834b, i, i + i2);
    }

    public void write(int i) {
        this.f1833a.append((char) i);
    }

    public void flush() {
    }

    public void close() {
    }
}
