package dataStructures;


/**
 * Array Iterator
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
class ArrayIterator<E> implements Iterator<E> {
    private E[] elems;
    private int counter;
    private int current;
    
    public ArrayIterator(E[] elems, int counter) {
        this.elems = elems;
        this.counter = counter;
        rewind();
    }


    @Override
    public void rewind() {
        //TODO:
        this.counter = 0;
    }


    @Override
    public boolean hasNext() {
	    //TODO
        return counter>current;
    }


    @Override
    public E next() {
	    //TODO
        return elems[current++];
    }
}
