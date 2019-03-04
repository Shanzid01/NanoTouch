package com.slideme.sam.manager.controller.activities.access;

import android.content.Intent;
import android.os.AsyncTask;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0363v;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: LoginActivity */
public class C1637a extends AsyncTask<String, Void, Intent> {
    final /* synthetic */ LoginActivity f2762a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4928a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4929a((Intent) obj);
    }

    public C1637a(LoginActivity loginActivity) {
        this.f2762a = loginActivity;
    }

    protected void onPreExecute() {
        this.f2762a.f2652b.setMessage(this.f2762a.getString(R.string.login_progress));
        this.f2762a.mo4228a(true);
    }

    protected Intent m4928a(String... strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        AuthData a = SAM.f2614g.m5590a(str, str2, "com.slideme.user_account", true);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("authAccount", str);
        intent.putExtra("accountType", "com.slideme.user_account");
        intent.putExtra("authtoken", a.m4817b());
        intent.putExtra("userdata", a.m4816a());
        intent.putExtra("com.slideme.sam.manager.EXTRA_PASSWORD", str2);
        return intent;
    }

    protected void m4929a(Intent intent) {
        this.f2762a.f2654d = null;
        if (intent != null) {
            C0345b.m2427c().m2438a(new C0363v().m2492a("SlideME").m2493a(true));
            this.f2762a.mo4241a(intent);
            return;
        }
        C1920k.m5781a(this.f2762a, (int) R.string.login_error, 1).show();
        this.f2762a.mo4228a(false);
    }

    protected void onCancelled() {
        this.f2762a.f2654d = null;
        this.f2762a.mo4228a(false);
    }
}
