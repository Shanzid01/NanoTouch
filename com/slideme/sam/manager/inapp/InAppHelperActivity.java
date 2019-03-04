package com.slideme.sam.manager.inapp;

import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import java.util.List;

public abstract class InAppHelperActivity extends FragmentActivity implements LoaderCallbacks<Bundle> {
    private boolean f3181a = false;
    private PackageInfo f3182b;
    private ServiceConnection f3183c = new C1788e(this);
    private C1785b f3184d;
    private boolean f3185e = false;
    private Bundle f3186f;
    private Bundle f3187g;

    protected abstract void m5325a();

    private boolean m5324b() {
        return this.f3182b != null && Float.parseFloat(this.f3182b.versionName) > 6.0f;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f3182b = (PackageInfo) bundle.getParcelable("SAM_PACKAGE_INFO");
        }
        if (this.f3182b == null) {
            List<PackageInfo> installedPackages = getPackageManager().getInstalledPackages(0);
            if (installedPackages != null) {
                for (PackageInfo packageInfo : installedPackages) {
                    if (packageInfo.packageName.equals("com.slideme.sam.manager")) {
                        this.f3182b = packageInfo;
                        break;
                    }
                }
            }
        }
        if (m5324b()) {
            bindService(new Intent("com.slideme.sam.manager.inapp.InAppService.BIND"), this.f3183c, 1);
        } else {
            boolean z;
            if (this.f3182b != null) {
                z = true;
            } else {
                z = false;
            }
            C1795l.m5373a(this, z).show();
        }
        if (bundle != null) {
            this.f3186f = bundle.getBundle("list_result");
            this.f3187g = bundle.getBundle("purchases_list_result");
        }
    }

    protected void onDestroy() {
        if (this.f3181a) {
            unbindService(this.f3183c);
        }
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("list_result", this.f3186f);
        bundle.putBundle("purchases_list_state", this.f3187g);
        bundle.putParcelable("SAM_PACKAGE_INFO", this.f3182b);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                Bundle bundle;
                if (intent == null || intent.getExtras() == null) {
                    bundle = new Bundle();
                    bundle.putInt("com.slideme.sam.manager.inapp.BUNDLE_STATUS", 4);
                } else {
                    bundle = intent.getBundleExtra("com.slideme.sam.manager.inapp.extra.RESPONSE");
                }
                m5326a(new PurchaseResult(bundle));
                return;
            default:
                return;
        }
    }

    protected void m5326a(PurchaseResult purchaseResult) {
    }
}
