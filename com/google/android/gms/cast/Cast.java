package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkb;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(zzGS, zzkb.zzGR, new Scope[0]);
    public static final CastApi CastApi = new zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    private static final zzb<zzju, CastOptions> zzGS = new C08081();

    final class C08081 implements zzb<zzju, CastOptions> {
        C08081() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzju zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb((Object) castOptions, (Object) "Setting the API options is required.");
            return new zzju(context, looper, castOptions.zzIx, (long) castOptions.zzIz, castOptions.zzIy, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    abstract class zza extends zzjr<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzh(status);
        }

        public ApplicationConnectionResult zzh(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ zza zzID;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    public interface CastApi {

        public final class zza implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) {
                return ((zzju) googleApiClient.zza(zzkb.zzGR)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient googleApiClient) {
                return ((zzju) googleApiClient.zza(zzkb.zzGR)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient googleApiClient) {
                return ((zzju) googleApiClient.zza(zzkb.zzGR)).zzhs();
            }

            public boolean isMute(GoogleApiClient googleApiClient) {
                return ((zzju) googleApiClient.zza(zzkb.zzGR)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zzb(null, null, this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zzb(str, null, this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zzb(str, str2, this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zza(str, false, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, final String str, final LaunchOptions launchOptions) {
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zza(str, launchOptions, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
                return launchApplication(googleApiClient, str, new Builder().setRelaunchIfRunning(z).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzjy(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zzd((com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) {
                try {
                    ((zzju) googleApiClient.zza(zzkb.zzGR)).zzaJ(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient googleApiClient) {
                try {
                    ((zzju) googleApiClient.zza(zzkb.zzGR)).zzhr();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.zzb(new zzjy(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zza(str, str2, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalArgumentException e) {
                            zzah(2001);
                        } catch (IllegalStateException e2) {
                            zzah(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) {
                try {
                    ((zzju) googleApiClient.zza(zzkb.zzGR)).zza(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient googleApiClient, boolean z) {
                try {
                    ((zzju) googleApiClient.zza(zzkb.zzGR)).zzL(z);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient googleApiClient, double d) {
                try {
                    ((zzju) googleApiClient.zza(zzkb.zzGR)).zza(d);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzjy(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        try {
                            com_google_android_gms_internal_zzju.zza("", (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zzjy(this, googleApiClient) {
                    final /* synthetic */ zza zzIt;

                    protected void zza(zzju com_google_android_gms_internal_zzju) {
                        if (TextUtils.isEmpty(str)) {
                            zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            com_google_android_gms_internal_zzju.zza(str, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzah(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient);

        String getApplicationStatus(GoogleApiClient googleApiClient);

        double getVolume(GoogleApiClient googleApiClient);

        boolean isMute(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str);

        void requestStatus(GoogleApiClient googleApiClient);

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback);

        void setMute(GoogleApiClient googleApiClient, boolean z);

        void setVolume(GoogleApiClient googleApiClient, double d);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public final class CastOptions implements HasOptions {
        final CastDevice zzIx;
        final Listener zzIy;
        private final int zzIz;

        public final class Builder {
            CastDevice zzIA;
            Listener zzIB;
            private int zzIC;

            private Builder(CastDevice castDevice, Listener listener) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                zzx.zzb((Object) listener, (Object) "CastListener parameter cannot be null");
                this.zzIA = castDevice;
                this.zzIB = listener;
                this.zzIC = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean z) {
                if (z) {
                    this.zzIC |= 1;
                } else {
                    this.zzIC &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzIx = builder.zzIA;
            this.zzIy = builder.zzIB;
            this.zzIz = builder.zzIC;
        }

        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }
    }

    public class Listener {
        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }

        public void zzab(int i) {
        }

        public void zzac(int i) {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private Cast() {
    }
}
