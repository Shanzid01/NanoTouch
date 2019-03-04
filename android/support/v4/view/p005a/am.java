package android.support.v4.view.p005a;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompatIcs */
class am {
    public static Object m230a() {
        return AccessibilityRecord.obtain();
    }

    public static void m231a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m233b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m232a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m234c(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
