package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0120a;
import android.support.v4.view.p005a.C0098e;
import android.view.View;

/* compiled from: RecyclerViewAccessibilityDelegate */
class bi extends C0120a {
    final /* synthetic */ bh f649b;

    bi(bh bhVar) {
        this.f649b = bhVar;
    }

    public void mo303a(View view, C0098e c0098e) {
        super.mo303a(view, c0098e);
        if (this.f649b.f647b.getLayoutManager() != null) {
            this.f649b.f647b.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c0098e);
        }
    }

    public boolean mo304a(View view, int i, Bundle bundle) {
        if (super.mo304a(view, i, bundle)) {
            return true;
        }
        if (this.f649b.f647b.getLayoutManager() != null) {
            return this.f649b.f647b.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }
        return false;
    }
}
