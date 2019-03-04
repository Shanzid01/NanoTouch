package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] zzIZ = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
    private static final zza zzJa = new zza().zzb(KEY_CREATION_DATE, "creationDateTime", 4).zzb(KEY_RELEASE_DATE, "releaseDate", 4).zzb(KEY_BROADCAST_DATE, "originalAirdate", 4).zzb(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).zzb(KEY_SUBTITLE, "subtitle", 1).zzb(KEY_ARTIST, "artist", 1).zzb(KEY_ALBUM_ARTIST, "albumArtist", 1).zzb(KEY_ALBUM_TITLE, "albumName", 1).zzb(KEY_COMPOSER, "composer", 1).zzb(KEY_DISC_NUMBER, "discNumber", 2).zzb(KEY_TRACK_NUMBER, "trackNumber", 2).zzb(KEY_SEASON_NUMBER, "season", 2).zzb(KEY_EPISODE_NUMBER, "episode", 2).zzb(KEY_SERIES_TITLE, "seriesTitle", 1).zzb(KEY_STUDIO, "studio", 1).zzb(KEY_WIDTH, "width", 2).zzb(KEY_HEIGHT, "height", 2).zzb(KEY_LOCATION_NAME, "location", 1).zzb(KEY_LOCATION_LATITUDE, "latitude", 3).zzb(KEY_LOCATION_LONGITUDE, "longitude", 3);
    private final List<WebImage> zzIn;
    private final Bundle zzJb;
    private int zzJc;

    class zza {
        private final Map<String, String> zzJd = new HashMap();
        private final Map<String, String> zzJe = new HashMap();
        private final Map<String, Integer> zzJf = new HashMap();

        public String zzaE(String str) {
            return (String) this.zzJd.get(str);
        }

        public String zzaF(String str) {
            return (String) this.zzJe.get(str);
        }

        public int zzaG(String str) {
            Integer num = (Integer) this.zzJf.get(str);
            return num != null ? num.intValue() : 0;
        }

        public zza zzb(String str, String str2, int i) {
            this.zzJd.put(str, str2);
            this.zzJe.put(str2, str);
            this.zzJf.put(str, Integer.valueOf(i));
            return this;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int i) {
        this.zzIn = new ArrayList();
        this.zzJb = new Bundle();
        this.zzJc = i;
    }

    private void zza(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.zzJb.containsKey(str)) {
                    switch (zzJa.zzaG(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(zzJa.zzaE(str), this.zzJb.getString(str));
                            break;
                        case 2:
                            jSONObject.put(zzJa.zzaE(str), this.zzJb.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(zzJa.zzaE(str), this.zzJb.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.zzJb.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzJb.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean zza(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zza((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void zzb(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String zzaF = zzJa.zzaF(str);
                    if (zzaF == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.zzJb.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzJb.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzJb.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzaF)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (zzJa.zzaG(zzaF)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.zzJb.putString(zzaF, (String) obj2);
                                        break;
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.zzJb.putInt(zzaF, ((Integer) obj2).intValue());
                                        break;
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.zzJb.putDouble(zzaF, ((Double) obj2).doubleValue());
                                        break;
                                    case 4:
                                        if ((obj2 instanceof String) && zzkh.zzaQ((String) obj2) != null) {
                                            this.zzJb.putString(zzaF, (String) obj2);
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private void zzf(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzaG = zzJa.zzaG(str);
        if (zzaG != i && zzaG != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + zzIZ[i]);
        }
    }

    public void addImage(WebImage webImage) {
        this.zzIn.add(webImage);
    }

    public void clear() {
        this.zzJb.clear();
        this.zzIn.clear();
    }

    public void clearImages() {
        this.zzIn.clear();
    }

    public boolean containsKey(String str) {
        return this.zzJb.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return zza(this.zzJb, mediaMetadata.zzJb) && this.zzIn.equals(mediaMetadata.zzIn);
    }

    public Calendar getDate(String str) {
        zzf(str, 4);
        String string = this.zzJb.getString(str);
        return string != null ? zzkh.zzaQ(string) : null;
    }

    public String getDateAsString(String str) {
        zzf(str, 4);
        return this.zzJb.getString(str);
    }

    public double getDouble(String str) {
        zzf(str, 3);
        return this.zzJb.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.zzIn;
    }

    public int getInt(String str) {
        zzf(str, 2);
        return this.zzJb.getInt(str);
    }

    public int getMediaType() {
        return this.zzJc;
    }

    public String getString(String str) {
        zzf(str, 1);
        return this.zzJb.getString(str);
    }

    public boolean hasImages() {
        return (this.zzIn == null || this.zzIn.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.zzJb.keySet()) {
            i *= 31;
            i = this.zzJb.get(str).hashCode() + i;
        }
        return (i * 31) + this.zzIn.hashCode();
    }

    public Set<String> keySet() {
        return this.zzJb.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        zzf(str, 4);
        this.zzJb.putString(str, zzkh.zza(calendar));
    }

    public void putDouble(String str, double d) {
        zzf(str, 3);
        this.zzJb.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        zzf(str, 2);
        this.zzJb.putInt(str, i);
    }

    public void putString(String str, String str2) {
        zzf(str, 1);
        this.zzJb.putString(str, str2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzJc);
        } catch (JSONException e) {
        }
        zzkh.zza(jSONObject, this.zzIn);
        switch (this.zzJc) {
            case 0:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                zza(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                zza(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                zza(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public void zzd(JSONObject jSONObject) {
        clear();
        this.zzJc = 0;
        try {
            this.zzJc = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzkh.zza(this.zzIn, jSONObject);
        switch (this.zzJc) {
            case 0:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                zzb(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                zzb(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                zzb(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                zzb(jSONObject, new String[0]);
                return;
        }
    }
}
