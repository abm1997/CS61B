package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements  BoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    public int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity] ;
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
     * return size of the buffer
     * */
    @Override
    public int capacity() {
        return rb.length;
    }

    /**
     * return number of items currently in the buffer
     * */
    @Override
    public int fillCount() {
        return fillCount;
    }
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new IllegalArgumentException("Ring buffer overflow");
        }
        rb[last] = x;
        last = onePlus(last);
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Ring buffer underflow");
        }
        T removedItem = rb[first];
        rb[first] = null;
        first = onePlus(first);
        fillCount--;
        return removedItem;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Ring buffer is empty");
        }
        return rb[first];
    }

    public int onePlus(int x) {
        if (x+1 == capacity()) {
            return 0;
        }
        return x+1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return  true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
        if(this.capacity() != other.capacity() || this.fillCount() != other.fillCount()) {
            return false;
        }

        int posOther = other.first;
        for (T item : this) {
            if (item != other.rb[posOther]) {
                return false;
            }
            posOther = onePlus(posOther);
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int wizPos ;
        private int count;
        public ArrayRingBufferIterator() {
            wizPos = first;
            count  = 0;
        }
        @Override
        public boolean hasNext() {
            return count < fillCount();
        }
        @Override
        public  T next() {
            T returnedItem = rb[wizPos];
            wizPos = onePlus(wizPos);
            count++;
            return returnedItem;
        }
    }
}
