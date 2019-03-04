package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;

public final class zzl implements Callback {
    private final Handler mHandler;
    private final zza zzPX;
    private final ArrayList<ConnectionCallbacks> zzPY = new ArrayList();
    final ArrayList<ConnectionCallbacks> zzPZ = new ArrayList();
    private boolean zzQa = false;
    private final ArrayList<OnConnectionFailedListener> zzQb = new ArrayList();

    public interface zza {
        boolean isConnected();

        Bundle zzhp();

        boolean zzin();
    }

    public zzl(Looper looper, zza com_google_android_gms_common_internal_zzl_zza) {
        this.zzPX = com_google_android_gms_common_internal_zzl_zza;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.zzPY) {
                if (this.zzPX.zzin() && this.zzPX.isConnected() && this.zzPY.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzPX.zzhp());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzx.zzl(connectionCallbacks);
        synchronized (this.zzPY) {
            contains = this.zzPY.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzx.zzl(onConnectionFailedListener);
        synchronized (this.zzQb) {
            contains = this.zzQb.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzx.zzl(connectionCallbacks);
        synchronized (this.zzPY) {
            if (this.zzPY.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.zzPY.add(connectionCallbacks);
            }
        }
        if (this.zzPX.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzl(onConnectionFailedListener);
        synchronized (this.zzQb) {
            if (this.zzQb.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.zzQb.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzx.zzl(connectionCallbacks);
        synchronized (this.zzPY) {
            if (!this.zzPY.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.zzQa) {
                this.zzPZ.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzl(onConnectionFailedListener);
        synchronized (this.zzQb) {
            if (!this.zzQb.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    public void zzaJ(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.zzPY) {
            this.zzQa = true;
            Iterator it = new ArrayList(this.zzPY).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.zzPX.zzin()) {
                    break;
                } else if (this.zzPY.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzPZ.clear();
            this.zzQa = false;
        }
    }

    protected void zzfe() {
        synchronized (this.zzPY) {
            zzj(this.zzPX.zzhp());
        }
    }

    public void zzg(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.zzQb) {
            Iterator it = new ArrayList(this.zzQb).iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (!this.zzPX.zzin()) {
                    return;
                } else if (this.zzQb.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public void zzj(Bundle bundle) {
        boolean z = true;
        synchronized (this.zzPY) {
            zzx.zzN(!this.zzQa);
            this.mHandler.removeMessages(1);
            this.zzQa = true;
            if (this.zzPZ.size() != 0) {
                z = false;
            }
            zzx.zzN(z);
            Iterator it = new ArrayList(this.zzPY).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.zzPX.zzin() || !this.zzPX.isConnected()) {
                    break;
                } else if (!this.zzPZ.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzPZ.clear();
            this.zzQa = false;
        }
    }
}
