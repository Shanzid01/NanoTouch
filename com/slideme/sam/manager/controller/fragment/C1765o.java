package com.slideme.sam.manager.controller.fragment;

import android.os.Message;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.games.GamesStatusCodes;

/* compiled from: ApplicationDetailsFragment */
class C1765o implements OnClickListener {
    final /* synthetic */ C1735a f3144a;

    C1765o(C1735a c1735a) {
        this.f3144a = c1735a;
    }

    public void onClick(View view) {
        if (this.f3144a.f2996h != null) {
            try {
                Message obtain = Message.obtain(null, GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE);
                obtain.arg1 = Integer.valueOf(this.f3144a.f2989a.app.nodeId).intValue();
                this.f3144a.f2996h.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
