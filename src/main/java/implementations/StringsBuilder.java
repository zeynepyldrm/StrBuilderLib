package implementations;

import abstractions.IStringBuilder;

public class StringsBuilder implements IStringBuilder {
    private char[] buffer;
    private int size;

    public StringsBuilder(int capacity) {
        buffer = new char[capacity];
        size = 0;
    }

    public StringsBuilder() {
        this(16);
    }

    private void expandBuffer(int newSize) {
        char[] newBuffer = new char[Math.max(buffer.length * 2, newSize)];
        System.arraycopy(buffer, 0, newBuffer, 0, size);
        buffer = newBuffer;
    }

    @Override
    public void append(String str) {
        int length = str.length();
        if (size + length > buffer.length) {
            expandBuffer(size + length);
        }
        str.getChars(0, length, buffer, size);
        size += length;
    }

    @Override
    public void insert(int index, String str) {
        if (index < 0 || index > size) {
            throw new StringIndexOutOfBoundsException();
        }
        int len = str.length();
        if (size + len > buffer.length) {
            expandBuffer(size + len);
        }
        System.arraycopy(buffer, index, buffer, index + len, size - index);
        str.getChars(0, len, buffer, index);
        size += len;
    }

    @Override
    public void delete(int start, int finish) {
        if (start < 0 || start >= size || finish < start || finish > size) {
            throw new StringIndexOutOfBoundsException();
        }
        int len = finish - start;
        System.arraycopy(buffer, finish, buffer, start, size - finish);
        size -= len;
    }

    @Override
    public void reverse() {
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            char temp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = temp;
        }
    }

    @Override
    public String toString() {
        return new String(buffer, 0, size);
    }

    @Override
    public char[] toCharArray() {
        return buffer;
    }
}
