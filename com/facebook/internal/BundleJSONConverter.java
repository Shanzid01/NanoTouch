package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    class C05731 implements Setter {
        C05731() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    class C05742 implements Setter {
        C05742() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    class C05753 implements Setter {
        C05753() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putLong(str, ((Long) obj).longValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    class C05764 implements Setter {
        C05764() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    class C05775 implements Setter {
        C05775() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            bundle.putString(str, (String) obj);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            jSONObject.put(str, obj);
        }
    }

    class C05786 implements Setter {
        C05786() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            throw new IllegalArgumentException("Unexpected type from JSON");
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            JSONArray jSONArray = new JSONArray();
            for (Object put : (String[]) obj) {
                jSONArray.put(put);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    class C05797 implements Setter {
        C05797() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof String) {
                    arrayList.add((String) obj2);
                    i++;
                } else {
                    throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    static {
        SETTERS.put(Boolean.class, new C05731());
        SETTERS.put(Integer.class, new C05742());
        SETTERS.put(Long.class, new C05753());
        SETTERS.put(Double.class, new C05764());
        SETTERS.put(String.class, new C05775());
        SETTERS.put(String[].class, new C05786());
        SETTERS.put(JSONArray.class, new C05797());
    }

    public static JSONObject convertToJSON(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.setOnJSON(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(str, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.setOnBundle(bundle, str, obj);
                }
            }
        }
        return bundle;
    }
}
