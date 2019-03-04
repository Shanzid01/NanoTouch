package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzc.zzf;
import com.google.android.gms.internal.zzc.zzi;
import com.google.android.gms.internal.zzc.zzj;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context mContext;
    private Map<String, FunctionCallTagCallback> zzaxA = new HashMap();
    private volatile long zzaxB;
    private volatile String zzaxC = "";
    private final String zzaxw;
    private final DataLayer zzaxx;
    private zzco zzaxy;
    private Map<String, FunctionCallMacroCallback> zzaxz = new HashMap();

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    class zza implements com.google.android.gms.tagmanager.zzs.zza {
        final /* synthetic */ Container zzaxD;

        private zza(Container container) {
            this.zzaxD = container;
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzcM = this.zzaxD.zzcM(str);
            return zzcM == null ? null : zzcM.getValue(str, map);
        }
    }

    class zzb implements com.google.android.gms.tagmanager.zzs.zza {
        final /* synthetic */ Container zzaxD;

        private zzb(Container container) {
            this.zzaxD = container;
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzcN = this.zzaxD.zzcN(str);
            if (zzcN != null) {
                zzcN.execute(str, map);
            }
            return zzde.zzue();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzj com_google_android_gms_internal_zzc_zzj) {
        this.mContext = context;
        this.zzaxx = dataLayer;
        this.zzaxw = str;
        this.zzaxB = j;
        zza(com_google_android_gms_internal_zzc_zzj.zzgs);
        if (com_google_android_gms_internal_zzc_zzj.zzgr != null) {
            zza(com_google_android_gms_internal_zzc_zzj.zzgr);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzc com_google_android_gms_internal_zzvl_zzc) {
        this.mContext = context;
        this.zzaxx = dataLayer;
        this.zzaxw = str;
        this.zzaxB = j;
        zza(com_google_android_gms_internal_zzvl_zzc);
    }

    private void zza(zzf com_google_android_gms_internal_zzc_zzf) {
        if (com_google_android_gms_internal_zzc_zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzvl.zzb(com_google_android_gms_internal_zzc_zzf));
        } catch (zzg e) {
            zzbf.zzZ("Not loading resource: " + com_google_android_gms_internal_zzc_zzf + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzc com_google_android_gms_internal_zzvl_zzc) {
        this.zzaxC = com_google_android_gms_internal_zzvl_zzc.getVersion();
        zzc com_google_android_gms_internal_zzvl_zzc2 = com_google_android_gms_internal_zzvl_zzc;
        zza(new zzco(this.mContext, com_google_android_gms_internal_zzvl_zzc2, this.zzaxx, new zza(), new zzb(), zzcP(this.zzaxC)));
    }

    private synchronized void zza(zzco com_google_android_gms_tagmanager_zzco) {
        this.zzaxy = com_google_android_gms_tagmanager_zzco;
    }

    private void zza(zzi[] com_google_android_gms_internal_zzc_zziArr) {
        List arrayList = new ArrayList();
        for (Object add : com_google_android_gms_internal_zzc_zziArr) {
            arrayList.add(add);
        }
        zzsJ().zzu(arrayList);
    }

    private synchronized zzco zzsJ() {
        return this.zzaxy;
    }

    public boolean getBoolean(String str) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getBoolean called for closed container.");
            return zzde.zzuc().booleanValue();
        }
        try {
            return zzde.zzk((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(str).getObject()).booleanValue();
        } catch (Exception e) {
            zzbf.zzZ("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzuc().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzaxw;
    }

    public double getDouble(String str) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getDouble called for closed container.");
            return zzde.zzub().doubleValue();
        }
        try {
            return zzde.zzj((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(str).getObject()).doubleValue();
        } catch (Exception e) {
            zzbf.zzZ("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzub().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzaxB;
    }

    public long getLong(String str) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getLong called for closed container.");
            return zzde.zzua().longValue();
        }
        try {
            return zzde.zzi((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(str).getObject()).longValue();
        } catch (Exception e) {
            zzbf.zzZ("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzua().longValue();
        }
    }

    public String getString(String str) {
        zzco zzsJ = zzsJ();
        if (zzsJ == null) {
            zzbf.zzZ("getString called for closed container.");
            return zzde.zzue();
        }
        try {
            return zzde.zzg((com.google.android.gms.internal.zzd.zza) zzsJ.zzdi(str).getObject());
        } catch (Exception e) {
            zzbf.zzZ("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzde.zzue();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzaxz) {
            this.zzaxz.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzaxA) {
            this.zzaxA.put(str, functionCallTagCallback);
        }
    }

    void release() {
        this.zzaxy = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzaxz) {
            this.zzaxz.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzaxA) {
            this.zzaxA.remove(str);
        }
    }

    FunctionCallMacroCallback zzcM(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaxz) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzaxz.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback zzcN(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaxA) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzaxA.get(str);
        }
        return functionCallTagCallback;
    }

    void zzcO(String str) {
        zzsJ().zzcO(str);
    }

    zzag zzcP(String str) {
        if (zzca.zztx().zzty().equals(zza.CONTAINER_DEBUG)) {
        }
        return new zzbn();
    }

    String zzsI() {
        return this.zzaxC;
    }
}
