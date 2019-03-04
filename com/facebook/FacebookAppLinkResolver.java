package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.Request.Callback;
import com.facebook.model.GraphObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C0003d;
import p000a.C0004e;
import p000a.C0009j;
import p000a.C0010k;
import p000a.C0018s;

public class FacebookAppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, C0003d> cachedAppLinks = new HashMap();

    public C0010k<C0003d> getAppLinkFromUrlInBackground(final Uri uri) {
        List arrayList = new ArrayList();
        arrayList.add(uri);
        return getAppLinkFromUrlsInBackground(arrayList).m27b(new C0009j<Map<Uri, C0003d>, C0003d>() {
            public C0003d then(C0010k<Map<Uri, C0003d>> c0010k) {
                return (C0003d) ((Map) c0010k.m33e()).get(uri);
            }
        });
    }

    public C0010k<Map<Uri, C0003d>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        final Object hashMap = new HashMap();
        final HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Uri uri : list) {
            synchronized (this.cachedAppLinks) {
                C0003d c0003d = (C0003d) this.cachedAppLinks.get(uri);
            }
            if (c0003d != null) {
                hashMap.put(uri, c0003d);
            } else {
                if (!hashSet.isEmpty()) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(uri.toString());
                hashSet.add(uri);
            }
        }
        if (hashSet.isEmpty()) {
            return C0010k.m10a(hashMap);
        }
        final C0018s a = C0010k.m11a();
        Bundle bundle = new Bundle();
        bundle.putString("ids", stringBuilder.toString());
        bundle.putString("fields", String.format("%s.fields(%s,%s)", new Object[]{APP_LINK_KEY, APP_LINK_ANDROID_TARGET_KEY, APP_LINK_WEB_TARGET_KEY}));
        new Request(null, "", bundle, null, new Callback() {
            public void onCompleted(Response response) {
                FacebookRequestError error = response.getError();
                if (error != null) {
                    a.m43b(error.getException());
                    return;
                }
                GraphObject graphObject = response.getGraphObject();
                JSONObject innerJSONObject = graphObject != null ? graphObject.getInnerJSONObject() : null;
                if (innerJSONObject == null) {
                    a.m44b(hashMap);
                    return;
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (innerJSONObject.has(uri.toString())) {
                        try {
                            JSONObject jSONObject = innerJSONObject.getJSONObject(uri.toString()).getJSONObject(FacebookAppLinkResolver.APP_LINK_KEY);
                            JSONArray jSONArray = jSONObject.getJSONArray(FacebookAppLinkResolver.APP_LINK_ANDROID_TARGET_KEY);
                            int length = jSONArray.length();
                            List arrayList = new ArrayList(length);
                            for (int i = 0; i < length; i++) {
                                C0004e access$0 = FacebookAppLinkResolver.getAndroidTargetFromJson(jSONArray.getJSONObject(i));
                                if (access$0 != null) {
                                    arrayList.add(access$0);
                                }
                            }
                            C0003d c0003d = new C0003d(uri, arrayList, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jSONObject));
                            hashMap.put(uri, c0003d);
                            synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
                                FacebookAppLinkResolver.this.cachedAppLinks.put(uri, c0003d);
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
                a.m44b(hashMap);
            }
        }).executeAsync();
        return a.m40a();
    }

    private static C0004e getAndroidTargetFromJson(JSONObject jSONObject) {
        Uri uri = null;
        String tryGetStringFromJson = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_PACKAGE_KEY, null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_CLASS_KEY, null);
        String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, "app_name", null);
        String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, "url", null);
        if (tryGetStringFromJson4 != null) {
            uri = Uri.parse(tryGetStringFromJson4);
        }
        return new C0004e(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        Uri uri2 = null;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(APP_LINK_WEB_TARGET_KEY);
            if (!tryGetBooleanFromJson(jSONObject2, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, "url", null);
            if (tryGetStringFromJson != null) {
                uri2 = Uri.parse(tryGetStringFromJson);
            }
            if (uri2 != null) {
                return uri2;
            }
            return uri;
        } catch (JSONException e) {
            return uri;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e) {
        }
        return str2;
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        try {
            z = jSONObject.getBoolean(str);
        } catch (JSONException e) {
        }
        return z;
    }
}
