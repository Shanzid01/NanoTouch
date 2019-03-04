package com.slideme.sam.manager.model.p061a;

import android.os.AsyncTask;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.wrappers.C1905r;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: SAMUpdateManager */
class C1820h extends AsyncTask<Float, Void, Void> {
    final /* synthetic */ C1818f f3258a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m5469a((Float[]) objArr);
    }

    private C1820h(C1818f c1818f) {
        this.f3258a = c1818f;
    }

    protected Void m5469a(Float... fArr) {
        int i = (SAM.f2613f.m5450g() && C1922m.m5798b(this.f3258a.f3253a)) ? 1 : 0;
        float floatValue = fArr[0].floatValue();
        if (i != 0) {
            C1905r c1905r = new C1905r((SAM) this.f3258a.f3253a.getApplicationContext());
            c1905r.m5706a(new C1821i(this, floatValue));
            c1905r.m5707c();
        } else {
            this.f3258a.m5462c();
        }
        return null;
    }
}
