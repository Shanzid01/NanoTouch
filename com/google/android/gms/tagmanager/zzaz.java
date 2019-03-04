package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.zzl.zza;

class zzaz<K, V> implements zzk<K, V> {
    private LruCache<K, V> zzazc;

    zzaz(int i, final zza<K, V> com_google_android_gms_tagmanager_zzl_zza_K__V) {
        this.zzazc = new LruCache<K, V>(this, i) {
            final /* synthetic */ zzaz zzaze;

            protected int sizeOf(K k, V v) {
                return com_google_android_gms_tagmanager_zzl_zza_K__V.sizeOf(k, v);
            }
        };
    }

    public V get(K k) {
        return this.zzazc.get(k);
    }

    public void zze(K k, V v) {
        this.zzazc.put(k, v);
    }
}
