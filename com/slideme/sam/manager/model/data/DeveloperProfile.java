package com.slideme.sam.manager.model.data;

public class DeveloperProfile extends UserProfile {
    private boolean topDeveloper = false;

    public DeveloperProfile() {
        super("", "");
    }

    public DeveloperProfile(String str, String str2) {
        super(str, str2);
    }

    public boolean isTopDeveloper() {
        return this.topDeveloper;
    }

    public void setTopDeveloper(boolean z) {
        this.topDeveloper = z;
    }
}
