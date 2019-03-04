package com.slideme.sam.manager.controller.fragment;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1703e;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.dynamic.child.AdProxyChild;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: DynamicLayoutFragment */
class al extends AsyncTask<Void, Void, ArrayList<AdProxyChild>> {
    final /* synthetic */ ae f3046a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m5248a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5249a((ArrayList) obj);
    }

    private al(ae aeVar) {
        this.f3046a = aeVar;
    }

    protected void onPreExecute() {
        this.f3046a.f3033g = true;
    }

    protected ArrayList<AdProxyChild> m5248a(Void... voidArr) {
        ArrayList<AdProxyChild> arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        if (this.f3046a.getActivity() != null) {
            try {
                if (VERSION.SDK_INT > 8) {
                    try {
                        Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f3046a.getActivity());
                        str = advertisingIdInfo.getId();
                        z = advertisingIdInfo.isLimitAdTrackingEnabled();
                    } catch (Exception e) {
                        C1922m.m5797b("AAIDHelper", e.getMessage());
                        str = C1913d.m5763b(this.f3046a.getActivity());
                    }
                } else {
                    str = C1913d.m5763b(this.f3046a.getActivity());
                }
            } catch (Exception e2) {
            }
        }
        if (!(this.f3046a.f3031e.banners == null || this.f3046a.f3031e.banners.adSlots == null || this.f3046a.f3031e.banners.adSlots.isEmpty())) {
            Iterator it = this.f3046a.f3031e.banners.adSlots.iterator();
            while (it.hasNext()) {
                AdProxyChild adProxyChild = (AdProxyChild) it.next();
                Object a = SAM.f2614g.m5597a(SAM.m4761a(), -1, adProxyChild.id, adProxyChild.limit, adProxyChild.source, true, str, z);
                if (!TextUtils.isEmpty(a)) {
                    JSONArray jSONArray;
                    try {
                        jSONArray = new JSONArray(a);
                    } catch (JSONException e3) {
                        if (C1914e.f3493a) {
                            e3.printStackTrace();
                        }
                        jSONArray = null;
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                AdProxyItem a2 = C1703e.m5067a(jSONArray.getJSONObject(i));
                                if (a2 != null && a2.samAvailable) {
                                    arrayList2.add(a2);
                                    stringBuilder.append(a2.packageName);
                                    stringBuilder.append(",");
                                }
                            } catch (Exception e4) {
                                if (C1914e.f3493a) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        int i2 = -1;
                        try {
                            i2 = Integer.valueOf(adProxyChild.limit).intValue();
                        } catch (NumberFormatException e5) {
                        }
                        this.f3046a.m5239b(arrayList2);
                        C1891a c1891a = new C1891a(stringBuilder.toString(), true, true, SAM.m4761a().getString(R.string.live_channel), i2);
                        c1891a.m5698b();
                        if (!(c1891a.m5697a() == null || c1891a.m5697a().isEmpty())) {
                            this.f3046a.m5229a(c1891a.m5697a());
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                Application application = (Application) this.f3046a.f3035i.get(((AdProxyItem) arrayList2.get(i3)).packageName);
                                if (!(application == null || TextUtils.isEmpty(application.promoIcon))) {
                                    AdProxyChild adProxyChild2 = new AdProxyChild();
                                    adProxyChild2.clickUrl = ((AdProxyItem) arrayList2.get(i3)).clickUrl;
                                    adProxyChild2.promoUrl = application.promoIcon;
                                    adProxyChild2.samAvailable = ((AdProxyItem) arrayList2.get(i3)).samAvailable;
                                    adProxyChild2.uid = application.bundleId;
                                    adProxyChild2.packageName = ((AdProxyItem) arrayList2.get(i3)).packageName;
                                    adProxyChild2.versionCode = application.versionCode;
                                    adProxyChild2.weightIndex = adProxyChild.weightIndex;
                                    adProxyChild2.adslotId = adProxyChild.id;
                                    adProxyChild2.payout = ((AdProxyItem) arrayList2.get(i3)).payout;
                                    adProxyChild2.network = ((AdProxyItem) arrayList2.get(i3)).network;
                                    adProxyChild2.platform = ((AdProxyItem) arrayList2.get(i3)).platform;
                                    adProxyChild2.offerId = ((AdProxyItem) arrayList2.get(i3)).offerId;
                                    arrayList.add(adProxyChild2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    protected void m5249a(ArrayList<AdProxyChild> arrayList) {
        this.f3046a.f3031e.banners.adSlots = arrayList;
        this.f3046a.f3033g = false;
        if (this.f3046a.m5232a(this.f3046a.f3031e)) {
            this.f3046a.m5235b();
        }
    }
}
