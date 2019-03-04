package com.slideme.sam.manager.net.response;

public class RegisterResponse extends BaseNetworkResponse {
    public RespTag resp;

    public class RespTag {
        public String password = null;
        public boolean success = false;
    }
}
