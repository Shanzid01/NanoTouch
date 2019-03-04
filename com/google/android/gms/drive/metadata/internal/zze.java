package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmm;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zze {
    private static Map<String, MetadataField<?>> zzVp = new HashMap();

    static {
        zzb(zzmi.zzVs);
        zzb(zzmi.zzVV);
        zzb(zzmi.zzVM);
        zzb(zzmi.zzVT);
        zzb(zzmi.zzVW);
        zzb(zzmi.zzVE);
        zzb(zzmi.zzVD);
        zzb(zzmi.zzVF);
        zzb(zzmi.zzVB);
        zzb(zzmi.zzVH);
        zzb(zzmi.zzVI);
        zzb(zzmi.zzVJ);
        zzb(zzmi.zzVR);
        zzb(zzmi.zzVt);
        zzb(zzmi.zzVO);
        zzb(zzmi.zzVv);
        zzb(zzmi.zzVC);
        zzb(zzmi.zzVw);
        zzb(zzmi.zzVx);
        zzb(zzmi.zzVy);
        zzb(zzmi.zzVL);
        zzb(zzmi.zzVG);
        zzb(zzmi.zzVN);
        zzb(zzmi.zzVP);
        zzb(zzmi.zzVQ);
        zzb(zzmi.zzVS);
        zzb(zzmi.zzVX);
        zzb(zzmi.zzVY);
        zzb(zzmi.zzVA);
        zzb(zzmi.zzVz);
        zzb(zzmi.zzVU);
        zzb(zzmi.zzVK);
        zzb(zzmi.zzVu);
        zzb(zzmi.zzVZ);
        zzb(zzmi.zzWa);
        zzb(zzmi.zzWb);
        zzb(zzmi.zzWc);
        zzb(zzmi.zzWd);
        zzb(zzmk.zzWe);
        zzb(zzmk.zzWg);
        zzb(zzmk.zzWh);
        zzb(zzmk.zzWi);
        zzb(zzmk.zzWf);
        zzb(zzmm.zzWk);
        zzb(zzmm.zzWl);
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzVp.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        zzVp.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzby(String str) {
        return (MetadataField) zzVp.get(str);
    }

    public static Collection<MetadataField<?>> zzkY() {
        return Collections.unmodifiableCollection(zzVp.values());
    }
}
