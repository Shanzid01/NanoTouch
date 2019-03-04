package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.tagmanager.zzbf;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzvn {
    public static final Integer zzaCx = Integer.valueOf(0);
    public static final Integer zzaCy = Integer.valueOf(1);
    private final Context mContext;
    private final ExecutorService zzazT;

    public zzvn(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzvn(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzazT = executorService;
    }

    private String zzdF(String str) {
        return "resource_" + str;
    }

    private byte[] zzf(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzlz.zza(inputStream, byteArrayOutputStream);
        } catch (IOException e) {
            zzbf.zzac("Failed to read the resource from disk");
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                zzbf.zzac("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void zza(String str, Integer num, zzvh com_google_android_gms_internal_zzvh, zzvm com_google_android_gms_internal_zzvm) {
        final String str2 = str;
        final Integer num2 = num;
        final zzvh com_google_android_gms_internal_zzvh2 = com_google_android_gms_internal_zzvh;
        final zzvm com_google_android_gms_internal_zzvm2 = com_google_android_gms_internal_zzvm;
        this.zzazT.execute(new Runnable(this) {
            final /* synthetic */ zzvn zzaCD;

            public void run() {
                this.zzaCD.zzb(str2, num2, com_google_android_gms_internal_zzvh2, com_google_android_gms_internal_zzvm2);
            }
        });
    }

    void zzb(String str, Integer num, zzvh com_google_android_gms_internal_zzvh, zzvm com_google_android_gms_internal_zzvm) {
        Object zzn;
        zzbf.zzab("DiskLoader: Starting to load resource from Disk.");
        try {
            zzn = com_google_android_gms_internal_zzvh.zzn(zzf(new FileInputStream(zzdE(str))));
            if (zzn != null) {
                zzbf.zzab("Saved resource loaded: " + zzdF(str));
                com_google_android_gms_internal_zzvm.zza(Status.zzNo, zzn, zzaCy, zzdD(str));
                return;
            }
        } catch (FileNotFoundException e) {
            zzbf.zzZ("Saved resource not found: " + zzdF(str));
        } catch (zzg e2) {
            zzbf.zzZ("Saved resource is corrupted: " + zzdF(str));
        }
        if (num == null) {
            com_google_android_gms_internal_zzvm.zza(Status.zzNq, null, null, 0);
            return;
        }
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(num.intValue());
            if (openRawResource != null) {
                zzn = com_google_android_gms_internal_zzvh.zzn(zzf(openRawResource));
                if (zzn != null) {
                    zzbf.zzab("Default resource loaded: " + this.mContext.getResources().getResourceEntryName(num.intValue()));
                    com_google_android_gms_internal_zzvm.zza(Status.zzNo, zzn, zzaCx, 0);
                    return;
                }
            }
        } catch (NotFoundException e3) {
            zzbf.zzZ("Default resource not found. ID: " + num);
        } catch (zzg e4) {
            zzbf.zzZ("Default resource resource is corrupted: " + num);
        }
        com_google_android_gms_internal_zzvm.zza(Status.zzNq, null, null, 0);
    }

    public long zzdD(String str) {
        File zzdE = zzdE(str);
        return zzdE.exists() ? zzdE.lastModified() : 0;
    }

    File zzdE(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzdF(str));
    }

    public void zzf(final String str, final byte[] bArr) {
        this.zzazT.execute(new Runnable(this) {
            final /* synthetic */ zzvn zzaCD;

            public void run() {
                this.zzaCD.zzg(str, bArr);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zzg(java.lang.String r4, byte[] r5) {
        /*
        r3 = this;
        r0 = r3.zzdE(r4);
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x002c }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x002c }
        r1.write(r5);	 Catch:{ IOException -> 0x003a }
        r1.close();	 Catch:{ IOException -> 0x0033 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0033 }
        r0.<init>();	 Catch:{ IOException -> 0x0033 }
        r1 = "Resource ";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0033 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x0033 }
        r1 = " saved on Disk.";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0033 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0033 }
        com.google.android.gms.tagmanager.zzbf.zzab(r0);	 Catch:{ IOException -> 0x0033 }
    L_0x002b:
        return;
    L_0x002c:
        r0 = move-exception;
        r0 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.zzbf.zzZ(r0);
        goto L_0x002b;
    L_0x0033:
        r0 = move-exception;
        r0 = "Error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbf.zzZ(r0);
        goto L_0x002b;
    L_0x003a:
        r2 = move-exception;
        r2 = "Error writing resource to disk. Removing resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzZ(r2);	 Catch:{ all -> 0x006a }
        r0.delete();	 Catch:{ all -> 0x006a }
        r1.close();	 Catch:{ IOException -> 0x0063 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0063 }
        r0.<init>();	 Catch:{ IOException -> 0x0063 }
        r1 = "Resource ";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0063 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x0063 }
        r1 = " saved on Disk.";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0063 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0063 }
        com.google.android.gms.tagmanager.zzbf.zzab(r0);	 Catch:{ IOException -> 0x0063 }
        goto L_0x002b;
    L_0x0063:
        r0 = move-exception;
        r0 = "Error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbf.zzZ(r0);
        goto L_0x002b;
    L_0x006a:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x008b }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x008b }
        r1.<init>();	 Catch:{ IOException -> 0x008b }
        r2 = "Resource ";
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x008b }
        r1 = r1.append(r4);	 Catch:{ IOException -> 0x008b }
        r2 = " saved on Disk.";
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x008b }
        r1 = r1.toString();	 Catch:{ IOException -> 0x008b }
        com.google.android.gms.tagmanager.zzbf.zzab(r1);	 Catch:{ IOException -> 0x008b }
    L_0x008a:
        throw r0;
    L_0x008b:
        r1 = move-exception;
        r1 = "Error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbf.zzZ(r1);
        goto L_0x008a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzvn.zzg(java.lang.String, byte[]):void");
    }
}
