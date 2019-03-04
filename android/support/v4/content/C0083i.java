package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: IntentCompat */
public class C0083i {
    private static final C0084j f95a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f95a = new C0087m();
        } else if (i >= 11) {
            f95a = new C0086l();
        } else {
            f95a = new C0085k();
        }
    }

    public static Intent m140a(ComponentName componentName) {
        return f95a.mo168a(componentName);
    }
}
