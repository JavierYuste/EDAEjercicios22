package Exercises.Ex9Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class UnsortedArrayMap<K,V> extends AbstractMap<K,V> {

    private ArrayList<MapEntry<K,V>> table = new ArrayList<>( );

    public UnsortedArrayMap() {}

    private int findIndex(K key) {
        int n = table.size();
        for (int j=0; j < n; j++)
            if (table.get(j).getKey().equals(key)) {
                return j;
            }
        return -1;
    }

    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        return table.get(j).getValue();
    }

    /**
     * Associates the specified value with the specified key in this map
     * (optional operation).  If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A map
     * {@code m} is said to contain a mapping for a key {@code k} if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * {@code true}.)
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key},
     *         if the implementation supports {@code null} values.)
     */
    public V put(K key, V value) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) {
            return null;
        }
        V answer = table.get(j).getValue();
        if (j != n - 1){
            table.set(j, table.get(n - 1));
        }
        table.remove(n - 1);
        return answer;
    }

    private class EntryIterator implements Iterator<Entry<K,V>> {
        private int j=0;

        public boolean hasNext() {
            return j < table.size();
        }

        public Entry<K,V> next() {
            if (j == table.size()) {
                throw new NoSuchElementException();
            }
            return table.get(j++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator() {
            return new EntryIterator();
        }
    }

    public Iterable<Entry<K,V>> entrySet() {
        return new EntryIterable( );
    }

    /**
     * Returns {@code true} if this map contains a mapping for the specified
     * key.  More formally, returns {@code true} if and only if
     * this map contains a mapping for a key {@code k} such that
     * {@code Objects.equals(key, k)}.  (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     *         key
     */
    public boolean containsKey(K key){
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean containsValue(V value){
        for (V v : this.values()) {
            if (v.equals(value)){
                return true;
            }
        }
        return false;
    }
}
