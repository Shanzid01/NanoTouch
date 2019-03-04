package com.slideme.sam.manager.controller.activities.market.userinfo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;

public class MyAppsActivity extends AccountAwareActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.titled_viewpager);
    }

    public void mo4239a() {
        ((ViewPager) findViewById(R.id.pager)).m186a(new C1694a(this, getSupportFragmentManager()));
        m4796e();
    }
}
