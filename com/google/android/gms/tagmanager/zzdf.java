package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.AppEventsConstants;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzdf extends zzdc {
    private static final String ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final String zzaBA = zzb.TRACK_TRANSACTION.toString();
    private static final String zzaBB = zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String zzaBC = zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> zzaBD = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
    private static final Pattern zzaBE = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzaBF = Pattern.compile("metric(\\d+)");
    private static Map<String, String> zzaBG;
    private static Map<String, String> zzaBH;
    private static final String zzaBu = zzb.ACCOUNT.toString();
    private static final String zzaBv = zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String zzaBw = zzb.ENABLE_ECOMMERCE.toString();
    private static final String zzaBx = zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String zzaBy = zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String zzaBz = zzb.ANALYTICS_FIELDS.toString();
    private final Set<String> zzaBI;
    private final zzdb zzaBJ;
    private final DataLayer zzaxx;

    public zzdf(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzdb(context));
    }

    zzdf(Context context, DataLayer dataLayer, zzdb com_google_android_gms_tagmanager_zzdb) {
        super(ID, new String[0]);
        this.zzaxx = dataLayer;
        this.zzaBJ = com_google_android_gms_tagmanager_zzdb;
        this.zzaBI = new HashSet();
        this.zzaBI.add("");
        this.zzaBI.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zzaBI.add("false");
    }

    private Double zzB(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Double: " + e.getMessage());
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            throw new RuntimeException("Cannot convert the object to Double: " + obj.toString());
        }
    }

    private Integer zzC(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Integer: " + e.getMessage());
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            throw new RuntimeException("Cannot convert the object to Integer: " + obj.toString());
        }
    }

    private Promotion zzR(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = (String) map.get("id");
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        str = (String) map.get("name");
        if (str != null) {
            promotion.setName(String.valueOf(str));
        }
        str = (String) map.get("creative");
        if (str != null) {
            promotion.setCreative(String.valueOf(str));
        }
        str = (String) map.get("position");
        if (str != null) {
            promotion.setPosition(String.valueOf(str));
        }
        return promotion;
    }

    private Product zzS(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null) {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null) {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null) {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null) {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null) {
            product.setPosition(zzC(obj).intValue());
        }
        obj = map.get("price");
        if (obj != null) {
            product.setPrice(zzB(obj).doubleValue());
        }
        obj = map.get("quantity");
        if (obj != null) {
            product.setQuantity(zzC(obj).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = zzaBE.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException e) {
                    zzbf.zzac("illegal number in custom dimension value: " + str);
                }
            } else {
                matcher = zzaBF.matcher(str);
                if (matcher.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher.group(1)), zzC(map.get(str)).intValue());
                    } catch (NumberFormatException e2) {
                        zzbf.zzac("illegal number in custom metric value: " + str);
                    }
                }
            }
        }
        return product;
    }

    private Map<String, String> zzT(Map<String, zzd.zza> map) {
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzaBB);
        if (com_google_android_gms_internal_zzd_zza != null) {
            return zzc(com_google_android_gms_internal_zzd_zza);
        }
        if (zzaBG == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            zzaBG = hashMap;
        }
        return zzaBG;
    }

    private Map<String, String> zzU(Map<String, zzd.zza> map) {
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzaBC);
        if (com_google_android_gms_internal_zzd_zza != null) {
            return zzc(com_google_android_gms_internal_zzd_zza);
        }
        if (zzaBH == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            zzaBH = hashMap;
        }
        return zzaBH;
    }

    private void zza(Tracker tracker, Map<String, zzd.zza> map) {
        String zzdt = zzdt("transactionId");
        if (zzdt == null) {
            zzbf.zzZ("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map zzm = zzm((zzd.zza) map.get(zzaBz));
            zzm.put("&t", "transaction");
            for (Entry entry : zzT(map).entrySet()) {
                zzb(zzm, (String) entry.getValue(), zzdt((String) entry.getKey()));
            }
            linkedList.add(zzm);
            List<Map> zzdu = zzdu("transactionProducts");
            if (zzdu != null) {
                for (Map map2 : zzdu) {
                    if (map2.get("name") == null) {
                        zzbf.zzZ("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map zzm2 = zzm((zzd.zza) map.get(zzaBz));
                    zzm2.put("&t", "item");
                    zzm2.put("&ti", zzdt);
                    for (Entry entry2 : zzU(map).entrySet()) {
                        zzb(zzm2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(zzm2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            zzbf.zzb("Unable to send transaction", e);
        }
    }

    private void zzb(Tracker tracker, Map<String, zzd.zza> map) {
        Object obj;
        Map map2;
        ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
        Map zzm = zzm((zzd.zza) map.get(zzaBz));
        screenViewBuilder.setAll(zzm);
        if (zzf(map, zzaBx)) {
            obj = this.zzaxx.get("ecommerce");
            map2 = obj instanceof Map ? (Map) obj : null;
        } else {
            obj = zzde.zzl((zzd.zza) map.get(zzaBy));
            map2 = obj instanceof Map ? (Map) obj : null;
        }
        if (map2 != null) {
            Map map3;
            List<Map> list;
            String str = (String) zzm.get("&cu");
            if (str == null) {
                str = (String) map2.get("currencyCode");
            }
            if (str != null) {
                screenViewBuilder.set("&cu", str);
            }
            obj = map2.get("impressions");
            if (obj instanceof List) {
                for (Map map4 : (List) obj) {
                    try {
                        screenViewBuilder.addImpression(zzS(map4), (String) map4.get("list"));
                    } catch (RuntimeException e) {
                        zzbf.zzZ("Failed to extract a product from DataLayer. " + e.getMessage());
                    }
                }
            }
            List list2 = map2.containsKey("promoClick") ? (List) ((Map) map2.get("promoClick")).get("promotions") : map2.containsKey("promoView") ? (List) ((Map) map2.get("promoView")).get("promotions") : null;
            if (r0 != null) {
                for (Map map42 : r0) {
                    try {
                        screenViewBuilder.addPromotion(zzR(map42));
                    } catch (RuntimeException e2) {
                        zzbf.zzZ("Failed to extract a promotion from DataLayer. " + e2.getMessage());
                    }
                }
                if (map2.containsKey("promoClick")) {
                    screenViewBuilder.set("&promoa", "click");
                    obj = null;
                    if (obj != null) {
                        for (String str2 : zzaBD) {
                            if (map2.containsKey(str2)) {
                                map3 = (Map) map2.get(str2);
                                list = (List) map3.get("products");
                                if (list != null) {
                                    for (Map map22 : list) {
                                        try {
                                            screenViewBuilder.addProduct(zzS(map22));
                                        } catch (RuntimeException e3) {
                                            zzbf.zzZ("Failed to extract a product from DataLayer. " + e3.getMessage());
                                        }
                                    }
                                }
                                try {
                                    screenViewBuilder.setProductAction(map3.containsKey("actionField") ? zzd(str2, (Map) map3.get("actionField")) : new ProductAction(str2));
                                } catch (RuntimeException e22) {
                                    zzbf.zzZ("Failed to extract a product action from DataLayer. " + e22.getMessage());
                                }
                            }
                        }
                    }
                } else {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                }
            }
            int i = 1;
            if (obj != null) {
                for (String str22 : zzaBD) {
                    if (map22.containsKey(str22)) {
                        map3 = (Map) map22.get(str22);
                        list = (List) map3.get("products");
                        if (list != null) {
                            while (r4.hasNext()) {
                                screenViewBuilder.addProduct(zzS(map22));
                            }
                        }
                        if (map3.containsKey("actionField")) {
                        }
                        screenViewBuilder.setProductAction(map3.containsKey("actionField") ? zzd(str22, (Map) map3.get("actionField")) : new ProductAction(str22));
                    }
                }
            }
        }
        tracker.send(screenViewBuilder.build());
    }

    private void zzb(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private Map<String, String> zzc(zzd.zza com_google_android_gms_internal_zzd_zza) {
        Object zzl = zzde.zzl(com_google_android_gms_internal_zzd_zza);
        if (!(zzl instanceof Map)) {
            return null;
        }
        Map map = (Map) zzl;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private ProductAction zzd(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get("id");
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null) {
            productAction.setProductActionList(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null) {
            productAction.setCheckoutOptions(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null) {
            productAction.setTransactionRevenue(zzB(obj).doubleValue());
        }
        obj = map.get("tax");
        if (obj != null) {
            productAction.setTransactionTax(zzB(obj).doubleValue());
        }
        obj = map.get("shipping");
        if (obj != null) {
            productAction.setTransactionShipping(zzB(obj).doubleValue());
        }
        obj = map.get("step");
        if (obj != null) {
            productAction.setCheckoutStep(zzC(obj).intValue());
        }
        return productAction;
    }

    private String zzdt(String str) {
        Object obj = this.zzaxx.get(str);
        return obj == null ? null : obj.toString();
    }

    private List<Map<String, String>> zzdu(String str) {
        Object obj = this.zzaxx.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private boolean zzf(Map<String, zzd.zza> map, String str) {
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(str);
        return com_google_android_gms_internal_zzd_zza == null ? false : zzde.zzk(com_google_android_gms_internal_zzd_zza).booleanValue();
    }

    private Map<String, String> zzm(zzd.zza com_google_android_gms_internal_zzd_zza) {
        if (com_google_android_gms_internal_zzd_zza == null) {
            return new HashMap();
        }
        Map<String, String> zzc = zzc(com_google_android_gms_internal_zzd_zza);
        if (zzc == null) {
            return new HashMap();
        }
        String str = (String) zzc.get("&aip");
        if (str != null && this.zzaBI.contains(str.toLowerCase())) {
            zzc.remove("&aip");
        }
        return zzc;
    }

    public /* bridge */ /* synthetic */ zzd.zza zzH(Map map) {
        return super.zzH(map);
    }

    public void zzJ(Map<String, zzd.zza> map) {
        Tracker zzdl = this.zzaBJ.zzdl("_GTM_DEFAULT_TRACKER_");
        zzdl.enableAdvertisingIdCollection(zzf(map, "collect_adid"));
        if (zzf(map, zzaBw)) {
            zzb(zzdl, map);
        } else if (zzf(map, zzaBv)) {
            zzdl.send(zzm((zzd.zza) map.get(zzaBz)));
        } else if (zzf(map, zzaBA)) {
            zza(zzdl, map);
        } else {
            zzbf.zzac("Ignoring unknown tag.");
        }
    }

    public /* bridge */ /* synthetic */ boolean zzsD() {
        return super.zzsD();
    }

    public /* bridge */ /* synthetic */ String zzth() {
        return super.zzth();
    }

    public /* bridge */ /* synthetic */ Set zzti() {
        return super.zzti();
    }
}
