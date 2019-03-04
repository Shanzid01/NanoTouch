package com.p019a.p020a.p023c;

import android.content.Context;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p018g.C0310o;

/* compiled from: DialogStringResolver */
class aw {
    private final Context f1243a;
    private final C0310o f1244b;

    public aw(Context context, C0310o c0310o) {
        this.f1243a = context;
        this.f1244b = c0310o;
    }

    public String m2565a() {
        return m2562a("com.crashlytics.CrashSubmissionPromptTitle", this.f1244b.f963a);
    }

    public String m2566b() {
        return m2562a("com.crashlytics.CrashSubmissionPromptMessage", this.f1244b.f964b);
    }

    public String m2567c() {
        return m2562a("com.crashlytics.CrashSubmissionSendTitle", this.f1244b.f965c);
    }

    public String m2568d() {
        return m2562a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f1244b.f969g);
    }

    public String m2569e() {
        return m2562a("com.crashlytics.CrashSubmissionCancelTitle", this.f1244b.f967e);
    }

    private String m2562a(String str, String str2) {
        return m2564b(C0214m.m1921b(this.f1243a, str), str2);
    }

    private String m2564b(String str, String str2) {
        return m2563a(str) ? str2 : str;
    }

    private boolean m2563a(String str) {
        return str == null || str.length() == 0;
    }
}
