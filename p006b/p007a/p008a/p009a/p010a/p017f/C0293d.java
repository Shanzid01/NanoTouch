package p006b.p007a.p008a.p009a.p010a.p017f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import p006b.p007a.p008a.p009a.C0337q;

/* compiled from: PreferenceStoreImpl */
public class C0293d implements C0292c {
    private final SharedPreferences f914a;
    private final String f915b;
    private final Context f916c;

    public C0293d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f916c = context;
        this.f915b = str;
        this.f914a = this.f916c.getSharedPreferences(this.f915b, 0);
    }

    @Deprecated
    public C0293d(C0337q c0337q) {
        this(c0337q.m2334B(), c0337q.getClass().getName());
    }

    public SharedPreferences mo500a() {
        return this.f914a;
    }

    public Editor mo502b() {
        return this.f914a.edit();
    }

    @TargetApi(9)
    public boolean mo501a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
