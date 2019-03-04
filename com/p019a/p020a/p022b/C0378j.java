package com.p019a.p020a.p022b;

import android.content.Context;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p011a.C0200d;

/* compiled from: DeviceTokenLoader */
public class C0378j implements C0200d<String> {
    public /* synthetic */ Object mo464c(Context context) {
        return m2543a(context);
    }

    public String m2543a(Context context) {
        long nanoTime = System.nanoTime();
        String str = "";
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = m2545b(context);
            str = m2544a(zipInputStream);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e) {
                    C0326f.m2298h().mo519e("Beta", "Failed to close the APK file", e);
                }
            }
        } catch (Throwable e2) {
            C0326f.m2298h().mo519e("Beta", "Failed to find this app in the PackageManager", e2);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e22) {
                    C0326f.m2298h().mo519e("Beta", "Failed to close the APK file", e22);
                }
            }
        } catch (Throwable e222) {
            C0326f.m2298h().mo519e("Beta", "Failed to find the APK file", e222);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e2222) {
                    C0326f.m2298h().mo519e("Beta", "Failed to close the APK file", e2222);
                }
            }
        } catch (Throwable e22222) {
            C0326f.m2298h().mo519e("Beta", "Failed to read the APK file", e22222);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e222222) {
                    C0326f.m2298h().mo519e("Beta", "Failed to close the APK file", e222222);
                }
            }
        } catch (Throwable th) {
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e2222222) {
                    C0326f.m2298h().mo519e("Beta", "Failed to close the APK file", e2222222);
                }
            }
        }
        C0326f.m2298h().mo511a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
        return str;
    }

    ZipInputStream m2545b(Context context) {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir));
    }

    String m2544a(ZipInputStream zipInputStream) {
        String name;
        do {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return "";
            }
            name = nextEntry.getName();
        } while (!name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
        return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
    }
}
