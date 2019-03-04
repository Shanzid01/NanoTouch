package com.slideme.sam.manager.controller.activities.market.product;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.model.data.ApplicationHolder;

public class ScreenshotActivity extends FlipperFragmentActivity {
    private ApplicationHolder f2834a = null;

    public void onCreate(Bundle bundle) {
        m4786b(false);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_screenshot);
        m4796e();
        this.f2834a = (ApplicationHolder) getIntent().getParcelableExtra("com.slideme.sam.manager.EXTRA_APPHOLDER");
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.m186a(new C1677c(this, this.f2834a));
        viewPager.setCurrentItem(getIntent().getIntExtra("com.slideme.sam.manager.EXTRA_SCREENSHOT_INDEX", 0));
    }
}
