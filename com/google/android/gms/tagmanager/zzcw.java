package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class zzcw implements zzab {
    private final String zzaAM = zza("GoogleTagManager", "4.00", VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient zzaAN;
    private zza zzaAO;
    private final Context zzaAv;

    public interface zza {
        void zza(zzap com_google_android_gms_tagmanager_zzap);

        void zzb(zzap com_google_android_gms_tagmanager_zzap);

        void zzc(zzap com_google_android_gms_tagmanager_zzap);
    }

    zzcw(HttpClient httpClient, Context context, zza com_google_android_gms_tagmanager_zzcw_zza) {
        this.zzaAv = context.getApplicationContext();
        this.zzaAN = httpClient;
        this.zzaAO = com_google_android_gms_tagmanager_zzcw_zza;
    }

    private HttpEntityEnclosingRequest zza(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.zzaAM);
            } catch (URISyntaxException e2) {
                e = e2;
                zzbf.zzac("Exception sending hit: " + e.getClass().getSimpleName());
                zzbf.zzac(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            zzbf.zzac("Exception sending hit: " + e.getClass().getSimpleName());
            zzbf.zzac(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void zza(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                zzbf.zzab("Error Writing hit to log...");
            }
        }
        zzbf.zzab(stringBuffer.toString());
    }

    static String zzc(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL zzd(zzap com_google_android_gms_tagmanager_zzap) {
        try {
            return new URL(com_google_android_gms_tagmanager_zzap.zztk());
        } catch (MalformedURLException e) {
            zzbf.zzZ("Error trying to parse the GTM url.");
            return null;
        }
    }

    public boolean zzfk() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzaAv.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbf.zzab("...no network connectivity");
        return false;
    }

    public void zzt(List<zzap> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            zzap com_google_android_gms_tagmanager_zzap = (zzap) list.get(i);
            URL zzd = zzd(com_google_android_gms_tagmanager_zzap);
            if (zzd == null) {
                zzbf.zzac("No destination: discarding hit.");
                this.zzaAO.zzb(com_google_android_gms_tagmanager_zzap);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest zza = zza(zzd);
                if (zza == null) {
                    this.zzaAO.zzb(com_google_android_gms_tagmanager_zzap);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(zzd.getHost(), zzd.getPort(), zzd.getProtocol());
                    zza.addHeader("Host", httpHost.toHostString());
                    zza(zza);
                    if (obj != null) {
                        try {
                            zzbk.zzan(this.zzaAv);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            zzbf.zzac("ClientProtocolException sending hit; discarding hit...");
                            this.zzaAO.zzb(com_google_android_gms_tagmanager_zzap);
                            obj2 = obj;
                        } catch (IOException e2) {
                            zzbf.zzac("Exception sending hit: " + e2.getClass().getSimpleName());
                            zzbf.zzac(e2.getMessage());
                            this.zzaAO.zzc(com_google_android_gms_tagmanager_zzap);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.zzaAN.execute(httpHost, zza);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        zzbf.zzac("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.zzaAO.zzc(com_google_android_gms_tagmanager_zzap);
                    } else {
                        this.zzaAO.zza(com_google_android_gms_tagmanager_zzap);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }
}
