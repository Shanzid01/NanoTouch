package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final int zzXH;
    private int zzXI;
    private final int zzXJ;
    private final List<DataBuffer<T>> zzXK;
    private final LayoutInflater zzXL;
    private boolean zzXM;

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.zzXM = true;
        this.mContext = context;
        this.zzXI = i;
        this.zzXH = i;
        this.zzXJ = i2;
        this.zzXK = list;
        this.zzXL = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, (List) list);
    }

    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    private View zza(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.zzXL.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.zzXJ == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.zzXJ);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            zzw.zza("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.zzXK.add(dataBuffer);
        if (this.zzXM) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer release : this.zzXK) {
            release.release();
        }
        this.zzXK.clear();
        if (this.zzXM) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer count : this.zzXK) {
            i = count.getCount() + i;
        }
        return i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzXI);
    }

    public T getItem(int i) {
        int i2 = i;
        for (DataBuffer dataBuffer : this.zzXK) {
            int count = dataBuffer.getCount();
            if (count <= i2) {
                i2 -= count;
            } else {
                try {
                    return dataBuffer.get(i2);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzXH);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zzXM = true;
    }

    public void setDropDownViewResource(int i) {
        this.zzXI = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.zzXM = z;
    }
}
