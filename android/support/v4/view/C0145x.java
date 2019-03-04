package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: KeyEventCompat */
public class C0145x {
    static final ab f288a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f288a = new aa();
        } else {
            f288a = new C0121y();
        }
    }

    public static boolean m922a(KeyEvent keyEvent, int i) {
        return f288a.mo232a(keyEvent.getMetaState(), i);
    }

    public static boolean m921a(KeyEvent keyEvent) {
        return f288a.mo233b(keyEvent.getMetaState());
    }

    public static void m923b(KeyEvent keyEvent) {
        f288a.mo231a(keyEvent);
    }
}
