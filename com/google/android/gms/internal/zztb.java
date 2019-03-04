package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import java.util.HashSet;
import java.util.Set;

public class zztb {
    private static zztb zzatE;
    private Context mContext;
    private boolean mStarted;
    private final Set<zza> zzatF = new HashSet();
    private TagManager zzatG = null;
    private zzta zzmB;

    class C13401 implements ResultCallback<ContainerHolder> {
        final /* synthetic */ zztb zzatH;

        C13401(zztb com_google_android_gms_internal_zztb) {
            this.zzatH = com_google_android_gms_internal_zztb;
        }

        public /* synthetic */ void onResult(Result result) {
            zza((ContainerHolder) result);
        }

        public void zza(ContainerHolder containerHolder) {
            this.zzatH.zzmB = new zzsz(this.zzatH.mContext, containerHolder.getStatus().isSuccess() ? containerHolder.getContainer() : null, this.zzatH.zzrB()).zzrv();
            this.zzatH.zzrC();
        }
    }

    public interface zza {
        void zzaE();
    }

    zztb(Context context, TagManager tagManager) {
        this.mContext = context;
        this.zzatG = tagManager;
    }

    public static zztb zzah(Context context) {
        zzx.zzl(context);
        if (zzatE == null) {
            synchronized (zztb.class) {
                if (zzatE == null) {
                    zzatE = new zztb(context, TagManager.getInstance(context.getApplicationContext()));
                }
            }
        }
        return zzatE;
    }

    private void zzrC() {
        synchronized (this) {
            for (zza zzaE : this.zzatF) {
                zzaE.zzaE();
            }
        }
    }

    public void start() {
        synchronized (this) {
            if (this.mStarted) {
                throw new IllegalStateException("Method start() has already been called");
            } else if (this.zzmB == null) {
                throw new IllegalStateException("No settings configured");
            } else {
                this.mStarted = true;
                this.zzatG.zzc(this.zzmB.zzrx(), -1, "admob").setResultCallback(new C13401(this));
            }
        }
    }

    public void zza(zzta com_google_android_gms_internal_zzta) {
        synchronized (this) {
            if (this.mStarted) {
                throw new IllegalStateException("Settings can't be changed after TagManager has been started");
            }
            this.zzmB = com_google_android_gms_internal_zzta;
        }
    }

    public void zza(zza com_google_android_gms_internal_zztb_zza) {
        synchronized (this) {
            this.zzatF.add(com_google_android_gms_internal_zztb_zza);
        }
    }

    public zzta zzrB() {
        zzta com_google_android_gms_internal_zzta;
        synchronized (this) {
            com_google_android_gms_internal_zzta = this.zzmB;
        }
        return com_google_android_gms_internal_zzta;
    }
}
