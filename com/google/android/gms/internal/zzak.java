package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@zzgi
public class zzak {
    private final int zznW;
    private final int zznX;
    private final int zznY;
    private final zzap zznZ;
    private final Object zznh = new Object();
    private ArrayList<String> zzoa = new ArrayList();
    private int zzob = 0;
    private int zzoc = 0;
    private int zzod = 0;
    private int zzoe;
    private String zzof = "";

    public zzak(int i, int i2, int i3, int i4) {
        this.zznW = i;
        this.zznX = i2;
        this.zznY = i3;
        this.zznZ = new zzap(i4);
    }

    private String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void zzj(String str) {
        if (str != null && str.length() >= this.zznY) {
            synchronized (this.zznh) {
                this.zzoa.add(str);
                this.zzob += str.length();
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzak)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzak com_google_android_gms_internal_zzak = (zzak) obj;
        return com_google_android_gms_internal_zzak.zzbm() != null && com_google_android_gms_internal_zzak.zzbm().equals(zzbm());
    }

    public int getScore() {
        return this.zzoe;
    }

    public int hashCode() {
        return zzbm().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.zzoc + " score:" + this.zzoe + " total_length:" + this.zzob + "\n text: " + zza(this.zzoa, 200) + "\n signture: " + this.zzof;
    }

    int zza(int i, int i2) {
        return (this.zznW * i) + (this.zznX * i2);
    }

    public boolean zzbl() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzod == 0;
        }
        return z;
    }

    public String zzbm() {
        return this.zzof;
    }

    public void zzbn() {
        synchronized (this.zznh) {
            this.zzoe -= 100;
        }
    }

    public void zzbo() {
        synchronized (this.zznh) {
            this.zzod--;
        }
    }

    public void zzbp() {
        synchronized (this.zznh) {
            this.zzod++;
        }
    }

    public void zzbq() {
        synchronized (this.zznh) {
            int zza = zza(this.zzob, this.zzoc);
            if (zza > this.zzoe) {
                this.zzoe = zza;
                this.zzof = this.zznZ.zza(this.zzoa);
            }
        }
    }

    int zzbr() {
        return this.zzob;
    }

    public void zzc(int i) {
        this.zzoc = i;
    }

    public void zzh(String str) {
        zzj(str);
        synchronized (this.zznh) {
            if (this.zzod < 0) {
                zzhx.zzY("ActivityContent: negative number of WebViews.");
            }
            zzbq();
        }
    }

    public void zzi(String str) {
        zzj(str);
    }
}
