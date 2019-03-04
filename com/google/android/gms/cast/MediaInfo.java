package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzIQ;
    private int zzIR;
    private String zzIS;
    private MediaMetadata zzIT;
    private long zzIU;
    private List<MediaTrack> zzIV;
    private TextTrackStyle zzIW;
    private JSONObject zzIX;

    public class Builder {
        private final MediaInfo zzIY;

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzIY = new MediaInfo(str);
        }

        public MediaInfo build() {
            this.zzIY.zzhi();
            return this.zzIY;
        }

        public Builder setContentType(String str) {
            this.zzIY.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzIY.setCustomData(jSONObject);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zzIY.zzg(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzIY.zza(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) {
            this.zzIY.zzm(j);
            return this;
        }

        public Builder setStreamType(int i) {
            this.zzIY.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzIY.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzIQ = str;
        this.zzIR = -1;
        this.zzIU = -1;
    }

    MediaInfo(JSONObject jSONObject) {
        int i = 0;
        this.zzIQ = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzIR = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzIR = 1;
        } else if ("LIVE".equals(string)) {
            this.zzIR = 2;
        } else {
            this.zzIR = -1;
        }
        this.zzIS = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.zzIT = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzIT.zzd(jSONObject2);
        }
        this.zzIU = -1;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.zzIU = zzjv.zzb(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.zzIV = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.zzIV.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i++;
            }
        } else {
            this.zzIV = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzd(jSONObject3);
            this.zzIW = textTrackStyle;
        } else {
            this.zzIW = null;
        }
        this.zzIX = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if ((this.zzIX == null) != (mediaInfo.zzIX == null)) {
            return false;
        }
        if (this.zzIX != null && mediaInfo.zzIX != null && !zzma.zzd(this.zzIX, mediaInfo.zzIX)) {
            return false;
        }
        if (!(zzjv.zza(this.zzIQ, mediaInfo.zzIQ) && this.zzIR == mediaInfo.zzIR && zzjv.zza(this.zzIS, mediaInfo.zzIS) && zzjv.zza(this.zzIT, mediaInfo.zzIT) && this.zzIU == mediaInfo.zzIU)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.zzIQ;
    }

    public String getContentType() {
        return this.zzIS;
    }

    public JSONObject getCustomData() {
        return this.zzIX;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzIV;
    }

    public MediaMetadata getMetadata() {
        return this.zzIT;
    }

    public long getStreamDuration() {
        return this.zzIU;
    }

    public int getStreamType() {
        return this.zzIR;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzIW;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzIQ, Integer.valueOf(this.zzIR), this.zzIS, this.zzIT, Long.valueOf(this.zzIU), String.valueOf(this.zzIX));
    }

    void setContentType(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzIS = str;
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzIX = jSONObject;
    }

    void setStreamType(int i) {
        if (i < -1 || i > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzIR = i;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzIW = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.zzIQ);
            switch (this.zzIR) {
                case 1:
                    obj = "BUFFERED";
                    break;
                case 2:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.zzIS != null) {
                jSONObject.put("contentType", this.zzIS);
            }
            if (this.zzIT != null) {
                jSONObject.put("metadata", this.zzIT.toJson());
            }
            if (this.zzIU <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzjv.zzp(this.zzIU));
            }
            if (this.zzIV != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.zzIV) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzIW != null) {
                jSONObject.put("textTrackStyle", this.zzIW.toJson());
            }
            if (this.zzIX != null) {
                jSONObject.put("customData", this.zzIX);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzIT = mediaMetadata;
    }

    void zzg(List<MediaTrack> list) {
        this.zzIV = list;
    }

    void zzhi() {
        if (TextUtils.isEmpty(this.zzIQ)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzIS)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzIR == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzm(long j) {
        if (j >= 0 || j == -1) {
            this.zzIU = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }
}
