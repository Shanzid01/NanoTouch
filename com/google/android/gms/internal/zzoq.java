package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zzoq extends zzk<zzos> {
    private final int mTheme;
    private final String zzHg;
    private zza zzalt;
    private Activity zzoi;

    public final class zza extends com.google.android.gms.internal.zzor.zza {
        private final int zzPu;
        private Activity zzoi;

        public zza(int i, Activity activity) {
            this.zzPu = i;
            this.zzoi = activity;
        }

        private void setActivity(Activity activity) {
            this.zzoi = activity;
        }

        public void zzi(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.zzoi.createPendingResult(this.zzPu, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.zzoi, this.zzPu);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.zzoi.createPendingResult(this.zzPu, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public zzoq(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super((Context) activity, looper, 12, connectionCallbacks, onConnectionFailedListener);
        this.zzHg = str;
        this.zzoi = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzalt != null) {
            this.zzalt.setActivity(null);
            this.zzalt = null;
        }
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzpn();
        this.zzalt = new zza(i, this.zzoi);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzHg)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzHg, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzpm().zza(this.zzalt, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzalt.zzi(1, bundle);
        }
    }

    protected zzos zzbd(IBinder iBinder) {
        return com.google.android.gms.internal.zzos.zza.zzbf(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String zzcG() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzbd(iBinder);
    }

    protected zzos zzpm() {
        return (zzos) super.zzjb();
    }

    protected void zzpn() {
        super.zzfc();
    }
}
