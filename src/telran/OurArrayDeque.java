package telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurArrayDeque<E> implements OurDeque<E> {

    private static final int INITIAL_CAPACITY = 16;
    E[]source;
    int size;

    //the field points out into the first element in the data structure
    int firstIndex;

    OurArrayDeque(int initialCapacity) {
        source = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(E elt) {
        if(size == source.length) {
            increaseSource();

            int newLastIndex = (firstIndex + size)%source.length;
            source[newLastIndex] = elt;
            size ++;
        }
    }

    private void increaseSource() {
            E[] newSource = (E[]) new Object[source.length*2];
            System.arraycopy(source, firstIndex, newSource, 0,source.length-firstIndex);
            System.arraycopy(source, 0, newSource, source.length-firstIndex,firstIndex);

            firstIndex = 0;
            this.source = newSource;

//            int i = 0;
//            for (E elt : this) {
//                newSource[i++] = elt;
//            }
//            this.source = newSource;
    }

    // TODO complete
    @Override
    public void addFirst(E elt) {
        if(size==0) {
            source[firstIndex] = elt;
        } else {
            int newFirstIndex = (firstIndex-1+source.length) % source.length;
            source[newFirstIndex] = elt;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E res = source[firstIndex];
        size--;
        firstIndex = (firstIndex+1)% source.length;
        return res;
    }

    //TODO complete
    @Override
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int lastIndex = (firstIndex + size - 1)%source.length;
        E res = source[lastIndex];
        size--;
        source[lastIndex] = null;
        return res;
    }

    @Override
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return source[firstIndex];
    }

    @Override
    public E getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        int lastIndex = (firstIndex + size - 1)%source.length;
        return source[lastIndex];
    }

    @Override
    public int size() {
        return size;
    }

    //TODO the assignment of higher complexity
    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {

        E current = getFirst(); // current index
        int remaining = size(); //elements left
        E lastElement = getLast();

        public DequeIterator() {
        }

        @Override
        public boolean hasNext() {
            return remaining > 0;
        }

        @Override
        public E next() {
//            if (remaining <= 0) {
//                throw new NoSuchElementException();
//            }
//            E result = source[(int) current];
//
//            remaining--;

            return null;
        }
    }

}
