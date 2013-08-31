package com.petrez.data.structures;

import com.petrez.data.wrappers.Node;

public interface SymbolTable<K extends Comparable<K>, V> {
    V   min();
    V   max();
    V   get(K key);
    void    add(K key, V value);
    void    add(Node<K, V> node);
    void    add(Node<K, V>[] nodes);
    void    deleteMin();
    void    deleteMax();
    void    delete(K key);
    boolean isEmpty();
}
