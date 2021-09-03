package liuyuboo;

public class ArrayStack<E> implements Stack{
    E[] table;
    int size;
    @Override
    public void push(Object e) {
        table[size++] = (E)e;
    }

    @Override
    public Object pop() {
        E del = table[size - 1];
        table[size--] = null;
        return del;
    }

    @Override
    public Object peek() {

        return table[size];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
