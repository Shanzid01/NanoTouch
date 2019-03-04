package android.support.v4.content;

import android.content.Context;
import java.io.File;

/* compiled from: ContextCompatKitKat */
class C0080f {
    public static File[] m134a(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] m135a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] m136b(Context context) {
        return context.getObbDirs();
    }
}
