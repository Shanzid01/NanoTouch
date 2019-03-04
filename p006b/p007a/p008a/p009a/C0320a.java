package p006b.p007a.p008a.p009a;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: ActivityLifecycleManager */
public class C0320a {
    private final Application f998a;
    private C0321b f999b;

    public C0320a(Context context) {
        this.f998a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f999b = new C0321b(this.f998a);
        }
    }

    public boolean m2253a(C0323d c0323d) {
        return this.f999b != null && this.f999b.m2257a(c0323d);
    }

    public void m2252a() {
        if (this.f999b != null) {
            this.f999b.m2254a();
        }
    }
}
