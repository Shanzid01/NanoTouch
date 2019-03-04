package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class zzba extends zzaj {
    private static final String ID = zza.LANGUAGE.toString();

    public zzba() {
        super(ID, new String[0]);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzde.zzuf();
        }
        String language = locale.getLanguage();
        return language == null ? zzde.zzuf() : zzde.zzx(language.toLowerCase());
    }

    public boolean zzsD() {
        return false;
    }

    public /* bridge */ /* synthetic */ String zzth() {
        return super.zzth();
    }

    public /* bridge */ /* synthetic */ Set zzti() {
        return super.zzti();
    }
}
