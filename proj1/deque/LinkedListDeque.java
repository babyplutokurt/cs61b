package deque;

import net.sf.saxon.om.Item;

import java.awt.desktop.AppReopenedEvent;

public class LinkedListDeque<T> implements Deque<T>{
    public class ItemNode {
        public T item;
        public ItemNode next;
        public ItemNode prev;

        ItemNode(){
            item = null;
            prev = next = null;
        }
        ItemNode(ItemNode p, T i, ItemNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private int size;
    private ItemNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ItemNode();
        sentinel.prev = sentinel.next = sentinel;
    }

    public T getFirst() {
        return sentinel.next.item;
    }
    @Override
    public void addFirst(T item) {
        ItemNode temp = new ItemNode(sentinel, item, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size += 1;
    }
    @Override
    public void addLast(T x) {
        ItemNode temp = new ItemNode(sentinel.prev, x, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ItemNode temp = sentinel.next;
        for (int i = 0; i < size; i++){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ItemNode tmp = sentinel.next;
        sentinel.next = tmp.next;
        tmp.next.prev = sentinel;
        size--;
        return tmp.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ItemNode tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        tmp.prev.next = sentinel;
        size--;
        return tmp.item;
    }

    @Override
    public T get(int index) {
        ItemNode temp = sentinel.next;
        for (int i = 0; i < index; i ++) {
            temp = temp.next;
        }
        return temp.item;
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
        L.addLast(100);
        L.addLast(101);
        L.addLast(102);
        L.addLast(103);
        L.addLast(104);
        L.removeFirst();
        Object x = L.get(4);
        //Object m = L.printDeque();
        //System.out.println(m);
        System.out.println(x);

    }
}