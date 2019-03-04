package com.google.android.gms.internal;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@zzgi
public class zzht {
    public static final zza<Void> zzzB = new C12371();

    public interface zza<T> {
        T zzb(InputStream inputStream);

        T zzdQ();
    }

    final class C12371 implements zza {
        C12371() {
        }

        public /* synthetic */ Object zzb(InputStream inputStream) {
            return zzc(inputStream);
        }

        public Void zzc(InputStream inputStream) {
            return null;
        }

        public /* synthetic */ Object zzdQ() {
            return zzeA();
        }

        public Void zzeA() {
            return null;
        }
    }

    protected HttpURLConnection zzW(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public <T> Future<T> zza(final String str, final zza<T> com_google_android_gms_internal_zzht_zza_T) {
        return zzhn.submit(new Callable<T>(this) {
            final /* synthetic */ zzht zzzE;

            public T call() {
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = this.zzzE.zzW(str);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode > 299) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return com_google_android_gms_internal_zzht_zza_T.zzdQ();
                    }
                    T zzb = com_google_android_gms_internal_zzht_zza_T.zzb(httpURLConnection.getInputStream());
                    if (httpURLConnection == null) {
                        return zzb;
                    }
                    httpURLConnection.disconnect();
                    return zzb;
                } catch (Throwable e) {
                    zzhx.zzd("Error making HTTP request.", e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable e2) {
                    zzhx.zzd("Error making HTTP request.", e2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        });
    }
}
