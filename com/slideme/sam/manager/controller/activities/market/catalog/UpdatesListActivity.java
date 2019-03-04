package com.slideme.sam.manager.controller.activities.market.catalog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.C0090q;
import android.widget.Button;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.fragment.p056a.an;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.cache.helper.UpdatesDatabase;
import com.slideme.sam.manager.model.data.cache.helper.data.UpdatesDatabaseObject;
import com.slideme.sam.manager.model.service.ApplicationDownloadService;
import com.slideme.sam.manager.util.C1915f;

public class UpdatesListActivity extends ApplicationListActivity {
    private UpdatesDatabase f2817b;
    private Button f2818c;
    private BroadcastReceiver f2819d;

    public void onCreate(Bundle bundle) {
        m4956c(R.layout.activity_updates_list);
        super.onCreate(bundle);
        this.f2817b = new UpdatesDatabase(this);
        this.f2818c = (Button) findViewById(R.id.update_all);
        this.f2818c.setOnClickListener(new C1673h(this));
        this.f2819d = new C1674i(this);
        C0090q.m145a((Context) this).m149a(this.f2819d, new IntentFilter("com.slideme.sam.manager.ACTION_UPDATES_CHECKED"));
    }

    protected void onResume() {
        super.onResume();
        m4981i();
    }

    private void m4981i() {
        this.f2818c.setVisibility(this.f2817b.getAll().length > 0 ? 0 : 8);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f2817b.close();
        C0090q.m145a((Context) this).m148a(this.f2819d);
    }

    protected void mo4242b() {
        this.a = new an();
    }

    private void m4982j() {
        int i = 0;
        Application[] e = this.a.m5096e();
        UpdatesDatabaseObject[] all = this.f2817b.getAll();
        int i2 = 0;
        while (i2 < e.length) {
            if (!(all[i2].token == null || all[i2].token.equals(""))) {
                e[i2].token = all[i2].token;
            }
            i2++;
        }
        i2 = e.length;
        while (i < i2) {
            Parcelable parcelable = e[i];
            Intent intent = new Intent(this, ApplicationDownloadService.class);
            C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", parcelable);
            startService(intent);
            i++;
        }
    }
}
