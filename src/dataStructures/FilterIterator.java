package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

/**
 * Iterator Abstract Data Type with Filter
 * Includes description of general methods for one way iterator.
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class FilterIterator<E> implements Iterator<E> {


    /**
     *  Iterator of elements to filter.
     */
    Iterator<E> iterator;


    /**
     *  Filter.
     */
    Predicate<E> filter;


    /**
     * Node with the next element in the iteration.
     */
    E nextToReturn;


    /**
     *
     * @param list to be iterated
     * @param criterion filter
     */
    public FilterIterator(Iterator<E> list, Predicate<E> criterion) {
        //TODO
        this.iterator = list;
        this.filter = filter;
        advance();
    }


    /**
     * Returns true if next would return an element
     *
     * @return true iff the iteration has more elements
     */
    public boolean hasNext() {
        //TODO
        return nextToReturn != null;
    }


    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException - if call is made without verifying pre-condition
     */
    public E next() {
        //TODO
        if(!hasNext()){
            throw new NoSuchElementException();
        }else{
            E current = nextToReturn;
            advance();
            return current;
        }
    }


    /**
     * Restarts the iteration.
     * After rewind, if the iteration is not empty, next will return the first element.
     */
    public void rewind() {
        //TODO
        iterator.rewind();
        advance();
    }


    /**
     * private method to find the next element.
     */
    private void advance() {
        nextToReturn = null;
        while (iterator.hasNext()) {
            E candidate = iterator.next();
            if (filter.check(candidate)) {
                nextToReturn = candidate;
                break;
            }
        }
    }
}
