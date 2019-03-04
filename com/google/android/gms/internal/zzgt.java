package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.facebook.Response;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@zzgi
public class zzgt implements Callable<zzhe> {
    private final Context mContext;
    private final Object zznh = new Object();
    private final zzt zzrv;
    private final com.google.android.gms.internal.zzhe.zza zzvN;
    private int zzvR;
    private final zzht zzwV;
    private final zzai zzwW;
    private boolean zzwX;
    private List<String> zzwY;

    public interface zza<T extends com.google.android.gms.internal.zzcn.zza> {
        T zza(zzgt com_google_android_gms_internal_zzgt, JSONObject jSONObject);
    }

    class zzb {
        final /* synthetic */ zzgt zzxc;
        public zzcv zzxe;

        zzb(zzgt com_google_android_gms_internal_zzgt) {
            this.zzxc = com_google_android_gms_internal_zzgt;
        }
    }

    public zzgt(Context context, zzt com_google_android_gms_internal_zzt, zzai com_google_android_gms_internal_zzai, zzht com_google_android_gms_internal_zzht, com.google.android.gms.internal.zzhe.zza com_google_android_gms_internal_zzhe_zza) {
        this.mContext = context;
        this.zzrv = com_google_android_gms_internal_zzt;
        this.zzwV = com_google_android_gms_internal_zzht;
        this.zzwW = com_google_android_gms_internal_zzai;
        this.zzvN = com_google_android_gms_internal_zzhe_zza;
        this.zzwX = false;
        this.zzvR = -2;
        this.zzwY = null;
    }

    private com.google.android.gms.internal.zzcn.zza zza(zzah com_google_android_gms_internal_zzah, zza com_google_android_gms_internal_zzgt_zza, JSONObject jSONObject) {
        if (zzdO()) {
            return null;
        }
        String[] zzb = zzb(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.zzwY = zzb == null ? null : Arrays.asList(zzb);
        com.google.android.gms.internal.zzcn.zza zza = com_google_android_gms_internal_zzgt_zza.zza(this, jSONObject);
        if (zza == null) {
            zzhx.zzZ("Failed to retrieve ad assets.");
            return null;
        }
        zza.zza(new zzcn(this.zzrv, com_google_android_gms_internal_zzah, jSONObject));
        return zza;
    }

    private zzhe zza(com.google.android.gms.internal.zzcn.zza com_google_android_gms_internal_zzcn_zza) {
        int i;
        synchronized (this.zznh) {
            i = this.zzvR;
            if (com_google_android_gms_internal_zzcn_zza == null && this.zzvR == -2) {
                i = 0;
            }
        }
        return new zzhe(this.zzvN.zzyy.zzwn, null, this.zzvN.zzyz.zzst, i, this.zzvN.zzyz.zzsu, this.zzwY, this.zzvN.zzyz.orientation, this.zzvN.zzyz.zzsx, this.zzvN.zzyy.zzwq, false, null, null, null, null, null, 0, this.zzvN.zzlV, this.zzvN.zzyz.zzwH, this.zzvN.zzyv, this.zzvN.zzyw, this.zzvN.zzyz.zzwN, this.zzvN.zzys, i != -2 ? null : com_google_android_gms_internal_zzcn_zza, this.zzvN.zzyy.zzwD);
    }

    private String[] zzb(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private JSONObject zzc(final zzah com_google_android_gms_internal_zzah) {
        if (zzdO()) {
            return null;
        }
        final zzhq com_google_android_gms_internal_zzhq = new zzhq();
        final zzb com_google_android_gms_internal_zzgt_zzb = new zzb(this);
        zzcv c12141 = new zzcv(this) {
            final /* synthetic */ zzgt zzxc;

            public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
                com_google_android_gms_internal_zzah.zzb("/nativeAdPreProcess", com_google_android_gms_internal_zzgt_zzb.zzxe);
                try {
                    String str = (String) map.get(Response.SUCCESS_KEY);
                    if (!TextUtils.isEmpty(str)) {
                        com_google_android_gms_internal_zzhq.zzb(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (Throwable e) {
                    zzhx.zzb("Malformed native JSON response.", e);
                }
                this.zzxc.zzx(0);
                zzx.zza(this.zzxc.zzdO(), (Object) "Unable to set the ad state error!");
                com_google_android_gms_internal_zzhq.zzb(null);
            }
        };
        com_google_android_gms_internal_zzgt_zzb.zzxe = c12141;
        com_google_android_gms_internal_zzah.zza("/nativeAdPreProcess", c12141);
        com_google_android_gms_internal_zzah.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzvN.zzyz.zzwG));
        return (JSONObject) com_google_android_gms_internal_zzhq.get();
    }

    private zzah zzdN() {
        if (zzdO()) {
            return null;
        }
        zzah com_google_android_gms_internal_zzah = (zzah) this.zzwW.zza(this.mContext, this.zzvN.zzyy.zzlP, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        com_google_android_gms_internal_zzah.zza(this.zzrv, this.zzrv, this.zzrv, this.zzrv, false, this.zzrv, this.zzrv, null, this.zzrv);
        return com_google_android_gms_internal_zzah;
    }

    public /* synthetic */ Object call() {
        return zzdM();
    }

    public Future<Drawable> zza(JSONObject jSONObject, String str, final boolean z) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Object string = z ? jSONObject2.getString("url") : jSONObject2.optString("url");
        if (!TextUtils.isEmpty(string)) {
            return this.zzwV.zza(string, new com.google.android.gms.internal.zzht.zza<Drawable>(this) {
                final /* synthetic */ zzgt zzxc;

                public Drawable zza(InputStream inputStream) {
                    byte[] zzd;
                    try {
                        zzd = zzlz.zzd(inputStream);
                    } catch (IOException e) {
                        zzd = null;
                    }
                    if (zzd == null) {
                        this.zzxc.zza(2, z);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzd, 0, zzd.length);
                    if (decodeByteArray != null) {
                        return new BitmapDrawable(Resources.getSystem(), decodeByteArray);
                    }
                    this.zzxc.zza(2, z);
                    return null;
                }

                public /* synthetic */ Object zzb(InputStream inputStream) {
                    return zza(inputStream);
                }

                public Drawable zzdP() {
                    this.zzxc.zza(2, z);
                    return null;
                }

                public /* synthetic */ Object zzdQ() {
                    return zzdP();
                }
            });
        }
        zza(0, z);
        return new zzhr(null);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzx(i);
        }
    }

    protected zza zzc(JSONObject jSONObject) {
        if (zzdO()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        if ("2".equals(string)) {
            return new zzgu();
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(string)) {
            return new zzgv();
        }
        zzx(0);
        return null;
    }

    public zzhe zzdM() {
        try {
            zzah zzdN = zzdN();
            JSONObject zzc = zzc(zzdN);
            return zza(zza(zzdN, zzc(zzc), zzc));
        } catch (CancellationException e) {
            if (!this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (ExecutionException e2) {
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (InterruptedException e3) {
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (Throwable e4) {
            zzhx.zzd("Malformed native JSON response.", e4);
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (Throwable e42) {
            zzhx.zzd("Timeout when loading native ad.", e42);
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        }
    }

    public boolean zzdO() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzwX;
        }
        return z;
    }

    public void zzx(int i) {
        synchronized (this.zznh) {
            this.zzwX = true;
            this.zzvR = i;
        }
    }
}
