package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgi
public class zzal {
    private final Object zznh = new Object();
    private int zzog;
    private List<zzak> zzoh = new LinkedList();

    public boolean zza(zzak com_google_android_gms_internal_zzak) {
        boolean z;
        synchronized (this.zznh) {
            if (this.zzoh.contains(com_google_android_gms_internal_zzak)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzb(zzak com_google_android_gms_internal_zzak) {
        boolean z;
        synchronized (this.zznh) {
            Iterator it = this.zzoh.iterator();
            while (it.hasNext()) {
                zzak com_google_android_gms_internal_zzak2 = (zzak) it.next();
                if (com_google_android_gms_internal_zzak != com_google_android_gms_internal_zzak2 && com_google_android_gms_internal_zzak2.zzbm().equals(com_google_android_gms_internal_zzak.zzbm())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public zzak zzbs() {
        zzak com_google_android_gms_internal_zzak = null;
        synchronized (this.zznh) {
            if (this.zzoh.size() == 0) {
                zzhx.zzY("Queue empty");
                return null;
            } else if (this.zzoh.size() >= 2) {
                int i = Integer.MIN_VALUE;
                for (zzak com_google_android_gms_internal_zzak2 : this.zzoh) {
                    zzak com_google_android_gms_internal_zzak3;
                    int i2;
                    int score = com_google_android_gms_internal_zzak2.getScore();
                    if (score > i) {
                        int i3 = score;
                        com_google_android_gms_internal_zzak3 = com_google_android_gms_internal_zzak2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        com_google_android_gms_internal_zzak3 = com_google_android_gms_internal_zzak;
                    }
                    i = i2;
                    com_google_android_gms_internal_zzak = com_google_android_gms_internal_zzak3;
                }
                this.zzoh.remove(com_google_android_gms_internal_zzak);
                return com_google_android_gms_internal_zzak;
            } else {
                com_google_android_gms_internal_zzak2 = (zzak) this.zzoh.get(0);
                com_google_android_gms_internal_zzak2.zzbn();
                return com_google_android_gms_internal_zzak2;
            }
        }
    }

    public void zzc(zzak com_google_android_gms_internal_zzak) {
        synchronized (this.zznh) {
            if (this.zzoh.size() >= 10) {
                zzhx.zzY("Queue is full, current size = " + this.zzoh.size());
                this.zzoh.remove(0);
            }
            int i = this.zzog;
            this.zzog = i + 1;
            com_google_android_gms_internal_zzak.zzc(i);
            this.zzoh.add(com_google_android_gms_internal_zzak);
        }
    }
}
