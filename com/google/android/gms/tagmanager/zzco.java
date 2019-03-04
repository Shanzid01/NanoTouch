package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.zzc.zzi;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zze;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzco {
    private static final zzbv<com.google.android.gms.internal.zzd.zza> zzazW = new zzbv(zzde.zzuf(), true);
    private final Map<String, zzaj> zzaAa;
    private final Map<String, zzaj> zzaAb;
    private final zzk<com.google.android.gms.internal.zzvl.zza, zzbv<com.google.android.gms.internal.zzd.zza>> zzaAc;
    private final zzk<String, zzb> zzaAd;
    private final Set<zze> zzaAe;
    private final Map<String, zzc> zzaAf;
    private volatile String zzaAg;
    private int zzaAh;
    private final DataLayer zzaxx;
    private final com.google.android.gms.internal.zzvl.zzc zzazX;
    private final zzag zzazY;
    private final Map<String, zzaj> zzazZ;

    class C14221 implements com.google.android.gms.tagmanager.zzl.zza<com.google.android.gms.internal.zzvl.zza, zzbv<com.google.android.gms.internal.zzd.zza>> {
        final /* synthetic */ zzco zzaAi;

        C14221(zzco com_google_android_gms_tagmanager_zzco) {
            this.zzaAi = com_google_android_gms_tagmanager_zzco;
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((com.google.android.gms.internal.zzvl.zza) obj, (zzbv) obj2);
        }

        public int zza(com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza, zzbv<com.google.android.gms.internal.zzd.zza> com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza) {
            return ((com.google.android.gms.internal.zzd.zza) com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza.getObject()).zzvX();
        }
    }

    class C14232 implements com.google.android.gms.tagmanager.zzl.zza<String, zzb> {
        final /* synthetic */ zzco zzaAi;

        C14232(zzco com_google_android_gms_tagmanager_zzco) {
            this.zzaAi = com_google_android_gms_tagmanager_zzco;
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((String) obj, (zzb) obj2);
        }

        public int zza(String str, zzb com_google_android_gms_tagmanager_zzco_zzb) {
            return str.length() + com_google_android_gms_tagmanager_zzco_zzb.getSize();
        }
    }

    interface zza {
        void zza(zze com_google_android_gms_internal_zzvl_zze, Set<com.google.android.gms.internal.zzvl.zza> set, Set<com.google.android.gms.internal.zzvl.zza> set2, zzcj com_google_android_gms_tagmanager_zzcj);
    }

    class C14254 implements zza {
        final /* synthetic */ zzco zzaAi;

        C14254(zzco com_google_android_gms_tagmanager_zzco) {
            this.zzaAi = com_google_android_gms_tagmanager_zzco;
        }

        public void zza(zze com_google_android_gms_internal_zzvl_zze, Set<com.google.android.gms.internal.zzvl.zza> set, Set<com.google.android.gms.internal.zzvl.zza> set2, zzcj com_google_android_gms_tagmanager_zzcj) {
            set.addAll(com_google_android_gms_internal_zzvl_zze.zzuE());
            set2.addAll(com_google_android_gms_internal_zzvl_zze.zzuF());
            com_google_android_gms_tagmanager_zzcj.zztq().zzc(com_google_android_gms_internal_zzvl_zze.zzuE(), com_google_android_gms_internal_zzvl_zze.zzuJ());
            com_google_android_gms_tagmanager_zzcj.zztr().zzc(com_google_android_gms_internal_zzvl_zze.zzuF(), com_google_android_gms_internal_zzvl_zze.zzuK());
        }
    }

    class zzb {
        private zzbv<com.google.android.gms.internal.zzd.zza> zzaAn;
        private com.google.android.gms.internal.zzd.zza zzaAo;

        public zzb(zzbv<com.google.android.gms.internal.zzd.zza> com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza, com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza) {
            this.zzaAn = com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza;
            this.zzaAo = com_google_android_gms_internal_zzd_zza;
        }

        public int getSize() {
            return (this.zzaAo == null ? 0 : this.zzaAo.zzvX()) + ((com.google.android.gms.internal.zzd.zza) this.zzaAn.getObject()).zzvX();
        }

        public zzbv<com.google.android.gms.internal.zzd.zza> zztJ() {
            return this.zzaAn;
        }

        public com.google.android.gms.internal.zzd.zza zztK() {
            return this.zzaAo;
        }
    }

    class zzc {
        private final Set<zze> zzaAe = new HashSet();
        private final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zzaAp = new HashMap();
        private final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zzaAq = new HashMap();
        private final Map<zze, List<String>> zzaAr = new HashMap();
        private final Map<zze, List<String>> zzaAs = new HashMap();
        private com.google.android.gms.internal.zzvl.zza zzaAt;

        public void zza(zze com_google_android_gms_internal_zzvl_zze) {
            this.zzaAe.add(com_google_android_gms_internal_zzvl_zze);
        }

        public void zza(zze com_google_android_gms_internal_zzvl_zze, com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza) {
            List list = (List) this.zzaAp.get(com_google_android_gms_internal_zzvl_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAp.put(com_google_android_gms_internal_zzvl_zze, list);
            }
            list.add(com_google_android_gms_internal_zzvl_zza);
        }

        public void zza(zze com_google_android_gms_internal_zzvl_zze, String str) {
            List list = (List) this.zzaAr.get(com_google_android_gms_internal_zzvl_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAr.put(com_google_android_gms_internal_zzvl_zze, list);
            }
            list.add(str);
        }

        public void zzb(com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza) {
            this.zzaAt = com_google_android_gms_internal_zzvl_zza;
        }

        public void zzb(zze com_google_android_gms_internal_zzvl_zze, com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza) {
            List list = (List) this.zzaAq.get(com_google_android_gms_internal_zzvl_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAq.put(com_google_android_gms_internal_zzvl_zze, list);
            }
            list.add(com_google_android_gms_internal_zzvl_zza);
        }

        public void zzb(zze com_google_android_gms_internal_zzvl_zze, String str) {
            List list = (List) this.zzaAs.get(com_google_android_gms_internal_zzvl_zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaAs.put(com_google_android_gms_internal_zzvl_zze, list);
            }
            list.add(str);
        }

        public Set<zze> zztL() {
            return this.zzaAe;
        }

        public Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zztM() {
            return this.zzaAp;
        }

        public Map<zze, List<String>> zztN() {
            return this.zzaAr;
        }

        public Map<zze, List<String>> zztO() {
            return this.zzaAs;
        }

        public Map<zze, List<com.google.android.gms.internal.zzvl.zza>> zztP() {
            return this.zzaAq;
        }

        public com.google.android.gms.internal.zzvl.zza zztQ() {
            return this.zzaAt;
        }
    }

    public zzco(Context context, com.google.android.gms.internal.zzvl.zzc com_google_android_gms_internal_zzvl_zzc, DataLayer dataLayer, com.google.android.gms.tagmanager.zzs.zza com_google_android_gms_tagmanager_zzs_zza, com.google.android.gms.tagmanager.zzs.zza com_google_android_gms_tagmanager_zzs_zza2, zzag com_google_android_gms_tagmanager_zzag) {
        if (com_google_android_gms_internal_zzvl_zzc == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzazX = com_google_android_gms_internal_zzvl_zzc;
        this.zzaAe = new HashSet(com_google_android_gms_internal_zzvl_zzc.zzuy());
        this.zzaxx = dataLayer;
        this.zzazY = com_google_android_gms_tagmanager_zzag;
        this.zzaAc = new zzl().zza(1048576, new C14221(this));
        this.zzaAd = new zzl().zza(1048576, new C14232(this));
        this.zzazZ = new HashMap();
        zzb(new zzi(context));
        zzb(new zzs(com_google_android_gms_tagmanager_zzs_zza2));
        zzb(new zzw(dataLayer));
        zzb(new zzdf(context, dataLayer));
        zzb(new zzda(context, dataLayer));
        this.zzaAa = new HashMap();
        zzc(new zzq());
        zzc(new zzad());
        zzc(new zzae());
        zzc(new zzal());
        zzc(new zzam());
        zzc(new zzbb());
        zzc(new zzbc());
        zzc(new zzce());
        zzc(new zzcx());
        this.zzaAb = new HashMap();
        zza(new zzb(context));
        zza(new zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzm());
        zza(new zzp(this.zzazX.getVersion()));
        zza(new zzs(com_google_android_gms_tagmanager_zzs_zza));
        zza(new zzu(dataLayer));
        zza(new zzz(context));
        zza(new zzaa());
        zza(new zzac());
        zza(new zzah(this));
        zza(new zzan());
        zza(new zzao());
        zza(new zzav(context));
        zza(new zzax());
        zza(new zzba());
        zza(new zzbh());
        zza(new zzbj(context));
        zza(new zzbw());
        zza(new zzby());
        zza(new zzcb());
        zza(new zzcd());
        zza(new zzcf(context));
        zza(new zzcp());
        zza(new zzcq());
        zza(new zzcz());
        zza(new zzdg());
        this.zzaAf = new HashMap();
        for (zze com_google_android_gms_internal_zzvl_zze : this.zzaAe) {
            if (com_google_android_gms_tagmanager_zzag.zztg()) {
                zza(com_google_android_gms_internal_zzvl_zze.zzuG(), com_google_android_gms_internal_zzvl_zze.zzuH(), "add macro");
                zza(com_google_android_gms_internal_zzvl_zze.zzuL(), com_google_android_gms_internal_zzvl_zze.zzuI(), "remove macro");
                zza(com_google_android_gms_internal_zzvl_zze.zzuE(), com_google_android_gms_internal_zzvl_zze.zzuJ(), "add tag");
                zza(com_google_android_gms_internal_zzvl_zze.zzuF(), com_google_android_gms_internal_zzvl_zze.zzuK(), "remove tag");
            }
            int i = 0;
            while (i < com_google_android_gms_internal_zzvl_zze.zzuG().size()) {
                com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza = (com.google.android.gms.internal.zzvl.zza) com_google_android_gms_internal_zzvl_zze.zzuG().get(i);
                String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (com_google_android_gms_tagmanager_zzag.zztg() && i < com_google_android_gms_internal_zzvl_zze.zzuH().size()) {
                    str = (String) com_google_android_gms_internal_zzvl_zze.zzuH().get(i);
                }
                zzc zze = zze(this.zzaAf, zza(com_google_android_gms_internal_zzvl_zza));
                zze.zza(com_google_android_gms_internal_zzvl_zze);
                zze.zza(com_google_android_gms_internal_zzvl_zze, com_google_android_gms_internal_zzvl_zza);
                zze.zza(com_google_android_gms_internal_zzvl_zze, str);
                i++;
            }
            i = 0;
            while (i < com_google_android_gms_internal_zzvl_zze.zzuL().size()) {
                com_google_android_gms_internal_zzvl_zza = (com.google.android.gms.internal.zzvl.zza) com_google_android_gms_internal_zzvl_zze.zzuL().get(i);
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (com_google_android_gms_tagmanager_zzag.zztg() && i < com_google_android_gms_internal_zzvl_zze.zzuI().size()) {
                    str = (String) com_google_android_gms_internal_zzvl_zze.zzuI().get(i);
                }
                zze = zze(this.zzaAf, zza(com_google_android_gms_internal_zzvl_zza));
                zze.zza(com_google_android_gms_internal_zzvl_zze);
                zze.zzb(com_google_android_gms_internal_zzvl_zze, com_google_android_gms_internal_zzvl_zza);
                zze.zzb(com_google_android_gms_internal_zzvl_zze, str);
                i++;
            }
        }
        for (Entry entry : this.zzazX.zzuz().entrySet()) {
            for (com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza2 : (List) entry.getValue()) {
                if (!zzde.zzk((com.google.android.gms.internal.zzd.zza) com_google_android_gms_internal_zzvl_zza2.zzuv().get(com.google.android.gms.internal.zzb.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zze(this.zzaAf, (String) entry.getKey()).zzb(com_google_android_gms_internal_zzvl_zza2);
                }
            }
        }
    }

    private zzbv<com.google.android.gms.internal.zzd.zza> zza(com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza, Set<String> set, zzdh com_google_android_gms_tagmanager_zzdh) {
        if (!com_google_android_gms_internal_zzd_zza.zzgF) {
            return new zzbv(com_google_android_gms_internal_zzd_zza, true);
        }
        com.google.android.gms.internal.zzd.zza zzo;
        int i;
        zzbv zza;
        switch (com_google_android_gms_internal_zzd_zza.type) {
            case 2:
                zzo = zzvl.zzo(com_google_android_gms_internal_zzd_zza);
                zzo.zzgw = new com.google.android.gms.internal.zzd.zza[com_google_android_gms_internal_zzd_zza.zzgw.length];
                for (i = 0; i < com_google_android_gms_internal_zzd_zza.zzgw.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzd_zza.zzgw[i], (Set) set, com_google_android_gms_tagmanager_zzdh.zzhf(i));
                    if (zza == zzazW) {
                        return zzazW;
                    }
                    zzo.zzgw[i] = (com.google.android.gms.internal.zzd.zza) zza.getObject();
                }
                return new zzbv(zzo, false);
            case 3:
                zzo = zzvl.zzo(com_google_android_gms_internal_zzd_zza);
                if (com_google_android_gms_internal_zzd_zza.zzgx.length != com_google_android_gms_internal_zzd_zza.zzgy.length) {
                    zzbf.zzZ("Invalid serving value: " + com_google_android_gms_internal_zzd_zza.toString());
                    return zzazW;
                }
                zzo.zzgx = new com.google.android.gms.internal.zzd.zza[com_google_android_gms_internal_zzd_zza.zzgx.length];
                zzo.zzgy = new com.google.android.gms.internal.zzd.zza[com_google_android_gms_internal_zzd_zza.zzgx.length];
                for (i = 0; i < com_google_android_gms_internal_zzd_zza.zzgx.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzd_zza.zzgx[i], (Set) set, com_google_android_gms_tagmanager_zzdh.zzhg(i));
                    zzbv zza2 = zza(com_google_android_gms_internal_zzd_zza.zzgy[i], (Set) set, com_google_android_gms_tagmanager_zzdh.zzhh(i));
                    if (zza == zzazW || zza2 == zzazW) {
                        return zzazW;
                    }
                    zzo.zzgx[i] = (com.google.android.gms.internal.zzd.zza) zza.getObject();
                    zzo.zzgy[i] = (com.google.android.gms.internal.zzd.zza) zza2.getObject();
                }
                return new zzbv(zzo, false);
            case 4:
                if (set.contains(com_google_android_gms_internal_zzd_zza.zzgz)) {
                    zzbf.zzZ("Macro cycle detected.  Current macro reference: " + com_google_android_gms_internal_zzd_zza.zzgz + "." + "  Previous macro references: " + set.toString() + ".");
                    return zzazW;
                }
                set.add(com_google_android_gms_internal_zzd_zza.zzgz);
                zzbv<com.google.android.gms.internal.zzd.zza> zza3 = zzdi.zza(zza(com_google_android_gms_internal_zzd_zza.zzgz, (Set) set, com_google_android_gms_tagmanager_zzdh.zztt()), com_google_android_gms_internal_zzd_zza.zzgE);
                set.remove(com_google_android_gms_internal_zzd_zza.zzgz);
                return zza3;
            case 7:
                zzo = zzvl.zzo(com_google_android_gms_internal_zzd_zza);
                zzo.zzgD = new com.google.android.gms.internal.zzd.zza[com_google_android_gms_internal_zzd_zza.zzgD.length];
                for (i = 0; i < com_google_android_gms_internal_zzd_zza.zzgD.length; i++) {
                    zza = zza(com_google_android_gms_internal_zzd_zza.zzgD[i], (Set) set, com_google_android_gms_tagmanager_zzdh.zzhi(i));
                    if (zza == zzazW) {
                        return zzazW;
                    }
                    zzo.zzgD[i] = (com.google.android.gms.internal.zzd.zza) zza.getObject();
                }
                return new zzbv(zzo, false);
            default:
                zzbf.zzZ("Unknown type: " + com_google_android_gms_internal_zzd_zza.type);
                return zzazW;
        }
    }

    private zzbv<com.google.android.gms.internal.zzd.zza> zza(String str, Set<String> set, zzbi com_google_android_gms_tagmanager_zzbi) {
        this.zzaAh++;
        zzb com_google_android_gms_tagmanager_zzco_zzb = (zzb) this.zzaAd.get(str);
        if (com_google_android_gms_tagmanager_zzco_zzb == null || this.zzazY.zztg()) {
            zzc com_google_android_gms_tagmanager_zzco_zzc = (zzc) this.zzaAf.get(str);
            if (com_google_android_gms_tagmanager_zzco_zzc == null) {
                zzbf.zzZ(zztI() + "Invalid macro: " + str);
                this.zzaAh--;
                return zzazW;
            }
            com.google.android.gms.internal.zzvl.zza zztQ;
            zzbv zza = zza(str, com_google_android_gms_tagmanager_zzco_zzc.zztL(), com_google_android_gms_tagmanager_zzco_zzc.zztM(), com_google_android_gms_tagmanager_zzco_zzc.zztN(), com_google_android_gms_tagmanager_zzco_zzc.zztP(), com_google_android_gms_tagmanager_zzco_zzc.zztO(), set, com_google_android_gms_tagmanager_zzbi.zzsX());
            if (((Set) zza.getObject()).isEmpty()) {
                zztQ = com_google_android_gms_tagmanager_zzco_zzc.zztQ();
            } else {
                if (((Set) zza.getObject()).size() > 1) {
                    zzbf.zzac(zztI() + "Multiple macros active for macroName " + str);
                }
                zztQ = (com.google.android.gms.internal.zzvl.zza) ((Set) zza.getObject()).iterator().next();
            }
            if (zztQ == null) {
                this.zzaAh--;
                return zzazW;
            }
            zzbv zza2 = zza(this.zzaAb, zztQ, (Set) set, com_google_android_gms_tagmanager_zzbi.zztl());
            boolean z = zza.zztu() && zza2.zztu();
            zzbv<com.google.android.gms.internal.zzd.zza> com_google_android_gms_tagmanager_zzbv = zza2 == zzazW ? zzazW : new zzbv(zza2.getObject(), z);
            com.google.android.gms.internal.zzd.zza zztK = zztQ.zztK();
            if (com_google_android_gms_tagmanager_zzbv.zztu()) {
                this.zzaAd.zze(str, new zzb(com_google_android_gms_tagmanager_zzbv, zztK));
            }
            zza(zztK, (Set) set);
            this.zzaAh--;
            return com_google_android_gms_tagmanager_zzbv;
        }
        zza(com_google_android_gms_tagmanager_zzco_zzb.zztK(), (Set) set);
        this.zzaAh--;
        return com_google_android_gms_tagmanager_zzco_zzb.zztJ();
    }

    private zzbv<com.google.android.gms.internal.zzd.zza> zza(Map<String, zzaj> map, com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza, Set<String> set, zzcg com_google_android_gms_tagmanager_zzcg) {
        boolean z = true;
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza = (com.google.android.gms.internal.zzd.zza) com_google_android_gms_internal_zzvl_zza.zzuv().get(com.google.android.gms.internal.zzb.FUNCTION.toString());
        if (com_google_android_gms_internal_zzd_zza == null) {
            zzbf.zzZ("No function id in properties");
            return zzazW;
        }
        String str = com_google_android_gms_internal_zzd_zza.zzgA;
        zzaj com_google_android_gms_tagmanager_zzaj = (zzaj) map.get(str);
        if (com_google_android_gms_tagmanager_zzaj == null) {
            zzbf.zzZ(str + " has no backing implementation.");
            return zzazW;
        }
        zzbv<com.google.android.gms.internal.zzd.zza> com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza = (zzbv) this.zzaAc.get(com_google_android_gms_internal_zzvl_zza);
        if (com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza != null && !this.zzazY.zztg()) {
            return com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : com_google_android_gms_internal_zzvl_zza.zzuv().entrySet()) {
            zzbv zza = zza((com.google.android.gms.internal.zzd.zza) entry.getValue(), (Set) set, com_google_android_gms_tagmanager_zzcg.zzde((String) entry.getKey()).zze((com.google.android.gms.internal.zzd.zza) entry.getValue()));
            if (zza == zzazW) {
                return zzazW;
            }
            boolean z3;
            if (zza.zztu()) {
                com_google_android_gms_internal_zzvl_zza.zza((String) entry.getKey(), (com.google.android.gms.internal.zzd.zza) zza.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), zza.getObject());
            z2 = z3;
        }
        if (com_google_android_gms_tagmanager_zzaj.zzb(hashMap.keySet())) {
            if (!(z2 && com_google_android_gms_tagmanager_zzaj.zzsD())) {
                z = false;
            }
            com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza = new zzbv(com_google_android_gms_tagmanager_zzaj.zzH(hashMap), z);
            if (z) {
                this.zzaAc.zze(com_google_android_gms_internal_zzvl_zza, com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza);
            }
            com_google_android_gms_tagmanager_zzcg.zzd((com.google.android.gms.internal.zzd.zza) com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza.getObject());
            return com_google_android_gms_tagmanager_zzbv_com_google_android_gms_internal_zzd_zza;
        }
        zzbf.zzZ("Incorrect keys for function " + str + " required " + com_google_android_gms_tagmanager_zzaj.zzti() + " had " + hashMap.keySet());
        return zzazW;
    }

    private zzbv<Set<com.google.android.gms.internal.zzvl.zza>> zza(Set<zze> set, Set<String> set2, zza com_google_android_gms_tagmanager_zzco_zza, zzcn com_google_android_gms_tagmanager_zzcn) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (zze com_google_android_gms_internal_zzvl_zze : set) {
            zzcj zzts = com_google_android_gms_tagmanager_zzcn.zzts();
            zzbv zza = zza(com_google_android_gms_internal_zzvl_zze, (Set) set2, zzts);
            if (((Boolean) zza.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzco_zza.zza(com_google_android_gms_internal_zzvl_zze, hashSet, hashSet2, zzts);
            }
            boolean z2 = z && zza.zztu();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        com_google_android_gms_tagmanager_zzcn.zzc(hashSet);
        return new zzbv(hashSet, z);
    }

    private static String zza(com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza) {
        return zzde.zzg((com.google.android.gms.internal.zzd.zza) com_google_android_gms_internal_zzvl_zza.zzuv().get(com.google.android.gms.internal.zzb.INSTANCE_NAME.toString()));
    }

    private void zza(com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza, Set<String> set) {
        if (com_google_android_gms_internal_zzd_zza != null) {
            zzbv zza = zza(com_google_android_gms_internal_zzd_zza, (Set) set, new zzbt());
            if (zza != zzazW) {
                Object zzl = zzde.zzl((com.google.android.gms.internal.zzd.zza) zza.getObject());
                if (zzl instanceof Map) {
                    this.zzaxx.push((Map) zzl);
                } else if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            this.zzaxx.push((Map) zzl2);
                        } else {
                            zzbf.zzac("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzbf.zzac("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void zza(List<com.google.android.gms.internal.zzvl.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbf.zzaa("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzaj> map, zzaj com_google_android_gms_tagmanager_zzaj) {
        if (map.containsKey(com_google_android_gms_tagmanager_zzaj.zzth())) {
            throw new IllegalArgumentException("Duplicate function type name: " + com_google_android_gms_tagmanager_zzaj.zzth());
        }
        map.put(com_google_android_gms_tagmanager_zzaj.zzth(), com_google_android_gms_tagmanager_zzaj);
    }

    private static zzc zze(Map<String, zzc> map, String str) {
        zzc com_google_android_gms_tagmanager_zzco_zzc = (zzc) map.get(str);
        if (com_google_android_gms_tagmanager_zzco_zzc != null) {
            return com_google_android_gms_tagmanager_zzco_zzc;
        }
        com_google_android_gms_tagmanager_zzco_zzc = new zzc();
        map.put(str, com_google_android_gms_tagmanager_zzco_zzc);
        return com_google_android_gms_tagmanager_zzco_zzc;
    }

    private String zztI() {
        if (this.zzaAh <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.zzaAh));
        for (int i = 2; i < this.zzaAh; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    zzbv<Boolean> zza(com.google.android.gms.internal.zzvl.zza com_google_android_gms_internal_zzvl_zza, Set<String> set, zzcg com_google_android_gms_tagmanager_zzcg) {
        zzbv zza = zza(this.zzaAa, com_google_android_gms_internal_zzvl_zza, (Set) set, com_google_android_gms_tagmanager_zzcg);
        Boolean zzk = zzde.zzk((com.google.android.gms.internal.zzd.zza) zza.getObject());
        com_google_android_gms_tagmanager_zzcg.zzd(zzde.zzx(zzk));
        return new zzbv(zzk, zza.zztu());
    }

    zzbv<Boolean> zza(zze com_google_android_gms_internal_zzvl_zze, Set<String> set, zzcj com_google_android_gms_tagmanager_zzcj) {
        boolean z = true;
        for (com.google.android.gms.internal.zzvl.zza zza : com_google_android_gms_internal_zzvl_zze.zzuD()) {
            zzbv zza2 = zza(zza, (Set) set, com_google_android_gms_tagmanager_zzcj.zztm());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                com_google_android_gms_tagmanager_zzcj.zzf(zzde.zzx(Boolean.valueOf(false)));
                return new zzbv(Boolean.valueOf(false), zza2.zztu());
            }
            boolean z2 = z && zza2.zztu();
            z = z2;
        }
        for (com.google.android.gms.internal.zzvl.zza zza3 : com_google_android_gms_internal_zzvl_zze.zzuC()) {
            zza2 = zza(zza3, (Set) set, com_google_android_gms_tagmanager_zzcj.zztn());
            if (((Boolean) zza2.getObject()).booleanValue()) {
                z = z && zza2.zztu();
            } else {
                com_google_android_gms_tagmanager_zzcj.zzf(zzde.zzx(Boolean.valueOf(false)));
                return new zzbv(Boolean.valueOf(false), zza2.zztu());
            }
        }
        com_google_android_gms_tagmanager_zzcj.zzf(zzde.zzx(Boolean.valueOf(true)));
        return new zzbv(Boolean.valueOf(true), z);
    }

    zzbv<Set<com.google.android.gms.internal.zzvl.zza>> zza(String str, Set<zze> set, Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map, Map<zze, List<String>> map2, Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map3, Map<zze, List<String>> map4, Set<String> set2, zzcn com_google_android_gms_tagmanager_zzcn) {
        final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map5 = map;
        final Map<zze, List<String>> map6 = map2;
        final Map<zze, List<com.google.android.gms.internal.zzvl.zza>> map7 = map3;
        final Map<zze, List<String>> map8 = map4;
        return zza((Set) set, (Set) set2, new zza(this) {
            final /* synthetic */ zzco zzaAi;

            public void zza(zze com_google_android_gms_internal_zzvl_zze, Set<com.google.android.gms.internal.zzvl.zza> set, Set<com.google.android.gms.internal.zzvl.zza> set2, zzcj com_google_android_gms_tagmanager_zzcj) {
                List list = (List) map5.get(com_google_android_gms_internal_zzvl_zze);
                List list2 = (List) map6.get(com_google_android_gms_internal_zzvl_zze);
                if (list != null) {
                    set.addAll(list);
                    com_google_android_gms_tagmanager_zzcj.zzto().zzc(list, list2);
                }
                list = (List) map7.get(com_google_android_gms_internal_zzvl_zze);
                list2 = (List) map8.get(com_google_android_gms_internal_zzvl_zze);
                if (list != null) {
                    set2.addAll(list);
                    com_google_android_gms_tagmanager_zzcj.zztp().zzc(list, list2);
                }
            }
        }, com_google_android_gms_tagmanager_zzcn);
    }

    zzbv<Set<com.google.android.gms.internal.zzvl.zza>> zza(Set<zze> set, zzcn com_google_android_gms_tagmanager_zzcn) {
        return zza((Set) set, new HashSet(), new C14254(this), com_google_android_gms_tagmanager_zzcn);
    }

    void zza(zzaj com_google_android_gms_tagmanager_zzaj) {
        zza(this.zzaAb, com_google_android_gms_tagmanager_zzaj);
    }

    void zzb(zzaj com_google_android_gms_tagmanager_zzaj) {
        zza(this.zzazZ, com_google_android_gms_tagmanager_zzaj);
    }

    void zzc(zzaj com_google_android_gms_tagmanager_zzaj) {
        zza(this.zzaAa, com_google_android_gms_tagmanager_zzaj);
    }

    public synchronized void zzcO(String str) {
        zzdj(str);
        zzaf zzda = this.zzazY.zzda(str);
        zzt zzte = zzda.zzte();
        for (com.google.android.gms.internal.zzvl.zza zza : (Set) zza(this.zzaAe, zzte.zzsX()).getObject()) {
            zza(this.zzazZ, zza, new HashSet(), zzte.zzsW());
        }
        zzda.zztf();
        zzdj(null);
    }

    public zzbv<com.google.android.gms.internal.zzd.zza> zzdi(String str) {
        this.zzaAh = 0;
        zzaf zzcZ = this.zzazY.zzcZ(str);
        zzbv<com.google.android.gms.internal.zzd.zza> zza = zza(str, new HashSet(), zzcZ.zztd());
        zzcZ.zztf();
        return zza;
    }

    synchronized void zzdj(String str) {
        this.zzaAg = str;
    }

    synchronized String zztH() {
        return this.zzaAg;
    }

    public synchronized void zzu(List<zzi> list) {
        for (zzi com_google_android_gms_internal_zzc_zzi : list) {
            if (com_google_android_gms_internal_zzc_zzi.name == null || !com_google_android_gms_internal_zzc_zzi.name.startsWith("gaExperiment:")) {
                zzbf.zzab("Ignored supplemental: " + com_google_android_gms_internal_zzc_zzi);
            } else {
                zzai.zza(this.zzaxx, com_google_android_gms_internal_zzc_zzi);
            }
        }
    }
}
