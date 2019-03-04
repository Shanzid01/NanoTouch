package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgs.zza;
import com.google.android.gms.internal.zzia.zzb;
import com.google.android.gms.internal.zzia.zzc;
import com.google.android.gms.internal.zzia.zzd;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public final class zzgw extends zza {
    private static final Object zzmz = new Object();
    private static zzgw zzxf;
    private final Context mContext;
    private final zzdf zznr;
    private final zzhc zzxg;
    private final zzdg zzxh;
    private final zzbv zzxi;

    final class C12181 implements Runnable {
        final /* synthetic */ zzdf zzxj;
        final /* synthetic */ zzgy zzxk;
        final /* synthetic */ zzcf zzxl;
        final /* synthetic */ zzce zzxm;
        final /* synthetic */ String zzxn;

        class C12172 implements zzia.zza {
            final /* synthetic */ C12181 zzxp;

            C12172(C12181 c12181) {
                this.zzxp = c12181;
            }

            public void run() {
            }
        }

        C12181(zzdf com_google_android_gms_internal_zzdf, zzgy com_google_android_gms_internal_zzgy, zzcf com_google_android_gms_internal_zzcf, zzce com_google_android_gms_internal_zzce, String str) {
            this.zzxj = com_google_android_gms_internal_zzdf;
            this.zzxk = com_google_android_gms_internal_zzgy;
            this.zzxl = com_google_android_gms_internal_zzcf;
            this.zzxm = com_google_android_gms_internal_zzce;
            this.zzxn = str;
        }

        public void run() {
            zzia zzcJ = this.zzxj.zzcJ();
            this.zzxk.zze(zzcJ);
            this.zzxl.zza(this.zzxm, "rwc");
            final zzce zzcq = this.zzxl.zzcq();
            zzcJ.zza(new zzd<zzah>(this) {
                final /* synthetic */ C12181 zzxp;

                public /* synthetic */ void zza(Object obj) {
                    zzb((zzah) obj);
                }

                public void zzb(zzah com_google_android_gms_internal_zzah) {
                    this.zzxp.zzxl.zza(zzcq, "jsf");
                    com_google_android_gms_internal_zzah.zza("/invalidRequest", this.zzxp.zzxk.zzxz);
                    com_google_android_gms_internal_zzah.zza("/loadAdURL", this.zzxp.zzxk.zzxA);
                    try {
                        com_google_android_gms_internal_zzah.zzb("AFMA_buildAdURL", this.zzxp.zzxn);
                    } catch (Throwable e) {
                        zzhx.zzb("Error requesting an ad url", e);
                    }
                }
            }, new C12172(this));
        }
    }

    final class C12192 implements Runnable {
        final /* synthetic */ Context zznK;
        final /* synthetic */ zzgy zzxk;
        final /* synthetic */ zzcf zzxl;
        final /* synthetic */ zzce zzxm;
        final /* synthetic */ String zzxn;
        final /* synthetic */ zzgo zzxq;
        final /* synthetic */ zzbv zzxr;

        C12192(Context context, zzgo com_google_android_gms_internal_zzgo, zzgy com_google_android_gms_internal_zzgy, zzcf com_google_android_gms_internal_zzcf, zzce com_google_android_gms_internal_zzce, String str, zzbv com_google_android_gms_internal_zzbv) {
            this.zznK = context;
            this.zzxq = com_google_android_gms_internal_zzgo;
            this.zzxk = com_google_android_gms_internal_zzgy;
            this.zzxl = com_google_android_gms_internal_zzcf;
            this.zzxm = com_google_android_gms_internal_zzce;
            this.zzxn = str;
            this.zzxr = com_google_android_gms_internal_zzbv;
        }

        public void run() {
            zzic zza = zzab.zzaN().zza(this.zznK, new zzba(), false, false, null, this.zzxq.zzlP);
            if (zzab.zzaP().zzem()) {
                zza.getWebView().clearCache(true);
            }
            zza.setWillNotDraw(true);
            this.zzxk.zza(zza);
            this.zzxl.zza(this.zzxm, "rwc");
            zzid.zza zzb = zzgw.zza(this.zzxn, this.zzxl, this.zzxl.zzcq());
            zzid zzeG = zza.zzeG();
            zzeG.zza("/invalidRequest", this.zzxk.zzxz);
            zzeG.zza("/loadAdURL", this.zzxk.zzxA);
            zzeG.zza("/log", zzcu.zzrG);
            zzeG.zza(zzb);
            zzhx.zzY("Loading the JS library.");
            zza.loadUrl(this.zzxr.zzbV());
        }
    }

    final class C12213 implements Runnable {
        final /* synthetic */ zzdf zzxj;
        final /* synthetic */ zzgy zzxk;

        class C12201 implements zzd<zzah> {
            final /* synthetic */ C12213 zzxs;

            C12201(C12213 c12213) {
                this.zzxs = c12213;
            }

            public /* synthetic */ void zza(Object obj) {
                zzb((zzah) obj);
            }

            public void zzb(zzah com_google_android_gms_internal_zzah) {
                com_google_android_gms_internal_zzah.zzb("/invalidRequest", this.zzxs.zzxk.zzxz);
                com_google_android_gms_internal_zzah.zzb("/loadAdURL", this.zzxs.zzxk.zzxA);
            }
        }

        C12213(zzgy com_google_android_gms_internal_zzgy, zzdf com_google_android_gms_internal_zzdf) {
            this.zzxk = com_google_android_gms_internal_zzgy;
            this.zzxj = com_google_android_gms_internal_zzdf;
        }

        public void run() {
            this.zzxk.zzdT();
            if (this.zzxk.zzdR() != null) {
                this.zzxk.zzdR().zza(new C12201(this), new zzb());
                this.zzxj.zzb(this.zzxk.zzdR());
            }
        }
    }

    final class C12224 implements zzid.zza {
        final /* synthetic */ zzcf zzxl;
        final /* synthetic */ String zzxn;
        final /* synthetic */ zzce zzxo;

        C12224(zzcf com_google_android_gms_internal_zzcf, zzce com_google_android_gms_internal_zzce, String str) {
            this.zzxl = com_google_android_gms_internal_zzcf;
            this.zzxo = com_google_android_gms_internal_zzce;
            this.zzxn = str;
        }

        public void zza(zzic com_google_android_gms_internal_zzic, boolean z) {
            this.zzxl.zza(this.zzxo, "jsf");
            this.zzxl.zzcr();
            com_google_android_gms_internal_zzic.zzb("AFMA_buildAdURL", this.zzxn);
        }
    }

    class C12235 implements zzd<zzah> {
        final /* synthetic */ zzgw zzxt;

        C12235(zzgw com_google_android_gms_internal_zzgw) {
            this.zzxt = com_google_android_gms_internal_zzgw;
        }

        public /* synthetic */ void zza(Object obj) {
            zzb((zzah) obj);
        }

        public void zzb(zzah com_google_android_gms_internal_zzah) {
            com_google_android_gms_internal_zzah.zza("/log", zzcu.zzrG);
        }
    }

    zzgw(Context context, zzbv com_google_android_gms_internal_zzbv, zzdg com_google_android_gms_internal_zzdg, zzhc com_google_android_gms_internal_zzhc) {
        this.mContext = context;
        this.zzxg = com_google_android_gms_internal_zzhc;
        this.zzxh = com_google_android_gms_internal_zzdg;
        this.zzxi = com_google_android_gms_internal_zzbv;
        this.zznr = new zzdf(context.getApplicationContext() != null ? context.getApplicationContext() : context, new zzhy(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true), com_google_android_gms_internal_zzbv.zzbV(), new C12235(this), new zzc());
    }

    private static zzgq zza(Context context, zzdf com_google_android_gms_internal_zzdf, zzbv com_google_android_gms_internal_zzbv, zzdg com_google_android_gms_internal_zzdg, zzhc com_google_android_gms_internal_zzhc, zzgo com_google_android_gms_internal_zzgo) {
        zzhx.zzY("Starting ad request from service.");
        zzab.zzaP().zzb(context, com_google_android_gms_internal_zzgo.zzlP);
        zzca.zzl(context);
        zzcf com_google_android_gms_internal_zzcf = new zzcf("load_ad");
        zzce zzcq = com_google_android_gms_internal_zzcf.zzcq();
        com_google_android_gms_internal_zzdg.init();
        zzhb com_google_android_gms_internal_zzhb = new zzhb(context);
        if (com_google_android_gms_internal_zzhb.zzyj == -1) {
            zzhx.zzY("Device is offline.");
            return new zzgq(2);
        }
        String uuid = com_google_android_gms_internal_zzgo.versionCode >= 7 ? com_google_android_gms_internal_zzgo.zzwF : UUID.randomUUID().toString();
        zzgy com_google_android_gms_internal_zzgy = new zzgy(uuid, com_google_android_gms_internal_zzgo.applicationInfo.packageName);
        if (com_google_android_gms_internal_zzgo.zzwn.extras != null) {
            String string = com_google_android_gms_internal_zzgo.zzwn.extras.getString("_ad");
            if (string != null) {
                return zzgx.zza(context, com_google_android_gms_internal_zzgo, string);
            }
        }
        JSONObject zza = zzgx.zza(com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzhb, com_google_android_gms_internal_zzdg.zzb(250), com_google_android_gms_internal_zzbv);
        if (com_google_android_gms_internal_zzgo.versionCode < 7) {
            try {
                zza.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza == null) {
            return new zzgq(0);
        }
        String jSONObject = zza.toString();
        com_google_android_gms_internal_zzcf.zza(zzcq, "arc");
        zzce zzcq2 = com_google_android_gms_internal_zzcf.zzcq();
        if (((Boolean) zzca.zzqm.get()).booleanValue()) {
            zzhw.zzzG.post(new C12181(com_google_android_gms_internal_zzdf, com_google_android_gms_internal_zzgy, com_google_android_gms_internal_zzcf, zzcq2, jSONObject));
        } else {
            zzhw.zzzG.post(new C12192(context, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzgy, com_google_android_gms_internal_zzcf, zzcq2, jSONObject, com_google_android_gms_internal_zzbv));
        }
        zzgq com_google_android_gms_internal_zzgq;
        try {
            zzha com_google_android_gms_internal_zzha = (zzha) com_google_android_gms_internal_zzgy.zzdS().get(10, TimeUnit.SECONDS);
            if (com_google_android_gms_internal_zzha == null) {
                com_google_android_gms_internal_zzgq = new zzgq(0);
                return com_google_android_gms_internal_zzgq;
            } else if (com_google_android_gms_internal_zzha.getErrorCode() != -2) {
                zzgq com_google_android_gms_internal_zzgq2 = new zzgq(com_google_android_gms_internal_zzha.getErrorCode());
                zzhw.zzzG.post(new C12213(com_google_android_gms_internal_zzgy, com_google_android_gms_internal_zzdf));
                return com_google_android_gms_internal_zzgq2;
            } else {
                if (com_google_android_gms_internal_zzcf.zzcu() != null) {
                    com_google_android_gms_internal_zzcf.zza(com_google_android_gms_internal_zzcf.zzcu(), "rur");
                }
                String str = null;
                if (com_google_android_gms_internal_zzha.zzdW()) {
                    str = com_google_android_gms_internal_zzhc.zzR(com_google_android_gms_internal_zzgo.zzwo.packageName);
                }
                zzcq2 = com_google_android_gms_internal_zzcf.zzcq();
                com_google_android_gms_internal_zzgq = zza(context, com_google_android_gms_internal_zzgo.zzlP.zzzH, com_google_android_gms_internal_zzha.getUrl(), str, com_google_android_gms_internal_zzha);
                com_google_android_gms_internal_zzcf.zza(zzcq2, "ufe");
                com_google_android_gms_internal_zzcf.zza(zzcq, "tts");
                if (zzhk.zzeg() != null) {
                    zzhk.zzeg().zza(com_google_android_gms_internal_zzcf);
                }
                zzhw.zzzG.post(new C12213(com_google_android_gms_internal_zzgy, com_google_android_gms_internal_zzdf));
                return com_google_android_gms_internal_zzgq;
            }
        } catch (Exception e2) {
            com_google_android_gms_internal_zzgq = new zzgq(0);
            return com_google_android_gms_internal_zzgq;
        } finally {
            zzhw.zzzG.post(new C12213(com_google_android_gms_internal_zzgy, com_google_android_gms_internal_zzdf));
        }
    }

    public static zzgq zza(Context context, String str, String str2, String str3, zzha com_google_android_gms_internal_zzha) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            zzgq com_google_android_gms_internal_zzgq;
            zzgz com_google_android_gms_internal_zzgz = new zzgz();
            zzhx.zzY("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                zzab.zzaM().zza(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!(com_google_android_gms_internal_zzha == null || TextUtils.isEmpty(com_google_android_gms_internal_zzha.zzdV()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = com_google_android_gms_internal_zzha.zzdV().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    zza(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        zzhx.zzac("No location header to follow redirect.");
                        com_google_android_gms_internal_zzgq = new zzgq(0);
                        httpURLConnection.disconnect();
                        return com_google_android_gms_internal_zzgq;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        zzhx.zzac("Too many redirects.");
                        com_google_android_gms_internal_zzgq = new zzgq(0);
                        httpURLConnection.disconnect();
                        return com_google_android_gms_internal_zzgq;
                    }
                    com_google_android_gms_internal_zzgz.zzh(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String zza = zzab.zzaM().zza(new InputStreamReader(httpURLConnection.getInputStream()));
                    zza(url3, headerFields, zza, responseCode);
                    com_google_android_gms_internal_zzgz.zza(url3, headerFields, zza);
                    com_google_android_gms_internal_zzgq = com_google_android_gms_internal_zzgz.zzi(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return com_google_android_gms_internal_zzgq;
                }
            }
            zzhx.zzac("Received error HTTP response code: " + responseCode);
            com_google_android_gms_internal_zzgq = new zzgq(0);
            httpURLConnection.disconnect();
            return com_google_android_gms_internal_zzgq;
        } catch (IOException e) {
            zzhx.zzac("Error while connecting to ad server: " + e.getMessage());
            return new zzgq(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static zzgw zza(Context context, zzbv com_google_android_gms_internal_zzbv, zzdg com_google_android_gms_internal_zzdg, zzhc com_google_android_gms_internal_zzhc) {
        zzgw com_google_android_gms_internal_zzgw;
        synchronized (zzmz) {
            if (zzxf == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzxf = new zzgw(context, com_google_android_gms_internal_zzbv, com_google_android_gms_internal_zzdg, com_google_android_gms_internal_zzhc);
            }
            com_google_android_gms_internal_zzgw = zzxf;
        }
        return com_google_android_gms_internal_zzgw;
    }

    private static zzid.zza zza(String str, zzcf com_google_android_gms_internal_zzcf, zzce com_google_android_gms_internal_zzce) {
        return new C12224(com_google_android_gms_internal_zzcf, com_google_android_gms_internal_zzce, str);
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzhx.zzA(2)) {
            zzhx.zzab("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzhx.zzab("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        zzhx.zzab("      " + str32);
                    }
                }
            }
            zzhx.zzab("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzhx.zzab(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzhx.zzab("    null");
            }
            zzhx.zzab("  Response Code:\n    " + i + "\n}");
        }
    }

    public zzgq zzd(zzgo com_google_android_gms_internal_zzgo) {
        zzhk.zzd(this.mContext, com_google_android_gms_internal_zzgo.zzlP.zzzH);
        return zza(this.mContext, this.zznr, this.zzxi, this.zzxh, this.zzxg, com_google_android_gms_internal_zzgo);
    }
}
