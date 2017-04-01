package bludau.anatol.algs.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the {@link DynamicArray} class.
 */
public class DynamicArrayTest {

    @Test
    public void sizeShouldReturnsZeroSizeForAnEmptyArray() {
        assertEquals(0, getEmptyDynamicArray().size());
    }

    @Test
    public void addShouldReturnTheAddedItem() {
        DynamicArray<Integer> array = getEmptyDynamicArray();

        Integer result = array.add(3);
        assertEquals(Integer.valueOf(3), result);
    }

    @Test
    public void capacityShouldReturnInitialSizeForObjectCreatedByDefaultConstructor() {
        assertEquals(10, getEmptyDynamicArray().capacity());
    }

    @Test
    public void capacityShouldReturnValueFromConstructorParameter() {
        DynamicArray<?> array = new DynamicArray<>(15);
        assertEquals(15, array.capacity());
    }

    @Test
    public void sizeShouldIncreaseAfterAddingNewElemetns() {
        DynamicArray<Object> array = getEmptyDynamicArray();
        array.add(new Object());
        assertEquals(1, array.size());
    }

    @Test
    public void isEmptyShouldReturnTrueForAnEmptyArray() {
        DynamicArray<?> array = getEmptyDynamicArray();
        assertTrue(array.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseForANotEmptyArray() {
        DynamicArray<Object> array = getEmptyDynamicArray();
        array.add(new Object());
        assertFalse(array.isEmpty());
    }

    @Test
    public void getShouldReturnElementInTheSpecifiedPosition() {
        DynamicArray<String> array = getFilledArray();
        assertEquals("three", array.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getShouldThrowAnIndexOutOfBoundExceptionForNegativeArgument() {
        DynamicArray<String> array = getFilledArray();
        String result = array.get(-1);
        fail("Method shouldn't return value " + result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getShouldThrowAnIndexOutOfBoundExceptionForLargeArgument() {
        DynamicArray<String> array = getFilledArray();
        String result = array.get(5);
        fail("Method should no return value " + result);
    }

    @Test
    public void setShouldSubstitudeAValueOnASpecificIndex() {
        DynamicArray<String> array = getFilledArray();
        array.set(1, "newElement");
        assertEquals(5, array.size());
        assertEquals("one", array.get(0));
        assertEquals("newElement", array.get(1));
        assertEquals("three", array.get(2));
        assertEquals("four", array.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setShouldThrowAnIndexOutOfBoundsExceptionForNegativeIndex() {
        DynamicArray<String> array = getFilledArray();
        array.set(-1, "test");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setShouldThrowAnIndexOutOfBoundsExceptionForLargeIndex() {
        DynamicArray<String> array = getFilledArray();
        array.set(20, "test");
    }

    @Test
    public void addMethodShouldExpandSize() {
        DynamicArray<String> array = new DynamicArray<>(2);
        assertEquals(2, array.capacity());
        array.add("1");
        array.add("2");
        array.add("3");

        assertEquals(4, array.capacity());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void popShouldThrowIndexOfBoundExceptionForEmptyArray() {
        Object result = getEmptyDynamicArray().pop();
        fail("Method should throw exception instead of value " + result);
    }

    @Test
    public void popShouldReturnLastElementAndRetunIt() {
        DynamicArray<String> array = fillTestArray(new DynamicArray<>(16));

        assertEquals(16, array.capacity());
        assertEquals("five", array.pop());
        assertEquals(8, array.capacity());
    }

    private DynamicArray<String> getFilledArray() {
        return fillTestArray(getEmptyDynamicArray());
    }

    private DynamicArray<String> fillTestArray(DynamicArray<String> array) {
        array.add("one");
        array.add("two");
        array.add("three");
        array.add("four");
        array.add("five");

        return array;
    }

    private <T> DynamicArray<T> getEmptyDynamicArray() {
        return new DynamicArray<>();
    }
}
