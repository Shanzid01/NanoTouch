package p006b.p007a.p008a.p009a.p010a.p012b;

import android.content.Context;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p011a.C0199b;
import p006b.p007a.p008a.p009a.p010a.p011a.C0200d;

/* compiled from: InstallerPackageNameProvider */
public class ab {
    private final C0200d<String> f750a = new ac(this);
    private final C0199b<String> f751b = new C0199b();

    public String m1828a(Context context) {
        try {
            String str = (String) this.f751b.mo461a(context, this.f750a);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
