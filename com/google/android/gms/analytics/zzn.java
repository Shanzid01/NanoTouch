package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class zzn<T extends zzm> {
    Context mContext;
    zza<T> zzBI;

    public interface zza<U extends zzm> {
        void zzc(String str, int i);

        void zzd(String str, boolean z);

        U zzfB();

        void zzi(String str, String str2);

        void zzj(String str, String str2);
    }

    public zzn(Context context, zza<T> com_google_android_gms_analytics_zzn_zza_T) {
        this.mContext = context;
        this.zzBI = com_google_android_gms_analytics_zzn_zza_T;
    }

    private T zza(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    Object attributeValue;
                    if (toLowerCase.equals("screenname")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        Object trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            this.zzBI.zzi(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || r1 == null)) {
                            this.zzBI.zzj(attributeValue, r1);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(r1))) {
                            try {
                                this.zzBI.zzd(attributeValue, Boolean.parseBoolean(r1));
                            } catch (NumberFormatException e) {
                                zzae.zzZ("Error parsing bool configuration value: " + r1);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(r1))) {
                            try {
                                this.zzBI.zzc(attributeValue, Integer.parseInt(r1));
                            } catch (NumberFormatException e2) {
                                zzae.zzZ("Error parsing int configuration value: " + r1);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            zzae.zzZ("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            zzae.zzZ("Error parsing tracker configuration file: " + e4);
        }
        return this.zzBI.zzfB();
    }

    public T zzD(int i) {
        try {
            return zza(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            zzae.zzac("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
