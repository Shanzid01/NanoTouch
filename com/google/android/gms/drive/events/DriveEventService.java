package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzw;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzPm;
    private CountDownLatch zzSX;
    zza zzSY;
    boolean zzSZ;

    final class zza extends Handler {
        final /* synthetic */ DriveEventService zzTb;

        zza(DriveEventService driveEventService) {
            this.zzTb = driveEventService;
        }

        private Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message zzkC() {
            return obtainMessage(2);
        }

        public void handleMessage(Message message) {
            zzw.zzq("DriveEventService", "handleMessage message type:" + message.what);
            switch (message.what) {
                case 1:
                    this.zzTb.zza((OnEventResponse) message.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    zzw.zzr("DriveEventService", "Unexpected message type:" + message.what);
                    return;
            }
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzai.zza {
        final /* synthetic */ DriveEventService zzTb;

        zzb(DriveEventService driveEventService) {
            this.zzTb = driveEventService;
        }

        public void zzc(OnEventResponse onEventResponse) {
            synchronized (this.zzTb) {
                zzw.zzq("DriveEventService", "onEvent: " + onEventResponse);
                this.zzTb.zzkB();
                if (this.zzTb.zzSY != null) {
                    this.zzTb.zzSY.sendMessage(this.zzTb.zzSY.zzb(onEventResponse));
                } else {
                    zzw.zzs("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.zzSZ = false;
        this.zzPm = -1;
        this.mName = str;
    }

    private void zza(OnEventResponse onEventResponse) {
        DriveEvent zzkQ = onEventResponse.zzkQ();
        zzw.zzq("DriveEventService", "handleEventMessage: " + zzkQ);
        try {
            switch (zzkQ.getType()) {
                case 1:
                    onChange((ChangeEvent) zzkQ);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzkQ);
                    return;
                default:
                    zzw.zzr(this.mName, "Unhandled event: " + zzkQ);
                    return;
            }
        } catch (Throwable e) {
            zzw.zza(this.mName, e, "Error handling event: " + zzkQ);
        }
        zzw.zza(this.mName, e, "Error handling event: " + zzkQ);
    }

    private void zzkB() {
        int callingUid = getCallingUid();
        if (callingUid != this.zzPm) {
            if (GooglePlayServicesUtil.zzd(this, callingUid)) {
                this.zzPm = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzSY == null && !this.zzSZ) {
                this.zzSZ = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzSX = new CountDownLatch(1);
                new Thread(this) {
                    final /* synthetic */ DriveEventService zzTb;

                    public void run() {
                        try {
                            Looper.prepare();
                            this.zzTb.zzSY = new zza(this.zzTb);
                            this.zzTb.zzSZ = false;
                            countDownLatch.countDown();
                            zzw.zzq("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            zzw.zzq("DriveEventService", "Finished loop");
                        } finally {
                            if (this.zzTb.zzSX != null) {
                                this.zzTb.zzSX.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzw.zzs("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new zzb(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent changeEvent) {
        zzw.zzr(this.mName, "Unhandled change event: " + changeEvent);
    }

    public void onCompletion(CompletionEvent completionEvent) {
        zzw.zzr(this.mName, "Unhandled completion event: " + completionEvent);
    }

    public synchronized void onDestroy() {
        zzw.zzq("DriveEventService", "onDestroy");
        if (this.zzSY != null) {
            this.zzSY.sendMessage(this.zzSY.zzkC());
            this.zzSY = null;
            try {
                if (!this.zzSX.await(5000, TimeUnit.MILLISECONDS)) {
                    zzw.zzr("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzSX = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
