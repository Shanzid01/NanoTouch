package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzwh implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi com_google_android_gms_internal_zzwi) {
                com_google_android_gms_internal_zzwi.zze(str3, str4, i2);
                setResult(Status.zzNo);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi com_google_android_gms_internal_zzwi) {
                com_google_android_gms_internal_zzwi.zzhG(i);
                setResult(Status.zzNo);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi com_google_android_gms_internal_zzwi) {
                com_google_android_gms_internal_zzwi.zzhH(i);
                setResult(Status.zzNo);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest fullWalletRequest, final int i) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi com_google_android_gms_internal_zzwi) {
                com_google_android_gms_internal_zzwi.zza(fullWalletRequest, i);
                setResult(Status.zzNo);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest maskedWalletRequest, final int i) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi com_google_android_gms_internal_zzwi) {
                com_google_android_gms_internal_zzwi.zza(maskedWalletRequest, i);
                setResult(Status.zzNo);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzwh zzaET;

            protected void zza(zzwi com_google_android_gms_internal_zzwi) {
                com_google_android_gms_internal_zzwi.zza(notifyTransactionStatusRequest);
                setResult(Status.zzNo);
            }
        });
    }
}
