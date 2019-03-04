package com.p019a.p020a.p021a;

import android.content.Context;
import android.os.Looper;
import p006b.p007a.p008a.p009a.p010a.p012b.aj;
import p006b.p007a.p008a.p009a.p010a.p015d.C0271m;
import p006b.p007a.p008a.p009a.p010a.p017f.C0290a;

/* compiled from: AnswersFilesManagerProvider */
class C0354l {
    final Context f1128a;
    final C0290a f1129b;

    public C0354l(Context context, C0290a c0290a) {
        this.f1128a = context;
        this.f1129b = c0290a;
    }

    public ae m2469a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new ae(this.f1128a, new an(), new aj(), new C0271m(this.f1128a, this.f1129b.mo499a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
