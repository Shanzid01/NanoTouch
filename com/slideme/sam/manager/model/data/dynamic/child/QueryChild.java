package com.slideme.sam.manager.model.data.dynamic.child;

import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.controller.activities.market.catalog.QueryDynamicLayoutItemActivity;

public class QueryChild extends ActivityChild {
    public void click(Context context) {
        if (this.data != null && !this.data.equals("")) {
            Intent intent = new Intent(context, QueryDynamicLayoutItemActivity.class);
            intent.putExtra("com.slideme.sam.manager.EXTRA_TITLE", this.title);
            intent.putExtra("com.slideme.sam.manager.EXTRA_QUERY_DATA", this.data);
            context.startActivity(intent);
        }
    }
}
