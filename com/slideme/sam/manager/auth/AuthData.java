package com.slideme.sam.manager.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.UserProfile;
import com.slideme.sam.manager.model.data.UserProfile.Roles;
import java.util.ArrayList;
import java.util.Arrays;

public class AuthData implements Parcelable {
    public static final Creator<AuthData> CREATOR = new C1597a();
    protected UserProfile f2650a;
    private String f2651b;

    public AuthData(String str, UserProfile userProfile) {
        this.f2651b = str;
        this.f2650a = userProfile;
    }

    private AuthData(Parcel parcel) {
        this.f2651b = parcel.readString();
        this.f2650a = (UserProfile) parcel.readParcelable(UserProfile.class.getClassLoader());
    }

    public Bundle m4816a() {
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.f2650a.uid);
        bundle.putString("name", this.f2650a.name);
        bundle.putString("mail", this.f2650a.getMail());
        bundle.putString("status", this.f2650a.status);
        bundle.putString("language", this.f2650a.language);
        bundle.putString("roles", this.f2650a.roles.toString());
        bundle.putString("showQuestionnaire", this.f2650a.showQuestionnaire() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2651b);
        parcel.writeParcelable(this.f2650a, 0);
    }

    public static boolean m4805a(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account b = SAM.f2622o.m4850b();
        if (b != null) {
            return m4801a(accountManager.getUserData(b, "roles")).contains(String.valueOf(Roles.SAM_DEBUGGER.rid));
        }
        return false;
    }

    public static boolean m4806b(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account b = SAM.f2622o.m4850b();
        if (b != null) {
            return m4801a(m4800a(accountManager, b, "roles")).contains(String.valueOf(Roles.APPLICATION_TESTER.rid));
        }
        return false;
    }

    public static boolean m4807c(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account b = SAM.f2622o.m4850b();
        if (b != null) {
            return m4801a(m4800a(accountManager, b, "roles")).contains(String.valueOf(Roles.APPLICATION_SCORER.rid));
        }
        return false;
    }

    @Deprecated
    public static boolean m4808d(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account b = SAM.f2622o.m4850b();
        if (b != null) {
            return m4801a(m4800a(accountManager, b, "roles")).contains(String.valueOf(Roles.FAST_REG_USER.rid));
        }
        return false;
    }

    public static boolean m4809e(Context context) {
        return SAM.f2622o.m4850b() == null;
    }

    public static String m4810f(Context context) {
        if (SAM.f2622o.m4850b() != null) {
            return m4800a(AccountManager.get(context), SAM.f2622o.m4850b(), "uid");
        }
        return null;
    }

    public static String m4811g(Context context) {
        if (SAM.f2622o.m4850b() != null) {
            return m4800a(AccountManager.get(context), SAM.f2622o.m4850b(), "name");
        }
        return null;
    }

    public static String m4812h(Context context) {
        if (SAM.f2622o.m4850b() != null) {
            return AccountManager.get(context).getPassword(SAM.f2622o.m4850b());
        }
        return null;
    }

    public static boolean m4813i(Context context) {
        if (SAM.f2622o.m4850b() != null) {
            return Boolean.parseBoolean(m4800a(AccountManager.get(context), SAM.f2622o.m4850b(), "showQuestionnaire"));
        }
        return false;
    }

    public static void m4804a(Context context, boolean z) {
        if (SAM.f2622o.m4850b() != null) {
            AccountManager.get(context).setUserData(SAM.f2622o.m4850b(), "showQuestionnaire", z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        }
    }

    public String m4817b() {
        return this.f2651b;
    }

    public static float m4814j(Context context) {
        if (SAM.f2622o.m4850b() == null || context == null) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        String userData = AccountManager.get(context).getUserData(SAM.f2622o.m4850b(), "wallet");
        if (userData == null) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        return Float.parseFloat(userData);
    }

    public static void m4802a(Context context, float f) {
        if (SAM.f2622o.m4850b() != null) {
            AccountManager.get(context).setUserData(SAM.f2622o.m4850b(), "wallet", String.valueOf(f));
        }
    }

    public static void m4803a(Context context, String str) {
        if (SAM.f2622o.m4850b() != null) {
            AccountManager.get(context).setUserData(SAM.f2622o.m4850b(), "wallet", str);
        }
    }

    private static ArrayList<String> m4801a(String str) {
        return new ArrayList(Arrays.asList(str.substring(1, str.length() - 1).split(", ")));
    }

    public static void m4815k(Context context) {
        if (SAM.f2622o.m4850b() != null) {
            AccountManager accountManager = AccountManager.get(context);
            ArrayList a = m4801a(accountManager.getUserData(SAM.f2622o.m4850b(), "roles"));
            if (a.contains(String.valueOf(Roles.FAST_REG_USER.rid))) {
                a.remove(String.valueOf(Roles.FAST_REG_USER.rid));
                accountManager.setUserData(SAM.f2622o.m4850b(), "roles", a.toString());
            }
        }
    }

    private static String m4800a(AccountManager accountManager, Account account, String str) {
        if (account != null) {
            return accountManager.getUserData(account, str);
        }
        return null;
    }
}
