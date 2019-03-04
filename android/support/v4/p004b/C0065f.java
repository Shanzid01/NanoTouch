package android.support.v4.p004b;

/* compiled from: LongSparseArray */
public class C0065f<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public C0065f() {
        this(10);
    }

    public C0065f(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = C0062c.f62b;
            this.mValues = C0062c.f63c;
        } else {
            int b = C0062c.m95b(i);
            this.mKeys = new long[b];
            this.mValues = new Object[b];
        }
        this.mSize = 0;
    }

    public C0065f<E> clone() {
        try {
            C0065f<E> c0065f = (C0065f) super.clone();
            try {
                c0065f.mKeys = (long[]) this.mKeys.clone();
                c0065f.mValues = (Object[]) this.mValues.clone();
                return c0065f;
            } catch (CloneNotSupportedException e) {
                return c0065f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E get(long j) {
        return get(j, null);
    }

    public E get(long j, E e) {
        int a = C0062c.m93a(this.mKeys, this.mSize, j);
        return (a < 0 || this.mValues[a] == DELETED) ? e : this.mValues[a];
    }

    public void delete(long j) {
        int a = C0062c.m93a(this.mKeys, this.mSize, j);
        if (a >= 0 && this.mValues[a] != DELETED) {
            this.mValues[a] = DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(long j, E e) {
        int a = C0062c.m93a(this.mKeys, this.mSize, j);
        if (a >= 0) {
            this.mValues[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.mValues[a] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                a = C0062c.m93a(this.mKeys, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.mKeys.length) {
                int b = C0062c.m95b(this.mSize + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            if (this.mSize - a != 0) {
                System.arraycopy(this.mKeys, a, this.mKeys, a + 1, this.mSize - a);
                System.arraycopy(this.mValues, a, this.mValues, a + 1, this.mSize - a);
            }
            this.mKeys[a] = j;
            this.mValues[a] = e;
            this.mSize++;
            return;
        }
        this.mKeys[a] = j;
        this.mValues[a] = e;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public long keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i];
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = e;
    }

    public int indexOfKey(long j) {
        if (this.mGarbage) {
            gc();
        }
        return C0062c.m93a(this.mKeys, this.mSize, j);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(long j, E e) {
        if (this.mSize == 0 || j > this.mKeys[this.mSize - 1]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i = this.mSize;
            if (i >= this.mKeys.length) {
                int b = C0062c.m95b(i + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            this.mKeys[i] = j;
            this.mValues[i] = e;
            this.mSize = i + 1;
            return;
        }
        put(j, e);
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            C0065f valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
