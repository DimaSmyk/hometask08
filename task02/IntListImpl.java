package selfwork08.task02;

import java.util.Arrays;

public class IntListImpl implements IntListNew {

    public static void main(String[] args) {

        IntListNew test = new IntListImpl();
        test.add(3);//0
        test.add(5);//1
        test.add(2);//2
        test.add(9);//3
        test.add(12);//4
        test.add(28);//5
        test.add(21);//6
        test.add(25);//7
    }

    private int[] array = new int[DEFAULT_CAPACITY];
    private int size;
    private int index;
    private static final int DEFAULT_CAPACITY = 16;

    @Override
    public void add(int i) {
        if (index == array.length)
            increaseArray();
        array[index] = i;
        index++;
        size++;
    }

    private void increaseArray() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, size - 1);
        array = arrayNew;
    }

    @Override
    public void insert(int index, int value) {
        int[] arrayNew1 = new int[array.length ];
        System.arraycopy(array, index - 1,
                arrayNew1, index, this.index - index);
        array[index] = value;
        System.arraycopy(arrayNew1, index + 1,
                arrayNew1, index, this.index - index);

    }

    @Override
    public void set(int index, int value) {
        array[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    public int getByIndex(int index) {
        return array[index];
    }

    @Override
    public Integer getIndexByValue(int value) {
        int result = -1;
        for (int i = 0; i < index; i++) {
            if (array[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < index; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeValue(int value) {
        for (int i = 0; i < index; i++) {
            if (array[i] == value) {
                System.arraycopy(array,  i + 1,
                        array, i, this.index - i);
                size--;
                this.index--;
            }
        }
    }

    @Override
    public void removeByIndex(int index) {
        System.arraycopy(array, index + 1, array, index, this.index - index);
        size--;
        this.index--;
    }

    @Override
    public IntListNew subList(int fromIndex, int toIndex) {

        IntListNew sub = new IntListImpl();
        for (int i = 0; i < size; i++) {
            if(i >= fromIndex && i <= toIndex){
                sub.add(i);
            }
        }
        return sub;
    }

    @Override
    public int[] toArray() {
        int[] arrayNew = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array,0,arrayNew,0,size);
            Arrays.toString(arrayNew);
        } return arrayNew;
    }
}



