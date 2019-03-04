package p006b.p007a.p008a.p009a.p010a.p012b;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0277d;
import p006b.p007a.p008a.p009a.p010a.p016e.C0278e;

/* compiled from: AbstractSpiCall */
public abstract class C0201a {
    private static final Pattern f744b = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final C0337q f745a;
    private final String f746c;
    private final C0274m f747d;
    private final C0277d f748e;
    private final String f749f;

    public C0201a(C0337q c0337q, String str, String str2, C0274m c0274m, C0277d c0277d) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (c0274m == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.f745a = c0337q;
            this.f749f = str;
            this.f746c = m1824a(str2);
            this.f747d = c0274m;
            this.f748e = c0277d;
        }
    }

    protected String m1826a() {
        return this.f746c;
    }

    protected C0278e m1827b() {
        return m1825a(Collections.emptyMap());
    }

    protected C0278e m1825a(Map<String, String> map) {
        return this.f747d.mo493a(this.f748e, m1826a(), map).m2141a(false).m2131a(10000).m2134a("User-Agent", "Crashlytics Android SDK/" + this.f745a.mo529a()).m2134a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String m1824a(String str) {
        if (C0214m.m1926c(this.f749f)) {
            return str;
        }
        return f744b.matcher(str).replaceFirst(this.f749f);
    }
}
