package com.p019a.p020a.p023c;

import java.io.File;
import java.util.Locale;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.ad;

/* compiled from: QueueFileLogStore */
class bt implements ay {
    private final File f1289a;
    private final int f1290b;
    private ad f1291c;

    public bt(File file, int i) {
        this.f1289a = file;
        this.f1290b = i;
    }

    public void mo552a(long j, String str) {
        m2646d();
        m2645b(j, str);
    }

    public C0389b mo551a() {
        if (!this.f1289a.exists()) {
            return null;
        }
        m2646d();
        if (this.f1291c == null) {
            return null;
        }
        int[] iArr = new int[]{0};
        byte[] bArr = new byte[this.f1291c.m1850a()];
        try {
            this.f1291c.m1851a(new bu(this, bArr, iArr));
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C0389b.m2589a(bArr, 0, iArr[0]);
    }

    public void mo553b() {
        C0214m.m1913a(this.f1291c, "There was a problem closing the Crashlytics log file.");
        this.f1291c = null;
    }

    public void mo554c() {
        mo553b();
        this.f1289a.delete();
    }

    private void m2646d() {
        if (this.f1291c == null) {
            try {
                this.f1291c = new ad(this.f1289a);
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Could not open log file: " + this.f1289a, e);
            }
        }
    }

    private void m2645b(long j, String str) {
        if (this.f1291c != null) {
            String str2;
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            try {
                int i = this.f1290b / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                str2 = str2.replaceAll("\r", " ").replaceAll("\n", " ");
                this.f1291c.m1852a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str2}).getBytes("UTF-8"));
                while (!this.f1291c.m1855b() && this.f1291c.m1850a() > this.f1290b) {
                    this.f1291c.m1856c();
                }
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
