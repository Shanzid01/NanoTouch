package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzlo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzn extends zzm implements Callback {
    private final Handler mHandler;
    private final HashMap<zza, zzb> zzQe = new HashMap();
    private final zzlo zzQf;
    private final long zzQg;
    private final Context zznk;

    final class zza {
        private final ComponentName zzQh;
        private final String zzrc;

        public zza(ComponentName componentName) {
            this.zzrc = null;
            this.zzQh = (ComponentName) zzx.zzl(componentName);
        }

        public zza(String str) {
            this.zzrc = zzx.zzbn(str);
            this.zzQh = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_common_internal_zzn_zza = (zza) obj;
            return zzw.equal(this.zzrc, com_google_android_gms_common_internal_zzn_zza.zzrc) && zzw.equal(this.zzQh, com_google_android_gms_common_internal_zzn_zza.zzQh);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzrc, this.zzQh);
        }

        public String toString() {
            return this.zzrc == null ? this.zzQh.flattenToString() : this.zzrc;
        }

        public Intent zzjj() {
            return this.zzrc != null ? new Intent(this.zzrc).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) : new Intent().setComponent(this.zzQh);
        }
    }

    final class zzb {
        private int mState = 2;
        private IBinder zzPp;
        private ComponentName zzQh;
        private final zza zzQi = new zza(this);
        private final Set<ServiceConnection> zzQj = new HashSet();
        private boolean zzQk;
        private final zza zzQl;
        final /* synthetic */ zzn zzQm;

        public class zza implements ServiceConnection {
            final /* synthetic */ zzb zzQn;

            public zza(zzb com_google_android_gms_common_internal_zzn_zzb) {
                this.zzQn = com_google_android_gms_common_internal_zzn_zzb;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.zzQn.zzQm.zzQe) {
                    this.zzQn.zzPp = iBinder;
                    this.zzQn.zzQh = componentName;
                    for (ServiceConnection onServiceConnected : this.zzQn.zzQj) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.zzQn.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.zzQn.zzQm.zzQe) {
                    this.zzQn.zzPp = null;
                    this.zzQn.zzQh = componentName;
                    for (ServiceConnection onServiceDisconnected : this.zzQn.zzQj) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.zzQn.mState = 2;
                }
            }
        }

        public zzb(zzn com_google_android_gms_common_internal_zzn, zza com_google_android_gms_common_internal_zzn_zza) {
            this.zzQm = com_google_android_gms_common_internal_zzn;
            this.zzQl = com_google_android_gms_common_internal_zzn_zza;
        }

        public IBinder getBinder() {
            return this.zzPp;
        }

        public ComponentName getComponentName() {
            return this.zzQh;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzQk;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            this.zzQm.zzQf.zza(this.zzQm.zznk, serviceConnection, str, this.zzQl.zzjj());
            this.zzQj.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzQj.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            this.zzQm.zzQf.zzb(this.zzQm.zznk, serviceConnection);
            this.zzQj.remove(serviceConnection);
        }

        public void zzbh(String str) {
            this.zzQk = this.zzQm.zzQf.zza(this.zzQm.zznk, str, this.zzQl.zzjj(), this.zzQi, 129);
            if (this.zzQk) {
                this.mState = 3;
            } else {
                this.zzQm.zzQf.zza(this.zzQm.zznk, this.zzQi);
            }
        }

        public void zzbi(String str) {
            this.zzQm.zzQf.zza(this.zzQm.zznk, this.zzQi);
            this.zzQk = false;
            this.mState = 2;
        }

        public boolean zzjk() {
            return this.zzQj.isEmpty();
        }
    }

    zzn(Context context) {
        this.zznk = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzQf = zzlo.zzka();
        this.zzQg = 5000;
    }

    private boolean zza(zza com_google_android_gms_common_internal_zzn_zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzx.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzQe) {
            zzb com_google_android_gms_common_internal_zzn_zzb = (zzb) this.zzQe.get(com_google_android_gms_common_internal_zzn_zza);
            if (com_google_android_gms_common_internal_zzn_zzb != null) {
                this.mHandler.removeMessages(0, com_google_android_gms_common_internal_zzn_zzb);
                if (!com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection)) {
                    com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzn_zzb.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzn_zzb.getComponentName(), com_google_android_gms_common_internal_zzn_zzb.getBinder());
                            break;
                        case 2:
                            com_google_android_gms_common_internal_zzn_zzb.zzbh(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + com_google_android_gms_common_internal_zzn_zza);
            }
            com_google_android_gms_common_internal_zzn_zzb = new zzb(this, com_google_android_gms_common_internal_zzn_zza);
            com_google_android_gms_common_internal_zzn_zzb.zza(serviceConnection, str);
            com_google_android_gms_common_internal_zzn_zzb.zzbh(str);
            this.zzQe.put(com_google_android_gms_common_internal_zzn_zza, com_google_android_gms_common_internal_zzn_zzb);
            isBound = com_google_android_gms_common_internal_zzn_zzb.isBound();
        }
        return isBound;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzb(com.google.android.gms.common.internal.zzn.zza r7, android.content.ServiceConnection r8, java.lang.String r9) {
        /*
        r6 = this;
        r0 = "ServiceConnection must not be null";
        com.google.android.gms.common.internal.zzx.zzb(r8, r0);
        r1 = r6.zzQe;
        monitor-enter(r1);
        r0 = r6.zzQe;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r7);	 Catch:{ all -> 0x002b }
        r0 = (com.google.android.gms.common.internal.zzn.zzb) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x002e;
    L_0x0012:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x002b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002b }
        r2.<init>();	 Catch:{ all -> 0x002b }
        r3 = "Nonexistent connection status for service config: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x002b }
        r2 = r2.append(r7);	 Catch:{ all -> 0x002b }
        r2 = r2.toString();	 Catch:{ all -> 0x002b }
        r0.<init>(r2);	 Catch:{ all -> 0x002b }
        throw r0;	 Catch:{ all -> 0x002b }
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r2 = r0.zza(r8);	 Catch:{ all -> 0x002b }
        if (r2 != 0) goto L_0x004e;
    L_0x0034:
        r0 = "GmsClientSupervisor";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002b }
        r2.<init>();	 Catch:{ all -> 0x002b }
        r3 = "Trying to unbind a GmsServiceConnection that was not bound before. config=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x002b }
        r2 = r2.append(r7);	 Catch:{ all -> 0x002b }
        r2 = r2.toString();	 Catch:{ all -> 0x002b }
        android.util.Log.e(r0, r2);	 Catch:{ all -> 0x002b }
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
    L_0x004d:
        return;
    L_0x004e:
        r0.zzb(r8, r9);	 Catch:{ all -> 0x002b }
        r2 = r0.zzjk();	 Catch:{ all -> 0x002b }
        if (r2 == 0) goto L_0x0065;
    L_0x0057:
        r2 = r6.mHandler;	 Catch:{ all -> 0x002b }
        r3 = 0;
        r0 = r2.obtainMessage(r3, r0);	 Catch:{ all -> 0x002b }
        r2 = r6.mHandler;	 Catch:{ all -> 0x002b }
        r4 = r6.zzQg;	 Catch:{ all -> 0x002b }
        r2.sendMessageDelayed(r0, r4);	 Catch:{ all -> 0x002b }
    L_0x0065:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzn.zzb(com.google.android.gms.common.internal.zzn$zza, android.content.ServiceConnection, java.lang.String):void");
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb com_google_android_gms_common_internal_zzn_zzb = (zzb) message.obj;
                synchronized (this.zzQe) {
                    if (com_google_android_gms_common_internal_zzn_zzb.zzjk()) {
                        if (com_google_android_gms_common_internal_zzn_zzb.isBound()) {
                            com_google_android_gms_common_internal_zzn_zzb.zzbi("GmsClientSupervisor");
                        }
                        this.zzQe.remove(com_google_android_gms_common_internal_zzn_zzb.zzQl);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
