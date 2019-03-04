package com.slideme.sam.manager.controller.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: ApplicationDetailsFragment */
class C1775y extends AsyncTask<Intent, Void, Void> {
    final /* synthetic */ C1735a f3163a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m5317a((Intent[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5318a((Void) obj);
    }

    private C1775y(C1735a c1735a) {
        this.f3163a = c1735a;
    }

    protected void onPreExecute() {
        if (this.f3163a.getActivity() != null) {
            ((FlipperFragmentActivity) this.f3163a.getActivity()).mo4273f();
        }
    }

    protected Void m5317a(Intent... intentArr) {
        boolean a;
        if (this.f3163a.f2992d != null) {
            a = this.f3163a.m5176a(this.f3163a.f2992d, false, null, null, null, this.f3163a.f2993e);
        } else {
            a = this.f3163a.m5180b(intentArr[0]);
        }
        if (!a) {
            cancel(true);
        }
        return null;
    }

    protected void m5318a(Void voidR) {
        try {
            this.f3163a.m5218a(null);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }
}
