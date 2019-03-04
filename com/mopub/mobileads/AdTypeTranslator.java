package com.mopub.mobileads;

import com.google.android.gms.fitness.FitnessActivities;
import com.mopub.common.C1508p;
import com.mopub.mobileads.MoPubInterstitial.MoPubInterstitialView;

public class AdTypeTranslator {

    public enum CustomEventType {
        ADMOB_BANNER("admob_native_banner", "com.mopub.mobileads.GoogleAdMobBanner"),
        ADMOB_INTERSTITIAL("admob_full_interstitial", "com.mopub.mobileads.GoogleAdMobInterstitial"),
        GOOGLE_PLAY_BANNER("google_play_banner", "com.mopub.mobileads.GooglePlayServicesBanner"),
        GOOGLE_PLAY_INTERSTITIAL("google_play_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial"),
        MILLENNIAL_BANNER("millennial_native_banner", "com.mopub.mobileads.MillennialBanner"),
        MILLENNIAL_INTERSTITIAL("millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial"),
        MRAID_BANNER("mraid_banner", "com.mopub.mobileads.MraidBanner"),
        MRAID_INTERSTITIAL("mraid_interstitial", "com.mopub.mobileads.MraidInterstitial"),
        HTML_BANNER("html_banner", "com.mopub.mobileads.HtmlBanner"),
        HTML_INTERSTITIAL("html_interstitial", "com.mopub.mobileads.HtmlInterstitial"),
        VAST_VIDEO_INTERSTITIAL("vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial"),
        UNSPECIFIED("", null);
        
        private final String mClassName;
        private final String mKey;

        private CustomEventType(String str, String str2) {
            this.mKey = str;
            this.mClassName = str2;
        }

        private static CustomEventType fromString(String str) {
            for (CustomEventType customEventType : values()) {
                if (customEventType.mKey.equals(str)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }

        public String toString() {
            return this.mClassName;
        }
    }

    static String m4227a(String str, String str2) {
        String str3;
        if ("interstitial".equals(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        return str3 != null ? str3 : FitnessActivities.UNKNOWN;
    }

    static String m4226a(MoPubView moPubView, String str, String str2) {
        CustomEventType access$2;
        if (!"html".equals(str) && !"mraid".equals(str)) {
            if ("interstitial".equals(str)) {
                access$2 = CustomEventType.fromString(new StringBuilder(String.valueOf(str2)).append("_interstitial").toString());
            } else {
                access$2 = CustomEventType.fromString(new StringBuilder(String.valueOf(str)).append("_banner").toString());
            }
            if (moPubView != null) {
                access$2 = C1508p.m4136a(moPubView.getContext(), access$2);
            }
        } else if (m4228a(moPubView)) {
            access$2 = CustomEventType.fromString(new StringBuilder(String.valueOf(str)).append("_interstitial").toString());
        } else {
            access$2 = CustomEventType.fromString(new StringBuilder(String.valueOf(str)).append("_banner").toString());
        }
        return access$2.toString();
    }

    private static boolean m4228a(MoPubView moPubView) {
        return moPubView instanceof MoPubInterstitialView;
    }
}
