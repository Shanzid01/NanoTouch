package com.slideme.sam.manager.controller.activities.market.catalog;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.activities.preference.SettingsActivity;

/* compiled from: MainActivity */
class C1668c implements OnClickListener {
    final /* synthetic */ MainActivity f2822a;

    C1668c(MainActivity mainActivity) {
        this.f2822a = mainActivity;
    }

    public void onClick(View view) {
        this.f2822a.startActivity(new Intent(this.f2822a, SettingsActivity.class));
    }
}
