package com.slideme.sam.manager.model.p061a;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.SamUpdateActivity;
import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.net.wrappers.C1892h;
import java.io.File;

/* compiled from: SAMUpdateManager */
public class C1818f {
    private Context f3253a;
    private SharedPreferences f3254b;
    private C1822j f3255c = C1822j.IDLE;

    public C1818f(Context context) {
        this.f3253a = context;
        this.f3254b = context.getSharedPreferences("update_pref", 0);
    }

    public C1822j m5465a() {
        return this.f3255c;
    }

    public void m5466a(float f) {
        this.f3254b.edit().putFloat("current_version", f).commit();
    }

    public void m5467b() {
        if (!this.f3253a.getResources().getBoolean(R.bool.disableSAMUpdates)) {
            String string = this.f3253a.getString(R.string.sam_version_num);
            this.f3255c = C1822j.START;
            SAM.f2614g.m5616a(new C1819g(this, string));
        }
    }

    private void m5460b(float f) {
        new C1820h().execute(new Float[]{Float.valueOf(f)});
    }

    private void m5462c() {
        this.f3255c = C1822j.UPDATE;
        C0090q.m145a(this.f3253a).m150a(new Intent("com.slideme.sam.manager.ACTION_NOTIFICATION_BANNER_REFRESH"));
        ((NotificationManager) this.f3253a.getSystemService("notification")).notify(0, C1704f.m5070a(this.f3253a));
    }

    private void m5464d() {
        this.f3255c = C1822j.INSTALL;
        C0090q.m145a(this.f3253a).m150a(new Intent("com.slideme.sam.manager.ACTION_NOTIFICATION_BANNER_REFRESH"));
        ((NotificationManager) this.f3253a.getSystemService("notification")).notify(0, C1704f.m5076b(this.f3253a));
    }

    @SuppressLint({"InlinedApi"})
    public static Intent m5456a(Context context) {
        Intent intent = new Intent(context, SamUpdateActivity.class);
        intent.setFlags(1350598656);
        return intent;
    }

    @SuppressLint({"InlinedApi"})
    public static Intent m5459b(Context context) {
        File file = new File(C1892h.m5700a(context), "SAM.apk");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(1350598656);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        return intent;
    }
}
