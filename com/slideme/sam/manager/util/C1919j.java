package com.slideme.sam.manager.util;

import java.util.List;

/* compiled from: SortUtils */
public abstract class C1919j {
    public static <T> void m5778a(Comparable<T>[] comparableArr, Comparable<T>[] comparableArr2) {
        C1919j.m5779a((Comparable[]) comparableArr.clone(), (Comparable[]) comparableArr2.clone(), comparableArr, comparableArr2, 0, comparableArr.length, 0);
    }

    private static <T> void m5779a(Comparable<T>[] comparableArr, Comparable<T>[] comparableArr2, Comparable<T>[] comparableArr3, Comparable<T>[] comparableArr4, int i, int i2, int i3) {
        int i4 = i2 - i;
        int i5;
        int i6;
        if (i4 < 7) {
            for (i5 = i; i5 < i2; i5++) {
                i6 = i5;
                while (i6 > i && comparableArr3[i6 - 1].compareTo(comparableArr3[i6]) > 0) {
                    C1919j.m5780a(comparableArr3, i6, i6 - 1);
                    C1919j.m5780a(comparableArr4, i6, i6 - 1);
                    i6--;
                }
            }
            return;
        }
        int i7 = i + i3;
        int i8 = i2 + i3;
        int i9 = (i7 + i8) >>> 1;
        C1919j.m5779a(comparableArr3, comparableArr4, comparableArr, comparableArr2, i7, i9, -i3);
        C1919j.m5779a(comparableArr3, comparableArr4, comparableArr, comparableArr2, i9, i8, -i3);
        if (comparableArr[i9 - 1].compareTo(comparableArr[i9]) <= 0) {
            System.arraycopy(comparableArr, i7, comparableArr3, i, i4);
            System.arraycopy(comparableArr2, i7, comparableArr4, i, i4);
            return;
        }
        i6 = i9;
        i5 = i7;
        while (i < i2) {
            if (i6 >= i8 || (i5 < i9 && comparableArr[i5].compareTo(comparableArr[i6]) <= 0)) {
                comparableArr3[i] = comparableArr[i5];
                comparableArr4[i] = comparableArr2[i5];
                i5++;
            } else {
                comparableArr3[i] = comparableArr[i6];
                comparableArr4[i] = comparableArr2[i6];
                i6++;
            }
            i++;
        }
    }

    private static void m5780a(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    public static <T> void m5777a(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int i2 = i + 1; i2 < list.size(); i2++) {
                if (list.get(i).equals(list.get(i2))) {
                    list.remove(i);
                }
            }
        }
    }
}
