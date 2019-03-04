package com.p019a.p020a.p021a;

/* compiled from: SessionEventMetadata */
final class am {
    public final String f1083a;
    public final String f1084b;
    public final String f1085c;
    public final String f1086d;
    public final String f1087e;
    public final Boolean f1088f;
    public final String f1089g;
    public final String f1090h;
    public final String f1091i;
    public final String f1092j;
    public final String f1093k;
    public final String f1094l;
    private String f1095m;

    public am(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f1083a = str;
        this.f1084b = str2;
        this.f1085c = str3;
        this.f1086d = str4;
        this.f1087e = str5;
        this.f1088f = bool;
        this.f1089g = str6;
        this.f1090h = str7;
        this.f1091i = str8;
        this.f1092j = str9;
        this.f1093k = str10;
        this.f1094l = str11;
    }

    public String toString() {
        if (this.f1095m == null) {
            this.f1095m = "appBundleId=" + this.f1083a + ", executionId=" + this.f1084b + ", installationId=" + this.f1085c + ", androidId=" + this.f1086d + ", advertisingId=" + this.f1087e + ", limitAdTrackingEnabled=" + this.f1088f + ", betaDeviceToken=" + this.f1089g + ", buildId=" + this.f1090h + ", osVersion=" + this.f1091i + ", deviceModel=" + this.f1092j + ", appVersionCode=" + this.f1093k + ", appVersionName=" + this.f1094l;
        }
        return this.f1095m;
    }
}
