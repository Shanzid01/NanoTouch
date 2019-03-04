package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzrk extends zzk<zzrn> {
    private final long zzadW = ((long) hashCode());

    class zzb extends zzrj {
        private final com.google.android.gms.common.api.zze<MessageListener> zzasI;

        zzb(com.google.android.gms.common.api.zze<MessageListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzasI = com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(final String str) {
            this.zzasI.zza(new com.google.android.gms.common.api.zze.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzasL;

                public void zza(MessageListener messageListener) {
                    messageListener.onDisconnected(str);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((MessageListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void onMessageReceived(final String str, final byte[] bArr, final boolean z) {
            this.zzasI.zza(new com.google.android.gms.common.api.zze.zzb<MessageListener>(this) {
                final /* synthetic */ zzb zzasL;

                public void zza(MessageListener messageListener) {
                    messageListener.onMessageReceived(str, bArr, z);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((MessageListener) obj);
                }

                public void zzhX() {
                }
            });
        }
    }

    final class zza extends zzb {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com.google.android.gms.common.api.zze<MessageListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzgv(int i) {
            this.zzHa.zzd(new Status(i));
        }
    }

    final class zzc extends zzb {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;
        private final com.google.android.gms.common.api.zze<ConnectionResponseCallback> zzasM;

        public zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com.google.android.gms.common.api.zze<ConnectionResponseCallback> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com.google.android.gms.common.api.zze<MessageListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzasM = (com.google.android.gms.common.api.zze) zzx.zzl(com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(final String str, final int i, final byte[] bArr) {
            this.zzasM.zza(new com.google.android.gms.common.api.zze.zzb<ConnectionResponseCallback>(this) {
                final /* synthetic */ zzc zzasN;

                public void zza(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((ConnectionResponseCallback) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void zzgu(int i) {
            this.zzHa.zzd(new Status(i));
        }
    }

    final class zzd extends zzrj {
        private final com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> zzHa;
        private final com.google.android.gms.common.api.zze<ConnectionRequestListener> zzasO;

        zzd(com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com.google.android.gms.common.api.zze<ConnectionRequestListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzasO = (com.google.android.gms.common.api.zze) zzx.zzl(com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final byte[] bArr2 = bArr;
            this.zzasO.zza(new com.google.android.gms.common.api.zze.zzb<ConnectionRequestListener>(this) {
                final /* synthetic */ zzd zzasR;

                public void zza(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str4, str5, str6, bArr2);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((ConnectionRequestListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void zzi(int i, String str) {
            this.zzHa.zzd(new zze(new Status(i), str));
        }
    }

    final class zze implements StartAdvertisingResult {
        private final Status zzHb;
        private final String zzasS;

        zze(Status status, String str) {
            this.zzHb = status;
            this.zzasS = str;
        }

        public String getLocalEndpointName() {
            return this.zzasS;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class zzf extends zzrj {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;
        private final com.google.android.gms.common.api.zze<EndpointDiscoveryListener> zzasO;

        zzf(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com.google.android.gms.common.api.zze<EndpointDiscoveryListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzl(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzasO = (com.google.android.gms.common.api.zze) zzx.zzl(com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String str, String str2, String str3, String str4) {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            this.zzasO.zza(new com.google.android.gms.common.api.zze.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzf zzasW;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str5, str6, str7, str8);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void onEndpointLost(final String str) {
            this.zzasO.zza(new com.google.android.gms.common.api.zze.zzb<EndpointDiscoveryListener>(this) {
                final /* synthetic */ zzf zzasW;

                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(str);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }

                public void zzhX() {
                }
            });
        }

        public void zzgs(int i) {
            this.zzHa.zzd(new Status(i));
        }
    }

    public zzrk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzrn) zzjb()).zzu(this.zzadW);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str, long j, com.google.android.gms.common.api.zze<EndpointDiscoveryListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
        ((zzrn) zzjb()).zza(new zzf(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StartAdvertisingResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, com.google.android.gms.common.api.zze<ConnectionRequestListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
        ((zzrn) zzjb()).zza(new zzd(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, com.google.android.gms.common.api.zze<ConnectionResponseCallback> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com.google.android.gms.common.api.zze<MessageListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener) {
        ((zzrn) zzjb()).zza(new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, com.google.android.gms.common.api.zze<MessageListener> com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener) {
        ((zzrn) zzjb()).zza(new zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zze_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzadW);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzrn) zzjb()).zza(strArr, bArr, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzrn) zzjb()).zzb(strArr, bArr, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    protected zzrn zzcg(IBinder iBinder) {
        return com.google.android.gms.internal.zzrn.zza.zzci(iBinder);
    }

    public void zzcx(String str) {
        try {
            ((zzrn) zzjb()).zzb(str, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzcy(String str) {
        try {
            ((zzrn) zzjb()).zzc(str, this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcg(iBinder);
    }

    public void zzq(final com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str) {
        ((zzrn) zzjb()).zza(new zzrj(this) {
            final /* synthetic */ zzrk zzasH;

            public void zzgw(int i) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzd(new Status(i));
            }
        }, str, this.zzadW);
    }

    public String zzrk() {
        try {
            return ((zzrn) zzjb()).zzE(this.zzadW);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzrl() {
        try {
            return ((zzrn) zzjb()).zzrl();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzrm() {
        try {
            ((zzrn) zzjb()).zzB(this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzrn() {
        try {
            ((zzrn) zzjb()).zzD(this.zzadW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }
}
