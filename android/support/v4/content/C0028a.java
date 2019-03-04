package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import java.io.File;

/* compiled from: ContextCompat */
public class C0028a {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return C0028a.startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0079e.m133a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0078d.m132a(context, intentArr);
            return true;
        }
    }

    public static File[] getObbDirs(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0080f.m136b(context);
        }
        File a;
        if (i >= 11) {
            a = C0078d.m131a(context);
        } else {
            a = C0028a.buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context.getPackageName());
        }
        return new File[]{a};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0080f.m135a(context, str);
        }
        File a;
        if (i >= 8) {
            a = C0077c.m130a(context, str);
        } else {
            a = C0028a.buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_FILES, str);
        }
        return new File[]{a};
    }

    public static File[] getExternalCacheDirs(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0080f.m134a(context);
        }
        File a;
        if (i >= 8) {
            a = C0077c.m129a(context);
        } else {
            a = C0028a.buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_CACHE);
        }
        return new File[]{a};
    }

    private static File buildPath(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            File file3;
            String str = strArr[i];
            if (file2 == null) {
                file3 = new File(str);
            } else if (str != null) {
                file3 = new File(file2, str);
            } else {
                file3 = file2;
            }
            i++;
            file2 = file3;
        }
        return file2;
    }

    public static final Drawable getDrawable(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return C0076b.m126a(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public final File getNoBackupFilesDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return C0076b.m127a(context);
        }
        return C0028a.createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public final File getCodeCacheDir(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return C0076b.m128b(context);
        }
        return C0028a.createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    private static synchronized File createFilesDir(File file) {
        synchronized (C0028a.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
