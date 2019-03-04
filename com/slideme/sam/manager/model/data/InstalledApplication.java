package com.slideme.sam.manager.model.data;

public class InstalledApplication {
    public CharSequence name;
    public String packageName;

    public InstalledApplication(String str, CharSequence charSequence) {
        this.packageName = str;
        this.name = charSequence;
    }
}
