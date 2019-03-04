package com.slideme.sam.manager.inapp.openiab;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.vendor.DeveloperDetailsActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.response.InAppListResponse;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import org.p059a.p060a.C1804b;

/* compiled from: OpenIabStoreService */
class C1805b extends C1804b {
    final /* synthetic */ OpenIabStoreService f3238a;

    private C1805b(OpenIabStoreService openIabStoreService) {
        this.f3238a = openIabStoreService;
    }

    public String mo4285a() {
        return "SlideME";
    }

    public boolean mo4286a(String str) {
        String installerPackageName = this.f3238a.getPackageManager().getInstallerPackageName(str);
        return installerPackageName != null && installerPackageName.equals(this.f3238a.getPackageName());
    }

    public boolean mo4288b(String str) {
        if (mo4286a(str)) {
            return true;
        }
        InAppListResponse a = SAM.f2614g.m5593a(3, new ArrayList(), str);
        if (a == null || C1922m.m5794a(a.products)) {
            return false;
        }
        return true;
    }

    public int mo4289c(String str) {
        C1891a c1891a = new C1891a(str, true, ((SAM) this.f3238a.getApplication()).m4780d());
        c1891a.m5698b();
        if (c1891a == null || C1922m.m5794a(c1891a.m5697a())) {
            return 0;
        }
        return ((Application) c1891a.m5697a().get(0)).versionCode;
    }

    public Intent mo4287b() {
        return new Intent("org.onepf.oms.billing.BIND");
    }

    public Intent mo4291d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Valid packageName is required");
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sam://details?id=" + str));
        return intent;
    }

    public Intent mo4292e(String str) {
        return mo4291d(str);
    }

    public Intent mo4293f(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Valid packageName is required");
        }
        Intent intent = new Intent(this.f3238a, DeveloperDetailsActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_PACKAGE_NAME", str);
        return intent;
    }

    public boolean mo4290c() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
