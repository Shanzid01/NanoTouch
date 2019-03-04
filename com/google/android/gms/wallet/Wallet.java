package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzwh;
import com.google.android.gms.internal.zzwi;
import com.google.android.gms.internal.zzwk;
import com.google.android.gms.internal.zzwl;
import com.google.android.gms.wallet.wobs.zzr;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final Payments Payments = new zzwh();
    private static final zzc<zzwi> zzGR = new zzc();
    private static final com.google.android.gms.common.api.Api.zzb<zzwi, WalletOptions> zzGS = new C14451();
    public static final zzr zzaEm = new zzwl();
    public static final zzvw zzaEn = new zzwk();

    public abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzwi> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzGR, googleApiClient);
        }
    }

    public abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    final class C14451 implements com.google.android.gms.common.api.Api.zzb<zzwi, WalletOptions> {
        C14451() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzwi zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzwi(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, com_google_android_gms_common_internal_zzf.getAccountName(), walletOptions.theme);
        }
    }

    public final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public final class Builder {
            private int mTheme = 0;
            private int zzaEo = 0;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int i) {
                if (i == 0 || i == 2 || i == 1) {
                    this.zzaEo = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(i)}));
            }

            public Builder setTheme(int i) {
                if (i == 0 || i == 1) {
                    this.mTheme = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(i)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzaEo;
            this.theme = builder.mTheme;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        Payments.changeMaskedWallet(googleApiClient, str, str2, i);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        Payments.checkForPreAuthorization(googleApiClient, i);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        Payments.loadFullWallet(googleApiClient, fullWalletRequest, i);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        Payments.loadMaskedWallet(googleApiClient, maskedWalletRequest, i);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Payments.notifyTransactionStatus(googleApiClient, notifyTransactionStatusRequest);
    }
}
