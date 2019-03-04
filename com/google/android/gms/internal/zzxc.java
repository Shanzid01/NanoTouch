package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;

public interface zzxc {

    public final class zza extends zzwy {
        public String name;
        public String packageName;
        public String version;
        public String zzaHW;
        public long[] zzaHX;

        public zza() {
            zzvZ();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzxc_zza = (zza) obj;
            if (this.packageName == null) {
                if (com_google_android_gms_internal_zzxc_zza.packageName != null) {
                    return false;
                }
            } else if (!this.packageName.equals(com_google_android_gms_internal_zzxc_zza.packageName)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzxc_zza.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzxc_zza.version)) {
                return false;
            }
            if (this.zzaHW == null) {
                if (com_google_android_gms_internal_zzxc_zza.zzaHW != null) {
                    return false;
                }
            } else if (!this.zzaHW.equals(com_google_android_gms_internal_zzxc_zza.zzaHW)) {
                return false;
            }
            return !zzww.equals(this.zzaHX, com_google_android_gms_internal_zzxc_zza.zzaHX) ? false : this.name == null ? com_google_android_gms_internal_zzxc_zza.name == null : this.name.equals(com_google_android_gms_internal_zzxc_zza.name);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaHW == null ? 0 : this.zzaHW.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.packageName == null ? 0 : this.packageName.hashCode()) + 527) * 31)) * 31)) * 31) + zzww.hashCode(this.zzaHX)) * 31;
            if (this.name != null) {
                i = this.name.hashCode();
            }
            return hashCode + i;
        }

        public zza zzA(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.packageName = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 18:
                        this.version = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 26:
                        this.zzaHW = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 32:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 32);
                        zzvu = this.zzaHX == null ? 0 : this.zzaHX.length;
                        Object obj = new long[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaHX, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = com_google_android_gms_internal_zzwq.zzvw();
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = com_google_android_gms_internal_zzwq.zzvw();
                        this.zzaHX = obj;
                        continue;
                    case 34:
                        int zzip = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            com_google_android_gms_internal_zzwq.zzvw();
                            zzvu++;
                        }
                        com_google_android_gms_internal_zzwq.zzir(zzc);
                        zzc = this.zzaHX == null ? 0 : this.zzaHX.length;
                        Object obj2 = new long[(zzvu + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzaHX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzwq.zzvw();
                            zzc++;
                        }
                        this.zzaHX = obj2;
                        com_google_android_gms_internal_zzwq.zziq(zzip);
                        continue;
                    case 42:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    default:
                        if (!zzxb.zzb(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.packageName != null) {
                com_google_android_gms_internal_zzwr.zzb(1, this.packageName);
            }
            if (this.version != null) {
                com_google_android_gms_internal_zzwr.zzb(2, this.version);
            }
            if (this.zzaHW != null) {
                com_google_android_gms_internal_zzwr.zzb(3, this.zzaHW);
            }
            if (this.zzaHX != null && this.zzaHX.length > 0) {
                for (long zzb : this.zzaHX) {
                    com_google_android_gms_internal_zzwr.zzb(4, zzb);
                }
            }
            if (this.name != null) {
                com_google_android_gms_internal_zzwr.zzb(5, this.name);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzA(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (this.packageName != null) {
                zzc += zzwr.zzj(1, this.packageName);
            }
            if (this.version != null) {
                zzc += zzwr.zzj(2, this.version);
            }
            if (this.zzaHW != null) {
                zzc += zzwr.zzj(3, this.zzaHW);
            }
            if (this.zzaHX != null && this.zzaHX.length > 0) {
                int i2 = 0;
                while (i < this.zzaHX.length) {
                    i2 += zzwr.zzN(this.zzaHX[i]);
                    i++;
                }
                zzc = (zzc + i2) + (this.zzaHX.length * 1);
            }
            return this.name != null ? zzc + zzwr.zzj(5, this.name) : zzc;
        }

        public zza zzvZ() {
            this.packageName = null;
            this.version = null;
            this.zzaHW = null;
            this.zzaHX = zzxb.zzaHP;
            this.name = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzb extends zzwy {
        private static volatile zzb[] zzaHY;
        public String name;
        public String zzaHZ;
        public String zzaIa;
        public Integer zzaIb;
        public zzc zzaIc;
        public zze zzaId;
        public zza zzaIe;

        public zzb() {
            zzwb();
        }

        public static zzb[] zzwa() {
            if (zzaHY == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaHY == null) {
                        zzaHY = new zzb[0];
                    }
                }
            }
            return zzaHY;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzxc_zzb = (zzb) obj;
            if (this.zzaHZ == null) {
                if (com_google_android_gms_internal_zzxc_zzb.zzaHZ != null) {
                    return false;
                }
            } else if (!this.zzaHZ.equals(com_google_android_gms_internal_zzxc_zzb.zzaHZ)) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzxc_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzxc_zzb.name)) {
                return false;
            }
            if (this.zzaIa == null) {
                if (com_google_android_gms_internal_zzxc_zzb.zzaIa != null) {
                    return false;
                }
            } else if (!this.zzaIa.equals(com_google_android_gms_internal_zzxc_zzb.zzaIa)) {
                return false;
            }
            if (this.zzaIb == null) {
                if (com_google_android_gms_internal_zzxc_zzb.zzaIb != null) {
                    return false;
                }
            } else if (!this.zzaIb.equals(com_google_android_gms_internal_zzxc_zzb.zzaIb)) {
                return false;
            }
            if (this.zzaIc == null) {
                if (com_google_android_gms_internal_zzxc_zzb.zzaIc != null) {
                    return false;
                }
            } else if (!this.zzaIc.equals(com_google_android_gms_internal_zzxc_zzb.zzaIc)) {
                return false;
            }
            if (this.zzaId == null) {
                if (com_google_android_gms_internal_zzxc_zzb.zzaId != null) {
                    return false;
                }
            } else if (!this.zzaId.equals(com_google_android_gms_internal_zzxc_zzb.zzaId)) {
                return false;
            }
            return this.zzaIe == null ? com_google_android_gms_internal_zzxc_zzb.zzaIe == null : this.zzaIe.equals(com_google_android_gms_internal_zzxc_zzb.zzaIe);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaId == null ? 0 : this.zzaId.hashCode()) + (((this.zzaIc == null ? 0 : this.zzaIc.hashCode()) + (((this.zzaIb == null ? 0 : this.zzaIb.intValue()) + (((this.zzaIa == null ? 0 : this.zzaIa.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzaHZ == null ? 0 : this.zzaHZ.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaIe != null) {
                i = this.zzaIe.hashCode();
            }
            return hashCode + i;
        }

        public zzb zzB(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzaHZ = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 34:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 42:
                        this.zzaIa = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 48:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                                this.zzaIb = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    case 58:
                        if (this.zzaIc == null) {
                            this.zzaIc = new zzc();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIc);
                        continue;
                    case 66:
                        if (this.zzaId == null) {
                            this.zzaId = new zze();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaId);
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        if (this.zzaIe == null) {
                            this.zzaIe = new zza();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIe);
                        continue;
                    default:
                        if (!zzxb.zzb(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzaHZ != null) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzaHZ);
            }
            if (this.name != null) {
                com_google_android_gms_internal_zzwr.zzb(4, this.name);
            }
            if (this.zzaIa != null) {
                com_google_android_gms_internal_zzwr.zzb(5, this.zzaIa);
            }
            if (this.zzaIb != null) {
                com_google_android_gms_internal_zzwr.zzy(6, this.zzaIb.intValue());
            }
            if (this.zzaIc != null) {
                com_google_android_gms_internal_zzwr.zza(7, this.zzaIc);
            }
            if (this.zzaId != null) {
                com_google_android_gms_internal_zzwr.zza(8, this.zzaId);
            }
            if (this.zzaIe != null) {
                com_google_android_gms_internal_zzwr.zza(9, this.zzaIe);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzB(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaHZ != null) {
                zzc += zzwr.zzj(1, this.zzaHZ);
            }
            if (this.name != null) {
                zzc += zzwr.zzj(4, this.name);
            }
            if (this.zzaIa != null) {
                zzc += zzwr.zzj(5, this.zzaIa);
            }
            if (this.zzaIb != null) {
                zzc += zzwr.zzA(6, this.zzaIb.intValue());
            }
            if (this.zzaIc != null) {
                zzc += zzwr.zzc(7, this.zzaIc);
            }
            if (this.zzaId != null) {
                zzc += zzwr.zzc(8, this.zzaId);
            }
            return this.zzaIe != null ? zzc + zzwr.zzc(9, this.zzaIe) : zzc;
        }

        public zzb zzwb() {
            this.zzaHZ = null;
            this.name = null;
            this.zzaIa = null;
            this.zzaIb = null;
            this.zzaIc = null;
            this.zzaId = null;
            this.zzaIe = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzc extends zzwy {
        public String name;
        public zzd[] zzaIf;

        public zzc() {
            zzwc();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzxc_zzc = (zzc) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzxc_zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzxc_zzc.name)) {
                return false;
            }
            return zzww.equals(this.zzaIf, com_google_android_gms_internal_zzxc_zzc.zzaIf);
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31) + zzww.hashCode(this.zzaIf);
        }

        public zzc zzC(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 18:
                        int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 18);
                        zzvu = this.zzaIf == null ? 0 : this.zzaIf.length;
                        Object obj = new zzd[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIf, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzd();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzd();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzaIf = obj;
                        continue;
                    default:
                        if (!zzxb.zzb(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.name != null) {
                com_google_android_gms_internal_zzwr.zzb(1, this.name);
            }
            if (this.zzaIf != null && this.zzaIf.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIf) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(2, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzC(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.name != null) {
                zzc += zzwr.zzj(1, this.name);
            }
            if (this.zzaIf == null || this.zzaIf.length <= 0) {
                return zzc;
            }
            int i = zzc;
            for (zzwy com_google_android_gms_internal_zzwy : this.zzaIf) {
                if (com_google_android_gms_internal_zzwy != null) {
                    i += zzwr.zzc(2, com_google_android_gms_internal_zzwy);
                }
            }
            return i;
        }

        public zzc zzwc() {
            this.name = null;
            this.zzaIf = zzd.zzwd();
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzd extends zzwy {
        private static volatile zzd[] zzaIg;
        public String name;
        public Integer zzaIh;
        public Boolean zzaIi;

        public zzd() {
            zzwe();
        }

        public static zzd[] zzwd() {
            if (zzaIg == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIg == null) {
                        zzaIg = new zzd[0];
                    }
                }
            }
            return zzaIg;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzxc_zzd = (zzd) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzxc_zzd.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzxc_zzd.name)) {
                return false;
            }
            if (this.zzaIh == null) {
                if (com_google_android_gms_internal_zzxc_zzd.zzaIh != null) {
                    return false;
                }
            } else if (!this.zzaIh.equals(com_google_android_gms_internal_zzxc_zzd.zzaIh)) {
                return false;
            }
            return this.zzaIi == null ? com_google_android_gms_internal_zzxc_zzd.zzaIi == null : this.zzaIi.equals(com_google_android_gms_internal_zzxc_zzd.zzaIi);
        }

        public int hashCode() {
            int i = 0;
            int intValue = ((this.zzaIh == null ? 0 : this.zzaIh.intValue()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zzaIi != null) {
                i = this.zzaIi.hashCode();
            }
            return intValue + i;
        }

        public zzd zzD(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 24:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 1:
                            case 2:
                                this.zzaIh = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        this.zzaIi = Boolean.valueOf(com_google_android_gms_internal_zzwq.zzvy());
                        continue;
                    default:
                        if (!zzxb.zzb(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.name != null) {
                com_google_android_gms_internal_zzwr.zzb(1, this.name);
            }
            if (this.zzaIh != null) {
                com_google_android_gms_internal_zzwr.zzy(3, this.zzaIh.intValue());
            }
            if (this.zzaIi != null) {
                com_google_android_gms_internal_zzwr.zzb(4, this.zzaIi.booleanValue());
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzD(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.name != null) {
                zzc += zzwr.zzj(1, this.name);
            }
            if (this.zzaIh != null) {
                zzc += zzwr.zzA(3, this.zzaIh.intValue());
            }
            return this.zzaIi != null ? zzc + zzwr.zzc(4, this.zzaIi.booleanValue()) : zzc;
        }

        public zzd zzwe() {
            this.name = null;
            this.zzaIh = null;
            this.zzaIi = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zze extends zzwy {
        public String version;
        public Integer zzaIb;
        public String zzaIj;
        public String zzaIk;
        public String zzaIl;
        public Integer zzaIm;

        public zze() {
            zzwf();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzxc_zze = (zze) obj;
            if (this.zzaIj == null) {
                if (com_google_android_gms_internal_zzxc_zze.zzaIj != null) {
                    return false;
                }
            } else if (!this.zzaIj.equals(com_google_android_gms_internal_zzxc_zze.zzaIj)) {
                return false;
            }
            if (this.zzaIb == null) {
                if (com_google_android_gms_internal_zzxc_zze.zzaIb != null) {
                    return false;
                }
            } else if (!this.zzaIb.equals(com_google_android_gms_internal_zzxc_zze.zzaIb)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzxc_zze.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzxc_zze.version)) {
                return false;
            }
            if (this.zzaIk == null) {
                if (com_google_android_gms_internal_zzxc_zze.zzaIk != null) {
                    return false;
                }
            } else if (!this.zzaIk.equals(com_google_android_gms_internal_zzxc_zze.zzaIk)) {
                return false;
            }
            if (this.zzaIl == null) {
                if (com_google_android_gms_internal_zzxc_zze.zzaIl != null) {
                    return false;
                }
            } else if (!this.zzaIl.equals(com_google_android_gms_internal_zzxc_zze.zzaIl)) {
                return false;
            }
            return this.zzaIm == null ? com_google_android_gms_internal_zzxc_zze.zzaIm == null : this.zzaIm.equals(com_google_android_gms_internal_zzxc_zze.zzaIm);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIl == null ? 0 : this.zzaIl.hashCode()) + (((this.zzaIk == null ? 0 : this.zzaIk.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzaIb == null ? 0 : this.zzaIb.intValue()) + (((this.zzaIj == null ? 0 : this.zzaIj.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaIm != null) {
                i = this.zzaIm.intValue();
            }
            return hashCode + i;
        }

        public zze zzE(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzaIj = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 16:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                this.zzaIb = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    case 26:
                        this.version = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 34:
                        this.zzaIk = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 42:
                        this.zzaIl = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 48:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzaIm = Integer.valueOf(zzvu);
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!zzxb.zzb(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzaIj != null) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzaIj);
            }
            if (this.zzaIb != null) {
                com_google_android_gms_internal_zzwr.zzy(2, this.zzaIb.intValue());
            }
            if (this.version != null) {
                com_google_android_gms_internal_zzwr.zzb(3, this.version);
            }
            if (this.zzaIk != null) {
                com_google_android_gms_internal_zzwr.zzb(4, this.zzaIk);
            }
            if (this.zzaIl != null) {
                com_google_android_gms_internal_zzwr.zzb(5, this.zzaIl);
            }
            if (this.zzaIm != null) {
                com_google_android_gms_internal_zzwr.zzy(6, this.zzaIm.intValue());
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzE(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIj != null) {
                zzc += zzwr.zzj(1, this.zzaIj);
            }
            if (this.zzaIb != null) {
                zzc += zzwr.zzA(2, this.zzaIb.intValue());
            }
            if (this.version != null) {
                zzc += zzwr.zzj(3, this.version);
            }
            if (this.zzaIk != null) {
                zzc += zzwr.zzj(4, this.zzaIk);
            }
            if (this.zzaIl != null) {
                zzc += zzwr.zzj(5, this.zzaIl);
            }
            return this.zzaIm != null ? zzc + zzwr.zzA(6, this.zzaIm.intValue()) : zzc;
        }

        public zze zzwf() {
            this.zzaIj = null;
            this.zzaIb = null;
            this.version = null;
            this.zzaIk = null;
            this.zzaIl = null;
            this.zzaIm = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzf extends zzwy {
        private static volatile zzf[] zzaIn;
        public Integer zzaIo;
        public Double zzaIp;

        public zzf() {
            zzwh();
        }

        public static zzf[] zzwg() {
            if (zzaIn == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIn == null) {
                        zzaIn = new zzf[0];
                    }
                }
            }
            return zzaIn;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzxc_zzf = (zzf) obj;
            if (this.zzaIo == null) {
                if (com_google_android_gms_internal_zzxc_zzf.zzaIo != null) {
                    return false;
                }
            } else if (!this.zzaIo.equals(com_google_android_gms_internal_zzxc_zzf.zzaIo)) {
                return false;
            }
            return this.zzaIp == null ? com_google_android_gms_internal_zzxc_zzf.zzaIp == null : this.zzaIp.equals(com_google_android_gms_internal_zzxc_zzf.zzaIp);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIo == null ? 0 : this.zzaIo.hashCode()) + 527) * 31;
            if (this.zzaIp != null) {
                i = this.zzaIp.hashCode();
            }
            return hashCode + i;
        }

        public zzf zzF(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIo = Integer.valueOf(com_google_android_gms_internal_zzwq.zzvx());
                        continue;
                    case 17:
                        this.zzaIp = Double.valueOf(com_google_android_gms_internal_zzwq.readDouble());
                        continue;
                    default:
                        if (!zzxb.zzb(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzaIo != null) {
                com_google_android_gms_internal_zzwr.zzy(1, this.zzaIo.intValue());
            }
            if (this.zzaIp != null) {
                com_google_android_gms_internal_zzwr.zza(2, this.zzaIp.doubleValue());
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzF(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIo != null) {
                zzc += zzwr.zzA(1, this.zzaIo.intValue());
            }
            return this.zzaIp != null ? zzc + zzwr.zzb(2, this.zzaIp.doubleValue()) : zzc;
        }

        public zzf zzwh() {
            this.zzaIo = null;
            this.zzaIp = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
