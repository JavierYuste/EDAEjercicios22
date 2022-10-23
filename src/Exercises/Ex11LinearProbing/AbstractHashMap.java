package Exercises.Ex11LinearProbing;

import Exercises.Ex9Maps.AbstractMap;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {

    protected int n = 0; // number of entries in the dictionary
    protected int capacity; // length of the table
    private int prime; // prime factor
    private long scale, shift; // the shift and scaling factors
    protected double loadFactor = 0.5;

    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random( );
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int cap) { this(cap, 109345121); } // default prime

    public AbstractHashMap() { this(17); } // default capacity

    public int size() {
        return n;
    }

    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    @Override
    public boolean containsKey(K key) {
        return bucketContainsKey(hashValue(key), key);
    }

    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity * this.loadFactor) // keep load factor <= 0.5
            resize(2 * capacity - 1); // (or find a nearby prime)
        return answer;
    }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()) * scale + shift % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for (Entry<K,V> e : entrySet( ))
            buffer.add(e);
        capacity = newCap;
        createTable( ); // based on updated capacity
        n = 0; // will be recomputed while reinserting entries
        for (Entry<K,V> e : buffer)
            put(e.getKey( ), e.getValue( ));
    }

    @Override
    public boolean containsValue(V value) {
        for (V v : this.values()) {
            if (v.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty(){
        return this.size() == 0;
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int h, K k);
    protected abstract V bucketPut(int h, K k, V v);
    protected abstract V bucketRemove(int h, K k);
    protected abstract boolean bucketContainsKey(int h, K k);
}
