package com.slideme.sam.manager.controller.activities;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;
import com.slideme.sam.manager.controller.p055b.C1705g;
import com.slideme.sam.manager.model.p054b.C1829c;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.util.p063a.C1909c;
import com.slideme.sam.manager.view.C1950a;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AboutActivity extends CommonActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_about);
        ((TextView) findViewById(R.id.partner)).setText(((SAM) getApplication()).m4780d());
        ((TextView) findViewById(R.id.manuValue)).setText(C1829c.m5503e());
        ((TextView) findViewById(R.id.modelValue)).setText(C1829c.m5499a());
        ((TextView) findViewById(R.id.apiValue)).setText(Integer.toString(C1829c.m5504f()));
        try {
            String a = C1913d.m5757a((Context) this);
            if (TextUtils.isEmpty(a)) {
                ((TextView) findViewById(R.id.deviceIdValue)).setVisibility(8);
                ((TextView) findViewById(R.id.deviceIdTitle)).setVisibility(8);
            } else {
                ((TextView) findViewById(R.id.deviceIdValue)).setText(a.substring(0, a.indexOf("-")));
            }
            ((TextView) findViewById(R.id.aidValue)).setText(Secure.getString(getContentResolver(), "android_id"));
            String str = "";
            ((TextView) findViewById(R.id.didValue)).setText(((WifiManager) getSystemService("wifi")).getConnectionInfo().getMacAddress());
        } catch (Exception e) {
        }
        ((TextView) findViewById(R.id.dpiValue)).setText(C1705g.m5079b(this, getResources()));
        String[] a2 = C1705g.m5078a(this, getResources());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a2[0]);
        stringBuilder.append("x");
        stringBuilder.append(a2[1]);
        ((TextView) findViewById(R.id.resValue)).setText(stringBuilder.toString());
        View findViewById = findViewById(R.id.support);
        if (AuthData.m4808d(this)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setOnClickListener(new C1636a(this));
        }
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        StringBuilder stringBuilder2 = new StringBuilder();
        if (VERSION.SDK_INT >= 16) {
            long a3 = C1909c.m5751a(memoryInfo);
            stringBuilder2.append(a3 > 0 ? C1950a.m5858a(a3) : "--");
        } else {
            stringBuilder2.append(m4894b() > 0 ? C1950a.m5858a(m4894b()) : "--");
        }
        stringBuilder2.append(" (");
        stringBuilder2.append(C1950a.m5858a((long) (activityManager.getMemoryClass() * 1048576)));
        stringBuilder2.append(")");
        ((TextView) findViewById(R.id.ramValue)).setText(stringBuilder2.toString());
    }

    private long m4894b() {
        String str;
        Throwable e;
        String str2 = "";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
            do {
                str2 = randomAccessFile.readLine();
                if (str2 == null) {
                    str = str2;
                    break;
                }
            } while (!str2.startsWith("MemTotal"));
            String[] split = str2.split(" ");
            str = split[split.length - 2];
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e = e2;
                C1922m.m5791a(e);
                return Long.parseLong(str) * 1024;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            str = str2;
            e = th;
        }
        return Long.parseLong(str) * 1024;
    }
}
