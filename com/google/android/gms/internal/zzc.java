package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import com.google.android.gms.location.places.Place;

public interface zzc {

    public final class zza extends zzws<zza> {
        public int level;
        public int zzfn;
        public int zzfo;

        public zza() {
            zzb();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzc_zza = (zza) obj;
            return (this.level == com_google_android_gms_internal_zzc_zza.level && this.zzfn == com_google_android_gms_internal_zzc_zza.zzfn && this.zzfo == com_google_android_gms_internal_zzc_zza.zzfo) ? zza((zzws) com_google_android_gms_internal_zzc_zza) : false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.zzfn) * 31) + this.zzfo) * 31) + zzvL();
        }

        public zza zza(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = zzvu;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzfn = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 24:
                        this.zzfo = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.level != 1) {
                com_google_android_gms_internal_zzwr.zzy(1, this.level);
            }
            if (this.zzfn != 0) {
                com_google_android_gms_internal_zzwr.zzy(2, this.zzfn);
            }
            if (this.zzfo != 0) {
                com_google_android_gms_internal_zzwr.zzy(3, this.zzfo);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public zza zzb() {
            this.level = 1;
            this.zzfn = 0;
            this.zzfo = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zza(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.level != 1) {
                zzc += zzwr.zzA(1, this.level);
            }
            if (this.zzfn != 0) {
                zzc += zzwr.zzA(2, this.zzfn);
            }
            return this.zzfo != 0 ? zzc + zzwr.zzA(3, this.zzfo) : zzc;
        }
    }

    public final class zzb extends zzws<zzb> {
        private static volatile zzb[] zzfp;
        public int name;
        public int[] zzfq;
        public int zzfr;
        public boolean zzfs;
        public boolean zzft;

        public zzb() {
            zze();
        }

        public static zzb[] zzd() {
            if (zzfp == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfp == null) {
                        zzfp = new zzb[0];
                    }
                }
            }
            return zzfp;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzc_zzb = (zzb) obj;
            return (zzww.equals(this.zzfq, com_google_android_gms_internal_zzc_zzb.zzfq) && this.zzfr == com_google_android_gms_internal_zzc_zzb.zzfr && this.name == com_google_android_gms_internal_zzc_zzb.name && this.zzfs == com_google_android_gms_internal_zzc_zzb.zzfs && this.zzft == com_google_android_gms_internal_zzc_zzb.zzft) ? zza((zzws) com_google_android_gms_internal_zzc_zzb) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzfs ? 1231 : 1237) + ((((((zzww.hashCode(this.zzfq) + 527) * 31) + this.zzfr) * 31) + this.name) * 31)) * 31;
            if (!this.zzft) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzft) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzft);
            }
            com_google_android_gms_internal_zzwr.zzy(2, this.zzfr);
            if (this.zzfq != null && this.zzfq.length > 0) {
                for (int zzy : this.zzfq) {
                    com_google_android_gms_internal_zzwr.zzy(3, zzy);
                }
            }
            if (this.name != 0) {
                com_google_android_gms_internal_zzwr.zzy(4, this.name);
            }
            if (this.zzfs) {
                com_google_android_gms_internal_zzwr.zzb(6, this.zzfs);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzc(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (this.zzft) {
                zzc += zzwr.zzc(1, this.zzft);
            }
            int zzA = zzwr.zzA(2, this.zzfr) + zzc;
            if (this.zzfq == null || this.zzfq.length <= 0) {
                zzc = zzA;
            } else {
                for (int zziw : this.zzfq) {
                    i += zzwr.zziw(zziw);
                }
                zzc = (zzA + i) + (this.zzfq.length * 1);
            }
            if (this.name != 0) {
                zzc += zzwr.zzA(4, this.name);
            }
            return this.zzfs ? zzc + zzwr.zzc(6, this.zzfs) : zzc;
        }

        public zzb zzc(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzft = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    case 16:
                        this.zzfr = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 24:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 24);
                        zzvu = this.zzfq == null ? 0 : this.zzfq.length;
                        Object obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfq, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzfq = obj;
                        continue;
                    case 26:
                        int zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzfq == null ? 0 : this.zzfq.length;
                        Object obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfq, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfq = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 32:
                        this.name = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 48:
                        this.zzfs = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zze() {
            this.zzfq = zzxb.zzaHO;
            this.zzfr = 0;
            this.name = 0;
            this.zzfs = false;
            this.zzft = false;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzc extends zzws<zzc> {
        private static volatile zzc[] zzfu;
        public String zzfv;
        public long zzfw;
        public long zzfx;
        public boolean zzfy;
        public long zzfz;

        public zzc() {
            zzg();
        }

        public static zzc[] zzf() {
            if (zzfu == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfu == null) {
                        zzfu = new zzc[0];
                    }
                }
            }
            return zzfu;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzc_zzc = (zzc) obj;
            if (this.zzfv == null) {
                if (com_google_android_gms_internal_zzc_zzc.zzfv != null) {
                    return false;
                }
            } else if (!this.zzfv.equals(com_google_android_gms_internal_zzc_zzc.zzfv)) {
                return false;
            }
            return (this.zzfw == com_google_android_gms_internal_zzc_zzc.zzfw && this.zzfx == com_google_android_gms_internal_zzc_zzc.zzfx && this.zzfy == com_google_android_gms_internal_zzc_zzc.zzfy && this.zzfz == com_google_android_gms_internal_zzc_zzc.zzfz) ? zza((zzws) com_google_android_gms_internal_zzc_zzc) : false;
        }

        public int hashCode() {
            return (((((this.zzfy ? 1231 : 1237) + (((((((this.zzfv == null ? 0 : this.zzfv.hashCode()) + 527) * 31) + ((int) (this.zzfw ^ (this.zzfw >>> 32)))) * 31) + ((int) (this.zzfx ^ (this.zzfx >>> 32)))) * 31)) * 31) + ((int) (this.zzfz ^ (this.zzfz >>> 32)))) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (!this.zzfv.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzfv);
            }
            if (this.zzfw != 0) {
                com_google_android_gms_internal_zzwr.zzb(2, this.zzfw);
            }
            if (this.zzfx != 2147483647L) {
                com_google_android_gms_internal_zzwr.zzb(3, this.zzfx);
            }
            if (this.zzfy) {
                com_google_android_gms_internal_zzwr.zzb(4, this.zzfy);
            }
            if (this.zzfz != 0) {
                com_google_android_gms_internal_zzwr.zzb(5, this.zzfz);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzd(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.zzfv.equals("")) {
                zzc += zzwr.zzj(1, this.zzfv);
            }
            if (this.zzfw != 0) {
                zzc += zzwr.zzd(2, this.zzfw);
            }
            if (this.zzfx != 2147483647L) {
                zzc += zzwr.zzd(3, this.zzfx);
            }
            if (this.zzfy) {
                zzc += zzwr.zzc(4, this.zzfy);
            }
            return this.zzfz != 0 ? zzc + zzwr.zzd(5, this.zzfz) : zzc;
        }

        public zzc zzd(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzfv = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 16:
                        this.zzfw = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 24:
                        this.zzfx = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 32:
                        this.zzfy = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    case 40:
                        this.zzfz = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzc zzg() {
            this.zzfv = "";
            this.zzfw = 0;
            this.zzfx = 2147483647L;
            this.zzfy = false;
            this.zzfz = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzd extends zzws<zzd> {
        public com.google.android.gms.internal.zzd.zza[] zzfA;
        public com.google.android.gms.internal.zzd.zza[] zzfB;
        public zzc[] zzfC;

        public zzd() {
            zzh();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzc_zzd = (zzd) obj;
            return (zzww.equals(this.zzfA, com_google_android_gms_internal_zzc_zzd.zzfA) && zzww.equals(this.zzfB, com_google_android_gms_internal_zzc_zzd.zzfB) && zzww.equals(this.zzfC, com_google_android_gms_internal_zzc_zzd.zzfC)) ? zza((zzws) com_google_android_gms_internal_zzc_zzd) : false;
        }

        public int hashCode() {
            return ((((((zzww.hashCode(this.zzfA) + 527) * 31) + zzww.hashCode(this.zzfB)) * 31) + zzww.hashCode(this.zzfC)) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            int i = 0;
            if (this.zzfA != null && this.zzfA.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzfA) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(1, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzfB != null && this.zzfB.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy2 : this.zzfB) {
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        com_google_android_gms_internal_zzwr.zza(2, com_google_android_gms_internal_zzwy2);
                    }
                }
            }
            if (this.zzfC != null && this.zzfC.length > 0) {
                while (i < this.zzfC.length) {
                    zzwy com_google_android_gms_internal_zzwy3 = this.zzfC[i];
                    if (com_google_android_gms_internal_zzwy3 != null) {
                        com_google_android_gms_internal_zzwr.zza(3, com_google_android_gms_internal_zzwy3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zze(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i;
            int i2 = 0;
            int zzc = super.zzc();
            if (this.zzfA != null && this.zzfA.length > 0) {
                i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy : this.zzfA) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        i += zzwr.zzc(1, com_google_android_gms_internal_zzwy);
                    }
                }
                zzc = i;
            }
            if (this.zzfB != null && this.zzfB.length > 0) {
                i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy2 : this.zzfB) {
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        i += zzwr.zzc(2, com_google_android_gms_internal_zzwy2);
                    }
                }
                zzc = i;
            }
            if (this.zzfC != null && this.zzfC.length > 0) {
                while (i2 < this.zzfC.length) {
                    zzwy com_google_android_gms_internal_zzwy3 = this.zzfC[i2];
                    if (com_google_android_gms_internal_zzwy3 != null) {
                        zzc += zzwr.zzc(3, com_google_android_gms_internal_zzwy3);
                    }
                    i2++;
                }
            }
            return zzc;
        }

        public zzd zze(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 10);
                        zzvu = this.zzfA == null ? 0 : this.zzfA.length;
                        obj = new com.google.android.gms.internal.zzd.zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfA, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfA = obj;
                        continue;
                    case 18:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 18);
                        zzvu = this.zzfB == null ? 0 : this.zzfB.length;
                        obj = new com.google.android.gms.internal.zzd.zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfB, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfB = obj;
                        continue;
                    case 26:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 26);
                        zzvu = this.zzfC == null ? 0 : this.zzfC.length;
                        obj = new zzc[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfC, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzc();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzc();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfC = obj;
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzd zzh() {
            this.zzfA = com.google.android.gms.internal.zzd.zza.zzr();
            this.zzfB = com.google.android.gms.internal.zzd.zza.zzr();
            this.zzfC = zzc.zzf();
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zze extends zzws<zze> {
        private static volatile zze[] zzfD;
        public int key;
        public int value;

        public zze() {
            zzj();
        }

        public static zze[] zzi() {
            if (zzfD == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfD == null) {
                        zzfD = new zze[0];
                    }
                }
            }
            return zzfD;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzc_zze = (zze) obj;
            return (this.key == com_google_android_gms_internal_zzc_zze.key && this.value == com_google_android_gms_internal_zzc_zze.value) ? zza((zzws) com_google_android_gms_internal_zzc_zze) : false;
        }

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            com_google_android_gms_internal_zzwr.zzy(1, this.key);
            com_google_android_gms_internal_zzwr.zzy(2, this.value);
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzf(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            return (super.zzc() + zzwr.zzA(1, this.key)) + zzwr.zzA(2, this.value);
        }

        public zze zzf(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.key = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 16:
                        this.value = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zze zzj() {
            this.key = 0;
            this.value = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzf extends zzws<zzf> {
        public String version;
        public String[] zzfE;
        public String[] zzfF;
        public com.google.android.gms.internal.zzd.zza[] zzfG;
        public zze[] zzfH;
        public zzb[] zzfI;
        public zzb[] zzfJ;
        public zzb[] zzfK;
        public zzg[] zzfL;
        public String zzfM;
        public String zzfN;
        public String zzfO;
        public zza zzfP;
        public float zzfQ;
        public boolean zzfR;
        public String[] zzfS;
        public int zzfT;

        public zzf() {
            zzk();
        }

        public static zzf zza(byte[] bArr) {
            return (zzf) zzwy.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzc_zzf = (zzf) obj;
            if (!zzww.equals(this.zzfE, com_google_android_gms_internal_zzc_zzf.zzfE) || !zzww.equals(this.zzfF, com_google_android_gms_internal_zzc_zzf.zzfF) || !zzww.equals(this.zzfG, com_google_android_gms_internal_zzc_zzf.zzfG) || !zzww.equals(this.zzfH, com_google_android_gms_internal_zzc_zzf.zzfH) || !zzww.equals(this.zzfI, com_google_android_gms_internal_zzc_zzf.zzfI) || !zzww.equals(this.zzfJ, com_google_android_gms_internal_zzc_zzf.zzfJ) || !zzww.equals(this.zzfK, com_google_android_gms_internal_zzc_zzf.zzfK) || !zzww.equals(this.zzfL, com_google_android_gms_internal_zzc_zzf.zzfL)) {
                return false;
            }
            if (this.zzfM == null) {
                if (com_google_android_gms_internal_zzc_zzf.zzfM != null) {
                    return false;
                }
            } else if (!this.zzfM.equals(com_google_android_gms_internal_zzc_zzf.zzfM)) {
                return false;
            }
            if (this.zzfN == null) {
                if (com_google_android_gms_internal_zzc_zzf.zzfN != null) {
                    return false;
                }
            } else if (!this.zzfN.equals(com_google_android_gms_internal_zzc_zzf.zzfN)) {
                return false;
            }
            if (this.zzfO == null) {
                if (com_google_android_gms_internal_zzc_zzf.zzfO != null) {
                    return false;
                }
            } else if (!this.zzfO.equals(com_google_android_gms_internal_zzc_zzf.zzfO)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzc_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzc_zzf.version)) {
                return false;
            }
            if (this.zzfP == null) {
                if (com_google_android_gms_internal_zzc_zzf.zzfP != null) {
                    return false;
                }
            } else if (!this.zzfP.equals(com_google_android_gms_internal_zzc_zzf.zzfP)) {
                return false;
            }
            return (Float.floatToIntBits(this.zzfQ) == Float.floatToIntBits(com_google_android_gms_internal_zzc_zzf.zzfQ) && this.zzfR == com_google_android_gms_internal_zzc_zzf.zzfR && zzww.equals(this.zzfS, com_google_android_gms_internal_zzc_zzf.zzfS) && this.zzfT == com_google_android_gms_internal_zzc_zzf.zzfT) ? zza((zzws) com_google_android_gms_internal_zzc_zzf) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzfO == null ? 0 : this.zzfO.hashCode()) + (((this.zzfN == null ? 0 : this.zzfN.hashCode()) + (((this.zzfM == null ? 0 : this.zzfM.hashCode()) + ((((((((((((((((zzww.hashCode(this.zzfE) + 527) * 31) + zzww.hashCode(this.zzfF)) * 31) + zzww.hashCode(this.zzfG)) * 31) + zzww.hashCode(this.zzfH)) * 31) + zzww.hashCode(this.zzfI)) * 31) + zzww.hashCode(this.zzfJ)) * 31) + zzww.hashCode(this.zzfK)) * 31) + zzww.hashCode(this.zzfL)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzfP != null) {
                i = this.zzfP.hashCode();
            }
            return (((((((this.zzfR ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.zzfQ)) * 31)) * 31) + zzww.hashCode(this.zzfS)) * 31) + this.zzfT) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            int i = 0;
            if (this.zzfF != null && this.zzfF.length > 0) {
                for (String str : this.zzfF) {
                    if (str != null) {
                        com_google_android_gms_internal_zzwr.zzb(1, str);
                    }
                }
            }
            if (this.zzfG != null && this.zzfG.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzfG) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(2, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzfH != null && this.zzfH.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy2 : this.zzfH) {
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        com_google_android_gms_internal_zzwr.zza(3, com_google_android_gms_internal_zzwy2);
                    }
                }
            }
            if (this.zzfI != null && this.zzfI.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy22 : this.zzfI) {
                    if (com_google_android_gms_internal_zzwy22 != null) {
                        com_google_android_gms_internal_zzwr.zza(4, com_google_android_gms_internal_zzwy22);
                    }
                }
            }
            if (this.zzfJ != null && this.zzfJ.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy222 : this.zzfJ) {
                    if (com_google_android_gms_internal_zzwy222 != null) {
                        com_google_android_gms_internal_zzwr.zza(5, com_google_android_gms_internal_zzwy222);
                    }
                }
            }
            if (this.zzfK != null && this.zzfK.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy2222 : this.zzfK) {
                    if (com_google_android_gms_internal_zzwy2222 != null) {
                        com_google_android_gms_internal_zzwr.zza(6, com_google_android_gms_internal_zzwy2222);
                    }
                }
            }
            if (this.zzfL != null && this.zzfL.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy22222 : this.zzfL) {
                    if (com_google_android_gms_internal_zzwy22222 != null) {
                        com_google_android_gms_internal_zzwr.zza(7, com_google_android_gms_internal_zzwy22222);
                    }
                }
            }
            if (!this.zzfM.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(9, this.zzfM);
            }
            if (!this.zzfN.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(10, this.zzfN);
            }
            if (!this.zzfO.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                com_google_android_gms_internal_zzwr.zzb(12, this.zzfO);
            }
            if (!this.version.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(13, this.version);
            }
            if (this.zzfP != null) {
                com_google_android_gms_internal_zzwr.zza(14, this.zzfP);
            }
            if (Float.floatToIntBits(this.zzfQ) != Float.floatToIntBits(0.0f)) {
                com_google_android_gms_internal_zzwr.zzb(15, this.zzfQ);
            }
            if (this.zzfS != null && this.zzfS.length > 0) {
                for (String str2 : this.zzfS) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzwr.zzb(16, str2);
                    }
                }
            }
            if (this.zzfT != 0) {
                com_google_android_gms_internal_zzwr.zzy(17, this.zzfT);
            }
            if (this.zzfR) {
                com_google_android_gms_internal_zzwr.zzb(18, this.zzfR);
            }
            if (this.zzfE != null && this.zzfE.length > 0) {
                while (i < this.zzfE.length) {
                    String str3 = this.zzfE[i];
                    if (str3 != null) {
                        com_google_android_gms_internal_zzwr.zzb(19, str3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzg(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzc = super.zzc();
            if (this.zzfF == null || this.zzfF.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzfF) {
                    if (str != null) {
                        i3++;
                        i2 += zzwr.zzdM(str);
                    }
                }
                i = (zzc + i2) + (i3 * 1);
            }
            if (this.zzfG != null && this.zzfG.length > 0) {
                i2 = i;
                for (zzwy com_google_android_gms_internal_zzwy : this.zzfG) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        i2 += zzwr.zzc(2, com_google_android_gms_internal_zzwy);
                    }
                }
                i = i2;
            }
            if (this.zzfH != null && this.zzfH.length > 0) {
                i2 = i;
                for (zzwy com_google_android_gms_internal_zzwy2 : this.zzfH) {
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        i2 += zzwr.zzc(3, com_google_android_gms_internal_zzwy2);
                    }
                }
                i = i2;
            }
            if (this.zzfI != null && this.zzfI.length > 0) {
                i2 = i;
                for (zzwy com_google_android_gms_internal_zzwy22 : this.zzfI) {
                    if (com_google_android_gms_internal_zzwy22 != null) {
                        i2 += zzwr.zzc(4, com_google_android_gms_internal_zzwy22);
                    }
                }
                i = i2;
            }
            if (this.zzfJ != null && this.zzfJ.length > 0) {
                i2 = i;
                for (zzwy com_google_android_gms_internal_zzwy222 : this.zzfJ) {
                    if (com_google_android_gms_internal_zzwy222 != null) {
                        i2 += zzwr.zzc(5, com_google_android_gms_internal_zzwy222);
                    }
                }
                i = i2;
            }
            if (this.zzfK != null && this.zzfK.length > 0) {
                i2 = i;
                for (zzwy com_google_android_gms_internal_zzwy2222 : this.zzfK) {
                    if (com_google_android_gms_internal_zzwy2222 != null) {
                        i2 += zzwr.zzc(6, com_google_android_gms_internal_zzwy2222);
                    }
                }
                i = i2;
            }
            if (this.zzfL != null && this.zzfL.length > 0) {
                i2 = i;
                for (zzwy com_google_android_gms_internal_zzwy22222 : this.zzfL) {
                    if (com_google_android_gms_internal_zzwy22222 != null) {
                        i2 += zzwr.zzc(7, com_google_android_gms_internal_zzwy22222);
                    }
                }
                i = i2;
            }
            if (!this.zzfM.equals("")) {
                i += zzwr.zzj(9, this.zzfM);
            }
            if (!this.zzfN.equals("")) {
                i += zzwr.zzj(10, this.zzfN);
            }
            if (!this.zzfO.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                i += zzwr.zzj(12, this.zzfO);
            }
            if (!this.version.equals("")) {
                i += zzwr.zzj(13, this.version);
            }
            if (this.zzfP != null) {
                i += zzwr.zzc(14, this.zzfP);
            }
            if (Float.floatToIntBits(this.zzfQ) != Float.floatToIntBits(0.0f)) {
                i += zzwr.zzc(15, this.zzfQ);
            }
            if (this.zzfS != null && this.zzfS.length > 0) {
                i3 = 0;
                zzc = 0;
                for (String str2 : this.zzfS) {
                    if (str2 != null) {
                        zzc++;
                        i3 += zzwr.zzdM(str2);
                    }
                }
                i = (i + i3) + (zzc * 2);
            }
            if (this.zzfT != 0) {
                i += zzwr.zzA(17, this.zzfT);
            }
            if (this.zzfR) {
                i += zzwr.zzc(18, this.zzfR);
            }
            if (this.zzfE == null || this.zzfE.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzfE.length) {
                String str3 = this.zzfE[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzwr.zzdM(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public zzf zzg(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 10);
                        zzvu = this.zzfF == null ? 0 : this.zzfF.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfF, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.readString();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.readString();
                        this.zzfF = obj;
                        continue;
                    case 18:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 18);
                        zzvu = this.zzfG == null ? 0 : this.zzfG.length;
                        obj = new com.google.android.gms.internal.zzd.zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfG, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzd.zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfG = obj;
                        continue;
                    case 26:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 26);
                        zzvu = this.zzfH == null ? 0 : this.zzfH.length;
                        obj = new zze[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfH, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zze();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zze();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfH = obj;
                        continue;
                    case 34:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 34);
                        zzvu = this.zzfI == null ? 0 : this.zzfI.length;
                        obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfI, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfI = obj;
                        continue;
                    case 42:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 42);
                        zzvu = this.zzfJ == null ? 0 : this.zzfJ.length;
                        obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfJ, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfJ = obj;
                        continue;
                    case 50:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 50);
                        zzvu = this.zzfK == null ? 0 : this.zzfK.length;
                        obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfK, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfK = obj;
                        continue;
                    case 58:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 58);
                        zzvu = this.zzfL == null ? 0 : this.zzfL.length;
                        obj = new zzg[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfL, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzg();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzg();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzfL = obj;
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        this.zzfM = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        this.zzfN = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 98:
                        this.zzfO = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 106:
                        this.version = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 114:
                        if (this.zzfP == null) {
                            this.zzfP = new zza();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzfP);
                        continue;
                    case 125:
                        this.zzfQ = com_google_android_gms_internal_zzwq.readFloat();
                        continue;
                    case 130:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 130);
                        zzvu = this.zzfS == null ? 0 : this.zzfS.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfS, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.readString();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.readString();
                        this.zzfS = obj;
                        continue;
                    case 136:
                        this.zzfT = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 144:
                        this.zzfR = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    case 154:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 154);
                        zzvu = this.zzfE == null ? 0 : this.zzfE.length;
                        obj = new String[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfE, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.readString();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.readString();
                        this.zzfE = obj;
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzf zzk() {
            this.zzfE = zzxb.zzaHT;
            this.zzfF = zzxb.zzaHT;
            this.zzfG = com.google.android.gms.internal.zzd.zza.zzr();
            this.zzfH = zze.zzi();
            this.zzfI = zzb.zzd();
            this.zzfJ = zzb.zzd();
            this.zzfK = zzb.zzd();
            this.zzfL = zzg.zzl();
            this.zzfM = "";
            this.zzfN = "";
            this.zzfO = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.version = "";
            this.zzfP = null;
            this.zzfQ = 0.0f;
            this.zzfR = false;
            this.zzfS = zzxb.zzaHT;
            this.zzfT = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzg extends zzws<zzg> {
        private static volatile zzg[] zzfU;
        public int[] zzfV;
        public int[] zzfW;
        public int[] zzfX;
        public int[] zzfY;
        public int[] zzfZ;
        public int[] zzga;
        public int[] zzgb;
        public int[] zzgc;
        public int[] zzgd;
        public int[] zzge;

        public zzg() {
            zzm();
        }

        public static zzg[] zzl() {
            if (zzfU == null) {
                synchronized (zzww.zzaHL) {
                    if (zzfU == null) {
                        zzfU = new zzg[0];
                    }
                }
            }
            return zzfU;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzc_zzg = (zzg) obj;
            return (zzww.equals(this.zzfV, com_google_android_gms_internal_zzc_zzg.zzfV) && zzww.equals(this.zzfW, com_google_android_gms_internal_zzc_zzg.zzfW) && zzww.equals(this.zzfX, com_google_android_gms_internal_zzc_zzg.zzfX) && zzww.equals(this.zzfY, com_google_android_gms_internal_zzc_zzg.zzfY) && zzww.equals(this.zzfZ, com_google_android_gms_internal_zzc_zzg.zzfZ) && zzww.equals(this.zzga, com_google_android_gms_internal_zzc_zzg.zzga) && zzww.equals(this.zzgb, com_google_android_gms_internal_zzc_zzg.zzgb) && zzww.equals(this.zzgc, com_google_android_gms_internal_zzc_zzg.zzgc) && zzww.equals(this.zzgd, com_google_android_gms_internal_zzc_zzg.zzgd) && zzww.equals(this.zzge, com_google_android_gms_internal_zzc_zzg.zzge)) ? zza((zzws) com_google_android_gms_internal_zzc_zzg) : false;
        }

        public int hashCode() {
            return ((((((((((((((((((((zzww.hashCode(this.zzfV) + 527) * 31) + zzww.hashCode(this.zzfW)) * 31) + zzww.hashCode(this.zzfX)) * 31) + zzww.hashCode(this.zzfY)) * 31) + zzww.hashCode(this.zzfZ)) * 31) + zzww.hashCode(this.zzga)) * 31) + zzww.hashCode(this.zzgb)) * 31) + zzww.hashCode(this.zzgc)) * 31) + zzww.hashCode(this.zzgd)) * 31) + zzww.hashCode(this.zzge)) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            int i = 0;
            if (this.zzfV != null && this.zzfV.length > 0) {
                for (int zzy : this.zzfV) {
                    com_google_android_gms_internal_zzwr.zzy(1, zzy);
                }
            }
            if (this.zzfW != null && this.zzfW.length > 0) {
                for (int zzy2 : this.zzfW) {
                    com_google_android_gms_internal_zzwr.zzy(2, zzy2);
                }
            }
            if (this.zzfX != null && this.zzfX.length > 0) {
                for (int zzy22 : this.zzfX) {
                    com_google_android_gms_internal_zzwr.zzy(3, zzy22);
                }
            }
            if (this.zzfY != null && this.zzfY.length > 0) {
                for (int zzy222 : this.zzfY) {
                    com_google_android_gms_internal_zzwr.zzy(4, zzy222);
                }
            }
            if (this.zzfZ != null && this.zzfZ.length > 0) {
                for (int zzy2222 : this.zzfZ) {
                    com_google_android_gms_internal_zzwr.zzy(5, zzy2222);
                }
            }
            if (this.zzga != null && this.zzga.length > 0) {
                for (int zzy22222 : this.zzga) {
                    com_google_android_gms_internal_zzwr.zzy(6, zzy22222);
                }
            }
            if (this.zzgb != null && this.zzgb.length > 0) {
                for (int zzy222222 : this.zzgb) {
                    com_google_android_gms_internal_zzwr.zzy(7, zzy222222);
                }
            }
            if (this.zzgc != null && this.zzgc.length > 0) {
                for (int zzy2222222 : this.zzgc) {
                    com_google_android_gms_internal_zzwr.zzy(8, zzy2222222);
                }
            }
            if (this.zzgd != null && this.zzgd.length > 0) {
                for (int zzy22222222 : this.zzgd) {
                    com_google_android_gms_internal_zzwr.zzy(9, zzy22222222);
                }
            }
            if (this.zzge != null && this.zzge.length > 0) {
                while (i < this.zzge.length) {
                    com_google_android_gms_internal_zzwr.zzy(10, this.zzge[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzh(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3 = 0;
            int zzc = super.zzc();
            if (this.zzfV == null || this.zzfV.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                for (int zziw : this.zzfV) {
                    i2 += zzwr.zziw(zziw);
                }
                i = (zzc + i2) + (this.zzfV.length * 1);
            }
            if (this.zzfW != null && this.zzfW.length > 0) {
                zzc = 0;
                for (int zziw2 : this.zzfW) {
                    zzc += zzwr.zziw(zziw2);
                }
                i = (i + zzc) + (this.zzfW.length * 1);
            }
            if (this.zzfX != null && this.zzfX.length > 0) {
                zzc = 0;
                for (int zziw22 : this.zzfX) {
                    zzc += zzwr.zziw(zziw22);
                }
                i = (i + zzc) + (this.zzfX.length * 1);
            }
            if (this.zzfY != null && this.zzfY.length > 0) {
                zzc = 0;
                for (int zziw222 : this.zzfY) {
                    zzc += zzwr.zziw(zziw222);
                }
                i = (i + zzc) + (this.zzfY.length * 1);
            }
            if (this.zzfZ != null && this.zzfZ.length > 0) {
                zzc = 0;
                for (int zziw2222 : this.zzfZ) {
                    zzc += zzwr.zziw(zziw2222);
                }
                i = (i + zzc) + (this.zzfZ.length * 1);
            }
            if (this.zzga != null && this.zzga.length > 0) {
                zzc = 0;
                for (int zziw22222 : this.zzga) {
                    zzc += zzwr.zziw(zziw22222);
                }
                i = (i + zzc) + (this.zzga.length * 1);
            }
            if (this.zzgb != null && this.zzgb.length > 0) {
                zzc = 0;
                for (int zziw222222 : this.zzgb) {
                    zzc += zzwr.zziw(zziw222222);
                }
                i = (i + zzc) + (this.zzgb.length * 1);
            }
            if (this.zzgc != null && this.zzgc.length > 0) {
                zzc = 0;
                for (int zziw2222222 : this.zzgc) {
                    zzc += zzwr.zziw(zziw2222222);
                }
                i = (i + zzc) + (this.zzgc.length * 1);
            }
            if (this.zzgd != null && this.zzgd.length > 0) {
                zzc = 0;
                for (int zziw22222222 : this.zzgd) {
                    zzc += zzwr.zziw(zziw22222222);
                }
                i = (i + zzc) + (this.zzgd.length * 1);
            }
            if (this.zzge == null || this.zzge.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zzge.length) {
                i2 += zzwr.zziw(this.zzge[i3]);
                i3++;
            }
            return (i + i2) + (this.zzge.length * 1);
        }

        public zzg zzh(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                Object obj;
                int zzip;
                Object obj2;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 8);
                        zzvu = this.zzfV == null ? 0 : this.zzfV.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfV, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzfV = obj;
                        continue;
                    case 10:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzfV == null ? 0 : this.zzfV.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfV, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfV = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 16:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 16);
                        zzvu = this.zzfW == null ? 0 : this.zzfW.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfW, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzfW = obj;
                        continue;
                    case 18:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzfW == null ? 0 : this.zzfW.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfW, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfW = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 24:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 24);
                        zzvu = this.zzfX == null ? 0 : this.zzfX.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfX, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzfX = obj;
                        continue;
                    case 26:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzfX == null ? 0 : this.zzfX.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfX = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 32:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 32);
                        zzvu = this.zzfY == null ? 0 : this.zzfY.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfY, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzfY = obj;
                        continue;
                    case 34:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzfY == null ? 0 : this.zzfY.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfY, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfY = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 40:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 40);
                        zzvu = this.zzfZ == null ? 0 : this.zzfZ.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzfZ, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzfZ = obj;
                        continue;
                    case 42:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzfZ == null ? 0 : this.zzfZ.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzfZ, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzfZ = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 48:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 48);
                        zzvu = this.zzga == null ? 0 : this.zzga.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzga, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzga = obj;
                        continue;
                    case 50:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzga == null ? 0 : this.zzga.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzga, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzga = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 56:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 56);
                        zzvu = this.zzgb == null ? 0 : this.zzgb.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgb, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgb = obj;
                        continue;
                    case 58:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgb == null ? 0 : this.zzgb.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgb, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgb = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 64:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 64);
                        zzvu = this.zzgc == null ? 0 : this.zzgc.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgc, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgc = obj;
                        continue;
                    case 66:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgc == null ? 0 : this.zzgc.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgc, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgc = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case Place.TYPE_PHARMACY /*72*/:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 72);
                        zzvu = this.zzgd == null ? 0 : this.zzgd.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgd, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgd = obj;
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgd == null ? 0 : this.zzgd.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgd, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgd = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 80);
                        zzvu = this.zzge == null ? 0 : this.zzge.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzge, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzge = obj;
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzge == null ? 0 : this.zzge.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzge, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzge = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzg zzm() {
            this.zzfV = zzxb.zzaHO;
            this.zzfW = zzxb.zzaHO;
            this.zzfX = zzxb.zzaHO;
            this.zzfY = zzxb.zzaHO;
            this.zzfZ = zzxb.zzaHO;
            this.zzga = zzxb.zzaHO;
            this.zzgb = zzxb.zzaHO;
            this.zzgc = zzxb.zzaHO;
            this.zzgd = zzxb.zzaHO;
            this.zzge = zzxb.zzaHO;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzh extends zzws<zzh> {
        public static final zzwt<com.google.android.gms.internal.zzd.zza, zzh> zzgf = zzwt.zza(11, zzh.class, 810);
        private static final zzh[] zzgg = new zzh[0];
        public int[] zzgh;
        public int[] zzgi;
        public int[] zzgj;
        public int zzgk;
        public int[] zzgl;
        public int zzgm;
        public int zzgn;

        public zzh() {
            zzn();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzc_zzh = (zzh) obj;
            return (zzww.equals(this.zzgh, com_google_android_gms_internal_zzc_zzh.zzgh) && zzww.equals(this.zzgi, com_google_android_gms_internal_zzc_zzh.zzgi) && zzww.equals(this.zzgj, com_google_android_gms_internal_zzc_zzh.zzgj) && this.zzgk == com_google_android_gms_internal_zzc_zzh.zzgk && zzww.equals(this.zzgl, com_google_android_gms_internal_zzc_zzh.zzgl) && this.zzgm == com_google_android_gms_internal_zzc_zzh.zzgm && this.zzgn == com_google_android_gms_internal_zzc_zzh.zzgn) ? zza((zzws) com_google_android_gms_internal_zzc_zzh) : false;
        }

        public int hashCode() {
            return ((((((((((((((zzww.hashCode(this.zzgh) + 527) * 31) + zzww.hashCode(this.zzgi)) * 31) + zzww.hashCode(this.zzgj)) * 31) + this.zzgk) * 31) + zzww.hashCode(this.zzgl)) * 31) + this.zzgm) * 31) + this.zzgn) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            int i = 0;
            if (this.zzgh != null && this.zzgh.length > 0) {
                for (int zzy : this.zzgh) {
                    com_google_android_gms_internal_zzwr.zzy(1, zzy);
                }
            }
            if (this.zzgi != null && this.zzgi.length > 0) {
                for (int zzy2 : this.zzgi) {
                    com_google_android_gms_internal_zzwr.zzy(2, zzy2);
                }
            }
            if (this.zzgj != null && this.zzgj.length > 0) {
                for (int zzy22 : this.zzgj) {
                    com_google_android_gms_internal_zzwr.zzy(3, zzy22);
                }
            }
            if (this.zzgk != 0) {
                com_google_android_gms_internal_zzwr.zzy(4, this.zzgk);
            }
            if (this.zzgl != null && this.zzgl.length > 0) {
                while (i < this.zzgl.length) {
                    com_google_android_gms_internal_zzwr.zzy(5, this.zzgl[i]);
                    i++;
                }
            }
            if (this.zzgm != 0) {
                com_google_android_gms_internal_zzwr.zzy(6, this.zzgm);
            }
            if (this.zzgn != 0) {
                com_google_android_gms_internal_zzwr.zzy(7, this.zzgn);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzi(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i;
            int i2;
            int i3 = 0;
            int zzc = super.zzc();
            if (this.zzgh == null || this.zzgh.length <= 0) {
                i = zzc;
            } else {
                i2 = 0;
                for (int zziw : this.zzgh) {
                    i2 += zzwr.zziw(zziw);
                }
                i = (zzc + i2) + (this.zzgh.length * 1);
            }
            if (this.zzgi != null && this.zzgi.length > 0) {
                zzc = 0;
                for (int zziw2 : this.zzgi) {
                    zzc += zzwr.zziw(zziw2);
                }
                i = (i + zzc) + (this.zzgi.length * 1);
            }
            if (this.zzgj != null && this.zzgj.length > 0) {
                zzc = 0;
                for (int zziw22 : this.zzgj) {
                    zzc += zzwr.zziw(zziw22);
                }
                i = (i + zzc) + (this.zzgj.length * 1);
            }
            if (this.zzgk != 0) {
                i += zzwr.zzA(4, this.zzgk);
            }
            if (this.zzgl != null && this.zzgl.length > 0) {
                i2 = 0;
                while (i3 < this.zzgl.length) {
                    i2 += zzwr.zziw(this.zzgl[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzgl.length * 1);
            }
            if (this.zzgm != 0) {
                i += zzwr.zzA(6, this.zzgm);
            }
            return this.zzgn != 0 ? i + zzwr.zzA(7, this.zzgn) : i;
        }

        public zzh zzi(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                Object obj;
                int zzip;
                Object obj2;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 8);
                        zzvu = this.zzgh == null ? 0 : this.zzgh.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgh, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgh = obj;
                        continue;
                    case 10:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgh == null ? 0 : this.zzgh.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgh, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgh = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 16:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 16);
                        zzvu = this.zzgi == null ? 0 : this.zzgi.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgi, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgi = obj;
                        continue;
                    case 18:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgi == null ? 0 : this.zzgi.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgi, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgi = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 24:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 24);
                        zzvu = this.zzgj == null ? 0 : this.zzgj.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgj, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgj = obj;
                        continue;
                    case 26:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgj == null ? 0 : this.zzgj.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgj, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgj = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 32:
                        this.zzgk = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 40:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 40);
                        zzvu = this.zzgl == null ? 0 : this.zzgl.length;
                        obj = new int[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgl, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvx();
                        this.zzgl = obj;
                        continue;
                    case 42:
                        zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvx();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzgl == null ? 0 : this.zzgl.length;
                        obj2 = new int[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzgl, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvx();
                            zzc++;
                        }
                        this.zzgl = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 48:
                        this.zzgm = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 56:
                        this.zzgn = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzh zzn() {
            this.zzgh = zzxb.zzaHO;
            this.zzgi = zzxb.zzaHO;
            this.zzgj = zzxb.zzaHO;
            this.zzgk = 0;
            this.zzgl = zzxb.zzaHO;
            this.zzgm = 0;
            this.zzgn = 0;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzi extends zzws<zzi> {
        private static volatile zzi[] zzgo;
        public String name;
        public com.google.android.gms.internal.zzd.zza zzgp;
        public zzd zzgq;

        public zzi() {
            zzp();
        }

        public static zzi[] zzo() {
            if (zzgo == null) {
                synchronized (zzww.zzaHL) {
                    if (zzgo == null) {
                        zzgo = new zzi[0];
                    }
                }
            }
            return zzgo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzc_zzi = (zzi) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzc_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzc_zzi.name)) {
                return false;
            }
            if (this.zzgp == null) {
                if (com_google_android_gms_internal_zzc_zzi.zzgp != null) {
                    return false;
                }
            } else if (!this.zzgp.equals(com_google_android_gms_internal_zzc_zzi.zzgp)) {
                return false;
            }
            if (this.zzgq == null) {
                if (com_google_android_gms_internal_zzc_zzi.zzgq != null) {
                    return false;
                }
            } else if (!this.zzgq.equals(com_google_android_gms_internal_zzc_zzi.zzgq)) {
                return false;
            }
            return zza((zzws) com_google_android_gms_internal_zzc_zzi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzgp == null ? 0 : this.zzgp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zzgq != null) {
                i = this.zzgq.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (!this.name.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(1, this.name);
            }
            if (this.zzgp != null) {
                com_google_android_gms_internal_zzwr.zza(2, this.zzgp);
            }
            if (this.zzgq != null) {
                com_google_android_gms_internal_zzwr.zza(3, this.zzgq);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzj(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.name.equals("")) {
                zzc += zzwr.zzj(1, this.name);
            }
            if (this.zzgp != null) {
                zzc += zzwr.zzc(2, this.zzgp);
            }
            return this.zzgq != null ? zzc + zzwr.zzc(3, this.zzgq) : zzc;
        }

        public zzi zzj(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 18:
                        if (this.zzgp == null) {
                            this.zzgp = new com.google.android.gms.internal.zzd.zza();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzgp);
                        continue;
                    case 26:
                        if (this.zzgq == null) {
                            this.zzgq = new zzd();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzgq);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzi zzp() {
            this.name = "";
            this.zzgp = null;
            this.zzgq = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzj extends zzws<zzj> {
        public zzi[] zzgr;
        public zzf zzgs;
        public String zzgt;

        public zzj() {
            zzq();
        }

        public static zzj zzb(byte[] bArr) {
            return (zzj) zzwy.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzc_zzj = (zzj) obj;
            if (!zzww.equals(this.zzgr, com_google_android_gms_internal_zzc_zzj.zzgr)) {
                return false;
            }
            if (this.zzgs == null) {
                if (com_google_android_gms_internal_zzc_zzj.zzgs != null) {
                    return false;
                }
            } else if (!this.zzgs.equals(com_google_android_gms_internal_zzc_zzj.zzgs)) {
                return false;
            }
            if (this.zzgt == null) {
                if (com_google_android_gms_internal_zzc_zzj.zzgt != null) {
                    return false;
                }
            } else if (!this.zzgt.equals(com_google_android_gms_internal_zzc_zzj.zzgt)) {
                return false;
            }
            return zza((zzws) com_google_android_gms_internal_zzc_zzj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzgs == null ? 0 : this.zzgs.hashCode()) + ((zzww.hashCode(this.zzgr) + 527) * 31)) * 31;
            if (this.zzgt != null) {
                i = this.zzgt.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzgr != null && this.zzgr.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzgr) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(1, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzgs != null) {
                com_google_android_gms_internal_zzwr.zza(2, this.zzgs);
            }
            if (!this.zzgt.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(3, this.zzgt);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzk(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzgr != null && this.zzgr.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzgr) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        zzc += zzwr.zzc(1, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzgs != null) {
                zzc += zzwr.zzc(2, this.zzgs);
            }
            return !this.zzgt.equals("") ? zzc + zzwr.zzj(3, this.zzgt) : zzc;
        }

        public zzj zzk(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 10);
                        zzvu = this.zzgr == null ? 0 : this.zzgr.length;
                        Object obj = new zzi[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgr, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzi();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzi();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzgr = obj;
                        continue;
                    case 18:
                        if (this.zzgs == null) {
                            this.zzgs = new zzf();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzgs);
                        continue;
                    case 26:
                        this.zzgt = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzj zzq() {
            this.zzgr = zzi.zzo();
            this.zzgs = null;
            this.zzgt = "";
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
