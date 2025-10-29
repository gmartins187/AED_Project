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
     * Node at the head of the list.
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
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }


    /**
     * Returns the number of elements in the list.
     *
     * @return number of elements in the list
     */
    public int size() {
        return currentSize;
    }


    /**
     * Returns an iterator of the elements in the list (in proper sequence).
     *
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new DoublyIterator<>(head);
    }


    /**
     * Returns the first element of the list.
     *
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMin() {
        //TODO
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return head.getElement();
    }


    /**
     * Returns the last element of the list.
     *
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMax() {
        //TODO
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }


    /**
     * Returns the first occurrence of the element equals to the given element in the list.
     *
     * @return element in the list or null
     */
    public E get(E element) {
        //TODO
        if (head == null) {
            return null;
        }
        DoublyListNode<E> current = head;
        while (current != null) {
            if(current.equals(element))
                return current.getElement();
            else if(current.getNext() == null)
                current = current.getNext();
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
        DoublyListNode<E> current = head;
        while (current != null) {
            int cmp = compareElements(current.getElement(), element);

            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                break;
            } else {
                current = current.getNext();
            }
        }
        return false;
    }


    /**
     * Inserts the specified element at the list, according to the natural order.
     * If there is an equal element, the new element is inserted after it.
     *
     * @param element to be inserted
     */
    public void add(E element) {
        DoublyListNode<E> newNode = new DoublyListNode<>(element);

        // 1. Handle the empty list case
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentSize++;
            return;
        }

        // 2. Find the correct insertion point
        DoublyListNode<E> current = head;
        while (current != null) {
            int comparison = compareElements(element, current.getElement());

            if (comparison < 0) {
                // Found the spot: element < current.getElement()
                // We must insert *before* the 'current' node.
                break;
            }

            // If comparison >= 0 (element is greater or equal),
            // we keep moving forward. This naturally finds the spot
            // after any duplicates.
            current = current.getNext();
        }

        // 3. Insert the node (this logic from your code is correct)
        if (current == head) {
            // Insert at head
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } else if (current == null) {
            // Insert at tail
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        } else {
            // Insert in middle (before 'current')
            DoublyListNode<E> previous = current.getPrevious();
            newNode.setNext(current);
            newNode.setPrevious(previous);
            previous.setNext(newNode);
            current.setPrevious(newNode);
        }
        currentSize++;
    }


    /**
     * Removes and returns the first occurrence of the element equals to the given element in the list.
     *
     * @return element removed from the list or null if !belongs(element)
     */
    public E remove(E element) {
        //TODO
        if (head == null) {
            return null;
        }
        DoublyListNode<E> current = head;
        int comparison;
        while (current != null) {
            comparison = compareElements(element, current.getElement());

            if (comparison == 0) {
                break;
            }

            if (comparison < 0) {
                return null;
            }
            current = current.getNext();
        }
        if (current == null) {
            return null;
        }
        E elementRemoved = current.getElement();
        DoublyListNode<E> previous = current.getPrevious();
        DoublyListNode<E> next = current.getNext();
        if (current == head) {
            head = next;
            if (head != null) {
                head.setPrevious(null);
            } else {
                tail = null;
            }
        }
        else if (current == tail) {
            tail = previous;
            tail.setNext(null);
        }
        else {
            previous.setNext(next);
            next.setPrevious(previous);
        }
        currentSize--;
        return elementRemoved;
    }


    /**
     * Compares elements using comparator.
     * If comparator is null, uses natural order.
     * @param element1 first element.
     * @param element2 second element.
     * @return negative value if first is less than second, zero if first is equal to second
     * or positive value if first is greater than second.
     */
    private int compareElements(E element1, E element2) {
        return comparator.compare(element1, element2);
    }
}
