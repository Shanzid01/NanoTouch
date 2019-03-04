package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzs;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
    Map<String, String> zzFz = new HashMap();

    void put(String str, String str2) {
        zzx.zzb((Object) str, (Object) "Name should be non-null");
        this.zzFz.put(str, str2);
    }

    public Product setBrand(String str) {
        put("br", str);
        return this;
    }

    public Product setCategory(String str) {
        put("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        put("cc", str);
        return this;
    }

    public Product setCustomDimension(int i, String str) {
        put(zzs.zzK(i), str);
        return this;
    }

    public Product setCustomMetric(int i, int i2) {
        put(zzs.zzL(i), Integer.toString(i2));
        return this;
    }

    public Product setId(String str) {
        put("id", str);
        return this;
    }

    public Product setName(String str) {
        put("nm", str);
        return this;
    }

    public Product setPosition(int i) {
        put("ps", Integer.toString(i));
        return this;
    }

    public Product setPrice(double d) {
        put("pr", Double.toString(d));
        return this;
    }

    public Product setQuantity(int i) {
        put("qt", Integer.toString(i));
        return this;
    }

    public Product setVariant(String str) {
        put("va", str);
        return this;
    }

    public Map<String, String> zzaw(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.zzFz.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }
}
