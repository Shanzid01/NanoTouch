package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0783R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Creator<WalletFragmentStyle> CREATOR = new zzc();
    final int zzFG;
    Bundle zzaER;
    int zzaES;

    public WalletFragmentStyle() {
        this.zzFG = 1;
        this.zzaER = new Bundle();
    }

    WalletFragmentStyle(int i, Bundle bundle, int i2) {
        this.zzFG = i;
        this.zzaER = bundle;
        this.zzaES = i2;
    }

    private void zza(TypedArray typedArray, int i, String str) {
        if (!this.zzaER.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.zzaER.putLong(str, Dimension.zza(peekValue));
            }
        }
    }

    private void zza(TypedArray typedArray, int i, String str, String str2) {
        if (!this.zzaER.containsKey(str) && !this.zzaER.containsKey(str2)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.zzaER.putInt(str2, peekValue.resourceId);
            } else {
                this.zzaER.putInt(str, peekValue.data);
            }
        }
    }

    private void zzb(TypedArray typedArray, int i, String str) {
        if (!this.zzaER.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.zzaER.putInt(str, peekValue.data);
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int i) {
        this.zzaER.putInt("buyButtonAppearance", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i) {
        this.zzaER.putLong("buyButtonHeight", Dimension.zzhC(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i, float f) {
        this.zzaER.putLong("buyButtonHeight", Dimension.zza(i, f));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int i) {
        this.zzaER.putInt("buyButtonText", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i) {
        this.zzaER.putLong("buyButtonWidth", Dimension.zzhC(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i, float f) {
        this.zzaER.putLong("buyButtonWidth", Dimension.zza(i, f));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int i) {
        this.zzaER.remove("maskedWalletDetailsBackgroundResource");
        this.zzaER.putInt("maskedWalletDetailsBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int i) {
        this.zzaER.remove("maskedWalletDetailsBackgroundColor");
        this.zzaER.putInt("maskedWalletDetailsBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int i) {
        this.zzaER.remove("maskedWalletDetailsButtonBackgroundResource");
        this.zzaER.putInt("maskedWalletDetailsButtonBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int i) {
        this.zzaER.remove("maskedWalletDetailsButtonBackgroundColor");
        this.zzaER.putInt("maskedWalletDetailsButtonBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int i) {
        this.zzaER.putInt("maskedWalletDetailsButtonTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int i) {
        this.zzaER.putInt("maskedWalletDetailsHeaderTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int i) {
        this.zzaER.putInt("maskedWalletDetailsLogoImageType", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int i) {
        this.zzaER.putInt("maskedWalletDetailsLogoTextColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int i) {
        this.zzaER.putInt("maskedWalletDetailsTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int i) {
        this.zzaES = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public int zza(String str, DisplayMetrics displayMetrics, int i) {
        return this.zzaER.containsKey(str) ? Dimension.zza(this.zzaER.getLong(str), displayMetrics) : i;
    }

    public void zzao(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.zzaES <= 0 ? C0783R.style.WalletFragmentDefaultStyle : this.zzaES, C0783R.styleable.WalletFragmentStyle);
        zza(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(obtainStyledAttributes, C0783R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }
}
