package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class zzap {
    private final int zzoA;
    private final int zzoB;
    private final int zzoC;
    private final zzao zzoD = new zzar();

    class C11591 implements Comparator<String> {
        final /* synthetic */ zzap zzoE;

        C11591(zzap com_google_android_gms_internal_zzap) {
            this.zzoE = com_google_android_gms_internal_zzap;
        }

        public int compare(String str, String str2) {
            return str2.length() - str.length();
        }
    }

    class C11602 implements Comparator<com.google.android.gms.internal.zzas.zza> {
        final /* synthetic */ zzap zzoE;

        C11602(zzap com_google_android_gms_internal_zzap) {
            this.zzoE = com_google_android_gms_internal_zzap;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((com.google.android.gms.internal.zzas.zza) obj, (com.google.android.gms.internal.zzas.zza) obj2);
        }

        public int zza(com.google.android.gms.internal.zzas.zza com_google_android_gms_internal_zzas_zza, com.google.android.gms.internal.zzas.zza com_google_android_gms_internal_zzas_zza2) {
            return (int) (com_google_android_gms_internal_zzas_zza.value - com_google_android_gms_internal_zzas_zza2.value);
        }
    }

    class zza {
        ByteArrayOutputStream zzoF = new ByteArrayOutputStream(4096);
        Base64OutputStream zzoG = new Base64OutputStream(this.zzoF, 10);

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.zzoG.close();
            } catch (Throwable e) {
                zzhx.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzoF.close();
                byteArrayOutputStream = this.zzoF.toString();
            } catch (Throwable e2) {
                zzhx.zzb("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.zzoF = null;
                this.zzoG = null;
            }
            return byteArrayOutputStream;
        }

        public void write(byte[] bArr) {
            this.zzoG.write(bArr);
        }
    }

    public zzap(int i) {
        this.zzoB = i;
        this.zzoA = 6;
        this.zzoC = 0;
    }

    private String zzm(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzbz = zzbz();
        Arrays.sort(split, new C11591(this));
        int i = 0;
        while (i < split.length && i < this.zzoB) {
            if (split[i].trim().length() != 0) {
                try {
                    zzbz.write(this.zzoD.zzl(split[i]));
                } catch (Throwable e) {
                    zzhx.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzbz.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zzoC) {
            case 0:
                return zzn(stringBuffer.toString());
            case 1:
                return zzm(stringBuffer.toString());
            default:
                return "";
        }
    }

    zza zzbz() {
        return new zza();
    }

    String zzn(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzbz = zzbz();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzoB, new C11602(this));
        for (String zzp : split) {
            String[] zzp2 = zzaq.zzp(zzp);
            if (zzp2.length >= this.zzoA) {
                zzas.zza(zzp2, this.zzoB, this.zzoA, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzbz.write(this.zzoD.zzl(((com.google.android.gms.internal.zzas.zza) it.next()).zzoI));
            } catch (Throwable e) {
                zzhx.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzbz.toString();
    }
}
