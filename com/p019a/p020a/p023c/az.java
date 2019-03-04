package com.p019a.p020a.p023c;

import android.content.Context;
import java.io.File;
import java.util.Set;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: LogFileManager */
class az {
    private static final bb f1245a = new bb();
    private final Context f1246b;
    private final File f1247c;
    private ay f1248d;

    public az(Context context, File file) {
        this(context, file, null);
    }

    public az(Context context, File file, String str) {
        this.f1246b = context;
        this.f1247c = new File(file, "log-files");
        this.f1248d = f1245a;
        m2585a(str);
    }

    public final void m2585a(String str) {
        this.f1248d.mo553b();
        this.f1248d = f1245a;
        if (str != null) {
            if (m2581d()) {
                m2584a(m2579b(str), 65536);
            } else {
                C0326f.m2298h().mo511a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    public void m2583a(long j, String str) {
        this.f1248d.mo552a(j, str);
    }

    public C0389b m2582a() {
        return this.f1248d.mo551a();
    }

    public void m2587b() {
        this.f1248d.mo554c();
    }

    public void m2586a(Set<String> set) {
        File[] listFiles = this.f1247c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m2578a(file))) {
                    file.delete();
                }
            }
        }
    }

    void m2584a(File file, int i) {
        this.f1248d = new bt(file, i);
    }

    private File m2579b(String str) {
        m2580c();
        return new File(this.f1247c, "crashlytics-userlog-" + str + ".temp");
    }

    private String m2578a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }

    private void m2580c() {
        if (!this.f1247c.exists()) {
            this.f1247c.mkdirs();
        }
    }

    private boolean m2581d() {
        return C0214m.m1916a(this.f1246b, "com.crashlytics.CollectCustomLogs", true);
    }
}
