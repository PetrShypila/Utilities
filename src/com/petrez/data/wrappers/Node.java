package com.petrez.data.wrappers;

/**
 * Class wrap key and value. Using as element in
 * <i>Symbol Table</i> data structure.
 * @param <K> Key
 * @param <V> Value
 */

public class Node<K extends Comparable<K>, V> {

    public final K    KEY;
    private      V    value;
    private      Node left;
    private      Node right;

    public Node(K key, V value) {
        if(key == null || value == null)
            throw new NullPointerException("Key or value can't be NULL");
        this.KEY   = key;
        this.value = value;
        this.left  = null;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public V getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(V value) {
        this.value = value;
    }
}