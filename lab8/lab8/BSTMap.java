package lab8;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by YFateen on 3/9/17.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    int mapSize;
    Node firstNode;

    @Override
    public void clear() {
        firstNode = null;
        mapSize = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKeyHelper(firstNode, key);
    }

    public boolean containsKeyHelper(Node n, K key) {
        if (n == null || n.getKey() == null) {
            return false;
        }
        if (n.getKey() == key) {
            return true;
        }
        if (n.getKey().compareTo(key) > 0) {
            return containsKeyHelper(n.getLeftNode(), key);
        } else {
            return containsKeyHelper(n.getLeftNode(), key);
        }
    }

    @Override
    public V get(K key) {
        return getHelperMethod(firstNode, key);
    }

    public V getHelperMethod(Node n, K key) {
        if (n == null || n.getKey() == null) {
            return null;
        }
        if (n.getKey() == key) {
            return n.getValue();
        }
        if (n.getKey().compareTo(key) > 0) {
            return getHelperMethod(n.getLeftNode(), key);
        } else {
            return getHelperMethod(n.getLeftNode(), key);
        }

    }

    @Override
    public int size() {
        return size(firstNode);
    }

    private int size(Node input) {
        if (input == null) {
            return (0);
        } else {
            return (size(input.getLeftNode()) + 1 + size(input.getRightNode()));
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (value == null) {
            return;
        }
        firstNode = put(firstNode, key, value);
    }

    public Node put(Node n, K key, V value) {
        if (n == null) {
            return new Node(key, value, 1);
        }
        if (key.compareTo(n.key) < 0) {
            n.leftNode = put(n.getLeftNode(), key, value);
        } else if (key.compareTo(n.key) > 0) {
            n.rightNode = put(n.rightNode, key, value);
        }
        n.value = value;
        n.size = 1 + size(n.getLeftNode()) + size(n.getRightNode());
        return n;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Error: Unsupported operation");
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Error: Unsupported operation");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("Error: Unsupported operation");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("Error: Unsupported operation");
    }

    public void printInOrder() {
        printerHelper(firstNode);
    }

    public void printerHelper(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printerHelper(node.leftNode);
            printerHelper(node.rightNode);
        }
    }

    private class Node {
        private Node leftNode;
        private Node rightNode;
        private K key;
        private V value;
        private int size;

        Node() {
            this.key = null;
            this.value = null;
            this.leftNode = null;
            this.rightNode = null;
        }

        Node(K key, V val, int size) {
            this.key = key;
            this.value = val;
            this.size = size;
        }

        public V getValue() {
            return this.value;
        }

        public K getKey() {
            return this.key;
        }

        public Node getLeftNode() {
            return this.leftNode;
        }

        public Node getRightNode() {
            return this.rightNode;
        }
    }
}
