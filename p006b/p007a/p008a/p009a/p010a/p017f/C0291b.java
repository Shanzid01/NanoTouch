package p006b.p007a.p008a.p009a.p010a.p017f;

import android.content.Context;
import java.io.File;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;

/* compiled from: FileStoreImpl */
public class C0291b implements C0290a {
    private final Context f911a;
    private final String f912b;
    private final String f913c;

    public C0291b(C0337q c0337q) {
        if (c0337q.m2334B() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f911a = c0337q.m2334B();
        this.f912b = c0337q.m2336D();
        this.f913c = "Android/" + this.f911a.getPackageName();
    }

    public File mo499a() {
        return m2196a(this.f911a.getFilesDir());
    }

    File m2196a(File file) {
        if (file == null) {
            C0326f.m2298h().mo511a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C0326f.m2298h().mo516d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
