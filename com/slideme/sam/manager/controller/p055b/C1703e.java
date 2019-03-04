package com.slideme.sam.manager.controller.p055b;

import android.text.TextUtils;
import com.slideme.sam.manager.net.response.AdProxyItem;
import org.json.JSONObject;

/* compiled from: AdProxyUtils */
public class C1703e {
    public static AdProxyItem m5067a(JSONObject jSONObject) {
        double d = 0.0d;
        AdProxyItem adProxyItem = new AdProxyItem();
        adProxyItem.clickUrl = jSONObject.isNull(AdProxyItem.JSON_FIELD_CLICKURL) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_CLICKURL);
        adProxyItem.description = jSONObject.isNull(AdProxyItem.JSON_FIELD_DESCRIPTION) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_DESCRIPTION);
        adProxyItem.image = jSONObject.isNull(AdProxyItem.JSON_FIELD_IMAGE) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_IMAGE);
        adProxyItem.name = jSONObject.isNull(AdProxyItem.JSON_FIELD_NAME) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_NAME);
        adProxyItem.packageName = jSONObject.isNull(AdProxyItem.JSON_FIELD_PACKAGENAME) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_PACKAGENAME);
        adProxyItem.samAvailable = jSONObject.isNull(AdProxyItem.JSON_FIELD_SAMAVAILABLE) ? false : jSONObject.getBoolean(AdProxyItem.JSON_FIELD_SAMAVAILABLE);
        adProxyItem.payout = jSONObject.isNull(AdProxyItem.JSON_FIELD_PAYOUT) ? 0.0d : jSONObject.getDouble(AdProxyItem.JSON_FIELD_PAYOUT);
        adProxyItem.offerId = jSONObject.isNull(AdProxyItem.JSON_FIELD_OFFER_ID) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_OFFER_ID);
        adProxyItem.platform = jSONObject.isNull(AdProxyItem.JSON_FIELD_PLATFORM) ? "" : jSONObject.getString(AdProxyItem.JSON_FIELD_PLATFORM);
        adProxyItem.network = jSONObject.isNull(AdProxyItem.JSON_FIELD_NETWORK) ? null : jSONObject.getString(AdProxyItem.JSON_FIELD_NETWORK);
        if (!jSONObject.isNull(AdProxyItem.JSON_FIELD_RATING)) {
            d = jSONObject.getDouble(AdProxyItem.JSON_FIELD_RATING);
        }
        adProxyItem.rating = d;
        return adProxyItem;
    }

    public static boolean m5068a(String str) {
        return !TextUtils.isEmpty(str) && str.contains("reward");
    }

    public static boolean m5069b(String str) {
        return !TextUtils.isEmpty(str) && str.contains("shareandearn");
    }
}
