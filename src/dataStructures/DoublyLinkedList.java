package dataStructures;
import dataStructures.exceptions.InvalidPositionException;
import dataStructures.exceptions.NoSuchElementException;


/**
 * Implementation of Doubly Linked List
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class DoublyLinkedList<E> implements TwoWayList<E> {


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
     * Constructor of an empty double linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public DoublyLinkedList( ) {
        //TODO
        this.currentSize = 0;
        this.tail = null;
        this.head = null;
    }


    /**
     * Returns true iff the list contains no elements.
     * @return true if list is empty
     */
    public boolean isEmpty() {
        //TODO
        return currentSize == 0;
    }


    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    public int size() {
        //TODO
        return currentSize;
    }


    /**
     * Returns a two-way iterator of the elements in the list.
     *
     * @return Two-Way Iterator of the elements in the list
     */
    public TwoWayIterator<E> twoWayiterator() {
        return new TwoWayDoublyIterator<>(head, tail);
    }


    /**
     * Returns an iterator of the elements in the list (in proper sequence).
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new DoublyIterator<>(head);
    }


    /**
     * Inserts the element at the first position in the list.
     * @param element - Element to be inserted
     */
    public void addFirst( E element ) {
        //TODO
        DoublyListNode<E> node = new DoublyListNode<>(element);
        if(isEmpty()){
            this.head = node;
            this.tail = node;
            this.currentSize++;
        } else {
            node.setNext(this.head);
            this.head.setPrevious(node);
            this.head = node;
            this.currentSize++;
        }
    }


    /**
     * Inserts the element at the last position in the list.
     * @param element - Element to be inserted
     */
    public void addLast( E element ) {
        //TODO
        DoublyListNode<E> node = new DoublyListNode<>(element);
        if(isEmpty()){
            this.head = node;
            this.tail = node;
            this.currentSize++;
        } else{
            node.setPrevious(this.tail);
            this.tail.setNext(node);
            this.tail = node;
            this.currentSize++;
        }
    }


    /**
     * Returns the first element of the list.
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getFirst( ) {
        //TODO
        if(size() == 0)
            throw new NoSuchElementException();
        return this.head.getElement();
    }


    /**
     * Returns the last element of the list.
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getLast( ) {
        //TODO
        if(size() == 0)
            throw new NoSuchElementException();
        return this.tail.getElement();
    }


    /**
     * This method iterates the whole doublyLinkedList and return the node
     * based on the position.
     * @param position the position searching
     * @return the node from the position
     */
    private DoublyListNode<E> getNode(int position) {

        DoublyListNode<E> node = head;
        for (int i = 0; i < position; i++)
            node = node.getNext();
        return node;
    }


     /**
     * Returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, get corresponds to getFirst.
     * If the specified position is size()-1, get corresponds to getLast.
     * @param position - position of element to be returned
     * @return element at position
     * @throws InvalidPositionException if position is not valid in the list
     */
    public E get( int position ) {
        //TODO
        if(position >= size() || position < 0) {
            throw new InvalidPositionException();
        } else {

            return getNode(position).getElement();
        }
    }


    /**
     * Returns the position of the first occurrence of the specified element
     * in the list, if the list contains the element.
     * Otherwise, returns -1.
     * @param element - element to be searched in list
     * @return position of the first occurrence of the element in the list (or -1)
     */
    public int indexOf( E element ) {
        //TODO
        DoublyListNode<E> node = this.head;
        for (int i=0; i<size(); i++) {
            if(node.getElement().equals(element))
                return i;
            else
                node = node.getNext();
        }
        return -1;
    }


    /**
     * Inserts the specified element at the specified position in the list.
     * Range of valid positions: 0, ..., size().
     * If the specified position is 0, add corresponds to addFirst.
     * If the specified position is size(), add corresponds to addLast.
     * @param position - position where to insert element
     * @param element - element to be inserted
     * @throws InvalidPositionException - if position is not valid in the list
     */
    public void add( int position, E element ) {
        //TODO
        if(position>size() || position<0){
            throw new InvalidPositionException();
        } else if(position==0){
            addFirst(element);
        } else if(position==size()){
            addLast(element);
        } else{
            DoublyListNode<E> current = getNode(position);
            DoublyListNode<E> previous = current.getPrevious();
            DoublyListNode<E> newNode = new DoublyListNode<>(element, previous, current);

            previous.setNext(newNode);
            current.setPrevious(newNode);
            this.currentSize++;
        }
    }


    /**
     * Removes and returns the element at the first position in the list.
     * @return element removed from the first position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeFirst( ) {
        //TODO
        if(size() == 0){
            throw new NoSuchElementException();
        } else{
            E node = this.head.getElement();
            if (this.currentSize == 1) {
                this.currentSize = 0;
                this.tail = null;
                this.head = null;
            }else{
                this.head.getNext().setPrevious(null);
                this.head = this.head.getNext();
                this.currentSize--;
            }
            return node;
        }
    }


    /**
     * Removes and returns the element at the last position in the list.
     * @return element removed from the last position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeLast( ) {
        //TODO
        if(size() == 0){
            throw new NoSuchElementException();
        } else {
            E element = this.tail.getElement();
            if (currentSize == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.getPrevious();
                this.tail.setNext(null);
            }
            this.currentSize--;
            return element;
        }
    }


    /**
     *  Removes and returns the element at the specified position in the list.
     * Range of valid positions: 0, ..., size()-1.
     * If the specified position is 0, remove corresponds to removeFirst.
     * If the specified position is size()-1, remove corresponds to removeLast.
     * @param position - position of element to be removed
     * @return element removed at position
     * @throws InvalidPositionException - if position is not valid in the list
     */
    public E remove( int position ) {
        //TODO
        if (position < 0 || position >= size())
            throw new InvalidPositionException();

        DoublyListNode<E> node = getNode(position);
        E element = node.getElement();

        if (node.getPrevious() == null) {
            head = node.getNext();

            if (head != null)
                head.setPrevious(null);
            else
                tail = null;
        }
        else if (node.getNext() == null) {
            tail = node.getPrevious();

            if (tail != null)
                tail.setNext(null);
        }
        else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }

        currentSize--;
        return element;
    }
}
