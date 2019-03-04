package com.slideme.sam.manager.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.text.format.DateFormat;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

/* compiled from: FormatUtils */
public abstract class C1950a {
    public static String m5856a(double d) {
        NumberFormat instance = NumberFormat.getInstance();
        if ((instance instanceof DecimalFormat) && VERSION.SDK_INT >= 9) {
            ((DecimalFormat) instance).setRoundingMode(RoundingMode.HALF_EVEN);
        }
        instance.setMaximumFractionDigits(2);
        instance.setMinimumFractionDigits(1);
        return instance.format(d);
    }

    public static String m5859a(Context context, Date date) {
        return DateFormat.getDateFormat(context).format(date);
    }

    public static String m5857a(int i) {
        NumberFormat instance = NumberFormat.getInstance();
        instance.setGroupingUsed(true);
        return instance.format((long) i);
    }

    public static String m5858a(long j) {
        if (j <= 0) {
            return "0B";
        }
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new StringBuilder(String.valueOf(new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)))).append(" ").append(new String[]{"B", "KB", "MB", "GB", "TB"}[log10]).toString();
    }

    public static Spanned m5855a(String str) {
        return Html.fromHtml(str.replace("\n", "<br/>"));
    }
}
