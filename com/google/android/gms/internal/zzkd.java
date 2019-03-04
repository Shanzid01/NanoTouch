package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzkd extends zzjs {
    private static final String NAMESPACE = zzjv.zzaL("com.google.cast.media");
    private long zzKV;
    private MediaStatus zzKW;
    private final List<zzkg> zzKX = new ArrayList();
    private final zzkg zzKY = new zzkg(86400000);
    private final zzkg zzKZ = new zzkg(86400000);
    private final zzkg zzLa = new zzkg(86400000);
    private final zzkg zzLb = new zzkg(86400000);
    private final zzkg zzLc = new zzkg(86400000);
    private final zzkg zzLd = new zzkg(86400000);
    private final zzkg zzLe = new zzkg(86400000);
    private final zzkg zzLf = new zzkg(86400000);
    private final zzkg zzLg = new zzkg(86400000);
    private final zzkg zzLh = new zzkg(86400000);

    public zzkd(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000);
        this.zzKX.add(this.zzKY);
        this.zzKX.add(this.zzKZ);
        this.zzKX.add(this.zzLa);
        this.zzKX.add(this.zzLb);
        this.zzKX.add(this.zzLc);
        this.zzKX.add(this.zzLd);
        this.zzKX.add(this.zzLe);
        this.zzKX.add(this.zzLf);
        this.zzKX.add(this.zzLg);
        this.zzKX.add(this.zzLh);
    }

    private void zza(long j, JSONObject jSONObject) {
        int i = 1;
        boolean zzq = this.zzKY.zzq(j);
        int i2 = (!this.zzLc.zzhI() || this.zzLc.zzq(j)) ? 0 : 1;
        if ((!this.zzLd.zzhI() || this.zzLd.zzq(j)) && (!this.zzLe.zzhI() || this.zzLe.zzq(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (zzq || this.zzKW == null) {
            this.zzKW = new MediaStatus(jSONObject);
            this.zzKV = SystemClock.elapsedRealtime();
            i2 = 7;
        } else {
            i2 = this.zzKW.zza(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.zzKV = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.zzKV = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        for (zzkg zzc : this.zzKX) {
            zzc.zzc(j, 0);
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzKV == 0) {
            return 0;
        }
        double playbackRate = this.zzKW.getPlaybackRate();
        long streamPosition = this.zzKW.getStreamPosition();
        int playerState = this.zzKW.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzKV;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (elapsedRealtime <= 0 || streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.zzKW == null ? null : this.zzKW.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzKW;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf) {
        JSONObject jSONObject = new JSONObject();
        long zzhn = zzhn();
        this.zzLf.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject.put("requestId", zzhn);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzKW != null) {
                jSONObject.put("mediaSessionId", this.zzKW.zzhj());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, double d, JSONObject jSONObject) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzLd.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzhj());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, long j, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzLc.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", zzhj());
            jSONObject2.put("currentTime", zzjv.zzp(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzKY.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzjv.zzp(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, TextTrackStyle textTrackStyle) {
        JSONObject jSONObject = new JSONObject();
        long zzhn = zzhn();
        this.zzLh.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject.put("requestId", zzhn);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zzhj());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzKZ.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzhj());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, boolean z, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzLe.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzhj());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public long zza(zzkf com_google_android_gms_internal_zzkf, long[] jArr) {
        JSONObject jSONObject = new JSONObject();
        long zzhn = zzhn();
        this.zzLg.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject.put("requestId", zzhn);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzhj());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzhn, null);
        return zzhn;
    }

    public final void zzaI(String str) {
        this.zzKe.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    zza(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzKW = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.zzLf.zzc(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzKe.zzd("received unexpected error: Invalid Player State.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzkg zzb : this.zzKX) {
                    zzb.zzb(optLong, 2100, r1);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.zzKY.zzb(optLong, 2100, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zzKY.zzb(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.zzKe.zzd("received unexpected error: Invalid Request.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzkg zzb2 : this.zzKX) {
                    zzb2.zzb(optLong, 2100, r1);
                }
            }
        } catch (JSONException e) {
            this.zzKe.zzd("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zzb(zzkf com_google_android_gms_internal_zzkf, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzLb.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzhj());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public void zzb(long j, int i) {
        for (zzkg zzc : this.zzKX) {
            zzc.zzc(j, i);
        }
    }

    public long zzc(zzkf com_google_android_gms_internal_zzkf, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzhn = zzhn();
        this.zzLa.zza(zzhn, com_google_android_gms_internal_zzkf);
        zzK(true);
        try {
            jSONObject2.put("requestId", zzhn);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzhj());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzhn, null);
        return zzhn;
    }

    public long zzhj() {
        if (this.zzKW != null) {
            return this.zzKW.zzhj();
        }
        throw new IllegalStateException("No current media session");
    }

    protected boolean zzo(long j) {
        boolean z;
        for (zzkg zzd : this.zzKX) {
            zzd.zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzkg.zzLm) {
            for (zzkg zzd2 : this.zzKX) {
                if (zzd2.zzhI()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
