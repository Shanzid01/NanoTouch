package com.slideme.sam.manager.controller.activities.market;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.cache.helper.data.InstallReferrerCacheObject;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.model.p054b.C1829c;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1920k;
import com.slideme.sam.manager.util.C1922m;
import java.io.File;

public class InstallDelegateActivity extends Activity {
    private static int f2796b = 1;
    private Application f2797a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2797a = (Application) C1915f.m5770a(getIntent(), "com.slideme.sam.manager.EXTRA_APPLICATION", Application.CREATOR);
        if (bundle == null) {
            C1920k.m5781a((Context) this, (int) R.string.installing, 0).show();
            if (!TextUtils.isEmpty(this.f2797a.referrer)) {
                C1922m.m5797b("AdProxy", "Initiallizing pending install referrer broadcast for app: " + this.f2797a.packageName);
                InstallReferrerCacheObject installReferrerCacheObject = new InstallReferrerCacheObject(this.f2797a.packageName, this.f2797a.referrer, InstallReferrerCacheObject.STATE_NEW);
                SAM.f2623p.remove(installReferrerCacheObject);
                SAM.f2623p.add(installReferrerCacheObject);
            }
            m4954a();
        }
    }

    @SuppressLint({"InlinedApi"})
    private void m4954a() {
        Intent intent;
        Uri fromFile = Uri.fromFile(new File(this.f2797a.localFilePath));
        if (C1829c.m5504f() >= 14) {
            intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            intent.setData(fromFile);
            intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
            intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", getApplicationInfo().packageName);
        } else {
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        }
        startActivityForResult(intent, f2796b);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ((SAM) getApplication()).m4775a(this.f2797a, C1827a.m5491a(this, this.f2797a.packageName, this.f2797a.versionCode) == C1828b.UP_TO_DATE);
        finish();
    }
}
