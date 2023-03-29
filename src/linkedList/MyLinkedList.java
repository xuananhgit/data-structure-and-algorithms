package linkedList;

import java.util.Objects;

public class MyLinkedList {

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void printLinkedList(Node head) {
        if (Objects.isNull(head)) {
            System.out.println("List is empty!");
        } else {
            var temp = head;
            while (Objects.nonNull(temp)) {
                System.out.print(temp.value);
                temp = temp.next;
                if (Objects.nonNull(temp)) {
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }
    }


    public static Node addToHead(Node head, int value) {
        var newNode = new Node(value);
        if (Objects.nonNull(head)) {
            newNode.next = head;
        }
        return newNode;
    }

    public static Node addToTail(Node head, int value) {
        var newNode = new Node(value);
        if (Objects.isNull(head)) {
            return newNode;
        }
        var lastNode = head;
        while (Objects.nonNull(lastNode.next)) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        return head;
    }

    public static Node addToIndex(Node head, int value, int index) {
        if (index == 0) {
            return addToHead(head, value);
        }
        var newNode = new Node(value);
        var currentNode = head;
        var count = 0;
        while (Objects.nonNull(currentNode)) {
            count++;
            if (count == index) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static Node removeAtHeadNode(Node head) {
        return Objects.nonNull(head) ? head.next : null;
    }

    public static Node removeAtTail(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        var temp = head;
        while (Objects.nonNull(temp.next.next)) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node removeAtIndex(Node head, int index) {
        if (Objects.isNull(head) || index < 0) return null;
        if (index == 0) return removeAtHeadNode(head);

        var curtNode = head;
        Node prevNode = null;
        var count = 0;
        while (Objects.nonNull(curtNode.next)) {
            if (count == index) {
                break;
            }
            prevNode = curtNode;
            curtNode = curtNode.next;
            count++;
        }
        if (index == count) {
            prevNode.next = curtNode.next;
        }
        return head;
    }

    public static Node reverseList(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        var curNode = head;
        while (Objects.nonNull(curNode.next)) {
            var nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }
        return head;
    }

    public static Node reverseListA(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) return head;
        var nextNode = head.next;

        var newHead = reverseListA(nextNode);

        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        var n1 = new Node(1);
        var n2 = new Node(2);
        var n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        printLinkedList(n1);
        n1 = reverseListA(n1);
        printLinkedList(n1);
    }
}
