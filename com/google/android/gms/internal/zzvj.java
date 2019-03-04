package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class zzvj {
    private final List<zzve> zzaBY = new ArrayList();

    public String getId() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (zzve com_google_android_gms_internal_zzve : this.zzaBY) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("#");
            }
            stringBuilder.append(com_google_android_gms_internal_zzve.getContainerId());
        }
        return stringBuilder.toString();
    }

    public zzvj zzb(zzve com_google_android_gms_internal_zzve) {
        zzx.zzl(com_google_android_gms_internal_zzve);
        for (zzve containerId : this.zzaBY) {
            if (containerId.getContainerId().equals(com_google_android_gms_internal_zzve.getContainerId())) {
                throw new IllegalArgumentException("The container is already being requested. " + com_google_android_gms_internal_zzve.getContainerId());
            }
        }
        this.zzaBY.add(com_google_android_gms_internal_zzve);
        return this;
    }

    public List<zzve> zzun() {
        return this.zzaBY;
    }
}
