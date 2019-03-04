package com.slideme.sam.manager.util.cache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.p043a.C0743k;
import com.google.p043a.C0751r;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1922m;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class PreferenceCache {
    private static final String PREFERENCES_NAME = "cache_preferences";
    private static C0743k mGson;
    private Context mContext;

    public PreferenceCache(Context context) {
        this.mContext = context;
        mGson = new C0751r().m3700a();
    }

    public void put(CacheItem cacheItem) {
        Editor edit = this.mContext.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        try {
            edit.putString(C1913d.m5758a(cacheItem.key), mGson.m3678a((Object) cacheItem));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        edit.commit();
    }

    public CacheItem fetch(String str) {
        try {
            String a = C1913d.m5758a(str);
            String string = this.mContext.getSharedPreferences(PREFERENCES_NAME, 0).getString(a, null);
            if (!TextUtils.isEmpty(string)) {
                CacheItem cacheItem = (CacheItem) mGson.m3675a(string, CacheItem.class);
                if (!cacheItem.isExpired()) {
                    return cacheItem;
                }
                this.mContext.getSharedPreferences(PREFERENCES_NAME, 0).edit().remove(a).commit();
                return null;
            }
        } catch (Exception e) {
            C1922m.m5790a(e);
        }
        return null;
    }

    public <T> T extractPayload(CacheItem cacheItem, Class<T> cls) {
        return mGson.m3675a(cacheItem.payload, (Class) cls);
    }
}
