package org.algorithms;

import org.algorithms.exceptions.FullSizeException;
import org.algorithms.exceptions.IndexValidException;
import org.algorithms.exceptions.NullValueException;

import java.util.Arrays;

public class IntegerListImplements implements IntegerList {

    private final int[] ints;
    private int size;

    public IntegerListImplements() {
        ints = new int[5];
    }

    public IntegerListImplements(int index) {
        ints = new int[index];
    }

    @Override
    public Integer add(int item) {
        validValue(item);
        validSize();
        ints[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, int item) {
        validValue(item);
        validSize();
        validIndex(index);
        if (index == size) {
            ints[size++] = item;
            return item;
        }
        System.arraycopy(ints, index, ints, index + 1, size - index);
        size++;
        return item;
    }

    @Override
    public Integer set(int index, int item) {
        validIndex(index);
        validValue(item);
        ints[index] = item;
        return item;
    }

    @Override
    public Integer remove(String number) {
        int item = Integer.parseInt(number);
        validValue(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validIndex(index);
        if (index != size) {
            System.arraycopy(ints, index + 1, ints, index, size - index);
        }
        size--;
        return ints[index];
    }

    private void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    @Override
    public boolean contains(int element) {
        sortSelection(ints);
        int min = 0;
        int max = ints.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == ints[mid]) {
                return true;
            }

            if (element < ints[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            Integer string = ints[i];
            if (string.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer string = ints[i];
            if (string.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validIndex(index);
        return ints[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(ints, size);
    }

    private void validValue(Integer item) {
        if (item == null) {
            throw new NullValueException("Нет информации");
        }
    }

    private void validIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexValidException("Неверное значение");
        }
    }

    private void validSize() {
        if (this.size == ints.length) {
            throw new FullSizeException("Массив переполнен");
        }
    }
}
