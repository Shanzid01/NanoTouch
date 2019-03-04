package com.slideme.sam.manager.controller.activities.market.catalog;

import android.os.Bundle;
import com.slideme.sam.manager.controller.fragment.p056a.ae;

public class QueryDynamicLayoutItemActivity extends ApplicationListActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void mo4242b() {
        CharSequence string = getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_TITLE");
        this.a = new ae();
        if (string != null && string.length() != 0) {
            setTitle(string);
        }
    }
}
