package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* compiled from: ContextCompatHoneycomb */
class C0078d {
    static void m132a(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }

    public static File m131a(Context context) {
        return context.getObbDir();
    }
}
