package android.support.v4.view.p005a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
public class C0094a {
    private static final C0095d f200a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f200a = new C0097b();
        } else {
            f200a = new C0096c();
        }
    }

    public static ag m200a(AccessibilityEvent accessibilityEvent) {
        return new ag(accessibilityEvent);
    }
}
