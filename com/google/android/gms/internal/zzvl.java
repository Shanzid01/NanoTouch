package com.google.android.gms.internal;

import com.google.android.gms.internal.zzc.zzh;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzde;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzvl {

    public class zza {
        private final com.google.android.gms.internal.zzd.zza zzaAo;
        private final Map<String, com.google.android.gms.internal.zzd.zza> zzaCj;

        private zza(Map<String, com.google.android.gms.internal.zzd.zza> map, com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
            this.zzaCj = map;
            this.zzaAo = com_google_android_gms_internal_zzd_zza;
        }

        public static zzb zzuu() {
            return new zzb();
        }

        public String toString() {
            return "Properties: " + zzuv() + " pushAfterEvaluate: " + this.zzaAo;
        }

        public void zza(String str, com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
            this.zzaCj.put(str, com_google_android_gms_internal_zzd_zza);
        }

        public com.google.android.gms.internal.zzd.zza zztK() {
            return this.zzaAo;
        }

        public Map<String, com.google.android.gms.internal.zzd.zza> zzuv() {
            return Collections.unmodifiableMap(this.zzaCj);
        }
    }

    public class zzb {
        private com.google.android.gms.internal.zzd.zza zzaAo;
        private final Map<String, com.google.android.gms.internal.zzd.zza> zzaCj;

        private zzb() {
            this.zzaCj = new HashMap();
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
            this.zzaCj.put(str, com_google_android_gms_internal_zzd_zza);
            return this;
        }

        public zzb zzq(com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
            this.zzaAo = com_google_android_gms_internal_zzd_zza;
            return this;
        }

        public zza zzuw() {
            return new zza(this.zzaCj, this.zzaAo);
        }
    }

    public class zzc {
        private final String zzYw;
        private final List<zze> zzaCk;
        private final Map<String, List<zza>> zzaCl;
        private final int zzaCm;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzaCk = Collections.unmodifiableList(list);
            this.zzaCl = Collections.unmodifiableMap(map);
            this.zzYw = str;
            this.zzaCm = i;
        }

        public static zzd zzux() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzYw;
        }

        public String toString() {
            return "Rules: " + zzuy() + "  Macros: " + this.zzaCl;
        }

        public List<zze> zzuy() {
            return this.zzaCk;
        }

        public Map<String, List<zza>> zzuz() {
            return this.zzaCl;
        }
    }

    public class zzd {
        private String zzYw;
        private final List<zze> zzaCk;
        private final Map<String, List<zza>> zzaCl;
        private int zzaCm;

        private zzd() {
            this.zzaCk = new ArrayList();
            this.zzaCl = new HashMap();
            this.zzYw = "";
            this.zzaCm = 0;
        }

        public zzd zzb(zze com_google_android_gms_internal_zzvl_zze) {
            this.zzaCk.add(com_google_android_gms_internal_zzvl_zze);
            return this;
        }

        public zzd zzc(zza com_google_android_gms_internal_zzvl_zza) {
            String zzg = zzde.zzg((com.google.android.gms.internal.zzd.zza) com_google_android_gms_internal_zzvl_zza.zzuv().get(zzb.INSTANCE_NAME.toString()));
            List list = (List) this.zzaCl.get(zzg);
            if (list == null) {
                list = new ArrayList();
                this.zzaCl.put(zzg, list);
            }
            list.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zzd zzdy(String str) {
            this.zzYw = str;
            return this;
        }

        public zzd zzhk(int i) {
            this.zzaCm = i;
            return this;
        }

        public zzc zzuA() {
            return new zzc(this.zzaCk, this.zzaCl, this.zzYw, this.zzaCm);
        }
    }

    public class zze {
        private final List<zza> zzaCn;
        private final List<zza> zzaCo;
        private final List<zza> zzaCp;
        private final List<zza> zzaCq;
        private final List<zza> zzaCr;
        private final List<zza> zzaCs;
        private final List<String> zzaCt;
        private final List<String> zzaCu;
        private final List<String> zzaCv;
        private final List<String> zzaCw;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzaCn = Collections.unmodifiableList(list);
            this.zzaCo = Collections.unmodifiableList(list2);
            this.zzaCp = Collections.unmodifiableList(list3);
            this.zzaCq = Collections.unmodifiableList(list4);
            this.zzaCr = Collections.unmodifiableList(list5);
            this.zzaCs = Collections.unmodifiableList(list6);
            this.zzaCt = Collections.unmodifiableList(list7);
            this.zzaCu = Collections.unmodifiableList(list8);
            this.zzaCv = Collections.unmodifiableList(list9);
            this.zzaCw = Collections.unmodifiableList(list10);
        }

        public static zzf zzuB() {
            return new zzf();
        }

        public String toString() {
            return "Positive predicates: " + zzuC() + "  Negative predicates: " + zzuD() + "  Add tags: " + zzuE() + "  Remove tags: " + zzuF() + "  Add macros: " + zzuG() + "  Remove macros: " + zzuL();
        }

        public List<zza> zzuC() {
            return this.zzaCn;
        }

        public List<zza> zzuD() {
            return this.zzaCo;
        }

        public List<zza> zzuE() {
            return this.zzaCp;
        }

        public List<zza> zzuF() {
            return this.zzaCq;
        }

        public List<zza> zzuG() {
            return this.zzaCr;
        }

        public List<String> zzuH() {
            return this.zzaCt;
        }

        public List<String> zzuI() {
            return this.zzaCu;
        }

        public List<String> zzuJ() {
            return this.zzaCv;
        }

        public List<String> zzuK() {
            return this.zzaCw;
        }

        public List<zza> zzuL() {
            return this.zzaCs;
        }
    }

    public class zzf {
        private final List<zza> zzaCn;
        private final List<zza> zzaCo;
        private final List<zza> zzaCp;
        private final List<zza> zzaCq;
        private final List<zza> zzaCr;
        private final List<zza> zzaCs;
        private final List<String> zzaCt;
        private final List<String> zzaCu;
        private final List<String> zzaCv;
        private final List<String> zzaCw;

        private zzf() {
            this.zzaCn = new ArrayList();
            this.zzaCo = new ArrayList();
            this.zzaCp = new ArrayList();
            this.zzaCq = new ArrayList();
            this.zzaCr = new ArrayList();
            this.zzaCs = new ArrayList();
            this.zzaCt = new ArrayList();
            this.zzaCu = new ArrayList();
            this.zzaCv = new ArrayList();
            this.zzaCw = new ArrayList();
        }

        public zzf zzd(zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaCn.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zzf zzdA(String str) {
            this.zzaCw.add(str);
            return this;
        }

        public zzf zzdB(String str) {
            this.zzaCt.add(str);
            return this;
        }

        public zzf zzdC(String str) {
            this.zzaCu.add(str);
            return this;
        }

        public zzf zzdz(String str) {
            this.zzaCv.add(str);
            return this;
        }

        public zzf zze(zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaCo.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zzf zzf(zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaCp.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zzf zzg(zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaCq.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zzf zzh(zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaCr.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zzf zzi(zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaCs.add(com_google_android_gms_internal_zzvl_zza);
            return this;
        }

        public zze zzuM() {
            return new zze(this.zzaCn, this.zzaCo, this.zzaCp, this.zzaCq, this.zzaCr, this.zzaCs, this.zzaCt, this.zzaCu, this.zzaCv, this.zzaCw);
        }
    }

    public class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzd.zza zza(int i, com.google.android.gms.internal.zzc.zzf com_google_android_gms_internal_zzc_zzf, com.google.android.gms.internal.zzd.zza[] com_google_android_gms_internal_zzd_zzaArr, Set<Integer> set) {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzdw("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza = (com.google.android.gms.internal.zzd.zza) zza(com_google_android_gms_internal_zzc_zzf.zzfG, i, "values");
        if (com_google_android_gms_internal_zzd_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzd_zzaArr[i];
        }
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza2 = null;
        set.add(Integer.valueOf(i));
        zzh zzp;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (com_google_android_gms_internal_zzd_zza.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                com_google_android_gms_internal_zzd_zza2 = com_google_android_gms_internal_zzd_zza;
                break;
            case 2:
                zzp = zzp(com_google_android_gms_internal_zzd_zza);
                com_google_android_gms_internal_zzd_zza2 = zzo(com_google_android_gms_internal_zzd_zza);
                com_google_android_gms_internal_zzd_zza2.zzgw = new com.google.android.gms.internal.zzd.zza[zzp.zzgh.length];
                iArr = zzp.zzgh;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzd_zza2.zzgw[i3] = zza(iArr[i2], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                com_google_android_gms_internal_zzd_zza2 = zzo(com_google_android_gms_internal_zzd_zza);
                zzh zzp2 = zzp(com_google_android_gms_internal_zzd_zza);
                if (zzp2.zzgi.length != zzp2.zzgj.length) {
                    zzdw("Uneven map keys (" + zzp2.zzgi.length + ") and map values (" + zzp2.zzgj.length + ")");
                }
                com_google_android_gms_internal_zzd_zza2.zzgx = new com.google.android.gms.internal.zzd.zza[zzp2.zzgi.length];
                com_google_android_gms_internal_zzd_zza2.zzgy = new com.google.android.gms.internal.zzd.zza[zzp2.zzgi.length];
                int[] iArr2 = zzp2.zzgi;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    com_google_android_gms_internal_zzd_zza2.zzgx[i4] = zza(iArr2[i3], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = zzp2.zzgj;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzd_zza2.zzgy[i3] = zza(iArr[i2], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                com_google_android_gms_internal_zzd_zza2 = zzo(com_google_android_gms_internal_zzd_zza);
                com_google_android_gms_internal_zzd_zza2.zzgz = zzde.zzg(zza(zzp(com_google_android_gms_internal_zzd_zza).zzgm, com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, (Set) set));
                break;
            case 7:
                com_google_android_gms_internal_zzd_zza2 = zzo(com_google_android_gms_internal_zzd_zza);
                zzp = zzp(com_google_android_gms_internal_zzd_zza);
                com_google_android_gms_internal_zzd_zza2.zzgD = new com.google.android.gms.internal.zzd.zza[zzp.zzgl.length];
                iArr = zzp.zzgl;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzd_zza2.zzgD[i3] = zza(iArr[i2], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (com_google_android_gms_internal_zzd_zza2 == null) {
            zzdw("Invalid value: " + com_google_android_gms_internal_zzd_zza);
        }
        com_google_android_gms_internal_zzd_zzaArr[i] = com_google_android_gms_internal_zzd_zza2;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzd_zza2;
    }

    private static zza zza(com.google.android.gms.internal.zzc.zzb com_google_android_gms_internal_zzc_zzb, com.google.android.gms.internal.zzc.zzf com_google_android_gms_internal_zzc_zzf, com.google.android.gms.internal.zzd.zza[] com_google_android_gms_internal_zzd_zzaArr, int i) {
        zzb zzuu = zza.zzuu();
        for (int valueOf : com_google_android_gms_internal_zzc_zzb.zzfq) {
            com.google.android.gms.internal.zzc.zze com_google_android_gms_internal_zzc_zze = (com.google.android.gms.internal.zzc.zze) zza(com_google_android_gms_internal_zzc_zzf.zzfH, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(com_google_android_gms_internal_zzc_zzf.zzfF, com_google_android_gms_internal_zzc_zze.key, "keys");
            com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza = (com.google.android.gms.internal.zzd.zza) zza(com_google_android_gms_internal_zzd_zzaArr, com_google_android_gms_internal_zzc_zze.value, "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzuu.zzq(com_google_android_gms_internal_zzd_zza);
            } else {
                zzuu.zzb(str, com_google_android_gms_internal_zzd_zza);
            }
        }
        return zzuu.zzuw();
    }

    private static zze zza(com.google.android.gms.internal.zzc.zzg com_google_android_gms_internal_zzc_zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzc.zzf com_google_android_gms_internal_zzc_zzf) {
        zzf zzuB = zze.zzuB();
        for (int valueOf : com_google_android_gms_internal_zzc_zzg.zzfV) {
            zzuB.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : com_google_android_gms_internal_zzc_zzg.zzfW) {
            zzuB.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : com_google_android_gms_internal_zzc_zzg.zzfX) {
            zzuB.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : com_google_android_gms_internal_zzc_zzg.zzfZ) {
            zzuB.zzdz(com_google_android_gms_internal_zzc_zzf.zzfG[Integer.valueOf(valueOf3).intValue()].zzgv);
        }
        for (int valueOf222 : com_google_android_gms_internal_zzc_zzg.zzfY) {
            zzuB.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : com_google_android_gms_internal_zzc_zzg.zzga) {
            zzuB.zzdA(com_google_android_gms_internal_zzc_zzf.zzfG[Integer.valueOf(valueOf32).intValue()].zzgv);
        }
        for (int valueOf2222 : com_google_android_gms_internal_zzc_zzg.zzgb) {
            zzuB.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : com_google_android_gms_internal_zzc_zzg.zzgd) {
            zzuB.zzdB(com_google_android_gms_internal_zzc_zzf.zzfG[Integer.valueOf(valueOf322).intValue()].zzgv);
        }
        for (int valueOf22222 : com_google_android_gms_internal_zzc_zzg.zzgc) {
            zzuB.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : com_google_android_gms_internal_zzc_zzg.zzge) {
            zzuB.zzdC(com_google_android_gms_internal_zzc_zzf.zzfG[Integer.valueOf(valueOf4).intValue()].zzgv);
        }
        return zzuB.zzuM();
    }

    private static <T> T zza(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            zzdw("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzc.zzf com_google_android_gms_internal_zzc_zzf) {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzd.zza[] com_google_android_gms_internal_zzd_zzaArr = new com.google.android.gms.internal.zzd.zza[com_google_android_gms_internal_zzc_zzf.zzfG.length];
        for (i = 0; i < com_google_android_gms_internal_zzc_zzf.zzfG.length; i++) {
            zza(i, com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, new HashSet(0));
        }
        zzd zzux = zzc.zzux();
        List arrayList = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzc_zzf.zzfJ.length; i++) {
            arrayList.add(zza(com_google_android_gms_internal_zzc_zzf.zzfJ[i], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzc_zzf.zzfK.length; i++) {
            arrayList2.add(zza(com_google_android_gms_internal_zzc_zzf.zzfK[i], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzc_zzf.zzfI.length; i++) {
            zza zza = zza(com_google_android_gms_internal_zzc_zzf.zzfI[i], com_google_android_gms_internal_zzc_zzf, com_google_android_gms_internal_zzd_zzaArr, i);
            zzux.zzc(zza);
            arrayList3.add(zza);
        }
        com.google.android.gms.internal.zzc.zzg[] com_google_android_gms_internal_zzc_zzgArr = com_google_android_gms_internal_zzc_zzf.zzfL;
        int length = com_google_android_gms_internal_zzc_zzgArr.length;
        while (i2 < length) {
            zzux.zzb(zza(com_google_android_gms_internal_zzc_zzgArr[i2], arrayList, arrayList3, arrayList2, com_google_android_gms_internal_zzc_zzf));
            i2++;
        }
        zzux.zzdy(com_google_android_gms_internal_zzc_zzf.version);
        zzux.zzhk(com_google_android_gms_internal_zzc_zzf.zzfT);
        return zzux.zzuA();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzdw(String str) {
        zzbf.zzZ(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzd.zza zzo(com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza2 = new com.google.android.gms.internal.zzd.zza();
        com_google_android_gms_internal_zzd_zza2.type = com_google_android_gms_internal_zzd_zza.type;
        com_google_android_gms_internal_zzd_zza2.zzgE = (int[]) com_google_android_gms_internal_zzd_zza.zzgE.clone();
        if (com_google_android_gms_internal_zzd_zza.zzgF) {
            com_google_android_gms_internal_zzd_zza2.zzgF = com_google_android_gms_internal_zzd_zza.zzgF;
        }
        return com_google_android_gms_internal_zzd_zza2;
    }

    private static zzh zzp(com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
        if (((zzh) com_google_android_gms_internal_zzd_zza.zza(zzh.zzgf)) == null) {
            zzdw("Expected a ServingValue and didn't get one. Value is: " + com_google_android_gms_internal_zzd_zza);
        }
        return (zzh) com_google_android_gms_internal_zzd_zza.zza(zzh.zzgf);
    }
}
