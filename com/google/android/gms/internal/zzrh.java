package com.google.android.gms.internal;

import android.support.v4.p004b.C0059a;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import java.util.UUID;

public final class zzrh extends zzqy<zzrh> {
    private String zzasq;
    private int zzasr;
    private int zzass;
    private String zzast;
    private String zzasu;
    private boolean zzasv;
    private boolean zzasw;
    private boolean zzasx;

    public zzrh() {
        this(false);
    }

    public zzrh(boolean z) {
        this(z, zzrd());
    }

    public zzrh(boolean z, int i) {
        zzx.zzaL(i);
        this.zzasr = i;
        this.zzasw = z;
    }

    static int zzrd() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("com.google.android.gms.measurement.data.ScreenViewInfo", "UUID.randomUUID() returned 0.");
        return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    private void zzrj() {
        if (this.zzasx) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public boolean isMutable() {
        return !this.zzasx;
    }

    public void setScreenName(String str) {
        zzrj();
        this.zzasq = str;
    }

    public String toString() {
        Map c0059a = new C0059a();
        c0059a.put("screenName", this.zzasq);
        c0059a.put("interstitial", Boolean.valueOf(this.zzasv));
        c0059a.put("automatic", Boolean.valueOf(this.zzasw));
        c0059a.put("screenId", Integer.valueOf(this.zzasr));
        c0059a.put("referrerScreenId", Integer.valueOf(this.zzass));
        c0059a.put("referrerScreenName", this.zzast);
        c0059a.put("referrerUri", this.zzasu);
        return zzqy.zzG(c0059a);
    }

    public int zzaF() {
        return this.zzasr;
    }

    public void zzaa(boolean z) {
        zzrj();
        this.zzasv = z;
    }

    public void zzcv(String str) {
        zzrj();
        this.zzast = str;
    }

    public void zzgr(int i) {
        zzrj();
        this.zzass = i;
    }

    public String zzre() {
        return this.zzasq;
    }

    public int zzrf() {
        return this.zzass;
    }

    public String zzrg() {
        return this.zzast;
    }

    public void zzrh() {
        this.zzasx = true;
    }

    public boolean zzri() {
        return this.zzasv;
    }
}
