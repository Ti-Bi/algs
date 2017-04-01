package bludau.anatol.algs.datastructures;

import java.util.Arrays;

/**
 * An example of a resizable array.
 *
 * @param <T> type of array elements
 */
public class DynamicArray<T> {

    /**
     * Initial capacity for the array.
     */
    private static final int INITIAL_SIZE = 10;

    /**
     * The growth factor.
     */
    private static final int GROWTH_FACTOR = 2;

    /**
     * The reduction factor.
     * Capacity will be divided by {@link #GROWTH_FACTOR} if the size became in {@link #GROWTH_FACTOR} less then the current capacity.
     */
    private static final int REDUCTION_FACTOR = 4;

    /**
     * Current size of resizable array.
     */
    private int size;

    /**
     * Array for storing data internally.
     */
    private T[] array;

    /**
     * A default constructor. Sets the capacity to the {@link #INITIAL_SIZE}.
     */
    public DynamicArray() {
        array = initArray(INITIAL_SIZE);
    }

    /**
     * Sets the capacity to a specified value.
     *
     * @param initialSize capacity which would be set
     */
    public DynamicArray(int initialSize) {
        array = initArray(initialSize);
    }

    /**
     * Adds an element in the end of Array.
     *
     * @param item element for adding
     * @return newly added element
     */
    public T add(T item) {
        if (array.length == size) {
            resize(GROWTH_FACTOR * array.length);
        }

        array[size++] = item;
        return item;
    }

    /**
     * Returns the last element from array and delete it.
     *
     * @return the last element
     */
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int indexForReturnedElement = --size;

        T result = array[indexForReturnedElement];
        array[indexForReturnedElement] = null;

        if (size <= array.length / REDUCTION_FACTOR) {
            resize(array.length / GROWTH_FACTOR);
        }

        return result;
    }

    /**
     * Returns the current size of a resizable array.
     *
     * @return the current size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity.
     *
     * @return the current capacity
     */
    public int capacity() {
        return array.length;
    }

    /**
     * Check if the array is empty.
     *
     * @return {@code true} if the arrys is empty or {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an element by its index.
     *
     * @param i index of element for returning
     * @return element for the given index
     * @throws IndexOutOfBoundsException if i is not in bounds
     */
    public T get(int i) throws IndexOutOfBoundsException {
        checkIndex(i);

        return array[i];
    }

    /**
     * Sets the element for a specified index.
     *
     * @param i    index for setting
     * @param item element for setting
     * @return the added index
     * @throws IndexOutOfBoundsException if i is not in bounds
     */
    public T set(int i, T item) throws IndexOutOfBoundsException {
        checkIndex(i);

        array[i] = item;

        return item;
    }

    /**
     * Checks if the index is in bounds.
     *
     * @param i the index
     * @throws IndexOutOfBoundsException if i is not in bounds
     */
    private void checkIndex(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Resize the array to a specified capacity.
     *
     * @param newCapacity target capacity for the array
     */
    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * Init a new array.
     *
     * @param initialSize the initial size
     * @return a newly created array
     */
    @SuppressWarnings("unchecked")
    private T[] initArray(int initialSize) {
        this.size = 0;
        return (T[]) new Object[initialSize];
    }

}
