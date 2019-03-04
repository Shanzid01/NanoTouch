package com.slideme.sam.manager.controller.activities.common;

import android.text.TextUtils;
import com.p019a.p020a.C0367a;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.DeviceRegisterResponse;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1922m;
import java.util.HashMap;

/* compiled from: FlipperFragmentActivity */
class C1663h extends C1600v {
    final /* synthetic */ C1662g f2794a;

    C1663h(C1662g c1662g) {
        this.f2794a = c1662g;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        C1922m.m5797b("Connect", "Registered device...");
        if (this.f2794a.f2793a.f2646a != null) {
            DeviceRegisterResponse deviceRegisterResponse = (DeviceRegisterResponse) baseNetworkResponse;
            C0367a.m2509e().f1149c.m2782b(deviceRegisterResponse.serverUDID);
            C1913d.m5760a(this.f2794a.f2793a, deviceRegisterResponse.serverUDID);
            HashMap a = SAM.f2614g.m5599a(this.f2794a.f2793a.getApplicationContext());
            a.put("sam_version", this.f2794a.f2793a.getApplicationContext().getString(R.string.sam_version_num));
            StringBuilder stringBuilder = new StringBuilder();
            for (Object obj : deviceRegisterResponse.hashFields) {
                stringBuilder.append((String) a.get(obj));
            }
            Object obj2 = "";
            try {
                obj2 = C1913d.m5758a(stringBuilder.toString());
            } catch (Exception e) {
                C1922m.m5790a(e);
            } catch (Exception e2) {
                C1922m.m5790a(e2);
            }
            if (TextUtils.isEmpty(deviceRegisterResponse.hash) || !deviceRegisterResponse.hash.equals(r0)) {
                C1922m.m5797b("Connect", "Device specs update needed...");
                SAM.f2614g.m5605a(this.f2794a.f2793a, new C1664i(this));
                return;
            }
            C1922m.m5797b("Connect", "No device specs update is needed!");
            this.f2794a.f2793a.f2646a.setDisplayedChild(C1665j.CONTENT.ordinal());
        }
    }

    public void mo4233a(Throwable th, String str) {
        super.mo4233a(th, str);
        C1922m.m5797b("Connect", "Failed to register device!");
        this.f2794a.f2793a.finish();
    }
}
