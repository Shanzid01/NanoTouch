package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzbo;
import com.google.android.gms.internal.zzbo.zza;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = zzbo.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzAA;
    private final int zzAB;
    private final int zzAC;
    private final int zzAD;
    private final int zzAE;
    private final int zzAF;
    private final String zzAG;
    private final int zzAH;
    private final String zzAI;
    private final int zzAJ;
    private final int zzAK;
    private final String zzAL;
    private final int zzAy;
    private final int zzAz;
    private final zzbo zzlg;

    public final class Builder {
        private int zzAA;
        private int zzAB;
        private int zzAC;
        private int zzAD;
        private int zzAE = 0;
        private int zzAF;
        private String zzAG;
        private int zzAH;
        private String zzAI;
        private int zzAJ;
        private int zzAK;
        private String zzAL;
        private int zzAy;
        private int zzAz;
        private final zza zzlh = new zza();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzlh.zzb(cls, bundle);
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

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int i) {
            this.zzAy = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.zzAz = i;
            this.zzAA = Color.argb(0, 0, 0, 0);
            this.zzAB = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.zzAz = Color.argb(0, 0, 0, 0);
            this.zzAA = i2;
            this.zzAB = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.zzAC = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.zzAD = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.zzAE = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.zzAF = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.zzAG = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.zzAH = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.zzAI = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.zzAJ = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.zzAK = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzlh.zza(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.zzAL = str;
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

    private SearchAdRequest(Builder builder) {
        this.zzAy = builder.zzAy;
        this.zzAz = builder.zzAz;
        this.zzAA = builder.zzAA;
        this.zzAB = builder.zzAB;
        this.zzAC = builder.zzAC;
        this.zzAD = builder.zzAD;
        this.zzAE = builder.zzAE;
        this.zzAF = builder.zzAF;
        this.zzAG = builder.zzAG;
        this.zzAH = builder.zzAH;
        this.zzAI = builder.zzAI;
        this.zzAJ = builder.zzAJ;
        this.zzAK = builder.zzAK;
        this.zzAL = builder.zzAL;
        this.zzlg = new zzbo(builder.zzlh, this);
    }

    public int getAnchorTextColor() {
        return this.zzAy;
    }

    public int getBackgroundColor() {
        return this.zzAz;
    }

    public int getBackgroundGradientBottom() {
        return this.zzAA;
    }

    public int getBackgroundGradientTop() {
        return this.zzAB;
    }

    public int getBorderColor() {
        return this.zzAC;
    }

    public int getBorderThickness() {
        return this.zzAD;
    }

    public int getBorderType() {
        return this.zzAE;
    }

    public int getCallButtonColor() {
        return this.zzAF;
    }

    public String getCustomChannels() {
        return this.zzAG;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzlg.getCustomEventExtrasBundle(cls);
    }

    public int getDescriptionTextColor() {
        return this.zzAH;
    }

    public String getFontFace() {
        return this.zzAI;
    }

    public int getHeaderTextColor() {
        return this.zzAJ;
    }

    public int getHeaderTextSize() {
        return this.zzAK;
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

    public String getQuery() {
        return this.zzAL;
    }

    public boolean isTestDevice(Context context) {
        return this.zzlg.isTestDevice(context);
    }

    zzbo zzY() {
        return this.zzlg;
    }
}
