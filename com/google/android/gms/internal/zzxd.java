package com.google.android.gms.internal;

import com.google.android.gms.internal.zzxc.zzf;
import com.google.android.gms.location.places.Place;

public interface zzxd {

    public final class zza extends zzwy {
        public long zzaIq;
        public long zzaIr;
        public int zzaIs;
        public com.google.android.gms.internal.zzxe.zza zzaIt;
        public int zzaIu;
        public zzc[] zzaIv;
        public int zzaIw;
        public boolean zzaIx;
        public com.google.android.gms.internal.zzxc.zzb[] zzaIy;

        public zza() {
            zzwi();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzxd_zza = (zza) obj;
            if (this.zzaIq != com_google_android_gms_internal_zzxd_zza.zzaIq) {
                return false;
            }
            if (this.zzaIr != com_google_android_gms_internal_zzxd_zza.zzaIr) {
                return false;
            }
            if (this.zzaIs != com_google_android_gms_internal_zzxd_zza.zzaIs) {
                return false;
            }
            if (this.zzaIt == null) {
                if (com_google_android_gms_internal_zzxd_zza.zzaIt != null) {
                    return false;
                }
            } else if (!this.zzaIt.equals(com_google_android_gms_internal_zzxd_zza.zzaIt)) {
                return false;
            }
            return this.zzaIu != com_google_android_gms_internal_zzxd_zza.zzaIu ? false : !zzww.equals(this.zzaIv, com_google_android_gms_internal_zzxd_zza.zzaIv) ? false : this.zzaIw != com_google_android_gms_internal_zzxd_zza.zzaIw ? false : this.zzaIx != com_google_android_gms_internal_zzxd_zza.zzaIx ? false : zzww.equals(this.zzaIy, com_google_android_gms_internal_zzxd_zza.zzaIy);
        }

        public int hashCode() {
            return (((this.zzaIx ? 1231 : 1237) + (((((((((this.zzaIt == null ? 0 : this.zzaIt.hashCode()) + ((((((((int) (this.zzaIq ^ (this.zzaIq >>> 32))) + 527) * 31) + ((int) (this.zzaIr ^ (this.zzaIr >>> 32)))) * 31) + this.zzaIs) * 31)) * 31) + this.zzaIu) * 31) + zzww.hashCode(this.zzaIv)) * 31) + this.zzaIw) * 31)) * 31) + zzww.hashCode(this.zzaIy);
        }

        public zza zzG(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                Object obj;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIq = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 16:
                        this.zzaIr = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 24:
                        this.zzaIs = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 34:
                        if (this.zzaIt == null) {
                            this.zzaIt = new com.google.android.gms.internal.zzxe.zza();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIt);
                        continue;
                    case 40:
                        this.zzaIu = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 50:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 50);
                        zzvu = this.zzaIv == null ? 0 : this.zzaIv.length;
                        obj = new zzc[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIv, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzc();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzc();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzaIv = obj;
                        continue;
                    case 56:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.zzaIw = zzvu;
                                break;
                            default:
                                continue;
                        }
                    case 64:
                        this.zzaIx = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 74);
                        zzvu = this.zzaIy == null ? 0 : this.zzaIy.length;
                        obj = new com.google.android.gms.internal.zzxc.zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIy, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new com.google.android.gms.internal.zzxc.zzb();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new com.google.android.gms.internal.zzxc.zzb();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzaIy = obj;
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
            int i = 0;
            if (this.zzaIq != 0) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzaIq);
            }
            if (this.zzaIr != 0) {
                com_google_android_gms_internal_zzwr.zzb(2, this.zzaIr);
            }
            if (this.zzaIs != 0) {
                com_google_android_gms_internal_zzwr.zzy(3, this.zzaIs);
            }
            if (this.zzaIt != null) {
                com_google_android_gms_internal_zzwr.zza(4, this.zzaIt);
            }
            if (this.zzaIu != 0) {
                com_google_android_gms_internal_zzwr.zzy(5, this.zzaIu);
            }
            if (this.zzaIv != null && this.zzaIv.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIv) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(6, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzaIw != 0) {
                com_google_android_gms_internal_zzwr.zzy(7, this.zzaIw);
            }
            if (this.zzaIx) {
                com_google_android_gms_internal_zzwr.zzb(8, this.zzaIx);
            }
            if (this.zzaIy != null && this.zzaIy.length > 0) {
                while (i < this.zzaIy.length) {
                    zzwy com_google_android_gms_internal_zzwy2 = this.zzaIy[i];
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        com_google_android_gms_internal_zzwr.zza(9, com_google_android_gms_internal_zzwy2);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzG(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i = 0;
            int zzc = super.zzc();
            if (this.zzaIq != 0) {
                zzc += zzwr.zzd(1, this.zzaIq);
            }
            if (this.zzaIr != 0) {
                zzc += zzwr.zzd(2, this.zzaIr);
            }
            if (this.zzaIs != 0) {
                zzc += zzwr.zzA(3, this.zzaIs);
            }
            if (this.zzaIt != null) {
                zzc += zzwr.zzc(4, this.zzaIt);
            }
            if (this.zzaIu != 0) {
                zzc += zzwr.zzA(5, this.zzaIu);
            }
            if (this.zzaIv != null && this.zzaIv.length > 0) {
                int i2 = zzc;
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIv) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        i2 += zzwr.zzc(6, com_google_android_gms_internal_zzwy);
                    }
                }
                zzc = i2;
            }
            if (this.zzaIw != 0) {
                zzc += zzwr.zzA(7, this.zzaIw);
            }
            if (this.zzaIx) {
                zzc += zzwr.zzc(8, this.zzaIx);
            }
            if (this.zzaIy != null && this.zzaIy.length > 0) {
                while (i < this.zzaIy.length) {
                    zzwy com_google_android_gms_internal_zzwy2 = this.zzaIy[i];
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        zzc += zzwr.zzc(9, com_google_android_gms_internal_zzwy2);
                    }
                    i++;
                }
            }
            return zzc;
        }

        public zza zzwi() {
            this.zzaIq = 0;
            this.zzaIr = 0;
            this.zzaIs = 0;
            this.zzaIt = null;
            this.zzaIu = 0;
            this.zzaIv = zzc.zzwl();
            this.zzaIw = 0;
            this.zzaIx = false;
            this.zzaIy = com.google.android.gms.internal.zzxc.zzb.zzwa();
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzb extends zzwy {
        private static volatile zzb[] zzaIz;
        public long zzaIA;
        public long zzaIB;
        public zzf[] zzaIC;
        public int zzaID;
        public com.google.android.gms.internal.zzxc.zzb zzaIE;
        public int zzaIF;
        public com.google.android.gms.internal.zzxc.zzb zzaIG;
        public long zzaIH;
        public long zzaII;

        public zzb() {
            zzwk();
        }

        public static zzb[] zzwj() {
            if (zzaIz == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIz == null) {
                        zzaIz = new zzb[0];
                    }
                }
            }
            return zzaIz;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzxd_zzb = (zzb) obj;
            if (this.zzaIA != com_google_android_gms_internal_zzxd_zzb.zzaIA) {
                return false;
            }
            if (this.zzaIB != com_google_android_gms_internal_zzxd_zzb.zzaIB) {
                return false;
            }
            if (!zzww.equals(this.zzaIC, com_google_android_gms_internal_zzxd_zzb.zzaIC)) {
                return false;
            }
            if (this.zzaID != com_google_android_gms_internal_zzxd_zzb.zzaID) {
                return false;
            }
            if (this.zzaIE == null) {
                if (com_google_android_gms_internal_zzxd_zzb.zzaIE != null) {
                    return false;
                }
            } else if (!this.zzaIE.equals(com_google_android_gms_internal_zzxd_zzb.zzaIE)) {
                return false;
            }
            if (this.zzaIF != com_google_android_gms_internal_zzxd_zzb.zzaIF) {
                return false;
            }
            if (this.zzaIG == null) {
                if (com_google_android_gms_internal_zzxd_zzb.zzaIG != null) {
                    return false;
                }
            } else if (!this.zzaIG.equals(com_google_android_gms_internal_zzxd_zzb.zzaIG)) {
                return false;
            }
            return this.zzaIH != com_google_android_gms_internal_zzxd_zzb.zzaIH ? false : this.zzaII == com_google_android_gms_internal_zzxd_zzb.zzaII;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzaIE == null ? 0 : this.zzaIE.hashCode()) + ((((((((((int) (this.zzaIA ^ (this.zzaIA >>> 32))) + 527) * 31) + ((int) (this.zzaIB ^ (this.zzaIB >>> 32)))) * 31) + zzww.hashCode(this.zzaIC)) * 31) + this.zzaID) * 31)) * 31) + this.zzaIF) * 31;
            if (this.zzaIG != null) {
                i = this.zzaIG.hashCode();
            }
            return ((((hashCode + i) * 31) + ((int) (this.zzaIH ^ (this.zzaIH >>> 32)))) * 31) + ((int) (this.zzaII ^ (this.zzaII >>> 32)));
        }

        public zzb zzH(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaIA = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 16:
                        this.zzaIB = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case 26:
                        int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 26);
                        zzvu = this.zzaIC == null ? 0 : this.zzaIC.length;
                        Object obj = new zzf[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIC, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzf();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzf();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzaIC = obj;
                        continue;
                    case 32:
                        this.zzaID = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 42:
                        if (this.zzaIE == null) {
                            this.zzaIE = new com.google.android.gms.internal.zzxc.zzb();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIE);
                        continue;
                    case 48:
                        this.zzaIF = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 58:
                        if (this.zzaIG == null) {
                            this.zzaIG = new com.google.android.gms.internal.zzxc.zzb();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIG);
                        continue;
                    case 64:
                        this.zzaIH = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case Place.TYPE_PHARMACY /*72*/:
                        this.zzaII = com_google_android_gms_internal_zzwq.zzvw();
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
            if (this.zzaIA != 0) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzaIA);
            }
            if (this.zzaIB != 0) {
                com_google_android_gms_internal_zzwr.zzb(2, this.zzaIB);
            }
            if (this.zzaIC != null && this.zzaIC.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIC) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(3, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzaID != 0) {
                com_google_android_gms_internal_zzwr.zzy(4, this.zzaID);
            }
            if (this.zzaIE != null) {
                com_google_android_gms_internal_zzwr.zza(5, this.zzaIE);
            }
            if (this.zzaIF != 0) {
                com_google_android_gms_internal_zzwr.zzy(6, this.zzaIF);
            }
            if (this.zzaIG != null) {
                com_google_android_gms_internal_zzwr.zza(7, this.zzaIG);
            }
            if (this.zzaIH != 0) {
                com_google_android_gms_internal_zzwr.zzb(8, this.zzaIH);
            }
            if (this.zzaII != 0) {
                com_google_android_gms_internal_zzwr.zzb(9, this.zzaII);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzH(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaIA != 0) {
                zzc += zzwr.zzd(1, this.zzaIA);
            }
            if (this.zzaIB != 0) {
                zzc += zzwr.zzd(2, this.zzaIB);
            }
            if (this.zzaIC != null && this.zzaIC.length > 0) {
                int i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIC) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        i += zzwr.zzc(3, com_google_android_gms_internal_zzwy);
                    }
                }
                zzc = i;
            }
            if (this.zzaID != 0) {
                zzc += zzwr.zzA(4, this.zzaID);
            }
            if (this.zzaIE != null) {
                zzc += zzwr.zzc(5, this.zzaIE);
            }
            if (this.zzaIF != 0) {
                zzc += zzwr.zzA(6, this.zzaIF);
            }
            if (this.zzaIG != null) {
                zzc += zzwr.zzc(7, this.zzaIG);
            }
            if (this.zzaIH != 0) {
                zzc += zzwr.zzd(8, this.zzaIH);
            }
            return this.zzaII != 0 ? zzc + zzwr.zzd(9, this.zzaII) : zzc;
        }

        public zzb zzwk() {
            this.zzaIA = 0;
            this.zzaIB = 0;
            this.zzaIC = zzf.zzwg();
            this.zzaID = 0;
            this.zzaIE = null;
            this.zzaIF = 0;
            this.zzaIG = null;
            this.zzaIH = 0;
            this.zzaII = 0;
            this.zzaHM = -1;
            return this;
        }
    }

    public final class zzc extends zzwy {
        private static volatile zzc[] zzaIJ;
        public int zzaID;
        public com.google.android.gms.internal.zzxc.zzb zzaIE;
        public zzb[] zzaIK;
        public boolean zzaIx;

        public zzc() {
            zzwm();
        }

        public static zzc[] zzwl() {
            if (zzaIJ == null) {
                synchronized (zzww.zzaHL) {
                    if (zzaIJ == null) {
                        zzaIJ = new zzc[0];
                    }
                }
            }
            return zzaIJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzxd_zzc = (zzc) obj;
            if (this.zzaID != com_google_android_gms_internal_zzxd_zzc.zzaID) {
                return false;
            }
            if (this.zzaIE == null) {
                if (com_google_android_gms_internal_zzxd_zzc.zzaIE != null) {
                    return false;
                }
            } else if (!this.zzaIE.equals(com_google_android_gms_internal_zzxd_zzc.zzaIE)) {
                return false;
            }
            return !zzww.equals(this.zzaIK, com_google_android_gms_internal_zzxd_zzc.zzaIK) ? false : this.zzaIx == com_google_android_gms_internal_zzxd_zzc.zzaIx;
        }

        public int hashCode() {
            return (this.zzaIx ? 1231 : 1237) + (((((this.zzaIE == null ? 0 : this.zzaIE.hashCode()) + ((this.zzaID + 527) * 31)) * 31) + zzww.hashCode(this.zzaIK)) * 31);
        }

        public zzc zzI(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        this.zzaID = com_google_android_gms_internal_zzwq.zzvx();
                        continue;
                    case 18:
                        if (this.zzaIE == null) {
                            this.zzaIE = new com.google.android.gms.internal.zzxc.zzb();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIE);
                        continue;
                    case 26:
                        int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 26);
                        zzvu = this.zzaIK == null ? 0 : this.zzaIK.length;
                        Object obj = new zzb[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzaIK, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zzb();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zzb();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzaIK = obj;
                        continue;
                    case 32:
                        this.zzaIx = com_google_android_gms_internal_zzwq.zzvy();
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
            if (this.zzaID != 0) {
                com_google_android_gms_internal_zzwr.zzy(1, this.zzaID);
            }
            if (this.zzaIE != null) {
                com_google_android_gms_internal_zzwr.zza(2, this.zzaIE);
            }
            if (this.zzaIK != null && this.zzaIK.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIK) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(3, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzaIx) {
                com_google_android_gms_internal_zzwr.zzb(4, this.zzaIx);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzI(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzaID != 0) {
                zzc += zzwr.zzA(1, this.zzaID);
            }
            if (this.zzaIE != null) {
                zzc += zzwr.zzc(2, this.zzaIE);
            }
            if (this.zzaIK != null && this.zzaIK.length > 0) {
                int i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy : this.zzaIK) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        i += zzwr.zzc(3, com_google_android_gms_internal_zzwy);
                    }
                }
                zzc = i;
            }
            return this.zzaIx ? zzc + zzwr.zzc(4, this.zzaIx) : zzc;
        }

        public zzc zzwm() {
            this.zzaID = 0;
            this.zzaIE = null;
            this.zzaIK = zzb.zzwj();
            this.zzaIx = false;
            this.zzaHM = -1;
            return this;
        }
    }
}
