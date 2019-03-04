package com.slideme.sam.manager.net.response;

import com.google.p043a.p044a.C0670c;

public class DeviceRegisterResponse extends BaseNetworkResponse {
    @C0670c(a = "device_instance_hash")
    public String hash;
    @C0670c(a = "device_instance_hash_fields")
    public String[] hashFields;
    @C0670c(a = "log")
    public String[] serverLog;
    @C0670c(a = "udid")
    public String serverUDID;
}
