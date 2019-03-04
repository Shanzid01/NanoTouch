package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import java.util.ArrayList;
import java.util.List;

public class zzaa extends com.google.android.gms.drive.internal.zzai.zza {
    private final int zzTe;
    private final zzc zzUp;
    private final zza zzUq;
    private final List<Integer> zzUr = new ArrayList();

    class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzc com_google_android_gms_drive_events_zzc = (zzc) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) com_google_android_gms_drive_events_zzc).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) com_google_android_gms_drive_events_zzc).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            ((zzf) com_google_android_gms_drive_events_zzc).zzkD();
                            return;
                        default:
                            zzw.zzr("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzw.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzc com_google_android_gms_drive_events_zzc, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(com_google_android_gms_drive_events_zzc, driveEvent)));
        }
    }

    public zzaa(Looper looper, Context context, int i, zzc com_google_android_gms_drive_events_zzc) {
        this.zzTe = i;
        this.zzUp = com_google_android_gms_drive_events_zzc;
        this.zzUq = new zza(looper, context);
    }

    public void zzbJ(int i) {
        this.zzUr.add(Integer.valueOf(i));
    }

    public boolean zzbK(int i) {
        return this.zzUr.contains(Integer.valueOf(i));
    }

    public void zzc(OnEventResponse onEventResponse) {
        DriveEvent zzkQ = onEventResponse.zzkQ();
        zzx.zzN(this.zzTe == zzkQ.getType());
        zzx.zzN(this.zzUr.contains(Integer.valueOf(zzkQ.getType())));
        this.zzUq.zza(this.zzUp, zzkQ);
    }
}
