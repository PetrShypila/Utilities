package com.petrez.data.structures;

/**
 * Stack implementation based on array. Most time operation takes a constant time.
 * But sometimes, when array need to resize it takes a linear running time. This stack
 * implementation can take maximum 30mln objects.
 * @author Shipilo Peter
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T>, Iterable<T> {

    public static final int MAX_ARRAY_SIZE = 30000000;
    private T[]             objectsArray;
    private int             objectsCounter;

    public ArrayStack() {
        objectsCounter = 0;
        objectsArray   = (T[]) new Object[16];
    }

    /**
     * Getting object from the end of Queue.
     * @return user's object.
     */
    @Override
    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = objectsArray[objectsCounter - 1];
        objectsArray[objectsCounter - 1] = null;
        objectsCounter--;

        if(objectsArray.length / 4 > objectsCounter) {
            objectsArray = Arrays.copyOf(objectsArray, objectsArray.length / 2);
        }

        return item;
    }

    /**
     * Adding object to stack of Objects to the end of Queue.
     * @param item user's object.
     */
    @Override
    public void push(T item) {
        if(objectsCounter >= MAX_ARRAY_SIZE) {
            throw new ArrayIndexOutOfBoundsException();
        }
        objectsArray[objectsCounter] = item;
        objectsCounter++;

        if(objectsArray.length == objectsCounter) {
            if (objectsArray.length * 2 < MAX_ARRAY_SIZE) {
                objectsArray = Arrays.copyOf(objectsArray, objectsArray.length * 2);
            } else {
                objectsArray = Arrays.copyOf(objectsArray, MAX_ARRAY_SIZE);
            }
        }
    }

    /**
     * Looking for elements an array
     * @return true - if array empty.Else false.
     */
    @Override
    public boolean isEmpty() {
        return objectsCounter == 0;
    }

    /**
     * Method returning current value of objects in a stack (not stack size)
     * @return number of objects in a stack.
     */
    @Override
    public int size() {
        return objectsCounter;
    }

    /**
     * Method returning iterator for implement for-each statement.
     * @return Objects iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(this);
    }



    private class ArrayIterator<T> implements Iterator<T> {
        private Stack<T> arrayStack;

        private ArrayIterator(Stack<T> arrayStack) {
            this.arrayStack = arrayStack;
        }

        @Override
        public boolean hasNext() {
            return !arrayStack.isEmpty();
        }

        @Override
        public T next() {
            return arrayStack.pop();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
