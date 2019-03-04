package p006b.p007a.p008a.p009a.p010a.p013c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DependencyPriorityBlockingQueue */
public class C0244m<E extends C0243l & C0248y & C0247u> extends PriorityBlockingQueue<E> {
    final Queue<E> f843a = new LinkedList();
    private final ReentrantLock f844b = new ReentrantLock();

    public /* synthetic */ Object peek() {
        return m2004b();
    }

    public /* synthetic */ Object poll() {
        return m2006c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return m2000a(j, timeUnit);
    }

    public /* synthetic */ Object take() {
        return m1998a();
    }

    public E m1998a() {
        return m2005b(0, null, null);
    }

    public E m2004b() {
        E e = null;
        try {
            e = m2005b(1, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public E m2000a(long j, TimeUnit timeUnit) {
        return m2005b(3, Long.valueOf(j), timeUnit);
    }

    public E m2006c() {
        E e = null;
        try {
            e = m2005b(2, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public int size() {
        try {
            this.f844b.lock();
            int size = this.f843a.size() + super.size();
            return size;
        } finally {
            this.f844b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f844b.lock();
            T[] a = m2003a(super.toArray(tArr), this.f843a.toArray(tArr));
            return a;
        } finally {
            this.f844b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f844b.lock();
            Object[] a = m2003a(super.toArray(), this.f843a.toArray());
            return a;
        } finally {
            this.f844b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f844b.lock();
            int drainTo = super.drainTo(collection) + this.f843a.size();
            while (!this.f843a.isEmpty()) {
                collection.add(this.f843a.poll());
            }
            return drainTo;
        } finally {
            this.f844b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f844b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f843a.isEmpty() && drainTo <= i) {
                collection.add(this.f843a.poll());
                drainTo++;
            }
            this.f844b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f844b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f844b.lock();
            boolean z = super.contains(obj) || this.f843a.contains(obj);
            this.f844b.unlock();
            return z;
        } catch (Throwable th) {
            this.f844b.unlock();
        }
    }

    public void clear() {
        try {
            this.f844b.lock();
            this.f843a.clear();
            super.clear();
        } finally {
            this.f844b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f844b.lock();
            boolean z = super.remove(obj) || this.f843a.remove(obj);
            this.f844b.unlock();
            return z;
        } catch (Throwable th) {
            this.f844b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f844b.lock();
            boolean removeAll = super.removeAll(collection) | this.f843a.removeAll(collection);
            return removeAll;
        } finally {
            this.f844b.unlock();
        }
    }

    E m1999a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                return (C0243l) super.take();
            case 1:
                return (C0243l) super.peek();
            case 2:
                return (C0243l) super.poll();
            case 3:
                return (C0243l) super.poll(l.longValue(), timeUnit);
            default:
                return null;
        }
    }

    boolean m2001a(int i, E e) {
        try {
            this.f844b.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.f843a.offer(e);
            return offer;
        } finally {
            this.f844b.unlock();
        }
    }

    E m2005b(int i, Long l, TimeUnit timeUnit) {
        C0243l a;
        while (true) {
            a = m1999a(i, l, timeUnit);
            if (a == null || m2002a(a)) {
                return a;
            }
            m2001a(i, a);
        }
        return a;
    }

    boolean m2002a(E e) {
        return e.mo475d();
    }

    public void m2007d() {
        try {
            this.f844b.lock();
            Iterator it = this.f843a.iterator();
            while (it.hasNext()) {
                C0243l c0243l = (C0243l) it.next();
                if (m2002a(c0243l)) {
                    super.offer(c0243l);
                    it.remove();
                }
            }
        } finally {
            this.f844b.unlock();
        }
    }

    <T> T[] m2003a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
