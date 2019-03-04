package com.mopub.mobileads;

/* compiled from: BaseInterstitialActivity */
enum C1545o {
    WEB_VIEW_DID_APPEAR("javascript:webviewDidAppear();"),
    WEB_VIEW_DID_CLOSE("javascript:webviewDidClose();");
    
    private String mUrl;

    private C1545o(String str) {
        this.mUrl = str;
    }

    protected String getUrl() {
        return this.mUrl;
    }
}
