package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.p049a.C1475a;
import com.mopub.common.p050b.C1486i;
import java.lang.ref.WeakReference;

/* compiled from: GpsHelper */
class C1509q extends AsyncTask<Void, Void, Void> {
    private WeakReference<Context> f2198a;
    private WeakReference<C1510r> f2199b;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4148a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4149a((Void) obj);
    }

    public C1509q(Context context, C1510r c1510r) {
        this.f2198a = new WeakReference(context);
        this.f2199b = new WeakReference(c1510r);
    }

    protected Void m4148a(Void... voidArr) {
        try {
            Context context = (Context) this.f2198a.get();
            if (context != null) {
                Object a = C1475a.m4010a(null, "getAdvertisingIdInfo").m4082a(Class.forName(C1508p.f2197b)).m4083a(Context.class, context).m4084a();
                if (a != null) {
                    C1508p.m4140a(context, a);
                }
            }
        } catch (Exception e) {
            C1486i.m4076a("Unable to obtain AdvertisingIdClient.getAdvertisingIdInfo()");
        }
        return null;
    }

    protected void m4149a(Void voidR) {
        C1510r c1510r = (C1510r) this.f2199b.get();
        if (c1510r != null) {
            c1510r.mo4137a();
        }
    }
}
