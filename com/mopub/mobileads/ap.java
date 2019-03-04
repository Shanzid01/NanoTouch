package com.mopub.mobileads;

/* compiled from: MraidCommandFactory */
enum ap {
    CLOSE("close"),
    EXPAND("expand"),
    USECUSTOMCLOSE("usecustomclose"),
    OPEN("open"),
    RESIZE("resize"),
    GET_RESIZE_PROPERTIES("getResizeProperties"),
    SET_RESIZE_PROPERTIES("setResizeProperties"),
    PLAY_VIDEO("playVideo"),
    STORE_PICTURE("storePicture"),
    GET_CURRENT_POSITION("getCurrentPosition"),
    GET_DEFAULT_POSITION("getDefaultPosition"),
    GET_MAX_SIZE("getMaxSize"),
    GET_SCREEN_SIZE("getScreenSize"),
    CREATE_CALENDAR_EVENT("createCalendarEvent"),
    UNSPECIFIED("");
    
    private String mCommand;

    private ap(String str) {
        this.mCommand = str;
    }

    private static ap fromString(String str) {
        for (ap apVar : values()) {
            if (apVar.mCommand.equals(str)) {
                return apVar;
            }
        }
        return UNSPECIFIED;
    }

    String getCommand() {
        return this.mCommand;
    }
}
