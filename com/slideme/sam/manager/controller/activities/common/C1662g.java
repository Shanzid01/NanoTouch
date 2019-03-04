package com.slideme.sam.manager.controller.activities.common;

import android.os.AsyncTask;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.SplashActivity;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.UserProfile;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: FlipperFragmentActivity */
class C1662g extends AsyncTask<Void, Void, UserProfile> {
    final /* synthetic */ FlipperFragmentActivity f2793a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4948a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4949a((UserProfile) obj);
    }

    private C1662g(FlipperFragmentActivity flipperFragmentActivity) {
        this.f2793a = flipperFragmentActivity;
    }

    protected UserProfile m4948a(Void... voidArr) {
        return SAM.f2614g.m5638c();
    }

    protected void m4949a(UserProfile userProfile) {
        super.onPostExecute(userProfile);
        ((SAM) this.f2793a.getApplication()).m4781e();
        if (userProfile != null && this.f2793a.f2646a != null) {
            C1922m.m5797b("Connect", "Connected... Register Device...");
            SAM.f2614g.m5622a(C1913d.m5757a(this.f2793a.getApplicationContext()), new C1663h(this));
            if (!this.f2793a.k) {
                this.f2793a.m4787c();
            } else if (this.f2793a instanceof SplashActivity) {
                C1698a.m5060a(this.f2793a, false, null, AuthData.m4813i(this.f2793a.getApplicationContext()));
                this.f2793a.finish();
            }
        }
    }

    protected void onCancelled() {
        super.onCancelled();
    }
}
