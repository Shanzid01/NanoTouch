package com.slideme.sam.manager.inapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.util.C1922m;

public abstract class AccountAwareService extends Service {
    protected static boolean f3178a = false;
    private static final Object f3179b = new Object();
    private static BroadcastReceiver f3180c = new C1784a();

    public void onCreate() {
        super.onCreate();
        C0090q.m145a((Context) this).m149a(f3180c, new IntentFilter("com.slideme.sam.manager.ACTION_IAP_ACCOUNT_HANDLED"));
    }

    public void onDestroy() {
        super.onDestroy();
        C0090q.m145a((Context) this).m148a(f3180c);
    }

    protected boolean m5321a() {
        if (SAM.f2622o.m4850b() == null) {
            Intent intent = new Intent(this, SelectAccountActivity.class);
            intent.setFlags(1342177280);
            startActivity(intent);
            synchronized (f3179b) {
                try {
                    f3179b.wait();
                } catch (Throwable e) {
                    C1922m.m5791a(e);
                    return false;
                }
            }
        }
        f3178a = true;
        if (f3178a) {
            return true;
        }
        return false;
    }
}
