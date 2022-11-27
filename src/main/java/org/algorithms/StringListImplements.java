package org.algorithms;

import org.algorithms.exceptions.FullSizeException;
import org.algorithms.exceptions.IndexValidException;
import org.algorithms.exceptions.NullValueException;

import java.util.Arrays;

public class StringListImplements implements StringList {

    private final String[] strings;
    private int size;

    public StringListImplements() {
        strings = new String[5];
    }

    public StringListImplements(int index) {
        strings = new String[index];
    }

    @Override
    public String add(String item) {
        validValue(item);
        validSize();
        strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validValue(item);
        validSize();
        validIndex(index);
        if (index == size) {
            strings[size++] = item;
            return item;
        }
        System.arraycopy(strings, index, strings, index + 1, size - index);
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validIndex(index);
        validValue(item);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validValue(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validIndex(index);
        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return strings[index];
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String string = strings[i];
            if (string.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            String string = strings[i];
            if (string.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }

    private void validValue(String item) {
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
        if (this.size == strings.length) {
            throw new FullSizeException("Массив переполнен");
        }
    }
}
