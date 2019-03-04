package android.support.v4.content;

import android.content.Context;
import java.io.File;

/* compiled from: ContextCompatFroyo */
class C0077c {
    public static File m129a(Context context) {
        return context.getExternalCacheDir();
    }

    public static File m130a(Context context, String str) {
        return context.getExternalFilesDir(str);
    }
}
