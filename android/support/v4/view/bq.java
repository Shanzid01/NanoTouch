package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat */
public class bq {
    static final bv f230a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f230a = new bu();
        } else if (VERSION.SDK_INT >= 11) {
            f230a = new bt();
        } else if (VERSION.SDK_INT >= 8) {
            f230a = new bs();
        } else {
            f230a = new br();
        }
    }

    public static int m774a(ViewConfiguration viewConfiguration) {
        return f230a.mo294a(viewConfiguration);
    }
}
