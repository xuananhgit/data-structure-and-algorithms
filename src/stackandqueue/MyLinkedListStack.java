package stackandqueue;

import java.util.Objects;

public class MyLinkedListStack implements IStackAndQueue{

    private Node topNode;

    private static class Node {
        private final int value;
        private Node next;
        private Node(int value) {
            this.value = value;
        }
    }

    @Override
    public boolean push(int value) {
        var newNode = new Node(value);
        if (!isFull()) {
            newNode.next = topNode;
            topNode = newNode;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return - 1;
        }
        int value = topNode.value;
        topNode = topNode.next;
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(topNode);
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        Node temp = topNode;
        while (Objects.nonNull(temp)) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
