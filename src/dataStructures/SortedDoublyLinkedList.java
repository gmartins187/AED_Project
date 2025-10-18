package dataStructures;
import dataStructures.exceptions.*;


/**
 * Sorted Doubly linked list Implementation
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 * 
 */
public class SortedDoublyLinkedList<E> implements SortedList<E> {


    /**
     *  Node at the head of the list.
     */
    private DoublyListNode<E> head;


    /**
     * Node at the tail of the list.
     */
    private DoublyListNode<E> tail;


    /**
     * Number of elements in the list.
     */
    private int currentSize;


    /**
     * Comparator of elements.
     */
    private final Comparator<E> comparator;


    /**
     * Constructor of an empty sorted double linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public SortedDoublyLinkedList(Comparator<E> comparator) {
        //TODO
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
        this.comparator = comparator;
    }


    /**
     * Returns true iff the list contains no elements.
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return currentSize==0;
    }


    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    public int size() {
        return currentSize;
    }


    /**
     * Returns an iterator of the elements in the list (in proper sequence).
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new DoublyIterator<>(head);
    }


    /**
     * Returns the first element of the list.
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMin( ) {
        //TODO
        if (size() == 0 ){
            throw new NoSuchElementException();
        }
        return head.getElement();
    }


    /**
     * Returns the last element of the list.
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMax( ) {
        //TODO
        if (size() == 0 ){
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }


    /**
     * Returns the first occurrence of the element equals to the given element in the list.
     * @return element in the list or null
     */
    public E get(E element) {
        //TODO
        if (head == null) {
            return null;
        }
        DoublyListNode<E> current = head;
        while (current != null) {
            if (comparator.compare(current.getElement(), element) == 0) {
                return current.getElement(); }
            else if (comparator.compare(current.getElement(), element) > 0) {
                current = current.getNext(); }
            else break;
        }
        return null;
    }


    /**
     * Returns true iff the element exists in the list.
     *
     * @param element to be found
     * @return true iff the element exists in the list.
     */
    public boolean contains(E element) {
        //TODO
        if (head == null) {
            return false;
        }
        DoublyListNode<E> current = head;
        while (current != null) {
            if (comparator.compare(current.getElement(), element) == 0) {
                return true; }
            else if (comparator.compare(current.getElement(), element) > 0) {
                current = current.getNext(); }
            else break;
        }
        return false;
    }


    /**
     * Inserts the specified element at the list, according to the natural order.
     * If there is an equal element, the new element is inserted after it.
     * @param element to be inserted
     */
    public void add(E element) {
        //TODO: Left as an exercise.
    }


    /**
     * Removes and returns the first occurrence of the element equals to the given element in the list.
     * @return element removed from the list or null if !belongs(element)
     */
    public E remove(E element) {
        //TODO: Left as an exercise.
        return null;
    }
}
