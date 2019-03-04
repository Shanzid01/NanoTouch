package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;

public class PermissionListView extends LinearLayout {
    private JSONArray f3723a = new JSONArray();
    private HashMap<String, ArrayList<PermissionInfo>> f3724b = new HashMap();
    private int f3725c;

    public PermissionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6001b();
    }

    private void m6001b() {
        setOrientation(1);
        setGravity(17);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.secondaryDivider});
        this.f3725c = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
    }

    public void m6004a(JSONArray jSONArray) {
        this.f3723a = jSONArray;
        m6002c();
        m6003a();
    }

    public void m6003a() {
        removeAllViews();
        if (this.f3723a == null || this.f3723a.length() <= 0) {
            View textView = new TextView(getContext());
            textView.setLayoutParams(new LayoutParams(-2, -2));
            textView.setText(R.string.permissions_default);
            textView.setGravity(1);
            textView.setTextAppearance(getContext(), R.style.TextAppearance.Medium.Slideme);
            int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, getContext().getResources().getDisplayMetrics());
            textView.setPadding(0, applyDimension, 0, applyDimension);
            addView(textView);
            return;
        }
        PackageManager packageManager = getContext().getPackageManager();
        for (String str : this.f3724b.keySet()) {
            ArrayList arrayList = (ArrayList) this.f3724b.get(str);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuilder.append(Html.fromHtml("&#8226;"));
                stringBuilder.append(((PermissionInfo) arrayList.get(i)).loadLabel(packageManager));
                if (i != arrayList.size() - 1) {
                    stringBuilder.append("\n");
                }
            }
            ViewGroup viewGroup = (ViewGroup) inflate(getContext(), R.layout.permission_item, null);
            ((TextView) viewGroup.findViewById(R.id.permLab)).setText(str);
            ((TextView) viewGroup.findViewById(R.id.permDesc)).setText(stringBuilder.toString().trim());
            addView(viewGroup);
        }
    }

    private void m6002c() {
        PackageManager packageManager = getContext().getPackageManager();
        for (int i = 0; i < this.f3723a.length(); i++) {
            try {
                PermissionInfo permissionInfo = packageManager.getPermissionInfo(this.f3723a.getString(i), 128);
                String charSequence = packageManager.getPermissionGroupInfo(permissionInfo.group, 128).loadLabel(packageManager).toString();
                if (this.f3724b.containsKey(charSequence)) {
                    ((ArrayList) this.f3724b.get(charSequence)).add(permissionInfo);
                } else {
                    this.f3724b.put(charSequence, new ArrayList());
                    ((ArrayList) this.f3724b.get(charSequence)).add(permissionInfo);
                }
            } catch (Throwable e) {
                C1922m.m5791a(e);
            } catch (Throwable e2) {
                C1922m.m5791a(e2);
            }
        }
    }
}
