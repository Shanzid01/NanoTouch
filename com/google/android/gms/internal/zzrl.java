package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzrl implements Connections {
    public static final com.google.android.gms.common.api.Api.zzc<zzrk> zzGR = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zzb<zzrk, NoOptions> zzGS = new C13241();

    final class C13241 implements com.google.android.gms.common.api.Api.zzb<zzrk, NoOptions> {
        C13241() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzl(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzrk zzl(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrk(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzrk> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzrl.zzGR, googleApiClient);
        }
    }

    abstract class zzb extends zza<StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzaF(status);
        }

        public StartAdvertisingResult zzaF(final Status status) {
            return new StartAdvertisingResult(this) {
                final /* synthetic */ zzb zzate;

                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public static zzrk zzd(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzrk zze(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zzb = googleApiClient.zzb(Nearby.CONNECTIONS_API);
        if (!z || zzb) {
            return zzb ? (zzrk) googleApiClient.zza(zzGR) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, MessageListener messageListener) {
        final zze zzf = googleApiClient.zzf(messageListener);
        final String str2 = str;
        final byte[] bArr2 = bArr;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk com_google_android_gms_internal_zzrk) {
                com_google_android_gms_internal_zzrk.zza((com.google.android.gms.common.api.zza.zzb) this, str2, bArr2, zzf);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzcy(str);
    }

    public String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzrl();
    }

    public String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzrk();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk com_google_android_gms_internal_zzrk) {
                com_google_android_gms_internal_zzrk.zzq(this, str);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        final zze zzf = googleApiClient.zzf(connectionResponseCallback);
        final zze zzf2 = googleApiClient.zzf(messageListener);
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk com_google_android_gms_internal_zzrk) {
                com_google_android_gms_internal_zzrk.zza(this, str3, str4, bArr2, zzf, zzf2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zza(new String[]{str}, bArr);
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zza((String[]) list.toArray(new String[list.size()]), bArr);
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zzb(new String[]{str}, bArr);
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zzb((String[]) list.toArray(new String[list.size()]), bArr);
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, ConnectionRequestListener connectionRequestListener) {
        final zze zzf = googleApiClient.zzf(connectionRequestListener);
        final String str2 = str;
        final AppMetadata appMetadata2 = appMetadata;
        final long j2 = j;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk com_google_android_gms_internal_zzrk) {
                com_google_android_gms_internal_zzrk.zza(this, str2, appMetadata2, j2, zzf);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, EndpointDiscoveryListener endpointDiscoveryListener) {
        final zze zzf = googleApiClient.zzf(endpointDiscoveryListener);
        final String str2 = str;
        final long j2 = j;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzrl zzata;

            protected void zza(zzrk com_google_android_gms_internal_zzrk) {
                com_google_android_gms_internal_zzrk.zza((com.google.android.gms.common.api.zza.zzb) this, str2, j2, zzf);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzrm();
    }

    public void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzrn();
    }

    public void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzcx(str);
    }
}
