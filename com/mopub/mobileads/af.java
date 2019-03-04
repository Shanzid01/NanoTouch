package com.mopub.mobileads;

/* compiled from: MoPubInterstitial */
enum af {
    CUSTOM_EVENT_AD_READY,
    NOT_READY;

    boolean isReady() {
        return this != NOT_READY;
    }
}
