package p006b.p007a.p008a.p009a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p013c.C0245n;
import p006b.p007a.p008a.p009a.p010a.p013c.C0255w;
import p006b.p007a.p008a.p009a.p010a.p013c.C0257z;

/* compiled from: Fabric */
public class C0326f {
    static volatile C0326f f1005a;
    static final C0324t f1006b = new C0325e();
    final C0324t f1007c;
    final boolean f1008d;
    private final Context f1009e;
    private final Map<Class<? extends C0337q>, C0337q> f1010f;
    private final ExecutorService f1011g;
    private final Handler f1012h;
    private final C0328l<C0326f> f1013i;
    private final C0328l<?> f1014j;
    private final C0226z f1015k;
    private C0320a f1016l;
    private WeakReference<Activity> f1017m;
    private AtomicBoolean f1018n = new AtomicBoolean(false);

    static C0326f m2288a() {
        if (f1005a != null) {
            return f1005a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C0326f(Context context, Map<Class<? extends C0337q>, C0337q> map, C0255w c0255w, Handler handler, C0324t c0324t, boolean z, C0328l c0328l, C0226z c0226z) {
        this.f1009e = context;
        this.f1010f = map;
        this.f1011g = c0255w;
        this.f1012h = handler;
        this.f1007c = c0324t;
        this.f1008d = z;
        this.f1013i = c0328l;
        this.f1014j = m2302a(map.size());
        this.f1015k = c0226z;
    }

    public static C0326f m2289a(Context context, C0337q... c0337qArr) {
        if (f1005a == null) {
            synchronized (C0326f.class) {
                if (f1005a == null) {
                    C0326f.m2297c(new C0330i(context).m2320a(c0337qArr).m2319a());
                }
            }
        }
        return f1005a;
    }

    private static void m2297c(C0326f c0326f) {
        f1005a = c0326f;
        c0326f.m2300j();
    }

    public C0326f m2301a(Activity activity) {
        this.f1017m = new WeakReference(activity);
        return this;
    }

    public Activity m2305b() {
        if (this.f1017m != null) {
            return (Activity) this.f1017m.get();
        }
        return null;
    }

    private void m2300j() {
        m2301a(m2296c(this.f1009e));
        this.f1016l = new C0320a(this.f1009e);
        this.f1016l.m2253a(new C0327g(this));
        m2303a(this.f1009e);
    }

    public String m2307c() {
        return "1.3.6.79";
    }

    public String m2308d() {
        return "io.fabric.sdk.android:fabric";
    }

    void m2303a(Context context) {
        StringBuilder append;
        Future b = m2306b(context);
        Collection g = m2311g();
        C0340u c0340u = new C0340u(b, g);
        List<C0337q> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        c0340u.m2341a(context, this, C0328l.f1020d, this.f1015k);
        for (C0337q a : arrayList) {
            a.m2341a(context, this, this.f1014j, this.f1015k);
        }
        c0340u.m2347z();
        if (C0326f.m2298h().mo513a("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(m2308d()).append(" [Version: ").append(m2307c()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (C0337q a2 : arrayList) {
            a2.f1038f.m2013a(c0340u.f);
            m2304a(this.f1010f, a2);
            a2.m2347z();
            if (append != null) {
                append.append(a2.mo531b()).append(" [Version: ").append(a2.mo529a()).append("]\n");
            }
        }
        if (append != null) {
            C0326f.m2298h().mo511a("Fabric", append.toString());
        }
    }

    void m2304a(Map<Class<? extends C0337q>, C0337q> map, C0337q c0337q) {
        C0245n c0245n = (C0245n) c0337q.getClass().getAnnotation(C0245n.class);
        if (c0245n != null) {
            for (Class cls : c0245n.m2008a()) {
                if (cls.isInterface()) {
                    for (C0337q c0337q2 : map.values()) {
                        if (cls.isAssignableFrom(c0337q2.getClass())) {
                            c0337q.f1038f.m2013a(c0337q2.f1038f);
                        }
                    }
                } else if (((C0337q) map.get(cls)) == null) {
                    throw new C0257z("Referenced Kit was null, does the kit exist?");
                } else {
                    c0337q.f1038f.m2013a(((C0337q) map.get(cls)).f1038f);
                }
            }
        }
    }

    private Activity m2296c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public C0320a m2309e() {
        return this.f1016l;
    }

    public ExecutorService m2310f() {
        return this.f1011g;
    }

    public Collection<C0337q> m2311g() {
        return this.f1010f.values();
    }

    public static <T extends C0337q> T m2290a(Class<T> cls) {
        return (C0337q) C0326f.m2288a().f1010f.get(cls);
    }

    public static C0324t m2298h() {
        if (f1005a == null) {
            return f1006b;
        }
        return f1005a.f1007c;
    }

    public static boolean m2299i() {
        if (f1005a == null) {
            return false;
        }
        return f1005a.f1008d;
    }

    private static Map<Class<? extends C0337q>, C0337q> m2295b(Collection<? extends C0337q> collection) {
        Map hashMap = new HashMap(collection.size());
        C0326f.m2293a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void m2293a(Map<Class<? extends C0337q>, C0337q> map, Collection<? extends C0337q> collection) {
        for (C0337q c0337q : collection) {
            map.put(c0337q.getClass(), c0337q);
            if (c0337q instanceof C0338r) {
                C0326f.m2293a((Map) map, ((C0338r) c0337q).mo547c());
            }
        }
    }

    C0328l<?> m2302a(int i) {
        return new C0329h(this, i);
    }

    Future<Map<String, C0339s>> m2306b(Context context) {
        return m2310f().submit(new C0332k(context.getPackageCodePath()));
    }
}
