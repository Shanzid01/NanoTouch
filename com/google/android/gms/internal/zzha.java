package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzgi
class zzha {
    private int zzvR;
    private final List<String> zzxQ;
    private final List<String> zzxR;
    private final String zzxS;
    private final String zzxT;
    private final String zzxU;
    private final String zzxV;
    private final boolean zzxW;
    private String zzxX;
    private final String zzxv;

    public zzha(int i, Map<String, String> map) {
        this.zzxX = (String) map.get("url");
        this.zzxT = (String) map.get("base_uri");
        this.zzxU = (String) map.get("post_parameters");
        this.zzxW = parseBoolean((String) map.get("drt_include"));
        this.zzxS = (String) map.get("activation_overlay_url");
        this.zzxR = zzQ((String) map.get("check_packages"));
        this.zzxv = (String) map.get("request_id");
        this.zzxV = (String) map.get("type");
        this.zzxQ = zzQ((String) map.get("errors"));
        this.zzvR = i;
    }

    private static boolean parseBoolean(String str) {
        return str != null && (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    private List<String> zzQ(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzvR;
    }

    public String getRequestId() {
        return this.zzxv;
    }

    public String getType() {
        return this.zzxV;
    }

    public String getUrl() {
        return this.zzxX;
    }

    public void setUrl(String str) {
        this.zzxX = str;
    }

    public List<String> zzdU() {
        return this.zzxQ;
    }

    public String zzdV() {
        return this.zzxU;
    }

    public boolean zzdW() {
        return this.zzxW;
    }
}
