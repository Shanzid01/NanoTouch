package com.p019a.p020a.p021a;

import java.io.File;
import java.util.List;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0201a;
import p006b.p007a.p008a.p009a.p010a.p012b.ai;
import p006b.p007a.p008a.p009a.p010a.p015d.C0269l;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p016e.C0277d;
import p006b.p007a.p008a.p009a.p010a.p016e.C0278e;

/* compiled from: SessionAnalyticsFilesSender */
class af extends C0201a implements C0269l {
    private final String f1065b;

    public af(C0337q c0337q, String str, String str2, C0274m c0274m, String str3) {
        super(c0337q, str, str2, c0274m, C0277d.POST);
        this.f1065b = str3;
    }

    public boolean mo538a(List<File> list) {
        C0278e a = m1827b().m2134a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m2134a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo529a()).m2134a("X-CRASHLYTICS-API-KEY", this.f1065b);
        int i = 0;
        for (File file : list) {
            a.m2137a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        C0326f.m2298h().mo511a("Answers", "Sending " + list.size() + " analytics files to " + m1826a());
        int b = a.m2144b();
        C0326f.m2298h().mo511a("Answers", "Response code for analytics file send is " + b);
        if (ai.m1860a(b) == 0) {
            return true;
        }
        return false;
    }
}
