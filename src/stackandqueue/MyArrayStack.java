package stackandqueue;

public class MyArrayStack implements IStackAndQueue{
    private final int[] array;
    private final int size;
    private int topIndex;


    public MyArrayStack(int size) {
        this.size = size;
        array = new int[size];
        topIndex = -1;
    }
    @Override
    public boolean push(int value) {
        if (!isFull()) {
            topIndex++;
            array[topIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            int value = array[topIndex];
            topIndex--;
            System.out.println();
            return value;
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return topIndex == size - 1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (var i = 0; i <= topIndex; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
