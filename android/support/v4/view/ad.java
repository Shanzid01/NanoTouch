package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: KeyEventCompatHoneycomb */
class ad {
    public static int m513a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m514a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m515b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
