package com.google.analytics.tracking.android;

import com.facebook.AppEventsConstants;
import com.facebook.android.Facebook;
import com.google.android.gms.plus.PlusShare;

/* compiled from: MetaModelInitializer */
class az {
    private static final ax f2018a = new ba();
    private static final ax f2019b = new bb();

    public static void m3830a(aw awVar) {
        awVar.m3825a("apiVersion", "v", null, null);
        awVar.m3825a("libraryVersion", "_v", null, null);
        awVar.m3825a("anonymizeIp", "aip", AppEventsConstants.EVENT_PARAM_VALUE_NO, f2018a);
        awVar.m3825a("trackingId", "tid", null, null);
        awVar.m3825a("hitType", "t", null, null);
        awVar.m3825a("sessionControl", "sc", null, null);
        awVar.m3825a("adSenseAdMobHitId", "a", null, null);
        awVar.m3825a("usage", "_u", null, null);
        awVar.m3825a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "dt", null, null);
        awVar.m3825a("referrer", "dr", null, null);
        awVar.m3825a("language", "ul", null, null);
        awVar.m3825a("encoding", "de", null, null);
        awVar.m3825a("page", "dp", null, null);
        awVar.m3825a("screenColors", "sd", null, null);
        awVar.m3825a("screenResolution", "sr", null, null);
        awVar.m3825a("viewportSize", "vp", null, null);
        awVar.m3825a("javaEnabled", "je", AppEventsConstants.EVENT_PARAM_VALUE_YES, f2018a);
        awVar.m3825a("flashVersion", "fl", null, null);
        awVar.m3825a("clientId", "cid", null, null);
        awVar.m3825a("campaignName", "cn", null, null);
        awVar.m3825a("campaignSource", "cs", null, null);
        awVar.m3825a("campaignMedium", "cm", null, null);
        awVar.m3825a("campaignKeyword", "ck", null, null);
        awVar.m3825a("campaignContent", "cc", null, null);
        awVar.m3825a("campaignId", "ci", null, null);
        awVar.m3825a("gclid", "gclid", null, null);
        awVar.m3825a("dclid", "dclid", null, null);
        awVar.m3825a("gmob_t", "gmob_t", null, null);
        awVar.m3825a("eventCategory", "ec", null, null);
        awVar.m3825a("eventAction", "ea", null, null);
        awVar.m3825a("eventLabel", "el", null, null);
        awVar.m3825a("eventValue", "ev", null, null);
        awVar.m3825a("nonInteraction", "ni", AppEventsConstants.EVENT_PARAM_VALUE_NO, f2018a);
        awVar.m3825a("socialNetwork", "sn", null, null);
        awVar.m3825a("socialAction", "sa", null, null);
        awVar.m3825a("socialTarget", "st", null, null);
        awVar.m3825a("appName", "an", null, null);
        awVar.m3825a("appVersion", "av", null, null);
        awVar.m3825a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "cd", null, null);
        awVar.m3825a("appId", Facebook.ATTRIBUTION_ID_COLUMN_NAME, null, null);
        awVar.m3825a("appInstallerId", "aiid", null, null);
        awVar.m3825a("transactionId", "ti", null, null);
        awVar.m3825a("transactionAffiliation", "ta", null, null);
        awVar.m3825a("transactionShipping", "ts", null, null);
        awVar.m3825a("transactionTotal", "tr", null, null);
        awVar.m3825a("transactionTax", "tt", null, null);
        awVar.m3825a("currencyCode", "cu", null, null);
        awVar.m3825a("itemPrice", "ip", null, null);
        awVar.m3825a("itemCode", "ic", null, null);
        awVar.m3825a("itemName", "in", null, null);
        awVar.m3825a("itemCategory", "iv", null, null);
        awVar.m3825a("itemQuantity", "iq", null, null);
        awVar.m3825a("exDescription", "exd", null, null);
        awVar.m3825a("exFatal", "exf", AppEventsConstants.EVENT_PARAM_VALUE_YES, f2018a);
        awVar.m3825a("timingVar", "utv", null, null);
        awVar.m3825a("timingValue", "utt", null, null);
        awVar.m3825a("timingCategory", "utc", null, null);
        awVar.m3825a("timingLabel", "utl", null, null);
        awVar.m3825a("sampleRate", "sf", "100", f2019b);
        awVar.m3825a("hitTime", "ht", null, null);
        awVar.m3825a("customDimension", "cd", null, null);
        awVar.m3825a("customMetric", "cm", null, null);
        awVar.m3825a("contentGrouping", "cg", null, null);
    }
}
