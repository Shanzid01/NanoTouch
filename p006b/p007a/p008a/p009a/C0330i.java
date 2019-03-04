package p006b.p007a.p008a.p009a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p013c.C0255w;

/* compiled from: Fabric */
public class C0330i {
    private final Context f1024a;
    private C0337q[] f1025b;
    private C0255w f1026c;
    private Handler f1027d;
    private C0324t f1028e;
    private boolean f1029f;
    private String f1030g;
    private String f1031h;
    private C0328l<C0326f> f1032i;

    public C0330i(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.f1024a = context.getApplicationContext();
    }

    public C0330i m2320a(C0337q... c0337qArr) {
        if (this.f1025b != null) {
            throw new IllegalStateException("Kits already set.");
        }
        this.f1025b = c0337qArr;
        return this;
    }

    public C0326f m2319a() {
        Map hashMap;
        if (this.f1026c == null) {
            this.f1026c = C0255w.m2044a();
        }
        if (this.f1027d == null) {
            this.f1027d = new Handler(Looper.getMainLooper());
        }
        if (this.f1028e == null) {
            if (this.f1029f) {
                this.f1028e = new C0325e(3);
            } else {
                this.f1028e = new C0325e();
            }
        }
        if (this.f1031h == null) {
            this.f1031h = this.f1024a.getPackageName();
        }
        if (this.f1032i == null) {
            this.f1032i = C0328l.f1020d;
        }
        if (this.f1025b == null) {
            hashMap = new HashMap();
        } else {
            hashMap = C0326f.m2295b(Arrays.asList(this.f1025b));
        }
        return new C0326f(this.f1024a, hashMap, this.f1026c, this.f1027d, this.f1028e, this.f1029f, this.f1032i, new C0226z(this.f1024a, this.f1031h, this.f1030g, hashMap.values()));
    }
}
