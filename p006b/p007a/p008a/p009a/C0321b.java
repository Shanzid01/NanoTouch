package p006b.p007a.p008a.p009a;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
class C0321b {
    private final Set<ActivityLifecycleCallbacks> f1000a = new HashSet();
    private final Application f1001b;

    C0321b(Application application) {
        this.f1001b = application;
    }

    @TargetApi(14)
    private void m2254a() {
        for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f1000a) {
            this.f1001b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
        }
    }

    @TargetApi(14)
    private boolean m2257a(C0323d c0323d) {
        if (this.f1001b == null) {
            return false;
        }
        ActivityLifecycleCallbacks c0322c = new C0322c(this, c0323d);
        this.f1001b.registerActivityLifecycleCallbacks(c0322c);
        this.f1000a.add(c0322c);
        return true;
    }
}
