package com.slideme.sam.manager.inapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.drive.DriveFile;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.response.InAppConsumeResponse;
import com.slideme.sam.manager.net.response.InAppListResponse;
import com.slideme.sam.manager.net.response.InAppPurchasesListResponse;
import java.util.List;

public class InAppService extends AccountAwareService {
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public InAppListResponse m5345a(int i, List<String> list, String str) {
        if (m5321a()) {
            return SAM.f2614g.m5593a(i, (List) list, str);
        }
        return null;
    }

    public InAppPurchasesListResponse m5346a(int i, String str) {
        if (m5321a()) {
            return SAM.f2614g.m5594a(i, str);
        }
        return null;
    }

    public PendingIntent m5343a(int i, String str, String str2, String str3) {
        Intent intent = new Intent(this, InAppPurchasingActivity.class);
        intent.putExtra("com.slideme.sam.manager.extra.IAP_ID", str);
        intent.putExtra("com.slideme.sam.manager.extra.CALLER_PACKAGE", str2);
        intent.putExtra("com.slideme.sam.manager.extra.API_VERSION", i);
        intent.putExtra("com.slideme.sam.manager.extra.DEVELOPER_PAYLOAD", str3);
        intent.setFlags(8388608);
        return PendingIntent.getActivity(this, -1, intent, DriveFile.MODE_READ_ONLY);
    }

    public InAppConsumeResponse m5344a(int i, String str, String str2) {
        if (m5321a()) {
            return SAM.f2614g.m5592a(i, str, str2);
        }
        return null;
    }

    public IBinder onBind(Intent intent) {
        return new C1794k(this);
    }

    public static final Bundle m5342a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.slideme.sam.manager.inapp.BUNDLE_STATUS", i);
        return bundle;
    }
}
