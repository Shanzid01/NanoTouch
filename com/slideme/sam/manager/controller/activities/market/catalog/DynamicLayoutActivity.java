package com.slideme.sam.manager.controller.activities.market.catalog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.fragment.ae;

public class DynamicLayoutActivity extends FlipperFragmentActivity {
    private Fragment f2807a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2807a = getSupportFragmentManager().findFragmentByTag("content_fragment");
        mo4242b();
    }

    public void mo4242b() {
        if (this.f2807a == null) {
            this.f2807a = new ae();
            if (getIntent().getExtras() != null) {
                this.f2807a.setArguments(getIntent().getExtras());
            }
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2807a, "content_fragment").commit();
        }
        m4796e();
    }
}
