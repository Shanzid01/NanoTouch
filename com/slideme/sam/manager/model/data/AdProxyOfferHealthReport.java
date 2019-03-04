package com.slideme.sam.manager.model.data;

public class AdProxyOfferHealthReport {
    public boolean healthy;
    public String id;
    public String network;
    public String udid;
    public int versionCode;
    public String versionName;

    public AdProxyOfferHealthReport(String str, String str2, String str3, int i, boolean z, String str4) {
        this.id = str;
        this.network = str2;
        this.versionName = str3;
        this.versionCode = i;
        this.healthy = z;
        this.udid = str4;
    }
}
