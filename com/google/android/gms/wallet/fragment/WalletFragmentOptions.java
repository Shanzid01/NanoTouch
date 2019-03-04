package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C0783R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int zzFG;
    private int zzRW;
    private WalletFragmentStyle zzaEP;
    private int zzaEo;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions zzaEQ;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.zzaEQ = walletFragmentOptions;
        }

        public WalletFragmentOptions build() {
            return this.zzaEQ;
        }

        public Builder setEnvironment(int i) {
            this.zzaEQ.zzaEo = i;
            return this;
        }

        public Builder setFragmentStyle(int i) {
            this.zzaEQ.zzaEP = new WalletFragmentStyle().setStyleResourceId(i);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle walletFragmentStyle) {
            this.zzaEQ.zzaEP = walletFragmentStyle;
            return this;
        }

        public Builder setMode(int i) {
            this.zzaEQ.zzRW = i;
            return this;
        }

        public Builder setTheme(int i) {
            this.zzaEQ.mTheme = i;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.zzFG = 1;
    }

    WalletFragmentOptions(int i, int i2, int i3, WalletFragmentStyle walletFragmentStyle, int i4) {
        this.zzFG = i;
        this.zzaEo = i2;
        this.mTheme = i3;
        this.zzaEP = walletFragmentStyle;
        this.zzRW = i4;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0783R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0783R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0783R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0783R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0783R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzaEo = i2;
        walletFragmentOptions.zzaEP = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzaEP.zzao(context);
        walletFragmentOptions.zzRW = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzaEo;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzaEP;
    }

    public int getMode() {
        return this.zzRW;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public void zzao(Context context) {
        if (this.zzaEP != null) {
            this.zzaEP.zzao(context);
        }
    }
}
