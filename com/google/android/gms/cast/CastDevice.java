package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzjv;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR = new zzb();
    private final int zzFG;
    private String zzIE;
    String zzIF;
    private Inet4Address zzIG;
    private String zzIH;
    private String zzII;
    private String zzIJ;
    private int zzIK;
    private List<WebImage> zzIL;
    private int zzIM;
    private int zzrX;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, List<WebImage> list, int i3, int i4) {
        this.zzFG = i;
        this.zzIE = str;
        this.zzIF = str2;
        if (this.zzIF != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzIF);
                if (byName instanceof Inet4Address) {
                    this.zzIG = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.zzIG = null;
            }
        }
        this.zzIH = str3;
        this.zzII = str4;
        this.zzIJ = str5;
        this.zzIK = i2;
        this.zzIL = list;
        this.zzIM = i3;
        this.zzrX = i4;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : zzjv.zza(this.zzIE, castDevice.zzIE) && zzjv.zza(this.zzIG, castDevice.zzIG) && zzjv.zza(this.zzII, castDevice.zzII) && zzjv.zza(this.zzIH, castDevice.zzIH) && zzjv.zza(this.zzIJ, castDevice.zzIJ) && this.zzIK == castDevice.zzIK && zzjv.zza(this.zzIL, castDevice.zzIL) && this.zzIM == castDevice.zzIM && this.zzrX == castDevice.zzrX;
    }

    public int getCapabilities() {
        return this.zzIM;
    }

    public String getDeviceId() {
        return this.zzIE;
    }

    public String getDeviceVersion() {
        return this.zzIJ;
    }

    public String getFriendlyName() {
        return this.zzIH;
    }

    public WebImage getIcon(int i, int i2) {
        WebImage webImage = null;
        if (this.zzIL.isEmpty()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return (WebImage) this.zzIL.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzIL) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < i || height < i2) {
                if (width < i && height < i2 && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.zzIL.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzIL);
    }

    public Inet4Address getIpAddress() {
        return this.zzIG;
    }

    public String getModelName() {
        return this.zzII;
    }

    public int getServicePort() {
        return this.zzIK;
    }

    public int getStatus() {
        return this.zzrX;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public boolean hasIcons() {
        return !this.zzIL.isEmpty();
    }

    public int hashCode() {
        return this.zzIE == null ? 0 : this.zzIE.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzIE.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        return castDevice == null ? false : getDeviceId() == null ? castDevice.getDeviceId() == null : zzjv.zza(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.zzIH, this.zzIE});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
