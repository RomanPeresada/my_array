package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArray<T> implements Iterable {
    private static final int DEFAULT_SIZE = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private Object[] array;
    private int indexOfArray;

    public MyArray() {
        array = new Object[DEFAULT_SIZE];
    }

    public MyArray(int capacity) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException();
        } else if (capacity == 0) {
            this.array = EMPTY_ARRAY;
        } else {
            array = new Object[capacity];
        }
    }

    public T get(int index) {
        if (index < 0 && index > indexOfArray)
            throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    private void suppForCopy() {
        T[] tempArray = (T[]) new Object[(capacity() * 3) / 2 + 1];
        System.arraycopy(array, 0, tempArray, 0, size());
        array = tempArray.clone();
    }

    public void add(T element) {
        if (capacity() * 0.75 <= indexOfArray) {
            suppForCopy();
        }
        array[indexOfArray] = element;
        indexOfArray++;

    }

    public void add(int index, T element) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();
        System.arraycopy(array, index, array, index + 1, size() - index);
        array[index] = element;
        indexOfArray++;
    }

    public boolean remove(int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();
        System.arraycopy(array, index + 1, array, index, size() - index - 1);
        indexOfArray--;
        return true;
    }

    public boolean remove(T element) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element)) {
                index = i;
                break;
            }
        }
        if (index == -1)
            throw new NoSuchElementException();
        else {
            System.arraycopy(array, index + 1, array, index, size() - index - 1);
            array[indexOfArray--] = null;
            return true;
        }
    }

    public void printMyArray() {
        System.out.print("[ ");
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i));
            if (i < size() - 1)
                System.out.print(", ");
        }
        System.out.println(" ]");
    }

    public int capacity() {
        return array.length;
    }

    public int size() {
        return indexOfArray;
    }

    public void trimToSize() {
        Object[] tempArray = new Object[size()];
        System.arraycopy(array, 0, tempArray, 0, size());
        array = tempArray.clone();
    }

    public void set(int index, T element) {
        if (index < 0 && index > size())
            throw new IndexOutOfBoundsException();
        array[index] = element;
    }

    public int getIndexOfArray(T obj) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(obj))
                return i;
        }
        return -1;
    }

    public int getLastIndexOfMyArray(T obj) {
        for (int i = size() - 1; i >= 0; i--) {
            if (get(i).equals(obj))
                return i;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size() && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("not developed");
            }
        };
        return it;
    }
}
