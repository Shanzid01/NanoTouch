package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: ContextCompatApi21 */
class C0076b {
    public static Drawable m126a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File m127a(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File m128b(Context context) {
        return context.getCodeCacheDir();
    }
}
