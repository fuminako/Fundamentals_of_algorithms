package org.algorithms;

import org.algorithms.exceptions.IndexValidException;
import org.algorithms.exceptions.NullValueException;

import java.util.Arrays;

public class IntegerListImplements implements IntegerList {

    private int[] ints;
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
        grow();
        ints[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, int item) {
        validValue(item);
        grow();
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

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    @Override
    public boolean contains(int element) {
        quickSort(ints, 0, ints.length - 1);
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

    private void grow() {
        if (this.size == ints.length) {
            ints = Arrays.copyOf(ints, ints.length + ints.length / 2);
        }
    }
}
