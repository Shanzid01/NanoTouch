package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbo;
import com.google.android.gms.internal.zzbo.zza;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = zzbo.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final zzbo zzlg;

    public final class Builder {
        private final zza zzlh = new zza();

        public Builder() {
            this.zzlh.zzs(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzlh.zzb(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.zzlh.zzr(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzlh.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzlh.zza(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.zzlh.zzt(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzlh.zzs(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
        }

        public Builder setBirthday(Date date) {
            this.zzlh.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            zzx.zzb((Object) str, (Object) "Content URL must be non-null.");
            zzx.zzb(str, (Object) "Content URL must be non-empty.");
            zzx.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str.length()));
            this.zzlh.zzu(str);
            return this;
        }

        public Builder setGender(int i) {
            this.zzlh.zzh(i);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzlh.zza(location);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zzlh.zzw(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zzlh.zzk(z);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.zzlg = new zzbo(builder.zzlh);
    }

    public Date getBirthday() {
        return this.zzlg.getBirthday();
    }

    public String getContentUrl() {
        return this.zzlg.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzlg.getCustomEventExtrasBundle(cls);
    }

    public int getGender() {
        return this.zzlg.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzlg.getKeywords();
    }

    public Location getLocation() {
        return this.zzlg.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzlg.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzlg.getNetworkExtrasBundle(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.zzlg.isTestDevice(context);
    }

    zzbo zzY() {
        return this.zzlg;
    }
}
