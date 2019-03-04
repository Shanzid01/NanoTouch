package com.mopub.mobileads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import com.mopub.common.p050b.C1482e;
import com.mopub.mobileads.MraidView.ExpansionStyle;
import com.mopub.mobileads.MraidView.NativeCloseButtonStyle;
import com.mopub.mobileads.MraidView.PlacementType;
import com.mopub.mobileads.MraidView.ViewState;
import com.mopub.mobileads.util.C1559e;
import java.io.File;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* compiled from: MraidDisplayController */
class bb extends ah {
    private static final String[] f2415d = new String[]{"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    protected float f2416a;
    protected int f2417b = -1;
    protected int f2418c = -1;
    private ViewState f2419e = ViewState.HIDDEN;
    private final ExpansionStyle f2420f;
    private final NativeCloseButtonStyle f2421g;
    private MraidView f2422h;
    private FrameLayout f2423i;
    private Handler f2424j = new Handler();
    private final int f2425k;
    private bk f2426l = new bk(this);
    private ImageView f2427m;
    private boolean f2428n;
    private int f2429o;
    private FrameLayout f2430p;
    private FrameLayout f2431q;
    private RelativeLayout f2432r;

    bb(MraidView mraidView, ExpansionStyle expansionStyle, NativeCloseButtonStyle nativeCloseButtonStyle) {
        int requestedOrientation;
        super(mraidView);
        this.f2420f = expansionStyle;
        this.f2421g = nativeCloseButtonStyle;
        Context r = m4558r();
        if (r instanceof Activity) {
            requestedOrientation = ((Activity) r).getRequestedOrientation();
        } else {
            requestedOrientation = -1;
        }
        this.f2425k = requestedOrientation;
        this.f2431q = m4573i();
        this.f2432r = m4574j();
        this.f2430p = m4575k();
        m4553m();
    }

    private void m4553m() {
        this.f2419e = ViewState.LOADING;
        m4554n();
        this.f2426l.m4583a(m4558r());
    }

    private void m4554n() {
        int top;
        int i = 0;
        Context r = m4558r();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) r.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f2416a = displayMetrics.density;
        if (r instanceof Activity) {
            Window window = ((Activity) r).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            top = window.findViewById(16908290).getTop() - i;
        } else {
            top = 0;
        }
        top = (displayMetrics.heightPixels - i) - top;
        this.f2417b = (int) (((double) displayMetrics.widthPixels) * (160.0d / ((double) displayMetrics.densityDpi)));
        this.f2418c = (int) (((double) top) * (160.0d / ((double) displayMetrics.densityDpi)));
    }

    private int m4555o() {
        return ((WindowManager) m4558r().getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    private void m4535a(int i) {
        m4554n();
        m4496a().m4402a(bn.m4588a(this.f2417b, this.f2418c));
    }

    public void m4564b() {
        try {
            this.f2426l.m4582a();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
    }

    protected void m4567c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bn.m4588a(this.f2417b, this.f2418c));
        arrayList.add(bw.m4602a(m4496a().getIsVisible()));
        m4496a().m4404a(arrayList);
        this.f2419e = ViewState.DEFAULT;
        m4496a().m4402a(bo.m4590a(this.f2419e));
        m4576l();
    }

    protected void m4568d() {
        if (this.f2419e == ViewState.EXPANDED) {
            m4556p();
            m4547c(false);
            this.f2419e = ViewState.DEFAULT;
            m4496a().m4402a(bo.m4590a(this.f2419e));
        } else if (this.f2419e == ViewState.DEFAULT) {
            m4496a().setVisibility(4);
            this.f2419e = ViewState.HIDDEN;
            m4496a().m4402a(bo.m4590a(this.f2419e));
        }
        if (m4496a().m4409d() != null) {
            m4496a().m4409d().onClose(m4496a(), this.f2419e);
        }
    }

    private void m4556p() {
        m4563a(false);
        this.f2431q.removeAllViewsInLayout();
        this.f2432r.removeAllViewsInLayout();
        this.f2423i.removeView(this.f2432r);
        m4496a().requestLayout();
        ViewGroup viewGroup = (ViewGroup) this.f2430p.getParent();
        viewGroup.addView(m4496a(), this.f2429o);
        viewGroup.removeView(this.f2430p);
        viewGroup.invalidate();
    }

    protected void m4561a(String str, int i, int i2, boolean z, boolean z2) {
        if (this.f2420f != ExpansionStyle.DISABLED) {
            if (str == null || URLUtil.isValidUrl(str)) {
                this.f2423i = (FrameLayout) m4496a().getRootView().findViewById(16908290);
                m4566b(z);
                m4547c(z2);
                m4557q();
                View a = m4496a();
                if (str != null) {
                    this.f2422h = new MraidView(m4558r(), m4496a().m4398a(), ExpansionStyle.DISABLED, NativeCloseButtonStyle.AD_CONTROLLED, PlacementType.INLINE);
                    this.f2422h.m4399a(new bc(this));
                    this.f2422h.loadUrl(str);
                    a = this.f2422h;
                }
                m4536a(a, (int) (((float) i) * this.f2416a), (int) (((float) i2) * this.f2416a));
                this.f2423i.addView(this.f2432r, new LayoutParams(-1, -1));
                if (this.f2421g == NativeCloseButtonStyle.ALWAYS_VISIBLE || !(this.f2428n || this.f2421g == NativeCloseButtonStyle.ALWAYS_HIDDEN)) {
                    m4563a(true);
                }
                this.f2419e = ViewState.EXPANDED;
                m4496a().m4402a(bo.m4590a(this.f2419e));
                if (m4496a().m4409d() != null) {
                    m4496a().m4409d().onExpand(m4496a());
                    return;
                }
                return;
            }
            m4496a().m4401a(ap.EXPAND, "URL passed to expand() was invalid.");
        }
    }

    protected void m4560a(String str) {
        Context r = m4558r();
        if (!C1559e.m4667c(r)) {
            m4496a().m4401a(ap.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            Log.d("MoPub", "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
        } else if (r instanceof Activity) {
            m4549e(str);
        } else {
            m4546c("Downloading image to Picture gallery...");
            m4548d(str);
        }
    }

    private void m4546c(String str) {
        this.f2424j.post(new bd(this, str));
    }

    private void m4548d(String str) {
        File s = m4559s();
        s.mkdirs();
        new Thread(new be(this, str, s)).start();
    }

    private void m4549e(String str) {
        new Builder(m4558r()).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new bg(this, str)).setCancelable(true).show();
    }

    protected void m4565b(String str) {
        C1520p.m4376a(m4558r(), str, m4496a().m4398a());
    }

    protected void m4569e() {
        m4496a().m4401a(ap.GET_CURRENT_POSITION, "Unsupported action getCurrentPosition");
    }

    protected void m4570f() {
        m4496a().m4401a(ap.GET_DEFAULT_POSITION, "Unsupported action getDefaultPosition");
    }

    protected void m4571g() {
        m4496a().m4401a(ap.GET_MAX_SIZE, "Unsupported action getMaxSize");
    }

    protected void m4572h() {
        m4496a().m4401a(ap.GET_SCREEN_SIZE, "Unsupported action getScreenSize");
    }

    protected void m4562a(Map<String, String> map) {
        Context context = m4496a().getContext();
        if (C1559e.m4668d(context)) {
            try {
                Map b = m4541b((Map) map);
                Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                for (String str : b.keySet()) {
                    Object obj = b.get(str);
                    if (obj instanceof Long) {
                        type.putExtra(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        type.putExtra(str, ((Integer) obj).intValue());
                    } else {
                        type.putExtra(str, (String) obj);
                    }
                }
                type.setFlags(DriveFile.MODE_READ_ONLY);
                context.startActivity(type);
                return;
            } catch (ActivityNotFoundException e) {
                Log.d("MraidDisplayController", "no calendar app installed");
                m4496a().m4401a(ap.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
                return;
            } catch (IllegalArgumentException e2) {
                Log.d("MraidDisplayController", "create calendar: invalid parameters " + e2.getMessage());
                m4496a().m4401a(ap.CREATE_CALENDAR_EVENT, e2.getMessage());
                return;
            } catch (Exception e3) {
                Log.d("MraidDisplayController", "could not create calendar event");
                m4496a().m4401a(ap.CREATE_CALENDAR_EVENT, "could not create calendar event");
                return;
            }
        }
        Log.d("MraidDisplayController", "unsupported action createCalendarEvent for devices pre-ICS");
        m4496a().m4401a(ap.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
    }

    private Map<String, Object> m4541b(Map<String, String> map) {
        Map<String, Object> hashMap = new HashMap();
        if (map.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION) && map.containsKey("start")) {
            hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, map.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
            if (!map.containsKey("start") || map.get("start") == null) {
                throw new IllegalArgumentException("Invalid calendar event: start is null.");
            }
            Date f = m4550f((String) map.get("start"));
            if (f != null) {
                hashMap.put("beginTime", Long.valueOf(f.getTime()));
                if (map.containsKey("end") && map.get("end") != null) {
                    f = m4550f((String) map.get("end"));
                    if (f != null) {
                        hashMap.put("endTime", Long.valueOf(f.getTime()));
                    } else {
                        throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                    }
                }
                if (map.containsKey("location")) {
                    hashMap.put("eventLocation", map.get("location"));
                }
                if (map.containsKey("summary")) {
                    hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, map.get("summary"));
                }
                if (map.containsKey("transparency")) {
                    int i;
                    String str = "availability";
                    if (((String) map.get("transparency")).equals("transparent")) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    hashMap.put(str, Integer.valueOf(i));
                }
                hashMap.put("rrule", m4545c((Map) map));
                return hashMap;
            }
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    private Date m4550f(String str) {
        Date date = null;
        int i = 0;
        while (i < f2415d.length) {
            try {
                date = new SimpleDateFormat(f2415d[i]).parse(str);
                if (date != null) {
                    break;
                }
                i++;
            } catch (ParseException e) {
            }
        }
        return date;
    }

    private String m4545c(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.containsKey("frequency")) {
            int parseInt;
            String str = (String) map.get("frequency");
            if (map.containsKey("interval")) {
                parseInt = Integer.parseInt((String) map.get("interval"));
            } else {
                parseInt = -1;
            }
            if ("daily".equals(str)) {
                stringBuilder.append("FREQ=DAILY;");
                if (parseInt != -1) {
                    stringBuilder.append("INTERVAL=" + parseInt + ";");
                }
            } else if ("weekly".equals(str)) {
                stringBuilder.append("FREQ=WEEKLY;");
                if (parseInt != -1) {
                    stringBuilder.append("INTERVAL=" + parseInt + ";");
                }
                if (map.containsKey("daysInWeek")) {
                    str = m4551g((String) map.get("daysInWeek"));
                    if (str == null) {
                        throw new IllegalArgumentException("invalid ");
                    }
                    stringBuilder.append("BYDAY=" + str + ";");
                }
            } else if ("monthly".equals(str)) {
                stringBuilder.append("FREQ=MONTHLY;");
                if (parseInt != -1) {
                    stringBuilder.append("INTERVAL=" + parseInt + ";");
                }
                if (map.containsKey("daysInMonth")) {
                    str = m4552h((String) map.get("daysInMonth"));
                    if (str == null) {
                        throw new IllegalArgumentException();
                    }
                    stringBuilder.append("BYMONTHDAY=" + str + ";");
                }
            } else {
                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
            }
        }
        return stringBuilder.toString();
    }

    private String m4551g(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            if (parseInt2 == 7) {
                parseInt2 = 0;
            }
            if (!zArr[parseInt2]) {
                stringBuilder.append(m4540b(parseInt2) + ",");
                zArr[parseInt2] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String m4552h(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String parseInt : split) {
            int parseInt2 = Integer.parseInt(parseInt);
            if (!zArr[parseInt2 + 31]) {
                stringBuilder.append(m4544c(parseInt2) + ",");
                zArr[parseInt2 + 31] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String m4540b(int i) {
        switch (i) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                throw new IllegalArgumentException("invalid day of week " + i);
        }
    }

    private String m4544c(int i) {
        if (i != 0 && i >= -31 && i <= 31) {
            return i;
        }
        throw new IllegalArgumentException("invalid day of month " + i);
    }

    private void m4557q() {
        ViewGroup viewGroup = (ViewGroup) m4496a().getParent();
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (i < childCount && viewGroup.getChildAt(i) != m4496a()) {
                i++;
            }
            this.f2429o = i;
            viewGroup.addView(this.f2430p, i, new ViewGroup.LayoutParams(m4496a().getWidth(), m4496a().getHeight()));
            viewGroup.removeView(m4496a());
        }
    }

    private void m4536a(View view, int i, int i2) {
        int i3 = (int) ((50.0f * this.f2416a) + 0.5f);
        if (i < i3) {
            i = i3;
        }
        if (i2 < i3) {
            i2 = i3;
        }
        View view2 = new View(m4558r());
        view2.setBackgroundColor(0);
        view2.setOnTouchListener(new bh(this));
        this.f2432r.addView(view2, new LayoutParams(-1, -1));
        this.f2431q.addView(view, new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(i, i2);
        layoutParams.addRule(13);
        this.f2432r.addView(this.f2431q, layoutParams);
    }

    private void m4547c(boolean z) {
        try {
            int i;
            Activity activity = (Activity) m4558r();
            if (z) {
                i = activity.getResources().getConfiguration().orientation;
            } else {
                i = this.f2425k;
            }
            activity.setRequestedOrientation(i);
        } catch (ClassCastException e) {
            Log.d("MraidDisplayController", "Unable to modify device orientation.");
        }
    }

    protected void m4563a(boolean z) {
        if (this.f2423i != null) {
            if (z) {
                if (this.f2427m == null) {
                    Drawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{-16842919}, C1482e.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this.f2423i.getContext()));
                    stateListDrawable.addState(new int[]{16842919}, C1482e.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this.f2423i.getContext()));
                    this.f2427m = new ImageButton(m4558r());
                    this.f2427m.setImageDrawable(stateListDrawable);
                    this.f2427m.setBackgroundDrawable(null);
                    this.f2427m.setOnClickListener(new bi(this));
                }
                int i = (int) ((50.0f * this.f2416a) + 0.5f);
                this.f2431q.addView(this.f2427m, new FrameLayout.LayoutParams(i, i, 5));
            } else {
                this.f2431q.removeView(this.f2427m);
            }
            MraidView a = m4496a();
            if (a.m4410e() != null) {
                a.m4410e().onCloseButtonStateChange(a, z);
            }
        }
    }

    protected void m4566b(boolean z) {
        this.f2428n = z;
        MraidView a = m4496a();
        boolean z2 = !z;
        if (a.m4410e() != null) {
            a.m4410e().onCloseButtonStateChange(a, z2);
        }
    }

    FrameLayout m4573i() {
        return new FrameLayout(m4558r());
    }

    RelativeLayout m4574j() {
        return new RelativeLayout(m4558r());
    }

    FrameLayout m4575k() {
        return new FrameLayout(m4558r());
    }

    private Context m4558r() {
        return m4496a().getContext();
    }

    protected void m4576l() {
        Context r = m4558r();
        m4496a().m4402a(new bp().m4594b(C1559e.m4665a(r)).m4592a(C1559e.m4666b(r)).m4595c(C1559e.m4668d(r)).m4597e(C1559e.m4669e(r)).m4596d(C1559e.m4667c(r)));
    }

    private File m4559s() {
        return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private String m4534a(URI uri, HttpResponse httpResponse) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        path = new File(path).getName();
        Header firstHeader = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader == null) {
            return path;
        }
        for (String str : firstHeader.getValue().split(";")) {
            if (str.contains("image/")) {
                String str2 = "." + str.split("/")[1];
                if (path.endsWith(str2)) {
                    return path;
                }
                return new StringBuilder(String.valueOf(path)).append(str2).toString();
            }
        }
        return path;
    }
}
