package com.slideme.sam.manager.net.response;

import com.slideme.sam.manager.model.data.UserProfile;

public class LoginResponse extends BaseNetworkResponse {
    public String sessid;
    public UserProfile user;
}
