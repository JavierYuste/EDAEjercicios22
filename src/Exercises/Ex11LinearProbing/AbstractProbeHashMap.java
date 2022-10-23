package Exercises.Ex11LinearProbing;


import java.util.ArrayList;
import java.util.Map.Entry;

public abstract class AbstractProbeHashMap<K,V> extends AbstractHashMap<K,V> {

    public AbstractProbeHashMap() {
        super();
    }

    public AbstractProbeHashMap(int cap) {
        super(cap);
    }

    public AbstractProbeHashMap(int cap, int p) {
        super(cap, p);
    }

    @Override
    protected void createTable() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected V bucketGet(int h, K k) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected V bucketRemove(int h, K k) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected boolean bucketContainsKey(int h, K k) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
