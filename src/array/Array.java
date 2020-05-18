package array;

import java.util.Objects;

public class Array<E> {
    private E[] data; // the length of data is the capacity of the array
    private int size; // the actual length of array

    public Array(int capacity) {
        this.size = 0;
        data = (E[])new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        data[index] = e;
    }

    public void add(int pos, E e) {

        if (pos < 0 || pos > size) {
            //invalid index
            throw new IllegalArgumentException("Invalid index!");
        }

        if (size == data.length) {
            //array is full
            resize(2 * data.length);
        }
            //add new element and increase size
        for (int i = size - 1; i >= pos; i--) {
            data[i + 1] = data[i];
        }
        data[pos] = e;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        E ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering object. Not necessary

        if ((size == data.length / 4) && (data.length / 2 != 0)) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirtst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            } else {
                res.append("]");
            }
        }

        return res.toString();
    }
}
