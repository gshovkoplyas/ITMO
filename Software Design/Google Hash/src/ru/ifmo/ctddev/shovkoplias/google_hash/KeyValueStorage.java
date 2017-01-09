package ru.ifmo.ctddev.shovkoplias.google_hash;

import javax.xml.soap.Node;
import java.util.HashMap;

/**
 * Created by GShark on 10.09.2016.
 */
public class KeyValueStorage<K, V> extends AbstractKVS<K, V> {
    private HashMap<K, Node> nodes = new HashMap<K, Node>();
    private Node<K, V> first;

    @Override
    protected int doSize() {
        return nodes.size();
    }

    @Override
    protected V doGet(K key) {
        if (!nodes.containsKey(key)) {
            return null;
        }
        Node<K, V> gettable = nodes.get(key);
        splay(gettable);
        return gettable.value;
    }

    private void splay(Node<K, V> gettable) {
        Node<K, V> prev = gettable.prev;
        Node<K, V> next = gettable.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        gettable.prev = null;
        gettable.next = first;
        first = gettable;
    }

    @Override
    protected void doPut(K key, V value) {
        if (!nodes.containsKey(key)) {
            Node<K, V> puttable = new Node(key, value, null, first);
            first = puttable;
            nodes.put(key, puttable);
        } else {
            Node<K, V> puttable = nodes.get(key);
            puttable.value = value;
            splay(puttable);
        }
        if (doSize() > MAX_SIZE) {
            Node<K, V> cur = first;
            int cnt = 1;
            while (cur.next != null) {
                cur = cur.next;
                cnt++;
            }
            assert (cnt == doSize());
            nodes.remove(cur.key);
            cur.prev.next = null;
        }
    }

    @Override
    protected V firstValue() {
        if (first == null) {
            return null;
        }
        return first.value;
    }

    @Override
    protected K firstKey() {
        if (first == null) {
            return null;
        }
        return first.key;
    }

    private class Node<K, V> {
        Node prev;
        Node next;
        final K key;
        V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }

    }

    public KeyValueStorage() {
    }

    public KeyValueStorage(int maxSize) {
        super(maxSize);
    }
}
