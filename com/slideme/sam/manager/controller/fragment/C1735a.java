package com.slideme.sam.manager.controller.fragment;

import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.content.C0090q;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.facebook.AppEventsConstants;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.ShareDialogFeature;
import com.google.android.gms.fitness.FitnessActivities;
import com.mopub.mobileads.MoPubView;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0358p;
import com.p019a.p020a.p021a.ap;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.test.ApproveActivity;
import com.slideme.sam.manager.controller.activities.test.ScorecardActivity;
import com.slideme.sam.manager.controller.p053a.C1629t;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.Application.ImageSize;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.data.cache.helper.BookmarksCache;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.model.service.ApplicationDownloadService;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.C1867a;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;
import com.slideme.sam.manager.util.C1918i;
import com.slideme.sam.manager.util.C1920k;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.C1950a;
import com.slideme.sam.manager.view.p064a.C1937h;
import com.slideme.sam.manager.view.p064a.C1945p;
import com.slideme.sam.manager.view.touchme.ApplicationListView;
import com.slideme.sam.manager.view.touchme.ChangelogListView;
import com.slideme.sam.manager.view.touchme.DownloadButton;
import com.slideme.sam.manager.view.touchme.ExpandableTextContainer;
import com.slideme.sam.manager.view.touchme.ExpandableTitledContainer;
import com.slideme.sam.manager.view.touchme.LanguageListView;
import com.slideme.sam.manager.view.touchme.MiscAppInfo;
import com.slideme.sam.manager.view.touchme.MyReview;
import com.slideme.sam.manager.view.touchme.NotificationPanel;
import com.slideme.sam.manager.view.touchme.ObservableScrollView;
import com.slideme.sam.manager.view.touchme.PermissionListView;
import com.slideme.sam.manager.view.touchme.ReviewChartView;
import com.slideme.sam.manager.view.touchme.ReviewListView;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;
import com.slideme.sam.manager.view.touchme.ScreenshotContainer;
import com.slideme.sam.manager.view.touchme.aa;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;

/* compiled from: ApplicationDetailsFragment */
public class C1735a extends SherlockFragment implements OnDismissListener, aa {
    private LinearLayout f2977A;
    private MoPubView f2978B;
    private ScreenshotContainer f2979C;
    private ReviewChartView f2980D;
    private NotificationPanel f2981E;
    private boolean f2982F;
    private boolean f2983G = false;
    private String f2984H = SAM.f2618k.m5421a();
    private BroadcastReceiver f2985I = new C1750b(this);
    private ServiceConnection f2986J = new C1760k(this);
    private TimerTask f2987K;
    private Timer f2988L;
    private ApplicationHolder f2989a;
    private C1775y f2990b;
    private String f2991c;
    private String f2992d;
    private String f2993e;
    private double f2994f;
    private boolean f2995g = false;
    private Messenger f2996h = null;
    private final Messenger f2997i = new Messenger(new C1776z(this));
    private Boolean f2998j = Boolean.valueOf(false);
    private String f2999k;
    private DownloadButton f3000l;
    private ToggleButton f3001m;
    private MyReview f3002n;
    private Button f3003o;
    private ObservableScrollView f3004p;
    private View f3005q;
    private View f3006r;
    private ApplicationListView f3007s;
    private ApplicationListView f3008t;
    private ReviewListView f3009u;
    private LanguageListView f3010v;
    private View f3011w;
    private ProgressBar f3012x;
    private ImageButton f3013y;
    private TextView f3014z;

    private boolean m5180b(Intent intent) {
        String str = null;
        if (!intent.getAction().equals("android.intent.action.VIEW")) {
            return false;
        }
        String string;
        if (intent.getExtras() != null) {
            string = intent.getExtras().getString("com.slideme.sam.manager.EXTRA_DESTINATION_URL");
            str = intent.getExtras().getString("com.slideme.sam.manager.EXTRA_ADSLOT_ID");
            if (intent.getExtras().getBoolean("com.slideme.sam.manager.EXTRA_OFFER_SHARE")) {
                this.f2993e = intent.getExtras().getString("com.slideme.sam.manager.EXTRA_OFFER_ID");
                this.f2994f = intent.getExtras().getDouble("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT");
            }
        } else {
            string = null;
        }
        if (!TextUtils.isEmpty(intent.getData().getQueryParameter("bundleId"))) {
            return m5176a(intent.getData().getQueryParameter("bundleId"), false, intent.getData().getQueryParameter("referrer"), string, str, this.f2993e);
        }
        if (!TextUtils.isEmpty(intent.getData().getQueryParameter("id"))) {
            return m5176a(intent.getData().getQueryParameter("id"), true, intent.getData().getQueryParameter("referrer"), string, str, this.f2993e);
        } else if (TextUtils.isEmpty(intent.getData().getQueryParameter("q"))) {
            return false;
        } else {
            return m5176a(intent.getData().getQueryParameter("q"), true, intent.getData().getQueryParameter("referrer"), string, str, this.f2993e);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f2991c = getArguments().getString("com.slideme.sam.manager.EXTRA_TOKEN");
            this.f2989a = (ApplicationHolder) getArguments().getParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER");
            this.f2992d = getArguments().getString("com.slideme.sam.manager.EXTRA_BUNDLE_ID");
            this.f2998j = Boolean.valueOf(getArguments().getBoolean("com.slideme.sam.manager.EXTRA_APP_PRIVATE"));
            if (getArguments().getBoolean("com.slideme.sam.manager.EXTRA_OFFER_SHARE")) {
                this.f2993e = getArguments().getString("com.slideme.sam.manager.EXTRA_OFFER_ID");
                this.f2994f = getArguments().getDouble("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT");
            }
        }
        if (this.f2989a == null && bundle != null) {
            bundle.setClassLoader(ApplicationHolder.class.getClassLoader());
            this.f2989a = (ApplicationHolder) bundle.getParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER");
        }
        if (this.f2989a == null) {
            this.f2990b = new C1775y();
            this.f2990b.execute(new Intent[]{getActivity().getIntent()});
        } else {
            this.f2983G = true;
        }
        if (bundle != null) {
            this.f2982F = bundle.getBoolean("com.slideme.sam.manager.STATE_WAS_BOOKMARKED");
            this.f2999k = bundle.getString("com.slideme.sam.manager.STATE_OFFER_SHARE_URL");
        }
        setHasOptionsMenu(true);
    }

    public void onResume() {
        super.onResume();
        m5193i();
        if (this.f3000l != null && this.f2989a != null) {
            this.f3000l.m5932c();
            this.f3000l.setEnabled(!m5208p());
        }
    }

    public void onPause() {
        m5196j();
        if (this.f2990b != null) {
            this.f2990b.cancel(true);
        }
        super.onPause();
    }

    public void onDestroy() {
        BookmarksCache bookmarksCache = new BookmarksCache(getActivity());
        if (!(this.f3001m == null || this.f2989a == null || this.f2982F == bookmarksCache.has(this.f2989a.app.bundleId))) {
            SAM.f2614g.m5634b(this.f2989a.app, this.f3001m.isChecked(), new C1600v());
        }
        bookmarksCache.close();
        if (this.f2979C != null) {
            this.f2979C.removeAllViews();
        }
        if (this.f2978B != null) {
            this.f2978B.m4349c();
        }
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((FlipperFragmentActivity) getActivity()).m4793a(layoutInflater.inflate(R.layout.widget_application_details_no_app, null), 3);
        return layoutInflater.inflate(R.layout.fragment_application_details, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f3001m = (ToggleButton) view.findViewById(R.id.bookmarked);
        this.f3001m.setVisibility(AuthData.m4809e(getActivity().getApplicationContext()) ? 4 : 0);
        this.f3003o = (Button) view.findViewById(R.id.reviews);
        this.f3004p = (ObservableScrollView) view.findViewById(R.id.scroller);
        this.f3006r = view.findViewById(R.id.placeholder);
        this.f3005q = view.findViewById(R.id.sticky);
        this.f2979C = (ScreenshotContainer) view.findViewById(R.id.screenshots);
        this.f3002n = (MyReview) view.findViewById(R.id.myReview);
        this.f3009u = (ReviewListView) view.findViewById(R.id.reviewList);
        this.f3007s = (ApplicationListView) view.findViewById(R.id.devAppList);
        this.f3010v = (LanguageListView) view.findViewById(R.id.languages);
        this.f3000l = (DownloadButton) view.findViewById(R.id.download);
        this.f3008t = (ApplicationListView) view.findViewById(R.id.similarAppList);
        this.f2977A = (LinearLayout) view.findViewById(R.id.adViewsContainer);
        this.f2978B = (MoPubView) view.findViewById(R.id.adview);
        this.f3011w = view.findViewById(R.id.progressContainer);
        this.f3013y = (ImageButton) view.findViewById(R.id.downloadCancel);
        this.f3012x = (ProgressBar) view.findViewById(R.id.downloadProgress);
        this.f3014z = (TextView) view.findViewById(R.id.downloadText);
        this.f2980D = (ReviewChartView) view.findViewById(R.id.reviewChart);
        if (this.f2980D != null) {
            this.f2980D.setLoading(true);
        }
        this.f2981E = (NotificationPanel) view.findViewById(R.id.notification_panel);
        if (m5192h() && VERSION.SDK_INT >= 11 && getResources().getConfiguration().orientation != 2) {
            this.f3004p.m6000a(this);
            this.f3004p.getViewTreeObserver().addOnGlobalLayoutListener(new C1761l(this));
        } else if (m5192h() && (VERSION.SDK_INT < 11 || getResources().getConfiguration().orientation == 2)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_list);
            this.f3005q.setLayoutParams(this.f3006r.getLayoutParams());
            ((FrameLayout) view.findViewById(R.id.sticky_container)).removeView(this.f3005q);
            linearLayout.addView(this.f3005q, 1);
            linearLayout.removeView(this.f3006r);
        }
        ExpandableTitledContainer expandableTitledContainer = (ExpandableTitledContainer) view.findViewById(R.id.languages_container);
        expandableTitledContainer.m5959a(new C1763m(this, expandableTitledContainer, view));
        this.f3011w.setVisibility(8);
        this.f3013y.setOnClickListener(new C1765o(this));
        if (this.f2983G) {
            m5218a(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER", this.f2989a);
        bundle.putBoolean("com.slideme.sam.manager.STATE_WAS_BOOKMARKED", this.f2982F);
        bundle.putString("com.slideme.sam.manager.STATE_OFFER_SHARE_URL", this.f2999k);
    }

    public void m5218a(Bundle bundle) {
        C0345b.m2427c().m2436a(new C0358p().m2483b(this.f2989a.app.getName()).m2484c("Activity").m2481a(this.f2989a.app.bundleId));
        if (this.f3012x == null) {
            this.f2983G = true;
            return;
        }
        if (this.f2996h != null) {
            try {
                Message obtain = Message.obtain(null, 2001);
                obtain.arg1 = Integer.valueOf(this.f2989a.app.nodeId).intValue();
                obtain.replyTo = this.f2997i;
                this.f2996h.send(obtain);
            } catch (RemoteException e) {
            }
        }
        m5185e();
        m5190g();
        m5188f();
        getActivity().supportInvalidateOptionsMenu();
        this.f2979C.m6030a(new C1945p(getActivity(), this.f2989a, (SafeViewFlipper) getView().findViewById(R.id.flipper2)));
        ((FlipperFragmentActivity) getActivity()).m4796e();
        if (bundle == null) {
            m5184d();
            return;
        }
        try {
            this.f3009u.m6021a();
            this.f3002n.m5989c();
            this.f3007s.m5906a();
            this.f3008t.m5906a();
        } catch (Exception e2) {
            m5184d();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.options_app_details, menu);
        if (this.f2989a != null && this.f2989a.app != null) {
            menu.findItem(R.id.menu_share).setVisible(!this.f2989a.app.isPrivate());
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        super.onPrepareOptionsMenu(menu);
        if (this.f2989a != null) {
            MenuItem findItem;
            C1828b installState = this.f2989a.getInstallState(getActivity());
            if (installState != C1828b.NOT_INSTALLED) {
                menu.findItem(R.id.menu_uninstall).setVisible(true);
                menu.findItem(R.id.menu_redownload).setVisible(installState == C1828b.UP_TO_DATE);
                if (AuthData.m4807c(getActivity())) {
                    menu.findItem(R.id.menu_test).setVisible(true);
                } else if (AuthData.m4806b(getActivity())) {
                    findItem = menu.findItem(R.id.menu_test);
                    String[] stringArray = getResources().getStringArray(R.array.approve_options);
                    findItem.setTitle(stringArray[0] + " / " + stringArray[1]);
                    findItem.setVisible(true);
                }
            } else {
                menu.findItem(R.id.menu_uninstall).setVisible(false);
                menu.findItem(R.id.menu_redownload).setVisible(false);
            }
            findItem = menu.findItem(R.id.menu_report);
            if (!AuthData.m4809e(getActivity())) {
                z = true;
            }
            findItem.setVisible(z);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.menu_share:
                if (this.f2989a == null || this.f2989a.app == null) {
                    C1920k.m5781a(getActivity(), (int) R.string.wait_until_app_loaded, 0).show();
                } else {
                    intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", getString(R.string.share_text, this.f2989a.app.getName()) + getString(R.string.SLIDEME_HTTP_URL) + "/node/" + this.f2989a.app.nodeId);
                    intent.setType("text/plain");
                    startActivity(Intent.createChooser(intent, null));
                }
                return true;
            case R.id.menu_uninstall:
                if (this.f2989a == null || this.f2989a.app == null) {
                    C1920k.m5781a(getActivity(), (int) R.string.wait_until_app_loaded, 0).show();
                } else {
                    intent = new Intent("android.intent.action.DELETE");
                    intent.setData(Uri.parse("package:" + this.f2989a.app.packageName));
                    startActivityForResult(intent, 0);
                }
                return true;
            case R.id.menu_redownload:
                this.f3000l.m5931b();
                return true;
            case R.id.menu_report:
                if (this.f2989a == null || this.f2989a.app == null) {
                    C1920k.m5781a(getActivity(), (int) R.string.wait_until_app_loaded, 0).show();
                } else {
                    C1629t c1629t = new C1629t();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER", this.f2989a);
                    c1629t.setArguments(bundle);
                    c1629t.show(getActivity().getSupportFragmentManager(), "report_dialog");
                }
                return true;
            case R.id.menu_gift:
                return true;
            case R.id.menu_test:
                if (this.f2989a == null || this.f2989a.app == null) {
                    C1920k.m5781a(getActivity(), (int) R.string.wait_until_app_loaded, 0).show();
                } else {
                    Intent intent2;
                    if (AuthData.m4806b(getActivity())) {
                        intent2 = new Intent(getActivity(), ApproveActivity.class);
                    } else {
                        intent2 = new Intent(getActivity(), ScorecardActivity.class);
                    }
                    intent2.putExtra("com.slideme.sam.manager.EXTRA_APPHOLDER", this.f2989a);
                    startActivity(intent2);
                }
                return true;
            default:
                return false;
        }
    }

    private boolean m5176a(String str, boolean z, String str2, String str3, String str4, String str5) {
        if (!isAdded()) {
            return false;
        }
        boolean z2 = z || (getActivity().getIntent().getExtras() != null && getActivity().getIntent().getExtras().getBoolean("com.slideme.sam.manager.EXTRA_APP_PRIVATE"));
        C1891a c1891a = new C1891a(str, z2, z, ((SAM) getActivity().getApplication()).m4780d());
        if (this.f2989a == null) {
            c1891a.m5698b();
            if (c1891a.m5697a() == null) {
                getActivity().runOnUiThread(new C1766p(this));
                return false;
            }
            Application application = (Application) c1891a.m5697a().get(0);
            application.referrer = str2;
            application.clickUrl = str3;
            application.adSlotId = str4;
            this.f2989a = new ApplicationHolder(application);
        }
        this.f2989a.downloadPrimarySynch(getActivity());
        if (!(TextUtils.isEmpty(str5) || TextUtils.isEmpty(AuthData.m4810f(getActivity())))) {
            if (SAM.f2613f.m5444a(this.f2989a.app.packageName)) {
                if (FacebookDialog.canPresentShareDialog(getActivity(), ShareDialogFeature.SHARE_DIALOG)) {
                    getActivity().runOnUiThread(new C1767q(this, str5));
                }
            }
            new C1771u(this, str5).start();
        }
        return true;
    }

    private void m5172a(String str) {
        if (TextUtils.isEmpty(this.f2999k)) {
            C1920k.m5781a(getActivity(), (int) R.string.loading, 0).show();
            SAM.f2614g.m5624a(str, AuthData.m4810f(getActivity()), new C1774x(this));
            return;
        }
        m5182c();
    }

    private void m5182c() {
        if (C1867a.f3350a.contains("advm")) {
            this.f2999k += "&advm=1";
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        String string = getString(R.string.share_text);
        intent.putExtra("android.intent.extra.TEXT", new StringBuilder(String.valueOf(string.substring(0, string.indexOf(37)) + this.f2989a.app.getName() + " ")).append(this.f2999k).toString());
        m5216a(intent);
    }

    private void m5184d() {
        if (AuthData.m4806b(getActivity())) {
            this.f2989a.app.token = "free";
        } else if (this.f2991c != null) {
            this.f2989a.app.token = this.f2991c;
        }
        this.f3002n.m5990d();
        this.f3009u.m6025a(this.f2989a.app.bundleId);
        m5173a(this.f2989a.app.vendor, this.f2989a.app.bundleId);
        m5179b(this.f2989a.app.bundleId);
        if (this.f2980D != null) {
            this.f2980D.m6011a(this.f2989a.app, getActivity());
        }
    }

    private void m5173a(String str, String str2) {
        Catalog catalog = new Catalog(((SAM) getActivity().getApplication()).m4780d());
        catalog.m5671b("pub:" + str);
        catalog.m5658a(new Sort(0, 0));
        catalog.m5684e(SAM.f2613f.m5453j());
        this.f3007s.m5910a(str2);
        this.f3007s.m5909a(catalog);
        this.f3007s.m5911b();
    }

    private void m5179b(String str) {
        Catalog catalog = new Catalog(((SAM) getActivity().getApplication()).m4780d());
        catalog.m5665a(true, str);
        catalog.m5684e(SAM.f2613f.m5453j());
        this.f3008t.m5909a(catalog);
        this.f3008t.m5911b();
    }

    private void m5185e() {
        ((TextView) getView().findViewById(R.id.vendorButton)).setText(getString(R.string.more_info_about, this.f2989a.app.getOrganization()));
        ((TextView) getView().findViewById(R.id.app_name)).setText(this.f2989a.app.getName());
        ((TextView) getView().findViewById(R.id.version)).setText(this.f2989a.getVersionText());
        ((TextView) getView().findViewById(R.id.size)).setText(" (" + C1950a.m5858a(this.f2989a.app.size) + ") ");
        ((TextView) getView().findViewById(R.id.lastUpdated)).setText(this.f2989a.getLastUpdated(getActivity()));
        ((TextView) getView().findViewById(R.id.vendor)).setText(this.f2989a.app.getOrganization());
        ((RatingBar) getView().findViewById(R.id.rating_app)).setRating(this.f2989a.getStarRating());
        ((TextView) getView().findViewById(R.id.download_count)).setText(new StringBuilder(String.valueOf(C1950a.m5857a(this.f2989a.app.analytics.downloadCount))).append(" ").append(getString(R.string.downloads)).toString());
        ((TextView) getView().findViewById(R.id.rating_count)).setText(new StringBuilder(String.valueOf(this.f2989a.app.analytics.reviewCount)).append(" ").append(getString(R.string.reviews)).toString());
        ((ExpandableTextContainer) getView().findViewById(R.id.description)).m5936a(C1950a.m5855a(this.f2989a.description));
        ((MiscAppInfo) getView().findViewById(R.id.miscAppInfo)).m5980a(this.f2989a);
        try {
            ((PermissionListView) getView().findViewById(R.id.permissions)).m6004a(new JSONArray(this.f2989a.app.compatibility.permissions));
        } catch (Throwable e) {
            C1922m.m5791a(e);
            getView().findViewById(R.id.permissions_container).setVisibility(8);
        }
        if (this.f2989a.changelog != null) {
            if (this.f2989a.changelog.getCount() == 0) {
                getView().findViewById(R.id.changelog_container).setVisibility(8);
            } else {
                ((ChangelogListView) getView().findViewById(R.id.changelog)).m5914a(this.f2989a.changelog);
                ((ChangelogListView) getView().findViewById(R.id.changelog)).m5913a();
            }
        }
        this.f2989a.setIcon((ImageView) getView().findViewById(R.id.app_icon), ImageSize.values()[getResources().getInteger(R.integer.ordinal_icon_app)], null);
        this.f3002n.m5986a(getActivity());
        this.f3002n.m5987a(this.f2989a);
        this.f3009u.m6022a(getActivity());
        this.f3009u.setVersionCode(this.f2989a.app.versionCode);
        this.f3009u.m6024a(this.f3003o);
        this.f3007s.m5907a(getActivity());
        this.f3008t.m5907a(getActivity());
        this.f3010v.m5974a(this.f2989a.app.compatibility.locales);
        this.f3000l.m5929a((ApplicationDetailsActivity) getActivity());
        this.f3000l.m5930a(this.f2989a);
        this.f3000l.setEnabled(!m5208p());
    }

    private void m5188f() {
        SAM sam = (SAM) getActivity().getApplication();
        if (SAM.f2619l.m5427a(this.f2989a.app.advertisement > 0)) {
            if (m5192h()) {
                this.f2977A.setVisibility(8);
                m5167a(this.f2978B, getString(R.string.pub_id_320x50));
                return;
            }
            m5167a(this.f2978B, getString(R.string.pub_id_300x250));
        } else if (this.f2978B != null) {
            this.f2978B.m4349c();
        }
    }

    private void m5167a(MoPubView moPubView, String str) {
        moPubView.m4344a(str);
        moPubView.m4348b("m_channel:" + ((SAM) getActivity().getApplication()).m4780d() + ",m_hps:" + (SAM.f2615h.m5512c() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO));
        moPubView.m4343a(new C1752c(this, moPubView));
        moPubView.m4346b();
    }

    private void m5190g() {
        if (!AuthData.m4809e(getActivity().getApplicationContext())) {
            BookmarksCache bookmarksCache = new BookmarksCache(getActivity());
            this.f3001m.setChecked(bookmarksCache.has(this.f2989a.app.bundleId));
            this.f2982F = bookmarksCache.has(this.f2989a.app.bundleId);
            bookmarksCache.close();
            this.f3001m.setOnCheckedChangeListener(new C1753d(this));
            this.f3001m.setOnLongClickListener(new C1754e(this));
        }
        getView().findViewById(R.id.vendorButton).setOnClickListener(new C1755f(this));
        this.f3003o.setOnClickListener(new C1756g(this));
    }

    private boolean m5192h() {
        return this.f3004p != null;
    }

    public void mo4262a() {
        this.f3005q.setTranslationY((float) Math.max(0, this.f3006r.getTop() - this.f3004p.getScrollY()));
    }

    public MyReview m5219b() {
        return this.f3002n;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        ((ReviewListView) getView().findViewById(R.id.reviewList)).m6021a();
    }

    private void m5193i() {
        IntentFilter intentFilter = new IntentFilter("com.slideme.sam.manager.ACTION_DOWNLOAD_END");
        intentFilter.addAction("com.slideme.sam.manager.ACTION_DOWNLOAD_RESTART");
        intentFilter.addAction("com.slideme.sam.manager.ACTION_SILENT_INSTALL_START");
        intentFilter.addAction("com.slideme.sam.manager.ACTION_SILENT_INSTALL_STOP");
        C0090q.m145a(getActivity()).m149a(this.f2985I, intentFilter);
        getActivity().bindService(new Intent(getActivity(), ApplicationDownloadService.class), this.f2986J, 1);
    }

    private void m5196j() {
        if (this.f2985I != null) {
            C0090q.m145a(getActivity()).m148a(this.f2985I);
        }
        getActivity().unbindService(this.f2986J);
        m5206o();
    }

    private void m5197k() {
        if (m5210q()) {
            this.f3013y.setVisibility(0);
            m5200l();
            return;
        }
        m5202m();
    }

    private void m5166a(int i, int i2, int i3, int i4) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new C1757h(this, i, i2, i4, i3));
        }
    }

    private void m5200l() {
        this.f3011w.setVisibility(0);
        if (this.f3000l != null) {
            this.f3000l.setEnabled(false);
        }
        m5203n();
    }

    private void m5202m() {
        this.f3011w.setVisibility(8);
        if (this.f3000l != null) {
            this.f3000l.setEnabled(!m5208p());
            this.f3000l.m5932c();
        }
        m5206o();
        this.f3012x.setProgress(0);
        this.f3014z.setText("");
    }

    private void m5203n() {
        this.f2988L = new Timer();
        this.f2987K = new C1758i(this);
        this.f2988L.schedule(this.f2987K, 0, 250);
    }

    private void m5206o() {
        if (this.f2988L != null) {
            this.f2988L.cancel();
        }
        this.f2988L = null;
        this.f2987K = null;
    }

    private boolean m5208p() {
        if (m5210q()) {
            return true;
        }
        if (this.f2989a.app.isCompatible || SAM.f2613f.m5453j()) {
            return false;
        }
        return true;
    }

    private boolean m5210q() {
        return this.f2996h != null && this.f2995g;
    }

    void m5216a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = getActivity().getPackageManager().queryIntentActivities(intent, 128);
        if (queryIntentActivities.size() > 1) {
            List arrayList = new ArrayList(queryIntentActivities.size());
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                if (!arrayList.contains(str) && C1918i.m5773a(str, true, true, true, true)) {
                    arrayList.add(resolveInfo.activityInfo.packageName);
                }
            }
            if (C1922m.m5794a(arrayList)) {
                for (ResolveInfo resolveInfo2 : queryIntentActivities) {
                    String str2 = resolveInfo2.activityInfo.packageName;
                    if (!arrayList.contains(str2) && C1918i.m5773a(str2, false, true, true, true)) {
                        arrayList.add(resolveInfo2.activityInfo.packageName);
                    }
                }
            }
            ListAdapter c1937h = new C1937h(getActivity(), arrayList);
            String[] split = getResources().getString(R.string.sharearn_prompt).split(" ");
            new Builder(getActivity()).setTitle(split[0] + " " + split[1]).setAdapter(c1937h, new C1759j(this, intent, arrayList)).show();
        } else if (queryIntentActivities.size() == 1) {
            m5217a(intent, ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName);
        }
    }

    public void m5217a(Intent intent, String str) {
        if (TextUtils.isEmpty(this.f2989a.app.adSlotId)) {
            this.f2989a.app.adSlotId = FitnessActivities.UNKNOWN;
        }
        C0345b.m2427c().m2433a(new ap().m2413a(str).m2416c(this.f2989a.app.getName()).m2417d(this.f2989a.app.adSlotId).m2415b(this.f2989a.app.bundleId));
        startActivityForResult(intent, 102);
    }
}
