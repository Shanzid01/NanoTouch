package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;

public class zzve {
    private final Integer zzaBM;
    private final String zzaBN;
    private final boolean zzaBO;
    private final String zzaxw;
    private final String zzazP;

    public zzve(String str, Integer num, String str2, boolean z) {
        this(str, num, str2, z, "");
    }

    public zzve(String str, Integer num, String str2, boolean z, String str3) {
        zzx.zzl(str);
        zzx.zzl(str3);
        this.zzaxw = str;
        this.zzaBM = num;
        this.zzaBN = str2;
        this.zzaBO = z;
        this.zzazP = str3;
    }

    public String getContainerId() {
        return this.zzaxw;
    }

    public Integer zzuh() {
        return this.zzaBM;
    }

    public String zzui() {
        return this.zzaBN;
    }

    public String zzuj() {
        return this.zzaBN != null ? this.zzaBN + "_" + this.zzaxw : this.zzaxw;
    }

    public boolean zzuk() {
        return this.zzaBO;
    }

    public String zzul() {
        return this.zzazP;
    }
}
