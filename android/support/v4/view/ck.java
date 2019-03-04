package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p005a.C0098e;
import android.support.v4.view.p005a.ag;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewPager */
class ck extends C0120a {
    final /* synthetic */ ViewPager f240b;

    ck(ViewPager viewPager) {
        this.f240b = viewPager;
    }

    public void mo305d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo305d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        ag a = ag.m210a();
        a.m212a(m799b());
        if (accessibilityEvent.getEventType() == 4096 && this.f240b.f181h != null) {
            a.m211a(this.f240b.f181h.getCount());
            a.m213b(this.f240b.f182i);
            a.m214c(this.f240b.f182i);
        }
    }

    public void mo303a(View view, C0098e c0098e) {
        super.mo303a(view, c0098e);
        c0098e.m249b(ViewPager.class.getName());
        c0098e.m269i(m799b());
        if (this.f240b.canScrollHorizontally(1)) {
            c0098e.m240a(4096);
        }
        if (this.f240b.canScrollHorizontally(-1)) {
            c0098e.m240a(8192);
        }
    }

    public boolean mo304a(View view, int i, Bundle bundle) {
        if (super.mo304a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.f240b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f240b.setCurrentItem(this.f240b.f182i + 1);
                return true;
            case 8192:
                if (!this.f240b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f240b.setCurrentItem(this.f240b.f182i - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean m799b() {
        return this.f240b.f181h != null && this.f240b.f181h.getCount() > 1;
    }
}
