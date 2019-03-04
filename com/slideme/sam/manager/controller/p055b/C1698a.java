package com.slideme.sam.manager.controller.p055b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.drive.DriveFile;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.SplashAccountFlowActivity;
import com.slideme.sam.manager.controller.activities.SplashActivity;
import com.slideme.sam.manager.controller.activities.access.UpgradeProfileActivity;
import com.slideme.sam.manager.controller.activities.market.catalog.CategoryDisplayActivity;
import com.slideme.sam.manager.controller.activities.market.catalog.MainActivity;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.web.QuestionnaireActivity;
import com.slideme.sam.manager.controller.activities.web.TopupActivity;
import com.slideme.sam.manager.controller.activities.web.WebBuyFragmentActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.data.Category;
import com.slideme.sam.manager.model.p054b.C1827a;

/* compiled from: ActivityHelper */
public abstract class C1698a {
    public static void m5058a(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            new Thread(new C1699b(str, activity)).start();
        }
    }

    public static void m5059a(Activity activity, boolean z, Bundle bundle) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.addFlags(67108864);
        if (z) {
            intent.addFlags(DriveFile.MODE_WRITE_ONLY);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
    }

    public static void m5060a(Activity activity, boolean z, Bundle bundle, boolean z2) {
        if (z2) {
            C1698a.m5053a(activity);
        } else if (SAM.f2624q == null || SAM.f2624q.isEmpty() || C1827a.m5498b(activity, SAM.f2624q.getProperty("auto_download"))) {
            C1698a.m5059a(activity, z, bundle);
        } else {
            C1698a.m5058a(activity, SAM.f2624q.getProperty("auto_download"));
        }
    }

    public static void m5061a(Context context) {
        Intent intent = new Intent(context, TopupActivity.class);
        intent.putExtra("com.slideme.sam.manager.extra.URL", context.getString(R.string.SLIDEME_TOPUP_URL));
        context.startActivity(intent);
    }

    public static void m5057a(Activity activity, ApplicationHolder applicationHolder, int i) {
        Intent intent = new Intent(activity, WebBuyFragmentActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_APPHOLDER", applicationHolder);
        activity.startActivityForResult(intent, i);
    }

    public static void m5053a(Activity activity) {
        Intent intent = new Intent(activity, QuestionnaireActivity.class);
        intent.putExtra("com.slideme.sam.manager.extra.URL", activity.getString(R.string.SLIDEME_QUESTIONNAIRE_URL));
        activity.startActivity(intent);
    }

    public static void m5064b(Context context) {
        context.startActivity(new Intent(context, UpgradeProfileActivity.class));
    }

    public static void m5062a(Context context, boolean z) {
        Intent intent;
        if (z) {
            intent = new Intent(context, SplashAccountFlowActivity.class);
        } else {
            intent = new Intent(context, SplashActivity.class);
        }
        intent.addFlags(67108864);
        intent.addFlags(DriveFile.MODE_WRITE_ONLY);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        context.startActivity(intent);
    }

    public static void m5054a(Activity activity, Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setClass(activity, ApplicationDetailsActivity.class);
        activity.startActivity(intent2);
    }

    public static void m5055a(Activity activity, Application application) {
        C1698a.m5056a(activity, application, false);
    }

    public static void m5056a(Activity activity, Application application, boolean z) {
        ((SAM) activity.getApplicationContext()).m4774a(activity, new C1701c(activity, application, z));
    }

    public static void m5063a(Category category, Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CategoryDisplayActivity.class);
        intent.putExtra("com.slideme.sam.manager.extra.CATEGORY", category);
        context.startActivity(intent);
    }
}
