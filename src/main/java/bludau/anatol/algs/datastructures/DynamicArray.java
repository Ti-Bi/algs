package bludau.anatol.algs.datastructures;

import java.util.Arrays;

public class DynamicArray<T> {

    public static final int INITIAL_SIZE = 10;

    private static final int GROWTH_FACTOR = 2;

    private static final int REDUCTION_FACTOR = 4;

    private int size;

    private T[] array;

    public DynamicArray() {
        array = initArray(INITIAL_SIZE);
    }

    public DynamicArray(int initialSize) {
        array = initArray(initialSize);
    }

    public T add(T item) {
        if (array.length == size) {
            resize(GROWTH_FACTOR * array.length);
        }

        array[size++] = item;
        return item;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    private T[] initArray(int initialSize) {
        this.size = 0;
        return (T[]) new Object[initialSize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int i) throws IndexOutOfBoundsException {
        checkIndex(i);

        return array[i];
    }

    public T set(int i, T item) throws IndexOutOfBoundsException {
        checkIndex(i);

        array[i] = item;

        return item;
    }

    private void checkIndex(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }

    public T pop() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        int indexForReturnedElement = --size;

        T result = array[indexForReturnedElement];
        array[indexForReturnedElement] = null;

        if (size <= array.length / REDUCTION_FACTOR){
            resize(array.length / GROWTH_FACTOR);
        }

        return result;
    }
}
