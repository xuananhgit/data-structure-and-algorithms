package stackandqueue;

import java.util.Objects;

public class MyLinkedListQueue implements IStackAndQueue{

    private static class Node {
        private final int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node headNode;
    private Node tailNode;

    @Override
    public boolean push(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            headNode = tailNode = newNode;
        } else {
            tailNode.next = newNode;
            tailNode = newNode;
        }
        return true;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("list is empty!");
            return -1;
        }
        var value = headNode.value;
        if (headNode == tailNode) {
            headNode = tailNode = null;
        } else {
            headNode = headNode.next;
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(headNode) && Objects.isNull(tailNode);
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("list is empty!");
            return;
        }
        var temp = headNode;
        while (Objects.nonNull(temp)) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
