package com.petrez.data.wrappers;

/**
 * Objects which implement this interface keep user's objects for add into stack.
 * @param <T> user's object
 * @author Peter Shipilo
 */

public interface Element<T> {
    T          getItem();
    void       setItem(T item);
    Element<T> getNext();
    void       setNext(Element element);
}
