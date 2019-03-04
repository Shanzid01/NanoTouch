package com.p026b.p027a.p041c;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* compiled from: StorageUtils */
public final class C0525e {
    public static File m3156a(Context context) {
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = C0525e.m3158c(context);
        }
        if (file == null) {
            return context.getCacheDir();
        }
        return file;
    }

    public static File m3157b(Context context) {
        File a = C0525e.m3156a(context);
        File file = new File(a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : a;
    }

    private static File m3158c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists()) {
            return file;
        }
        if (file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                C0524d.m3153b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        C0524d.m3154c("Unable to create external cache directory", new Object[0]);
        return null;
    }
}
