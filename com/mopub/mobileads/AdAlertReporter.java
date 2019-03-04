package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.p050b.C1479b;
import com.mopub.mobileads.util.C1555a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdAlertReporter {
    private final String f2215a = new SimpleDateFormat("M/d/yy hh:mm:ss a z").format(C1479b.m4052b());
    private final View f2216b;
    private final Context f2217c;
    private final AdConfiguration f2218d;
    private Intent f2219e;
    private ArrayList<Uri> f2220f = new ArrayList();
    private String f2221g;
    private String f2222h;

    public AdAlertReporter(Context context, View view, AdConfiguration adConfiguration) {
        this.f2216b = view;
        this.f2217c = context;
        this.f2218d = adConfiguration;
        m4175b();
        Bitmap c = m4176c();
        String a = m4170a(c);
        this.f2221g = m4177d();
        this.f2222h = m4178e();
        m4179f();
        m4174a(this.f2221g, this.f2222h, a);
        m4172a("mp_adalert_parameters.txt", this.f2221g);
        m4172a("mp_adalert_markup.html", this.f2222h);
        m4171a("mp_adalert_screenshot.png", c);
    }

    public void m4180a() {
        this.f2219e.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f2220f);
        Intent createChooser = Intent.createChooser(this.f2219e, "Send Email...");
        createChooser.addFlags(DriveFile.MODE_READ_ONLY);
        this.f2217c.startActivity(createChooser);
    }

    private void m4175b() {
        this.f2219e = new Intent("android.intent.action.SEND_MULTIPLE", Uri.parse("mailto:"));
        this.f2219e.setType("plain/text");
        this.f2219e.putExtra("android.intent.extra.EMAIL", new String[]{"creative-review@mopub.com"});
    }

    private Bitmap m4176c() {
        if (this.f2216b == null || this.f2216b.getRootView() == null) {
            return null;
        }
        View rootView = this.f2216b.getRootView();
        boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        rootView.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    private String m4170a(Bitmap bitmap) {
        String str = null;
        if (bitmap != null) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.JPEG, 25, byteArrayOutputStream);
                str = C1555a.m4657a(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception e) {
            }
        }
        return str;
    }

    private String m4177d() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f2218d != null) {
            m4173a(stringBuilder, "sdk_version", this.f2218d.m4209v());
            m4173a(stringBuilder, "creative_id", this.f2218d.m4202o());
            m4173a(stringBuilder, "platform_version", Integer.toString(this.f2218d.m4207t()));
            m4173a(stringBuilder, "device_model", this.f2218d.m4206s());
            m4173a(stringBuilder, "ad_unit_id", this.f2218d.m4187b());
            m4173a(stringBuilder, "device_locale", this.f2218d.m4205r());
            m4173a(stringBuilder, "device_id", this.f2218d.m4203p());
            m4173a(stringBuilder, "network_type", this.f2218d.m4193f());
            m4173a(stringBuilder, "platform", this.f2218d.m4208u());
            m4173a(stringBuilder, "timestamp", m4169a(this.f2218d.m4197j()));
            m4173a(stringBuilder, "ad_type", this.f2218d.m4192e());
            m4173a(stringBuilder, "ad_size", "{" + this.f2218d.m4198k() + ", " + this.f2218d.m4199l() + "}");
        }
        return stringBuilder.toString();
    }

    private String m4178e() {
        return this.f2218d != null ? this.f2218d.m4189c() : "";
    }

    private void m4173a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str);
        stringBuilder.append(" : ");
        stringBuilder.append(str2);
        stringBuilder.append("\n");
    }

    private void m4179f() {
        this.f2219e.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.f2215a);
    }

    private void m4174a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(strArr[i]);
            if (i != strArr.length - 1) {
                stringBuilder.append("\n=================\n");
            }
        }
        this.f2219e.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4171a(java.lang.String r6, android.graphics.Bitmap r7) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0005;
    L_0x0003:
        if (r7 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r1 = r5.f2217c;	 Catch:{ Exception -> 0x0043, all -> 0x005c }
        r2 = 1;
        r0 = r1.openFileOutput(r6, r2);	 Catch:{ Exception -> 0x0043, all -> 0x005c }
        r1 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x0043 }
        r2 = 25;
        r7.compress(r1, r2, r0);	 Catch:{ Exception -> 0x0043 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
        r2.<init>();	 Catch:{ Exception -> 0x0043 }
        r3 = r5.f2217c;	 Catch:{ Exception -> 0x0043 }
        r3 = r3.getFilesDir();	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r6);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0043 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0043 }
        r1 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x0043 }
        r2 = r5.f2220f;	 Catch:{ Exception -> 0x0043 }
        r2.add(r1);	 Catch:{ Exception -> 0x0043 }
        com.mopub.common.p050b.C1490m.m4085a(r0);
        goto L_0x0005;
    L_0x0043:
        r1 = move-exception;
        r1 = "MoPub";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0064 }
        r3 = "Unable to write text attachment to file: ";
        r2.<init>(r3);	 Catch:{ all -> 0x0064 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0064 }
        r2 = r2.toString();	 Catch:{ all -> 0x0064 }
        android.util.Log.d(r1, r2);	 Catch:{ all -> 0x0064 }
        com.mopub.common.p050b.C1490m.m4085a(r0);
        goto L_0x0005;
    L_0x005c:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0060:
        com.mopub.common.p050b.C1490m.m4085a(r1);
        throw r0;
    L_0x0064:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdAlertReporter.a(java.lang.String, android.graphics.Bitmap):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4172a(java.lang.String r6, java.lang.String r7) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0005;
    L_0x0003:
        if (r7 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r1 = r5.f2217c;	 Catch:{ Exception -> 0x0043, all -> 0x005c }
        r2 = 1;
        r0 = r1.openFileOutput(r6, r2);	 Catch:{ Exception -> 0x0043, all -> 0x005c }
        r1 = r7.getBytes();	 Catch:{ Exception -> 0x0043 }
        r0.write(r1);	 Catch:{ Exception -> 0x0043 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
        r2.<init>();	 Catch:{ Exception -> 0x0043 }
        r3 = r5.f2217c;	 Catch:{ Exception -> 0x0043 }
        r3 = r3.getFilesDir();	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r3 = java.io.File.separator;	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.append(r6);	 Catch:{ Exception -> 0x0043 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0043 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0043 }
        r1 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x0043 }
        r2 = r5.f2220f;	 Catch:{ Exception -> 0x0043 }
        r2.add(r1);	 Catch:{ Exception -> 0x0043 }
        com.mopub.common.p050b.C1490m.m4085a(r0);
        goto L_0x0005;
    L_0x0043:
        r1 = move-exception;
        r1 = "MoPub";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0064 }
        r3 = "Unable to write text attachment to file: ";
        r2.<init>(r3);	 Catch:{ all -> 0x0064 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0064 }
        r2 = r2.toString();	 Catch:{ all -> 0x0064 }
        android.util.Log.d(r1, r2);	 Catch:{ all -> 0x0064 }
        com.mopub.common.p050b.C1490m.m4085a(r0);
        goto L_0x0005;
    L_0x005c:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0060:
        com.mopub.common.p050b.C1490m.m4085a(r1);
        throw r0;
    L_0x0064:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdAlertReporter.a(java.lang.String, java.lang.String):void");
    }

    private String m4169a(long j) {
        if (j != -1) {
            return new SimpleDateFormat("M/d/yy hh:mm:ss a z").format(new Date(j));
        }
        return null;
    }
}
