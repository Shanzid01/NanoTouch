package android.support.v4.view.p005a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean */
final class ab extends AccessibilityNodeProvider {
    final /* synthetic */ ac f201a;

    ab(ac acVar) {
        this.f201a = acVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f201a.mo224a(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.f201a.mo225a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f201a.mo226a(i, i2, bundle);
    }
}
