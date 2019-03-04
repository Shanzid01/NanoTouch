package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzkd zzJs = new zzkd(this, null) {
        final /* synthetic */ RemoteMediaPlayer zzJw;

        protected void onMetadataUpdated() {
            this.zzJw.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.zzJw.onStatusUpdated();
        }
    };
    private final zza zzJt = new zza(this);
    private OnMetadataUpdatedListener zzJu;
    private OnStatusUpdatedListener zzJv;
    private final Object zznh = new Object();

    abstract class zzb extends zzjr<MediaChannelResult> {
        zzkf zzJN = new C08281(this);

        class C08281 implements zzkf {
            final /* synthetic */ zzb zzJO;

            C08281(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzJO = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzJO.setResult(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzn(long j) {
                this.zzJO.setResult(this.zzJO.zzj(new Status(2103)));
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzj(status);
        }

        public MediaChannelResult zzj(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ zzb zzJO;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    class zza implements zzke {
        private GoogleApiClient zzJJ;
        private long zzJK = 0;
        final /* synthetic */ RemoteMediaPlayer zzJw;

        final class zza implements ResultCallback<Status> {
            private final long zzJL;
            final /* synthetic */ zza zzJM;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzJM = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzJL = j;
            }

            public /* synthetic */ void onResult(Result result) {
                zzi((Status) result);
            }

            public void zzi(Status status) {
                if (!status.isSuccess()) {
                    this.zzJM.zzJw.zzJs.zzb(this.zzJL, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzJw = remoteMediaPlayer;
        }

        public void zza(String str, String str2, long j, String str3) {
            if (this.zzJJ == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzJJ, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzJJ = googleApiClient;
        }

        public long zzhk() {
            long j = this.zzJK + 1;
            this.zzJK = j;
            return j;
        }
    }

    final class zzc implements MediaChannelResult {
        private final Status zzHb;
        private final JSONObject zzIX;

        zzc(Status status, JSONObject jSONObject) {
            this.zzHb = status;
            this.zzIX = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzIX;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public RemoteMediaPlayer() {
        this.zzJs.zza(this.zzJt);
    }

    private void onMetadataUpdated() {
        if (this.zzJu != null) {
            this.zzJu.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzJv != null) {
            this.zzJv.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zznh) {
            approximateStreamPosition = this.zzJs.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zznh) {
            mediaInfo = this.zzJs.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zznh) {
            mediaStatus = this.zzJs.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzJs.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zznh) {
            streamDuration = this.zzJs.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z2 = z;
        final long j2 = j;
        final long[] jArr2 = jArr;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient2);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, mediaInfo2, z2, j2, jArr2, jSONObject2);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzJs.zzaI(str2);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zzc(this.zzJN, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final long j2 = j;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient2);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, j2, i2, jSONObject2);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient googleApiClient, final long[] jArr) {
        if (jArr != null) {
            return googleApiClient.zzb(new zzb(this, googleApiClient) {
                final /* synthetic */ RemoteMediaPlayer zzJw;

                protected void zza(zzju com_google_android_gms_internal_zzju) {
                    synchronized (this.zzJw.zznh) {
                        this.zzJw.zzJt.zzb(googleApiClient);
                        try {
                            this.zzJw.zzJs.zza(this.zzJN, jArr);
                            this.zzJw.zzJt.zzb(null);
                        } catch (IOException e) {
                            setResult(zzj(new Status(2100)));
                            this.zzJw.zzJt.zzb(null);
                        } catch (Throwable th) {
                            this.zzJw.zzJt.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzJu = onMetadataUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzJv = onStatusUpdatedListener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final boolean z2 = z;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient2);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, z2, jSONObject2);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IllegalStateException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e2) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d) {
        return setStreamVolume(googleApiClient, d, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final double d2 = d;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient2);
                    try {
                        this.zzJw.zzJs.zza(this.zzJN, d2, jSONObject2);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IllegalStateException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (IllegalArgumentException e2) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e3) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient googleApiClient, final TextTrackStyle textTrackStyle) {
        if (textTrackStyle != null) {
            return googleApiClient.zzb(new zzb(this, googleApiClient) {
                final /* synthetic */ RemoteMediaPlayer zzJw;

                protected void zza(zzju com_google_android_gms_internal_zzju) {
                    synchronized (this.zzJw.zznh) {
                        this.zzJw.zzJt.zzb(googleApiClient);
                        try {
                            this.zzJw.zzJs.zza(this.zzJN, textTrackStyle);
                            this.zzJw.zzJt.zzb(null);
                        } catch (IOException e) {
                            setResult(zzj(new Status(2100)));
                            this.zzJw.zzJt.zzb(null);
                        } catch (Throwable th) {
                            this.zzJw.zzJt.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ RemoteMediaPlayer zzJw;

            protected void zza(zzju com_google_android_gms_internal_zzju) {
                synchronized (this.zzJw.zznh) {
                    this.zzJw.zzJt.zzb(googleApiClient);
                    try {
                        this.zzJw.zzJs.zzb(this.zzJN, jSONObject);
                        this.zzJw.zzJt.zzb(null);
                    } catch (IOException e) {
                        setResult(zzj(new Status(2100)));
                        this.zzJw.zzJt.zzb(null);
                    } catch (Throwable th) {
                        this.zzJw.zzJt.zzb(null);
                    }
                }
            }
        });
    }
}
