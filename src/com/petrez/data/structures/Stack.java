package com.petrez.data.structures;

/**
 * Simple generic stack implementation. Provide 4 basic operation:
 * <em>pop</em>, <em>push</em>, looking for stack empty and looking for stack size.
 * @param <T> Your object for adding to stack.
 * @author Peter Shipilo
 */

public interface Stack<T> {
    T       pop();
    void    push(T item);
    boolean isEmpty();
    int     size();
}
