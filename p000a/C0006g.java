package p000a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BoltsExecutors */
final class C0006g {
    private static final C0006g f12a = new C0006g();
    private final ExecutorService f13b;
    private final Executor f14c;

    private static boolean m6c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private C0006g() {
        this.f13b = !C0006g.m6c() ? Executors.newCachedThreadPool() : C0000a.m0a();
        this.f14c = new C0008i();
    }

    public static ExecutorService m4a() {
        return f12a.f13b;
    }

    static Executor m5b() {
        return f12a.f14c;
    }
}
