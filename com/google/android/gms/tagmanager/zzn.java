package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

class zzn implements ContainerHolder {
    private Status zzHb;
    private final Looper zzMc;
    private boolean zzSW;
    private Container zzaxE;
    private Container zzaxF;
    private zzb zzaxG;
    private zza zzaxH;
    private TagManager zzaxI;

    public interface zza {
        void zzcQ(String str);

        String zzsK();

        void zzsM();
    }

    class zzb extends Handler {
        private final ContainerAvailableListener zzaxJ;
        final /* synthetic */ zzn zzaxK;

        public zzb(zzn com_google_android_gms_tagmanager_zzn, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.zzaxK = com_google_android_gms_tagmanager_zzn;
            super(looper);
            this.zzaxJ = containerAvailableListener;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzcS((String) message.obj);
                    return;
                default:
                    zzbf.zzZ("Don't know how to handle this message.");
                    return;
            }
        }

        public void zzcR(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void zzcS(String str) {
            this.zzaxJ.onContainerAvailable(this.zzaxK, str);
        }
    }

    public zzn(Status status) {
        this.zzHb = status;
        this.zzMc = null;
    }

    public zzn(TagManager tagManager, Looper looper, Container container, zza com_google_android_gms_tagmanager_zzn_zza) {
        this.zzaxI = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzMc = looper;
        this.zzaxE = container;
        this.zzaxH = com_google_android_gms_tagmanager_zzn_zza;
        this.zzHb = Status.zzNo;
        tagManager.zza(this);
    }

    private void zzsL() {
        if (this.zzaxG != null) {
            this.zzaxG.zzcR(this.zzaxF.zzsI());
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.zzSW) {
                zzbf.zzZ("ContainerHolder is released.");
            } else {
                if (this.zzaxF != null) {
                    this.zzaxE = this.zzaxF;
                    this.zzaxF = null;
                }
                container = this.zzaxE;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.zzSW) {
            return this.zzaxE.getContainerId();
        }
        zzbf.zzZ("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.zzHb;
    }

    public synchronized void refresh() {
        if (this.zzSW) {
            zzbf.zzZ("Refreshing a released ContainerHolder.");
        } else {
            this.zzaxH.zzsM();
        }
    }

    public synchronized void release() {
        if (this.zzSW) {
            zzbf.zzZ("Releasing a released ContainerHolder.");
        } else {
            this.zzSW = true;
            this.zzaxI.zzb(this);
            this.zzaxE.release();
            this.zzaxE = null;
            this.zzaxF = null;
            this.zzaxH = null;
            this.zzaxG = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener containerAvailableListener) {
        if (this.zzSW) {
            zzbf.zzZ("ContainerHolder is released.");
        } else if (containerAvailableListener == null) {
            this.zzaxG = null;
        } else {
            this.zzaxG = new zzb(this, containerAvailableListener, this.zzMc);
            if (this.zzaxF != null) {
                zzsL();
            }
        }
    }

    public synchronized void zza(Container container) {
        if (!this.zzSW) {
            if (container == null) {
                zzbf.zzZ("Unexpected null container.");
            } else {
                this.zzaxF = container;
                zzsL();
            }
        }
    }

    public synchronized void zzcO(String str) {
        if (!this.zzSW) {
            this.zzaxE.zzcO(str);
        }
    }

    void zzcQ(String str) {
        if (this.zzSW) {
            zzbf.zzZ("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzaxH.zzcQ(str);
        }
    }

    String zzsK() {
        if (!this.zzSW) {
            return this.zzaxH.zzsK();
        }
        zzbf.zzZ("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }
}
