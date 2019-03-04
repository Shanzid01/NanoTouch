package com.slideme.sam.manager.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.p043a.p044a.C0670c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class UserProfile implements Parcelable {
    public static final Creator<UserProfile> CREATOR = new C18421();
    public String language;
    private String mFullName;
    private int mGender;
    private String mMail;
    private String mPassword;
    @C0670c(a = "show_webform")
    public boolean mShowQuestionnaire;
    private String mUsername;
    private float mWallet;
    public String name;
    public ArrayList<Long> roles;
    public String status;
    public String uid;

    class C18421 implements Creator<UserProfile> {
        C18421() {
        }

        public UserProfile[] newArray(int i) {
            return new UserProfile[i];
        }

        public UserProfile createFromParcel(Parcel parcel) {
            return new UserProfile(parcel);
        }
    }

    public enum Roles {
        ANONYMOUS(1),
        AUTHENTICATED(2),
        ADMINISTRATOR(3),
        DEVELOPER(4),
        ACCREDITED(5),
        NORMAL_USER(6),
        LIMITED_ADMIN(7),
        APPLICATION_TESTER(8),
        PAYING_USER(9),
        SPAM_FREE(10),
        ANALYTICS(12),
        PARTNER(13),
        FAST_REG_USER(15),
        SAM_DEBUGGER(16),
        APPLICATION_SCORER(19);
        
        public final long rid;

        private Roles(long j) {
            this.rid = j;
        }
    }

    public UserProfile(String str, String str2) {
        this.roles = new ArrayList();
        this.mWallet = GroundOverlayOptions.NO_DIMENSION;
        this.mGender = 0;
        this.mShowQuestionnaire = false;
        this.mUsername = str;
        this.mPassword = str2;
    }

    public UserProfile() {
        this.roles = new ArrayList();
        this.mWallet = GroundOverlayOptions.NO_DIMENSION;
        this.mGender = 0;
        this.mShowQuestionnaire = false;
    }

    public String computeAuth(String str) {
        try {
            return "username=" + URLEncoder.encode(this.mUsername.toString(), "UTF-8") + "&password=" + URLEncoder.encode(this.mPassword.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUserName() {
        return this.mUsername;
    }

    public void setUsername(String str) {
        this.mUsername = str;
    }

    public void setMail(String str) {
        this.mMail = str;
    }

    public String getMail() {
        return this.mMail;
    }

    public void setShowQuestionnaire(boolean z) {
        this.mShowQuestionnaire = z;
    }

    public boolean showQuestionnaire() {
        return this.mShowQuestionnaire;
    }

    public float getWalletBalance() {
        return this.mWallet;
    }

    public void setWalletBalance(float f) {
        this.mWallet = f;
    }

    public String getFullName() {
        return this.mFullName;
    }

    public void setFullName(String str) {
        this.mFullName = str;
    }

    public boolean isDeveloper() {
        return this.roles.contains(Long.valueOf(Roles.DEVELOPER.rid));
    }

    public boolean isAuthenticated() {
        return this.roles.contains(Long.valueOf(Roles.AUTHENTICATED.rid));
    }

    public boolean isAnonymous() {
        return this.roles.contains(Long.valueOf(Roles.ANONYMOUS.rid));
    }

    public boolean isTester() {
        return this.roles.contains(Long.valueOf(Roles.APPLICATION_TESTER.rid));
    }

    public boolean canScore() {
        return this.roles.contains(Long.valueOf(Roles.APPLICATION_TESTER.rid)) || this.roles.contains(Long.valueOf(Roles.APPLICATION_SCORER.rid));
    }

    public boolean isSamDebugger() {
        return this.roles.contains(Long.valueOf(Roles.SAM_DEBUGGER.rid));
    }

    public boolean isLoggedIn() {
        return isAuthenticated() && !isAnonymous();
    }

    public boolean isFastRegged() {
        return this.roles.contains(Long.valueOf(Roles.FAST_REG_USER.rid));
    }

    public void bought(double d) {
        this.mWallet = (float) (((double) this.mWallet) - d);
    }

    public void makeFull() {
        if (this.roles.contains(Long.valueOf(Roles.FAST_REG_USER.rid))) {
            this.roles.remove(this.roles.indexOf(Long.valueOf(Roles.FAST_REG_USER.rid)));
        }
    }

    public void setGender(int i) {
        this.mGender = i;
    }

    public int getGender() {
        return this.mGender;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public int describeContents() {
        return 0;
    }

    private UserProfile(Parcel parcel) {
        boolean z = false;
        this.roles = new ArrayList();
        this.mWallet = GroundOverlayOptions.NO_DIMENSION;
        this.mGender = 0;
        this.mShowQuestionnaire = false;
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.status = parcel.readString();
        this.language = parcel.readString();
        this.roles = parcel.readArrayList(Long.class.getClassLoader());
        this.mFullName = parcel.readString();
        this.mUsername = parcel.readString();
        this.mPassword = parcel.readString();
        this.mWallet = (float) parcel.readDouble();
        this.mGender = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        }
        this.mShowQuestionnaire = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.status);
        parcel.writeString(this.language);
        parcel.writeList(this.roles);
        parcel.writeString(this.mFullName);
        parcel.writeString(this.mUsername);
        parcel.writeString(this.mPassword);
        parcel.writeDouble((double) this.mWallet);
        parcel.writeInt(this.mGender);
        parcel.writeInt(this.mShowQuestionnaire ? 1 : 0);
    }
}
