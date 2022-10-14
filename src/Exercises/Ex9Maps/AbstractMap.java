package Exercises.Ex9Maps;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class AbstractMap<K,V> implements Map<K,V> {

    protected static class MapEntry<K,V> implements Entry<K,V> {
        private K k; // key
        private V v; // value

        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        public K getKey() { return k; }

        public V getValue() { return v; }

        protected void setKey(K key) { k = key; }

        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }

    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();

        public boolean hasNext() {
            return entries.hasNext();
        }

        public K next() {
            return entries.next().getKey();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {

        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();

        public boolean hasNext() {
            return entries.hasNext();
        }

        public V next() {
            return entries.next().getValue();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<V> values() { return new ValueIterable(); }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }
}
