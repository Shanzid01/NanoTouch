package android.support.v4.view.p005a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
class C0117w implements ac {
    final /* synthetic */ C0113t f211a;
    final /* synthetic */ C0116v f212b;

    C0117w(C0116v c0116v, C0113t c0113t) {
        this.f212b = c0116v;
        this.f211a = c0113t;
    }

    public boolean mo226a(int i, int i2, Bundle bundle) {
        return this.f211a.m477a(i, i2, bundle);
    }

    public List<Object> mo225a(String str, int i) {
        List a = this.f211a.m476a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0098e) a.get(i2)).m239a());
        }
        return arrayList;
    }

    public Object mo224a(int i) {
        C0098e a = this.f211a.m474a(i);
        if (a == null) {
            return null;
        }
        return a.m239a();
    }
}
