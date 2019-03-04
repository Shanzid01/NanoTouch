package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzgi
public final class zzhu extends zzhl {
    private final Context mContext;
    private final String zznf;
    private final String zzxX;
    private String zzyW = null;

    public zzhu(Context context, String str, String str2) {
        this.mContext = context;
        this.zznf = str;
        this.zzxX = str2;
    }

    public zzhu(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.zznf = str;
        this.zzxX = str2;
        this.zzyW = str3;
    }

    public void onStop() {
    }

    public void zzdw() {
        HttpURLConnection httpURLConnection;
        try {
            zzhx.zzab("Pinging URL: " + this.zzxX);
            httpURLConnection = (HttpURLConnection) new URL(this.zzxX).openConnection();
            if (TextUtils.isEmpty(this.zzyW)) {
                zzab.zzaM().zza(this.mContext, this.zznf, true, httpURLConnection);
            } else {
                zzab.zzaM().zza(this.mContext, this.zznf, true, httpURLConnection, this.zzyW);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                zzhx.zzac("Received non-success response code " + responseCode + " from pinging URL: " + this.zzxX);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            zzhx.zzac("Error while parsing ping URL: " + this.zzxX + ". " + e.getMessage());
        } catch (IOException e2) {
            zzhx.zzac("Error while pinging URL: " + this.zzxX + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
