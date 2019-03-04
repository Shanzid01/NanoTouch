package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzc.zzf;
import com.google.android.gms.internal.zzvd.zza;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.internal.zzwx;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcm implements zzf {
    private final Context mContext;
    private final String zzaxw;
    private zzbe<zza> zzazN;
    private final ExecutorService zzazT = Executors.newSingleThreadExecutor();

    class C14201 implements Runnable {
        final /* synthetic */ zzcm zzazU;

        C14201(zzcm com_google_android_gms_tagmanager_zzcm) {
            this.zzazU = com_google_android_gms_tagmanager_zzcm;
        }

        public void run() {
            this.zzazU.zztF();
        }
    }

    zzcm(Context context, String str) {
        this.mContext = context;
        this.zzaxw = str;
    }

    private zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        zzc com_google_android_gms_internal_zzvl_zzc = null;
        try {
            com_google_android_gms_internal_zzvl_zzc = zzay.zzdd(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbf.zzY("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        } catch (JSONException e2) {
            zzbf.zzac("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return com_google_android_gms_internal_zzvl_zzc;
    }

    private void zzd(zza com_google_android_gms_internal_zzvd_zza) {
        if (com_google_android_gms_internal_zzvd_zza.zzgs == null && com_google_android_gms_internal_zzvd_zza.zzaBL == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzc zzl(byte[] bArr) {
        try {
            zzc zzb = zzvl.zzb(zzf.zza(bArr));
            if (zzb == null) {
                return zzb;
            }
            zzbf.zzab("The container was successfully loaded from the resource (using binary file)");
            return zzb;
        } catch (zzwx e) {
            zzbf.zzZ("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzg e2) {
            zzbf.zzac("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    public synchronized void release() {
        this.zzazT.shutdown();
    }

    public void zza(zzbe<zza> com_google_android_gms_tagmanager_zzbe_com_google_android_gms_internal_zzvd_zza) {
        this.zzazN = com_google_android_gms_tagmanager_zzbe_com_google_android_gms_internal_zzvd_zza;
    }

    public void zzb(final zza com_google_android_gms_internal_zzvd_zza) {
        this.zzazT.execute(new Runnable(this) {
            final /* synthetic */ zzcm zzazU;

            public void run() {
                this.zzazU.zzc(com_google_android_gms_internal_zzvd_zza);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean zzc(com.google.android.gms.internal.zzvd.zza r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.zztG();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.zzwy.zzf(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r0 = 1;
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.zzbf.zzZ(r1);
        goto L_0x0015;
    L_0x001d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r1);
        goto L_0x0015;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.zzbf.zzac(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcm.zzc(com.google.android.gms.internal.zzvd$zza):boolean");
    }

    public zzc zzhc(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            zzbf.zzab("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzvl.zzc(openRawResource, byteArrayOutputStream);
                zzc zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzl(byteArrayOutputStream.toByteArray());
                }
                zzbf.zzab("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException e) {
                zzbf.zzac("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (NotFoundException e2) {
            zzbf.zzac("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    public void zzsS() {
        this.zzazT.execute(new C14201(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zztF() {
        /*
        r3 = this;
        r0 = r3.zzazN;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "Callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.zzazN;
        r0.zzsR();
        r0 = "Attempting to load resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzab(r0);
        r0 = com.google.android.gms.tagmanager.zzca.zztx();
        r0 = r0.zzty();
        r1 = com.google.android.gms.tagmanager.zzca.zza.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.zzca.zztx();
        r0 = r0.zzty();
        r1 = com.google.android.gms.tagmanager.zzca.zza.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.zzaxw;
        r1 = com.google.android.gms.tagmanager.zzca.zztx();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.zzazN;
        r1 = com.google.android.gms.tagmanager.zzbe.zza.NOT_AVAILABLE;
        r0.zza(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = r3.zztG();	 Catch:{ FileNotFoundException -> 0x0070 }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0.<init>();	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        com.google.android.gms.internal.zzvl.zzc(r1, r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0 = com.google.android.gms.internal.zzvd.zza.zzm(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r3.zzd(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r2 = r3.zzazN;	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r2.zzo(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r1.close();	 Catch:{ IOException -> 0x007e }
    L_0x006a:
        r0 = "The Disk resource was successfully read.";
        com.google.android.gms.tagmanager.zzbf.zzab(r0);
        goto L_0x0045;
    L_0x0070:
        r0 = move-exception;
        r0 = "Failed to find the resource in the disk";
        com.google.android.gms.tagmanager.zzbf.zzY(r0);
        r0 = r3.zzazN;
        r1 = com.google.android.gms.tagmanager.zzbe.zza.NOT_AVAILABLE;
        r0.zza(r1);
        goto L_0x0045;
    L_0x007e:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r0);
        goto L_0x006a;
    L_0x0085:
        r0 = move-exception;
        r0 = r3.zzazN;	 Catch:{ all -> 0x00b5 }
        r2 = com.google.android.gms.tagmanager.zzbe.zza.IO_ERROR;	 Catch:{ all -> 0x00b5 }
        r0.zza(r2);	 Catch:{ all -> 0x00b5 }
        r0 = "Failed to read the resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r0);	 Catch:{ all -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x006a;
    L_0x0096:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r0);
        goto L_0x006a;
    L_0x009d:
        r0 = move-exception;
        r0 = r3.zzazN;	 Catch:{ all -> 0x00b5 }
        r2 = com.google.android.gms.tagmanager.zzbe.zza.IO_ERROR;	 Catch:{ all -> 0x00b5 }
        r0.zza(r2);	 Catch:{ all -> 0x00b5 }
        r0 = "Failed to read the resource from disk. The resource is inconsistent";
        com.google.android.gms.tagmanager.zzbf.zzac(r0);	 Catch:{ all -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x00ae }
        goto L_0x006a;
    L_0x00ae:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r0);
        goto L_0x006a;
    L_0x00b5:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00ba }
    L_0x00b9:
        throw r0;
    L_0x00ba:
        r1 = move-exception;
        r1 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.zzbf.zzac(r1);
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcm.zztF():void");
    }

    File zztG() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzaxw);
    }
}
