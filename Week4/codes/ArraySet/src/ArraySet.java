import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x) {
        for (int i=0; i<size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Cannot add null");
        }

        if (contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    public int size() {
        return  size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos  < size;
        }
        public T next() {
            wizPos++;
            return items[wizPos-1];
        }
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("{");
        for (T item : this) {
            returnString.append(item.toString());
            returnString.append(",");
        }
        returnString.append("\b}"); //\b is backspace escape sequence to remove the extra comma
        return returnString.toString();
    }

    @Override
    public boolean equals (Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        ArraySet<T> o = (ArraySet<T>) other;
        if (size != o.size) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /**Set<Integer> javaSet = new HashSet<Integer>();
        javaSet.add(5);
        javaSet.add(23);
        javaSet.add(42);

        for (int i : javaSet) {
            System.out.println(i);
        }
        Iterator<Integer> seer = javaSet.iterator();
        while (seer.hasNext()) {
            System.out.println(seer.next());
        }*/

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        Iterator<Integer> aseer = aset.iterator();
        while (aseer.hasNext()) {
            System.out.println(aseer.next());
        }

        for (int i : aset) {
            System.out.println(i);
        }

        System.out.println(aset);
    }
}
