package android.support.v4.view.p005a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class C0113t {
    private static final C0114u f209a;
    private final Object f210b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f209a = new C0118x();
        } else if (VERSION.SDK_INT >= 16) {
            f209a = new C0116v();
        } else {
            f209a = new C0115z();
        }
    }

    public C0113t() {
        this.f210b = f209a.mo223a(this);
    }

    public C0113t(Object obj) {
        this.f210b = obj;
    }

    public Object m475a() {
        return this.f210b;
    }

    public C0098e m474a(int i) {
        return null;
    }

    public boolean m477a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<C0098e> m476a(String str, int i) {
        return null;
    }

    public C0098e m478b(int i) {
        return null;
    }
}
