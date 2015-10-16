package com.petrez.data.structures;

/**
 * Simple stack implementation based on Linked list. Have no fixed size.
 * All operation takes a constant time.
 * @param <Item> User's object which will add to stack.
 * @author Peter Shipilo
 */

import com.petrez.data.wrappers.Element;
import com.petrez.data.wrappers.ElementImplementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T>, Iterable<T> {

    /**
     * Top of stack.
     */
    private Element<T> firstInStack;

    /**
     * Objects counter in a stack.
     */
    private int itemsCounter;

    /**
     * Create empty stack.
     */
    public LinkedListStack() {
        itemsCounter = 0;
        firstInStack = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(firstInStack);
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = firstInStack.getItem();
        firstInStack = firstInStack.getNext();
        itemsCounter--;
        return item;
    }

    @Override
    public void push(T item) {
        Element oldFirst = firstInStack;
        firstInStack = new ElementImplementation<T>(item);
        firstInStack.setNext(oldFirst);
        itemsCounter++;
    }

    @Override
    public boolean isEmpty() {
        return firstInStack == null;
    }

    /**
     * Looking for stack size.
     * @return Current stack size.
     */
    @Override
    public int size() {
        return itemsCounter;
    }



    private class LinkedListIterator<T> implements Iterator<T> {

        private Element<T> currentInStack;

        private LinkedListIterator (Element<T> element) {
            this.currentInStack = element;
        }

        @Override
        public boolean hasNext() {
            return currentInStack != null;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = currentInStack.getItem();
            currentInStack = currentInStack.getNext();
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
