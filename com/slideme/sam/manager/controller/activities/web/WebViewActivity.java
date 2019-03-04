package com.slideme.sam.manager.controller.activities.web;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.controller.fragment.p057b.C1746k;

public class WebViewActivity extends AccountAwareActivity {
    private Fragment f2893a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4796e();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(false);
        }
    }

    public void mo4239a() {
        getSupportActionBar().setHomeButtonEnabled(false);
        this.f2893a = getSupportFragmentManager().findFragmentByTag("content_fragment");
        if (this.f2893a == null) {
            this.f2893a = new C1746k();
            this.f2893a.setRetainInstance(true);
            this.f2893a.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2893a, "content_fragment").commit();
        }
    }
}
