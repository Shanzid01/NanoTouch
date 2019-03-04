package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzin.zza;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.zip.CRC32;

public class zzjb implements SafeParcelable {
    public static final zzjc CREATOR = new zzjc();
    final int zzFG;
    final boolean zzGA;
    int zzGB;
    final zzip zzGw;
    final long zzGx;
    final int zzGy;
    final zzin zzGz;
    public final String zzpZ;

    zzjb(int i, zzip com_google_android_gms_internal_zzip, long j, int i2, String str, zzin com_google_android_gms_internal_zzin, boolean z, int i3) {
        this.zzFG = i;
        this.zzGw = com_google_android_gms_internal_zzip;
        this.zzGx = j;
        this.zzGy = i2;
        this.zzpZ = str;
        this.zzGz = com_google_android_gms_internal_zzin;
        this.zzGA = z;
        this.zzGB = i3;
    }

    public zzjb(zzip com_google_android_gms_internal_zzip, long j, int i) {
        this(1, com_google_android_gms_internal_zzip, j, i, null, null, false, -1);
    }

    public zzjb(zzip com_google_android_gms_internal_zzip, long j, int i, String str, zzin com_google_android_gms_internal_zzin, boolean z, int i2) {
        this(1, com_google_android_gms_internal_zzip, j, i, str, com_google_android_gms_internal_zzin, z, i2);
    }

    public zzjb(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list) {
        this(1, zza(str, intent), System.currentTimeMillis(), 0, null, zza(intent, str2, uri, str3, list).zzgU(), false, -1);
    }

    public static zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        zza com_google_android_gms_internal_zzin_zza = new zza();
        com_google_android_gms_internal_zzin_zza.zza(zzaB(str));
        if (uri != null) {
            com_google_android_gms_internal_zzin_zza.zza(zzh(uri));
        }
        if (list != null) {
            com_google_android_gms_internal_zzin_zza.zza(zzd(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_internal_zzin_zza.zza(zzm("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_internal_zzin_zza.zza(zzm("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_internal_zzin_zza.zza(zzm("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_internal_zzin_zza.zza(zzm("intent_extra_data", action));
            }
        }
        return com_google_android_gms_internal_zzin_zza.zzax(str2).zzH(true);
    }

    public static zzip zza(String str, Intent intent) {
        return zzl(str, zzg(intent));
    }

    private static zzir zzaB(String str) {
        return new zzir(str, new zziz.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzW(1).zzJ(true).zzaA("name").zzgX(), "text1");
    }

    private static zzir zzd(List<AppIndexingLink> list) {
        zzwy com_google_android_gms_internal_zzop_zza = new zzop.zza();
        zzop.zza.zza[] com_google_android_gms_internal_zzop_zza_zzaArr = new zzop.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zzop_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zzop_zza_zzaArr[i] = new zzop.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zzop_zza_zzaArr[i].zzalg = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zzop_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zzop_zza_zzaArr[i].zzalh = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zzop_zza.zzale = com_google_android_gms_internal_zzop_zza_zzaArr;
        return new zzir(zzwy.zzf(com_google_android_gms_internal_zzop_zza), new zziz.zza("outlinks").zzI(true).zzaA(".private:outLinks").zzaz("blob").zzgX());
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static zzir zzh(Uri uri) {
        return new zzir(uri.toString(), new zziz.zza("web_url").zzW(4).zzI(true).zzaA("url").zzgX());
    }

    private static zzip zzl(String str, String str2) {
        return new zzip(str, "", str2);
    }

    private static zzir zzm(String str, String str2) {
        return new zzir(str2, new zziz.zza(str).zzI(true).zzgX(), str);
    }

    public int describeContents() {
        zzjc com_google_android_gms_internal_zzjc = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.zzGw, Long.valueOf(this.zzGx), Integer.valueOf(this.zzGy)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzjc com_google_android_gms_internal_zzjc = CREATOR;
        zzjc.zza(this, parcel, i);
    }
}
