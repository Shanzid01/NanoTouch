package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: AccessibilityDelegateCompatJellyBean */
class C0133k {
    public static Object m890a(C0129m c0129m) {
        return new C0134l(c0129m);
    }

    public static Object m891a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m892a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
