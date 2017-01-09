package ru.ifmo.ctddev.shovkoplias.google_hash;


/**
 * Created by GShark on 10.09.2016.
 */
public abstract class AbstractKVS<K, V> {
    protected final int MAX_SIZE;
    private final int DEFAULT_MAX_SIZE = 10;

    public AbstractKVS() {
        MAX_SIZE = DEFAULT_MAX_SIZE;
    }
    protected AbstractKVS(int maxSize) {
        MAX_SIZE = maxSize;
    }

    public final int size() {
        int result = doSize();
        assert (0 <= result) && (result <= MAX_SIZE);
        return result;
    }

    public final V get(K key) {
        int size = size();
        V result = doGet(key);
        assert (size == size());
        assert firstValue() == result;
        assert firstKey() == key;
        return result;
    }

    public final void put(K key, V value) {
        int size = size();
        doPut(key, value);
        int newSize = size();
        assert (newSize >= size) && (newSize - size <= 1);
        assert firstValue() == value;
        assert firstKey() == key;
    }

    protected abstract int doSize();

    protected abstract V doGet(K key);

    protected abstract void doPut(K key, V value);

    protected abstract V firstValue();

    protected abstract K firstKey();
}
