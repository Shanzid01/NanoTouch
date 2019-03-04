package com.slideme.sam.manager.controller.activities.market.product;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.slideme.sam.manager.controller.fragment.bg;
import com.slideme.sam.manager.model.data.ApplicationHolder;

/* compiled from: ScreenshotActivity */
class C1677c extends FragmentPagerAdapter {
    final /* synthetic */ ScreenshotActivity f2851a;
    private bg[] f2852b;

    protected C1677c(ScreenshotActivity screenshotActivity, ApplicationHolder applicationHolder) {
        this.f2851a = screenshotActivity;
        super(screenshotActivity.getSupportFragmentManager());
        this.f2852b = new bg[applicationHolder.app.resources.screenshots.size()];
        for (int i = 0; i < this.f2852b.length; i++) {
            bg bgVar = new bg();
            Bundle bundle = new Bundle();
            bundle.putInt("com.slideme.sam.manager.EXTRA_SCREENSHOT_INDEX", i);
            bundle.putParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER", applicationHolder);
            bgVar.setArguments(bundle);
            this.f2852b[i] = bgVar;
        }
    }

    public Fragment getItem(int i) {
        return this.f2852b[i];
    }

    public int getCount() {
        return this.f2852b.length;
    }
}
