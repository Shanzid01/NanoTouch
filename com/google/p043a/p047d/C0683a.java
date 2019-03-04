package com.google.p043a.p047d;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.places.Place;
import com.google.p043a.p045b.C0724u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader */
public class C0683a implements Closeable {
    private static final char[] f1708a = ")]}'\n".toCharArray();
    private final Reader f1709b;
    private boolean f1710c = false;
    private final char[] f1711d = new char[Place.TYPE_SUBLOCALITY_LEVEL_2];
    private int f1712e = 0;
    private int f1713f = 0;
    private int f1714g = 0;
    private int f1715h = 0;
    private int f1716i = 0;
    private long f1717j;
    private int f1718k;
    private String f1719l;
    private int[] f1720m = new int[32];
    private int f1721n = 0;
    private String[] f1722o;
    private int[] f1723p;

    static {
        C0724u.f1883a = new C0733b();
    }

    public C0683a(Reader reader) {
        int[] iArr = this.f1720m;
        int i = this.f1721n;
        this.f1721n = i + 1;
        iArr[i] = 6;
        this.f1722o = new String[32];
        this.f1723p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f1709b = reader;
    }

    public final void m3453a(boolean z) {
        this.f1710c = z;
    }

    public final boolean m3467p() {
        return this.f1710c;
    }

    public void mo1124a() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 3) {
            m3431a(1);
            this.f1723p[this.f1721n - 1] = 0;
            this.f1716i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    public void mo1125b() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 4) {
            this.f1721n--;
            int[] iArr = this.f1723p;
            int i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1716i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    public void mo1126c() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 1) {
            m3431a(3);
            this.f1716i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    public void mo1128d() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 2) {
            this.f1721n--;
            this.f1722o[this.f1721n] = null;
            int[] iArr = this.f1723p;
            int i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1716i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    public boolean mo1129e() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public C0734c mo1130f() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        switch (i) {
            case 1:
                return C0734c.BEGIN_OBJECT;
            case 2:
                return C0734c.END_OBJECT;
            case 3:
                return C0734c.BEGIN_ARRAY;
            case 4:
                return C0734c.END_ARRAY;
            case 5:
            case 6:
                return C0734c.BOOLEAN;
            case 7:
                return C0734c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return C0734c.STRING;
            case 12:
            case 13:
            case 14:
                return C0734c.NAME;
            case 15:
            case 16:
                return C0734c.NUMBER;
            case 17:
                return C0734c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int mo1139o() {
        int b;
        int i = this.f1720m[this.f1721n - 1];
        if (i == 1) {
            this.f1720m[this.f1721n - 1] = 2;
        } else if (i == 2) {
            switch (m3435b(true)) {
                case 44:
                    break;
                case 59:
                    m3449x();
                    break;
                case Place.TYPE_TRAVEL_AGENCY /*93*/:
                    this.f1716i = 4;
                    return 4;
                default:
                    throw m3436b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f1720m[this.f1721n - 1] = 4;
            if (i == 5) {
                switch (m3435b(true)) {
                    case 44:
                        break;
                    case 59:
                        m3449x();
                        break;
                    case 125:
                        this.f1716i = 2;
                        return 2;
                    default:
                        throw m3436b("Unterminated object");
                }
            }
            b = m3435b(true);
            switch (b) {
                case 34:
                    this.f1716i = 13;
                    return 13;
                case 39:
                    m3449x();
                    this.f1716i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f1716i = 2;
                        return 2;
                    }
                    throw m3436b("Expected name");
                default:
                    m3449x();
                    this.f1712e--;
                    if (m3432a((char) b)) {
                        this.f1716i = 14;
                        return 14;
                    }
                    throw m3436b("Expected name");
            }
        } else if (i == 4) {
            this.f1720m[this.f1721n - 1] = 5;
            switch (m3435b(true)) {
                case 58:
                    break;
                case 61:
                    m3449x();
                    if ((this.f1712e < this.f1713f || m3438b(1)) && this.f1711d[this.f1712e] == '>') {
                        this.f1712e++;
                        break;
                    }
                default:
                    throw m3436b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f1710c) {
                m3428A();
            }
            this.f1720m[this.f1721n - 1] = 7;
        } else if (i == 7) {
            if (m3435b(false) == -1) {
                this.f1716i = 17;
                return 17;
            }
            m3449x();
            this.f1712e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m3435b(true)) {
            case 34:
                if (this.f1721n == 1) {
                    m3449x();
                }
                this.f1716i = 9;
                return 9;
            case 39:
                m3449x();
                this.f1716i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case Place.TYPE_TAXI_STAND /*91*/:
                this.f1716i = 3;
                return 3;
            case Place.TYPE_TRAVEL_AGENCY /*93*/:
                if (i == 1) {
                    this.f1716i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f1716i = 1;
                return 1;
            default:
                this.f1712e--;
                if (this.f1721n == 1) {
                    m3449x();
                }
                b = m3443r();
                if (b != 0) {
                    return b;
                }
                b = m3444s();
                if (b != 0) {
                    return b;
                }
                if (m3432a(this.f1711d[this.f1712e])) {
                    m3449x();
                    this.f1716i = 10;
                    return 10;
                }
                throw m3436b("Expected value");
        }
        if (i == 1 || i == 2) {
            m3449x();
            this.f1712e--;
            this.f1716i = 7;
            return 7;
        }
        throw m3436b("Unexpected value");
    }

    private int m3443r() {
        String str;
        int i;
        char c = this.f1711d[this.f1712e];
        String str2;
        if (c == 't' || c == 'T') {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.f1712e + i2 >= this.f1713f && !m3438b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f1711d[this.f1712e + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.f1712e + length < this.f1713f || m3438b(length + 1)) && m3432a(this.f1711d[this.f1712e + length])) {
            return 0;
        }
        this.f1712e += length;
        this.f1716i = i;
        return i;
    }

    private int m3444s() {
        char[] cArr = this.f1711d;
        int i = this.f1712e;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1713f;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (m3438b(i4 + 1)) {
                    i6 = this.f1712e;
                    i5 = this.f1713f;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.f1717j = j;
                    this.f1712e += i4;
                    this.f1716i = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.f1718k = i4;
                    this.f1716i = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case '+':
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case '-':
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case Place.TYPE_PARK /*69*/:
                case Quests.SELECT_COMPLETED_UNCLAIMED /*101*/:
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (m3432a(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.f1718k = i4;
            this.f1716i = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private boolean m3432a(char c) {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case Place.TYPE_TAXI_STAND /*91*/:
            case Place.TYPE_TRAVEL_AGENCY /*93*/:
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case Place.TYPE_TRAIN_STATION /*92*/:
                m3449x();
                break;
            default:
                return true;
        }
        return false;
    }

    public String mo1131g() {
        String t;
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 14) {
            t = m3445t();
        } else if (i == 12) {
            t = m3437b('\'');
        } else if (i == 13) {
            t = m3437b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
        }
        this.f1716i = 0;
        this.f1722o[this.f1721n - 1] = t;
        return t;
    }

    public String mo1132h() {
        String t;
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 10) {
            t = m3445t();
        } else if (i == 8) {
            t = m3437b('\'');
        } else if (i == 9) {
            t = m3437b('\"');
        } else if (i == 11) {
            t = this.f1719l;
            this.f1719l = null;
        } else if (i == 15) {
            t = Long.toString(this.f1717j);
        } else if (i == 16) {
            t = new String(this.f1711d, this.f1712e, this.f1718k);
            this.f1712e += this.f1718k;
        } else {
            throw new IllegalStateException("Expected a string but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
        }
        this.f1716i = 0;
        int[] iArr = this.f1723p;
        int i2 = this.f1721n - 1;
        iArr[i2] = iArr[i2] + 1;
        return t;
    }

    public boolean mo1133i() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 5) {
            this.f1716i = 0;
            int[] iArr = this.f1723p;
            i = this.f1721n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.f1716i = 0;
            int[] iArr2 = this.f1723p;
            int i2 = this.f1721n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
        }
    }

    public void mo1134j() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 7) {
            this.f1716i = 0;
            int[] iArr = this.f1723p;
            int i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    public double mo1135k() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 15) {
            this.f1716i = 0;
            int[] iArr = this.f1723p;
            int i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f1717j;
        }
        if (i == 16) {
            this.f1719l = new String(this.f1711d, this.f1712e, this.f1718k);
            this.f1712e += this.f1718k;
        } else if (i == 8 || i == 9) {
            this.f1719l = m3437b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f1719l = m3445t();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
        }
        this.f1716i = 11;
        double parseDouble = Double.parseDouble(this.f1719l);
        if (this.f1710c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f1719l = null;
            this.f1716i = 0;
            int[] iArr2 = this.f1723p;
            int i3 = this.f1721n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new C0735e("JSON forbids NaN and infinities: " + parseDouble + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    public long mo1136l() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        if (i == 15) {
            this.f1716i = 0;
            int[] iArr = this.f1723p;
            int i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f1717j;
        }
        long parseLong;
        if (i == 16) {
            this.f1719l = new String(this.f1711d, this.f1712e, this.f1718k);
            this.f1712e += this.f1718k;
        } else if (i == 8 || i == 9) {
            this.f1719l = m3437b(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.f1719l);
                this.f1716i = 0;
                int[] iArr2 = this.f1723p;
                int i3 = this.f1721n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
        }
        this.f1716i = 11;
        double parseDouble = Double.parseDouble(this.f1719l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f1719l + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
        }
        this.f1719l = null;
        this.f1716i = 0;
        iArr2 = this.f1723p;
        i3 = this.f1721n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    private String m3437b(char c) {
        char[] cArr = this.f1711d;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.f1712e;
            int i2 = this.f1713f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f1712e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.f1712e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m3451z());
                    i = this.f1712e;
                    i2 = this.f1713f;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.f1714g++;
                    this.f1715h = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f1712e = i3;
        } while (m3438b(1));
        throw m3436b("Unterminated string");
    }

    private String m3445t() {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.f1712e + i < this.f1713f) {
                switch (this.f1711d[this.f1712e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case Place.TYPE_TAXI_STAND /*91*/:
                    case Place.TYPE_TRAVEL_AGENCY /*93*/:
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case Place.TYPE_TRAIN_STATION /*92*/:
                        m3449x();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f1711d.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f1711d, this.f1712e, i);
                this.f1712e = i + this.f1712e;
                if (m3438b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (m3438b(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.f1711d, this.f1712e, i);
            } else {
                stringBuilder.append(this.f1711d, this.f1712e, i);
                str = stringBuilder.toString();
            }
            this.f1712e = i + this.f1712e;
            return str;
        }
    }

    private void m3440c(char c) {
        char[] cArr = this.f1711d;
        do {
            int i = this.f1712e;
            int i2 = this.f1713f;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f1712e = i;
                    return;
                }
                if (c2 == '\\') {
                    this.f1712e = i;
                    m3451z();
                    i = this.f1712e;
                    i2 = this.f1713f;
                } else if (c2 == '\n') {
                    this.f1714g++;
                    this.f1715h = i;
                }
                i3 = i;
            }
            this.f1712e = i3;
        } while (m3438b(1));
        throw m3436b("Unterminated string");
    }

    private void m3446u() {
        do {
            int i = 0;
            while (this.f1712e + i < this.f1713f) {
                switch (this.f1711d[this.f1712e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case Place.TYPE_TAXI_STAND /*91*/:
                    case Place.TYPE_TRAVEL_AGENCY /*93*/:
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case Place.TYPE_TRAIN_STATION /*92*/:
                        m3449x();
                        break;
                    default:
                        i++;
                }
                this.f1712e = i + this.f1712e;
                return;
            }
            this.f1712e = i + this.f1712e;
        } while (m3438b(1));
    }

    public int mo1137m() {
        int i = this.f1716i;
        if (i == 0) {
            i = mo1139o();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.f1717j;
            if (this.f1717j != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.f1717j + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
            }
            this.f1716i = 0;
            iArr = this.f1723p;
            i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            if (i == 16) {
                this.f1719l = new String(this.f1711d, this.f1712e, this.f1718k);
                this.f1712e += this.f1718k;
            } else if (i == 8 || i == 9) {
                this.f1719l = m3437b(i == 8 ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.f1719l);
                    this.f1716i = 0;
                    iArr = this.f1723p;
                    i2 = this.f1721n - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                throw new IllegalStateException("Expected an int but was " + mo1130f() + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
            }
            this.f1716i = 11;
            double parseDouble = Double.parseDouble(this.f1719l);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.f1719l + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
            }
            this.f1719l = null;
            this.f1716i = 0;
            iArr = this.f1723p;
            i2 = this.f1721n - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public void close() {
        this.f1716i = 0;
        this.f1720m[0] = 8;
        this.f1721n = 1;
        this.f1709b.close();
    }

    public void mo1138n() {
        int i = 0;
        do {
            int i2 = this.f1716i;
            if (i2 == 0) {
                i2 = mo1139o();
            }
            if (i2 == 3) {
                m3431a(1);
                i++;
            } else if (i2 == 1) {
                m3431a(3);
                i++;
            } else if (i2 == 4) {
                this.f1721n--;
                i--;
            } else if (i2 == 2) {
                this.f1721n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m3446u();
            } else if (i2 == 8 || i2 == 12) {
                m3440c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m3440c('\"');
            } else if (i2 == 16) {
                this.f1712e += this.f1718k;
            }
            this.f1716i = 0;
        } while (i != 0);
        int[] iArr = this.f1723p;
        int i3 = this.f1721n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f1722o[this.f1721n - 1] = "null";
    }

    private void m3431a(int i) {
        if (this.f1721n == this.f1720m.length) {
            Object obj = new int[(this.f1721n * 2)];
            Object obj2 = new int[(this.f1721n * 2)];
            Object obj3 = new String[(this.f1721n * 2)];
            System.arraycopy(this.f1720m, 0, obj, 0, this.f1721n);
            System.arraycopy(this.f1723p, 0, obj2, 0, this.f1721n);
            System.arraycopy(this.f1722o, 0, obj3, 0, this.f1721n);
            this.f1720m = obj;
            this.f1723p = obj2;
            this.f1722o = obj3;
        }
        int[] iArr = this.f1720m;
        int i2 = this.f1721n;
        this.f1721n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m3438b(int i) {
        Object obj = this.f1711d;
        this.f1715h -= this.f1712e;
        if (this.f1713f != this.f1712e) {
            this.f1713f -= this.f1712e;
            System.arraycopy(obj, this.f1712e, obj, 0, this.f1713f);
        } else {
            this.f1713f = 0;
        }
        this.f1712e = 0;
        do {
            int read = this.f1709b.read(obj, this.f1713f, obj.length - this.f1713f);
            if (read == -1) {
                return false;
            }
            this.f1713f = read + this.f1713f;
            if (this.f1714g == 0 && this.f1715h == 0 && this.f1713f > 0 && obj[0] == '﻿') {
                this.f1712e++;
                this.f1715h++;
                i++;
            }
        } while (this.f1713f < i);
        return true;
    }

    private int m3447v() {
        return this.f1714g + 1;
    }

    private int m3448w() {
        return (this.f1712e - this.f1715h) + 1;
    }

    private int m3435b(boolean z) {
        char[] cArr = this.f1711d;
        int i = this.f1712e;
        int i2 = this.f1713f;
        while (true) {
            if (i == i2) {
                this.f1712e = i;
                if (m3438b(1)) {
                    i = this.f1712e;
                    i2 = this.f1713f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + m3447v() + " column " + m3448w());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f1714g++;
                this.f1715h = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.f1712e = i3;
                if (i3 == i2) {
                    this.f1712e--;
                    boolean b = m3438b(2);
                    this.f1712e++;
                    if (!b) {
                        return c;
                    }
                }
                m3449x();
                switch (cArr[this.f1712e]) {
                    case '*':
                        this.f1712e++;
                        if (m3433a("*/")) {
                            i = this.f1712e + 2;
                            i2 = this.f1713f;
                            break;
                        }
                        throw m3436b("Unterminated comment");
                    case '/':
                        this.f1712e++;
                        m3450y();
                        i = this.f1712e;
                        i2 = this.f1713f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f1712e = i3;
                m3449x();
                m3450y();
                i = this.f1712e;
                i2 = this.f1713f;
            } else {
                this.f1712e = i3;
                return c;
            }
        }
    }

    private void m3449x() {
        if (!this.f1710c) {
            throw m3436b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m3450y() {
        char c;
        do {
            if (this.f1712e < this.f1713f || m3438b(1)) {
                char[] cArr = this.f1711d;
                int i = this.f1712e;
                this.f1712e = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f1714g++;
                    this.f1715h = this.f1712e;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean m3433a(String str) {
        while (true) {
            if (this.f1712e + str.length() > this.f1713f && !m3438b(str.length())) {
                return false;
            }
            if (this.f1711d[this.f1712e] == '\n') {
                this.f1714g++;
                this.f1715h = this.f1712e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f1711d[this.f1712e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f1712e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + m3447v() + " column " + m3448w();
    }

    public String m3468q() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f1721n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f1720m[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.f1723p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.f1722o[i2] == null) {
                        break;
                    }
                    append.append(this.f1722o[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    private char m3451z() {
        if (this.f1712e != this.f1713f || m3438b(1)) {
            char[] cArr = this.f1711d;
            int i = this.f1712e;
            this.f1712e = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\n':
                    this.f1714g++;
                    this.f1715h = this.f1712e;
                    return c;
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f1712e + 4 <= this.f1713f || m3438b(4)) {
                        int i2 = this.f1712e;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.f1711d[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f1711d, this.f1712e, 4));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.f1712e += 4;
                        return c;
                    }
                    throw m3436b("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw m3436b("Unterminated escape sequence");
    }

    private IOException m3436b(String str) {
        throw new C0735e(str + " at line " + m3447v() + " column " + m3448w() + " path " + m3468q());
    }

    private void m3428A() {
        m3435b(true);
        this.f1712e--;
        if (this.f1712e + f1708a.length <= this.f1713f || m3438b(f1708a.length)) {
            int i = 0;
            while (i < f1708a.length) {
                if (this.f1711d[this.f1712e + i] == f1708a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f1712e += f1708a.length;
        }
    }
}
