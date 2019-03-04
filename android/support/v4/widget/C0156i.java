package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: CursorFilter */
class C0156i extends Filter {
    C0148j f491a;

    C0156i(C0148j c0148j) {
        this.f491a = c0148j;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f491a.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f491a.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.f491a.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.f491a.changeCursor((Cursor) filterResults.values);
        }
    }
}
