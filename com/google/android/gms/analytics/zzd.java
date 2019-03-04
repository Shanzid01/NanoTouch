package com.google.android.gms.analytics;

import android.util.Pair;
import com.google.android.gms.internal.zzik;
import java.util.Collection;
import java.util.Map;

interface zzd {
    void dispatch();

    void setDryRun(boolean z);

    void zza(Map<String, String> map, long j, String str, Collection<zzik> collection);

    zzr zzff();

    Pair<Long, Long> zzfg();

    void zzl(long j);
}
