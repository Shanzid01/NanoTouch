package com.slideme.sam.manager.controller.activities.market.catalog;

import com.slideme.sam.manager.controller.fragment.p056a.ac;
import com.slideme.sam.manager.controller.fragment.p056a.ak;
import com.slideme.sam.manager.controller.fragment.p056a.ap;

public class ActivityDynamicLayoutItemActivity extends ApplicationListActivity {
    protected void mo4242b() {
        CharSequence string = getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_TITLE");
        String string2 = getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_ACTIVITY_TYPE");
        if (string2.equals("videos")) {
            this.a = new ap();
        } else if (string2.equals("top-rated")) {
            this.a = new ak();
        } else if (string2.equals("app-offers")) {
            this.a = new ac();
        } else {
            finish();
        }
        if (string != null && string.length() != 0) {
            setTitle(string);
        }
    }
}
