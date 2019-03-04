package android.support.v4.view.p005a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat */
final class ae extends AccessibilityNodeProvider {
    final /* synthetic */ af f202a;

    ae(af afVar) {
        this.f202a = afVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f202a.mo227a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f202a.mo228a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f202a.mo229a(i, i2, bundle);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f202a.mo230b(i);
    }
}
