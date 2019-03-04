package com.slideme.sam.manager.net.response;

import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.Category;
import java.util.ArrayList;

public class FeedsPageResponse extends BaseNetworkResponse {
    @C0670c(a = "Catalog")
    public CatalogTag catalog;

    public class CatalogTag {
        @C0670c(a = "Applications")
        public ArrayList<Application> applications;
        @C0670c(a = "Categories")
        public ArrayList<Category> categories;
        @C0670c(a = "Count")
        public int count;
        @C0670c(a = "Page")
        public int page;
    }

    public ArrayList<Application> getApplications() {
        if (this.catalog == null || this.catalog.applications == null) {
            return new ArrayList();
        }
        return this.catalog.applications;
    }

    public ArrayList<Category> getCategories() {
        if (this.catalog == null || this.catalog.categories == null) {
            return new ArrayList();
        }
        return this.catalog.categories;
    }
}
