package com.slideme.sam.manager.model.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v4.content.C0090q;
import com.google.p043a.ae;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.cache.helper.UpdatesDatabase;
import com.slideme.sam.manager.model.data.cache.helper.data.UpdatesDatabaseObject;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.net.C1879l;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationUpdatesCheckService extends IntentService {
    private static boolean f3304b = false;
    private SharedPreferences f3305a;
    private List<Application> f3306c;

    public ApplicationUpdatesCheckService() {
        super("AppUpdatesCheckService");
    }

    public void onCreate() {
        super.onCreate();
        this.f3305a = getSharedPreferences("app_updates_check_metadata", 0);
        setIntentRedelivery(false);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent.getAction().equals("com.slideme.sam.manager.ACTION_CHECK_UPDATES")) {
            boolean booleanExtra = intent.getBooleanExtra("com.slideme.sam.manager.EXTRA_FORCE", false);
            if (m5559c() || booleanExtra) {
                ArrayList a;
                f3304b = true;
                this.f3306c = new ArrayList();
                try {
                    a = SAM.f2614g.m5598a(C1879l.ALL);
                } catch (Throwable e) {
                    C1922m.m5791a(e);
                    a = null;
                }
                if (a == null) {
                    a = new ArrayList();
                }
                String[] strArr = (String[]) a.toArray(new String[a.size()]);
                Catalog catalog = new Catalog(((SAM) getApplication()).m4780d());
                catalog.m5667a(strArr);
                catalog.m5689g();
                while (catalog.m5681e() > 0) {
                    catalog.m5689g();
                }
                this.f3306c.addAll(catalog.m5693i());
                a = new ArrayList();
                try {
                    ArrayList b = SAM.f2614g.m5631b();
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = b.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next());
                        stringBuilder.append(",");
                    }
                    C1891a c1891a = new C1891a(stringBuilder.toString(), true, true, SAM.m4761a().getString(R.string.live_channel), b.size());
                    c1891a.m5698b();
                    if (!(c1891a.m5697a() == null || c1891a.m5697a().isEmpty())) {
                        C1922m.m5797b("UpdatesChecker", "Found " + String.valueOf(c1891a.m5697a().size()) + " preloaded apps");
                        boolean z = checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") == 0;
                        Iterator it2 = c1891a.m5697a().iterator();
                        while (it2.hasNext()) {
                            Parcelable parcelable = (Application) it2.next();
                            if (C1827a.m5491a(getApplicationContext(), parcelable.packageName, parcelable.versionCode) == C1828b.NEEDS_UPDATE) {
                                C1922m.m5797b("UpdatesChecker", "Preloaded app " + parcelable.name + " needs update");
                                if (z && C1922m.m5798b(getApplicationContext())) {
                                    C1922m.m5797b("UpdatesChecker", "Preloaded app " + parcelable.name + " will install silently");
                                    Intent intent2 = new Intent(this, ApplicationDownloadService.class);
                                    C1915f.m5769a(intent2, "com.slideme.sam.manager.EXTRA_APPLICATION", parcelable);
                                    startService(intent2);
                                } else {
                                    C1922m.m5797b("UpdatesChecker", "Preloaded app " + parcelable.name + " is added to user updatables list");
                                    this.f3306c.add(parcelable);
                                }
                            } else {
                                C1922m.m5797b("UpdatesChecker", "Preloaded app " + parcelable.name + " is up to date");
                            }
                        }
                    }
                } catch (ae e2) {
                }
                this.f3306c = m5557b(this.f3306c);
                C1922m.m5797b("UpdatesChecker", "Found " + String.valueOf(this.f3306c.size()) + " user updatable apps");
                if (this.f3306c.size() > 0) {
                    UpdatesDatabase updatesDatabase = new UpdatesDatabase(this);
                    updatesDatabase.clear();
                    updatesDatabase.addAll(m5555a(this.f3306c));
                    m5553a(System.currentTimeMillis());
                    updatesDatabase.close();
                }
                m5558c(this.f3306c);
                f3304b = false;
            }
        } else if (intent.getAction().equals("com.slideme.sam.manager.ACTION_REMOVE_NOTIFICATION")) {
            ((NotificationManager) getSystemService("notification")).cancel(1);
        }
    }

    private UpdatesDatabaseObject[] m5555a(List<Application> list) {
        UpdatesDatabaseObject[] updatesDatabaseObjectArr = new UpdatesDatabaseObject[list.size()];
        for (int i = 0; i < updatesDatabaseObjectArr.length; i++) {
            updatesDatabaseObjectArr[i] = new UpdatesDatabaseObject(((Application) list.get(i)).bundleId, ((Application) list.get(i)).token);
        }
        return updatesDatabaseObjectArr;
    }

    private List<Application> m5557b(List<Application> list) {
        List<Application> arrayList = new ArrayList();
        for (Application application : list) {
            if (C1827a.m5491a(this, application.packageName, application.versionCode) == C1828b.NEEDS_UPDATE) {
                arrayList.add(application);
            }
        }
        return arrayList;
    }

    private void m5558c(List<Application> list) {
        if (list.size() > 0) {
            ((NotificationManager) getSystemService("notification")).notify(1, C1704f.m5075a((Context) this, (List) list));
        }
        C0090q.m145a((Context) this).m150a(new Intent("com.slideme.sam.manager.ACTION_UPDATES_CHECKED"));
    }

    private void m5553a(long j) {
        this.f3305a.edit().putLong("last_checked", j).commit();
    }

    private long m5556b() {
        return this.f3305a.getLong("last_checked", -1);
    }

    private boolean m5559c() {
        return System.currentTimeMillis() - m5556b() > 43200000;
    }

    public static boolean m5554a() {
        return f3304b;
    }

    public void onDestroy() {
        if (f3304b) {
            m5553a(-1);
            UpdatesDatabase updatesDatabase = new UpdatesDatabase(this);
            updatesDatabase.clear();
            updatesDatabase.close();
        }
        super.onDestroy();
    }
}
