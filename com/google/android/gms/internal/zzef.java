package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzee.zza;

@zzgi
public class zzef extends zzeg {
    private final Context mContext;
    private final zzic zzmu;
    private final WindowManager zznu;
    private final zzbu zztF;
    DisplayMetrics zztG;
    private float zztH;
    int zztI = -1;
    int zztJ = -1;
    private int zztK;
    int zztL = -1;
    int zztM = -1;
    int zztN = -1;
    int zztO = -1;

    public zzef(zzic com_google_android_gms_internal_zzic, Context context, zzbu com_google_android_gms_internal_zzbu) {
        super(com_google_android_gms_internal_zzic);
        this.zzmu = com_google_android_gms_internal_zzic;
        this.mContext = context;
        this.zztF = com_google_android_gms_internal_zzbu;
        this.zznu = (WindowManager) context.getSystemService("window");
    }

    private void zzcS() {
        this.zztG = new DisplayMetrics();
        Display defaultDisplay = this.zznu.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zztG);
        this.zztH = this.zztG.density;
        this.zztK = defaultDisplay.getRotation();
    }

    private void zzcX() {
        int[] iArr = new int[2];
        this.zzmu.getLocationOnScreen(iArr);
        zzf(zzbe.zzbD().zzc(this.mContext, iArr[0]), zzbe.zzbD().zzc(this.mContext, iArr[1]));
    }

    private zzee zzda() {
        return new zza().zzo(this.zztF.zzbP()).zzn(this.zztF.zzbQ()).zzp(this.zztF.zzbU()).zzq(this.zztF.zzbR()).zzr(this.zztF.zzbS()).zzcR();
    }

    void zzcT() {
        this.zztI = zzbe.zzbD().zzb(this.zztG, this.zztG.widthPixels);
        this.zztJ = zzbe.zzbD().zzb(this.zztG, this.zztG.heightPixels);
        Activity zzeD = this.zzmu.zzeD();
        if (zzeD == null || zzeD.getWindow() == null) {
            this.zztL = this.zztI;
            this.zztM = this.zztJ;
            return;
        }
        int[] zzg = zzab.zzaM().zzg(zzeD);
        this.zztL = zzbe.zzbD().zzb(this.zztG, zzg[0]);
        this.zztM = zzbe.zzbD().zzb(this.zztG, zzg[1]);
    }

    void zzcU() {
        if (this.zzmu.zzad().zzpb) {
            this.zztN = this.zztI;
            this.zztO = this.zztJ;
            return;
        }
        this.zzmu.measure(0, 0);
        this.zztN = zzbe.zzbD().zzc(this.mContext, this.zzmu.getMeasuredWidth());
        this.zztO = zzbe.zzbD().zzc(this.mContext, this.zzmu.getMeasuredHeight());
    }

    public void zzcV() {
        zzcS();
        zzcT();
        zzcU();
        zzcY();
        zzcZ();
        zzcX();
        zzcW();
    }

    void zzcW() {
        if (zzhx.zzA(2)) {
            zzhx.zzaa("Dispatching Ready Event.");
        }
        zzI(this.zzmu.zzeJ().zzzH);
    }

    void zzcY() {
        zza(this.zztI, this.zztJ, this.zztL, this.zztM, this.zztH, this.zztK);
    }

    void zzcZ() {
        this.zzmu.zzb("onDeviceFeaturesReceived", zzda().toJson());
    }

    public void zzf(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? zzab.zzaM().zzj((Activity) this.mContext)[0] : 0), this.zztN, this.zztO);
        this.zzmu.zzeG().zze(i, i2);
    }
}
