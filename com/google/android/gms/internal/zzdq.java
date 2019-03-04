package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzdr.zza;
import java.util.Map;

@zzgi
public final class zzdq extends zza {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzsP;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzds zzD(String str) {
        try {
            Class cls = Class.forName(str, false, zzdq.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new zzdx(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.zzsP.get(mediationAdapter.mo1177b()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzdv((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                zzhx.zzac("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            zzhx.zzac("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzds zzB(String str) {
        return zzD(str);
    }

    public boolean zzC(String str) {
        boolean z = false;
        try {
            z = CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzdq.class.getClassLoader()));
        } catch (Throwable th) {
            zzhx.zzac("Could not load custom event implementation class: " + str + ", assuming old implementation.");
        }
        return z;
    }

    public void zze(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzsP = map;
    }
}
