package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class zzh implements zzg {
    protected MotionEvent zzkv;
    protected DisplayMetrics zzkw;
    protected zzm zzkx;
    private zzn zzky;

    protected zzh(Context context, zzm com_google_android_gms_internal_zzm, zzn com_google_android_gms_internal_zzn) {
        this.zzkx = com_google_android_gms_internal_zzm;
        this.zzky = com_google_android_gms_internal_zzn;
        try {
            this.zzkw = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.zzkw = new DisplayMetrics();
            this.zzkw.density = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
    }

    private String zza(Context context, String str, boolean z) {
        try {
            byte[] zzu;
            synchronized (this) {
                zzt();
                if (z) {
                    zzc(context);
                } else {
                    zzb(context);
                }
                zzu = zzu();
            }
            return zzu.length == 0 ? Integer.toString(5) : zza(zzu, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void zzt() {
        this.zzky.reset();
    }

    private byte[] zzu() {
        return this.zzky.zzD();
    }

    public String zza(Context context) {
        return zza(context, null, false);
    }

    public String zza(Context context, String str) {
        return zza(context, str, true);
    }

    String zza(byte[] bArr, String str) {
        byte[] bArr2;
        if (bArr.length > 239) {
            zzt();
            zza(20, 1);
            bArr = zzu();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(256).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[256];
        new zzf().zza(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            zza(str, bArr3);
        }
        return this.zzkx.zza(bArr3, true);
    }

    public void zza(int i, int i2, int i3) {
        if (this.zzkv != null) {
            this.zzkv.recycle();
        }
        this.zzkv = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.zzkw.density, ((float) i2) * this.zzkw.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void zza(int i, long j) {
        this.zzky.zzb(i, j);
    }

    protected void zza(int i, String str) {
        this.zzky.zzb(i, str);
    }

    public void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.zzkv != null) {
                this.zzkv.recycle();
            }
            this.zzkv = MotionEvent.obtain(motionEvent);
        }
    }

    void zza(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzwp(str.getBytes("UTF-8")).zzs(bArr);
    }

    protected abstract void zzb(Context context);

    protected abstract void zzc(Context context);
}
