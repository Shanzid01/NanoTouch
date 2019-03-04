package com.p019a.p020a.p021a;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p012b.aa;

/* compiled from: SessionMetadataCollector */
class ao {
    private final Context f1096a;
    private final C0226z f1097b;
    private final String f1098c;
    private final String f1099d;

    public ao(Context context, C0226z c0226z, String str, String str2) {
        this.f1096a = context;
        this.f1097b = c0226z;
        this.f1098c = str;
        this.f1099d = str2;
    }

    public am m2412a() {
        Map g = this.f1097b.m1964g();
        return new am(this.f1096a.getPackageName(), UUID.randomUUID().toString(), this.f1097b.m1959b(), (String) g.get(aa.ANDROID_ID), (String) g.get(aa.ANDROID_ADVERTISING_ID), this.f1097b.m1967j(), (String) g.get(aa.FONT_TOKEN), C0214m.m1936m(this.f1096a), this.f1097b.m1961d(), this.f1097b.m1962e(), this.f1098c, this.f1099d);
    }
}
