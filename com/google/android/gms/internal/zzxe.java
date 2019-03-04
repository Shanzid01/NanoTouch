package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;

public interface zzxe {

    public final class zza extends zzwy {
        public String description;
        public String name;
        public Long zzaIL;
        public Long zzaIM;
        public Long zzaIN;
        public Integer zzaIO;
        public com.google.android.gms.internal.zzxc.zza zzaIe;
        public String zzfl;

        public zza() {
            zzwn();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzxe_zza = (zza) obj;
            if (this.zzfl == null) {
                if (com_google_android_gms_internal_zzxe_zza.zzfl != null) {
                    return false;
                }
            } else if (!this.zzfl.equals(com_google_android_gms_internal_zzxe_zza.zzfl)) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzxe_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzxe_zza.name)) {
                return false;
            }
            if (this.description == null) {
                if (com_google_android_gms_internal_zzxe_zza.description != null) {
                    return false;
                }
            } else if (!this.description.equals(com_google_android_gms_internal_zzxe_zza.description)) {
                return false;
            }
            if (this.zzaIL == null) {
                if (com_google_android_gms_internal_zzxe_zza.zzaIL != null) {
                    return false;
                }
            } else if (!this.zzaIL.equals(com_google_android_gms_internal_zzxe_zza.zzaIL)) {
                return false;
            }
            if (this.zzaIM == null) {
                if (com_google_android_gms_internal_zzxe_zza.zzaIM != null) {
                    return false;
                }
            } else if (!this.zzaIM.equals(com_google_android_gms_internal_zzxe_zza.zzaIM)) {
                return false;
            }
            if (this.zzaIN == null) {
                if (com_google_android_gms_internal_zzxe_zza.zzaIN != null) {
                    return false;
                }
            } else if (!this.zzaIN.equals(com_google_android_gms_internal_zzxe_zza.zzaIN)) {
                return false;
            }
            if (this.zzaIe == null) {
                if (com_google_android_gms_internal_zzxe_zza.zzaIe != null) {
                    return false;
                }
            } else if (!this.zzaIe.equals(com_google_android_gms_internal_zzxe_zza.zzaIe)) {
                return false;
            }
            return this.zzaIO == null ? com_google_android_gms_internal_zzxe_zza.zzaIO == null : this.zzaIO.equals(com_google_android_gms_internal_zzxe_zza.zzaIO);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaIe == null ? 0 : this.zzaIe.hashCode()) + (((this.zzaIN == null ? 0 : this.zzaIN.hashCode()) + (((this.zzaIM == null ? 0 : this.zzaIM.hashCode()) + (((this.zzaIL == null ? 0 : this.zzaIL.hashCode()) + (((this.description == null ? 0 : this.description.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzfl == null ? 0 : this.zzfl.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaIO != null) {
                i = this.zzaIO.hashCode();
            }
            return hashCode + i;
        }

        public zza zzJ(zzwq com_google_android_gms_internal_zzwq) {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case 0:
                        break;
                    case 10:
                        this.zzfl = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 18:
                        this.name = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 26:
                        this.description = com_google_android_gms_internal_zzwq.readString();
                        continue;
                    case 32:
                        this.zzaIL = Long.valueOf(com_google_android_gms_internal_zzwq.zzvw());
                        continue;
                    case 40:
                        this.zzaIM = Long.valueOf(com_google_android_gms_internal_zzwq.zzvw());
                        continue;
                    case 64:
                        this.zzaIN = Long.valueOf(com_google_android_gms_internal_zzwq.zzvw());
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        if (this.zzaIe == null) {
                            this.zzaIe = new com.google.android.gms.internal.zzxc.zza();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaIe);
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        this.zzaIO = Integer.valueOf(com_google_android_gms_internal_zzwq.zzvx());
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
            if (this.zzfl != null) {
                com_google_android_gms_internal_zzwr.zzb(1, this.zzfl);
            }
            if (this.name != null) {
                com_google_android_gms_internal_zzwr.zzb(2, this.name);
            }
            if (this.description != null) {
                com_google_android_gms_internal_zzwr.zzb(3, this.description);
            }
            if (this.zzaIL != null) {
                com_google_android_gms_internal_zzwr.zzb(4, this.zzaIL.longValue());
            }
            if (this.zzaIM != null) {
                com_google_android_gms_internal_zzwr.zzb(5, this.zzaIM.longValue());
            }
            if (this.zzaIN != null) {
                com_google_android_gms_internal_zzwr.zzb(8, this.zzaIN.longValue());
            }
            if (this.zzaIe != null) {
                com_google_android_gms_internal_zzwr.zza(9, this.zzaIe);
            }
            if (this.zzaIO != null) {
                com_google_android_gms_internal_zzwr.zzy(10, this.zzaIO.intValue());
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
            return zzJ(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc();
            if (this.zzfl != null) {
                zzc += zzwr.zzj(1, this.zzfl);
            }
            if (this.name != null) {
                zzc += zzwr.zzj(2, this.name);
            }
            if (this.description != null) {
                zzc += zzwr.zzj(3, this.description);
            }
            if (this.zzaIL != null) {
                zzc += zzwr.zzd(4, this.zzaIL.longValue());
            }
            if (this.zzaIM != null) {
                zzc += zzwr.zzd(5, this.zzaIM.longValue());
            }
            if (this.zzaIN != null) {
                zzc += zzwr.zzd(8, this.zzaIN.longValue());
            }
            if (this.zzaIe != null) {
                zzc += zzwr.zzc(9, this.zzaIe);
            }
            return this.zzaIO != null ? zzc + zzwr.zzA(10, this.zzaIO.intValue()) : zzc;
        }

        public zza zzwn() {
            this.zzfl = null;
            this.name = null;
            this.description = null;
            this.zzaIL = null;
            this.zzaIM = null;
            this.zzaIN = null;
            this.zzaIe = null;
            this.zzaIO = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
