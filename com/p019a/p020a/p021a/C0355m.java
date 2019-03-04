package com.p019a.p020a.p021a;

import android.app.Activity;
import android.os.Bundle;
import p006b.p007a.p008a.p009a.C0323d;

/* compiled from: AnswersLifecycleCallbacks */
class C0355m extends C0323d {
    private final ag f1130a;

    public C0355m(ag agVar) {
        this.f1130a = agVar;
    }

    public void mo521a(Activity activity, Bundle bundle) {
        this.f1130a.m2388a(activity, al.CREATE);
    }

    public void mo520a(Activity activity) {
        this.f1130a.m2388a(activity, al.START);
    }

    public void mo522b(Activity activity) {
        this.f1130a.m2388a(activity, al.RESUME);
    }

    public void mo542c(Activity activity) {
        this.f1130a.m2388a(activity, al.PAUSE);
    }

    public void mo543d(Activity activity) {
        this.f1130a.m2388a(activity, al.STOP);
    }

    public void mo541b(Activity activity, Bundle bundle) {
        this.f1130a.m2388a(activity, al.SAVE_INSTANCE_STATE);
    }

    public void mo544e(Activity activity) {
        this.f1130a.m2388a(activity, al.DESTROY);
    }
}
