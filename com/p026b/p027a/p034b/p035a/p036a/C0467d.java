package com.p026b.p027a.p034b.p035a.p036a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: LinkedBlockingDeque */
public class C0467d<E> extends AbstractQueue<E> implements C0466a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    transient C0472h<E> f1411a;
    transient C0472h<E> f1412b;
    final ReentrantLock f1413c;
    private transient int f1414d;
    private final int f1415e;
    private final Condition f1416f;
    private final Condition f1417g;

    public C0467d() {
        this(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public C0467d(int i) {
        this.f1413c = new ReentrantLock();
        this.f1416f = this.f1413c.newCondition();
        this.f1417g = this.f1413c.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.f1415e = i;
    }

    private boolean m2940b(C0472h<E> c0472h) {
        if (this.f1414d >= this.f1415e) {
            return false;
        }
        C0472h c0472h2 = this.f1411a;
        c0472h.f1425c = c0472h2;
        this.f1411a = c0472h;
        if (this.f1412b == null) {
            this.f1412b = c0472h;
        } else {
            c0472h2.f1424b = c0472h;
        }
        this.f1414d++;
        this.f1416f.signal();
        return true;
    }

    private boolean m2941c(C0472h<E> c0472h) {
        if (this.f1414d >= this.f1415e) {
            return false;
        }
        C0472h c0472h2 = this.f1412b;
        c0472h.f1424b = c0472h2;
        this.f1412b = c0472h;
        if (this.f1411a == null) {
            this.f1411a = c0472h;
        } else {
            c0472h2.f1425c = c0472h;
        }
        this.f1414d++;
        this.f1416f.signal();
        return true;
    }

    private E m2942f() {
        C0472h c0472h = this.f1411a;
        if (c0472h == null) {
            return null;
        }
        C0472h c0472h2 = c0472h.f1425c;
        E e = c0472h.f1423a;
        c0472h.f1423a = null;
        c0472h.f1425c = c0472h;
        this.f1411a = c0472h2;
        if (c0472h2 == null) {
            this.f1412b = null;
        } else {
            c0472h2.f1424b = null;
        }
        this.f1414d--;
        this.f1417g.signal();
        return e;
    }

    private E m2943g() {
        C0472h c0472h = this.f1412b;
        if (c0472h == null) {
            return null;
        }
        C0472h c0472h2 = c0472h.f1424b;
        E e = c0472h.f1423a;
        c0472h.f1423a = null;
        c0472h.f1424b = c0472h;
        this.f1412b = c0472h2;
        if (c0472h2 == null) {
            this.f1411a = null;
        } else {
            c0472h2.f1425c = null;
        }
        this.f1414d--;
        this.f1417g.signal();
        return e;
    }

    void m2946a(C0472h<E> c0472h) {
        C0472h c0472h2 = c0472h.f1424b;
        C0472h c0472h3 = c0472h.f1425c;
        if (c0472h2 == null) {
            m2942f();
        } else if (c0472h3 == null) {
            m2943g();
        } else {
            c0472h2.f1425c = c0472h3;
            c0472h3.f1424b = c0472h2;
            c0472h.f1423a = null;
            this.f1414d--;
            this.f1417g.signal();
        }
    }

    public void m2947a(E e) {
        if (!m2952c((Object) e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean m2950b(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0472h c0472h = new C0472h(e);
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            boolean b = m2940b(c0472h);
            return b;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean m2952c(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0472h c0472h = new C0472h(e);
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            boolean c = m2941c(c0472h);
            return c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void m2954d(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0472h c0472h = new C0472h(e);
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        while (!m2941c(c0472h)) {
            try {
                this.f1417g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean m2948a(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0472h c0472h = new C0472h(e);
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lockInterruptibly();
        while (!m2941c(c0472h)) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.f1417g.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public E m2944a() {
        E b = m2949b();
        if (b != null) {
            return b;
        }
        throw new NoSuchElementException();
    }

    public E m2949b() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            E f = m2942f();
            return f;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E m2951c() {
        E f;
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        while (true) {
            try {
                f = m2942f();
                if (f != null) {
                    break;
                }
                this.f1416f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return f;
    }

    public E m2945a(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lockInterruptibly();
        long j2 = toNanos;
        while (true) {
            try {
                E f = m2942f();
                if (f != null) {
                    reentrantLock.unlock();
                    return f;
                } else if (j2 <= 0) {
                    break;
                } else {
                    j2 = this.f1416f.awaitNanos(j2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    public E m2953d() {
        E e = m2955e();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E m2955e() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            E e = this.f1411a == null ? null : this.f1411a.f1423a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public boolean m2956e(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            for (C0472h c0472h = this.f1411a; c0472h != null; c0472h = c0472h.f1425c) {
                if (obj.equals(c0472h.f1423a)) {
                    m2946a(c0472h);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean add(E e) {
        m2947a((Object) e);
        return true;
    }

    public boolean offer(E e) {
        return m2952c((Object) e);
    }

    public void put(E e) {
        m2954d(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return m2948a(e, j, timeUnit);
    }

    public E remove() {
        return m2944a();
    }

    public E poll() {
        return m2949b();
    }

    public E take() {
        return m2951c();
    }

    public E poll(long j, TimeUnit timeUnit) {
        return m2945a(j, timeUnit);
    }

    public E element() {
        return m2953d();
    }

    public E peek() {
        return m2955e();
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            int i = this.f1415e - this.f1414d;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection == this) {
            throw new IllegalArgumentException();
        } else {
            ReentrantLock reentrantLock = this.f1413c;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.f1414d);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.f1411a.f1423a);
                    m2942f();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean remove(Object obj) {
        return m2956e(obj);
    }

    public int size() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            int i = this.f1414d;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            for (C0472h c0472h = this.f1411a; c0472h != null; c0472h = c0472h.f1425c) {
                if (obj.equals(c0472h.f1423a)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f1414d];
            int i = 0;
            C0472h c0472h = this.f1411a;
            while (c0472h != null) {
                int i2 = i + 1;
                objArr[i] = c0472h.f1423a;
                c0472h = c0472h.f1425c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            if (tArr.length < this.f1414d) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1414d);
            }
            int i = 0;
            C0472h c0472h = this.f1411a;
            while (c0472h != null) {
                int i2 = i + 1;
                tArr[i] = c0472h.f1423a;
                c0472h = c0472h.f1425c;
                i = i2;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            reentrantLock.unlock();
            return tArr;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            String str;
            C0472h c0472h = this.f1411a;
            if (c0472h == null) {
                str = "[]";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                C0472h c0472h2 = c0472h;
                while (true) {
                    Object obj = c0472h2.f1423a;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    stringBuilder.append(obj);
                    c0472h = c0472h2.f1425c;
                    if (c0472h == null) {
                        break;
                    }
                    stringBuilder.append(',').append(' ');
                    c0472h2 = c0472h;
                }
                str = stringBuilder.append(']').toString();
                reentrantLock.unlock();
            }
            return str;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            C0472h c0472h = this.f1411a;
            while (c0472h != null) {
                c0472h.f1423a = null;
                C0472h c0472h2 = c0472h.f1425c;
                c0472h.f1424b = null;
                c0472h.f1425c = null;
                c0472h = c0472h2;
            }
            this.f1412b = null;
            this.f1411a = null;
            this.f1414d = 0;
            this.f1417g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> iterator() {
        return new C0471g();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.f1413c;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (C0472h c0472h = this.f1411a; c0472h != null; c0472h = c0472h.f1425c) {
                objectOutputStream.writeObject(c0472h.f1423a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f1414d = 0;
        this.f1411a = null;
        this.f1412b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }
}
