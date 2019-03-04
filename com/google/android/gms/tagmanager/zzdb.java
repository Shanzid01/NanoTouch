package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class zzdb {
    private Context mContext;
    private Tracker zzBL;
    private GoogleAnalytics zzBN;

    class zza implements Logger {
        zza() {
        }

        private static int zzhj(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbf.zzb("", exception);
        }

        public void error(String str) {
            zzbf.zzZ(str);
        }

        public int getLogLevel() {
            return zzhj(zzbf.getLogLevel());
        }

        public void info(String str) {
            zzbf.zzaa(str);
        }

        public void setLogLevel(int i) {
            zzbf.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            zzbf.zzab(str);
        }

        public void warn(String str) {
            zzbf.zzac(str);
        }
    }

    zzdb(Context context) {
        this.mContext = context;
    }

    private synchronized void zzdm(String str) {
        if (this.zzBN == null) {
            this.zzBN = GoogleAnalytics.getInstance(this.mContext);
            this.zzBN.setLogger(new zza());
            this.zzBL = this.zzBN.newTracker(str);
        }
    }

    public Tracker zzdl(String str) {
        zzdm(str);
        return this.zzBL;
    }
}
