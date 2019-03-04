package com.slideme.sam.manager.net.response;

import com.google.p043a.p044a.C0670c;

public class DailyServiceResponse extends BaseNetworkResponse {
    public Daily daily;

    public class Daily {
        @C0670c(a = "enable_ads")
        public boolean enableAds;
        @C0670c(a = "enable_ads_free_with_ads")
        public boolean enableAdsFreeWithAds;
        public Notification notification;
        public boolean offers;
        @C0670c(a = "offers_hijack_disable")
        public boolean offersHijackDisable;
        @C0670c(a = "offers_source")
        public String offersSource;
        @C0670c(a = "reward_percent")
        public float rewardPercent;

        public class Notification {
            public String action;
            public String message;
            public boolean sticky;
        }
    }
}
