package com.slideme.sam.manager.net.response;

import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.model.data.dynamic.child.ActivityChild;
import com.slideme.sam.manager.model.data.dynamic.child.AdProxyChild;
import com.slideme.sam.manager.model.data.dynamic.child.AppChild;
import com.slideme.sam.manager.model.data.dynamic.child.LayoutChild;
import com.slideme.sam.manager.model.data.dynamic.child.LinkChild;
import com.slideme.sam.manager.model.data.dynamic.child.QueryChild;
import com.slideme.sam.manager.model.data.dynamic.child.SetChild;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DynamicLayoutChildrenTag {
    @C0670c(a = "Activity")
    public ArrayList<ActivityChild> activity;
    @C0670c(a = "AdSlots")
    public ArrayList<AdProxyChild> adSlots;
    @C0670c(a = "App")
    public ArrayList<AppChild> app;
    @C0670c(a = "Link")
    public ArrayList<LinkChild> link;
    @C0670c(a = "Query")
    public ArrayList<QueryChild> query;
    @C0670c(a = "Set")
    public ArrayList<SetChild> set;
    protected ArrayList<LayoutChild> sortedList;

    class C18861 implements Comparator<LayoutChild> {
        C18861() {
        }

        public int compare(LayoutChild layoutChild, LayoutChild layoutChild2) {
            return layoutChild.weightIndex - layoutChild2.weightIndex;
        }
    }

    public ArrayList<LayoutChild> getSorted() {
        if (C1922m.m5794a(this.sortedList)) {
            this.sortedList = new ArrayList();
            if (!C1922m.m5794a(this.query)) {
                this.sortedList.addAll(this.query);
            }
            if (!C1922m.m5794a(this.set)) {
                this.sortedList.addAll(this.set);
            }
            if (!C1922m.m5794a(this.activity)) {
                this.sortedList.addAll(this.activity);
            }
            if (!C1922m.m5794a(this.app)) {
                this.sortedList.addAll(this.app);
            }
            if (!C1922m.m5794a(this.link)) {
                this.sortedList.addAll(this.link);
            }
            if (!C1922m.m5794a(this.adSlots)) {
                this.sortedList.addAll(this.adSlots);
            }
            Collections.sort(this.sortedList, createComparator());
        }
        return this.sortedList;
    }

    public void setSorted(ArrayList<LayoutChild> arrayList) {
        this.sortedList = arrayList;
    }

    protected Comparator<LayoutChild> createComparator() {
        return new C18861();
    }
}
