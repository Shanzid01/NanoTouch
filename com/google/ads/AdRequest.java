package com.google.ads;

@Deprecated
public final class AdRequest {
    public static final String f1934a = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String description;

        private ErrorCode(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    private AdRequest() {
    }
}
