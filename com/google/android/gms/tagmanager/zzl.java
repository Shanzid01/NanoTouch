package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzl<K, V> {
    final zza<K, V> zzaxu = new C14311(this);

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    class C14311 implements zza<K, V> {
        final /* synthetic */ zzl zzaxv;

        C14311(zzl com_google_android_gms_tagmanager_zzl) {
            this.zzaxv = com_google_android_gms_tagmanager_zzl;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public zzk<K, V> zza(int i, zza<K, V> com_google_android_gms_tagmanager_zzl_zza_K__V) {
        if (i > 0) {
            return zzsF() < 12 ? new zzcv(i, com_google_android_gms_tagmanager_zzl_zza_K__V) : new zzaz(i, com_google_android_gms_tagmanager_zzl_zza_K__V);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int zzsF() {
        return VERSION.SDK_INT;
    }
}
