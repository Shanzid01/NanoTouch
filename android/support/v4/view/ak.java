package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PagerTabStrip */
class ak implements OnClickListener {
    final /* synthetic */ PagerTabStrip f219a;

    ak(PagerTabStrip pagerTabStrip) {
        this.f219a = pagerTabStrip;
    }

    public void onClick(View view) {
        this.f219a.a.setCurrentItem(this.f219a.a.getCurrentItem() - 1);
    }
}
