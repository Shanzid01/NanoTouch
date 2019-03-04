package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzlk extends zzld implements SafeParcelable {
    public static final zzll CREATOR = new zzll();
    private final String mClassName;
    private final int zzFG;
    private final zzlh zzQX;
    private final Parcel zzRe;
    private final int zzRf;
    private int zzRg;
    private int zzRh;

    zzlk(int i, Parcel parcel, zzlh com_google_android_gms_internal_zzlh) {
        this.zzFG = i;
        this.zzRe = (Parcel) zzx.zzl(parcel);
        this.zzRf = 2;
        this.zzQX = com_google_android_gms_internal_zzlh;
        if (this.zzQX == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzQX.zzjP();
        }
        this.zzRg = 2;
    }

    private zzlk(SafeParcelable safeParcelable, zzlh com_google_android_gms_internal_zzlh, String str) {
        this.zzFG = 1;
        this.zzRe = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzRe, 0);
        this.zzRf = 1;
        this.zzQX = (zzlh) zzx.zzl(com_google_android_gms_internal_zzlh);
        this.mClassName = (String) zzx.zzl(str);
        this.zzRg = 2;
    }

    private static HashMap<Integer, Entry<String, zza<?, ?>>> zzF(Map<String, zza<?, ?>> map) {
        HashMap<Integer, Entry<String, zza<?, ?>>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((zza) entry.getValue()).zzjG()), entry);
        }
        return hashMap;
    }

    public static <T extends zzld & SafeParcelable> zzlk zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new zzlk((SafeParcelable) t, zzb(t), canonicalName);
    }

    private static void zza(zzlh com_google_android_gms_internal_zzlh, zzld com_google_android_gms_internal_zzld) {
        Class cls = com_google_android_gms_internal_zzld.getClass();
        if (!com_google_android_gms_internal_zzlh.zzb(cls)) {
            Map zzjz = com_google_android_gms_internal_zzld.zzjz();
            com_google_android_gms_internal_zzlh.zza(cls, zzjz);
            for (String str : zzjz.keySet()) {
                zza com_google_android_gms_internal_zzld_zza = (zza) zzjz.get(str);
                Class zzjH = com_google_android_gms_internal_zzld_zza.zzjH();
                if (zzjH != null) {
                    try {
                        zza(com_google_android_gms_internal_zzlh, (zzld) zzjH.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + com_google_android_gms_internal_zzld_zza.zzjH().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + com_google_android_gms_internal_zzld_zza.zzjH().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void zza(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(zzma.zzbt(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzlt.zze((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzlt.zzf((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                zzmb.zza(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzld_zza___, Parcel parcel, int i) {
        switch (com_google_android_gms_internal_zzld_zza___.zzjy()) {
            case 0:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, i))));
                return;
            case 5:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i)));
                return;
            case 6:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i)));
                return;
            case 10:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, zza(com_google_android_gms_internal_zzld_zza___, zzk(com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + com_google_android_gms_internal_zzld_zza___.zzjy());
        }
    }

    private void zza(StringBuilder stringBuilder, String str, zza<?, ?> com_google_android_gms_internal_zzld_zza___, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (com_google_android_gms_internal_zzld_zza___.zzjJ()) {
            zza(stringBuilder, com_google_android_gms_internal_zzld_zza___, parcel, i);
        } else {
            zzb(stringBuilder, com_google_android_gms_internal_zzld_zza___, parcel, i);
        }
    }

    private void zza(StringBuilder stringBuilder, Map<String, zza<?, ?>> map, Parcel parcel) {
        HashMap zzF = zzF(map);
        stringBuilder.append('{');
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        Object obj = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            Entry entry = (Entry) zzF.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                zza(stringBuilder, (String) entry.getKey(), (zza) entry.getValue(), parcel, zzI);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != zzJ) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
        }
        stringBuilder.append('}');
    }

    private static zzlh zzb(zzld com_google_android_gms_internal_zzld) {
        zzlh com_google_android_gms_internal_zzlh = new zzlh(com_google_android_gms_internal_zzld.getClass());
        zza(com_google_android_gms_internal_zzlh, com_google_android_gms_internal_zzld);
        com_google_android_gms_internal_zzlh.zzjN();
        com_google_android_gms_internal_zzlh.zzjM();
        return com_google_android_gms_internal_zzlh;
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzld_zza___, Parcel parcel, int i) {
        if (com_google_android_gms_internal_zzld_zza___.zzjE()) {
            stringBuilder.append("[");
            switch (com_google_android_gms_internal_zzld_zza___.zzjy()) {
                case 0:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, i));
                    break;
                case 1:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, i));
                    break;
                case 2:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, i));
                    break;
                case 3:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzx(parcel, i));
                    break;
                case 4:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzy(parcel, i));
                    break;
                case 5:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzz(parcel, i));
                    break;
                case 6:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, i));
                    break;
                case 7:
                    zzls.zza(stringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzE = com.google.android.gms.common.internal.safeparcel.zza.zzE(parcel, i);
                    int length = zzE.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        zzE[i2].setDataPosition(0);
                        zza(stringBuilder, com_google_android_gms_internal_zzld_zza___.zzjL(), zzE[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (com_google_android_gms_internal_zzld_zza___.zzjy()) {
            case 0:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
                return;
            case 1:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i));
                return;
            case 2:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
                return;
            case 3:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
                return;
            case 4:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, i));
                return;
            case 5:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i));
                return;
            case 6:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(zzma.zzbt(com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzlt.zze(com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzlt.zzf(com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle zzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i);
                Set<String> keySet = zzq.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(zzma.zzbt(zzq.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel zzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, i);
                zzD.setDataPosition(0);
                zza(stringBuilder, com_google_android_gms_internal_zzld_zza___.zzjL(), zzD);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzld_zza___, Object obj) {
        if (com_google_android_gms_internal_zzld_zza___.zzjD()) {
            zzb(stringBuilder, (zza) com_google_android_gms_internal_zzld_zza___, (ArrayList) obj);
        } else {
            zza(stringBuilder, com_google_android_gms_internal_zzld_zza___.zzjx(), obj);
        }
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzld_zza___, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            zza(stringBuilder, com_google_android_gms_internal_zzld_zza___.zzjx(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> zzk(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int describeContents() {
        zzll com_google_android_gms_internal_zzll = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        zzx.zzb(this.zzQX, (Object) "Cannot convert to JSON on client side.");
        Parcel zzjR = zzjR();
        zzjR.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzQX.zzbs(this.mClassName), zzjR);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzll com_google_android_gms_internal_zzll = CREATOR;
        zzll.zza(this, parcel, i);
    }

    protected Object zzbo(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean zzbp(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel zzjR() {
        switch (this.zzRg) {
            case 0:
                this.zzRh = zzb.zzK(this.zzRe);
                zzb.zzH(this.zzRe, this.zzRh);
                this.zzRg = 2;
                break;
            case 1:
                zzb.zzH(this.zzRe, this.zzRh);
                this.zzRg = 2;
                break;
        }
        return this.zzRe;
    }

    zzlh zzjS() {
        switch (this.zzRf) {
            case 0:
                return null;
            case 1:
                return this.zzQX;
            case 2:
                return this.zzQX;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzRf);
        }
    }

    public Map<String, zza<?, ?>> zzjz() {
        return this.zzQX == null ? null : this.zzQX.zzbs(this.mClassName);
    }
}
