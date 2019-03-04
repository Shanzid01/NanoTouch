package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0120a;
import android.support.v4.view.p005a.C0098e;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class bh extends C0120a {
    final RecyclerView f647b;
    final C0120a f648c = new bi(this);

    public bh(RecyclerView recyclerView) {
        this.f647b = recyclerView;
    }

    public boolean mo304a(View view, int i, Bundle bundle) {
        if (super.mo304a(view, i, bundle)) {
            return true;
        }
        if (this.f647b.getLayoutManager() != null) {
            return this.f647b.getLayoutManager().performAccessibilityAction(i, bundle);
        }
        return false;
    }

    public void mo303a(View view, C0098e c0098e) {
        super.mo303a(view, c0098e);
        c0098e.m249b(RecyclerView.class.getName());
        if (this.f647b.getLayoutManager() != null) {
            this.f647b.getLayoutManager().onInitializeAccessibilityNodeInfo(c0098e);
        }
    }

    public void mo305d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo305d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    C0120a m1697b() {
        return this.f648c;
    }
}
