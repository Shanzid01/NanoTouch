package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzy.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    public class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzED = new HashMap();
        ProductAction zzEE;
        Map<String, List<Product>> zzEF = new HashMap();
        List<Promotion> zzEG = new ArrayList();
        List<Product> zzEH = new ArrayList();

        protected HitBuilder() {
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzae.zzac("product should be non-null");
            } else {
                Object obj;
                if (str == null) {
                    obj = "";
                }
                if (!this.zzEF.containsKey(obj)) {
                    this.zzEF.put(obj, new ArrayList());
                }
                ((List) this.zzEF.get(obj)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzae.zzac("product should be non-null");
            } else {
                this.zzEH.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzac("promotion should be non-null");
            } else {
                this.zzEG.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzED);
            if (this.zzEE != null) {
                hashMap.putAll(this.zzEE.build());
            }
            int i = 1;
            for (Promotion zzaw : this.zzEG) {
                hashMap.putAll(zzaw.zzaw(zzs.zzH(i)));
                i++;
            }
            i = 1;
            for (Product zzaw2 : this.zzEH) {
                hashMap.putAll(zzaw2.zzaw(zzs.zzG(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.zzEF.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzJ = zzs.zzJ(i2);
                int i3 = 1;
                for (Product zzaw3 : list) {
                    hashMap.putAll(zzaw3.zzaw(zzJ + zzs.zzI(i3)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    hashMap.put(zzJ + "nm", entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return (String) this.zzED.get(str);
        }

        public final T set(String str, String str2) {
            zzy.zzfV().zza(zza.MAP_BUILDER_SET);
            if (str != null) {
                this.zzED.put(str, str2);
            } else {
                zzae.zzac(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            zzy.zzfV().zza(zza.MAP_BUILDER_SET_ALL);
            if (map != null) {
                this.zzED.putAll(new HashMap(map));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            zzy.zzfV().zza(zza.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object zzau = zzan.zzau(str);
            if (!TextUtils.isEmpty(zzau)) {
                Map zzat = zzan.zzat(zzau);
                set("&cc", (String) zzat.get("utm_content"));
                set("&cm", (String) zzat.get("utm_medium"));
                set("&cn", (String) zzat.get("utm_campaign"));
                set("&cs", (String) zzat.get("utm_source"));
                set("&ck", (String) zzat.get("utm_term"));
                set("&ci", (String) zzat.get("utm_id"));
                set("&gclid", (String) zzat.get("gclid"));
                set("&dclid", (String) zzat.get("dclid"));
                set("&gmob_t", (String) zzat.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzs.zzE(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzs.zzF(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zzan.zzG(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzEE = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zzED.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_EVENT);
            set("&t", "event");
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzan.zzG(z));
            return this;
        }
    }

    @Deprecated
    public class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_APP_VIEW);
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_SOCIAL);
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            zzy.zzfV().zza(zza.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
