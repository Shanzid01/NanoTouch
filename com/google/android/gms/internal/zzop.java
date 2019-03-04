package com.google.android.gms.internal;

public interface zzop {

    public final class zza extends zzws<zza> {
        public zza[] zzale;

        public final class zza extends zzws<zza> {
            private static volatile zza[] zzalf;
            public int viewId;
            public String zzalg;
            public String zzalh;

            public zza() {
                zzph();
            }

            public static zza[] zzpg() {
                if (zzalf == null) {
                    synchronized (zzww.zzaHL) {
                        if (zzalf == null) {
                            zzalf = new zza[0];
                        }
                    }
                }
                return zzalf;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzop_zza_zza = (zza) obj;
                if (this.zzalg == null) {
                    if (com_google_android_gms_internal_zzop_zza_zza.zzalg != null) {
                        return false;
                    }
                } else if (!this.zzalg.equals(com_google_android_gms_internal_zzop_zza_zza.zzalg)) {
                    return false;
                }
                if (this.zzalh == null) {
                    if (com_google_android_gms_internal_zzop_zza_zza.zzalh != null) {
                        return false;
                    }
                } else if (!this.zzalh.equals(com_google_android_gms_internal_zzop_zza_zza.zzalh)) {
                    return false;
                }
                return this.viewId == com_google_android_gms_internal_zzop_zza_zza.viewId ? zza((zzws) com_google_android_gms_internal_zzop_zza_zza) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzalg == null ? 0 : this.zzalg.hashCode()) + 527) * 31;
                if (this.zzalh != null) {
                    i = this.zzalh.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + zzvL();
            }

            public void zza(zzwr com_google_android_gms_internal_zzwr) {
                if (!this.zzalg.equals("")) {
                    com_google_android_gms_internal_zzwr.zzb(1, this.zzalg);
                }
                if (!this.zzalh.equals("")) {
                    com_google_android_gms_internal_zzwr.zzb(2, this.zzalh);
                }
                if (this.viewId != 0) {
                    com_google_android_gms_internal_zzwr.zzy(3, this.viewId);
                }
                super.zza(com_google_android_gms_internal_zzwr);
            }

            public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
                return zzp(com_google_android_gms_internal_zzwq);
            }

            protected int zzc() {
                int zzc = super.zzc();
                if (!this.zzalg.equals("")) {
                    zzc += zzwr.zzj(1, this.zzalg);
                }
                if (!this.zzalh.equals("")) {
                    zzc += zzwr.zzj(2, this.zzalh);
                }
                return this.viewId != 0 ? zzc + zzwr.zzA(3, this.viewId) : zzc;
            }

            public zza zzp(zzwq com_google_android_gms_internal_zzwq) {
                while (true) {
                    int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                    switch (zzvu) {
                        case 0:
                            break;
                        case 10:
                            this.zzalg = com_google_android_gms_internal_zzwq.readString();
                            continue;
                        case 18:
                            this.zzalh = com_google_android_gms_internal_zzwq.readString();
                            continue;
                        case 24:
                            this.viewId = com_google_android_gms_internal_zzwq.zzvx();
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

            public zza zzph() {
                this.zzalg = "";
                this.zzalh = "";
                this.viewId = 0;
                this.zzaHB = null;
                this.zzaHM = -1;
                return this;
            }
        }

        public zza() {
            zzpf();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzop_zza = (zza) obj;
            return zzww.equals(this.zzale, com_google_android_gms_internal_zzop_zza.zzale) ? zza((zzws) com_google_android_gms_internal_zzop_zza) : false;
        }

        public int hashCode() {
            return ((zzww.hashCode(this.zzale) + 527) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzale != null && this.zzale.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzale) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(1, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzo(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzale != null && this.zzale.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzale) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        zzc += zzwr.zzc(1, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            return zzc;
        }

        public zza zzo(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 10);
                        zzvu = this.zzale == null ? 0 : this.zzale.length;
                        Object obj = new zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzale, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzale = obj;
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

        public zza zzpf() {
            this.zzale = zza.zzpg();
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzb extends zzws<zzb> {
        private static volatile zzb[] zzali;
        public String name;
        public zzd zzalj;

        public zzb() {
            zzpj();
        }

        public static zzb[] zzpi() {
            if (zzali == null) {
                synchronized (zzww.zzaHL) {
                    if (zzali == null) {
                        zzali = new zzb[0];
                    }
                }
            }
            return zzali;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzop_zzb = (zzb) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzop_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzop_zzb.name)) {
                return false;
            }
            if (this.zzalj == null) {
                if (com_google_android_gms_internal_zzop_zzb.zzalj != null) {
                    return false;
                }
            } else if (!this.zzalj.equals(com_google_android_gms_internal_zzop_zzb.zzalj)) {
                return false;
            }
            return zza((zzws) com_google_android_gms_internal_zzop_zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzalj != null) {
                i = this.zzalj.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (!this.name.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(1, this.name);
            }
            if (this.zzalj != null) {
                com_google_android_gms_internal_zzwr.zza(2, this.zzalj);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzq(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.name.equals("")) {
                zzc += zzwr.zzj(1, this.name);
            }
            return this.zzalj != null ? zzc + zzwr.zzc(2, this.zzalj) : zzc;
        }

        public zzb zzpj() {
            this.name = "";
            this.zzalj = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public zzb zzq(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 18:
                        if (this.zzalj == null) {
                            this.zzalj = new zzd();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzalj);
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
    }

    public final class zzc extends zzws<zzc> {
        public String type;
        public zzb[] zzalk;

        public zzc() {
            zzpk();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzop_zzc = (zzc) obj;
            if (this.type == null) {
                if (com_google_android_gms_internal_zzop_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzop_zzc.type)) {
                return false;
            }
            return zzww.equals(this.zzalk, com_google_android_gms_internal_zzop_zzc.zzalk) ? zza((zzws) com_google_android_gms_internal_zzop_zzc) : false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzww.hashCode(this.zzalk)) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (!this.type.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(1, this.type);
            }
            if (this.zzalk != null && this.zzalk.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzalk) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(2, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzr(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (!this.type.equals("")) {
                zzc += zzwr.zzj(1, this.type);
            }
            if (this.zzalk == null || this.zzalk.length <= 0) {
                return zzc;
            }
            int i = zzc;
            for (zzwy com_google_android_gms_internal_zzwy : this.zzalk) {
                if (com_google_android_gms_internal_zzwy != null) {
                    i += zzwr.zzc(2, com_google_android_gms_internal_zzwy);
                }
            }
            return i;
        }

        public zzc zzpk() {
            this.type = "";
            this.zzalk = zzb.zzpi();
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public zzc zzr(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.type = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 18:
                        int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 18);
                        zzvu = this.zzalk == null ? 0 : this.zzalk.length;
                        Object obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzalk, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzalk = obj;
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
    }

    public final class zzd extends zzws<zzd> {
        public String zzQN;
        public boolean zzall;
        public long zzalm;
        public double zzaln;
        public zzc zzalo;

        public zzd() {
            zzpl();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzop_zzd = (zzd) obj;
            if (this.zzall != com_google_android_gms_internal_zzop_zzd.zzall) {
                return false;
            }
            if (this.zzQN == null) {
                if (com_google_android_gms_internal_zzop_zzd.zzQN != null) {
                    return false;
                }
            } else if (!this.zzQN.equals(com_google_android_gms_internal_zzop_zzd.zzQN)) {
                return false;
            }
            if (this.zzalm != com_google_android_gms_internal_zzop_zzd.zzalm || Double.doubleToLongBits(this.zzaln) != Double.doubleToLongBits(com_google_android_gms_internal_zzop_zzd.zzaln)) {
                return false;
            }
            if (this.zzalo == null) {
                if (com_google_android_gms_internal_zzop_zzd.zzalo != null) {
                    return false;
                }
            } else if (!this.zzalo.equals(com_google_android_gms_internal_zzop_zzd.zzalo)) {
                return false;
            }
            return zza((zzws) com_google_android_gms_internal_zzop_zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzQN == null ? 0 : this.zzQN.hashCode()) + (((this.zzall ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzalm ^ (this.zzalm >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaln);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.zzalo != null) {
                i = this.zzalo.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            if (this.zzall) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzall);
            }
            if (!this.zzQN.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(2, this.zzQN);
            }
            if (this.zzalm != 0) {
                com_google_android_gms_internal_zzwr.zzb(3, this.zzalm);
            }
            if (Double.doubleToLongBits(this.zzaln) != Double.doubleToLongBits(0.0d)) {
                com_google_android_gms_internal_zzwr.zza(4, this.zzaln);
            }
            if (this.zzalo != null) {
                com_google_android_gms_internal_zzwr.zza(5, this.zzalo);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzs(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzall) {
                zzc += zzwr.zzc(1, this.zzall);
            }
            if (!this.zzQN.equals("")) {
                zzc += zzwr.zzj(2, this.zzQN);
            }
            if (this.zzalm != 0) {
                zzc += zzwr.zzd(3, this.zzalm);
            }
            if (Double.doubleToLongBits(this.zzaln) != Double.doubleToLongBits(0.0d)) {
                zzc += zzwr.zzb(4, this.zzaln);
            }
            return this.zzalo != null ? zzc + zzwr.zzc(5, this.zzalo) : zzc;
        }

        public zzd zzpl() {
            this.zzall = false;
            this.zzQN = "";
            this.zzalm = 0;
            this.zzaln = 0.0d;
            this.zzalo = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }

        public zzd zzs(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzall = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    case 18:
                        this.zzQN = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 24:
                        this.zzalm = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 33:
                        this.zzaln = com_google_android_gms_internal_zzwq.readDouble();
                        continue;
                    case 42:
                        if (this.zzalo == null) {
                            this.zzalo = new zzc();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzalo);
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
    }
}
