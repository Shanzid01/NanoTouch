package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;

public interface zzd {

    public final class zza extends zzws<zza> {
        private static volatile zza[] zzgu;
        public int type;
        public String zzgA;
        public long zzgB;
        public boolean zzgC;
        public zza[] zzgD;
        public int[] zzgE;
        public boolean zzgF;
        public String zzgv;
        public zza[] zzgw;
        public zza[] zzgx;
        public zza[] zzgy;
        public String zzgz;

        public zza() {
            zzs();
        }

        public static zza[] zzr() {
            if (zzgu == null) {
                synchronized (zzww.zzaHL) {
                    if (zzgu == null) {
                        zzgu = new zza[0];
                    }
                }
            }
            return zzgu;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzd_zza = (zza) obj;
            if (this.type != com_google_android_gms_internal_zzd_zza.type) {
                return false;
            }
            if (this.zzgv == null) {
                if (com_google_android_gms_internal_zzd_zza.zzgv != null) {
                    return false;
                }
            } else if (!this.zzgv.equals(com_google_android_gms_internal_zzd_zza.zzgv)) {
                return false;
            }
            if (!zzww.equals(this.zzgw, com_google_android_gms_internal_zzd_zza.zzgw) || !zzww.equals(this.zzgx, com_google_android_gms_internal_zzd_zza.zzgx) || !zzww.equals(this.zzgy, com_google_android_gms_internal_zzd_zza.zzgy)) {
                return false;
            }
            if (this.zzgz == null) {
                if (com_google_android_gms_internal_zzd_zza.zzgz != null) {
                    return false;
                }
            } else if (!this.zzgz.equals(com_google_android_gms_internal_zzd_zza.zzgz)) {
                return false;
            }
            if (this.zzgA == null) {
                if (com_google_android_gms_internal_zzd_zza.zzgA != null) {
                    return false;
                }
            } else if (!this.zzgA.equals(com_google_android_gms_internal_zzd_zza.zzgA)) {
                return false;
            }
            return (this.zzgB == com_google_android_gms_internal_zzd_zza.zzgB && this.zzgC == com_google_android_gms_internal_zzd_zza.zzgC && zzww.equals(this.zzgD, com_google_android_gms_internal_zzd_zza.zzgD) && zzww.equals(this.zzgE, com_google_android_gms_internal_zzd_zza.zzgE) && this.zzgF == com_google_android_gms_internal_zzd_zza.zzgF) ? zza((zzws) com_google_android_gms_internal_zzd_zza) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.zzgz == null ? 0 : this.zzgz.hashCode()) + (((((((((this.zzgv == null ? 0 : this.zzgv.hashCode()) + ((this.type + 527) * 31)) * 31) + zzww.hashCode(this.zzgw)) * 31) + zzww.hashCode(this.zzgx)) * 31) + zzww.hashCode(this.zzgy)) * 31)) * 31;
            if (this.zzgA != null) {
                i2 = this.zzgA.hashCode();
            }
            hashCode = ((((((this.zzgC ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.zzgB ^ (this.zzgB >>> 32)))) * 31)) * 31) + zzww.hashCode(this.zzgD)) * 31) + zzww.hashCode(this.zzgE)) * 31;
            if (!this.zzgF) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) {
            int i = 0;
            com_google_android_gms_internal_zzwr.zzy(1, this.type);
            if (!this.zzgv.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(2, this.zzgv);
            }
            if (this.zzgw != null && this.zzgw.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy : this.zzgw) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        com_google_android_gms_internal_zzwr.zza(3, com_google_android_gms_internal_zzwy);
                    }
                }
            }
            if (this.zzgx != null && this.zzgx.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy2 : this.zzgx) {
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        com_google_android_gms_internal_zzwr.zza(4, com_google_android_gms_internal_zzwy2);
                    }
                }
            }
            if (this.zzgy != null && this.zzgy.length > 0) {
                for (zzwy com_google_android_gms_internal_zzwy22 : this.zzgy) {
                    if (com_google_android_gms_internal_zzwy22 != null) {
                        com_google_android_gms_internal_zzwr.zza(5, com_google_android_gms_internal_zzwy22);
                    }
                }
            }
            if (!this.zzgz.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(6, this.zzgz);
            }
            if (!this.zzgA.equals("")) {
                com_google_android_gms_internal_zzwr.zzb(7, this.zzgA);
            }
            if (this.zzgB != 0) {
                com_google_android_gms_internal_zzwr.zzb(8, this.zzgB);
            }
            if (this.zzgF) {
                com_google_android_gms_internal_zzwr.zzb(9, this.zzgF);
            }
            if (this.zzgE != null && this.zzgE.length > 0) {
                for (int zzy : this.zzgE) {
                    com_google_android_gms_internal_zzwr.zzy(10, zzy);
                }
            }
            if (this.zzgD != null && this.zzgD.length > 0) {
                while (i < this.zzgD.length) {
                    zzwy com_google_android_gms_internal_zzwy3 = this.zzgD[i];
                    if (com_google_android_gms_internal_zzwy3 != null) {
                        com_google_android_gms_internal_zzwr.zza(11, com_google_android_gms_internal_zzwy3);
                    }
                    i++;
                }
            }
            if (this.zzgC) {
                com_google_android_gms_internal_zzwr.zzb(12, this.zzgC);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzl(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int i;
            int i2 = 0;
            int zzc = super.zzc() + zzwr.zzA(1, this.type);
            if (!this.zzgv.equals("")) {
                zzc += zzwr.zzj(2, this.zzgv);
            }
            if (this.zzgw != null && this.zzgw.length > 0) {
                i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy : this.zzgw) {
                    if (com_google_android_gms_internal_zzwy != null) {
                        i += zzwr.zzc(3, com_google_android_gms_internal_zzwy);
                    }
                }
                zzc = i;
            }
            if (this.zzgx != null && this.zzgx.length > 0) {
                i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy2 : this.zzgx) {
                    if (com_google_android_gms_internal_zzwy2 != null) {
                        i += zzwr.zzc(4, com_google_android_gms_internal_zzwy2);
                    }
                }
                zzc = i;
            }
            if (this.zzgy != null && this.zzgy.length > 0) {
                i = zzc;
                for (zzwy com_google_android_gms_internal_zzwy22 : this.zzgy) {
                    if (com_google_android_gms_internal_zzwy22 != null) {
                        i += zzwr.zzc(5, com_google_android_gms_internal_zzwy22);
                    }
                }
                zzc = i;
            }
            if (!this.zzgz.equals("")) {
                zzc += zzwr.zzj(6, this.zzgz);
            }
            if (!this.zzgA.equals("")) {
                zzc += zzwr.zzj(7, this.zzgA);
            }
            if (this.zzgB != 0) {
                zzc += zzwr.zzd(8, this.zzgB);
            }
            if (this.zzgF) {
                zzc += zzwr.zzc(9, this.zzgF);
            }
            if (this.zzgE != null && this.zzgE.length > 0) {
                int i3 = 0;
                for (int zziw : this.zzgE) {
                    i3 += zzwr.zziw(zziw);
                }
                zzc = (zzc + i3) + (this.zzgE.length * 1);
            }
            if (this.zzgD != null && this.zzgD.length > 0) {
                while (i2 < this.zzgD.length) {
                    zzwy com_google_android_gms_internal_zzwy3 = this.zzgD[i2];
                    if (com_google_android_gms_internal_zzwy3 != null) {
                        zzc += zzwr.zzc(11, com_google_android_gms_internal_zzwy3);
                    }
                    i2++;
                }
            }
            return this.zzgC ? zzc + zzwr.zzc(12, this.zzgC) : zzc;
        }

        public zza zzl(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                int zzc;
                Object obj;
                int i;
                switch (zzvu) {
                    case 0:
                        break;
                    case 8:
                        zzvu = com_google_android_gms_internal_zzwq.zzvx();
                        switch (zzvu) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzvu;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzgv = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 26:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 26);
                        zzvu = this.zzgw == null ? 0 : this.zzgw.length;
                        obj = new zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgw, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzgw = obj;
                        continue;
                    case 34:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 34);
                        zzvu = this.zzgx == null ? 0 : this.zzgx.length;
                        obj = new zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgx, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzgx = obj;
                        continue;
                    case 42:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 42);
                        zzvu = this.zzgy == null ? 0 : this.zzgy.length;
                        obj = new zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgy, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzgy = obj;
                        continue;
                    case 50:
                        this.zzgz = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 58:
                        this.zzgA = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 64:
                        this.zzgB = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case Place.TYPE_PHARMACY /*72*/:
                        this.zzgF = com_google_android_gms_internal_zzwq.zzvy();
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        int zzc2 = zzxb.zzc(com_google_android_gms_internal_zzwq, 80);
                        Object obj2 = new int[zzc2];
                        i = 0;
                        zzc = 0;
                        while (i < zzc2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zzwq.zzvu();
                            }
                            int zzvx = com_google_android_gms_internal_zzwq.zzvx();
                            switch (zzvx) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    zzvu = zzc + 1;
                                    obj2[zzc] = zzvx;
                                    break;
                                default:
                                    zzvu = zzc;
                                    break;
                            }
                            i++;
                            zzc = zzvu;
                        }
                        if (zzc != 0) {
                            zzvu = this.zzgE == null ? 0 : this.zzgE.length;
                            if (zzvu != 0 || zzc != obj2.length) {
                                Object obj3 = new int[(zzvu + zzc)];
                                if (zzvu != 0) {
                                    System.arraycopy(this.zzgE, 0, obj3, 0, zzvu);
                                }
                                System.arraycopy(obj2, 0, obj3, zzvu, zzc);
                                this.zzgE = obj3;
                                break;
                            }
                            this.zzgE = obj2;
                            break;
                        }
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        i = com_google_android_gms_internal_zzwq.zzip(com_google_android_gms_internal_zzwq.zzvB());
                        zzc = com_google_android_gms_internal_zzwq.getPosition();
                        zzvu = 0;
                        while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                            switch (com_google_android_gms_internal_zzwq.zzvx()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    zzvu++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (zzvu != 0) {
                            com_google_android_gms_internal_zzwq.zzir(zzc);
                            zzc = this.zzgE == null ? 0 : this.zzgE.length;
                            Object obj4 = new int[(zzvu + zzc)];
                            if (zzc != 0) {
                                System.arraycopy(this.zzgE, 0, obj4, 0, zzc);
                            }
                            while (com_google_android_gms_internal_zzwq.zzvG() > 0) {
                                int zzvx2 = com_google_android_gms_internal_zzwq.zzvx();
                                switch (zzvx2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        zzvu = zzc + 1;
                                        obj4[zzc] = zzvx2;
                                        zzc = zzvu;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzgE = obj4;
                        }
                        com_google_android_gms_internal_zzwq.zziq(i);
                        continue;
                    case Place.TYPE_SYNAGOGUE /*90*/:
                        zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 90);
                        zzvu = this.zzgD == null ? 0 : this.zzgD.length;
                        obj = new zza[(zzc + zzvu)];
                        if (zzvu != 0) {
                            System.arraycopy(this.zzgD, 0, obj, 0, zzvu);
                        }
                        while (zzvu < obj.length - 1) {
                            obj[zzvu] = new zza();
                            com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                            com_google_android_gms_internal_zzwq.zzvu();
                            zzvu++;
                        }
                        obj[zzvu] = new zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        this.zzgD = obj;
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.zzgC = com_google_android_gms_internal_zzwq.zzvy();
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

        public zza zzs() {
            this.type = 1;
            this.zzgv = "";
            this.zzgw = zzr();
            this.zzgx = zzr();
            this.zzgy = zzr();
            this.zzgz = "";
            this.zzgA = "";
            this.zzgB = 0;
            this.zzgC = false;
            this.zzgD = zzr();
            this.zzgE = zzxb.zzaHO;
            this.zzgF = false;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
