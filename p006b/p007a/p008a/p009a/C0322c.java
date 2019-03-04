package p006b.p007a.p008a.p009a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: ActivityLifecycleManager */
class C0322c implements ActivityLifecycleCallbacks {
    final /* synthetic */ C0323d f1002a;
    final /* synthetic */ C0321b f1003b;

    C0322c(C0321b c0321b, C0323d c0323d) {
        this.f1003b = c0321b;
        this.f1002a = c0323d;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f1002a.mo521a(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.f1002a.mo520a(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.f1002a.mo522b(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f1002a.mo542c(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.f1002a.mo543d(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f1002a.mo541b(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f1002a.mo544e(activity);
    }
}
