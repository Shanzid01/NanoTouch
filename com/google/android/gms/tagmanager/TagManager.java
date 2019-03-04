package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzaAS;
    private final Context mContext;
    private final zza zzaAP;
    private final zzcs zzaAQ;
    private final ConcurrentMap<zzn, Boolean> zzaAR;
    private final DataLayer zzaxx;
    private final zzr zzazO;

    class C14091 implements zzb {
        final /* synthetic */ TagManager zzaAT;

        C14091(TagManager tagManager) {
            this.zzaAT = tagManager;
        }

        public void zzI(Map<String, Object> map) {
            Object obj = map.get("event");
            if (obj != null) {
                this.zzaAT.zzdk(obj.toString());
            }
        }
    }

    public interface zza {
        zzo zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzr com_google_android_gms_tagmanager_zzr);
    }

    final class C14102 implements zza {
        C14102() {
        }

        public zzo zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzr com_google_android_gms_tagmanager_zzr) {
            return new zzo(context, tagManager, looper, str, i, com_google_android_gms_tagmanager_zzr);
        }
    }

    class C14113 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager zzaAT;

        C14113(TagManager tagManager) {
            this.zzaAT = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzaAT.dispatch();
            }
        }
    }

    TagManager(Context context, zza com_google_android_gms_tagmanager_TagManager_zza, DataLayer dataLayer, zzcs com_google_android_gms_tagmanager_zzcs) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzaAQ = com_google_android_gms_tagmanager_zzcs;
        this.zzaAP = com_google_android_gms_tagmanager_TagManager_zza;
        this.zzaAR = new ConcurrentHashMap();
        this.zzaxx = dataLayer;
        this.zzaxx.zza(new C14091(this));
        this.zzaxx.zza(new zzd(this.mContext));
        this.zzazO = new zzr();
        zztT();
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzaAS == null) {
                if (context == null) {
                    zzbf.zzZ("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzaAS = new TagManager(context, new C14102(), new DataLayer(new zzv(context)), zzct.zztR());
            }
            tagManager = zzaAS;
        }
        return tagManager;
    }

    private void zzdk(String str) {
        for (zzn zzcO : this.zzaAR.keySet()) {
            zzcO.zzcO(str);
        }
    }

    private void zztT() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C14113(this));
        }
    }

    public void dispatch() {
        this.zzaAQ.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzaxx;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, str, i, this.zzazO);
        zza.zzsN();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, handler.getLooper(), str, i, this.zzazO);
        zza.zzsN();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, str, i, this.zzazO);
        zza.zzsP();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, handler.getLooper(), str, i, this.zzazO);
        zza.zzsP();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, str, i, this.zzazO);
        zza.zzsO();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, handler.getLooper(), str, i, this.zzazO);
        zza.zzsO();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzbf.setLogLevel(z ? 2 : 5);
    }

    void zza(zzn com_google_android_gms_tagmanager_zzn) {
        this.zzaAR.put(com_google_android_gms_tagmanager_zzn, Boolean.valueOf(true));
    }

    boolean zzb(zzn com_google_android_gms_tagmanager_zzn) {
        return this.zzaAR.remove(com_google_android_gms_tagmanager_zzn) != null;
    }

    public PendingResult<ContainerHolder> zzc(String str, int i, String str2) {
        PendingResult zza = this.zzaAP.zza(this.mContext, this, null, str, i, this.zzazO);
        zza.load(str2);
        return zza;
    }

    synchronized boolean zzl(Uri uri) {
        boolean z;
        zzca zztx = zzca.zztx();
        if (zztx.zzl(uri)) {
            String containerId = zztx.getContainerId();
            switch (zztx.zzty()) {
                case NONE:
                    for (zzn com_google_android_gms_tagmanager_zzn : this.zzaAR.keySet()) {
                        if (com_google_android_gms_tagmanager_zzn.getContainerId().equals(containerId)) {
                            com_google_android_gms_tagmanager_zzn.zzcQ(null);
                            com_google_android_gms_tagmanager_zzn.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzn com_google_android_gms_tagmanager_zzn2 : this.zzaAR.keySet()) {
                        if (com_google_android_gms_tagmanager_zzn2.getContainerId().equals(containerId)) {
                            com_google_android_gms_tagmanager_zzn2.zzcQ(zztx.zztz());
                            com_google_android_gms_tagmanager_zzn2.refresh();
                        } else if (com_google_android_gms_tagmanager_zzn2.zzsK() != null) {
                            com_google_android_gms_tagmanager_zzn2.zzcQ(null);
                            com_google_android_gms_tagmanager_zzn2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
