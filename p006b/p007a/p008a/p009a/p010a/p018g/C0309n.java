package p006b.p007a.p008a.p009a.p010a.p018g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: IconRequest */
public class C0309n {
    public final String f959a;
    public final int f960b;
    public final int f961c;
    public final int f962d;

    public C0309n(String str, int i, int i2, int i3) {
        this.f959a = str;
        this.f960b = i;
        this.f961c = i2;
        this.f962d = i3;
    }

    public static C0309n m2241a(Context context, String str) {
        if (str != null) {
            try {
                int l = C0214m.m1935l(context);
                C0326f.m2298h().mo511a("Fabric", "App icon resource ID is " + l);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C0309n(str, l, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
