package com.mopub.common.p050b;

/* compiled from: ResponseHeader */
public enum C1489l {
    AD_TIMEOUT("X-AdTimeout"),
    AD_TYPE("X-Adtype"),
    CLICKTHROUGH_URL("X-Clickthrough"),
    CUSTOM_EVENT_DATA("X-Custom-Event-Class-Data"),
    CUSTOM_EVENT_NAME("X-Custom-Event-Class-Name"),
    CUSTOM_EVENT_HTML_DATA("X-Custom-Event-Html-Data"),
    DSP_CREATIVE_ID("X-DspCreativeid"),
    FAIL_URL("X-Failurl"),
    FULL_AD_TYPE("X-Fulladtype"),
    HEIGHT("X-Height"),
    IMPRESSION_URL("X-Imptracker"),
    REDIRECT_URL("X-Launchpage"),
    NATIVE_PARAMS("X-Nativeparams"),
    NETWORK_TYPE("X-Networktype"),
    REFRESH_TIME("X-Refreshtime"),
    SCROLLABLE("X-Scrollable"),
    WARMUP("X-Warmup"),
    WIDTH("X-Width"),
    LOCATION("Location"),
    USER_AGENT("User-Agent"),
    CUSTOM_SELECTOR("X-Customselector");
    
    private final String key;

    private C1489l(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}
