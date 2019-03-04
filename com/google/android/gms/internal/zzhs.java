package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

@zzgi
public class zzhs {
    private final Context mContext;
    private int mState;
    private final float zztH;
    private String zzzv;
    private float zzzw;
    private float zzzx;
    private float zzzy;

    class C12362 implements OnClickListener {
        final /* synthetic */ zzhs zzzA;

        C12362(zzhs com_google_android_gms_internal_zzhs) {
            this.zzzA = com_google_android_gms_internal_zzhs;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public zzhs(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zztH = context.getResources().getDisplayMetrics().density;
    }

    public zzhs(Context context, String str) {
        this(context);
        this.zzzv = str;
    }

    private void showDialog() {
        if (this.mContext instanceof Activity) {
            Object obj;
            if (TextUtils.isEmpty(this.zzzv)) {
                obj = "No debug information";
            } else {
                Uri build = new Builder().encodedQuery(this.zzzv).build();
                StringBuilder stringBuilder = new StringBuilder();
                Map zzd = zzab.zzaM().zzd(build);
                for (String str : zzd.keySet()) {
                    stringBuilder.append(str).append(" = ").append((String) zzd.get(str)).append("\n\n");
                }
                obj = stringBuilder.toString().trim();
                if (TextUtils.isEmpty(obj)) {
                    obj = "No debug information";
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setMessage(obj);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new OnClickListener(this) {
                final /* synthetic */ zzhs zzzA;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.zzzA.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", obj), "Share via"));
                }
            });
            builder.setNegativeButton("Close", new C12362(this));
            builder.create().show();
            return;
        }
        zzhx.zzaa("Can not create dialog without Activity Context");
    }

    public void zzV(String str) {
        this.zzzv = str;
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzzw = f;
            this.zzzx = f2;
            this.zzzy = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzzx) {
                    this.zzzx = f2;
                } else if (f2 < this.zzzy) {
                    this.zzzy = f2;
                }
                if (this.zzzx - this.zzzy > BitmapDescriptorFactory.HUE_ORANGE * this.zztH) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzzw >= 50.0f * this.zztH) {
                        this.zzzw = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzzw <= -50.0f * this.zztH) {
                    this.zzzw = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzzw) {
                        this.zzzw = f;
                    }
                } else if (this.mState == 2 && f < this.zzzw) {
                    this.zzzw = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzc(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
