package com.google.p043a.p047d;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter */
public class C0686d implements Closeable, Flushable {
    private static final String[] f1727a = new String[128];
    private static final String[] f1728b = ((String[]) f1727a.clone());
    private final Writer f1729c;
    private int[] f1730d = new int[32];
    private int f1731e = 0;
    private String f1732f;
    private String f1733g;
    private boolean f1734h;
    private boolean f1735i;
    private String f1736j;
    private boolean f1737k;

    static {
        for (int i = 0; i <= 31; i++) {
            f1727a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f1727a[34] = "\\\"";
        f1727a[92] = "\\\\";
        f1727a[9] = "\\t";
        f1727a[8] = "\\b";
        f1727a[10] = "\\n";
        f1727a[13] = "\\r";
        f1727a[12] = "\\f";
        f1728b[60] = "\\u003c";
        f1728b[62] = "\\u003e";
        f1728b[38] = "\\u0026";
        f1728b[61] = "\\u003d";
        f1728b[39] = "\\u0027";
    }

    public C0686d(Writer writer) {
        m3490a(6);
        this.f1733g = ":";
        this.f1737k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f1729c = writer;
    }

    public final void m3505c(String str) {
        if (str.length() == 0) {
            this.f1732f = null;
            this.f1733g = ":";
            return;
        }
        this.f1732f = str;
        this.f1733g = ": ";
    }

    public final void m3503b(boolean z) {
        this.f1734h = z;
    }

    public boolean m3511g() {
        return this.f1734h;
    }

    public final void m3506c(boolean z) {
        this.f1735i = z;
    }

    public final boolean m3512h() {
        return this.f1735i;
    }

    public final void m3508d(boolean z) {
        this.f1737k = z;
    }

    public final boolean m3513i() {
        return this.f1737k;
    }

    public C0686d mo1146b() {
        m3494j();
        return m3489a(1, "[");
    }

    public C0686d mo1148c() {
        return m3488a(1, 2, "]");
    }

    public C0686d mo1150d() {
        m3494j();
        return m3489a(3, "{");
    }

    public C0686d mo1151e() {
        return m3488a(3, 5, "}");
    }

    private C0686d m3489a(int i, String str) {
        m3493e(true);
        m3490a(i);
        this.f1729c.write(str);
        return this;
    }

    private C0686d m3488a(int i, int i2, String str) {
        int a = mo1145a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f1736j != null) {
            throw new IllegalStateException("Dangling name: " + this.f1736j);
        } else {
            this.f1731e--;
            if (a == i2) {
                m3495k();
            }
            this.f1729c.write(str);
            return this;
        }
    }

    private void m3490a(int i) {
        if (this.f1731e == this.f1730d.length) {
            Object obj = new int[(this.f1731e * 2)];
            System.arraycopy(this.f1730d, 0, obj, 0, this.f1731e);
            this.f1730d = obj;
        }
        int[] iArr = this.f1730d;
        int i2 = this.f1731e;
        this.f1731e = i2 + 1;
        iArr[i2] = i;
    }

    private int mo1145a() {
        if (this.f1731e != 0) {
            return this.f1730d[this.f1731e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m3491b(int i) {
        this.f1730d[this.f1731e - 1] = i;
    }

    public C0686d mo1143a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f1736j != null) {
            throw new IllegalStateException();
        } else if (this.f1731e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f1736j = str;
            return this;
        }
    }

    private void m3494j() {
        if (this.f1736j != null) {
            m3496l();
            m3492d(this.f1736j);
            this.f1736j = null;
        }
    }

    public C0686d mo1147b(String str) {
        if (str == null) {
            return mo1152f();
        }
        m3494j();
        m3493e(false);
        m3492d(str);
        return this;
    }

    public C0686d mo1152f() {
        if (this.f1736j != null) {
            if (this.f1737k) {
                m3494j();
            } else {
                this.f1736j = null;
                return this;
            }
        }
        m3493e(false);
        this.f1729c.write("null");
        return this;
    }

    public C0686d mo1144a(boolean z) {
        m3494j();
        m3493e(false);
        this.f1729c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public C0686d mo1141a(long j) {
        m3494j();
        m3493e(false);
        this.f1729c.write(Long.toString(j));
        return this;
    }

    public C0686d mo1142a(Number number) {
        if (number == null) {
            return mo1152f();
        }
        m3494j();
        CharSequence obj = number.toString();
        if (this.f1734h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m3493e(false);
            this.f1729c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public void flush() {
        if (this.f1731e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1729c.flush();
    }

    public void close() {
        this.f1729c.close();
        int i = this.f1731e;
        if (i > 1 || (i == 1 && this.f1730d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f1731e = 0;
    }

    private void m3492d(String str) {
        int i = 0;
        String[] strArr = this.f1735i ? f1728b : f1727a;
        this.f1729c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.f1729c.write(str, i, i2 - i);
                }
                this.f1729c.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == ' ') {
                    str2 = "\\u2028";
                } else if (charAt == ' ') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f1729c.write(str, i, i2 - i);
                }
                this.f1729c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f1729c.write(str, i, length - i);
        }
        this.f1729c.write("\"");
    }

    private void m3495k() {
        if (this.f1732f != null) {
            this.f1729c.write("\n");
            int i = this.f1731e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f1729c.write(this.f1732f);
            }
        }
    }

    private void m3496l() {
        int a = mo1145a();
        if (a == 5) {
            this.f1729c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m3495k();
        m3491b(4);
    }

    private void m3493e(boolean z) {
        switch (mo1145a()) {
            case 1:
                m3491b(2);
                m3495k();
                return;
            case 2:
                this.f1729c.append(',');
                m3495k();
                return;
            case 4:
                this.f1729c.append(this.f1733g);
                m3491b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f1734h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f1734h || z) {
            m3491b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }
}
