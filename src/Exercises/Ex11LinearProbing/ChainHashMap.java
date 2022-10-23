package Exercises.Ex11LinearProbing;

import java.util.ArrayList;
import java.util.Map.Entry;

public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {
    private UnsortedArrayMap<K,V>[] table; // initialized within createTable

    public ChainHashMap() { super(); }

    public ChainHashMap(int cap) { super(cap); }

    public ChainHashMap(int cap, int p) { super(cap, p); }

    /** Creates an empty table having length equal to current capacity. */
    protected void createTable() {
        table = (UnsortedArrayMap<K,V>[]) new UnsortedArrayMap[capacity];
    }

    /** Returns value associated with key k in bucket with hash value h, or else null. */
    protected V bucketGet(int h, K k) {
        UnsortedArrayMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(k);
    }

    /** Associates key k with value v in bucket with hash value h; returns old value. */
    protected V bucketPut(int h, K k, V v) {
        UnsortedArrayMap<K,V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedArrayMap<>();
        int oldSize = bucket.size();
        V answer = bucket.put(k,v);
        n += (bucket.size() - oldSize); // size may have increased
        return answer;
    }

    /** Removes entry having key k from bucket with hash value h (if any). */
    protected V bucketRemove(int h, K k) {
        UnsortedArrayMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size()); // size may have decreased
        return answer;
    }

    /** Returns an iterable collection of all key-value entries of the map. */
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h=0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry : table[h].entrySet()) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }

    public boolean bucketContainsKey(int h, K key){
        if (table[h] != null) {
            return table[h].containsKey(key);
        }
        else{
            return false;
        }
    }
}
