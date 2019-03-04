package p006b.p007a.p008a.p009a.p010a.p012b;

import android.content.Context;
import p006b.p007a.p008a.p009a.p010a.p011a.C0200d;

/* compiled from: InstallerPackageNameProvider */
class ac implements C0200d<String> {
    final /* synthetic */ ab f752a;

    ac(ab abVar) {
        this.f752a = abVar;
    }

    public /* synthetic */ Object mo464c(Context context) {
        return m1829a(context);
    }

    public String m1829a(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
