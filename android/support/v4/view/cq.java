package android.support.v4.view;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import java.util.Comparator;

/* compiled from: ViewPager */
class cq implements Comparator<View> {
    cq() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m808a((View) obj, (View) obj2);
    }

    public int m808a(View view, View view2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
        if (layoutParams.f142a != layoutParams2.f142a) {
            return layoutParams.f142a ? 1 : -1;
        } else {
            return layoutParams.f146e - layoutParams2.f146e;
        }
    }
}
