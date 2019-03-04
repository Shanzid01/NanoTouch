package com.slideme.sam.manager.controller.activities.market.vendor;

import android.os.Bundle;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.fragment.p056a.C1726q;

public class DeveloperDetailsActivity extends FlipperFragmentActivity {
    private C1726q f2875a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2875a = (C1726q) getSupportFragmentManager().findFragmentByTag("content_fragment");
        mo4242b();
    }

    public void mo4242b() {
        if (this.f2875a == null) {
            Bundle bundle = new Bundle();
            bundle.putString("com.slideme.sam.manager.EXTRA_DEVELOPER_NAME", getIntent().getStringExtra("com.slideme.sam.manager.EXTRA_DEVELOPER_NAME"));
            bundle.putString("com.slideme.sam.manager.EXTRA_ORGANIZATION_NAME", getIntent().getStringExtra("com.slideme.sam.manager.EXTRA_ORGANIZATION_NAME"));
            bundle.putString("com.slideme.sam.manager.EXTRA_BUNDLE_ID", getIntent().getStringExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID"));
            this.f2875a = new C1726q();
            this.f2875a.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2875a, "content_fragment").commit();
        }
        m4796e();
    }
}
