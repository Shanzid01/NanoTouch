package com.slideme.sam.manager.model.data.tags;

import com.google.p043a.p044a.C0670c;
import java.util.ArrayList;

public class CompatibilityTag {
    @C0670c(a = "UseConfiguration")
    public String configurations;
    @C0670c(a = "UseFeature")
    public String features;
    @C0670c(a = "UseLibrary")
    public String libraries;
    @C0670c(a = "Locales")
    public ArrayList<String> locales;
    @C0670c(a = "OptimizedFor")
    public String optimizedFor = "NNN";
    @C0670c(a = "Permissions")
    public String permissions;
    @C0670c(a = "ScreenCompat")
    public ScreenCompatTag screenCompat;
}
