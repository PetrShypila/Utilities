package com.petrez.data.structures;

import com.petrez.data.wrappers.Node;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
    Value   min();
    Value   max();
    Value   get(Key key);
    void    add(Key key, Value value);
    void    add(Node<Key, Value> node);
    void    add(Node<Key, Value>[] nodes);
    void    deleteMin();
    void    deleteMax();
    void    delete(Key key);
    boolean isEmpty();
}
