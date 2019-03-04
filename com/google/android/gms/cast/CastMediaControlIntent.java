package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.zzjv;
import java.util.Collection;
import java.util.Locale;

public final class CastMediaControlIntent {
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
    @Deprecated
    public static final String CATEGORY_CAST = "com.google.android.gms.cast.CATEGORY_CAST";
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

    private CastMediaControlIntent() {
    }

    public static String categoryForCast(String str) {
        if (str != null) {
            return zza(CATEGORY_CAST, str, null);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String categoryForCast(String str, Collection<String> collection) {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        } else if (collection != null) {
            return zza(CATEGORY_CAST, str, collection);
        } else {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
    }

    public static String categoryForCast(Collection<String> collection) {
        if (collection != null) {
            return zza(CATEGORY_CAST, null, collection);
        }
        throw new IllegalArgumentException("namespaces cannot be null");
    }

    public static String categoryForRemotePlayback() {
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", null, null);
    }

    public static String categoryForRemotePlayback(String str) {
        if (!TextUtils.isEmpty(str)) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", str, null);
        }
        throw new IllegalArgumentException("applicationId cannot be null or empty");
    }

    public static String languageTagForLocale(Locale locale) {
        return zzjv.zzb(locale);
    }

    private static String zza(String str, String str2, Collection<String> collection) {
        String toUpperCase;
        StringBuffer stringBuffer = new StringBuffer(str);
        if (str2 != null) {
            toUpperCase = str2.toUpperCase();
            if (toUpperCase.matches("[A-F0-9]+")) {
                stringBuffer.append("/").append(toUpperCase);
            } else {
                throw new IllegalArgumentException("Invalid application ID: " + str2);
            }
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            for (String toUpperCase2 : collection) {
                if (!TextUtils.isEmpty(toUpperCase2)) {
                    if (toUpperCase2.trim().equals("")) {
                    }
                }
                throw new IllegalArgumentException("Namespaces must not be null or empty");
            }
            if (str2 == null) {
                stringBuffer.append("/");
            }
            stringBuffer.append("/").append(TextUtils.join(",", collection));
        }
        return stringBuffer.toString();
    }
}
