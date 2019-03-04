package com.slideme.sam.manager.controller.activities.market.userinfo;

import android.os.Bundle;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.controller.fragment.aq;

public class MyAccountActivity extends AccountAwareActivity {
    private aq f2871a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2871a = (aq) getSupportFragmentManager().findFragmentByTag("content_fragment");
    }

    public void mo4239a() {
        if (this.f2871a == null) {
            this.f2871a = new aq();
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2871a, "content_fragment").commit();
        }
        m4796e();
    }
}
