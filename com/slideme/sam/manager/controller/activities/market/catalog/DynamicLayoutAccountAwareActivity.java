package com.slideme.sam.manager.controller.activities.market.catalog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.controller.fragment.p056a.C1709a;

public class DynamicLayoutAccountAwareActivity extends AccountAwareActivity {
    private Fragment f2806a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2806a = getSupportFragmentManager().findFragmentByTag("content_fragment");
    }

    public void mo4242b() {
        if (this.f2806a == null) {
            this.f2806a = new C1709a();
            if (getIntent().getExtras() != null) {
                this.f2806a.setArguments(getIntent().getExtras());
            }
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2806a, "content_fragment").commit();
        }
        m4796e();
    }

    public void mo4239a() {
        mo4242b();
    }
}
