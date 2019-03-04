package com.slideme.sam.manager.controller.fragment.p056a;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.model.data.cache.helper.UpdatesDatabase;
import com.slideme.sam.manager.model.data.cache.helper.data.UpdatesDatabaseObject;
import com.slideme.sam.manager.model.service.ApplicationUpdatesCheckService;
import com.slideme.sam.manager.net.wrappers.Catalog;

/* compiled from: UpdatedApplicationListFragment */
public class an extends C1708i {
    private BroadcastReceiver f2942a = new ao(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ApplicationUpdatesCheckService.m5554a()) {
            mo4260a(false);
            m5093b(false);
        }
        C0090q.m145a(getActivity()).m149a(this.f2942a, new IntentFilter("com.slideme.sam.manager.ACTION_UPDATES_CHECKED"));
    }

    public void onDestroy() {
        C0090q.m145a(getActivity()).m148a(this.f2942a);
        super.onDestroy();
    }

    protected void mo4257a(Catalog catalog) {
        UpdatesDatabase updatesDatabase = new UpdatesDatabase(getActivity());
        UpdatesDatabaseObject[] all = updatesDatabase.getAll();
        updatesDatabase.close();
        String[] strArr = new String[all.length];
        for (int i = 0; i < all.length; i++) {
            strArr[i] = all[i].bundleId;
        }
        catalog.m5667a(strArr);
    }

    public void mo4260a(boolean z) {
        super.mo4260a(z);
        if (z && getActivity() != null) {
            ((NotificationManager) getActivity().getSystemService("notification")).cancel(1);
        }
    }

    boolean mo4258a() {
        return this.g.m5681e() > 0;
    }
}
