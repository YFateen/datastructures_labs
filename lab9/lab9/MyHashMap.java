package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by YFateen on 3/16/17.
 */
public class MyHashMap<K, V> implements Map61B<K, V> {
    private static double loadFactor = .75;
    private final int initialSize;
    private HashSet theSet;
    private int mapCount = 0;
    private LinkedList[] mainMap;


    public MyHashMap() {
        this(100);
    }

    public MyHashMap(int size) {
        this(size, loadFactor);
    }

    public MyHashMap(int size, double load) {
        initialSize = size;
        mainMap = new LinkedList[1000];
        for (int i = 0; i < 1000; i++) {
            mainMap[i] = new LinkedList();
        }
        loadFactor = load;
        theSet = new HashSet(initialSize);
    }

    @Override
    public void clear() {
        mainMap = null;
        theSet = null;
    }

    @Override
    public boolean containsKey(K key) {
        return theSet.contains(key);
    }

    @Override
    public V get(K key) {
        return (V) mainMap[hashFunction(key)].get(0);
    }

    @Override
    public int size() {
        return mapCount;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        mapCount++;
        theSet.add(key);
        mainMap[hashFunction(key)].add(value);

    }

    private int hashFunction(K key) {
        int hashKey = Math.abs(key.hashCode());
        hashKey = hashKey % 1000;
        return hashKey;
    }

    @Override
    public Set keySet() {
        return theSet;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("ERROR: Unimplemented Method.");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("ERROR: Unimplemented Method.");
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("ERROR: Unimplemented Method.");
    }

//    private class oinedData {
//        private K key;
//        private V value;
//
//        joinedData(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public K getKey() {
//            return this.key;
//        }
//
//        public V getValue() {
//            return this.value;
//        }
//    }
}
