package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@zzgi
public class zzam implements ActivityLifecycleCallbacks {
    private Context mContext;
    private final Object zznh = new Object();
    private Activity zzoi;

    public zzam(Application application, Activity activity) {
        application.registerActivityLifecycleCallbacks(this);
        setActivity(activity);
        this.mContext = application.getApplicationContext();
    }

    private void setActivity(Activity activity) {
        synchronized (this.zznh) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zzoi = activity;
            }
        }
    }

    public Activity getActivity() {
        return this.zzoi;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDestroyed(android.app.Activity r3) {
        /*
        r2 = this;
        r1 = r2.zznh;
        monitor-enter(r1);
        r0 = r2.zzoi;	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.zzoi;	 Catch:{ all -> 0x0016 }
        r0 = r0.equals(r3);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0014;
    L_0x0011:
        r0 = 0;
        r2.zzoi = r0;	 Catch:{ all -> 0x0016 }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x0008;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzam.onActivityDestroyed(android.app.Activity):void");
    }

    public void onActivityPaused(Activity activity) {
        setActivity(activity);
    }

    public void onActivityResumed(Activity activity) {
        setActivity(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
