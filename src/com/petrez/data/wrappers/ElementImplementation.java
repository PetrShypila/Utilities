package com.petrez.data.wrappers;

/**
 * This class keeping user's object and take a reference to object which added before.
 * This class can use for Queue and Stack data structure implementation.
 * @param <T> User's object.
 * @author Peter Shipilo
 */

public class ElementImplementation<T> implements Element<T> {
    Element nextElement;
    T       item;

    public ElementImplementation (T item) {
        this.item = item;
    }

    @Override
    public T getItem() {
        return item;
    }

    @Override
    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public Element getNext() {
        return nextElement;
    }

    @Override
    public void setNext(Element nextElement) {
        this.nextElement = nextElement;
    }
}
