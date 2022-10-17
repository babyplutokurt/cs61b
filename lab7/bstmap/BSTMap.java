package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable, V> implements Map61B {
    int size = 0;
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

    }

    @Override
    public boolean containsKey(Object key) {
        return  containsKey(root, (K) key);
    }

    private boolean containsKey(Node x, K key_value) {
         if (x == null) {
             return false;
         }
         int cmp = key_value.compareTo(x.key);
         if (cmp == 0) {
             return true;
         } else if (cmp < 0) {
             return containsKey(x.right, key_value);
         } else {
             return  containsKey(x.left, key_value);
         }
    }

    @Override
    public Object get(Object key) {
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
        return 0;
    }

    @Override
    public void put(Object key, Object value) {
    }

    private void put(Node x, K key, V value) {

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
