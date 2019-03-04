package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PagerTabStrip */
class al implements OnClickListener {
    final /* synthetic */ PagerTabStrip f220a;

    al(PagerTabStrip pagerTabStrip) {
        this.f220a = pagerTabStrip;
    }

    public void onClick(View view) {
        this.f220a.a.setCurrentItem(this.f220a.a.getCurrentItem() + 1);
    }
}
