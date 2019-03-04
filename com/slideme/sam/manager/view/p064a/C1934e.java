package com.slideme.sam.manager.view.p064a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Category;
import com.slideme.sam.manager.model.p054b.C1830d;
import com.slideme.sam.manager.view.C1950a;
import com.slideme.sam.manager.view.p064a.p065a.C1926d;
import com.slideme.sam.manager.view.touchme.BeveledRelativeLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: CategoryExpandableListAdapter */
public class C1934e extends BaseExpandableListAdapter {
    private HashMap<Integer, ArrayList<Category>> f3544a;
    private ArrayList<Category> f3545b = new ArrayList();
    private C1926d f3546c;
    private LayoutInflater f3547d;
    private ArrayList<View> f3548e;

    public C1934e(Activity activity) {
        this.f3546c = new C1926d(activity);
        this.f3547d = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public Object getChild(int i, int i2) {
        int groupId = (int) getGroupId(i);
        if (this.f3544a == null || this.f3544a.get(Integer.valueOf(groupId)) == null) {
            return null;
        }
        return ((ArrayList) this.f3544a.get(Integer.valueOf(groupId))).get(i2);
    }

    public long getChildId(int i, int i2) {
        int groupId = (int) getGroupId(i);
        if (this.f3544a == null && this.f3544a.get(Integer.valueOf(groupId)) == null) {
            return 0;
        }
        return (long) ((Category) ((ArrayList) this.f3544a.get(Integer.valueOf(groupId))).get(i2)).categoryId;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null || !view.getTag(R.id.gender).equals("child_view")) {
            view = null;
        }
        View a = this.f3546c.m5819a(i2, (Category) getChild(i, i2), view, null);
        a.setTag(R.id.gender, "child_view");
        return a;
    }

    public int getChildrenCount(int i) {
        int groupId = (int) getGroupId(i);
        if (this.f3544a == null || this.f3544a.get(Integer.valueOf(groupId)) == null) {
            return 0;
        }
        return ((ArrayList) this.f3544a.get(Integer.valueOf(groupId))).size();
    }

    public Object getGroup(int i) {
        return ((ArrayList) this.f3544a.get(Integer.valueOf(0))).get(i);
    }

    public int getGroupCount() {
        if (this.f3544a == null || this.f3544a.get(Integer.valueOf(0)) == null) {
            return 0;
        }
        return ((ArrayList) this.f3544a.get(Integer.valueOf(0))).size();
    }

    public long getGroupId(int i) {
        if (this.f3544a == null || this.f3544a.get(Integer.valueOf(0)) == null) {
            return -1;
        }
        return (long) ((Category) ((ArrayList) this.f3544a.get(Integer.valueOf(0))).get(i)).categoryId;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        View inflate;
        if (view == null || !view.getTag(R.id.gender).equals("group_view")) {
            view2 = null;
        } else {
            view2 = view;
        }
        if (view2 == null) {
            inflate = this.f3547d.inflate(R.layout.listitem_category_group, null);
        } else {
            inflate = view2;
        }
        ((ImageView) inflate.findViewById(R.id.category_icon)).setImageResource(C1830d.m5505a(((Category) getGroup(i)).categoryId));
        ((TextView) inflate.findViewById(R.id.category_display_name)).setText(((Category) getGroup(i)).name);
        inflate.setTag(R.id.gender, "group_view");
        return inflate;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void m5840a(ArrayList<Category> arrayList) {
        if (this.f3544a == null) {
            this.f3544a = new HashMap();
        } else {
            this.f3544a.clear();
        }
        if (!(this.f3545b == null || this.f3545b.size() == 0)) {
            this.f3545b.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Category category = (Category) it.next();
            if (!this.f3544a.containsKey(Integer.valueOf(category.parentId))) {
                this.f3544a.put(Integer.valueOf(category.parentId), new ArrayList(10));
            }
            ((ArrayList) this.f3544a.get(Integer.valueOf(category.parentId))).add(category);
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            category = (Category) it.next();
            if (category.parentId == 0 && this.f3544a.get(Integer.valueOf(category.categoryId)) == null) {
                ((ArrayList) this.f3544a.get(Integer.valueOf(0))).remove(category);
                this.f3545b.add(category);
            }
        }
        for (ArrayList sort : this.f3544a.values()) {
            Collections.sort(sort, new C1935f(this));
        }
    }

    public void m5839a(ExpandableListView expandableListView) {
        if (this.f3548e == null) {
            this.f3548e = new ArrayList();
        } else {
            Iterator it = this.f3548e.iterator();
            while (it.hasNext()) {
                expandableListView.removeFooterView((View) it.next());
            }
            this.f3548e.clear();
        }
        Iterator it2 = this.f3545b.iterator();
        while (it2.hasNext()) {
            Category category = (Category) it2.next();
            View frameLayout = new FrameLayout(expandableListView.getContext());
            BeveledRelativeLayout beveledRelativeLayout = (BeveledRelativeLayout) this.f3547d.inflate(R.layout.listitem_category_group, null);
            ((ImageView) beveledRelativeLayout.findViewById(R.id.category_icon)).setImageResource(C1830d.m5505a(category.categoryId));
            ((TextView) beveledRelativeLayout.findViewById(R.id.category_display_name)).setText(C1950a.m5855a(category.name));
            frameLayout.setOnClickListener(new C1936g(this, category));
            frameLayout.addView(beveledRelativeLayout);
            frameLayout.setForeground(frameLayout.getContext().getResources().getDrawable(R.drawable.bg_clickable_borderless));
            this.f3548e.add(frameLayout);
            expandableListView.addFooterView(frameLayout);
        }
    }
}
