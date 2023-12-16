package cn.disy920.sls_uno.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Objects;

/**
 * A circle collection. <br>
 * For example: A -> B -> C -> D -> A <br>
 * But iteration on this collection won't be endless. <br>
 * You can use {@link #getEntryOf} method to get the entry object or use the origin object,
 * and then access the whole chain.
 *
 * @param <T> The type of the elements stored in this collection
 * @author SNWCreations
 */
public class Circle<T> extends AbstractCollection<T> {
    public static final class Entry<T> {
        public final T obj;
        public final Circle<T> parent;
        Entry<T> prev;
        Entry<T> next;
        private boolean disconnected;

        Entry(T obj, Circle<T> parent) {
            this.obj = obj;
            this.parent = parent;
            this.prev = this;
            this.next = this;
        }

        /*
         * Disconnect this entry from the circle.
         */
        void disconnect() {
            if (disconnected) {
                return;
            }
            parent.beforeDisconnectEntry(this);
            var prev = this.prev;
            var next = this.next;
            this.prev.next = next;
            next.prev = prev;
            disconnected = true;
            parent.size--;
        }

        public Entry<T> getPrevious() {
            return prev;
        }

        public Entry<T> getNext() {
            return next;
        }

        public boolean isDisconnected() {
            return disconnected;
        }
    }

    private final class Itr implements Iterator<T> {
        private Entry<T> cursor;
        private boolean removedCurrentOne;

        Itr() {
            cursor = origin;
        }

        @Override
        public boolean hasNext() {
            return (removedCurrentOne ? cursor : cursor.next) != origin;
        }

        @Override
        public T next() {
            if (removedCurrentOne) {
                removedCurrentOne = false;
                return cursor.obj;
            } else {
                return goToNextEntry().obj;
            }
        }

        @Override
        public void remove() {
            if (removedCurrentOne) {
                return; // nop
            }
            var old = goToNextEntry();
            old.disconnect();
            removedCurrentOne = true;
            if (--size == 0) {
                origin = null; // we just removed the origin
            }
        }

        /*
         * (non-javadoc)
         * This method will let the iterator go to the next entry and return the previous one.
         */
        private Entry<T> goToNextEntry() {
            var old = cursor;
            cursor = cursor.next;
            return old;
        }
    }

    private Entry<T> origin;
    private int size;

    @Override
    public @NotNull Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        } else {
            Entry<T> entry = new Entry<>(t, this);
            if (isEmpty()) {
                origin = entry;
            } else {
                Entry<T> tail = origin.prev;
                tail.next = entry;
                entry.next = origin;
                entry.prev = tail;
                origin.prev = entry;
            }
            size++;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return origin == null;
    }

    /**
     * Get the entry which wrapped the provided object in this collection. <br>
     *
     * @param obj The search condition
     * @return The entry, or null if not found
     */
    @Nullable
    public Entry<T> getEntryOf(T obj) {
        if (isEmpty()) {
            return null;
        }
        Entry<T> result = origin;
        do {
            if (Objects.equals(result.obj, obj)) {
                return result;
            }
            result = result.next;
        } while (result != origin);
        return null;
    }

    /*
     * Do not call Entry#disconnect in this method!
     */
    protected void beforeDisconnectEntry(Entry<T> entryBeingDisconnected) {
    }
}
