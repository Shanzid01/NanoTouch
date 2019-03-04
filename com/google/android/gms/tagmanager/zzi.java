package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzb;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzi extends zzdc {
    private static final String ID = com.google.android.gms.internal.zza.ARBITRARY_PIXEL.toString();
    private static final String URL = zzb.URL.toString();
    private static final String zzaxp = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzaxq = zzb.UNREPEATABLE.toString();
    static final String zzaxr = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> zzaxs = new HashSet();
    private final Context mContext;
    private final zza zzaxt;

    public interface zza {
        zzaq zzsE();
    }

    class C14301 implements zza {
        final /* synthetic */ Context zznK;

        C14301(Context context) {
            this.zznK = context;
        }

        public zzaq zzsE() {
            return zzy.zzak(this.zznK);
        }
    }

    public zzi(Context context) {
        this(context, new C14301(context));
    }

    zzi(Context context, zza com_google_android_gms_tagmanager_zzi_zza) {
        super(ID, URL);
        this.zzaxt = com_google_android_gms_tagmanager_zzi_zza;
        this.mContext = context;
    }

    private synchronized boolean zzcI(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzcK(str)) {
                if (zzcJ(str)) {
                    zzaxs.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void zzJ(Map<String, com.google.android.gms.internal.zzd.zza> map) {
        String zzg = map.get(zzaxq) != null ? zzde.zzg((com.google.android.gms.internal.zzd.zza) map.get(zzaxq)) : null;
        if (zzg == null || !zzcI(zzg)) {
            Builder buildUpon = Uri.parse(zzde.zzg((com.google.android.gms.internal.zzd.zza) map.get(URL))).buildUpon();
            com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza = (com.google.android.gms.internal.zzd.zza) map.get(zzaxp);
            if (com_google_android_gms_internal_zzd_zza != null) {
                Object zzl = zzde.zzl(com_google_android_gms_internal_zzd_zza);
                if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            for (Entry entry : ((Map) zzl2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            zzbf.zzZ("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                zzbf.zzZ("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.zzaxt.zzsE().zzcY(uri);
            zzbf.zzab("ArbitraryPixel: url = " + uri);
            if (zzg != null) {
                synchronized (zzi.class) {
                    zzaxs.add(zzg);
                    zzcu.zza(this.mContext, zzaxr, zzg, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }

    boolean zzcJ(String str) {
        return this.mContext.getSharedPreferences(zzaxr, 0).contains(str);
    }

    boolean zzcK(String str) {
        return zzaxs.contains(str);
    }
}
