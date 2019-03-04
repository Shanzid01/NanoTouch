package com.google.android.gms.cast;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzHf;
    private String zzIO;
    private String zzIQ;
    private String zzIS;
    private JSONObject zzIX;
    private int zzJp;
    private int zzJq;

    public class Builder {
        private final MediaTrack zzJr;

        public Builder(long j, int i) {
            this.zzJr = new MediaTrack(j, i);
        }

        public MediaTrack build() {
            return this.zzJr;
        }

        public Builder setContentId(String str) {
            this.zzJr.setContentId(str);
            return this;
        }

        public Builder setContentType(String str) {
            this.zzJr.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzJr.setCustomData(jSONObject);
            return this;
        }

        public Builder setLanguage(String str) {
            this.zzJr.setLanguage(str);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzJr.setLanguage(zzjv.zzb(locale));
            return this;
        }

        public Builder setName(String str) {
            this.zzJr.setName(str);
            return this;
        }

        public Builder setSubtype(int i) {
            this.zzJr.zzaf(i);
            return this;
        }
    }

    MediaTrack(long j, int i) {
        clear();
        this.zzHf = j;
        if (i <= 0 || i > 3) {
            throw new IllegalArgumentException("invalid type " + i);
        }
        this.zzJp = i;
    }

    MediaTrack(JSONObject jSONObject) {
        zzd(jSONObject);
    }

    private void clear() {
        this.zzHf = 0;
        this.zzJp = 0;
        this.zzIQ = null;
        this.mName = null;
        this.zzIO = null;
        this.zzJq = -1;
        this.zzIX = null;
    }

    private void zzd(JSONObject jSONObject) {
        clear();
        this.zzHf = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzJp = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzJp = 2;
        } else if (NativeProtocol.METHOD_ARGS_VIDEO.equals(string)) {
            this.zzJp = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.zzIQ = jSONObject.optString("trackContentId", null);
        this.zzIS = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzIO = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.zzJq = 1;
            } else if ("CAPTIONS".equals(string)) {
                this.zzJq = 2;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.zzJq = 3;
            } else if ("CHAPTERS".equals(string)) {
                this.zzJq = 4;
            } else if ("METADATA".equals(string)) {
                this.zzJq = 5;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.zzJq = 0;
        this.zzIX = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        if ((this.zzIX == null) != (mediaTrack.zzIX == null)) {
            return false;
        }
        if (this.zzIX != null && mediaTrack.zzIX != null && !zzma.zzd(this.zzIX, mediaTrack.zzIX)) {
            return false;
        }
        if (!(this.zzHf == mediaTrack.zzHf && this.zzJp == mediaTrack.zzJp && zzjv.zza(this.zzIQ, mediaTrack.zzIQ) && zzjv.zza(this.zzIS, mediaTrack.zzIS) && zzjv.zza(this.mName, mediaTrack.mName) && zzjv.zza(this.zzIO, mediaTrack.zzIO) && this.zzJq == mediaTrack.zzJq)) {
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

    public long getId() {
        return this.zzHf;
    }

    public String getLanguage() {
        return this.zzIO;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzJq;
    }

    public int getType() {
        return this.zzJp;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzHf), Integer.valueOf(this.zzJp), this.zzIQ, this.zzIS, this.mName, this.zzIO, Integer.valueOf(this.zzJq), this.zzIX);
    }

    public void setContentId(String str) {
        this.zzIQ = str;
    }

    public void setContentType(String str) {
        this.zzIS = str;
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzIX = jSONObject;
    }

    void setLanguage(String str) {
        this.zzIO = str;
    }

    void setName(String str) {
        this.mName = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzHf);
            switch (this.zzJp) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", NativeProtocol.METHOD_ARGS_VIDEO);
                    break;
            }
            if (this.zzIQ != null) {
                jSONObject.put("trackContentId", this.zzIQ);
            }
            if (this.zzIS != null) {
                jSONObject.put("trackContentType", this.zzIS);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzIO)) {
                jSONObject.put("language", this.zzIO);
            }
            switch (this.zzJq) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzIX != null) {
                jSONObject.put("customData", this.zzIX);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzaf(int i) {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.zzJp == 1) {
            this.zzJq = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }
}
