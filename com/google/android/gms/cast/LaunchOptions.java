package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new zzc();
    private final int zzFG;
    private boolean zzIN;
    private String zzIO;

    public final class Builder {
        private LaunchOptions zzIP = new LaunchOptions();

        public LaunchOptions build() {
            return this.zzIP;
        }

        public Builder setLocale(Locale locale) {
            this.zzIP.setLanguage(zzjv.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean z) {
            this.zzIP.setRelaunchIfRunning(z);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, zzjv.zzb(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean z, String str) {
        this.zzFG = i;
        this.zzIN = z;
        this.zzIO = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzIN == launchOptions.zzIN && zzjv.zza(this.zzIO, launchOptions.zzIO);
    }

    public String getLanguage() {
        return this.zzIO;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzIN;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzIN), this.zzIO);
    }

    public void setLanguage(String str) {
        this.zzIO = str;
    }

    public void setRelaunchIfRunning(boolean z) {
        this.zzIN = z;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.zzIN), this.zzIO});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
