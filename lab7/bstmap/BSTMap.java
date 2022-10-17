package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable, V> implements Map61B {
    public Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean contains = containsKey(root, (K) key);
        return contains;
    }

    private boolean containsKey(Node x, K searchKey) {
        if (x == null) {
            return false;
        }
        int cmp = searchKey.compareTo(x.key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return containsKey(x.left, searchKey);
        } else {
            return containsKey(x.right, searchKey);
        }
    }

    @Override
    public Object get(Object key) {
        if (key == null)
            throw new IllegalArgumentException("calls put with a null key");
        return get(root, (K) key);
    }

    private V get(Node x, K key_value) {
        if (x == null) {
            return null;
        }
        int cmp = key_value.compareTo(x.key);
        if (cmp == 0) {
            return x.value;
        } else if (cmp > 0) {
            return get(x.right, key_value);
        } else {
            return get(x.left, key_value);
        }
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size;
        }
    }

    @Override
    public void put(Object key, Object value) {
        if (key == null)
            throw new IllegalArgumentException("calls put with a null key");
        // TODO if val == null
        root = put(root, (K) key, (V) value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = x.size + 1;
        return x;
    }

    public Node delete(){

    }

    private Node remove(Node x, K key) {
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = remove(x.left, key);
        } else if (cmp > 0) {
            x.right = remove(x.right, key);
        }
        if (x.size == 1) {
            x = null;
        } else if (x.size == 2) {
            x = new Node()
        }
    }
    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }

    @Override
    public Object remove(Object key, Object value) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }


    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }


}
