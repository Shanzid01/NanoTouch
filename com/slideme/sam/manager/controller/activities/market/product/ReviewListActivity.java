package com.slideme.sam.manager.controller.activities.market.product;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.fragment.ay;
import com.slideme.sam.manager.view.p064a.C1942l;

public class ReviewListActivity extends FlipperFragmentActivity implements OnDismissListener {
    private ay f2833a = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2833a = (ay) getSupportFragmentManager().findFragmentByTag("content_fragment");
        mo4242b();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f2833a != null && this.f2833a.getListAdapter() != null) {
            ((C1942l) this.f2833a.getListAdapter()).notifyDataSetChanged();
        }
    }

    public void mo4242b() {
        if (this.f2833a == null) {
            this.f2833a = new ay();
            this.f2833a.setArguments(new Bundle(getIntent().getExtras()));
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2833a, "content_fragment").commit();
        }
        m4796e();
    }
}
