package android.support.v4.view.p005a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
class C0119y implements af {
    final /* synthetic */ C0113t f213a;
    final /* synthetic */ C0118x f214b;

    C0119y(C0118x c0118x, C0113t c0113t) {
        this.f214b = c0118x;
        this.f213a = c0113t;
    }

    public boolean mo229a(int i, int i2, Bundle bundle) {
        return this.f213a.m477a(i, i2, bundle);
    }

    public List<Object> mo228a(String str, int i) {
        List a = this.f213a.m476a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0098e) a.get(i2)).m239a());
        }
        return arrayList;
    }

    public Object mo227a(int i) {
        C0098e a = this.f213a.m474a(i);
        if (a == null) {
            return null;
        }
        return a.m239a();
    }

    public Object mo230b(int i) {
        C0098e b = this.f213a.m478b(i);
        if (b == null) {
            return null;
        }
        return b.m239a();
    }
}
