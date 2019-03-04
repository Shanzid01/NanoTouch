package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbo;
import com.google.android.gms.internal.zzbo.zza;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = zzbo.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzbo zzlg;

    public final class Builder {
        private final zza zzlh = new zza();

        public Builder addCategoryExclusion(String str) {
            this.zzlh.zzx(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzlh.zzb(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.zzlh.zzc(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzlh.zzc(str, zzv.zzbm(",").zza(list));
            }
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
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzlh.zzs(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
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

        public Builder setManualImpressionsEnabled(boolean z) {
            this.zzlh.zzj(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.zzlh.zzv(str);
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

    private PublisherAdRequest(Builder builder) {
        this.zzlg = new zzbo(builder.zzlh);
    }

    public static void updateCorrelator() {
        zzbo.updateCorrelator();
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

    public Bundle getCustomTargeting() {
        return this.zzlg.getCustomTargeting();
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

    public boolean getManualImpressionsEnabled() {
        return this.zzlg.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzlg.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzlg.getNetworkExtrasBundle(cls);
    }

    public String getPublisherProvidedId() {
        return this.zzlg.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.zzlg.isTestDevice(context);
    }

    public zzbo zzY() {
        return this.zzlg;
    }
}
